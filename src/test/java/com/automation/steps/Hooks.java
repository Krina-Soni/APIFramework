package com.automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
	// This method will get executed before each scenario
	@Before
	public void setUp() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		System.out.println("Before");
	}

	// This method will get executed after each scenario
	@After
	public void cleanUp() {
		System.out.println("After");
	}

}
