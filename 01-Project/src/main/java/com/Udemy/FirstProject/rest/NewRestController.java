package com.Udemy.FirstProject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRestController {

    @GetMapping("/")
    public String greeting() {
        return "Hello Guys";
    }

    @GetMapping("/about")
    public String aboutMe() {
        return "My name is Anoshor";
    }

    @GetMapping("/daily")
    public String dailyGoal() {
        return "Learn Spring Boot Everyday !!";
    }
}
