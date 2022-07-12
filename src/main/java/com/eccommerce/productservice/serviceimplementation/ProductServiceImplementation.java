package com.eccommerce.productservice.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.eccommerce.productservice.exception.ProductNotFoundException;
import com.eccommerce.productservice.model.Product;
import com.eccommerce.productservice.repository.ProductRepo;
import com.eccommerce.productservice.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	ProductRepo productRepo;
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	public List<Product> listProduct(){
		return productRepo.findAll();
	}
	public Product editProduct(Product updateProduct) {
		Product product =  productRepo.findById(updateProduct.getId()).get();
		product.setProductName(updateProduct.getProductName());
		product.setProductDescription(updateProduct.getProductDescription());
		product.setImageUrl(updateProduct.getImageUrl());
		product.setPrice(updateProduct.getPrice());
		product.setDiscountPrice(updateProduct.getDiscountPrice());
		return productRepo.save(product);
	}
	public boolean readProduct(String id) {
		return productRepo.findById(id).isPresent();
	}
	public void deleteProduct(String id) {
		productRepo.deleteById(id);
	}
	public Product getProductById(String id){
		if(productRepo.findById(id).isEmpty()) {
			throw new ProductNotFoundException("product id is invalid");
		}
		return productRepo.findById(id).get();
	}
	public List<Product> getProductByProductCategoryId(String productCategoryId){
		return productRepo.findByProductCategoryId(productCategoryId);
		}
}
