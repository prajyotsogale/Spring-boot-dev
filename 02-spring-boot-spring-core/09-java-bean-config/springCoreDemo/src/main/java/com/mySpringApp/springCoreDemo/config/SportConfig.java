package com.mySpringApp.springCoreDemo.config;

import com.mySpringApp.springCoreDemo.common.Coach;
import com.mySpringApp.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
