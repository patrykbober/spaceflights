package pl.patrykbober.spaceflights.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "flights")
@Entity
public class Tourist
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Gender gender = Gender.UNKNOWN;
	private String country;
	private String remarks;
	private LocalDate dateOfBirth;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "travel",
			joinColumns = @JoinColumn(name = "tourist_id"),
			inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private Set<Flight> flights = new HashSet<>();

	public void addFlight(Flight flight)
	{
		flights.add(flight);
		flight.getTourists().add(this);
	}

	public void removeFlight(Flight flight)
	{
		flights.remove(flight);
		flight.getTourists().remove(this);
	}

	public static enum Gender
	{
		FEMALE,
		MALE,
		UNKNOWN
	}
}
