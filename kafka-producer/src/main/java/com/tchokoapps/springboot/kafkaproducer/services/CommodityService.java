package com.tchokoapps.springboot.kafkaproducer.services;

import com.tchokoapps.springboot.kafkaproducer.entities.Commodity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommodityService {

    private static final Map<String, Commodity>  COMMODITY_MAP = new HashMap<>();
    private static final String COPPER = "copper";
    private static final String GOLD = "gold";
    private static final double MAX_ADJUSTEMENT = 1.05;
    private static final double MIN_ADJUSTEMENT = 0.95;

    static {
        long timestamp = System.currentTimeMillis();
        COMMODITY_MAP.put(GOLD,new Commodity(GOLD,1_407.25,"ounce",timestamp ));
        COMMODITY_MAP.put(GOLD,new Commodity(COPPER,5_900.57,"tonne",timestamp ));
    }
}
