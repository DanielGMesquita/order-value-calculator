package com.techden.tdlessons.services;

import com.techden.tdlessons.entities.Order;
import com.techden.tdlessons.services.interfaces.FreightCalculator;
import org.springframework.stereotype.Service;

@Service
public class ShippingService implements FreightCalculator {
    @Override
    public Integer calculate(Order order) {
        if (order.getBaseValue() < 100) {
            return 20;
        } else if (order.getBaseValue() < 200) {
            return 12;
        }

        return 0;
    }
}
