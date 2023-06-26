package com.automation.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class StepDefinition {

	static String tokenValue = "";
	static String bookingID = "";

	@Given("user set up request for {string}")
	public void user_set_up_request_for(String endpoint) {
		endpoint = endpoint.replace("booking_id", bookingID);
		RestAssuredUtils.setEndpoint(endpoint);
	}

	@When("user perform the GET request")
	public void user_perform_the_get_request() {
		RestAssuredUtils.get();
	}
	
	@When("user perform the PUT request")
	public void user_perform_the_put_request() {
		RestAssuredUtils.put();
	}

	@When("user perform the POST request")
	public void user_perform_the_post_request() {
		RestAssuredUtils.post();
	}

	@When("user set header token")
	public void user_set_header_token() {
		RestAssuredUtils.setHeader("Cookie", "token=" + tokenValue);
	}

	@Then("verify status code is {int}")
	public void verify_status_code_is(int statusCode) {
		Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
	}
	
	@Then("user set header {string} to {string}")
	public void user_set_header(String key, String value) {
		RestAssuredUtils.setHeader(key, value);
	}

	@Then("user set body for auth request")
	public void user_set_body_for_auth_request() {
		try {
			RestAssuredUtils.setBody(readDataFromFile("auth_body.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("save token value from response")
	public void save_token_value_from_response() {
		JsonPath jsonPath = new JsonPath(RestAssuredUtils.getResponseAsString());
		tokenValue = jsonPath.getString("token");
	}

	@Then("save bookingid value from response")
	public void save_bookingid_value_from_response() {
		JsonPath jsonPath = new JsonPath(RestAssuredUtils.getResponseAsString());
		bookingID = jsonPath.getString("bookingid[0]");
	}

	@When("user set body for update request")
	public void user_set_body_for_update_request() {
		try {
			RestAssuredUtils.setBody(readDataFromFile("update_request_body.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readDataFromFile(String fileName) throws Exception {
		String body = new Scanner(new File("src//test//resources//" + fileName)).useDelimiter("\\Z").next();
		return body;
	}
	

}
