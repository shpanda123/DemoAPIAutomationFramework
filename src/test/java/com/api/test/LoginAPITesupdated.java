package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listners.TestListners.class)
public class LoginAPITesupdated {
	
	@Test
	public void logInTest() {
	AuthService at = new AuthService();
	LoginRequest loginrequest = new LoginRequest("uday1234","uday12345");
	
	Response response = at.login(loginrequest);
	
	System.out.println(response.asPrettyString());
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	LoginResponse  loginresponse = response.as(LoginResponse.class);
	System.out.println(loginresponse.getToken());
	
	Assert.assertEquals(loginresponse.getEmail(), "rahul.sharma03@gmail.com");
	Assert.assertEquals(loginresponse.getUsername(), "uday1234");
	Assert.assertTrue(loginresponse.getToken() != null);
	
	
	}

	
	

}
