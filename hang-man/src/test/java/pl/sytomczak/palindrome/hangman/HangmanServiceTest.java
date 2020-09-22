package pl.sytomczak.palindrome.hangman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest //adnotacja : zawsze kiedy używam springa
@ExtendWith(SpringExtension.class)  //j.w.
@DirtiesContext
public class HangmanServiceTest {

    @Autowired
    private HangmanService service;


    @Test
    public void shouldGetAllWords() {
        List<String> words = service.getAll();
        assertThat(words).isNotEmpty();
    }

    @Test
    public void shouldDrawWord() {
        service.drawWord();
        String word = service.getSelectedWord();
        assertThat(word).isNotBlank();
    }

    @Test
    public void shouldWriteOneLetter() {
        String word = "f";
        boolean isOnlyOneLetter = service.checkIfInputHaveOnlyOneLetter(word);
        assertThat(isOnlyOneLetter).isTrue();
    }

    @Test
    public void shouldCheckIfLetterIsInTheWord() {
        String word = service.getSelectedWord();

        boolean isInWord = service.checkIfLetterInTheWord(word.charAt(0));
        assertThat(isInWord).isTrue();
    }

    @Test
    public void shouldNotCheckIfLetterIsInTheWord() {
        boolean isInWord = service.checkIfLetterInTheWord(null);
        assertThat(isInWord).isFalse();
    }

    @Test
    public void shouldAddPoint() {
        int startingPoints = service.getPoints();
        service.addPoint();
        ;
        int endPoints = service.getPoints();
        assertThat(startingPoints).isLessThan(endPoints);
    }

    @Test
    public void shouldSubtractsChance() {
        int startingChances = service.getChances();
        service.subtractChances();
        int endChances = service.getChances();
        assertThat(startingChances).isGreaterThan(endChances);
    }

    @Test
    public void shouldCheckIfAllLetterAreShow() {
        String word = service.getSelectedWord();

        for (int i = 0; i < word.length(); i++) {
            if (service.checkIfLetterInTheWord(word.charAt(i))) service.addPoint();
        }

        int numberOfLettersInWord = word.length();
        int numberOfPoints = service.getPoints();
        assertThat(numberOfPoints).isEqualTo(numberOfLettersInWord);
    }

    @Test
    public void shouldCheckIfAllChanceAreOver() {
        int numberOfChances = service.getChances();

        for (int i = 11; i != 0; i--) {
            if (!service.checkIfLetterInTheWord(null)) service.subtractChances();
        }
        //TODO: fix it
    }

    @Test
    public void shouldHideDrawnWord() {
        String hiddenWord = service.hideWord("WORD");

        assertThat(hiddenWord).isEqualTo("_ _ _ _");
    }
}