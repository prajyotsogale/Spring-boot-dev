package springboot.demosecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.demosecurity.entity.User;
import springboot.demosecurity.service.UserService;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model){
        User newUser = new User();
        model.addAttribute("user",newUser);
        return "registrationPage";
    }

    @PostMapping("/saveRegistrationDetails")
    public String saveDetails(@ModelAttribute("user") User user, @RequestParam("confirmPassword") String confirmPassword){
        System.out.println("password is: "+user.getPassword()+"="+confirmPassword);
        if (!user.getPassword().trim().equals(confirmPassword)) {
            return "registrationPage";
        }

        userService.save(user);
        return "redirect:/showMyLoginPage";
    }
}
