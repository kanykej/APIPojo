package pojo;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.sql.SQLOutput;

import static org.hamcrest.Matchers.equalTo;

public class IntroToSerialization {
    public static void main(String[] args) {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MzQ4ODY0NzEsImlhdCI6MTczMjI5NDQ3MSwidXNlcm5hbWUiOiJrYm9yb245M0BnbWFpbC5jb20ifQ.bPvI3HmGlsfQW0E4PxAnq_BvghF0xbblQRFZbifOV8M7L6NyZXx3YNxyk85XjxZCIxySjKCXEMpWjm3t2fSj5w";
        Tag tag= new Tag();
        tag.setName_tag("apple");
        tag.setDescription("fruit apple");

        Gson gson= new Gson();
        String requestBodyInJson= gson.toJson(tag);
        System.out.println(requestBodyInJson);

        Response response =RestAssured.given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(token)
                .baseUri("https://backend.cashwise.us/api")
                .body(requestBodyInJson)
                .post("/myaccount/tags");

        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
       String responseInJson = response.asString();
       gson= new Gson();
       Tag tagResponse = gson.fromJson(responseInJson, Tag.class);

    }
}
