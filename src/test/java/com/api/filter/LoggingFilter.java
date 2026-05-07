package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
	
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		
		
		return response;
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		
		logger.info("Get Base Uri "+requestSpec.getBaseUri()); 
		logger.info("Get Base Header "+requestSpec.getHeaders()); 
		logger.info("Get Base payload "+requestSpec.getBody()); 
		
	}
public void logResponse(Response response) {
		
		logger.info("Get Status Code  "+response.getStatusCode()); 
		logger.info("Get Base Header "+response.headers()); 
		logger.info("Get Base payload "+response.getBody()); 
		
	}

}
