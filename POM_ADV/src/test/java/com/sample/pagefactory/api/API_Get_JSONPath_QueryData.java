package com.sample.pagefactory.api;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API_Get_JSONPath_QueryData {

	@Test
	public void ReadData() throws Exception {
		
//		Response resp = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		// Set the base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore";
     // Build the request
        RequestSpecification request = RestAssured
                .given()
                //  Basic Authentication
                .auth()
                .preemptive()
                .basic("username", "password");
//                .header("Authorization", "Bearer your_bearer_token_here")                 //  Bearer Token
//                .header("x-api-key", "your_api_key_here");         // API Key (custom header)

        // Send GET request
        Response resp = request.get("/v1/Books");
        System.out.println("Raw Response:" +resp);
		System.out.println("Status Code: " + resp.getStatusCode());
		String responseBody = resp.getBody().asString();
		System.out.println("Raw Response as String: " + responseBody);
		
		JsonPath jsonPath = resp.jsonPath(); 
	
//	    JsonPath jsonPath = new JsonPath(responseBody);

	    List<HashMap<String,String>> jsondata = jsonPath.getList("books");
	    System.out.println("jsondata:" +jsondata);
	    
	    for(HashMap<String,String> item:jsondata)
	    {
	    	if(item.get("title").equals("You Don't Know JS"))
	    			{
	    			 System.out.println("author: " +item.get("author"));
	    			 System.out.println("publisher: " +item.get("publisher"));
	    			}
	    }
	    for(HashMap<String,String> item:jsondata)
	    {
	    	System.out.println(item.get("subTitle"));
	    }
                
    }
}
