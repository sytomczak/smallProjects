package pl.sytomczak.palindrome.haikugenerator;

import lombok.Getter;


public enum NumberOfSyllableWords {
    FIVE(5),
    SEVEN(7);

    @Getter
    private int numberOfSyllable;

    NumberOfSyllableWords(int numberOfSyllable) {
        this.numberOfSyllable = numberOfSyllable;
    }
}

