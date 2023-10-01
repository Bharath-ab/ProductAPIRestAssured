package com.phoenixB2B.restassured;

import com.google.gson.Gson;
import com.phoenixB2B.customexceptions.DbDownException;
import com.phoenixB2B.pojo.LoginToPhoneixApp;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import static com.utils.TestUtils.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class LoginRestAssured{

    private String token;

    public LoginRestAssured(LoginToPhoneixApp lpa) {
        baseURI = getBaseURL();
        Gson gs = new Gson();
        Response response = given()
                .when()
                .body(gs.toJson(lpa))
                .and()
                .headers(new Headers(new Header("Content-Type", "application/json"),new Header("Origin", getOriginUrl()),new Header("Referer",getRefererUrl()),new Header("DNT", "1"))).post("/v1/login");
        token = response.path("data.token");
        if(token != null){
            System.out.println("Token Generated Successfully and Stored");
        }
        else{
            try{
                throw new DbDownException("Db is down please check");
            }
            catch(DbDownException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getToken() {
        return token;
    }


}
