package com.eccommerce.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eccommerce.productservice.controller.ProductController;
import com.eccommerce.productservice.model.Product;
import com.eccommerce.productservice.service.ProductService;
import com.eccommerce.productservice.common.ApiResponse;
import com.eccommerce.productservice.common.ProductCategoryDto;

@SpringBootTest
 class ProductControllerTest {
@Mock
ProductService productService;

@InjectMocks
ProductController productController;
@Mock
RestTemplate restTemplate;

@Test
void test_getProducts() {
	List<Product> product=new ArrayList<Product>();
	product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	when(productService.listProduct()).thenReturn(product);
	ResponseEntity<ApiResponse> res=productController.getProducts();
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody().getResponseData());
}
@Test
void test_getProductsById() {
	Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			15999,14999,"123smfd");
	String id="123hdgf";
	when(productService.readProduct(id)).thenReturn(true);
	when(productService.getProductById(id)).thenReturn(product);
	ResponseEntity<Product> res=productController.getProductsById(id);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody());
}
@Test
void test_editProduct() {
	Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			15999,14999,"123smfd");
	String id="123hdgf";
	when(productService.readProduct(id)).thenReturn(true);
	product.setProductName("redmi 10 pro");
	product.setProductDescription("ram 6gb,internal:32gb,camera:8mp");
	product.setImageUrl("https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4");
	product.setPrice(14999);
	product.setDiscountPrice(13999);
	when(productService.editProduct(product)).thenReturn(product);
	ResponseEntity<ApiResponse> res=productController.editProduct(product);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody().getResponseData());
}
@Test
void test_deleteProduct() {
	String id="123hdgf";
	String msg="product is deleted successfully";
	when(productService.readProduct(id)).thenReturn(true);
	productService.deleteProduct(id);
	ResponseEntity<ApiResponse> res=productController.deleteProduct(id);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(msg,res.getBody().getResponseData());
}
@Test
void test_getProductsByproductCategoryId() {
	List<Product> product=new ArrayList<Product>();
	product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	String id="123jgg";
	when(productService.getProductByProductCategoryId(id)).thenReturn(product);
	ResponseEntity<ApiResponse> res=productController.getProductsByproductCategoryId(id);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody().getResponseData());
}
@Test
void test_createProduct() {
	Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			15999,14999,"123smfd");
	ProductCategoryDto productCategoryDto=new ProductCategoryDto();
	ProductCategoryDto productCategoryDto1=new ProductCategoryDto();
	productCategoryDto.setCategoryId("123smfd");
	productCategoryDto.setId("123dg");
	productCategoryDto.setProductCategoryName("electronics");
	productCategoryDto1.setCategoryId(productCategoryDto.getCategoryId());
	productCategoryDto1.setId(productCategoryDto.getId());
	productCategoryDto1.setProductCategoryName(productCategoryDto.getProductCategoryName());
	when(restTemplate.getForObject("http://CATEGORYSERVICE/productcategories/"+product.getProductCategoryId(), ProductCategoryDto.class)==null).thenReturn(true);
	when(productService.createProduct(product)).thenReturn(product);
	ResponseEntity<ApiResponse> res=productController.createProduct(product);
	assertEquals(HttpStatus.CREATED,res.getStatusCode());
	assertEquals(product,res.getBody().getResponseData());
}
@Test
void testFailure_createProduct() {
	Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			15999,14999,"123smfd");
	String msg="category not found!!";
	
	ResponseEntity<ApiResponse> res=productController.createProduct(product);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
	assertEquals(msg,res.getBody().getResponseData());
}
@Test
void testFailure_getProductsById() {
	String id="123hdgf";
	when(productService.readProduct(id)).thenReturn(false);
	ResponseEntity<Product> res=productController.getProductsById(id);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
}
@Test
void testFailure_editProduct() {
	Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			15999,14999,"123smfd");
	String id="123hdgf";
	String msg="product not found";
	when(productService.readProduct(id)).thenReturn(false);
	ResponseEntity<ApiResponse> res=productController.editProduct(product);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
	assertEquals(msg,res.getBody().getResponseData());
}
@Test
void testFailure_deleteProduct() {
	String id="123hdgf";
	String msg="product not found!!";
	when(productService.readProduct(id)).thenReturn(false);
	ResponseEntity<ApiResponse> res=productController.deleteProduct(id);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
	assertEquals(msg,res.getBody().getResponseData());
}
@Test
void test_getProductsByproductCategoryIdFailure() {
	List<Product> product=new ArrayList<Product>();
	product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	String id="123jgg";
	String msg="product category have no product";
	productService.getProductByProductCategoryId(id).isEmpty();
	ResponseEntity<ApiResponse> res=productController.getProductsByproductCategoryId(id);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
	assertEquals(msg,res.getBody().getResponseData());
}
@Test
void test_getProductsFailure() {
	List<Product> product=new ArrayList<Product>();
	product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd"));
	product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
			"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
			1599,1499,"123smfd")); 
	IllegalArgumentException illegalArgumentException=new IllegalArgumentException ();
	when(productService.listProduct()).thenThrow(illegalArgumentException );
	ResponseEntity<ApiResponse> res=productController.getProducts();
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
}
}
