package injection.dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EnglishGreetingService implements GreetingService{
    public EnglishGreetingService(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String greet() {
        return "Hello there";
    }
}
