package com.project.a.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

//@Component: Need to uncomment to test it **********************************************************
public class MyFirstTimerRoute extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLogComponent simpleLogComponent;

    @Override
    public void configure() throws Exception {
        //timer -> transformation -> log
        from("timer:first-timer")//timer is keyword, like scheduler. "first-timer" is name of the timer. Generating null message every seconds
                //.transform().constant("My Constant Message. Time now:" + LocalTime.now())
                //.bean("getCurrentTimeBean")
                //.bean(getCurrentTimeBean, "getCurrentTime")//If one method the method name is optional, but in case of multiple methods present under bean, then need to specify the method name.
                //.bean(simpleLogComponent)
                .process(new SimplLogProcessor())
                .to("log:first-timer");//log is keyword

        //If we are affecting the body of the message, those are transformation, otherwise it is processing
    }
}

@Slf4j
class SimplLogProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("In class...");
    }
}

@Component
class GetCurrentTimeBean {

    public String getCurrentTime() {
        return "Time is: " + LocalTime.now();
    }
}


@Component
@Slf4j
class SimpleLogComponent {
    public void process(final String message) {
        log.info("message is: {}", message);
    }
}
