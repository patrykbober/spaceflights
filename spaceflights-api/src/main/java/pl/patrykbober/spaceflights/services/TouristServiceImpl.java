package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.TouristDto;
import pl.patrykbober.spaceflights.exceptions.FlightAlreadyAssignedException;
import pl.patrykbober.spaceflights.exceptions.FlightNotAssignedException;
import pl.patrykbober.spaceflights.exceptions.TouristNotFoundException;
import pl.patrykbober.spaceflights.repositories.TouristRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class TouristServiceImpl implements TouristService
{
	private final TouristRepository touristRepository;

	public TouristServiceImpl(TouristRepository touristRepository)
	{
		this.touristRepository = touristRepository;
	}

	@Override
	public Set<Tourist> findAllTourists()
	{
		return new HashSet<>(touristRepository.findAll());
	}

	@Override
	public Tourist findTouristById(Long id)
	{
		if (!touristRepository.findById(id).isPresent())
		{
			throw new TouristNotFoundException("Could not find tourist with this id");
		}
		return touristRepository.findById(id).get();
	}

	@Override
	public Set<Flight> findFlightsByTouristId(Long id)
	{
		if (!touristRepository.findById(id).isPresent())
		{
			throw new TouristNotFoundException("Could not find tourist with this id");
		}
		else
		{
			Tourist tourist = touristRepository.findById(id).get();
			return tourist.getFlights();
		}
	}

	@Override
	public Tourist createTourist(TouristDto tourist)
	{
		return touristRepository.save(tourist.convertToEntity());
	}

	@Override
	public Tourist updateTourist(Tourist tourist)
	{
		return touristRepository.save(tourist);
	}

	@Override
	public Tourist addFlightToTourist(Long touristId, Flight flight)
	{
		Tourist tourist = this.findTouristById(touristId);

		if (tourist.getFlights().contains(flight))
		{
			throw new FlightAlreadyAssignedException("This flight is already assigned to that tourist.");
		}
		tourist.addFlight(flight);

		return this.updateTourist(tourist);
	}

	@Override
	public Tourist removeFlightFromTourist(Long touristId, Flight flight)
	{
		Tourist tourist = this.findTouristById(touristId);

		if (!tourist.getFlights().contains(flight))
		{
			throw new FlightNotAssignedException("This flight is not assigned to that tourist");
		}
		tourist.removeFlight(flight);

		return this.updateTourist(tourist);
	}

	@Override
	public void deleteTouristById(Long id)
	{
		try
		{
			touristRepository.deleteById(id);
		} catch (Exception e)
		{
			throw new TouristNotFoundException("Could not find tourist with this id");
		}
	}
}
