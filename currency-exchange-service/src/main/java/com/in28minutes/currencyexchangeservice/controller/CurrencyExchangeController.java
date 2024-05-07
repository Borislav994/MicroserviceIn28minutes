package com.in28minutes.currencyexchangeservice.controller;

import com.in28minutes.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.currencyexchangeservice.service.CurrencyExchangeService;
import jakarta.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired // ovo koristimo jer @Value dobija vrednost samo kada se pravi bean
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchageService;

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        String port = environment.getProperty("local.server.port");

        logger.info("Retrieving exchange value from {} to {}", from, to);

        try {
            CurrencyExchange ce = currencyExchageService.findByFromAndTo(from, to);
            ce.setEnvironment(port);
            return ResponseEntity.ok(ce);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
