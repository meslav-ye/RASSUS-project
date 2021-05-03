package humiditymicroservices.humidity.controllers;

import humiditymicroservices.humidity.domain.HumidityValue;
import humiditymicroservices.humidity.services.HumidityService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(HumidityController.BASE_URL)
public class HumidityController {
    public static final String BASE_URL = "/humidity";
    private final HumidityService humidityService;
    
    public HumidityController(HumidityService humidityService){
        this.humidityService = humidityService;
    }
    @GetMapping("/current-reading")
    public Long getHumidityValueById(){
        return humidityService.currentReading();
    }

    
    
}
