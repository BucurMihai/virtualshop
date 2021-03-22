package com.unicredit.mihaibucur.controller.facade.impl;

import com.unicredit.mihaibucur.controller.facade.interfaces.ProductFacade;
import com.unicredit.mihaibucur.service.interfaces.CachePriceService;
import com.unicredit.mihaibucur.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductFacadeImpl implements ProductFacade {

    @Autowired
    ProductService productService;

    @Autowired
    CachePriceService cachePriceService;

    @Override
    public boolean validateBusiness(String productCode) {
       return productService.isValidProduct(productCode) ? true : false;
    }

    @Override
    public BigDecimal getPrice(String productCode) {
        return cachePriceService.getPrice(productCode);
    }
}
