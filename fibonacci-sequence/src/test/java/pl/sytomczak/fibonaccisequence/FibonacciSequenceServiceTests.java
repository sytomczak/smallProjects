package pl.sytomczak.fibonaccisequence;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

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
