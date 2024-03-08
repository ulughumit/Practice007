package api.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class testBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://3.85.79.28:7000";
    }

}
