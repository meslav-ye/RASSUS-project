package temperaturemicroservices.temperature.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.yml")
public class Configuration {

    @Value("${temperature.measurement.rate}")
    private String measurementRate;

    public String getMeasurementRate() {
        return measurementRate;
    }
}
