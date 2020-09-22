package pl.sytomczak.palindrome.bmicalculator;

import org.springframework.stereotype.Service;

@Service
public class BmiCalculatorService {

    public int checkIfInputsReturnCorrectBmi(int inputHeight, int inputWeight) {
        return (int) Math.round(inputWeight * 10000 / Math.pow(inputHeight, 2));
    }
}
