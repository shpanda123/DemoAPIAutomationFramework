package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	
	@Test(description="Verify my login API is working as expected")
	public void loginTest() {
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{\"username\": \"uday1234\", \"password\": \"uday12345\"}");
		Response response = z.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 400);
		
	}

}
