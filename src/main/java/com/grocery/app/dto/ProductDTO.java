package com.grocery.app.dto;

import com.grocery.app.model.ProductCategory;

import java.util.List;

public class ProductDTO {

    private Long productId;

    private String name;

    private Double price;

    private int quantity;

    ProductCategory productCategories;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(ProductCategory productCategories) {
        this.productCategories = productCategories;
    }
}
