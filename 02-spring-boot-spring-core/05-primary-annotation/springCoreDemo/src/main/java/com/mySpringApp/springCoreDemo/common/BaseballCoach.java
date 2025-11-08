package com.mySpringApp.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        return "BaseballCoach: Spend 30m in batting practice";
    }
}
