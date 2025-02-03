package com.grocery.app.dto;

import com.grocery.app.model.Orders;
import com.grocery.app.model.Product;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.Order;

public class EntityMapper {

    public static ProductDTO toProductDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setName(product.getName());
        productDTO.setProductCategories(product.getProductCategory());
        return productDTO;
    }

    public static OrderDTO toOrderDto(Orders savedOrder) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(savedOrder.getOrderId());
        orderDTO.setOrderDateTime(savedOrder.getOrderDate());
        orderDTO.setAmountPaid(savedOrder.getTotalAmount());
        return orderDTO;
    }
}
