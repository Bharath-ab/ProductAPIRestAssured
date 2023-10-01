package com.utils;

import com.phoenixB2B.intefaces.IBody;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static com.utils.TestUtils.getBaseURL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIHelper {
    //REST API Request Base URL Header Body HTTP Verb Endpoint
    List<Header> requestHeader = new ArrayList<Header>();
    IBody body;
    public Response makeRequest(Verb httpVerb, String endpoint, Object... headerAndBody) {
        Response response = null;
        for (Object d : headerAndBody) {
            if (d instanceof Header) {
                requestHeader.add((Header) d);
            } else if (d instanceof IBody) {
                body = (IBody) d;
            }
        }
        baseURI = getBaseURL();
        if(Verb.GET == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().get(endpoint);
        }
        else if (Verb.POST == httpVerb){
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().post(endpoint);
        }
        else if (Verb.PUT == httpVerb){
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().put(endpoint);
        }
        else if (Verb.DELETE == httpVerb){
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().delete(endpoint);
        }
        return response;
    }
}
