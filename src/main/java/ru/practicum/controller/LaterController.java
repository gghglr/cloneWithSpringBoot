package ru.practicum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaterController {

    @GetMapping("/test")
    public String test(){
        return "OK from controller!";
    }
}
