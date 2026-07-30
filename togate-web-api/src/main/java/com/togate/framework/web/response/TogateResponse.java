package com.togate.framework.web.response;

import java.time.Instant;
import java.util.Map;

public record TogateResponse<T>(
    boolean success,
    String code,
    String message,
    T data,
    Map<String, Object> details,
    Instant timestamp
) {
}