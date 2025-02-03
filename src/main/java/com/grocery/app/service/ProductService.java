package com.grocery.app.service;


import com.grocery.app.model.Product;
import com.grocery.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {

        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public void saveOrUpdate(Long productId, Product product) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if(existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setProductCategory(product.getProductCategory());
            p.setQuantity(product.getQuantity());
            p.setUpdatedAt(LocalDateTime.now());
            productRepository.save(p);
        }
    }
}
