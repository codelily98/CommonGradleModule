package com.togate.sample;

import com.togate.framework.core.error
    .TogateErrorCode;
import com.togate.framework.core.error
    .TogateException;
import com.togate.framework.web.response
    .TogateResponse;
import com.togate.framework.web.response
    .TogateResponseFactory;

import java.util.Map;

import org.springframework.web.bind.annotation
    .GetMapping;
import org.springframework.web.bind.annotation
    .RequestMapping;
import org.springframework.web.bind.annotation
    .RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    private final TogateResponseFactory responseFactory;

    public SampleController(
        TogateResponseFactory responseFactory
    ) {
        this.responseFactory = responseFactory;
    }

    @GetMapping
    public TogateResponse<Map<String, Object>>
        sample() {

        return responseFactory.success(
            Map.of(
                "framework", "TogateFramework",
                "version", "1.0.0"
            )
        );
    }

    @GetMapping("/error")
    public void error() {
        throw new TogateException(
            TogateErrorCode.INVALID_REQUEST,
            "테스트 오류입니다."
        );
    }
}