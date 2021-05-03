package aggregatormicroservice.aggregator.dto;

import lombok.Data;

@Data
public class ReadingsDto {
    private Long humidity;
    private Long temperature;
}
