//package com.sparta.rs;
//
//import com.sparta.rs.pojoresponse.AutomationExercise;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class AutomationExerciseTest {
//    private static Response response;
//    private static AutomationExercise automationExercise;
//
//
//    @BeforeAll
//    public  static void beforeAll() {
//        response = RestAssured
//                .given()
//                .baseUri("https://api.postcodes.io")
//                .basePath("/postcodes")
//                .header("Accept", "text/json")
//                .when()
//                .log().all()
//                .get("/EC2Y5AS")
//                .thenReturn();
//        pojoResponse = response.as(Postcode.class);
//    }
//
//    @Test
//    @DisplayName("Testing response is 200")
//    public  void    testStatusCode200_usingBeforeAll(){
//        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
//    }
//}
