package post_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import static io.restassured.RestAssured.given;

//post01 ile ayni

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
 *             And response body should be like {
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

public class PostJSONObject extends HerOkuAppBaseUrl {
    @Test
    public void test() {
        spec.pathParam("1","booking");
        JSONObject testData = HerOkuAppTestData.requestAndExpectSetup();
        System.out.println(testData);
        Response response = given()
                .accept("application/json")
                .spec(spec)
                .contentType(ContentType.JSON)
                .auth()
                .basic("admin","password123")
                .body(testData.toString())
                .when()
                .post("/{1}");
        response.prettyPrint();

        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(testData.getString("firstname"),actualData.getString("booking.firstname"));
        Assert.assertEquals(testData.getString("lastname"),actualData.getString("booking.lastname"));
        Assert.assertEquals(testData.getInt("totalprice"),actualData.getInt("booking.totalprice"));
        Assert.assertEquals(testData.getBoolean("depositpaid"),actualData.getBoolean("booking.depositpaid"));
        Assert.assertEquals(testData.getJSONObject("bookingdates").getString("checkin"),actualData.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(testData.getJSONObject("bookingdates").getString("checkout"),actualData.getString("booking.bookingdates.checkout"));
    }
}
