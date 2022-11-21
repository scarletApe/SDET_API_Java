package com.unosquare.requests;

import org.hamcrest.Matchers;
import org.junit.Assert;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unosquare.utils.ApiCore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//import static io.restassured.RestAssured.given;

public class FirstAPITest {
	@Test
	public void validate_200_status() {
		Response response = ApiCore.get_users("/users/2");
		// Assert that correct status code is returned.
		Assert.assertEquals(response.getStatusCode(), 200);
		Reporter.log("Status Code: " + response.getStatusCode());
	}

	@Test
	public void validate_first_and_last_names() {
		Response response = ApiCore.get_users("/users/2");

		response.then().body("data.first_name", Matchers.equalTo("Janet"));
		response.then().body("data.last_name", Matchers.equalTo("Weaver"));
		response.then().body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
		response.then().body("data.avatar", Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"));
		Reporter.log("Status Code: " + response.getStatusCode());
		Reporter.log("Response: " + response.body().asString());
	}

	@Test
	public void validate_first_and_last_names_Gherkin() {
		RestAssured.given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().body("data.'first_name'", Matchers.equalTo("Janet"))
		.assertThat().body("data.'last_name'", Matchers.equalTo("Weaver"))
		.assertThat().body("data.'email'", Matchers.equalTo("janet.weaver@reqres.in"))
		.assertThat().body("data.'avatar'", Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"));
	}

}
