package thymeleaf.practice.demothymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/")
    public String getForm(){
        return "helloworld-form";
    }

    @PostMapping("/processedForm")
    public String processedForm(@RequestParam(name = "studentName")String name, Model model){
        name = "Hello " + name.toUpperCase();
        model.addAttribute("name",name);
        return "helloworld";
    }

}
