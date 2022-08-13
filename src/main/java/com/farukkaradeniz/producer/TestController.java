package com.farukkaradeniz.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private MessagePublisher messagePublisher;

    public TestController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @GetMapping
    public String send(@RequestParam String message){
        messagePublisher.sendMessage("test " + message);
        return "ok";
    }

}