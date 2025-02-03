package com.grocery.app.service;

import com.grocery.app.model.ProductCategory;
import com.grocery.app.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    /**
     * Gets all product categories from the database.
     *
     * @return a list of all categories in the database
     */
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    /**
     * Saves a product category to the database.
     *
     * @param productCategory the category to be saved
     * @return the saved category
     */
    public ProductCategory saveCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
