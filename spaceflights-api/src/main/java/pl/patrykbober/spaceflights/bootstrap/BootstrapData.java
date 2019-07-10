package pl.patrykbober.spaceflights.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.patrykbober.spaceflights.domain.Flight;
import pl.patrykbober.spaceflights.domain.Tourist;
import pl.patrykbober.spaceflights.repositories.FlightRepository;
import pl.patrykbober.spaceflights.repositories.TouristRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner
{
	private final TouristRepository touristRepository;
	private final FlightRepository flightRepository;

	public BootstrapData(TouristRepository touristRepository, FlightRepository flightRepository)
	{
		this.touristRepository = touristRepository;
		this.flightRepository = flightRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Loading sample data");

		Flight f1 = new Flight();
		f1.setDepartureTime(LocalDateTime.now());
		f1.setArrivalTime(LocalDateTime.now().plusHours(2));
		f1.setNumberOfSeats(300);
		f1.setTicketPrice(50);

		Flight f2 = new Flight();
		f2.setDepartureTime(LocalDateTime.of(2019, 7, 3, 12, 35));
		f2.setArrivalTime(LocalDateTime.of(2019, 7, 3, 15, 50));
		f2.setNumberOfSeats(1);
		f2.setTicketPrice(200);

		Tourist t1 = new Tourist();
		t1.setFirstName("John");
		t1.setLastName("Smith");
		t1.setGender(Tourist.Gender.MALE);
		t1.setCountry("USA");
		t1.setRemarks("");
		t1.setDateOfBirth(LocalDate.of(1970, 1, 1));

		t1.addFlight(f1);
		t1.addFlight(f2);

		Tourist t2 = new Tourist();
		t2.setFirstName("Caroline");
		t2.setLastName("Bundy");
		t2.setGender(Tourist.Gender.FEMALE);
		t2.setCountry("England");
		t2.setRemarks("business class only");
		t2.setDateOfBirth(LocalDate.of(1988, 4, 23));

		t2.addFlight(f1);

		touristRepository.save(t1);
		touristRepository.save(t2);

		flightRepository.save(f1);
		flightRepository.save(f2);

		System.out.println("Loaded sample data: " + touristRepository.count() +
				" tourists and " + flightRepository.count() + " flights.");
	}
}
