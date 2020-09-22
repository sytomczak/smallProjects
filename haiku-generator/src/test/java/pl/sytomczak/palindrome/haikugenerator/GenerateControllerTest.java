package pl.sytomczak.palindrome.haikugenerator;

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
class GenerateControllerTest {

    @Mock
    private HaikuGeneratorService service;
    @InjectMocks
    private GenerateController controller;

    @Test
    public void shouldSucceed() {
        String haiku = "some haiku";
        when(service.generateHaiku()).thenReturn(haiku);


        ResponseEntity response = controller.generateHaiku();

        assertThat(response.getBody()).isEqualTo(haiku);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response).extracting(ResponseEntity::getStatusCode).isEqualTo(HttpStatus.OK);
    }
}