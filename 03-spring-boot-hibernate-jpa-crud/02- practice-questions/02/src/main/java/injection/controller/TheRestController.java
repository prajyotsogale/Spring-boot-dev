package injection.controller;

import injection.dao.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TheRestController {

    private GreetingService greet;

    @Autowired
    public TheRestController(@Qualifier("marathiGreetingService") GreetingService greet){
        this.greet = greet;
    }

    @GetMapping("/greet")
    public String greet(){
        return greet.greet();
    }
}
