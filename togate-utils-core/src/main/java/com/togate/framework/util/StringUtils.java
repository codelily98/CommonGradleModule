package com.togate.framework.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static String trimToNull(String value) {
        if (isBlank(value)) {
            return null;
        }

        return value.trim();
    }

    public static String defaultIfBlank(
        String value,
        String defaultValue
    ) {
        return isBlank(value)
            ? defaultValue
            : value;
    }

    public static String mask(
        String value,
        int visibleStart,
        int visibleEnd
    ) {
        if (isBlank(value)) {
            return value;
        }

        if (visibleStart + visibleEnd >= value.length()) {
            return "*".repeat(value.length());
        }

        int maskLength =
            value.length() - visibleStart - visibleEnd;

        return value.substring(0, visibleStart)
            + "*".repeat(maskLength)
            + value.substring(value.length() - visibleEnd);
    }
}