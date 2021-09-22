package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

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
        BookingDatesPojo bookingDates = new BookingDatesPojo("2016-12-06","2020-11-20");
        BookingPojo expectedData = new BookingPojo("Jim", "Jackson", 502, true, bookingDates, null);


        //3.Step : Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.Step : Do assertions
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println(actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals("First name are not matching",expectedData.getFirstname(),actualData.getFirstname());
        assertEquals("Last name are not matching",expectedData.getLastname(),actualData.getLastname());
        assertEquals("Total prices are not matching",expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals("Deposit pad is not matching",expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals("Check in dates are not matching",expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals("Check out date are not matching",expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals("Additional needs are not matching",expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());


        }


    }

