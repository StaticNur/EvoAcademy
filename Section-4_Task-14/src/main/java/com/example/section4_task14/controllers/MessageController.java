package com.example.section4_task14.controllers;

import com.example.section4_task14.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    private final List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Title-1", "text-1", LocalDate.of(1999, 2, 3).atStartOfDay()),
            new Message(2, "Title-2", "text-2", LocalDate.of(2002, 2, 2).atStartOfDay()),
            new Message(3, "Title-3", "text-3", LocalDate.of(2005, 4, 8).atStartOfDay()),
            new Message(4, "Title-4", "text-4", LocalDate.of(1978, 6, 5).atStartOfDay())
    ));

    @GetMapping("/messages")
    public Iterable<Message> getMessages() {
        return messages;
    }

    @GetMapping("messages/{id}")
    public Optional<Message> findMessageById(@PathVariable("id") int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst();
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = -1;
        for (Message m : messages) {
            if (m.getId() == id) {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addMessage(message), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable("id") int id) {
        messages.removeIf(m -> m.getId() == id);
    }
}
