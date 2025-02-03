package com.grocery.app.controller;

import com.grocery.app.model.Product;
import com.grocery.app.service.ProductCategoryService;
import com.grocery.app.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final ProductCategoryService productCategoryService;

    public ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }

    /**
     * Gets all items from the database.
     *¯
     * @return a list of all items in the database
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllItems() {
        var items = productService.getAllProducts();
        return ResponseEntity.ok(items);
    }

    /**
     * Saves a new item to the database.
     *
     * @param product the product to be saved
     * @return the saved product
     */
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        if(product.getProductCategory().getCategoryId() != null){
            product.setProductCategory(productCategoryService.getProductCategoryById(product.getProductCategory().getCategoryId()));
        }
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return ResponseEntity.ok(productService.save(product));
    }

    /**
     * Retrieves an item by its ID from the database.
     *
     * @param productId the ID of the item to be retrieved
     * @return a ResponseEntity containing the item if found, or a not found status if the item does not exist
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {

        Optional<Product> item = productService.getProductById(productId);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes an item from the database by its ID.
     *
     * @param productId the ID of the item to be deleted
     * @return a ResponseEntity with no content if the deletion is successful
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates an existing product in the database.
     *
     * @param productId the ID of the product to be updated
     * @param product the updated product
     * @return the updated product
     */
    @PutMapping("/update/{productId}")
    public  ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        productService.saveOrUpdate(productId, product);
        return null;

    }


}
