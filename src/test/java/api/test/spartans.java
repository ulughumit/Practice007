package api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class spartans {

    String URL = "http://3.85.79.28:8000/api/spartans";

    @Test
    public void getRequest(){
        Response response = RestAssured.get(URL);
        response.prettyPrint();

        System.out.println(response.getStatusCode());
        int actualCode = response.statusCode();
        Assertions.assertEquals(200,actualCode);
        }

    @Test
    public void postRequest() {



    }



}
