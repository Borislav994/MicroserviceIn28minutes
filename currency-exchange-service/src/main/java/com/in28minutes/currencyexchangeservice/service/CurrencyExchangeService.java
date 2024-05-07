package com.in28minutes.currencyexchangeservice.service;

import com.in28minutes.currencyexchangeservice.bean.CurrencyExchange;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyExchangeService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CurrencyExchange> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM CURRENCY_EXCHANGE", CurrencyExchange.class).getResultList();
    }

    public CurrencyExchange findById(long id) {
        return entityManager.find(CurrencyExchange.class, id);
    }

    public CurrencyExchange findByFromAndTo(String from, String to) {
        return (CurrencyExchange) entityManager.createNativeQuery(
                        "SELECT * FROM CURRENCY_EXCHANGE WHERE FROM_CURRENCY = :from AND TO_CURRENCY = :to", CurrencyExchange.class)
                .setParameter("from", from)
                .setParameter("to", to)
                .getSingleResult();
    }

}
