package pl.sytomczak.reverseastring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReverseController {

    private  ReverseStringService service;

    @Autowired
    public ReverseController(ReverseStringService service) {this.service = service;}

    @PostMapping("/reverseString")
    public ResponseEntity reverseString(@RequestBody ReverseStringWrapper reverseRequestBody) {
        return ResponseEntity.ok(service.reverseString(reverseRequestBody.getReversedString()));
    }
}
