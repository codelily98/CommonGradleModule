package com.togate.framework.web.response;

import com.togate.framework.core.error
    .TogateErrorCodeSpec;

import java.util.Map;

public interface TogateResponseFactory {

    <T> TogateResponse<T> success(T data);

    TogateResponse<Void> failure(
        TogateErrorCodeSpec errorCode,
        String message,
        Map<String, Object> details
    );
}