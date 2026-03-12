package com.sparta.rs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class AutomationExerciseTest {
        @Test
        @DisplayName("Status code 200 returned")
        public void textStatusCode200() {
            RestAssured

                    .given()
                    .baseUri("https://automationexercise.com")
                    .queryParam("email", "sembianr@hotmail.com")
                    .header("password", "sembian")
                    .when()
                    .get("/api/getUserDetailByEmail")
                    .then()
                    .assertThat()
                    .statusCode(200);
        }

        //Alternative version of the above test
        @Test
        @DisplayName("Status code 200 returned short")
        public void textStatusCode200_Shortversion() {
            RestAssured
                    .get("https://automationexercise.com/api/getUserDetailByEmail?email=sembian@hotmail.com")
                    .then()
                    .assertThat()
                    .statusCode(200);
        }

//        //Alternative with MatcherAssert
        private static Response response;

        @BeforeAll
        public static void beforeAll() {
            response = given()
                    .baseUri("https://automationexercise.com")
                    .queryParam("email", "sembian@hotmail.com")
                    .header("password", "sembian")
                    .when()
                    .get("/api/getUserDetailByEmail")
                    .thenReturn();
        }

        @Test
        @DisplayName("Status code 200 returned")
        public void textStatusCode200_Matcher() {
            MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
        }

        @Test
        @DisplayName("Correct server is returned")
        public void testServerNameInHeaderIsCloudFlare() {
            MatcherAssert.assertThat(response.header("Server"), Matchers.is("cloudflare"));
        }

        @Test
        @DisplayName("The connection name in the headers is keep-alive")
        public void testConnectionNameInHeaderIsKeepAlive() {
            MatcherAssert.assertThat(response.header("Connection"), Matchers.is("keep-alive"));
        }

        //test the values in the json body
        @Test
        @DisplayName("Correct lastname through jsonpath returned in result")
        public void testLastName() {
            MatcherAssert.assertThat(response.jsonPath().getString("user.last_name"), Matchers.is("ram"));
        }

        @Test
        @DisplayName("Correct birthday returned in result")
        public void testBirthday() {
            MatcherAssert.assertThat(response.jsonPath().getString("result.birth_day"), Matchers.nullValue());
        }
    }
