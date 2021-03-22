package com.unicredit.mihaibucur.controller.facade.interfaces;

import java.math.BigDecimal;

public interface ProductFacade {
    boolean validateBusiness(String productCode);

    BigDecimal getPrice(String productCode);
}
