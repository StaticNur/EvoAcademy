package com.example.section4_task16.controllers;

import com.example.section4_task16.entity.Message;
import com.example.section4_task16.entity.Person;
import com.example.section4_task16.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PeopleController {
    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personService.viewAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> findPersonById(@PathVariable("id") int id) {
        return personService.viewPerson(id);
    }

    @GetMapping("/persons/{id}/messages")
    public Iterable<Message> getPersonsMessages(@PathVariable("id") int id) {
        return personService.viewPersonAllMessages(id);
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PostMapping("/persons/{id}/messages")
    public ResponseEntity<Person> addMessage(@PathVariable int id, @RequestBody Message message) {
        Boolean saved = personService.saveMessage(id, message);
        if (saved) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        Boolean edited = personService.editPerson(id, person);
        if (edited) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }

    @DeleteMapping("/persons/{p_id}/messages/{m_id}")
    public ResponseEntity<Person> deletePersonMessage(@PathVariable("p_id") int p_id, @PathVariable("m_id") int m_id) {
        Boolean deleted = personService.deletePersonMessage(p_id, m_id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
