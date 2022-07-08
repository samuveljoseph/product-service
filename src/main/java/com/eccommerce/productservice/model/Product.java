package com.eccommerce.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String id;
	private String productName;
	private String productDescription;
	private String imageUrl;
	private double price;
	private double discountPrice;
	private String productCategoryId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Product(String id, String productName, String productDescription, String imageUrl, double price,
			double discountPrice, String productCategoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.imageUrl = imageUrl;
		this.price = price;
		this.discountPrice = discountPrice;
		this.productCategoryId = productCategoryId;
	}
	public Product() {
		super();
	}
}
