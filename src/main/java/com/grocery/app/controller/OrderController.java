package com.grocery.app.controller;

import com.grocery.app.dto.EntityMapper;
import com.grocery.app.dto.OrderDTO;
import com.grocery.app.model.Orders;
import com.grocery.app.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody Orders orders) {
        Orders savedOrder = orderService.saveOrder(orders);
        return ResponseEntity.ok(EntityMapper.toOrderDto(savedOrder));
    }
}
