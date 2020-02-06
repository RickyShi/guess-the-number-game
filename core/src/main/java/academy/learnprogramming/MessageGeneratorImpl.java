package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements  MessageGenerator {
    private final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void logGame(){
        log.info("game is {}", game);
        log.info("the remaining change is {}", game.getRemainingGuesses());
    }
    @Override
    public String getMainMessages() {
        return "Number is between " +
                game.getSmallest() + " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessages() {
        if (game.isGameWon()){
            return "You guessed it. The number was " + game.getNumber();
        } else if (game.isGameLoss()){
            return "You lost. the number was " + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == guessCount){
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + "guess left.";
        }
    }
}
