package temperaturemicroservices.temperature.services;

import temperaturemicroservices.temperature.domain.TemperatureDto;
import temperaturemicroservices.temperature.domain.TemperatureValue;

public interface TemperatureService {
    TemperatureDto currentReading();
    TemperatureValue saveValue(TemperatureValue value);
}
