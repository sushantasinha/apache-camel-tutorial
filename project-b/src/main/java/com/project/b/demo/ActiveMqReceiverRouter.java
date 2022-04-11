package com.project.b.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:my-active-queue")
                .to("log:received-message-from-activemq");
    }
}
