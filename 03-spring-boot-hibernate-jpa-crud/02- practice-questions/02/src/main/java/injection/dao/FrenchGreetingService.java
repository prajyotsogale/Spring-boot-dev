package injection.dao;

import org.springframework.stereotype.Component;

@Component
public class FrenchGreetingService implements GreetingService{

    public FrenchGreetingService(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }

    @Override
    public String greet() {
        return "Bonjour !";
    }
}
