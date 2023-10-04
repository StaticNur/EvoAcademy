package com.example.section4_task15.controllers;

import com.example.section4_task15.entity.Message;
import com.example.section4_task15.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("messages/{id}")
    public Optional<Message> findMessageById(@PathVariable("id") int id) {
        return messageRepository.findById(id);
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return message;
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
        Message m = messageRepository.findById(id).orElse(null);
        if (m != null) {
            message.setId(m.getId());
            messageRepository.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(addMessage(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable("id") int id) {
        messageRepository.deleteById(id);
    }
}
