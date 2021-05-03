package temperaturemicroservices.temperature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import temperaturemicroservices.temperature.domain.TemperatureValue;

public interface TemperatureRepository extends JpaRepository<TemperatureValue, Long> {
}
