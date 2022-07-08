package com.eccommerce.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eccommerce.productservice.model.Product;



public interface ProductRepo extends MongoRepository<Product,String> {
@Query("{productCategoryId:?0}")
public List<Product> findByProductCategoryId(String productCategoryId);
}
