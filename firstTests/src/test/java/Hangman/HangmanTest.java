package Hangman;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Дарья on 07.09.2016.
 */
public class HangmanTest {
    @Test
    public void youSeeMaskedWord() {
        assertEquals("____", new Hangman("sofa").getWord());
    }

    @Test
    public void youMustGuessLetters() {
        Hangman game = new Hangman("sofa");
        game.guessLetters('o');
        assertEquals("_o__", game.getWord());
    }
}
