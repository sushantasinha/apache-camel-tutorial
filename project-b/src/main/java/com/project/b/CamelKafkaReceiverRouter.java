package com.project.b;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CamelKafkaReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopic")
                .to("log:received-message-from-kafka");
    }

}


