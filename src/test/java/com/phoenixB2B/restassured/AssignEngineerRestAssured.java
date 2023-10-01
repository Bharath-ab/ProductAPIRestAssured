package com.phoenixB2B.restassured;


import com.google.gson.Gson;
import com.phoenixB2B.pojo.supervisor.EngineerAssignment;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static com.utils.TestUtils.*;
import static io.restassured.RestAssured.*;

public class AssignEngineerRestAssured {
    public AssignEngineerRestAssured(EngineerAssignment eag, String token) {
        baseURI = getBaseURL();
        Gson gs = new Gson();
        System.out.println(gs.toJson(eag));
        Response response = given()
                .when()
                .headers(new Headers(new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer",getRefererUrl()), new Header("DNT", "1")))
                .and()
                .body(gs.toJson(eag))
                .and()
                .post("/v1/engineer/assign");
        System.out.println(response.asPrettyString());
    }
}
