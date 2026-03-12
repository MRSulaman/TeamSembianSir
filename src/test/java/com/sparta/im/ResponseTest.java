

//
//
//
//
//

package com.sparta.im;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResponseTest {

    private static Response rawResponse;
    private static com.sparta.im.Response pojoResponse;

    @BeforeAll
    public static void beforeAll() {

        // Allow RestAssured to treat text/html as JSON
        RestAssured.registerParser("text/html", Parser.JSON);

        rawResponse = RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .basePath("/api/brandsList")
                .header("Accept", "application/json")   // Correct Accept header
                .when()
                .log().all()
                .get()
                .thenReturn();

        // Ensure request succeeded BEFORE deserializing
        MatcherAssert.assertThat(
                rawResponse.statusCode(),
                Matchers.is(200)
        );

        // Now safe to deserialize into your POJO
        pojoResponse = rawResponse.as(com.sparta.im.Response.class);
    }

    @Test
    @DisplayName("responseCode returns 200")
    public void testResponseCode200() {
        MatcherAssert.assertThat(
                pojoResponse.getResponseCode(),
                Matchers.is(200)
        );
    }
}
