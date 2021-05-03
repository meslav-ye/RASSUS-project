package aggregatormicroservice.aggregator.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("${humidity-service.name}")
public interface HumidityServiceProxy {

    @GetMapping("/humidity/current-reading")
    public Long currentReading();
}
