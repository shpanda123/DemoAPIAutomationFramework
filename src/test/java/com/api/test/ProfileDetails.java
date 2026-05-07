package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagmentService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;

import io.restassured.response.Response;

public class ProfileDetails {

	
	@Test(description="Get profile deatils of logged in user")
	public void profileDetails(){
		
		AuthService authservice = new AuthService();
		LoginRequest loginrequest = new LoginRequest("uday1234", "uday12345");
		
		Response response = authservice.login(loginrequest);
		
		LoginResponse loginresponse = response.as(LoginResponse.class);
		
		//System.out.println(loginresponse.getToken());
		
		UserProfileManagmentService userprofile = new UserProfileManagmentService();
		
		response = userprofile.getProfile(loginresponse.getToken());
		System.out.println(response.asPrettyString());
		
	}
}
