package com.unicredit.mihaibucur.model.dao;

import com.unicredit.mihaibucur.model.entity.CachePriceModel;
import com.unicredit.mihaibucur.model.entity.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>{
    public ProductModel findProductModelByCode(String code);
}
