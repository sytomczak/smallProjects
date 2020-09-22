package pl.sytomczak.palindrome.calkulateAgeInSecond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalkulateSecondTest {


    @Test
    public void shouldConvertMinutesToSecond() {
        int result = CalkulateSecond.convert(0, 0, 1);
        assertThat(result).isEqualTo(60);
    }

    @Test
    public void shouldConvertHoursToSecond() {
        int result = CalkulateSecond.convert(0, 1, 0);
        assertThat(result).isEqualTo(3600);
    }

    @Test
    public void shouldConvetDaysToSecond() {
        int result = CalkulateSecond.convert(1, 0, 0);
        assertThat(result).isEqualTo(86400);
    }
}