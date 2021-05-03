package humiditymicroservices.humidity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HumidityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumidityApplication.class, args);
	}

}
