package api.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class baseCydeo {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="https://api.training.cydeo.com";
    }
}
