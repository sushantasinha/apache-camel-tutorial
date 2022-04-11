package com.project.a.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer>period=10000")
                .transform().constant("My activeMQ Message")
                .log("${body}")
                .to("activemq:my-active-queue");
    }
}
