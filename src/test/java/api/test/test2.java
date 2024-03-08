package api.test;

import api.utilities.baseCydeo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class test2 extends baseCydeo {

    /*
    Given accept type is application/json
    And path param is 6
    When user send request /student/{id}
    Then status code should be 200
    And content type is application/json;charset=UTF-8
    And Date header is exist
    And Server header is envoy
    And verify following
                firstName Mike
                batch 26
                major math
                emailAddress mikesmith@email.com
                companyName Cydeo
                street 777 5th Ave
                zipCode 33222


                api.training.cydeo.com/
    */

    @Test
    public void cydeoTest(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 6)
                .when().get("/student/{id}");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertEquals("application/json;charset=UTF-8",response.contentType());
        assertTrue(response.headers().hasHeaderWithName("Date"));
        assertEquals("envoy",response.header("server"));

        JsonPath jsonPath = response.jsonPath();
        assertEquals("Mike",jsonPath.getString("students[0].firstName"));



    }






}
