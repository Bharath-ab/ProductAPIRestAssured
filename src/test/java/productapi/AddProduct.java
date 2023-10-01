package productapi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProduct {
        private String id;
        public void addProduct() {
        RestAssured.baseURI = "http://139.59.91.96:3000";
        RequestSpecification myRequest = RestAssured.given();
        Header header1 = new Header("Content-Type","application/json");
        Header header2 = new Header("Authorization",LoginRequest.token);
        Headers multiHeaders = new Headers(header1,header2);
        myRequest.headers(multiHeaders);
        myRequest.body(" {\n" +
                "\"prod_name\": \"Iphone 13\", \n" +
                "\"prod_desc\": \"100 px camera\",\n" +
                "\"prod_price\": 99999\n" +
                "\n" +
                "}");
        Response response = myRequest.post("/api/v1/products");
            System.out.println(response.asPrettyString());
                id =response.path("data.id").toString();
    }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }
}
