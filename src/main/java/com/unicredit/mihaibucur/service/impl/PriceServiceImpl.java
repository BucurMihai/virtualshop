package com.unicredit.mihaibucur.service.impl;

import com.unicredit.mihaibucur.model.dao.ProductRepository;
import com.unicredit.mihaibucur.model.entity.PriceModel;
import com.unicredit.mihaibucur.model.entity.ProductModel;
import com.unicredit.mihaibucur.service.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    ProductRepository productDao;

    @Override
    public boolean isLastPriceValid(String productCode) {
        ProductModel productModel = productDao.findProductModelByCode(productCode);
        PriceModel priceModel = productModel.getPriceModels().get(productModel.getPriceModels().size() - 1);
        return priceModel.getValid();
    }
}
