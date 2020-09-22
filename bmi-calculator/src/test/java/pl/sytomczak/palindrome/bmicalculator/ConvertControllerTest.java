package pl.sytomczak.palindrome.bmicalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConvertControllerTest {

    @Mock
    private BmiCalculatorService service;
    @InjectMocks
    private ConvertController controller;

    @Test
    public void shouldSucceed() {
        ConvertWrapper wrapper = new ConvertWrapper();
        wrapper.setConvertHeight(162);
        wrapper.setConvertWeight(62);

        int resultBmi = 24;
        when(service.checkIfInputsReturnCorrectBmi(anyInt(), anyInt())).thenReturn(resultBmi);

        ResponseEntity response = controller.convertWeight(wrapper);

        assertThat(response.getBody()).isEqualTo(resultBmi);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
