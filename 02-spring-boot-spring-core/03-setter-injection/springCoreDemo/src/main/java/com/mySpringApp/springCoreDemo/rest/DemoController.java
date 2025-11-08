package com.mySpringApp.springCoreDemo.rest;

import com.mySpringApp.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //field injection
    /*@Autowired
    private Coach myCoach; delete the setter injection and constructor injection*/

    private Coach myCoach;

    //setter injection
    @Autowired
    public void setCoach(Coach coach){
        myCoach = coach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
