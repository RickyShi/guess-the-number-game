package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber = 50;
    private int guessCount = 8;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
/*
 now after adding custom annotation,
 below code will work so that we do not need worry about future refactoring might cause some issue.
 */
    /*@Bean
    public int guessCount1() {
        return guessCount;
    }*/
}
