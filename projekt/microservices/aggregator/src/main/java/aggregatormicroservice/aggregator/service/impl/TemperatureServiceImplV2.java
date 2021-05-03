package aggregatormicroservice.aggregator.service.impl;

import aggregatormicroservice.aggregator.config.MeasuringUnitConfig;
import aggregatormicroservice.aggregator.dto.TemperatureDto;
import aggregatormicroservice.aggregator.proxy.TemperatureServiceProxy;
import aggregatormicroservice.aggregator.service.TemperatureService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TemperatureServiceImplV2 implements TemperatureService {
    public TemperatureServiceProxy temperatureServiceProxy;
    MeasuringUnitConfig measuringUnitConfig;
    private static final Double KELVIN = 273.15;

    public TemperatureServiceImplV2(TemperatureServiceProxy temperatureServiceProxy, MeasuringUnitConfig measuringUnitConfig) {
        this.temperatureServiceProxy = temperatureServiceProxy;
        this.measuringUnitConfig = measuringUnitConfig;
    }

    @Override
    public TemperatureDto getTemperature() {
        TemperatureDto temperature = temperatureServiceProxy.currentReading();

        if(measuringUnitConfig.getUnit().equals("K")){
            Long value = temperature.getValue()+ KELVIN.longValue();
            temperature.setValue(value);
        }
        return temperature;
    }
}
