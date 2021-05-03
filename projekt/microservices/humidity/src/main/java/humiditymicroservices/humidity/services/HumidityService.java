package humiditymicroservices.humidity.services;

import humiditymicroservices.humidity.domain.HumidityValue;

public interface HumidityService {
    Long currentReading();

    HumidityValue saveValue(HumidityValue value);
}
