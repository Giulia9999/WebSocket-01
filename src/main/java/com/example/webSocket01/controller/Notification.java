package com.example.webSocket01.controller;

import com.example.webSocket01.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public void sendNotification(@RequestBody MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/broadcast-message", messageDTO);
    }
}