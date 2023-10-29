package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.model.Weather;
import com.example.person.repositories.PersonRepository;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
<<<<<<< HEAD

    private final PersonService personService;
    private final RestTemplate restTemplate;
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
        Weather weather = restTemplate.getForObject("http://localhost:8083/weather?location=" + location, Weather.class);
        return ResponseEntity.ok(weather);
=======
    private final RestTemplate restTemplate;
    private final PersonRepository repository;
    @Autowired
    public PersonController(RestTemplate restTemplate, PersonRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
>>>>>>> cbbde4622372a633bdf2b5579dbb715ef3af051b
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
