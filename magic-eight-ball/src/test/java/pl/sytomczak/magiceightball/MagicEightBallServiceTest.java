package pl.sytomczak.magiceightball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MagicEightBallServiceTest {

    @Mock
    private MagicEightBallRepository repository;
    @InjectMocks
    private MagicEighBallService service;

    @Test
    public void shouldGenerateSentence() {
        when(repository.getNumberOfSentence()).thenReturn(6);
        when(repository.getSentence(anyInt())).thenReturn("sentence");

        String sentence = service.generateSentence();

        assertThat(sentence).isNotBlank();

    }

}
