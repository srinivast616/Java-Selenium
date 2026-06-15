package com.sample.pagefactory.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AP_Get_JSONArray {

	@Test
	public void ReadData() throws Exception {			

        RestAssured.baseURI = "https://demoqa.com/BookStore";
    
        RequestSpecification request = RestAssured
                .given()
                //  Basic Authentication
                .auth()
                .preemptive()
                .basic("username", "password");
//                .header("Authorization", "Bearer your_bearer_token_here")                 //  Bearer Token
//                .header("x-api-key", "your_api_key_here");         // API Key (custom header)
        
        Response resp = request.get("/v1/Books");
        String responseBody = resp.getBody().asString();
		System.out.println("Raw Response as String: " + responseBody);
		
		JSONObject jsonObject = new JSONObject(responseBody);		 
		System.out.println("JSONObject:" +jsonObject.toString(2)); // Pretty print with 2-space indent
		
		JSONArray dataArray = jsonObject.getJSONArray("books"); 
        System.out.println("Data Array:" +dataArray);
        System.out.println("first item: " +dataArray.getJSONObject(0));        
        System.out.println("first item: " +dataArray.get(0));       
        
    }
}