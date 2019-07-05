package pl.patrykbober.spaceflights.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.dto.FlightDto;
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
				.map(Flight::convertToDto)
				.collect(Collectors.toSet());
	}
}
