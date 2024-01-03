package com.techden.tdlessons.services.interfaces;

import com.techden.tdlessons.entities.Order;

public interface FreightCalculator {
    Integer calculate(Order order);
}
