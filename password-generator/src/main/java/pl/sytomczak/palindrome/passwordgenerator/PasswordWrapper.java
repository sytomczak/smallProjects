package pl.sytomczak.palindrome.passwordgenerator;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class PasswordWrapper {
    private String password;
}
