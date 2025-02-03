package com.grocery.app.dto;

import com.grocery.app.model.Product;

public class EntityMapper {

    public static ProductDTO toProductDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setName(product.getName());
        productDTO.setProductCategories(product.getProductCategory());
        return productDTO;
    }
}
