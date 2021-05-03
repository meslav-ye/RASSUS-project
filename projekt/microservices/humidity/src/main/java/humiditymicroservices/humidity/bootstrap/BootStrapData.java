package humiditymicroservices.humidity.bootstrap;

import com.opencsv.bean.CsvToBeanBuilder;
import humiditymicroservices.humidity.domain.HumidityValue;
import humiditymicroservices.humidity.repositories.HumidityRepository;
import humiditymicroservices.humidity.services.SensorReading;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private final HumidityRepository humidityRepository;
    private static final String FILE_PATH = "mjerenja.csv";
    public BootStrapData(HumidityRepository humidityRepository){
        this.humidityRepository = humidityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<SensorReading> sensorReadings = new CsvToBeanBuilder<SensorReading>(new InputStreamReader(BootStrapData.class.getResourceAsStream("/mjerenja.csv"))).withType(SensorReading.class).build().parse();
        Long measure;
        for(SensorReading reading : sensorReadings){
            HumidityValue v= new HumidityValue();
            if(reading.getHumidity().isEmpty()){
                measure=0l;
            }
            else{
                measure=Integer.valueOf(reading.getHumidity()).longValue();
            }
            v.setValue(measure);
            humidityRepository.save(v);
        }
    }

}
