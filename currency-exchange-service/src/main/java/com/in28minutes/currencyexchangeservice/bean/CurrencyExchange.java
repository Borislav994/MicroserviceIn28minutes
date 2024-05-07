package com.in28minutes.currencyexchangeservice.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_currency")
    private String from;
    @Column(name = "to_currency")
    private String to;
    private BigDecimal conversionMultiple;
    // ova varijabla ce da nam sluzi da pratiomo koju istancu currnecy exchange pozivamo pomocu load balancera
    private String environment;

}
