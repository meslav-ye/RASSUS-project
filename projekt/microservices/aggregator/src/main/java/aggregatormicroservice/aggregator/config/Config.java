package aggregatormicroservice.aggregator.config;

import aggregatormicroservice.aggregator.proxy.HumidityServiceProxy;
import aggregatormicroservice.aggregator.proxy.TemperatureServiceProxy;
import aggregatormicroservice.aggregator.service.HumidityService;
import aggregatormicroservice.aggregator.service.TemperatureService;
import aggregatormicroservice.aggregator.service.impl.HumidityServiceImpl;
import aggregatormicroservice.aggregator.service.impl.HumidityServiceImplV2;
import aggregatormicroservice.aggregator.service.impl.TemperatureServiceImpl;
import aggregatormicroservice.aggregator.service.impl.TemperatureServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private static final String Humidity_URL = "http://localhost:8081";
    private static final String Temperature_URL = "http://localhost:8082";

    @Bean
    public HumidityService humidityService(HumidityServiceProxy humidityServiceProxy){
        HumidityService humidityService = new HumidityServiceImplV2(humidityServiceProxy);
        return humidityService;
    }

    @Bean
    public TemperatureService temperatureService(TemperatureServiceProxy temperatureServiceProxy, MeasuringUnitConfig measuringUnitConfig){
        TemperatureService temperatureService = new TemperatureServiceImplV2(temperatureServiceProxy, measuringUnitConfig);
        return temperatureService;
    }

}
