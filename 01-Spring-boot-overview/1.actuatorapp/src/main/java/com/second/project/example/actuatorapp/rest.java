package com.second.project.example.actuatorapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {

    @GetMapping("/")
    public String sayHello(){
        return coachName;
    }
    @GetMapping("/team")
    public String teamName(){
        return teamName;
    }

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

}
