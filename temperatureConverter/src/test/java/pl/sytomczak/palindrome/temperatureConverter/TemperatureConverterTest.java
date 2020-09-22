package pl.sytomczak.palindrome.temperatureConverter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class TemperatureConverterTest {

    @Test
    public void shouldConvertCentimetersToCentimeters() {
        double result = TemperatureConverter.convert("CM", "CM", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertCentimetersToMeters() {
        double result = TemperatureConverter.convert("CM", "M", 1);
        assertThat(result).isEqualTo(0.01);
    }

    @Test
    public void shouldConvertCentimetersToSeals() {
        double result = TemperatureConverter.convert("CM", "Foki", 1);
        assertThat(result).isEqualTo(150);
    }

    @Test
    public void shouldConvertMetersToMeters() {
        double result = TemperatureConverter.convert("M", "M", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertMetersToCentimeters() {
        double result = TemperatureConverter.convert("M", "CM", 1);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void shouldConvertMetersToSeals() {
        double result = TemperatureConverter.convert("M", "Foki", 1);
        assertThat(result).isEqualTo(1.5);
    }

    @Test
    public void shouldConvertSealsToCentimeters() {
        double result = TemperatureConverter.convert("Foki", "CM", 1);
        assertThat(result).isEqualTo(150);
    }

    @Test
    public void shouldConvertSealsToMeters() {
        double result = TemperatureConverter.convert("Foku", "M", 1);
        assertThat(result).isEqualTo(1.5);
    }

    @Test
    public void shouldConvertSealsToSeals() {
        double result = TemperatureConverter.convert("Foki", "Foki", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertCelsiusToCelsius() {
        double result = TemperatureConverter.convert("C", "C", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertCelsiusToFahrenheit() {
        double result = TemperatureConverter.convert("C", "F", 1);
        assertThat(result).isEqualTo(33.80);
    }

    @Test
    public void shouldConvertCelsiusToKelvin() {
        double result = TemperatureConverter.convert("C", "K", 1);
        assertThat(result).isEqualTo(274.15);
    }

    @Test
    public void shouldConvertFahrenheitToCelsius() {
        double result = TemperatureConverter.convert("F", "C", 1);
        assertThat(result).isEqualTo(-17.22);
    }

    @Test
    public void shouldConvertFahrenheitToFahrenheit() {
        double result = TemperatureConverter.convert("F", "F", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertFahrenheitToKelvin() {
        double result = TemperatureConverter.convert("F", "K", 1);
        assertThat(result).isEqualTo(255.93);
    }

    @Test
    public void shouldConvertKelvinToCelsius() {
        double result = TemperatureConverter.convert("K", "C", 1);
        assertThat(result).isEqualTo(-272.15);
    }

    @Test
    public void shouldConvertKelvinToKelvin() {
        double result = TemperatureConverter.convert("K", "K", 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldConvertKelvinToFahrenheit() {
        double result = TemperatureConverter.convert("K", "F", 1);
        assertThat(result).isEqualTo(-457.87);
    }

}