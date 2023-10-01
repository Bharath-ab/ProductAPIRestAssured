package com.phoenixB2B;

import com.phoenixB2B.pojo.LoginToPhoneixApp;
import com.utils.APIHelper;
import com.utils.Verb;
import io.restassured.http.Header;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.utils.TestUtils.getOriginUrl;
import static com.utils.TestUtils.getRefererUrl;


public class LoginApiTest {

    @Test(description = "Login API" ,priority = 1,groups = {"e2e","smoke","sanity"})
    public void verifyLogin(){
        APIHelper helper = new APIHelper();
        String token = helper.makeRequest(Verb.POST, "/v1/login", new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new LoginToPhoneixApp("iamfd", "password")).then().statusCode(200).and().body("message", Matchers.equalTo("Success")).log().all().and().extract().path("data.token");
        System.out.println("Token: "+token);
    }
}
