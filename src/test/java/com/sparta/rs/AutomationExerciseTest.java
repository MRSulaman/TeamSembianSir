package com.sparta.rs;

import com.sparta.rs.pojoresponse.AutomationExercise;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutomationExerciseTest {
    private static Response response;
    private static AutomationExercise automationExercise;

//    @BeforeAll
//    public  static void beforeAll() {
//        response = RestAssured
//                .given()
//                .baseUri("https://automationexercise.com")
//                .basePath("/api")
////                .header("Accept", "text/json")
//                .when()
////                .log().all()
//                .get("/productsList")
//                .thenReturn();
//        automationExercise = response.as(AutomationExercise.class);
//    }

    @Test
    @DisplayName("Testing response is 200")
    public  void    testStatusCode200_usingBeforeAll(){
        RestAssured
                .get("https://automationexercise.com/api/productsList")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
