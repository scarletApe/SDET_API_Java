package com.unosquare.requests;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unosquare.utils.ApiCore;

import io.restassured.response.Response;

public class PostTest {

	@SuppressWarnings("unchecked")
	@Test
	public void post_user() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "JohnAPI");
		jsonObj.put("job", "QA");
		Response response = ApiCore.post_user(jsonObj);

		Assert.assertEquals(201, response.statusCode());
		Reporter.log("Status Code " + response.getStatusCode() + "");
		Reporter.log("Response Body: " + response.body().asString());
	}

	@Test
	public void post_user_from_file() {
		Response response = ApiCore.post_user("src/test/resources/Json/Person1.json");

		Assert.assertEquals(201, response.statusCode());
		Reporter.log("Status Code " + response.getStatusCode() + "");
		Reporter.log("Response Body: " + response.body().asString());
	}

	@Test
	public void post_user_from_file2() {
		Response response = ApiCore.post_user("src/test/resources/Json/Person2.json");

		Assert.assertEquals(201, response.statusCode());
		Reporter.log("Status Code " + response.getStatusCode() + "");
		Reporter.log("Response Body: " + response.body().asString());
	}

}
