package pl.patrykbober.spaceflights.dto;

import lombok.Data;
import pl.patrykbober.spaceflights.domain.Flight;

import java.time.LocalDateTime;

@Data
public class FlightDto
{
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer numberOfSeats;
	private Integer ticketPrice;

	public Flight convertToEntity()
	{
		Flight entity = new Flight();
		entity.setDepartureTime(departureTime);
		entity.setArrivalTime(arrivalTime);
		entity.setNumberOfSeats(numberOfSeats);
		entity.setTicketPrice(ticketPrice);

		return entity;
	}
}
