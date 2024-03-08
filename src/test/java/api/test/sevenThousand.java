package api.test;

import api.utilities.testBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;


public class sevenThousand extends testBase {

    @Test
    public void test1 () {


        String requestBody = " {\n" +
                "     \"gender\":\"Female\",\n" +
                "     \"name\":\"John Wick\",\n" +
                "     \"phone\":8877445596\n" +
                "     }";


        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .auth().basic("admin","admin")
                .body(requestBody).when()
                .post("/api/spartans").prettyPeek()
                .then().statusCode(201)
                .contentType("application/json")
                .body("success",is("A Spartan is Born!")).extract().jsonPath();


    }

    @Test
    public void delete(){

        given()
                .pathParam("id",105)
                .auth().basic("editor","editor")
                .when()
                .delete("/api/spartans/{id}").then().statusCode(403);
    }




}
