package com.mySpringApp.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "TennisCoach: Practice your Backhand volley";
    }
}
