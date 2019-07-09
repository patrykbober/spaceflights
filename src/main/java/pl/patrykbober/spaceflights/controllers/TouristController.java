package pl.patrykbober.spaceflights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.dto.FlightDto;
import pl.patrykbober.spaceflights.dto.TouristDto;
import pl.patrykbober.spaceflights.services.FlightService;
import pl.patrykbober.spaceflights.services.TouristService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(TouristController.BASE_URL)
@CrossOrigin
public class TouristController
{
	public static final String BASE_URL = "/api/tourists";

	private final TouristService touristService;

	private final FlightService flightService;

	public TouristController(TouristService touristService, FlightService flightService)
	{
		this.touristService = touristService;
		this.flightService = flightService;
	}

	@GetMapping
	public Set<TouristDto> getAllTourists()
	{
		return touristService.findAllTourists()
				.stream()
				.map(TouristDto::new)
				.collect(Collectors.toSet());
	}

	@GetMapping("/{id}")
	public TouristDto getTouristById(@PathVariable Long id)
	{
		return new TouristDto(touristService.findTouristById(id));
	}

	@GetMapping("/{id}/flights")
	public Set<FlightDto> getFlightsByTouristId(@PathVariable Long id)
	{
		return touristService.findFlightsByTouristId(id)
				.stream()
				.map(FlightDto::new)
				.collect(Collectors.toSet());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TouristDto saveTourist(@RequestBody TouristDto tourist)
	{
		return new TouristDto(touristService.createTourist(tourist));
	}

	@PostMapping("/{touristId}/flights")
	public TouristDto addFlightToTourist(@PathVariable Long touristId, @RequestBody FlightDto flightId)
	{
		Flight flight = flightService.findFlightById(flightId.getId());
		Tourist tourist = touristService.findTouristById(touristId);

		tourist.addFlight(flight);

		return new TouristDto(touristService.updateTourist(tourist));
	}

	@DeleteMapping("/{touristId}/flights")
	public TouristDto removeFlightFromTourist(@PathVariable Long touristId, @RequestBody FlightDto flightId)
	{
		Flight flight = flightService.findFlightById(flightId.getId());
		Tourist tourist = touristService.findTouristById(touristId);

		tourist.removeFlight(flight);

		return new TouristDto(touristService.updateTourist(tourist));
	}

	@DeleteMapping("/{id}")
	public void deleteTouristById(@PathVariable Long id)
	{
		touristService.deleteTouristById(id);
	}

}
