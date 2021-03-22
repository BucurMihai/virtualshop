package com.unicredit.mihaibucur.model.dao;

import com.unicredit.mihaibucur.model.entity.CachePriceModel;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<CachePriceModel, Long> {
}
