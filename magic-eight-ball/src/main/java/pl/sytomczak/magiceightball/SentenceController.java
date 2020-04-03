package pl.sytomczak.magiceightball;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SentenceController {

    private MagicEighBallService service;

    @Autowired
    public SentenceController(MagicEighBallService service) {
        this.service = service;
    }

    @GetMapping("/askMagicBall")
    public ResponseEntity generateSentence() {
        return ResponseEntity.ok(service.generateSentence());
    }
}
