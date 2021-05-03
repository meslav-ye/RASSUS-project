package aggregatormicroservice.aggregator.proxy;

import aggregatormicroservice.aggregator.dto.TemperatureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("${temperature-service.name}")
public interface TemperatureServiceProxy {

    @GetMapping("/temperature/current-reading")
    public TemperatureDto currentReading();
}
