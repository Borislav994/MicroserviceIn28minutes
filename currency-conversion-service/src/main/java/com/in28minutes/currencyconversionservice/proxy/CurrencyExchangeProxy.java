package com.in28minutes.currencyconversionservice.proxy;

import com.in28minutes.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyConversion> retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}