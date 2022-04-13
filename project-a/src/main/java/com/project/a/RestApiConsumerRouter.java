package com.project.a;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.RestConfiguration;
import org.springframework.stereotype.Component;

@Component
public class RestApiConsumerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(9002);
        from("timer:rest-api-consumer?period=10000")
                .log(".............")
                .setHeader("from", () -> "USD")
                .setHeader("to", () -> "INR")
                .to("rest:get:/currency-exchange/from/{from}/to/{to}")
        .log("${body}")
        ;
    }
}
