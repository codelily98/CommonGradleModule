package com.togate.framework.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public final class DateUtils {

    private DateUtils() {
    }

    public static LocalDate parse(
        String value,
        DateTimeFormatter formatter
    ) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(formatter);

        return LocalDate.parse(value, formatter);
    }

    public static String format(
        LocalDate value,
        DateTimeFormatter formatter
    ) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(formatter);

        return value.format(formatter);
    }

    public static long daysBetween(
        LocalDate start,
        LocalDate end
    ) {
        return ChronoUnit.DAYS.between(start, end);
    }

    public static LocalDate firstDayOfMonth(
        LocalDate value
    ) {
        return value.withDayOfMonth(1);
    }

    public static LocalDate lastDayOfMonth(
        LocalDate value
    ) {
        return value.withDayOfMonth(
            value.lengthOfMonth()
        );
    }
}