package com.grocery.app.repository;

import com.grocery.app.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {


    ProductCategory findProductCategoryByCategoryId(Long categoryId);
}
