package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Flight;
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
	public Flight findFlightById(Long id)
	{
		return flightRepository.findById(id).get();
	}

	@Override
	public Set<Flight> findAllFlights()
	{
		return new HashSet<>(flightRepository.findAll());
	}
}
