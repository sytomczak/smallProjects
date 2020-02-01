package pl.sytomczak.fibonaccisequence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateFibonacciControllerTest {

    @Mock
    private FibonacciSequenceService service;
    @InjectMocks
    private CalculateFibonacciController controller;

    @Test
    public void shouldSucceed() {
        FibonacciSequenceWrapper wrapper = new FibonacciSequenceWrapper();
        wrapper.setCalculateFibonacci(7);

        int resultCalculateFibonacci = 13;
        when(service.calculateFibonacciSequence(anyInt())).thenReturn(resultCalculateFibonacci);

        ResponseEntity response = controller.calculateFibonacci(wrapper);

        assertThat(response.getBody()).isEqualTo(resultCalculateFibonacci);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
