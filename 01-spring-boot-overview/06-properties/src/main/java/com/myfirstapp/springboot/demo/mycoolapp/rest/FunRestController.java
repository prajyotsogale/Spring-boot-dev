package com.myfirstapp.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    //workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5 kilometers daily";
    }

    //fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }

    //using custom values from properties
    @Value("${coach.name}")
    public String coachName;

    @Value("${team.name}")
    public String teamName;

    //using new endpoint for properties
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+" , Team Name: "+teamName;
    }

}

