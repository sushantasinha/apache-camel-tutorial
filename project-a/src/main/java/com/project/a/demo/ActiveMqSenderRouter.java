package com.project.a.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //Uncomment to test
       /* from("timer:active-mq-timer>period=10000")
                .transform().constant("My activeMQ Message")
                .log("${body}")
                .to("activemq:my-active-queue");*/


        //Now pick files from local and send to activemq
        ///This will moved .camel folder under, after processing, under "C://input/json", where we could see all processed files.
        from("file:C://input/json")
                .log("${body}")
                .to("activemq:my-active-queue");

    }
}
