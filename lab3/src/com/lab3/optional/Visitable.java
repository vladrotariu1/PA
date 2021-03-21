package com.lab3.optional;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningHour();
    LocalTime getClosingHour();

    default LocalTime openingHour() {
        return LocalTime.of(9, 30);
    }

    default LocalTime closingHour() {
        return LocalTime.of(20,  0);
    }

    static Duration getVisitingDuration(Location location) {
        if (location instanceof Visitable) {
            return Duration.between(((Visitable) location).getOpeningHour(), ((Visitable) location).getClosingHour());
        } else {
            throw new ClassCastException ("Not a visitable object");
        }
    }
}
