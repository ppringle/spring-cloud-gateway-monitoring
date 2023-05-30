package com.example.gateway.config;

import com.example.gateway.domain.Greeting;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("modify_request_body", r -> r.path("/post/**")
                        .filters(f -> f.modifyRequestBody(
                                String.class, Greeting.class, MediaType.APPLICATION_JSON_VALUE,
                                (exchange, s) -> Mono.just(new Greeting(s.toUpperCase()))))
                        .uri("https://httpbin.org"))
                .build();
    }

}
