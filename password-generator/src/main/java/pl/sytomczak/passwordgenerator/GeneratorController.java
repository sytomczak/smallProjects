package pl.sytomczak.passwordgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneratorController {

    @Autowired
    private PasswordGeneratorService service;

    @GetMapping("/getPassword/{passwordLength}")
    public ResponseEntity getPassword(@PathVariable PasswordLength passwordLength) {
        PasswordWrapper responseBody = service.generatePassword(passwordLength);
        return ResponseEntity.ok(responseBody);
    }
}
