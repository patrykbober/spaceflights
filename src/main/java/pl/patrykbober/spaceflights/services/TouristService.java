package pl.patrykbober.spaceflights.services;

import pl.patrykbober.spaceflights.domain.Tourist;

import java.util.Set;

public interface TouristService
{
	Tourist findTouristById(Long id);

	Set<Tourist> findAllTourists();
}
