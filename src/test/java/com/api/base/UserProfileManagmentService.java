package com.api.base;

import com.api.models.requests.LoginRequest;

import io.restassured.response.Response;

public class UserProfileManagmentService extends BaseService {

	private static final String BASE_PATH = "/api/users/";

	public Response getProfile(String token) {
		setToken(token);
		return getRequest(BASE_PATH + "profile");

	}

	public Response updateProfile(Object payload,String token) {
		setToken(token);
		return putRequest(payload, BASE_PATH + "profile");

	}

}
