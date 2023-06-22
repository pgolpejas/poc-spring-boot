package com.pocspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
class TestPocSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.from(PocSpringBootApplication::main).with(TestPocSpringBootApplication.class).run(args);
    }

}
