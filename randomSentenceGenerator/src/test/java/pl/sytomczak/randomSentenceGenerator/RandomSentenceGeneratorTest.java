package pl.sytomczak.randomSentenceGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RandomSentenceGeneratorTest {

    @Autowired
    private RandomSentenceGeneratorService service;

    @Test
    public void shouldGetAllSentences() {
        List<String> sentences = service.getAll();
        assertThat(sentences).isNotEmpty();
    }

    @Test
    public void shouldGenerateSentences() {
        service.generateSentences();
        String sentence = service.getSelectedSentence();
        assertThat(sentence).isNotBlank();

    }
}
