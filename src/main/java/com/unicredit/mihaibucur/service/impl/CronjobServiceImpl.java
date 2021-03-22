package com.unicredit.mihaibucur.service.impl;

import com.unicredit.mihaibucur.model.dao.CachePriceRepository;
import com.unicredit.mihaibucur.model.dao.ProductRepository;
import com.unicredit.mihaibucur.model.entity.CachePriceModel;
import com.unicredit.mihaibucur.model.entity.PriceModel;
import com.unicredit.mihaibucur.model.entity.ProductModel;
import com.unicredit.mihaibucur.service.interfaces.CronjobService;
import com.unicredit.mihaibucur.service.interfaces.PriceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CronjobServiceImpl implements CronjobService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CachePriceRepository cachePriceRepository;

    @Autowired
    PriceFactory priceFactory;

    @Override
    public void cacheAllPrices() {
        Iterable<ProductModel> products = productRepository.findAll();
        products.forEach(product -> {
            Optional<PriceModel> priceModel = product.getPriceModels().stream().reduce((first, second) -> second);
            priceModel.ifPresent(priceModelMapper -> {
                priceModelMapper.setValid(true);
                BigDecimal valueConvertedToEUR = priceFactory.convertToEUR(
                        priceModelMapper.getValue(),
                        priceModelMapper.getCurrencyModel().getConversionRate());
                CachePriceModel cachePriceModel = new CachePriceModel(product.getCode(), valueConvertedToEUR);
                cachePriceRepository.save(cachePriceModel);
            });
        });
    }
}
