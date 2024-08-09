package funController;

import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "on the table tennis baby";
    }
}
