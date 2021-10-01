package get_http_request_method;

import base_urls.HerOkuAppBaseUrl_Exp;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.HerOkuAppPojo_Exp;
import pojos.InfoPojo_Exp;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get01_Exp extends HerOkuAppBaseUrl_Exp {
  /* Test Case:

        Given
            https://restful-booker.herokuapp.com/booking/11
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like
              {
                    "firstname": "Orcun",
                    "lastname": "Fazli",
                    "totalprice": 3000,
                    "depositpaid": true,
                    "bookingdates": {
                                "checkin": "2021-09-21",
                                "checkout": "2021-09-25"
                               },
                    "additionalneeds": "Dinner"
                }
     */

    @Test
    public void get01Exp (){
        spec.pathParams("first", "booking", "second", 11);

        BookingDatesPojo bookingdates = new BookingDatesPojo("2021-09-21","2021-09-25");
        BookingPojo expectedData = new BookingPojo("Orcun","Fazli", 3000, true, bookingdates , "Dinner");
        System.out.println(expectedData);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println(actualData);

        Assert.assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());







    }

}
