package com.sample.pagefactory.api;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArray_Query {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://demoqa.com/BookStore";		
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("username","password");
		Response resp = request.get("/v1/Books");
		String respBody = resp.getBody().asString();
		
		System.out.println("Response Body:");
		System.out.println(respBody);
		
		JSONObject jsonObject = new JSONObject(respBody);		
		System.out.println("JSONObject:");
		System.out.println(jsonObject);	
		System.out.println("JSONObject-Pretty print with 2-space indent:" ); 
		System.out.println(jsonObject.toString(2)); // Pretty print with 2-space indent
		
		JSONArray jsonArray = jsonObject.getJSONArray("books");			
		System.out.println("JSONArray:");
		System.out.println(jsonArray);
		
		System.out.println("First Item using get:");
		System.out.println(jsonArray.get(0));
		
		System.out.println("First Item using getJSONObject:");
		System.out.println(jsonArray.getJSONObject(0));
		
		for(int i=0;i<jsonArray.length();i++)
		{
			JSONObject obj = jsonArray.getJSONObject(i);
			String author = obj.getString("author");
			String subTitle = obj.getString("subTitle");
			System.out.println(author + " - " +subTitle);
			
			if(author.contains("Addy Osmani"))		
			{
				System.out.println("SubTitle of Addy Osmani is:" +subTitle);
			}					
		}
	}


}
