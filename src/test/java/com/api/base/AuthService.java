package com.api.base;

import com.api.models.requests.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH = "/api/auth/";
	
	public  Response login(Object payload) {
		
	return	postRequest(payload,BASE_PATH+"login");
		
		
	}
	
	public  Response signup(Object payload) {
		
		return	postRequest(payload,BASE_PATH+"signup");
			
			
		}
	
	

}
