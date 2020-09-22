package pl.sytomczak.palindrome.haikugenerator;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HaikuRepository {

    private List<HaikuWrapper> haikuBase = new ArrayList<>();

    public HaikuRepository() {
        this.haikuBase.add(haiku0);
        this.haikuBase.add(haiku1);
        this.haikuBase.add(haiku2);
        this.haikuBase.add(haiku3);
        this.haikuBase.add(haiku4);
        this.haikuBase.add(haiku5);
        this.haikuBase.add(haiku6);
    }

    public String getHaiku(int index) {
        if (index < 0 || index > haikuBase.size() - 1)
            return haikuBase.get(0).getHaiku();
        else
            return haikuBase.get(index).getHaiku();
    }

    public int getNumberOfHaikus() {
        return haikuBase.size();
    }

    private HaikuWrapper haiku0 = HaikuWrapper.of().index(0).haiku("Autumn always brings\n" +
            "Another harvest season\n" +
            "Ripe for the taking").build();
    private HaikuWrapper haiku1 = HaikuWrapper.of().index(1).haiku("Food on the table\n" +
            "Drink poured into every glass\n" +
            "Is this not living?").build();
    private HaikuWrapper haiku2 = HaikuWrapper.of().index(2).haiku("Easy, simple, fast\n" +
            "Is there better happiness\n" +
            "Than fridge leftovers?").build();
    private HaikuWrapper haiku3 = HaikuWrapper.of().index(3).haiku("If you cannot pick\n" +
            "What stares at you from the plate\n" +
            "Cannot be real food").build();
    private HaikuWrapper haiku4 = HaikuWrapper.of().index(4).haiku("Dirt on your fingers\n" +
            "Smell of rain permeating\n" +
            "This is how food grows").build();
    private HaikuWrapper haiku5 = HaikuWrapper.of().index(5).haiku("We were all seeds once\n" +
            "This we share with food we eat\n" +
            "Born from Mother Earth").build();
    private HaikuWrapper haiku6 = HaikuWrapper.of().index(6).haiku("War is waged daily\n" +
            "McDonalds, Burger King\n" +
            "Food battles we fight").build();
}
