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
@RequestMapping(FlightController.BASE_URL)
@CrossOrigin
public class FlightController
{
	public static final String BASE_URL = "/api/flights";

	private final FlightService flightService;

	private final TouristService touristService;

	public FlightController(FlightService flightService, TouristService touristService)
	{
		this.flightService = flightService;
		this.touristService = touristService;
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
		return new FlightDto(flightService.createFlight(flight));
	}

	@PostMapping("/{flightId}/tourists")
	public FlightDto addTouristToFlight(@PathVariable Long flightId, @RequestBody TouristDto touristId)
	{
		Tourist tourist = touristService.findTouristById(touristId.getId());
		Flight flight = flightService.findFlightById(flightId);

		tourist.addFlight(flight);

		return new FlightDto(flightService.updateFlight(flight));
	}

	@DeleteMapping("/{flightId}/tourists")
	public FlightDto removeTouristFromFlight(@PathVariable Long flightId, @RequestBody TouristDto touristId)
	{
		Tourist tourist = touristService.findTouristById(touristId.getId());
		Flight flight = flightService.findFlightById(flightId);

		tourist.removeFlight(flight);

		return new FlightDto(flightService.updateFlight(flight));
	}

	@DeleteMapping("/{id}")
	public void deleteFlightById(@PathVariable Long id)
	{
		flightService.deleteFlightById(id);
	}
}
