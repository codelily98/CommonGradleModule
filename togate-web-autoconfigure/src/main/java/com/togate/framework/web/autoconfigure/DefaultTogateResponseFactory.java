package com.togate.framework.web.autoconfigure;

import com.togate.framework.core.error
    .TogateErrorCode;
import com.togate.framework.core.error
    .TogateErrorCodeSpec;
import com.togate.framework.web.response
    .TogateResponse;
import com.togate.framework.web.response
    .TogateResponseFactory;

import java.time.Clock;
import java.util.Map;

public class DefaultTogateResponseFactory
        implements TogateResponseFactory {

    private final Clock clock;

    public DefaultTogateResponseFactory(Clock clock) {
        this.clock = clock;
    }

    @Override
    public <T> TogateResponse<T> success(T data) {
        return new TogateResponse<>(
            true,
            TogateErrorCode.SUCCESS.code(),
            TogateErrorCode.SUCCESS.message(),
            data,
            Map.of(),
            clock.instant()
        );
    }

    @Override
    public TogateResponse<Void> failure(
        TogateErrorCodeSpec errorCode,
        String message,
        Map<String, Object> details
    ) {
        return new TogateResponse<>(
            false,
            errorCode.code(),
            message,
            null,
            details == null ? Map.of() : details,
            clock.instant()
        );
    }
}