package com.togate.framework.core.error;

public interface TogateErrorCodeSpec {

    String code();

    int httpStatus();

    String message();
}