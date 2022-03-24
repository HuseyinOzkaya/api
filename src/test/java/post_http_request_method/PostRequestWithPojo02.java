package post_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingPostResponseBodyPojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends HerOkuAppBaseUrl {
    /**
     *
     *     Given
     *     https://restful-booker.herokuapp.com/booking
     *
     *     {
     *                 "firstname": "Selim",
     *                 "lastname": "Ak",
     *                 "totalprice": 11111,
     *                 "depositpaid": true,
     *                 "bookingdates": {
     *                     "checkin": "2020-09-09",
     *                     "checkout": "2020-09-21"
     *                  }
     *               }
     *       When
     *
     *             I send POST Request to the Url
     *
     *             with the request body
     *
     *         Then
     *
     *             Status code is 200
     *             And response body should be like
     *             {
     *                 "bookingid": 11,
     *                 "booking": {
     *                     "firstname": "Selim",
     *                     "lastname": "Ak",
     *                     "totalprice": 11111,
     *                     "depositpaid": true,
     *                     "bookingdates": {
     *                         "checkin": "2020-09-09",
     *                         "checkout": "2020-09-21"
     *                     }
     *                 }
     *              }
     *      */

        @Test
        public void test(){
            spec.pathParam("1","booking");
            BookingDatesPojo bookingDate = new BookingDatesPojo("2020-09-09","2020-09-21");
            BookingPojo requestData = new BookingPojo("huseyin","ozkaya",2344,true,bookingDate,"");

            Response response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .body(requestData)
                    .when()
                    .post("/{1}");
            response.prettyPrint();
            Assert.assertEquals(200,response.statusCode());

            BookingPostResponseBodyPojo actualData = response.as(BookingPostResponseBodyPojo.class);
            System.out.println(actualData);

            Assert.assertEquals(requestData.getFirstname(),actualData.getBooking().getFirstname());
            Assert.assertEquals(requestData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
            Assert.assertEquals(requestData.getLastname(),actualData.getBooking().getLastname());
        }
}
