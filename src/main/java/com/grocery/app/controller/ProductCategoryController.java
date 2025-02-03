package com.grocery.app.controller;

import com.grocery.app.model.ProductCategory;
import com.grocery.app.service.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }


    /**
     * Returns a list of all product categories in the database.
     *
     * @return a ResponseEntity containing a list of all product categories
     */
    @GetMapping("/all")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        List<ProductCategory> allCategories = productCategoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    /**
     * Saves a product category to the database. Before saving, it checks if a category with the same name already exists. If it does, it returns a 400 Bad Request response.
     *
     * @param productCategory the product category to be saved
     * @return a ResponseEntity containing the saved product category
     */
    @PostMapping
    public ResponseEntity<ProductCategory> saveCategory(@RequestBody ProductCategory productCategory) {
        // Check if a product category with the same name already exists
        Optional<ProductCategory> existingCategory = productCategoryService.getAllCategories().stream()
                .filter(category -> category.getCategoryName().equals(productCategory.getCategoryName()))
                .findFirst();

        if (existingCategory.isPresent()) {
            // Return a bad request if the category already exists
            return ResponseEntity.badRequest().build();
        }

        // Save the product category
        ProductCategory savedCategory = productCategoryService.saveCategory(productCategory);

        // Return the saved product category
        return ResponseEntity.ok(savedCategory);
    }

}
