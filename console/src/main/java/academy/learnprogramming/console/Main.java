package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        log.info("Guess the number game");
        //create context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //get numberGenerator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();
        log.info("number = {}", number);

        //get game bean from context (container)
        Game game = context.getBean(Game.class);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessages is {}", messageGenerator.getMainMessages());
        log.info("getResultMessages is {}", messageGenerator.getResultMessages());


        // close context (container)
        context.close();
    }
}
