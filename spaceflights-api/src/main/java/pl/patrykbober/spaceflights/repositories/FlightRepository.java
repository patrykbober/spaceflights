package pl.patrykbober.spaceflights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykbober.spaceflights.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>
{
}
