package funController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRest {


    private Coach mycoach;

//    @Autowire d
//    public FunRest(@Qualifier("footballCoach") Coach coach){
//        mycoach=coach;
//    }

    @Autowired
    public FunRest(Coach coach){
        mycoach = coach;
    }


    @GetMapping("/coach")
    public String showCoach(){
        return mycoach.getDailyWorkout();
    }

    @GetMapping("/fortune")
    public String tellFortune(){
        return "Today is your lucky day";
    }


}
