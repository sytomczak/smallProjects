package pl.sytomczak.internettime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

@Service
@Getter
@Setter
public class InternetTimeService {

    private int beats;
    private double now;

    public TimeWrapper generateTime() {

        ZonedDateTime now = ZonedDateTime.now();
        beats = (int) ((now.get(ChronoField.SECOND_OF_MINUTE) + (now.get(ChronoField.MINUTE_OF_HOUR) * 60) + (now.get(ChronoField.HOUR_OF_DAY) * 3600)) / 86.4);
        return TimeWrapper.of().beats(beats).build();
    }
}

