package com.unicredit.mihaibucur.controller.endpoint;

import com.unicredit.mihaibucur.controller.facade.interfaces.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URISyntaxException;

@RestController
public class ProductsController {

    @Autowired
    ProductFacade productFacade;

    @GetMapping({ "/products" })
    public BigDecimal getPrice(@RequestParam String productCode) throws Exception {
       if(productFacade.validateBusiness(productCode)){
           return productFacade.getPrice(productCode);
       }
       throw new Exception("Price not valid");
    }
}
