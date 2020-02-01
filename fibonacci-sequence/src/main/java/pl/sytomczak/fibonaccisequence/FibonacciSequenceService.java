package pl.sytomczak.fibonaccisequence;

import org.springframework.stereotype.Service;

@Service
public class FibonacciSequenceService {

    public int calculateFibonacciSequence(int calculateFibonacci) {

        if(calculateFibonacci == 0) {
            return 0;
        } else if (calculateFibonacci == 1) {
            return 1;
        } else return calculateFibonacciSequence(calculateFibonacci - 1) + calculateFibonacciSequence(calculateFibonacci - 2);
    }
}

