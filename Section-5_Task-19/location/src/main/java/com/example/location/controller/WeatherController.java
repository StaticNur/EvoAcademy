package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.service.GeodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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
        Geodata geodata = geodataService.getGeodata(location).orElse(null);
        if (geodata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String url = String.format("http://localhost:8082/?lat=%s&lon=%s", geodata.getLat(), geodata.getLon());
        Weather weather = restTemplate.getForObject(url, Weather.class);
        return ResponseEntity.ok(weather);
    }

    @GetMapping
    public Optional<Geodata> getWeather(@RequestParam("location") String location) {
        return geodataService.getGeodata(location);
    }

    @GetMapping("/all")
    public Iterable<Geodata> findAll() {
        return geodataService.showAll();
    }

    @PostMapping
    public Geodata save(@RequestBody Geodata geodata) {
        return geodataService.saveGeodata(geodata);
    }

    @DeleteMapping("/location")
    public void delete(@RequestParam("id") int id) {
        geodataService.delete(id);
    }

}