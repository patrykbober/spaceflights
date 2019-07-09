package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;
import pl.patrykbober.spaceflights.exceptions.FlightNotFoundException;
import pl.patrykbober.spaceflights.exceptions.NoSeatsAvailableException;
import pl.patrykbober.spaceflights.exceptions.TouristAlreadyAssignedException;
import pl.patrykbober.spaceflights.exceptions.TouristNotAssignedException;
import pl.patrykbober.spaceflights.repositories.FlightRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class FlightServiceImpl implements FlightService
{
	private final FlightRepository flightRepository;

	public FlightServiceImpl(FlightRepository flightRepository)
	{
		this.flightRepository = flightRepository;
	}

	@Override
	public Set<Flight> findAllFlights()
	{
		return new HashSet<>(flightRepository.findAll());
	}

	@Override
	public Flight findFlightById(Long id)
	{
		if (!flightRepository.findById(id).isPresent())
		{
			throw new FlightNotFoundException("Could not find flight with this id");
		}
		else
		{
			return flightRepository.findById(id).get();
		}
	}

	@Override
	public Set<Tourist> findTouristsByFlightId(Long id)
	{
		if (!flightRepository.findById(id).isPresent())
		{
			throw new FlightNotFoundException("Could not find flight with this id");
		}
		else
		{
			Flight flight = flightRepository.findById(id).get();
			return flight.getTourists();
		}
	}

	@Override
	public Flight createFlight(FlightDto flight)
	{
		return flightRepository.save(flight.convertToEntity());
	}

	@Override
	public Flight updateFlight(Flight flight)
	{
		return flightRepository.save(flight);
	}

	@Override
	public Flight addTouristToFlight(Long flightId, Tourist tourist)
	{
		Flight flight = this.findFlightById(flightId);

		if (flight.getTourists().contains(tourist))
		{
			throw new TouristAlreadyAssignedException("This tourist is already assigned to that flight.");
		}
		if (flight.getTourists().size() >= flight.getNumberOfSeats())
		{
			throw new NoSeatsAvailableException("There are no more available seats for this flight.");
		}
		tourist.addFlight(flight);

		return this.updateFlight(flight);
	}

	@Override
	public Flight removeTouristFromFlight(Long flightId, Tourist tourist)
	{
		Flight flight = this.findFlightById(flightId);

		if (!flight.getTourists().contains(tourist))
		{
			throw new TouristNotAssignedException("This tourist is not assigned to that flight");
		}
		tourist.removeFlight(flight);

		return this.updateFlight(flight);
	}

	@Override
	public void deleteFlightById(Long id)
	{
		try
		{
			flightRepository.deleteById(id);
		} catch (Exception e)
		{
			throw new FlightNotFoundException("Could not find flight with this id");
		}
	}
}
