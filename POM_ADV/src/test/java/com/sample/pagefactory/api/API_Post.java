//https://toolsqa.com/rest-assured/post-request-using-rest-assured/

package com.sample.pagefactory.api;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Post {

	@Test
	
	public void api_test_2 ()
	{
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		JSONObject requestBody = new JSONObject(); //in get request we need to pass response body as argument 
		requestBody.put("userId", "TQ123"); 
		requestBody.put("isbn", "9781449325862"); 
		
		RequestSpecification request = RestAssured.given();	
		request.auth().preemptive().basic("your_username", "your_password");
		request.header("Content-Type", "application/json");	
//		request.header("Authorization", "Bearer your_token_here"); // to pass bearer token
//		request.header("x-api-key", "your_api_key_here");  //api key 
		request.body(requestBody.toString());		
		
//		Response response = request.queryParam("api_key", "your_api_key_here").post("/post"); // to pass api key
		Response response = request.post("/users");
		
		System.out.println("The status received: " + response.statusLine());
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
	}
}
