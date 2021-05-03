package aggregatormicroservice.aggregator.service.impl;

import aggregatormicroservice.aggregator.config.MeasuringUnitConfig;
import aggregatormicroservice.aggregator.dto.TemperatureDto;
import aggregatormicroservice.aggregator.service.TemperatureService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TemperatureServiceImpl implements TemperatureService {
    private String baseURL;
    private RestTemplate restTemplate;
    MeasuringUnitConfig measuringUnitConfig;
    private static final Double KELVIN = 273.15;

    public TemperatureServiceImpl(String url, MeasuringUnitConfig measuringUnitConfig){
        this.baseURL = url;
        this.measuringUnitConfig = measuringUnitConfig;
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public TemperatureDto getTemperature() {
        TemperatureDto temperature = restTemplate.getForObject(baseURL+"/temperature/current-reading", TemperatureDto.class);

        if(measuringUnitConfig.getUnit().equals("K")){
            Long value = temperature.getValue()+ KELVIN.longValue();
            temperature.setValue(value);
        }
        return temperature;
    }
}
