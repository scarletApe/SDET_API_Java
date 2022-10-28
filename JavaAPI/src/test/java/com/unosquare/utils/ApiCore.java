package com.unosquare.utils;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiCore {

	public static Response post_user(JSONObject json) {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(json.toString());
		return httpRequest.post("/users");
	}

	public static Response post_user(String filePath) {
		return post_user(JsonUtil.read_json_file(filePath));
	}
	
	public static Response put_user(String filePath,String url) {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(JsonUtil.read_json_file(filePath));
		return httpRequest.put(url);
	}

	public static Response get_users(String url) {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest.get(url);
	}

	public static Response post_login(String filePath, String url) {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(JsonUtil.read_json_file(filePath).toString());
		return httpRequest.post(url);
	}
}
