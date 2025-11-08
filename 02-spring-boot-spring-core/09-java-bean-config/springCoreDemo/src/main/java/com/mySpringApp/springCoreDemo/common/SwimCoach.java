package com.mySpringApp.springCoreDemo.common;


import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach: Swim 100m as a warm up";
    }
}
