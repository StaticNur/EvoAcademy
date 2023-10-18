package com.example.location.repositories;

import com.example.location.model.Geodata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeodataRepository extends CrudRepository<Geodata, Integer> {
    List<Geodata> findByName(String name);
}
