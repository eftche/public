package com.feutche.test.boot.server;

import com.feutche.test.boot.client.Client;
import com.feutche.test.boot.client.ClientMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Server.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LongRunningRequestTest {

    @LocalServerPort
    public int port;

    @Test
    public void testLongRunningRequest() {
        Client client = new Client("http://127.0.0.1:" + port);
        Flux<ClientMessage> flux = client.longRunningMethod();
        Duration duration = StepVerifier.create(flux)
                .expectSubscription()
                .expectNextCount(620)
                .thenCancel()
                .verify();
        System.out.println("duration = " + duration);
    }
}
