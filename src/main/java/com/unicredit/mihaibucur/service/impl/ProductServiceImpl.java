package com.unicredit.mihaibucur.service.impl;

import com.unicredit.mihaibucur.service.interfaces.PriceService;
import com.unicredit.mihaibucur.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    PriceService priceService;

    @Override
    public boolean isValidProduct(String productCode) {
        return priceService.isLastPriceValid(productCode);
    }
}
