package com.togate.framework.core.error;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class TogateException extends RuntimeException {

    private final TogateErrorCodeSpec errorCode;
    private final Map<String, Object> details;

    public TogateException(
        TogateErrorCodeSpec errorCode
    ) {
        this(
            errorCode,
            errorCode.message(),
            Collections.emptyMap(),
            null
        );
    }

    public TogateException(
        TogateErrorCodeSpec errorCode,
        String message
    ) {
        this(
            errorCode,
            message,
            Collections.emptyMap(),
            null
        );
    }

    public TogateException(
        TogateErrorCodeSpec errorCode,
        Throwable cause
    ) {
        this(
            errorCode,
            errorCode.message(),
            Collections.emptyMap(),
            cause
        );
    }

    public TogateException(
        TogateErrorCodeSpec errorCode,
        String message,
        Map<String, Object> details,
        Throwable cause
    ) {
        super(message, cause);

        this.errorCode =
            Objects.requireNonNull(errorCode);

        this.details = details == null
            ? Collections.emptyMap()
            : Map.copyOf(details);
    }

    public TogateErrorCodeSpec getErrorCode() {
        return errorCode;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}