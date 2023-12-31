package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.model.Weather;
import com.example.person.repositories.PersonRepository;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final RestTemplate restTemplate;
    @Value("${location.service.url}")
    private String url;
    @Autowired
    public PersonController(PersonService personService, RestTemplate restTemplate) {
        this.personService = personService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable("id") int id) {
        Person person = personService.getPerson(id).orElse(null);
        if (person == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        String location = person.getLocation();
        Weather weather = restTemplate.getForObject(url + location, Weather.class);
        return ResponseEntity.ok(weather);
    }

    @GetMapping
    public Iterable<Person> findAll() {
        return personService.showAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable("id") int id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return personService.getPerson(person.getId()).isPresent()
                ? new ResponseEntity(personService.getPerson(person.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(personService.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        personService.delete(id);
    }
}
