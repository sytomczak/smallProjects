package pl.sytomczak.bmicalculator;

import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
public class ConvertWrapper {
    private Integer convertWeight;
    private Integer convertHeight;

    public Integer getConvertWeight() {
        return convertWeight;
    }

    public Integer getConvertHeight() {
        return convertHeight;
    }

}
