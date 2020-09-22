package pl.sytomczak.palindrome.randomSentenceGenerator;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Getter
@Setter
public class RandomSentenceGeneratorService {

    private String selectedSentence;

    public RandomSentenceGeneratorService() {
        initializeTheGame();
    }

    private void initializeTheGame() {
        generateSentences();
    }

    public List<String> getAll() {

        List<String> sentence = Lists.newArrayList(
                "It's good day to cheat!",
                "... maybe a small cheat? ;)",
                "Do extra cardio!",
                "Surprise a loved one.",
                "You have already done the macro for tomorrow?",
                "Take care of the dog!",
                "It will be a great day!",
                "Drink more water today",
                "If you bake cookies, cupcakes and meringue tomorrow will be a great day :P",
                "KFC is almost no cheat. A lot of protein will go into the muscles xD"
        );
        return sentence;
    }

    public void generateSentences() {

        List<String> sentence = this.getAll();
        int numberOfSentence = sentence.size();

        Random random = new Random();
        int indexOfSentence = (random.nextInt(numberOfSentence));

        selectedSentence = sentence.get(indexOfSentence);
        System.out.println(getSelectedSentence());
    }

    public void restartTheGame() {
        initializeTheGame();
    }

}