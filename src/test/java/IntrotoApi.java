import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;

public class IntrotoApi {
    public static void main(String[] args) {
String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzQ4ODY0NzEsImlhdCI6MTczMjI5NDQ3MSwidXNlcm5hbWUiOiJrYm9yb245M0BnbWFpbC5jb20ifQ.bPvI3HmGlsfQW0E4PxAnq_BvghF0xbblQRFZbifOV8M7L6NyZXx3YNxyk85XjxZCIxySjKCXEMpWjm3t2fSj5w";
      RestAssured.given()
              .auth()
              .oauth2(token)
              .baseUri("https://backend.cashwise.us/api")
              .when()
              .get("/myaccount/tags/all")
              .then()
              .statusCode(200);

        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .when()
                .get("/myaccount/tags/all")
                .then()
                .statusCode(200);

        RestAssured.given()
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .and()
                .when()
                .get("/myaccount/reminder/requests")
                .then()
                .statusCode(200);
    }
}
