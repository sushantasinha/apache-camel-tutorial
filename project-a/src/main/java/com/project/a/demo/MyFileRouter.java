package com.project.a.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C:/input")
                .log("${body}") //printing the content of the body
                .to("file:C:/output");
    }
}
