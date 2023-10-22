package com.example.weather.controller;

import com.example.weather.model.Main;
import com.example.weather.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class WeatherController {
    private final RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;
    @Value("${url.weather}")
    private String urlWeather;

    @Autowired
    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    //@Cacheable(value = "data")
    public Main getWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {
        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s", urlWeather, lat, lon, appId);
        return Objects.requireNonNull(restTemplate.getForObject(request, Root.class)).getMain();
    }
}
