package pl.sytomczak.palindrome.loveCalculator;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class LoveCalculatorService {

    private String femaleName;
    private String maleName;
    private Integer points;
    private boolean gameFinished;
    private String gameEndingLabel = StringConstants.CLOSE_BUTTON_LABEL;

    private LoveCalculatorService() {
        initializeTheGame();
    }

    private void initializeTheGame() {
        this.gameFinished = false;
        this.points = 0;
    }

    public void calculate(Names names) {
        femaleName = names.getFemaleName();
        maleName = names.getMaleName();

        checkIfFemaleInputIsNotEmpty(femaleName);
        checkIfMaleInputIsNotEmpty(maleName);

        addPercentagePoints();
    }


    public boolean checkIfFemaleInputIsNotEmpty(String femaleName) {
        return femaleName != null;
    }

    public boolean checkIfMaleInputIsNotEmpty(String maleName) {
        return maleName != null;
    }

    public String checkIfAdviceNotEmpty(String adv) {
        adv = advice();
        return adv;
    }

    public void addPercentagePoints() {
        boolean firstLetter = checkIfFirstLetterIsTheSame(femaleName, maleName);
        boolean sameLetter = checkIfNamesHaveTheSameLetter(femaleName, maleName);
        boolean sameNumberOfLetter = checkIfNamesHaveTheSameNumbersOfLetter(femaleName, maleName);

        if (firstLetter) {
            points += 40;
        } else if (sameLetter) {
            points += 25;
        } else if (sameNumberOfLetter) {
            points += 50;
        }
    }


    public boolean checkIfInputHaveOnlyLetters(String inputName) {
        return ((!inputName.equals(""))
                && (inputName != null)
                && (inputName.matches("[a-zA-Z]+")));
    }

    public boolean checkIfPointsAreBetweenZeroAndHundred(int actualPoints) {
        return (actualPoints >= 0 && actualPoints <= 100);
    }

    public String advice() {
        switch (getPoints()) {
            case 0:
                return "You shouldn't be together";
            case 25:
                return "You should be friends";
            case 40:
                return "Maybe spends more time together";
            case 50:
                return "You have 50 percent chance of a successful relationship!";
            case 65:
                return "You have a lot of chance to be good couple";
            case 75:
                return "You are good couple!";
            case 90:
                return "You are almost perfect couple!";
            case 100:
                return "You must get mariage";
            default:
                return "The Foczilla fairy has a break";
        }
    }

    public boolean checkIfFirstLetterIsTheSame(String maleName, String femaleName) {
        return maleName.charAt(0) == femaleName.charAt(0);
    }

    private void endTheGame(GameEndingType endingType) {

        if (endingType.equals(GameEndingType.CLOSE_BUTTON_LABEL)) ;
        setGameEndingLabel(StringConstants.CLOSE_BUTTON_LABEL);
        gameFinished = true;
    }

    public void restartTheGame() {
        setGameFinished(false);
        initializeTheGame();
    }

    public boolean checkIfNamesHaveTheSameNumbersOfLetter(String maleName, String femaleName) {
        return maleName.length() == femaleName.length();
    }

    public boolean checkIfNamesHaveTheSameLetter(String maleName, String femaleName) {

        for (int i = 0; i < maleName.length(); i++) {
            if (maleName.charAt(i) == femaleName.indexOf(i)) ;
            return true;
        }
        return false;
    }
}


