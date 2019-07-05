package pl.patrykbober.spaceflights.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.patrykbober.spaceflights.dto.FlightDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "tourists")
@Entity
public class Flight
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer numberOfSeats;
	private Integer ticketPrice;
	@ManyToMany(mappedBy = "flights", cascade = CascadeType.ALL)
	private Set<Tourist> tourists = new HashSet<>();

	public FlightDto convertToDto()
	{
		FlightDto dto = new FlightDto();
		dto.setDepartureTime(departureTime);
		dto.setArrivalTime(arrivalTime);
		dto.setNumberOfSeats(numberOfSeats);
		dto.setTicketPrice(ticketPrice);

		return dto;
	}
}
