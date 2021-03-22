package com.unicredit.mihaibucur.model.dao;

import com.unicredit.mihaibucur.model.entity.CachePriceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CachePriceRepository extends CrudRepository<CachePriceModel, Long> {
    public CachePriceModel findByProductCode(String productCode);
}
