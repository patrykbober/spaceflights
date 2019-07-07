package pl.patrykbober.spaceflights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.patrykbober.spaceflights.dto.FlightDto;
import pl.patrykbober.spaceflights.dto.TouristDto;
import pl.patrykbober.spaceflights.services.FlightService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(FlightController.BASE_URL)
public class FlightController
{
	public static final String BASE_URL = "/api/flights";

	private final FlightService flightService;

	public FlightController(FlightService flightService)
	{
		this.flightService = flightService;
	}

	@GetMapping
	Set<FlightDto> getAllFlights()
	{
		return flightService.findAllFlights()
				.stream()
				.map(FlightDto::new)
				.collect(Collectors.toSet());
	}

	@GetMapping("/{id}")
	public FlightDto getFlightById(@PathVariable Long id)
	{
		return new FlightDto(flightService.findFlightById(id));
	}

	@GetMapping("/{id}/tourists")
	public Set<TouristDto> getTouristsByFlightId(@PathVariable Long id)
	{
		return flightService.findTouristsByFlightId(id)
				.stream()
				.map(TouristDto::new)
				.collect(Collectors.toSet());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FlightDto saveFlight(@RequestBody FlightDto flight)
	{
		return new FlightDto(flightService.saveFlight(flight));
	}

	@DeleteMapping("/{id}")
	public void deleteFlightById(@PathVariable Long id)
	{
		flightService.deleteFlightById(id);
	}
}
