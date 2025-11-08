package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String theName =  request.getParameter("studentName");
        theName = "Yo!"+theName.toUpperCase();
        model.addAttribute("message",theName);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam(name = "studentName") String theName,
                                          Model model){
        theName = "Hey my friend from v3! "+theName.toUpperCase();
        model.addAttribute("message",theName);
        return "helloworld";
    }
}
