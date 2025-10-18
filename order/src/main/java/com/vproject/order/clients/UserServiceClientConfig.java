package com.vproject.order.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import java.util.Optional;

@Configuration
public class UserServiceClientConfig {
    @Bean
    public UserServiceClient userClientInterface(RestClient.Builder restClientBuilder) {
        RestClient restClient = restClientBuilder
                .baseUrl("http://user-service")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (request, response) -> {
                    Optional.empty();
                })
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        UserServiceClient userServiceClient = factory.createClient(UserServiceClient.class);
        return userServiceClient;
    }
}

