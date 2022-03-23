package get_http_request_method;

import base_urls.GoRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestApiBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination total" is 1552
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should be 31
        And
            We have at least one "active" status
        And
            "Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra" are among the users
        And
            The female users are more than male users
     */
    @Test
    public void get11(){

        //1.Step the URL
        spec.pathParam("first", "users");

        //2.Step : Set the expected data

        //3.Step : Send the GET request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();



        //4.Step : Do assertion

        //1.Way
        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit", equalTo(20),
                        ( "meta.pagination.links.current"),equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id", hasSize(20),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra"));

        //2.Way  User JsonPath to assert
        JsonPath json = response.jsonPath();

        assertEquals(20,json.getInt("meta.pagination.limit"));
        assertEquals("https://gorest.co.in/public/v1/users?page=1",json.getString("meta.pagination.links.current"));
        assertEquals(20,json.getList("data.id").size());
        assertTrue(json.getList("data.status").contains("active"));

        List<String> expectedNamesList = Arrays.asList("Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra");
        assertTrue(json.getList("data.name").containsAll(expectedNamesList));


        //The number of females are more than the number of males
        List<String> genderList = json.getList("data.gender");
        System.out.println(genderList);
        //1.Way for loop
        int femalecounter =0;
        for(String w : genderList){
            if(w.equals("female")){
                femalecounter++;
            }
        }
        assertTrue(femalecounter>genderList.size()-femalecounter);

        //2.Way Use goruve
        List <String> femaleList = json.getList("data.findAll{it.gender = 'female'}.gender");
        System.out.println(femaleList.size());

        List <String> maleList = json.getList("data.findAll{it.gender = 'male'}.gender");
        System.out.println(maleList.size());


        assertTrue(femaleList.size() >= maleList.size());







        //The number of active status is more than 5
        List <String> statusList = json.getList("data.status");
        System.out.println(statusList);
        //1.Way User Loop
        int statusCounter = 0;
        for (String w : statusList){
            if(w.equals("active")){
                statusCounter++;
            }
        }
        assertTrue(statusCounter>5);

        //2.User groovy
        List <String> listOfActiveStatus = json.getList("data.findAll{it.status='active'}.status");
        System.out.println(listOfActiveStatus);

        assertTrue(listOfActiveStatus.size()>5);

    }
}
