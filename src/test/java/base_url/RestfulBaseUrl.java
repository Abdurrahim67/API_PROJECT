package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup(){
        //set the url
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        //set the expected

        //3. adim send the request and get the reponse


    }
}