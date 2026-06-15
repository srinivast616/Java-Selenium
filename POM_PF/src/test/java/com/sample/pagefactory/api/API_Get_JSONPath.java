package com.sample.pagefactory.api;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Get_JSONPath {

	@Test

	public void testResponsecode()

	{
//		Response resp = RestAssured.get("https://reqres.in/api/users?page=1");

		// Set the base URI
		RestAssured.baseURI = "https://demoqa.com/BookStore";

		// Build the request
		RequestSpecification request = RestAssured.given()
				// Basic Authentication
				.auth().preemptive().basic("username", "password");
//                .header("Authorization", "Bearer your_bearer_token_here")                 //  Bearer Token
//                .header("x-api-key", "your_api_key_here");         // API Key (custom header)

		// Send GET request
		Response response = request.get("/v1/Books");
		int code = response.getStatusCode();
		System.out.println(" Status code is " + code);

		Assert.assertEquals(code, 200);

		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody:" + responseBody);

//		JsonPath jsonPath=response.jsonPath();	
		JsonPath jsonPath = new JsonPath(responseBody);
		List<HashMap<String, String>> jsonData = jsonPath.getList("books");
		System.out.println("json data:" + jsonData);

		String contentType = response.header("Content-Type"); // same as response.getHeader("Content-type");
		System.out.println("ContentType:" + contentType);

		Headers allheaders = response.headers();
		System.out.println(allheaders); // returns same output as response.getHeaders();
		for (Header header : allheaders) // returns same output as above
		{
			System.out.println(header.getName() + ":" + header.getValue());
		}

	}

}
