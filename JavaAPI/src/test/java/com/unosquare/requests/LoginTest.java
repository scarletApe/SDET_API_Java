package com.unosquare.requests;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unosquare.utils.ApiCore;

import io.restassured.response.Response;

public class LoginTest {

	@Test
	public void post_test_from_file2() {
		Response response = ApiCore.post_login(
				"src/test/resources/Json/Register.json",
				"/login");

		Assert.assertEquals(200, response.statusCode());
		Reporter.log("Status Code " + response.getStatusCode() + "");
		Reporter.log("Response Body: " + response.body().asString());
	}
}
