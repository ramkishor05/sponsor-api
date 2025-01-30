package org.sponsor.account.forgin.config;
import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor bearerAuthRequestInterceptor() {
        return requestTemplate -> {
        	requestTemplate.header("Authorization", ApiTokenContext.getContext().getCurrentToken());
        };
    }
}