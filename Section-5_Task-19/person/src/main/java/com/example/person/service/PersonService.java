package com.example.person.service;

import com.example.person.model.Person;
import com.example.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Optional<Person> getPerson(int id) {
        return repository.findById(id);
    }
    public Iterable<Person> showAll() {
        return repository.findAll();
    }
    @Transactional
    public Person save(Person person) {
        return repository.save(person);
    }
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
