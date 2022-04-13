package com.project.a.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {
   /* @Override
    public void configure() throws Exception {
        from("file:C:/input")
                .routeId("Files-Input-Route")
                .log("${body}") //printing the content of the body
                .to("file:C:/output");
    }*/

    //choice() and Simple Language
    @Override
    public void configure() throws Exception {
        from("file:C:/input")
                .routeId("Files-Input-Route")
                .choice()
                    .when(simple("${file:ext} ends with 'xml'"))//simple language
                    //.when(simple(${file:ext} == 'xml'")
                        .log("XML File")
                    .when(simple("${body} contains 'INR'"))//simple language
                        .log("JSON File and contains INR")
                    .otherwise()
                        .log("NOT XML or JSON file")
                .end()
                .log("${body}") //printing the content of the body
                .log("${messageHistory}")//entire message details incl. headers will be printed
                //.log("${messageHistory} ${headers}")//All headers will be printed
                //.log("${messageHistory} ${headers.CamelFileAbsolutePath}")//specific headers will be printed
                //.log("${messageHistory} ${file.absolute.path}")//same result as line 32 (previous line)
                .to("file:C:/output");
    }
}
