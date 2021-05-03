package temperaturemicroservices.temperature.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import temperaturemicroservices.temperature.config.Configuration;
import temperaturemicroservices.temperature.domain.TemperatureDto;
import temperaturemicroservices.temperature.domain.TemperatureValue;
import temperaturemicroservices.temperature.repositories.TemperatureRepository;

import java.util.Date;

@Service
public class TemperatureServiceImpl implements TemperatureService{
    //private static final Double KELVIN = 273.15;
    private final TemperatureRepository temperatureRepository;

    Configuration configuration;

    public TemperatureServiceImpl(TemperatureRepository temperatureRepository, Configuration configuration) {
        this.temperatureRepository = temperatureRepository;
        this.configuration = configuration;
    }

    @Override
    public TemperatureDto currentReading() {
        TemperatureDto temperatureDto = new TemperatureDto();
        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        Long ID = Integer.valueOf(hours).longValue()*4+Integer.valueOf(minutes).longValue()/15;
        //ID = Integer.valueOf(date.getSeconds()%60).longValue();
        Long value = temperatureRepository.findById(ID).get().getValue();

        /*if (configuration.getMeasurementRate().equals("K")){
            value = value + KELVIN.longValue();

        }*/

        temperatureDto.setMeasurementRate(configuration.getMeasurementRate());
        temperatureDto.setValue(value);
        return temperatureDto;
    }

    @Override
    public TemperatureValue saveValue(TemperatureValue value) {
        return temperatureRepository.save(value);
    }
}
