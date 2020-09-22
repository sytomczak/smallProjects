package pl.sytomczak.palindrome.reverseastring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReverseControllerTest {

    @Mock
    private ReverseStringService service;
    @InjectMocks
    private ReverseController controller;

    @Test
    public void shouldSucceed() {
        String reverseString = "reverseString";
        when(service.reverseString(any())).thenReturn(reverseString);

        ResponseEntity response = controller.reverseString(new ReverseStringWrapper());

        assertThat(response.getBody()).isEqualTo(reverseString);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
