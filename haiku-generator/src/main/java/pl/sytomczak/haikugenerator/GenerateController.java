package pl.sytomczak.haikugenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenerateController {

    private HaikuGeneratorService service;

    @Autowired
    public GenerateController(HaikuGeneratorService service) {
        this.service = service;
    }

    @GetMapping("/getHaiku")
    public ResponseEntity generateHaiku() {
        return ResponseEntity.ok(service.generateHaiku());
    }
}
