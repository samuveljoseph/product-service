package com.eccommerce.productservice.exception;

import java.io.IOException;


import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

public class ErrorController implements ResponseErrorHandler {
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return new DefaultResponseErrorHandler().hasError(response);
	}
	public void handleError(ClientHttpResponse response) throws IOException{
		if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
	   // http status code e.g. `500 INTERNAL_SERVER_ERROR`
	        System.out.println(response.getStatusCode());
	}
}
}
