package pl.sytomczak.palindrome.magiceightball;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class MagicEightBallWrapper {

    private int index;
    private String sentence;
}
