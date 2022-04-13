package com.project.a.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Header;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyFileRouterV2 extends RouteBuilder {

    @Autowired
    private DeciderBean deciderBean;

    @Override
    public void configure() throws Exception {
        from("file:C:/input/123")
                .routeId("Files-Input-Route")
                .choice()
                .when(method(deciderBean))//simple language
                    .log("XML File")
                .to("file:C:/output");
    }

}


@Slf4j
@Component
class DeciderBean {
    /*public boolean isThisConditionMey(String body) {
        log.info("Inside DeciderBean.isThisConditionMey()");
        return true;
    }*/


   /* public boolean isThisConditionMey(@Body String body,
                                      @Headers Map<String, String> headers) {
        //can pass specific header as well
        // @Header("...) String header)
        log.info("Inside DeciderBean.isThisConditionMey(): BODY {} ...... HEADERS {}", body, headers);
        return true;
    }*/

    public boolean isThisConditionMey(@Body String body,
                                      @Headers Map<String, String> headers,
                                      @ExchangeProperties Map<String, String> exchangeProperties) {
        //can pass specific header as well
        // @Header("...) String header)
        log.info("Inside DeciderBean.isThisConditionMey(): EXCHANGE_PROPERTIES {} ", exchangeProperties);
        return true;
    }

}
