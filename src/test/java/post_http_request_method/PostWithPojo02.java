package post_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class PostWithPojo02 extends HerOkuAppBaseUrl {
    /*


    Given
             https://restful-booker.herokuapp.com/booking/

             {
                 "firstname": "Orcun",
                "lastname": "Fazli",
                "totalprice": 998,
                "depositpaid": true,
                "bookingdates": {
                      "checkin": "2021-09-21",
                      "checkout": "2021-12-21"
                      }
                "additionalneeds": "Breakfast with coffee, Dragon Juice"
    }
    When
             I send POST Request to the URL
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
    public void postWithPojo02(){
    //1.Step : Set the URL
    spec.pathParam("first","booking");

    //2.Step: Set request body
    BookingDatesPojo bookingDates = new BookingDatesPojo("2021-09-21","2021-12-21");
    BookingPojo requestBody = new BookingPojo("Orcun", "Fazli", 998, true, bookingDates, "Breakfast with coffee, Dragon Juice");
    //3.Step : Send the request and get the response

    Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}");
    response.prettyPrint();



}
}






