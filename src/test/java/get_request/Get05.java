package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void get01(){
        //https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        //set the url
        spec.pathParam("first","booking").queryParams("firstname","Kimie","lastname","Jackie");
        //2. adim set the expected
        //3. adim send the request and get the reponse
        Response response =  given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do assertion
        assertEquals(200,response.getStatusCode());
       assertTrue(response.asString().contains("bookingid"));

    }


}