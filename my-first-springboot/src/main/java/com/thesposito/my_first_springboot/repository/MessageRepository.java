package com.thesposito.my_first_springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    public String getMessage(){
        return "Hello, Repository!";
    }
}
