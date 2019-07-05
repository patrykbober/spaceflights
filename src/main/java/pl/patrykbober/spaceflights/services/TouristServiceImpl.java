package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Tourist;
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
	public Tourist findTouristById(Long id)
	{
		return touristRepository.findById(id).get();
	}

	@Override
	public Set<Tourist> findAllTourists()
	{
		return new HashSet<>(touristRepository.findAll());
	}
}
