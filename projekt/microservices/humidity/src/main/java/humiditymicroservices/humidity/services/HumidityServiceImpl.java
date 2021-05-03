package humiditymicroservices.humidity.services;

import humiditymicroservices.humidity.domain.HumidityValue;
import humiditymicroservices.humidity.repositories.HumidityRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HumidityServiceImpl implements HumidityService{

    private final HumidityRepository humidityRepository;

    public HumidityServiceImpl(HumidityRepository humidityRepository){
        this.humidityRepository = humidityRepository;
    }
    @Override
    public Long currentReading() {
        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        Long ID = Integer.valueOf(hours).longValue()*4+Integer.valueOf(minutes).longValue()/15;
        //ID = Integer.valueOf(date.getSeconds()%60).longValue();
        System.out.println("*********"+ID);
        System.out.println(minutes);
        return humidityRepository.findById(ID).get().getValue();
    }

    @Override
    public HumidityValue saveValue(HumidityValue value) {
        return humidityRepository.save(value);
    }
}
