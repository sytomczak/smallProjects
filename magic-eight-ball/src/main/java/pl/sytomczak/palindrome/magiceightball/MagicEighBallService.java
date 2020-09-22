package pl.sytomczak.palindrome.magiceightball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MagicEighBallService {

    private MagicEightBallRepository repository;

    @Autowired
    public MagicEighBallService(MagicEightBallRepository repository) {
        this.repository = repository;
    }

    public String generateSentence() {
        int numberOfSentene = repository.getNumberOfSentence();
        int indexOfSentenceToGet = new Random().nextInt(numberOfSentene);
        return repository.getSentence(indexOfSentenceToGet);
    }
}
