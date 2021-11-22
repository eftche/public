package org.eftche.test.boot.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActiveProfilesTest.App.class)
@ActiveProfiles("foo")
public class ActiveProfilesTest {
    @Autowired
    private Environment environment;

    @Test
    public void testActiveProfiles() {
        assertArrayEquals(new String[]{"foo"}, environment.getActiveProfiles());
        assertEquals("foo", environment.getProperty("my-active-profiles"));
    }

    @SpringBootApplication
    public static class App {
        public static void main(String[] args) {
            new SpringApplicationBuilder(App.class).run(args);
        }
    }

    public static class ProfilePostProcessor implements EnvironmentPostProcessor, Ordered {
        @Override
        public int getOrder() {
            return ConfigDataEnvironmentPostProcessor.ORDER - 1;
        }

        @Override
        public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication application) {
            env.getPropertySources().addFirst(new MapPropertySource("ProfilePostProcessor",
                    Map.of("my-active-profiles", env.getActiveProfiles())));
        }
    }
}
