package pl.patrykbober.spaceflights.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.TouristDto;
import pl.patrykbober.spaceflights.services.TouristService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(TouristController.BASE_URL)
public class TouristController
{
	public static final String BASE_URL = "/api/tourists";

	private final TouristService touristService;
	
	public TouristController(TouristService touristService)
	{
		this.touristService = touristService;
	}

	@GetMapping
	Set<TouristDto> getAllTourists()
	{
		return touristService.findAllTourists()
				.stream()
				.map(Tourist::convertToDto)
				.collect(Collectors.toSet());
	}


}
