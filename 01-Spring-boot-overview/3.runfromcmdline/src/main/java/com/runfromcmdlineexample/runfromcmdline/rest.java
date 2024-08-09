package com.runfromcmdlineexample.runfromcmdline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {
    @GetMapping("/")
    public String giveInfo(){
        return "The program is running, so far...";
    }

    @GetMapping("/fortune")
    public String fortuneTeller(){
        return "Today is your lucky day";
    }

    @GetMapping("/prize")
    public String prizeWon(){
        return "Congratulations!! You Won a Prize!!";
    }
}
