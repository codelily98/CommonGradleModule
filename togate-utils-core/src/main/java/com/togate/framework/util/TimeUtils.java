package com.togate.framework.util;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public final class TimeUtils {

    private TimeUtils() {
    }

    public static Instant now(Clock clock) {
        Objects.requireNonNull(clock);
        return clock.instant();
    }

    public static boolean isExpired(
        Instant expiresAt,
        Clock clock
    ) {
        Objects.requireNonNull(expiresAt);
        Objects.requireNonNull(clock);

        return expiresAt.isBefore(clock.instant());
    }

    public static ZonedDateTime toZonedDateTime(
        Instant instant,
        ZoneId zoneId
    ) {
        return instant.atZone(zoneId);
    }
}