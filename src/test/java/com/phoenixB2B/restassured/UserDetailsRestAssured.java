package com.phoenixB2B.restassured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static com.utils.TestUtils.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserDetailsRestAssured {

    public UserDetailsRestAssured(String token) {
        baseURI = getBaseURL();
        Response response = given()
                .when()
                .headers(new Headers(new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1")))
                .and()
                .get("/v1/userdetails");
        String userLogged = response.path("data.role_name");
        System.out.println("Logged in User: " +userLogged);
    }

}
