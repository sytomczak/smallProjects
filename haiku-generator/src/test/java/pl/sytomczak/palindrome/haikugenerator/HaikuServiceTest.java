package pl.sytomczak.palindrome.haikugenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HaikuServiceTest {

    @Mock
    private HaikuRepository repository;
    @InjectMocks
    private HaikuGeneratorService service;

    @Test
    public void shouldGenerateHaiku() {
        when(repository.getNumberOfHaikus()).thenReturn(3);
        when(repository.getHaiku(anyInt())).thenReturn("some haiku");

        String haiku = service.generateHaiku();

        assertThat(haiku).isNotBlank();
    }
}