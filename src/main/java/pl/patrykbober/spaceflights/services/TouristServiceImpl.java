package pl.patrykbober.spaceflights.services;

import org.springframework.stereotype.Service;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.TouristDto;
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
		return touristRepository.findById(id).get();
	}

	@Override
	public Set<Flight> findFlightsByTouristId(Long id)
	{
		if (touristRepository.findById(id).isPresent())
		{
			Tourist tourist = touristRepository.findById(id).get();
			return tourist.getFlights();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Tourist saveTourist(TouristDto tourist)
	{
		return touristRepository.save(tourist.convertToEntity());
	}

	@Override
	public void deleteTouristById(Long id)
	{
		touristRepository.deleteById(id);
	}
}
