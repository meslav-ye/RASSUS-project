package temperaturemicroservices.temperature.bootstrap;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import temperaturemicroservices.temperature.domain.TemperatureValue;
import temperaturemicroservices.temperature.repositories.TemperatureRepository;
import temperaturemicroservices.temperature.services.SensorReading;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private final TemperatureRepository temperatureRepository;
    private static final String FILE_PATH = "mjerenja.csv";
    public BootStrapData(TemperatureRepository temperatureRepository){
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<SensorReading> sensorReadings = new CsvToBeanBuilder<SensorReading>(new InputStreamReader(BootStrapData.class.getResourceAsStream("/mjerenja.csv"))).withType(SensorReading.class).build().parse();
        System.out.println(sensorReadings);
        Long measure;
        for(SensorReading reading : sensorReadings){
            TemperatureValue v= new TemperatureValue();
            if(reading.getTemperature().isEmpty()){
                measure=0l;
            }
            else{
                measure=Integer.valueOf(reading.getTemperature()).longValue();
            }
            v.setValue(measure);
            temperatureRepository.save(v);
        }
    }

}
