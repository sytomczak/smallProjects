package pl.sytomczak.palindrome.fibonaccisequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciSequenceServiceTests {

    private FibonacciSequenceService service = new FibonacciSequenceService();

    @Test
    public void shouldCheckIfInputReturnCorrectFibonacciSequence_givenFibonacciSequence() {
        int inputNumberOfNumbersInFibonacciSequence = 10;
        int outputCalculateFibonacciSequence = 55;

        int result = service.calculateFibonacciSequence(inputNumberOfNumbersInFibonacciSequence);

        assertThat(result).isEqualTo(outputCalculateFibonacciSequence);

    }

}
