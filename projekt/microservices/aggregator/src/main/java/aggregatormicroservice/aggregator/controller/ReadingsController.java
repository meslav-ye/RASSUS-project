package aggregatormicroservice.aggregator.controller;

import aggregatormicroservice.aggregator.dto.ReadingsDto;
import aggregatormicroservice.aggregator.config.MeasuringUnitConfig;
import aggregatormicroservice.aggregator.service.impl.ReadingsService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ReadingsController {
    private final ReadingsService readingsService;
    private final MeasuringUnitConfig measuringUnitConfig;

    public ReadingsController(ReadingsService readingsService, MeasuringUnitConfig measuringUnitConfig) {
        this.readingsService = readingsService;
        this.measuringUnitConfig = measuringUnitConfig;
    }
    
    @GetMapping(value="/readings")
    public ReadingsDto readings() {
        return readingsService.getReadings();
    }

    @GetMapping(value="/unit")
    public String getMeasuringUnit(){
        return measuringUnitConfig.getUnit();
    }
    
}
