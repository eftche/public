package com.feutche.test.boot.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Server {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Server.class).run(args);
    }
}
