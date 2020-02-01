package pl.sytomczak.haikugenerator;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class HaikuWrapper {

    private int index;
    private String haiku;
}
