package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Flight;

import java.util.Set;

public interface FlightService
{
	Flight findFlightById(Long id);

	Set<Flight> findAllFlights();
}
