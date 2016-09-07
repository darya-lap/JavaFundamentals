package Hangman;

public class Hangman {
    private final String word;
    private String maskedWord;
    public Hangman(String s){
        this.word = s;
        maskedWord = s.replaceAll(".","_");
    }

    public String getWord() {
        return maskedWord;
    }


    public void guessLetters(char letter) {
        int index = word.indexOf(letter);
        if (index < 0)
        return;
        maskedWord = maskedWord.substring(0, index) + letter + maskedWord.substring(index +1);
    }
}
