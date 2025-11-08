package com.mySpringApp.springCoreDemo.rest;

import com.mySpringApp.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach myCoach;

    //constructor injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach){

        System.out.println("In constructor: "+getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
