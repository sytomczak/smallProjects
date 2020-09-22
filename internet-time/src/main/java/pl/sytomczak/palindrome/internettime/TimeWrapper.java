package pl.sytomczak.palindrome.internettime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class TimeWrapper {
    private int beats;
}
