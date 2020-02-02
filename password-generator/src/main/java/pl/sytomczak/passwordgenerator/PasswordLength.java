package pl.sytomczak.passwordgenerator;

import lombok.Getter;

public enum PasswordLength {
    WEAK(6),
    MEDIUM(8),
    STRONG(10);

    @Getter
    private int numberOfCharacters;

    PasswordLength(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }
}
