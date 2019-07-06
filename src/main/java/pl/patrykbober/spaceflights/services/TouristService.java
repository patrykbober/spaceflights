package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.TouristDto;

import java.util.Set;

public interface TouristService
{
	Tourist findTouristById(Long id);

	Set<Tourist> findAllTourists();

	Tourist saveTourist(TouristDto tourist);

	void deleteTouristById(Long id);

	Set<Flight> findFlightsByTouristId(Long id);
}
