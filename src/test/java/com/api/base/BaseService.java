package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filter.LoggingFilter;
import com.api.models.requests.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private final static String BASE_URL = "http://64.227.160.186:8080";
	
	private RequestSpecification requestspecification;
	
	public BaseService() {
		
		
		requestspecification = given().baseUri(BASE_URL);
	}
	
	static {
		
		
		RestAssured.filters(new LoggingFilter());
	}
	
	protected  Response postRequest(Object payload,String endpoint) {
		
		
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
protected  Response putRequest(Object payload,String endpoint) {
		
		
		return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response getRequest(String endpoint) 
	{
		
		return requestspecification.get(BASE_URL);
		
	}
	protected void setToken(String token){
		
		
		requestspecification.header("Authorization","Bearer "+token);
		
	}

}
