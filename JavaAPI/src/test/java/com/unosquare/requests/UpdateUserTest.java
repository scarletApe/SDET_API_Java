package com.unosquare.requests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unosquare.utils.ApiCore;

import io.restassured.response.Response;

public class UpdateUserTest {

	@Test
	public void update_user_from_file() {
		Response response = ApiCore.put_user(
				"src/test/resources/Json/Person3.json",
				"/users/2");

		Assert.assertEquals(200, response.statusCode());
		Reporter.log("Status Code " + response.getStatusCode() + "");
		Reporter.log("Response Body: " + response.body().asString());
	}
}
