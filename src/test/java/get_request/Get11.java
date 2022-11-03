package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {

/*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10  -- "Sayfalandırma sınırı" değeri 10'dur
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1" --"Geçerli bağlantı", "https://gorest.co.in/public/v1/users?page=1" olmalıdır
    And
        The number of users should  be 10 --Kullanıcı sayısı 10 olmalıdır
    And
        We have at least one "active" status--En az bir "etkin" durumumuz vardır
    And
       Fr. Paramartha Bandopadhyay, Pres. Amarnath Dhawan and Sujata Chaturvedi are among the users--Kullanicilar arasında  Niranjan Gupta, Samir Namboothiri ve Gandharva Kaul olmali
    And
        The female users are less than or equals to male users--Kadın kullanıcılar erkek kullanıcılara eşit veya daha az olmali
 */


    @Test
    public void get11() {

        //1. Set The URL
        spec.pathParam("first", "users");
        // 2. Set The Expected Data ( put, post, patch)
        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        // 4. Do Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Navin Panicker", "Pres. Amarnath Dhawan", "Sujata Chaturvedi"));

        //Kadin ve Erkek sayilarini karsilastiralim
        //1.Yol:

        List<String> genders = response.jsonPath().getList("data.gender");
        int numOfFemale = 0;
        for (String w : genders) {
            if (w.equalsIgnoreCase("female")) {
                numOfFemale++;
            }

            assertTrue(numOfFemale <= genders.size() - numOfFemale);

        }

        //2.yol:Kadin ve erkek sayilarini Groovy ile bulalim
        List<String> femaleGenders = response.jsonPath().getList("data.findAll{it.gender=='female'}.gender");
        System.out.println(femaleGenders);
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println(femaleNames);
        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println(maleNames);
        assertTrue(femaleNames.size()<=maleNames.size());

        //Lambda ile
        double female = response.jsonPath().getList("data.gender").stream().filter(t -> t.toString().equals("female")).count();
        double male = response.jsonPath().getList("data.gender").stream().filter(t -> t.toString().equals("male")).count();

    }


}
