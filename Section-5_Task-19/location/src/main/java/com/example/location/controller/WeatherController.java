package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.service.GeodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLEngineResult;

@RestController
public class WeatherController {
    private final GeodataService geodataService;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherController(GeodataService geodataService, RestTemplate restTemplate) {
        this.geodataService = geodataService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/weather")
    public ResponseEntity<Weather> redirectRequestWeather(@RequestParam("location") String location) {
        Geodata geodata = geodataService.getGeodata(location);
        if (geodata == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String url = String.format("http://localhost:8082/?lat=%s&lon=%s", geodata.getLat(), geodata.getLon());
        Weather response = restTemplate.getForObject(url, Weather.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public Geodata getLocation(@RequestParam("location") String location) {
        return geodataService.getGeodata(location);
    }

    @PostMapping
    public Geodata save(@RequestBody Geodata geodata) {
        return geodataService.saveGeodata(geodata);
    }

}
