package productapi;

import io.restassured.http.Header;
import io.restassured.response.Response;
import productapi.pojo.Login;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static productapi.utils.TestUtils.getBaseURL;


public class LoginRequest {
    public static String token;
    public void loginRequest(String uName,String uPassword) {
        baseURI = getBaseURL();
        Response response = given()
                .when()
                .header(new Header("Content-Type", "application/json"))
                .and()
                .body(new Login(uName,uPassword).toJson())
                .and()
                .post("/user/signin");
        System.out.println(response.asPrettyString());
        token = response.path("data.token").toString();
    }
}