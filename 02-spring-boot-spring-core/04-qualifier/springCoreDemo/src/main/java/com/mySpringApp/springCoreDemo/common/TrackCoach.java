package com.mySpringApp.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public String getDailyWorkout(){
        return "TrackCoach: Run a hard 5k";
    }
}
