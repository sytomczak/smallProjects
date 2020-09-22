package pl.sytomczak.palindrome.magiceightball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SentenceControllerTest {

    @Mock
    private MagicEighBallService service;
    @InjectMocks
    private SentenceController controller;

    @Test
    public void shouldSucceed() {
        String sentence = "sentence";
        when(service.generateSentence()).thenReturn(sentence);

        ResponseEntity response = controller.generateSentence();

        assertThat(response.getBody()).isEqualTo(sentence);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
