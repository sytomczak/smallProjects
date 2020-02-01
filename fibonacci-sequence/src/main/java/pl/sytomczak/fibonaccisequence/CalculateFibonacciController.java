package pl.sytomczak.fibonaccisequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculateFibonacciController {

    private FibonacciSequenceService service;

    @Autowired
    public CalculateFibonacciController(FibonacciSequenceService service) {
        this.service = service;
    }

    public CalculateFibonacciController() {this.service = new FibonacciSequenceService();}

    @PostMapping("/calculateFibonacci")
    public ResponseEntity calculateFibonacci(@RequestBody FibonacciSequenceWrapper calculateBody) {
        return ResponseEntity.ok(service.calculateFibonacciSequence(calculateBody.getCalculateFibonacci()));
    }
}
