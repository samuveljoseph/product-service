package com.eccommerce.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.eccommerce.productservice.exception.ProductNotFoundException;
import com.eccommerce.productservice.model.Product;
import com.eccommerce.productservice.repository.ProductRepo;

import com.eccommerce.productservice.serviceimplementation.ProductServiceImplementation;

@SpringBootTest
class ProductserviceApplicationTests {

	@Mock
	ProductRepo productRepo;

	@InjectMocks
	 ProductServiceImplementation productServiceImplementation;
	@Test
	void test_cresteProduct() {
		Product products=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				15999,14999,"123smfd");
		when(productRepo.save(products)).thenReturn(products);
		assertEquals(products,productServiceImplementation.createProduct(products));
	}
	@Test
	@Order(1)
	 void test_listProduct() {
		List<Product> product=new ArrayList<Product>();
		product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				1599,1499,"123smfd"));
		product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				1599,1499,"123smfd"));
		when(productRepo.findAll()).thenReturn(product);//mocking 
		assertEquals(2,productServiceImplementation.listProduct().size());
	}
	@Test
	void test_EditProduct() {
		Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				15999,14999,"123smfd");
		String id="123hdgf";
		when(productRepo.findById(id)).thenReturn(Optional.ofNullable(product));
		product.setProductName("redmi 10 pro");
		product.setProductDescription("ram 6gb,internal:32gb,camera:8mp");
		product.setImageUrl("https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4");
		product.setPrice(14999);
		product.setDiscountPrice(13999);
		when(productRepo.save(product)).thenReturn(product);
		assertEquals(product,productServiceImplementation.editProduct(product));
	}
	@Test
	void test_readProduct() {
		Product product=new Product();
		product.setId("123hdgf");
		product.setProductCategoryId("123smfd");
		product.setProductName("redmi 10 pro");
		product.setProductDescription("ram 6gb,internal:32gb,camera:8mp");
		product.setImageUrl("https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4");
		product.setPrice(14999);
		product.setDiscountPrice(13999);
		when(productRepo.findById("123hdgf")).thenReturn(Optional.ofNullable(product));
		assertEquals(true,productServiceImplementation.readProduct("123hdgf"));
	}
	@Test
	void test_getProductById() {
		Product product=new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				15999,14999,"123smfd");
		
		when(productRepo.findById("123hdgf")).thenReturn(Optional.ofNullable(product));
		assertEquals(product,productServiceImplementation.getProductById("123hdgf"));
	}
	@Test
	void test_getProductByProductCategoryId() {
		List<Product> product=new ArrayList<Product>();
		product.add(new Product("123hdgf","redmi 9 pro","ram 2gb,internal:16gb,camera:16mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				1599,1499,"123smfd"));
		product.add(new Product("123jgg","redmi 10 pro","ram 6gb,internal:32gb,camera:8mp",
				"https://www.google.com/aclk?sa=L&ai=DChcSEwj1nuzttP_3AhWRMysKHVuiA6oYABAJGgJzZg&sig=AOD64_1_oBQTqQFIwgnSHdyuSCnXsdXnNg&adurl&ctype=5&ved=2ahUKEwilntrttP_3AhVsLrcAHfGgAmAQvhd6BAgBEF4",
				1599,1499,"123smfd"));
		String id="123jgg";
		when(productRepo.findByProductCategoryId(id)).thenReturn(product);
		assertEquals(2,productServiceImplementation.getProductByProductCategoryId(id).size());
	}
	@Test
	void test_deleteProduct() {
		String id="123hdgf";
		productServiceImplementation.deleteProduct(id);
		verify(productRepo,times(1)).deleteById(id);
	}


	

}
