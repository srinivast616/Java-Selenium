package com.sample.pagefactory.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class API_Post_OAuth {
    public static void main(String[] args) {
        // Step 1: Get Access Token
        JSONObject requestParams = new JSONObject();
        requestParams.put("grant_type", "client_credentials");
        requestParams.put("client_id", "your_client_id");
        requestParams.put("client_secret", "your_client_secret");

        Response tokenResponse = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body(requestParams.toString())
            .post("https://example.com/oauth/token");

        String accessToken = tokenResponse.jsonPath().getString("access_token");

        // Step 2: Use Access Token in API Call
        JSONObject requestBody = new JSONObject();
        requestBody.put("key", "value");

        Response apiResponse = RestAssured
            .given()
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
            .post("https://example.com/api/endpoint");

        System.out.println("Status Code: " + apiResponse.getStatusCode());
        System.out.println("Response: " + apiResponse.getBody().asString());
    }
}
