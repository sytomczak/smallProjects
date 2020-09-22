package pl.sytomczak.palindrome.bmicalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConvertController {

    private BmiCalculatorService service;

    @Autowired
    public ConvertController(BmiCalculatorService service) {
        this.service = service;
    }

    @PostMapping("/convertBmi")
    public ResponseEntity convertWeight(@RequestBody ConvertWrapper convertBody) {
        return ResponseEntity.ok(service.checkIfInputsReturnCorrectBmi(convertBody.getConvertHeight(), convertBody.getConvertWeight()));
    }
}
