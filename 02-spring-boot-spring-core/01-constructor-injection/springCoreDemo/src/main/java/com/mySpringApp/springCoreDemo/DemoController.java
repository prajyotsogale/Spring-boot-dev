package com.mySpringApp.springCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    //constructor injection
    @Autowired
    public DemoController(Coach coach){
        this.myCoach = coach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
