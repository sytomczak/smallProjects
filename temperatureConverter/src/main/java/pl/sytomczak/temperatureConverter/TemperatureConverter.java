package pl.sytomczak.temperatureConverter;

public class TemperatureConverter {

    public static double convert(String inputUnit, String outputUnit, double inputValue) {

        if (inputUnit == "C") {
            if (outputUnit == "K") return inputValue = Math.round((inputValue + 273.15) * 100.0) / 100.0;
            if (outputUnit == "F") return inputValue = Math.round(((9 / 5.0) * inputValue + 32) * 100.0) / 100.0;
        } else if (inputUnit == "K") {
            if (outputUnit == "C") return inputValue = Math.round((inputValue - 273.15) * 100.0) / 100.0;
            if (outputUnit == "F")
                return inputValue = Math.round(((9 / 5.0) * (inputValue - 273.15) + 32) * 100.0) / 100.0;
        } else if (inputUnit == "F") {
            if (outputUnit == "C") return inputValue = Math.round((5 / 9.0) * (inputValue - 32) * 100.0) / 100.0;
            if (outputUnit == "K") return inputValue = Math.round((inputValue + 459.67) / 1.8 * 100.0) / 100.0;
        }

        if (inputUnit == "CM") {
            if (outputUnit == "M") return inputValue * 0.01;
            if (outputUnit == "Foki") return inputValue * 150;
        } else if (inputUnit == "M") {
            if (outputUnit == "CM") return inputValue * 100;
            if (outputUnit == "Foki") return inputValue * 1.5;
        } else {
            if (outputUnit == "CM") return inputValue * 150;
            if (outputUnit == "M") return inputValue * 1.5;
        }

        return inputValue;
    }
}
