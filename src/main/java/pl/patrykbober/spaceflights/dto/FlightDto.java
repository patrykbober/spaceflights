package pl.patrykbober.spaceflights.dto;

import lombok.Data;
import pl.patrykbober.spaceflights.domain.Flight;

import java.time.LocalDateTime;

@Data
public class FlightDto
{
	private Long id;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer numberOfSeats;
	private Integer ticketPrice;

	public FlightDto(Flight flight)
	{
		this.id = flight.getId();
		this.departureTime = flight.getDepartureTime();
		this.arrivalTime = flight.getArrivalTime();
		this.numberOfSeats = flight.getNumberOfSeats();
		this.ticketPrice = flight.getTicketPrice();
	}

	public Flight convertToEntity()
	{
		Flight entity = new Flight();
		entity.setId(id);
		entity.setDepartureTime(departureTime);
		entity.setArrivalTime(arrivalTime);
		entity.setNumberOfSeats(numberOfSeats);
		entity.setTicketPrice(ticketPrice);

		return entity;
	}
}
