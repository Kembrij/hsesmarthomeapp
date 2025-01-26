package ru.kembrij.smarthomeapi.util;

import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@UtilityClass
public final class TimeUtil {

    public static String getFormattedZonedDateTime(TemporalAccessor temporalAccessor) {
        return DateTimeFormatter.ISO_INSTANT.format(temporalAccessor);
    }

    public static String getFormattedLocalDate(TemporalAccessor temporalAccessor) {
        return DateTimeFormatter.ISO_DATE.format(temporalAccessor);
    }

}
