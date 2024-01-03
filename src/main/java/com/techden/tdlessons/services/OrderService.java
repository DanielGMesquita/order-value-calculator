package com.techden.tdlessons.services;

import com.techden.tdlessons.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double calculateOrderFinalValue(Order order) {
        double freight = calculateOrderFreight(order);
        double discount = calculateOrderDiscount(order);
        return order.getBaseValue() - discount + freight;
    }

    private double calculateOrderDiscount(Order order) {
        return order.getBaseValue() * order.getDiscountPercent();
    }

    private double calculateOrderFreight(Order order) {
        return shippingService.calculate(order);
    }
}
