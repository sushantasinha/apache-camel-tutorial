package com.project.b.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    @Autowired
    MyClass myClass;

    @Override
    public void configure() throws Exception {
        from("activemq:my-active-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                //FOR XML:
                //.unmarshal().jacksonXml(CurrencyExchange.class)
                //Also need to add jackson-xml-starter in pom
                .bean(myClass)
                .to("log:received-message-from-activemq");
    }

}

@Slf4j
@Component
class MyClass {
    public void m1() {
        log.info("....................");
    }
}

/*@AllArgsConstructor
@NoArgsConstructor*/
//@ToString
//Lombok Annotation did nto work, so generated getters, setters, constructor etc
//Did not analyse why failing
class CurrencyExchange {

    public CurrencyExchange() {

    }

    public CurrencyExchange(String from, String to, BigDecimal conversionRate) {
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    private String from;
    private String to;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    private BigDecimal conversionRate;

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }
}
