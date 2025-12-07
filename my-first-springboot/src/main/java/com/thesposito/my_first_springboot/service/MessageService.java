package com.thesposito.my_first_springboot.service;

import org.springframework.stereotype.Service;
import com.thesposito.my_first_springboot.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public String getMessage() {
        return messageRepository.getMessage();
    }
}
