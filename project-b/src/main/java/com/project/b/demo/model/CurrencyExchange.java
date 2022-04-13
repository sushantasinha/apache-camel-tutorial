package com.project.b.demo.model;

import java.math.BigDecimal;

/*@AllArgsConstructor
@NoArgsConstructor*/
//@ToString
//Lombok Annotation did nto work, so generated getters, setters, constructor etc
//Did not analyse why failing
public class CurrencyExchange {

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