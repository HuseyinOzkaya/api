package post_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo1.Booking;
import pojo1.BookingPojo;
import pojo1.Bookingdates;

import static io.restassured.RestAssured.given;

public class PostPojo1Kullanarak extends HerOkuAppBaseUrl {
    @Test
    public void test() {
        spec.pathParams("1","booking");
        Bookingdates bookingdates = new Bookingdates("2021-01-01","2021-02-02");
        Booking request = new Booking("Huseyin","Ozkaya",5260,false,bookingdates,"Internet");
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .auth()
                .basic("deneme","password123")
                .body(request)
                .when()
                .post("/{1}");
        response.prettyPrint();
        Assert.assertEquals(200,response.statusCode());

        BookingPojo actualData = response.as(BookingPojo.class);
        System.err.println(actualData);
    }
}
