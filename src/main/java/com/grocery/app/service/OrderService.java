package com.grocery.app.service;

import com.grocery.app.model.Orders;
import com.grocery.app.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders saveOrder(Orders orders) {
        return  orderRepository.save(orders);
    }
}
