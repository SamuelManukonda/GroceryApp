package com.grocery.app.dto;

import com.grocery.app.model.OrderProduct;
import com.grocery.app.model.Product;
import com.grocery.app.model.User;

import java.util.List;

public class OrderRequestDTO {

    private User user;
    private List<OrderProduct> orderProducts;
    private Double totalAmount;

}
