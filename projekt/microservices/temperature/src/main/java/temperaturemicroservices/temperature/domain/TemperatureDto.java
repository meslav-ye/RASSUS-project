package temperaturemicroservices.temperature.domain;

import lombok.Data;

@Data
public class TemperatureDto {
    private Long value;
    private String measurementRate;
}
