package productapi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProduct {
    public void deleteProduct(String id) {
        RestAssured.baseURI = "http://139.59.91.96:3000";
        RequestSpecification request = RestAssured.given();
        Header header1 = new Header("Content-Type","application/json");
        Header header2 = new Header("Authorization",LoginRequest.token);
        Headers multiHeader = new Headers(header1,header2);
        request.headers(multiHeader);
        Response response = request.delete("/api/v1/products/"+id);
        System.out.println(response.asPrettyString());
    }
}
