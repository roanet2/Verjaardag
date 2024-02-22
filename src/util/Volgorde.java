package util;

import model.Verjaardag;

import java.time.LocalDate;
import java.util.Comparator;

public class Volgorde implements Comparator<Verjaardag>{

    public int compare(Verjaardag verjaardag1, Verjaardag verjaardag2) {
        LocalDate volgendeVerjaardaag1 = verjaardag1.getVolgendeVerjaardag();
        LocalDate volgendeVerjaardaag2 = verjaardag2.getVolgendeVerjaardag();
        return volgendeVerjaardaag1.compareTo(volgendeVerjaardaag2);
    }
}

