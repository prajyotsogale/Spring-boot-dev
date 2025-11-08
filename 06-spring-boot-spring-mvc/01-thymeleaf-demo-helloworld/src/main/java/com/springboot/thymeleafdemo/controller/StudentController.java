package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries;

    @Value("${languages}")
    List<String> languages;

    @Value("${operatingSystems}")
    List<String> operatingSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        //create a student object
        Student theStudent = new Student();
        //add student object to the model
        model.addAttribute("student",theStudent);

        model.addAttribute("countries", countries);

        model.addAttribute("languages", languages);

        model.addAttribute("operatingSystems",operatingSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){

        //log the input data
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }
}
