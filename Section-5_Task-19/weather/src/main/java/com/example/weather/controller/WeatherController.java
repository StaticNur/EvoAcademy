package com.example.weather.controller;

import com.example.weather.service.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/weathers")
public class WeatherController {
    private final Request request;

    @Autowired
    public WeatherController(Request request) {
        this.request = request;
    }

    @GetMapping
    public ResponseEntity<String> showWeather() {
        try {
            String response = request.getWeather();
            if (response != null) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
