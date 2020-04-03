package pl.sytomczak.calkulateAgeInSecond;

public class CalkulateSecond {
    public static int convert(int dni, int godziny, int minuty) {

        int secondsInMinutes = minuty * 60;
        int secongInHours = godziny * 3600;
        int secondInDays = dni * 86400;
        return secondsInMinutes + secongInHours + secondInDays;


    }


}
