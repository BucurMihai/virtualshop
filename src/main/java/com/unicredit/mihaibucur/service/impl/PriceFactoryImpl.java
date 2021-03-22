package com.unicredit.mihaibucur.service.impl;

import com.unicredit.mihaibucur.model.dao.ProductRepository;
import com.unicredit.mihaibucur.model.entity.CachePriceModel;
import com.unicredit.mihaibucur.model.entity.PriceModel;
import com.unicredit.mihaibucur.service.interfaces.PriceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceFactoryImpl implements PriceFactory {
    @Autowired
    ProductRepository productRepository;



    @Override
    public BigDecimal convertToEUR(BigDecimal value, BigDecimal conversionRate) {
        BigDecimal eur = value.divide(conversionRate, 10, BigDecimal.ROUND_HALF_UP);
        return eur;
    }
}
