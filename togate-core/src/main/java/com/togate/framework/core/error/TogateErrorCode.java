package com.togate.framework.core.error;

public enum TogateErrorCode
        implements TogateErrorCodeSpec {

    SUCCESS(
        "TG-0000",
        200,
        "정상적으로 처리되었습니다."
    ),

    INVALID_REQUEST(
        "TG-COM-4000",
        400,
        "요청 값이 올바르지 않습니다."
    ),

    UNAUTHORIZED(
        "TG-SEC-4010",
        401,
        "인증이 필요합니다."
    ),

    FORBIDDEN(
        "TG-SEC-4030",
        403,
        "접근 권한이 없습니다."
    ),

    RESOURCE_NOT_FOUND(
        "TG-COM-4040",
        404,
        "요청한 데이터를 찾을 수 없습니다."
    ),

    INTERNAL_SERVER_ERROR(
        "TG-COM-5000",
        500,
        "서버 내부 오류가 발생했습니다."
    );

    private final String code;
    private final int httpStatus;
    private final String message;

    TogateErrorCode(
        String code,
        int httpStatus,
        String message
    ) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public int httpStatus() {
        return httpStatus;
    }

    @Override
    public String message() {
        return message;
    }
}