package com.feutche.test.boot.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ServerController {
    @GetMapping(value = "/long-running-method", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<ServerMessage> longRunningMethod() {
        return Flux.interval(Duration.ofMillis(1)).map(n -> new ServerMessage("Message " + n)).log();
    }
}
