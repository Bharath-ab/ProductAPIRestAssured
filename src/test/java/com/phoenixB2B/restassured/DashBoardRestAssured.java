package com.phoenixB2B.restassured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;

import static com.utils.TestUtils.*;
import static io.restassured.RestAssured.*;


public class DashBoardRestAssured {
    public DashBoardRestAssured(String token){
        baseURI = getBaseURL();
        Response response = given()
                .when()
                .headers(new Headers(new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1")))
                .and()
                .get("/v1/dashboard/count");

        ArrayList<Object> resp = response.path("data");
        for(int i =0; i< resp.size(); i++){
            String label = response.path("data["+i+"].label");
            int countOfIssues = response.path("data["+i+"].count");
            System.out.println(label + "\t: " + countOfIssues);
        }


    }
}
