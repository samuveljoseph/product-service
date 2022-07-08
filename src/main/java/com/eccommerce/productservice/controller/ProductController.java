package com.eccommerce.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eccommerce.productservice.common.ApiResponse;
import com.eccommerce.productservice.common.ProductCategoryDto;
import com.eccommerce.productservice.model.Product;
import com.eccommerce.productservice.service.ProductService;




@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	RestTemplate restTemplate;
	@PostMapping("/products")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product){
		try {
			if(restTemplate.getForObject("http://CATEGORYSERVICE/productcategories/"+product.getProductCategoryId(), ProductCategoryDto.class)==null){
				throw new IllegalArgumentException("category not found!!" );
			}
			return new ResponseEntity<>(new ApiResponse(true,productService.createProduct(product)),HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/products")
	public ResponseEntity<ApiResponse> getProducts(){
		try {
			return new ResponseEntity<>(new ApiResponse(true,productService.listProduct()),HttpStatus.OK);
		}		catch(IllegalArgumentException e) {
			return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductsById(@PathVariable("productId") String productId){
		try {
			if(!productService.readProduct(productId)) {
				throw new IllegalArgumentException("product not found!" );
			}
			return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
			
		}catch(IllegalArgumentException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	@PutMapping("/products")
	public ResponseEntity<ApiResponse> editProduct(@RequestBody Product product){
		try {
			if(!productService.readProduct(product.getId())) {
				throw new IllegalArgumentException("product not found" );
			}
			return new ResponseEntity<>(new ApiResponse(true,productService.editProduct(product)),HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
			}
	}
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") String productId){
		try {
			if(!productService.readProduct(productId)) {
				throw new IllegalArgumentException("product not found!!" );
			}
			productService.deleteProduct(productId);
			return new ResponseEntity<>(new ApiResponse(true,"product is deleted successfully"),HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
			}
	}
	@GetMapping("/product/{productCategoryId}")
	public ResponseEntity<ApiResponse> getProductsByproductCategoryId(@PathVariable("productCategoryId") String productCategoryId){
		try {
			if(productService.getProductByProductCategoryId(productCategoryId).isEmpty()) {
				throw new IllegalArgumentException("product category have no product" );
			}
			return new ResponseEntity<>(new ApiResponse(true,productService.getProductByProductCategoryId(productCategoryId)),HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
			}
	}
	
}

