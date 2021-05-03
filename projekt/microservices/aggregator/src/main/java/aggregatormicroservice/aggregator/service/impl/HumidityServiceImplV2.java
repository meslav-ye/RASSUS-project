package aggregatormicroservice.aggregator.service.impl;

import aggregatormicroservice.aggregator.proxy.HumidityServiceProxy;
import aggregatormicroservice.aggregator.service.HumidityService;

public class HumidityServiceImplV2 implements HumidityService {
    HumidityServiceProxy humidityServiceProxy;

    public HumidityServiceImplV2(HumidityServiceProxy humidityServiceProxy) {
        this.humidityServiceProxy = humidityServiceProxy;
    }

    @Override
    public Long getHumidity() {
        return humidityServiceProxy.currentReading();
    }
}
