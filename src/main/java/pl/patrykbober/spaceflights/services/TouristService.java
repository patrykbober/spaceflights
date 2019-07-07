package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.TouristDto;

import java.util.Set;

public interface TouristService
{
	Tourist findTouristById(Long id);

	Set<Tourist> findAllTourists();

	Set<Flight> findFlightsByTouristId(Long id);

	Tourist createTourist(TouristDto tourist);

	Tourist updateTourist(Tourist tourist);

	void deleteTouristById(Long id);
}
