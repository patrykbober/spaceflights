package pl.patrykbober.spaceflights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykbober.spaceflights.domain.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long>
{

}
