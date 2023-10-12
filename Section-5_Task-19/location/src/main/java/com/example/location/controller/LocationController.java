package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private LocationRepository repository;
    @Autowired
    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Location> findAll() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable("id") int id) {
        return repository.findById(id);
    }
    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return repository.findById(location.getId()).isPresent()
                ? new ResponseEntity(repository.findById(location.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(location), HttpStatus.CREATED);
    }
}
