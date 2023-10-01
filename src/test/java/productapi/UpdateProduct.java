package productapi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProduct {
    public void updateProduct(String id) {
        RestAssured.baseURI = "http://139.59.91.96:3000";
        RequestSpecification myRequest = RestAssured.given();
        Header h1 = new Header("Content-Type", "application/json");
        Header h2 = new Header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsYXN0X21vZGlmaWVkIjoxNjQ4MzQ5ODA3MTExLCJleHBpcmVfYXQiOjE2NTM1MzM4MDcxMTEsInBheWxvYWQiOnsiaWQiOjIsIm5hbWUiOiJKYXRpbiBTaGFybWEiLCJlbWFpbCI6ImphdGludnNoYXJtYUBnbWFpbC5jb20iLCJyb2xlIjoiYWRtaW4iLCJtb2JpbGVfbnVtYmVyIjoiMTIzMTIzMTIzMSJ9fQ.O_YfdrCjdHL5lB2wSeqfoOeqR790Gn5eVuCLtMq4Oj8");
        Headers multiHeader = new Headers(h1, h2);
        myRequest.headers(multiHeader);
        myRequest.body(" {\n" + "\"prod_name\": \"AT Batch March 2020 Updated\", \n" + "\"prod_desc\": \"Hello world product Updated\",\n" + "\"prod_price\": 1111111\n" + "\n" + "}");
        Response res = myRequest.put("/api/v1/products/"+id);
        System.out.println(res.asPrettyString());
    }
}
