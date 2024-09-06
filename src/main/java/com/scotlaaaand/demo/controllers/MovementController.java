package com.scotlaaaand.demo.controllers;


import com.scotlaaaand.demo.Step.Step;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MovementController {

    @MessageMapping("/move")
    @SendTo("/topic/movements")
    public String move(Step step) throws InterruptedException {
        Thread.sleep(500);
        return step.toString();
    }

}
