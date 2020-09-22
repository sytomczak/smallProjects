package pl.sytomczak.palindrome.bmicalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BmiCalculatorServiceTest {

    private BmiCalculatorService service = new BmiCalculatorService();

    @Test
    public void shouldCheckIfInputsReturnCorrectBmi_givenBmi() {
        int inputWeight = 62;
        int inputHeight = 162;
        int outputBmi = 24;

        int bmi = service.checkIfInputsReturnCorrectBmi(inputHeight, inputWeight);

        assertThat(bmi).isEqualTo(outputBmi);
    }
}
