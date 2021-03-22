package com.unicredit.mihaibucur.service.impl;

import com.unicredit.mihaibucur.model.dao.CachePriceRepository;
import com.unicredit.mihaibucur.service.interfaces.CachePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CachePriceServiceImpl implements CachePriceService {

    @Autowired
    CachePriceRepository cachePriceRepository;

    @Override
    public BigDecimal getPrice(String productCode) {
        return cachePriceRepository.findByProductCode(productCode).getValue();
    }
}
