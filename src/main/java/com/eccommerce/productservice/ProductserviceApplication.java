package com.eccommerce.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.eccommerce.productservice.exception.ErrorController;


@SpringBootApplication
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.setErrorHandler(new ErrorController());
		return restTemplate;
	}

}
