package com.eccommerce.productservice.service;

import java.util.List;


import com.eccommerce.productservice.model.Product;


public interface ProductService {
	public Product createProduct(Product product);
	public List<Product> listProduct();
	public Product editProduct(Product updateProduct);
	public boolean readProduct(String id);
	public void deleteProduct(String id);
	public Product getProductById(String id);
	public List<Product> getProductByProductCategoryId(String productCategoryId);
}
