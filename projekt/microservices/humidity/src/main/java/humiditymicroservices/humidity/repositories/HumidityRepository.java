package humiditymicroservices.humidity.repositories;

import humiditymicroservices.humidity.domain.HumidityValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<HumidityValue, Long> {
}
