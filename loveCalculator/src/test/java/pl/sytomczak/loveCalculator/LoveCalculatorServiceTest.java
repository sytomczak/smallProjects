package pl.sytomczak.loveCalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class LoveCalculatorServiceTest {

    @Autowired
    private LoveCalculatorService service;

    @Test
    public void shouldCheckIfFemaleInputIsNotEmpty() {
        String femaleName = "Zosia";
        boolean isFemaleNameNotEmpty = service.checkIfFemaleInputIsNotEmpty(femaleName);
        assertThat(isFemaleNameNotEmpty).isNotNull().isTrue();
    }

    @Test
    public void shouldCheckIfMaleInputIsNotEmpty() {
        String maleName = "Jan";
        boolean isMaleNameNotEmpty = service.checkIfMaleInputIsNotEmpty(maleName);
        assertThat(isMaleNameNotEmpty).isNotNull().isTrue();
    }

    @Test
    public void shouldCheckIfFemaleInputIsEmpty() {
        boolean isFemaleNameNotEmpty = service.checkIfFemaleInputIsNotEmpty(null);
        assertThat(isFemaleNameNotEmpty).isNotNull();
    }

    @Test
    public void shouldAddPercentagePoints() {
        service.setFemaleName("fname");
        service.setMaleName("mname");

        int startingPercentagePoints = service.getPoints();
        service.addPercentagePoints();

        int endPercentagePoints = service.getPoints();
        assertThat(startingPercentagePoints).isLessThan(endPercentagePoints);
    }

    @Test
    public void shouldCheckIfNamesHaveTheSameFirstLetterInName() {
        String maleName = "Olek";
        String femaleName = "Ola";

        boolean isFirstLetterTheSame = service.checkIfFirstLetterIsTheSame(maleName, femaleName);

        assertThat(isFirstLetterTheSame).isTrue();
    }

    @Test
    public void shouldCheckIfPointsAdded_givenTheSameFirstLetterInName() {
        String maleName = "AMale";
        String femaleName = "AFemale";
        service.setMaleName(maleName);
        service.setFemaleName(femaleName);
        int startingPoints = service.getPoints();
        int finalPoints = 0;

        service.addPercentagePoints();

        finalPoints = service.getPoints();

        assertThat(startingPoints).isLessThanOrEqualTo(finalPoints);
    }

    @Test
    public void shouldCheckIfNamesHaveTheSameNumbersOfLetters() {
        String maleName = "Marek";
        String femaleName = "Kasia";

        boolean isTheSameNumbersOfLetter = service.checkIfNamesHaveTheSameNumbersOfLetter(maleName, femaleName);
        assertThat(maleName.length()).isEqualTo(femaleName.length());
    }

    @Test
    public void shouldCheckIfPointsAdded_givenTheSameNumbersIfLetterInNames() {
        String maleName = "NNMale";
        String femaleName = "Female";
        service.setMaleName(maleName);
        service.setFemaleName(femaleName);
        int startingPoints = service.getPoints();
        int finalPoints = 0;

        service.addPercentagePoints();

        finalPoints = service.getPoints();

        assertThat(startingPoints).isLessThanOrEqualTo(finalPoints);
    }


    @Test
    public void shouldCheckIfNamesHaveTheSameLetterInName() {
        String maleName = "Marek";
        String femaleName = "Kasia";

        boolean hasTheSameLetter = service.checkIfNamesHaveTheSameLetter(maleName, femaleName);

        for (int i = 0; i < maleName.length(); i++) {
            if (maleName.charAt(i) == femaleName.indexOf(i)) hasTheSameLetter = true;
        }
        assertThat(hasTheSameLetter).isTrue();
    }

    @Test
    public void shouldCheckIfPointsAdded_givenTheSameLetterInNames() {
        //GIVEN
        String maleName = "Male";
        String femaleName = "Female";
        service.setMaleName(maleName);
        service.setFemaleName(femaleName);
        int startingPoints = service.getPoints();
        int finalPoints = 0;

        //WHEN
        service.addPercentagePoints();

        //THEN
        finalPoints = service.getPoints();
        assertThat(startingPoints).isLessThanOrEqualTo(finalPoints);
    }
}
