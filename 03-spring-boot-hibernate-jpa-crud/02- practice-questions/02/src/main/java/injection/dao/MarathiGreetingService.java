package injection.dao;


import org.springframework.stereotype.Component;

@Component
public class MarathiGreetingService implements GreetingService{

    public MarathiGreetingService(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }

    @Override
    public String greet() {
        return "Namaskar!";
    }
}
