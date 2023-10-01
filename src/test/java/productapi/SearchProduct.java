package productapi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchProduct {
    public void searchProduct(String id) {
        RestAssured.baseURI = "http://139.59.91.96:3000";
        RequestSpecification request = RestAssured.given();
        Header header = new Header("Authorization",LoginRequest.token);
        request.header(header);
        Response response = request.get("/api/v1/products/"+id);
        System.out.println(response.asPrettyString());
    }
}
