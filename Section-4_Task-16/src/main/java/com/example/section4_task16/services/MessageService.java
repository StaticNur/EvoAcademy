package com.example.section4_task16.services;

import com.example.section4_task16.entity.Message;
import com.example.section4_task16.entity.Person;
import com.example.section4_task16.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Iterable<Message> viewAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> viewMessage(int id) {
        return messageRepository.findById(id);
    }

    @Transactional
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Transactional
    public Boolean editMessage(int id, Message message) {
        Message m = messageRepository.findById(id).orElse(null);
        if (m != null) {
            message.setId(m.getId());
            messageRepository.save(message);
            return true;
        } else {
            saveMessage(message);
            return false;
        }
    }

    @Transactional
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }
}
