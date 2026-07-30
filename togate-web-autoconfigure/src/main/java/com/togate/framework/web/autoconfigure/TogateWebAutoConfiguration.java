package com.togate.framework.web.autoconfigure;

import com.togate.framework.web.response
    .TogateResponseFactory;

import java.time.Clock;

import org.springframework.boot.autoconfigure
    .AutoConfiguration;
import org.springframework.boot.autoconfigure.condition
    .ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition
    .ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnWebApplication(
    type = ConditionalOnWebApplication.Type.SERVLET
)
public class TogateWebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    Clock togateClock() {
        return Clock.systemUTC();
    }

    @Bean
    @ConditionalOnMissingBean(
        TogateResponseFactory.class
    )
    DefaultTogateResponseFactory
        togateResponseFactory(
            Clock clock
        ) {

        return new DefaultTogateResponseFactory(clock);
    }

    @Bean
    @ConditionalOnMissingBean
    TogateExceptionHandler togateExceptionHandler(
        TogateResponseFactory responseFactory
    ) {
        return new TogateExceptionHandler(
            responseFactory
        );
    }
}