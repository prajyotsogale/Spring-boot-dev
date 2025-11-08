package com.mySpringApp.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Cricket Coach: Practice fast bowling for 15 minutes :-)";
    }
}
