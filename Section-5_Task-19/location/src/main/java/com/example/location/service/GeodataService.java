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

    public Optional<Geodata> getGeodata(String location) {
        return repository.findByName(location);
    }
    public Iterable<Geodata> showAll() {
        return repository.findAll();
    }
    @Transactional
    public Geodata saveGeodata(Geodata geodata) {
        return repository.save(geodata);
    }
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
