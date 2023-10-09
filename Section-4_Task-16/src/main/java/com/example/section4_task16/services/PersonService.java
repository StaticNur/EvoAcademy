package com.example.section4_task16.services;

import com.example.section4_task16.entity.Message;
import com.example.section4_task16.entity.Person;
import com.example.section4_task16.repositories.MessageRepository;
import com.example.section4_task16.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public Iterable<Person> viewAll() {
        return personRepository.findAll();
    }

    public Optional<Person> viewPerson(int id) {
        return personRepository.findById(id);
    }

    public Iterable<Message> viewPersonAllMessages(int id) {
        return personRepository.findById(id).get().getMessages();
    }

    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Boolean saveMessage(int id, Message message) {
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return false;
        }
        message.setPerson(person);
        message.setTime(LocalDateTime.now());
        person.getMessages().add(message);
        personRepository.save(person);
        return true;
    }

    @Transactional
    public Boolean editPerson(int id, Person person) {
        Person p = personRepository.findById(id).orElse(null);
        if (p != null) {
            person.setId(p.getId());
            personRepository.save(person);
            return true;
        } else {
            savePerson(person);
            return false;
        }
    }

    @Transactional
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public Boolean deletePersonMessage(int p_id, int m_id) {
        Person person = personRepository.findById(p_id).orElse(null);
        Message message = messageRepository.findById(m_id).orElse(null);
        if (person == null || message == null) {
            return false;
        }
        if (person.getMessages().contains(message)) {
            person.getMessages().remove(message);
            messageRepository.deleteById(m_id);
            return true;
        }
        return false;
    }
}
