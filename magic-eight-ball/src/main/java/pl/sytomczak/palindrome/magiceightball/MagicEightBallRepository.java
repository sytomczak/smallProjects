package pl.sytomczak.palindrome.magiceightball;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MagicEightBallRepository {

    private List<MagicEightBallWrapper> sentenceBase = new ArrayList<>();

    public MagicEightBallRepository() {
        this.sentenceBase.add(sentence0);
        this.sentenceBase.add(sentence1);
        this.sentenceBase.add(sentence2);
        this.sentenceBase.add(sentence3);
        this.sentenceBase.add(sentence4);
        this.sentenceBase.add(sentence5);
        this.sentenceBase.add(sentence6);
        this.sentenceBase.add(sentence7);
        this.sentenceBase.add(sentence8);
        this.sentenceBase.add(sentence9);
        this.sentenceBase.add(sentence10);
        this.sentenceBase.add(sentence11);
        this.sentenceBase.add(sentence12);
        this.sentenceBase.add(sentence13);
        this.sentenceBase.add(sentence14);
        this.sentenceBase.add(sentence15);


    }

    public String getSentence(int index) {
        if (index < 0 || index > sentenceBase.size() - 1)
            return sentenceBase.get(0).getSentence();
        else
            return sentenceBase.get(index).getSentence();
    }

    public int getNumberOfSentence() {
        return sentenceBase.size();
    }

    private MagicEightBallWrapper sentence0 = MagicEightBallWrapper.of().index(0).sentence("It is certain.").build();
    private MagicEightBallWrapper sentence1 = MagicEightBallWrapper.of().index(1).sentence("As I see it, yes.").build();
    private MagicEightBallWrapper sentence2 = MagicEightBallWrapper.of().index(2).sentence("It is decidedly so.").build();
    private MagicEightBallWrapper sentence3 = MagicEightBallWrapper.of().index(3).sentence("Most likely.").build();
    private MagicEightBallWrapper sentence4 = MagicEightBallWrapper.of().index(4).sentence("Yes.").build();
    private MagicEightBallWrapper sentence5 = MagicEightBallWrapper.of().index(5).sentence("You may rely on it.").build();
    private MagicEightBallWrapper sentence6 = MagicEightBallWrapper.of().index(6).sentence("Yes - definitely.").build();
    private MagicEightBallWrapper sentence7 = MagicEightBallWrapper.of().index(7).sentence("Reply hazy, try again.").build();
    private MagicEightBallWrapper sentence8 = MagicEightBallWrapper.of().index(8).sentence(" Ask again later.").build();
    private MagicEightBallWrapper sentence9 = MagicEightBallWrapper.of().index(9).sentence("Better not tell you now.").build();
    private MagicEightBallWrapper sentence10 = MagicEightBallWrapper.of().index(10).sentence("Cannot predict now.").build();
    private MagicEightBallWrapper sentence11 = MagicEightBallWrapper.of().index(11).sentence("Concentrate and ask again.").build();
    private MagicEightBallWrapper sentence12 = MagicEightBallWrapper.of().index(12).sentence(" Don't count on it.").build();
    private MagicEightBallWrapper sentence13 = MagicEightBallWrapper.of().index(13).sentence("My reply is no.").build();
    private MagicEightBallWrapper sentence14 = MagicEightBallWrapper.of().index(14).sentence("My sources say no.").build();
    private MagicEightBallWrapper sentence15 = MagicEightBallWrapper.of().index(15).sentence("Outlook not so good.").build();

}
