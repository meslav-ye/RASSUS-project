package humiditymicroservices.humidity.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class HumidityValue {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long ID;
    private Long value;
}
