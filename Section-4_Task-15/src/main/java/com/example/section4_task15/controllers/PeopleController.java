package com.example.section4_task15.controllers;

import com.example.section4_task15.entity.Person;
import com.example.section4_task15.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> findPersonById(@PathVariable("id") int id) {
        return personRepository.findById(id);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        Person m = personRepository.findById(id).orElse(null);
        if (m != null) {
            person.setId(m.getId());
            personRepository.save(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(addPerson(person), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }
}
