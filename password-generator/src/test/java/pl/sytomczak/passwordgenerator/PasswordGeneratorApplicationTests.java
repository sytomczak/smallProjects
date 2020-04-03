package pl.sytomczak.passwordgenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordGeneratorApplicationTests {

    @Autowired
    private PasswordGeneratorService service;

    @Test
    public void shouldGenerateEasyPassword() {
        PasswordWrapper password = service.generatePassword(PasswordLength.WEAK);
        assertThat(password.getPassword()).isNotBlank();
    }

    @Test
    public void shouldGenerateMediumPassword() {
        PasswordWrapper password = service.generatePassword(PasswordLength.MEDIUM);
        assertThat(password.getPassword()).isNotBlank();
    }

    @Test
    public void shouldGenerateHardPassword() {
        PasswordWrapper password = service.generatePassword(PasswordLength.STRONG);
        assertThat(password.getPassword()).isNotBlank();
    }

    @Test
    public void shouldCheckIfEasyPasswordHaveSixMarks() {
        PasswordWrapper password = service.generatePassword(PasswordLength.WEAK);
        assertThat(password.getPassword().length()).isEqualTo(6);
    }

    @Test
    public void shouldCheckIfMediumPasswordHaveEightMarks() {
        PasswordWrapper password = service.generatePassword(PasswordLength.MEDIUM);
        assertThat(password.getPassword().length()).isEqualTo(8);
    }

    @Test
    public void shouldCheckIfHardPasswordHaveTenMarks() {
        PasswordWrapper password = service.generatePassword(PasswordLength.STRONG);
        assertThat(password.getPassword().length()).isEqualTo(10);

    }
}