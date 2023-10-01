package com.phoenixB2B.restassured;

import com.google.gson.Gson;
import com.phoenixB2B.pojo.frontdesk.CreateRepairJob;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static com.utils.TestUtils.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateRepairJobRestAssured {

    public CreateRepairJobRestAssured(String token, CreateRepairJob crj) {
        //Optimized Code Using Static Import
        baseURI = getBaseURL();
        Gson gs = new Gson();
        Response response = given()
                .headers(new Headers(new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer",getRefererUrl()), new Header("DNT", "1")))
                .and()
                .body(gs.toJson(crj))
                .when()
                .post("/v1/job/create");
        System.out.println(response.asPrettyString());
    }
}
