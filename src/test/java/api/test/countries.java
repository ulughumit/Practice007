package api.test;

import api.utilities.testBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class countries extends testBase {

    @DisplayName("getRequestCountryWithRegion")
    @Test
    public void tests () {
        Response response1 = given().accept(ContentType.JSON)
                .and().pathParams("id",103)
                .when().get("/employees/{id}")
                       .then().statusCode(200)
                      .contentType("application/json")
                              .extract().response().prettyPeek();

        //System.out.println( " Status code is : " + response1.statusCode());

        String id = response1.path("job_id");
        int dp = response1.path("department_id");


        System.out.println(id+ " "+dp);

        //System.out.println(response1.path("employee_id").toString());

        //System.out.println(response1.path("items.first_name").toString());

        //System.out.println(response1.path("items[4].country_name").toString());

                                /*
        response1.prettyPrint();
        assertEquals(200, response1.statusCode());
        assertEquals("application/json", response1.contentType());
        assertTrue(response1.body().asString().contains("United States of America"));
        */





    }


    }
