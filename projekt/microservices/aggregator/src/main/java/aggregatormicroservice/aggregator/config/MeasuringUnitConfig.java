package aggregatormicroservice.aggregator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MeasuringUnitConfig {

    @Value("${measuring.unit}")
    private String unit;

    public String getUnit() {
        return unit;
    }
}
