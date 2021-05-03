package aggregatormicroservice.aggregator.service.impl;

import aggregatormicroservice.aggregator.service.HumidityService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class HumidityServiceImpl implements HumidityService {
    private String baseURL;
    private RestTemplate restTemplate;

    public HumidityServiceImpl(String url){
        this.baseURL = url;

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public Long getHumidity() {
        Long humidity = restTemplate.getForObject(baseURL+"/humidity/current-reading", Long.class);
        return humidity;
    }
}
