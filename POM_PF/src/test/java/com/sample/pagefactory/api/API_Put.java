//https://toolsqa.com/rest-assured/post-request-using-rest-assured/
package com.sample.pagefactory.api;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Put {

@Test
public void PutAPIExample() 
{ 
    RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
     
    JSONObject requestParams = new JSONObject(); //in get request we need to pass response body as argument
    requestParams.put("userName", "test_rest");
    requestParams.put("password", "Testrest@123"); 
    requestParams.put("id", 101);
    requestParams.put("title", "Updated Title");
    requestParams.put("author", "Updated Author");
    
 // Build request with basic authentication
    RequestSpecification request = RestAssured
            .given()
//             basic authentication
            .auth()
            .preemptive()
            .basic("your_username", "your_password") 
            .header("Content-Type", "application/json")            
//            .header("Authorization", "Bearer your_bearer_token_here")  ---  bearer token
//            .header("x-api-key", "your_api_key_here")  --- api key            
            .body(requestParams.toString());
    
    Response response = request.put("/books/101");  // Assuming REST path includes ID     
    System.out.println(response.getStatusLine());
    System.out.println(response.getBody().asString());
 }
}
