package pl.sytomczak.loveCalkulator;

import java.math.BigDecimal;

public class LoveCalculatorLogic {

    public static double calculate(String firstName, String secondName) {

        char[] imie1Tablica = firstName.toCharArray();
        char[] imie2Tablica = secondName.toCharArray();
        double sumaImie1 = 0;
        double sumaImie2 = 0;

        for (char a : imie1Tablica) {

            sumaImie1 += a;
        }
        for (char a : imie2Tablica) {

            sumaImie2 += a;
        }

        double intermediate = 100 - (100 * Math.abs(1 - (sumaImie1 / sumaImie2)));
        BigDecimal result = new BigDecimal(intermediate);
        result = result.setScale(0, BigDecimal.ROUND_DOWN);

        return result.doubleValue();
    }

}
