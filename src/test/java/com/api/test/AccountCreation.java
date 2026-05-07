package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreation {
	@Test(description = "Verify Account is created")
	public void accountCreation() {
		
	SignUpRequest signuprequest=	new SignUpRequest.Builder().firstName("sony").lastName("panda").email("sony123@test.com").mobileNumber("7890789098").password("test123").username("sony123").build();
		
		AuthService authservice = new AuthService();
		
		Response response = authservice.signup(signuprequest);
		
		System.out.println(response.asPrettyString());
		
	}

}
