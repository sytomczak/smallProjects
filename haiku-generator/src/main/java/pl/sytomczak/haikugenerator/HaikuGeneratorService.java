package pl.sytomczak.haikugenerator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HaikuGeneratorService {

    private HaikuRepository repository;

    @Autowired
    public HaikuGeneratorService(HaikuRepository repository) {
        this.repository = repository;
    }

    public String generateHaiku() {
        int numberOfHaikus = repository.getNumberOfHaikus();
        int indexOfHaikuToGet = new Random().nextInt(numberOfHaikus);
        return repository.getHaiku(indexOfHaikuToGet);
    }
}
