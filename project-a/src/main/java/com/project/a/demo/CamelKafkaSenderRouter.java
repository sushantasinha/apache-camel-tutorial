package com.project.a.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelKafkaSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C://input/json/kafka")
                .log("${body}")
                .to("kafka:myKafkaTopic");
    }
}
