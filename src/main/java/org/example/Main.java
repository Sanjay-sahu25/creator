package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Main {
    public static void main(String[] args) {
        //validate if Add Place API is working as expected
        //given- all input details-resource,http method
        //when -Submit API
        //Then -validate response
        RestAssured.baseURI= "https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Rahul shetty academy\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}").when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200);
    }
}