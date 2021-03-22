package com.unicredit.mihaibucur.service.interfaces;

import java.math.BigDecimal;

public interface CachePriceService {
    BigDecimal getPrice(String productCode);
}
