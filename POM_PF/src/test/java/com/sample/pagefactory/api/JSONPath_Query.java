package com.sample.pagefactory.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

public class JSONPath_Query {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://demoqa.com/BookStore";
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("username", "password");
		Response resp = request.get("/v1/Books");

		String respBody = resp.getBody().asString();
		System.out.println("Response Body:");
		System.out.println(respBody);

//		JsonPath jsonPath = new JsonPath(respBody);
		JsonPath jsonPath = resp.jsonPath();
		List<HashMap<String, String>> data = jsonPath.getList("books");		

		System.out.println("                        ");
		System.out.println("Printing data using List");
		System.out.println("                        ");
		for (HashMap<String, String> dataItem : data) 
		{
			System.out.println(dataItem.get("author"));
		}

		for (HashMap<String, String> dataItem : data) {
			if (dataItem.get("author").contains("Rechard")) 
			{
				System.out.println("Book written by Richard:" + dataItem.get("Title"));
			}

		}
		
		System.out.println("                            ");
		System.out.println("Printing data using hash map");
		System.out.println("                            ");

		for (HashMap<String, String> dataItem : data) {
			for (Entry<String, String> entry : dataItem.entrySet()) {
				if (entry.getKey().equals("author")) {
					System.out.println(entry.getValue());
				}
			}
		}
		
	}
}
