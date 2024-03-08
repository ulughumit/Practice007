package api.test;

import api.utilities.testBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class twoHundred extends testBase {

//    /*
//    Given accept type is application/json
//    And query param limit is 200
//    When user send request /employees
//    Then user should see
//     */

    @Test
    public void test200 (){

        Response response = given().accept(ContentType.JSON)
                .queryParam("limit", 200)
                .when().get("/employees");

//        response.prettyPrint();
//        "job_id": "IT_PROG"

        JsonPath jsonPath = response.jsonPath();

        List<String> allEmailList = jsonPath.getList("items.email");
        System.out.println("allEmailList = " + allEmailList);

        List<String> listIT = jsonPath.getList("items.findAll {it.job_id=='IT_PROG'}.first_name");

        System.out.println("listIT = " + listIT);


    }





}
