package pl.sytomczak.palindrome.hangman;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@Getter
@Setter(AccessLevel.PRIVATE)
public class HangmanService {
    private final int STARTING_CHANCHES = 11;
    private final String PICTURE_PATH = "/img/%d.png";

    private String selectedWord;
    private String guessedWord;
    private Character providedLetter;
    private Integer points;
    private Integer maxPoints;
    private Integer chances;
    private List<Character> usedLetters;
    private String currentPicture;
    private String gameEndingLabel = StringConstants.GAME_WON_LABEL;
    private boolean gameFinished;

    public HangmanService() {
        initializeTheGame();
    }

    private void initializeTheGame() {
        this.usedLetters = new ArrayList<>();
        drawWord();
        this.points = 0;
        this.maxPoints = selectedWord.length();
        this.chances = STARTING_CHANCHES;
        this.gameFinished = false;
        setPictureOfNumber(STARTING_CHANCHES);
    }

    private void setPictureOfNumber(int pictureNumber) {
        currentPicture = String.format(PICTURE_PATH, pictureNumber);
    }

    public List<String> getAll() {

        List<String> words = Lists.newArrayList(
                "FOKA",
                "PIESEK",
                "FOCZKOWANIE",
                "FOKSTROT"
        );
        return words;
    }

    public void drawWord() {

        List<String> words = this.getAll();
        int numberOfWords = words.size();

        Random rand = new Random();
        int indexOfWord = (rand.nextInt(numberOfWords));

        selectedWord = words.get(indexOfWord);
        guessedWord = hideWord(selectedWord);
        System.out.println("WORD TO GUESS: " + getSelectedWord());
    }

    public String hideWord(String word) {
        StringBuilder hiddenWordBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            boolean isLetterGuessed = checkIfLetterHasBeenGuessed(word.charAt(i));

            if (i != word.length() - 1) {
                if (isLetterGuessed) {
                    hiddenWordBuilder.append(word.charAt(i));
                    hiddenWordBuilder.append(" ");
                } else hiddenWordBuilder.append("_ ");
            } else {
                if (isLetterGuessed) {
                    hiddenWordBuilder.append(word.charAt(i));
                } else hiddenWordBuilder.append("_");
            }
        }

        return hiddenWordBuilder.toString();
    }

    private boolean checkIfLetterHasBeenGuessed(char processedChar) {
        return usedLetters.contains(processedChar);
    }

    public void processTheTry(Character typedLetter) {
        if (usedLetters.contains(typedLetter)) return;
        usedLetters.add(typedLetter);

        if (checkIfLetterInTheWord(typedLetter)) {
            System.out.println("LETTER IN THE WORD");
            guessedWord = hideWord(selectedWord);
            checkHowManyTimesOccurs(typedLetter).forEach(i -> addPoint());
            if (checkIfPlayerWon()) endTheGame(GameEndingType.WIN);
        } else {
            System.out.println("LETTER NOT IN THE WORD!");
            subtractChances();
            setPictureOfNumber(getChances());
            if (checkIfPlayerLost()) endTheGame(GameEndingType.LOSE);
        }
        System.out.println("CHANCES LEFT: " + getChances());
        System.out.println("POINTS: " + getPoints());
        System.out.println("MAX POINTS: " + getMaxPoints());

    }

    private IntStream checkHowManyTimesOccurs(Character typedLetter) {
        IntStream.Builder intStreamBuilder = IntStream.builder();
        for (Character wordChar : selectedWord.toCharArray()) {
            if (wordChar.equals(typedLetter)) intStreamBuilder.add(1);
        }
        return intStreamBuilder.build();
    }

    private List<Integer> getIndexesOfTheLetters(Character typedLetter) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < selectedWord.length(); i++) {
            if (typedLetter.equals(selectedWord.charAt(i))) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private void endTheGame(GameEndingType endingType) {

        if (endingType.equals(GameEndingType.WIN)) {
            setGameEndingLabel(StringConstants.GAME_WON_LABEL);
        } else {
            setGameEndingLabel(StringConstants.GAME_LOST_LABEL);
        }

        gameFinished = true;
    }

    private boolean checkIfPlayerWon() {
        return getPoints().equals(maxPoints);
    }

    private boolean checkIfPlayerLost() {
        return getChances().equals(0);
    }

    public boolean checkIfInputHaveOnlyOneLetter(String word) {
        return ((!word.equals(""))
                && (word != null)
                && (word.matches("^[A-Z]*$")));
    }

    public boolean checkIfLetterInTheWord(Character letter) {
        if (letter == null) return false;

        int i = this.selectedWord.indexOf(letter);
        return (i != -1);
    }

    public void addPoint() {
        points++;
    }

    public void subtractChances() {
        if (chances > 0) this.chances--;
    }

    public void restartTheGame() {
        setGameFinished(false);
        initializeTheGame();
    }
}
