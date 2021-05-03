package aggregatormicroservice.aggregator.dto;

import lombok.Data;

@Data
public class TemperatureDto {
    private Long value;
    private String measurementRate;

}
