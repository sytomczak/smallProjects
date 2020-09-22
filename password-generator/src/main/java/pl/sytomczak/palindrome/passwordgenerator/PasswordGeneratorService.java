package pl.sytomczak.palindrome.passwordgenerator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Getter
@Setter
public class PasswordGeneratorService {

    public PasswordWrapper generatePassword(PasswordLength passwordLength) {
        String marks = ("[a-zA-Z0-9]+");
        String password = "";

        Random random = new Random();
        char[] text = new char[passwordLength.getNumberOfCharacters()];

        for (int i = 0; i < passwordLength.getNumberOfCharacters(); i++) {
            text[i] = marks.charAt(random.nextInt(marks.length()));
        }
        for (int i = 0; i < text.length; i++) {
            password += text[i];
        }

        return PasswordWrapper.of().password(password).build();
    }
}

