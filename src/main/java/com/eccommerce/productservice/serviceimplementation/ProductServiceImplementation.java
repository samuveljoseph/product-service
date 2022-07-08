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
		Optional<Product> productData = productRepo.findById(updateProduct.getId());
		Product product = productData.get();
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
		Optional<Product> productData=productRepo.findById(id);
		if(productData.isEmpty()) {
			throw new ProductNotFoundException("product id is invalid");
		}
		return productData.get();
	}
	public List<Product> getProductByProductCategoryId(String productCategoryId){
		return productRepo.findByProductCategoryId(productCategoryId);
		}
}
