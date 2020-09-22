package pl.sytomczak.palindrome.internettime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ConvertsController {

    @Autowired
    private InternetTimeService service;

    @GetMapping("/getTime/{numberOfBeats}")
    public ResponseEntity generateTime() {
        TimeWrapper responseBody = service.generateTime();
        return ResponseEntity.of(Optional.of(responseBody));
    }
}
