package get_http_request_method;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01Dt {
    /*
        We use Gherkin Language to create test cases.
        gherkin Language has 4 main keywords; Given, When, Then, And
        Given : it is used for pre-requisites
        When : It is used for action
        Then : It is used for outputs
        And : It is used for multiple Given, When, Then
     */
    /*
                            Test Case
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User send Get Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Content type should application/json
        And
            Status line should be like HTTP/1.1 200 OK

     */
    @Test
    public void get01(){

        //1. Step : Setting URL
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2. Step : Set the expected data

        //3. Step : Send Request and get response from API
        Response response = given().when().get(url);
        response.prettyPrint();

        //4. Step : Do assertion
        /*
            If you have multiple errors in your functionality, Java will stop execution after the first error.
            Because of that, you cannot see any error message for the second, third, etc. errors.

            If the execution stopped after the first error, it is called " Hard Assertion"
            There is "Soft Assertion (verification)" as well, it does not stop execution after errors. It executes all codes
            then gives error messages for all errors.
         */
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //How to  print statuc code, status line, headers, etc. on the console.

        System.out.println("Status code is " +response.getStatusCode());
        System.out.println("Status line is " +response.getStatusLine());
        System.out.println("Content code is " +response.getContentType());
        System.out.println("Headers are \n " +response.getHeaders());
        System.out.println("Server eaders is " +response.getHeader("Server"));
        System.out.println("Time is " +response.getTime());

    }
}

