package com.unicredit.mihaibucur.cronjob;

import com.unicredit.mihaibucur.model.dao.CachePriceRepository;
import com.unicredit.mihaibucur.service.interfaces.CronjobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class CachePriceCronjob {

    @Autowired
    CachePriceRepository cachePriceRepository;

    @Autowired
    CronjobService cronjobService;

    @Scheduled(cron = "0 8 * * *")
    public void cachePrices() throws URISyntaxException {
        cachePriceRepository.deleteAll();
        cronjobService.cacheAllPrices();
    }
}
