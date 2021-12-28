package com.feutche.test.boot.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class Client {
    private final WebClient webClient;

    public Client(String url) {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Flux<ClientMessage> longRunningMethod() {
        return webClient.get().uri("/long-running-method")
                .accept(MediaType.APPLICATION_NDJSON)
                .retrieve()
                .bodyToFlux(ClientMessage.class)
                .log();
    }
}
