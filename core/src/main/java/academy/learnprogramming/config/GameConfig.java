package academy.learnprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber = 50;
    private int guessCount = 8;

    @Bean
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    public int guessCount() {
        return guessCount;
    }
    // == below will not work if we still use @autowired private int guessCount since the name is not qualified ==
    /*@Bean
    public int guessCount1() {
        return guessCount;
    }*/
}
