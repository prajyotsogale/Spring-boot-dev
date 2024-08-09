package com.second.project.example.numbertwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {
    @GetMapping("/")
    public String sayHello(){
        return "WELCOME";
    }
}
