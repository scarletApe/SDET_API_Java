package com.unosquare.requests;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import static io.restassured.RestAssured.given;

public class FirstAPITest {
	@Test
	public void validate_200_status() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");

		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode, 200);
		Reporter.log("Success Status 200 validation");
	}

	@Test
	public void validate_first_and_last_names() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");

		response.then().body("data.first_name", Matchers.equalTo("Janet"));
		response.then().body("data.last_name", Matchers.equalTo("Weaver"));
		response.then().body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
		response.then().body("data.avatar", Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"));
		Reporter.log(response.body().asString());
		System.out.println(response.body().asString());
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

		Reporter.log("Success Status 200 validation");
	}


}
