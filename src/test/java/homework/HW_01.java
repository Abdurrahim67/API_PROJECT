package homework;

import homework.homework_base_url.HW_AutomationExcerciseBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HW_01 extends HW_AutomationExcerciseBaseUrl {

     /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/


    @Test
    public void test01() {
        //Set the URL
        spec.pathParam("first", "brandsList");
        //Set the Expected Data(put,post,patch)
        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //Do Assertion
        response.then().assertThat().statusCode(200).contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        List<String> brandlist=response.htmlPath().getList("brands.brand");
        int numOfHM=0;
        int numOfPolo=0;
        for (String w: brandlist) {
            if(w.equalsIgnoreCase("H&M")){
                numOfHM++;
            }
            if (w.equalsIgnoreCase("Polo")){
                numOfPolo++;
            }

        }
        assertEquals(numOfHM, numOfPolo);



    }


}
