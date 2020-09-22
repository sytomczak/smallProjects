package pl.sytomczak.palindrome.reverseastring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringServiceTest {

    private ReverseStringService service = new ReverseStringService();

    @Test
    public void shouldCheckIfStringIsReverse() {
        String input = "rybka";
        String output = "akbyr";

        String result = service.reverseString(input);

        assertThat(result).isEqualTo(output);
    }
}
