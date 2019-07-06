package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;
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
		if (flightRepository.findById(id).isPresent())
		{
			return flightRepository.findById(id).get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Set<Tourist> findTouristsByFlightId(Long id)
	{
		if (flightRepository.findById(id).isPresent())
		{
			Flight flight = flightRepository.findById(id).get();
			return flight.getTourists();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Flight saveFlight(FlightDto flight)
	{
		return flightRepository.save(flight.convertToEntity());
	}

	@Override
	public void deleteFlightById(Long id)
	{
		flightRepository.deleteById(id);
	}
}
