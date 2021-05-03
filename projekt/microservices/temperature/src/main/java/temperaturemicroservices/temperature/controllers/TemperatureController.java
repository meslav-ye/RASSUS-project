package temperaturemicroservices.temperature.controllers;

import org.springframework.web.bind.annotation.*;
import temperaturemicroservices.temperature.domain.TemperatureDto;
import temperaturemicroservices.temperature.domain.TemperatureValue;
import temperaturemicroservices.temperature.services.TemperatureService;


@RestController
@RequestMapping(TemperatureController.BASE_URL)
public class TemperatureController {
    public static final String BASE_URL = "/temperature";
    private final TemperatureService temperatureService;
    
    public TemperatureController(TemperatureService temperatureService){ this.temperatureService = temperatureService;}
    
    @GetMapping("/current-reading")
    public TemperatureDto getTemperatureByID(){
        return temperatureService.currentReading();
    }
    
}
