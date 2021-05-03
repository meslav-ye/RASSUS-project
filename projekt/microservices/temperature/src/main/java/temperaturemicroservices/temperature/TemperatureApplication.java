package temperaturemicroservices.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TemperatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureApplication.class, args);
	}

}
