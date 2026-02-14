package com.thesposito.my_first_springboot.controller;

import com.thesposito.my_first_springboot.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/msg")
    public String getMessage(){
        return messageService.getMessage();
    }
}
