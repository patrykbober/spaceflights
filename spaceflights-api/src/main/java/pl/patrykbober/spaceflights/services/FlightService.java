package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;

import java.util.Set;

public interface FlightService
{
	Flight findFlightById(Long id);

	Set<Flight> findAllFlights();

	Set<Tourist> findTouristsByFlightId(Long id);

	Flight createFlight(FlightDto flight);

	Flight updateFlight(Flight flight);

	Flight addTouristToFlight(Long flightId, Tourist tourist);

	Flight removeTouristFromFlight(Long flightId, Tourist tourist);

	void deleteFlightById(Long id);
}
