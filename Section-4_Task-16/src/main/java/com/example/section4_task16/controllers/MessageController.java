package com.example.section4_task16.controllers;

import com.example.section4_task16.entity.Message;
import com.example.section4_task16.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return messageService.viewAll();
    }

    @GetMapping("messages/{id}")
    public Optional<Message> findMessageById(@PathVariable("id") int id) {
        return messageService.viewMessage(id);
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
        Boolean edited = messageService.editMessage(id, message);
        if (edited) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable("id") int id) {
        messageService.deleteMessage(id);
    }
}
