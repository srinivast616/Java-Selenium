package com.sample.pagefactory.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class API_RecCount {

	@Test
	public void getCount() throws Exception {
		
		Response resp = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		System.out.println("Status Code: " + resp.getStatusCode());
		String responseBody = resp.getBody().asString();
		System.out.println("Response: " + responseBody);
		
		JSONObject jsonObject = new JSONObject(responseBody);
        System.out.println(jsonObject.toString(2)); // Pretty print with 2-space indent

//	    JsonPath jsonPath = resp.jsonPath();
	    JsonPath jsonPath = new JsonPath(responseBody);	    

		int recordCount = jsonPath.getList("books").size();
		System.out.println("Number of records: " + recordCount);

        JSONArray dataArray = jsonObject.getJSONArray("books"); 
        System.out.println("Record count: " + dataArray.length());		
	}
}
