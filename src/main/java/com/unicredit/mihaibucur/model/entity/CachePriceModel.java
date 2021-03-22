package com.unicredit.mihaibucur.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cachedprices")
public class CachePriceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productCode;
    private BigDecimal value;

    public CachePriceModel(String code, BigDecimal valueConvertedToEUR) {
        this.productCode = code;
        this.value = valueConvertedToEUR;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
