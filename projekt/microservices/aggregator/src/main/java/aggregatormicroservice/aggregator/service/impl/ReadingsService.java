package aggregatormicroservice.aggregator.service.impl;

import aggregatormicroservice.aggregator.dto.ReadingsDto;
import aggregatormicroservice.aggregator.service.HumidityService;
import aggregatormicroservice.aggregator.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingsService {

    @Autowired
    private HumidityService humidityService;

    @Autowired
    private TemperatureService temperatureService;

    public ReadingsDto getReadings(){

        ReadingsDto readingsDto = new ReadingsDto();
        readingsDto.setHumidity(humidityService.getHumidity());
        readingsDto.setTemperature(temperatureService.getTemperature().getValue());
        return readingsDto;
    }
}
