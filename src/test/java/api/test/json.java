package api.test;

import api.utilities.testBaseSpartan;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class json extends testBaseSpartan {

    /*
    *
    * Given accept type is json
And path param id is 10
When user sends a get request to "api/spartans/{id}"
Then status code is 200
And content-type is "application/json"
And response payload values match the following:
   id is 10,
   name is "Lorenza",
   gender is "Female",
   phone is 3312820936
*/

    @Test
    public void test1 (){

        Response responseSpartan = given().accept(ContentType.JSON)
                .and().pathParams("id", 10)
                .when().get("api/spartans/{id}");
        responseSpartan.prettyPrint();

        JsonPath jsonPath = responseSpartan.jsonPath();

        int id = jsonPath.getInt("id");
        System.out.println("id = " + id);

        String name = jsonPath.getString("name");
        System.out.println("name = " + name);

        String gender = jsonPath.getString("gender");
        System.out.println("gender = " + gender);

        long phone = jsonPath.getLong("phone");
        System.out.println("phone = " + phone);

        assertEquals(10,id);
        assertEquals(3312820936L,phone);

    }




}
