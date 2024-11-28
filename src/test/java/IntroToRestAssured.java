import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;


public class IntroToRestAssured {
    public static void main(String[] args) {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzQ4ODY0NzEsImlhdCI6MTczMjI5NDQ3MSwidXNlcm5hbWUiOiJrYm9yb245M0BnbWFpbC5jb20ifQ.bPvI3HmGlsfQW0E4PxAnq_BvghF0xbblQRFZbifOV8M7L6NyZXx3YNxyk85XjxZCIxySjKCXEMpWjm3t2fSj5w";

        JSONObject requestBody = new JSONObject();
        requestBody.put("product_title", "fish21");
        requestBody.put("product_price",9.0);
        requestBody.put("service_type_id", 2);
        requestBody.put("category_id", 1025);
        requestBody.put("product_description", "Italian");
        requestBody.put("date_of_payment", "2024-11-25");
        requestBody.put("remind_before_day", 4);
        requestBody.put("do_remind_every_month", "REPEAT_EVERY_MONTH");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .body(requestBody.toString())
                .when()
                .post("/myaccount/products")
                .then()
                .statusCode(201)
                .body("product_title", equalTo("fish21"))
                .body("product_price", equalTo(9));

       // System.out.println(response.body().prettyPrint());


    }
}
//{
//  "product_title": "string",
//  "product_price": 0,
//  "service_type_id": 0,
//  "category_id": 0,
//  "product_description": "string",
//  "date_of_payment": "2024-11-23",
//  "remind_before_day": 0,
//  "do_remind_every_month": "REPEAT_EVERY_MONTH"
//}