package com.automation.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {

	static RequestSpecification reqSpecs = RestAssured.given();

	static String endpoint;

	static Response response;

	public static void setEndpoint(String endpoint) {
		RestAssuredUtils.endpoint = endpoint;
	}

	public static void setHeader(String key, String value) {
		reqSpecs = reqSpecs.header(key, value);
	}

	public static void setBody(String body) {
		reqSpecs = reqSpecs.body(body);
	}

	public static void get() {
		response = reqSpecs.log().all().get(endpoint);
	}

	public static void post() {
		response = reqSpecs.log().all().post(endpoint);
	}

	public static void put() {
		response = reqSpecs.log().all().put(endpoint);
	}

	public static void delete() {
		response = reqSpecs.log().all().delete(endpoint);
	}
	
	public static int getStatusCode() {
		return response.getStatusCode();
	}
	
	public static String getResponseAsString() {
		return response.asString();
	}

}
