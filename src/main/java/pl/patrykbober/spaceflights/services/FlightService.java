package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;

import java.util.Set;

public interface FlightService
{
	Flight findFlightById(Long id);

	Set<Flight> findAllFlights();

	Flight saveFlight(FlightDto flight);

	void deleteFlightById(Long id);

	Set<Tourist> findTouristsByFlightId(Long id);
}
