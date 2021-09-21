package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class GetWithPojo01 extends HerOkuAppBaseUrl {
/*


    Given
             https://restful-booker.herokuapp.com/booking/2
    When
             I send GET Request to the URL
    Then
    Status code is 200
    And
            Response body is like {
                 "firstname": "Mary",
                "lastname": "Smith",
                "totalprice": 647,
                "depositpaid": false,
                "bookingdates": {
                      "checkin": "2016-02-05",
                      "checkout": "2021-01-16"
                      }
                "additionalneeds": "Breakfast"

    }

 */

    @Test
    public void getWithPojo01 (){

        //1.Step : Ste the URL
        spec.pathParams("first", "booking", "second", 2);

        //2.Step : Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2016-02-05","2021-01-16");
        BookingPojo booking = new BookingPojo("Mary", "Smith", 647, false, bookingDates, "Breakfast");


        //3.Step : Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.Step : Do assertions
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println(actualData);










    }
}
