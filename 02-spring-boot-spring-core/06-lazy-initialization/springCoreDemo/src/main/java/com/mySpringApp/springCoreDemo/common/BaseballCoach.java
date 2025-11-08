package com.mySpringApp.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "BaseballCoach: Spend 30m in batting practice";
    }
}
