package com.sparta.rs;

import com.sparta.rs.ApiResponse.Post405;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class API2PostToAllProductsListTest {
    private static Response response;
    private static Post405 post405;

    @BeforeAll
    public  static void beforeAll() {
        response = RestAssured
                .given()
//                    .baseUri("https://automationexercise.com")
//                    .basePath("/api")
//                    .header("Accept", "text/json")
                .post("https://automationexercise.com/api/productsList")
//                .when()
//                    .log().all()
//                    .post("/productsList")
                .thenReturn();
//        post405 = response.as(Post405.class);
    }

    @Test
    @DisplayName("Testing response is 405")
    public  void    testStatusCode405_usingBeforeAll(){
        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is("405"));
    }

}
