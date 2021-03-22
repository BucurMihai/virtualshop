package com.unicredit.mihaibucur.service.interfaces;

import java.math.BigDecimal;


public interface PriceFactory {
    BigDecimal convertToEUR(BigDecimal value, BigDecimal conversionRate);
}
