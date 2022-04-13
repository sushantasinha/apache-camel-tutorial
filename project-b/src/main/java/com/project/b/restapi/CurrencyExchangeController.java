package com.project.b.restapi;

import com.project.b.demo.model.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange findConversionValue(
            @PathVariable final String from,
            @PathVariable final String to
    ) {
        return new CurrencyExchange(from, to, new BigDecimal(10));
    }
}
