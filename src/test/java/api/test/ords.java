package api.test;

import api.utilities.testBase;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ords extends testBase {

/*
Given content type is application/json
When user sends GET request /api/spartans endpoint
Then status code should be 200
And Content type should be application/json
 */

    String URL = "http://3.85.79.28:8000/api/spartans";

    @Test
    public void getRequest(){
        Response response = RestAssured.get(URL);
        response.prettyPrint();

        System.out.println(response.getStatusCode());
        int actualCode = response.statusCode();
        assertEquals(200,actualCode);
    }




    @Test
    public void testJulia(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParams("id", 24)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();

        int actualCode = response.statusCode();
        assertEquals(200,actualCode);
        assertTrue(response.body().asString().contains("Julio"));

/*   Given accept type is Json
            And Id parameter value is 24
            When user sends GET request to /api/spartans/{id}
            Then response status code should be 200
            And response content-type: application/json
            And "Julio" should be in response payload(body)
         */
    }

    @Test
    public void negativeTest(){
        /*
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charsert=UTF-8;
     */
        Response responseNegative = given().accept(ContentType.XML)
                .and()
                .get("/api/spartans/10");
        responseNegative.prettyPrint();

        assertEquals(406,responseNegative.statusCode());
        assertEquals("application/xml;charset=UTF-8",responseNegative.contentType());

    }


}
