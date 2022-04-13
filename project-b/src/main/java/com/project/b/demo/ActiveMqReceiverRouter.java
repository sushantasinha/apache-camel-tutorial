package com.project.b.demo;

import com.project.b.demo.model.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Autowired
    MyClass myClass;

    @Override
    public void configure() throws Exception {
        //uncomment before use
        /*from("activemq:my-active-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                //FOR XML:
                //.unmarshal().jacksonXml(CurrencyExchange.class)
                //Also need to add jackson-xml-starter in pom
                .bean(myClass)
                .to("log:received-message-from-activemq");*/
    }

}

@Slf4j
@Component
class MyClass {
    public void m1() {
        log.info("....................");
    }
}


