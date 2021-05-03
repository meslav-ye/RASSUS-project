package temperaturemicroservices.temperature.services;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String temperature;
    private String pressure;
    private String humidity;
    private String co;
    private String no2;
    private String so2;

    @Override
    public String toString(){
        return "Senzorska očitanja:\n Temperatura = " + temperature + ", pritisak = " + pressure + ", vlažnost = " + humidity +
                ", CO = " + co + ", NO2 = " + no2 + ", SO2 = "+ so2;
    }

}
