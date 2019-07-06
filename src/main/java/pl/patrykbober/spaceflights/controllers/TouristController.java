package pl.patrykbober.spaceflights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;
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
	public Set<TouristDto> getAllTourists()
	{
		return touristService.findAllTourists()
				.stream()
				.map(Tourist::convertToDto)
				.collect(Collectors.toSet());
	}

	@GetMapping("/{id}")
	public TouristDto getTouristById(@PathVariable Long id)
	{
		return touristService.findTouristById(id).convertToDto();
	}

	@GetMapping("/{id}/flights")
	public Set<FlightDto> getFlightsByTouristId(@PathVariable Long id)
	{
		return touristService.findFlightsByTouristId(id)
				.stream()
				.map(Flight::convertToDto)
				.collect(Collectors.toSet());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TouristDto saveTourist(@RequestBody TouristDto tourist)
	{
		return touristService.saveTourist(tourist).convertToDto();
	}

	@DeleteMapping("/{id}")
	public void deleteTourist(@PathVariable Long id)
	{
		touristService.deleteTouristById(id);
	}

}
