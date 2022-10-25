package com.unosquare;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FuchsiaRoseTest {

	@Test
	public void validate_fuchsia_status_code_and_fields() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/unknown/2");

		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode, 200);
		Reporter.log("Sucess 200 validation");
		
		response.then().body("data.name", Matchers.equalTo("fuchsia rose"));
		response.then().body("data.year", Matchers.equalTo(2001));
		response.then().body("data.color", Matchers.equalTo("#C74375"));
		response.then().body("data.pantone_value", Matchers.equalTo("17-2031"));
		Reporter.log(response.body().asString());
		System.out.println(response.body().asString());
	}

	@Test
	public void validate_fuchsia_status_code_and_fields_Gherkin() {

		RestAssured
		.given()
		.when()
		.get("https://reqres.in/api/unknown/2")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().body("data.'name'", Matchers.equalTo("fuchsia rose"))
		.assertThat().body("data.'year'", Matchers.equalTo(2001))
		.assertThat().body("data.'color'", Matchers.equalTo("#C74375"))
		.assertThat().body("data.'pantone_value'", Matchers.equalTo("17-2031"));

		Reporter.log("Sucessfully completed validation");
	}
}
