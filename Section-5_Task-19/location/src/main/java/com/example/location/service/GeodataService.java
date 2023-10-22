package com.example.location.service;

import com.example.location.model.Geodata;
import com.example.location.repositories.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GeodataService {
    private final GeodataRepository repository;

    @Autowired
    public GeodataService(GeodataRepository repository) {
        this.repository = repository;
    }


    public Iterable<Geodata> getGeodataList() {
        return repository.findAll();
    }
    public Geodata getGeodata(String location) {
        return repository.findByName(location).get();
    }

    @Transactional
    public Geodata saveGeodata(Geodata geodata) {
        return repository.save(geodata);
    }
}
