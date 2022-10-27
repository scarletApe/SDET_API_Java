package com.unosquare.requests;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unosquare.utils.JsonUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTest {

	@SuppressWarnings("unchecked")
	@Test
	public void post_test() {

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "JohnAPI");
		requestParams.put("job", "QA");

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post("/users");

		Reporter.log(requestParams.toString());
		Reporter.log(response.body().asString());
	}

	@Test
	public void post_test_from_file() {

		JSONObject requestParams = JsonUtil.read_json_file("src/test/resources/Json/Person1.json");

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post("/users");
		
		Reporter.log("Status Code "+response.getStatusCode()+"");
		Reporter.log("Response Body: "+response.body().asString());
		Reporter.log("Json sent: "+requestParams.toString());
		Reporter.log("URL: https://reqres.in/api/users");
	}

	@Test
	public void post_test_from_file2() {

		JSONObject requestParams = JsonUtil.read_json_file("src/test/resources/Json/Person2.json");

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post("/users");

		Reporter.log("Status Code "+response.getStatusCode()+"");
		Reporter.log("Response Body: "+response.body().asString());
		Reporter.log("Json sent: "+requestParams.toString());
		Reporter.log("URL: https://reqres.in/api/users");
	}

}
