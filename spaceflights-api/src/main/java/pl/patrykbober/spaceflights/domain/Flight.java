package pl.patrykbober.spaceflights.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

	@Override
	public String toString() {
		return "Flight{" +
				"id=" + id +
				", departureTime=" + departureTime +
				", arrivalTime=" + arrivalTime +
				", numberOfSeats=" + numberOfSeats +
				", ticketPrice=" + ticketPrice +
				'}';
	}
}
