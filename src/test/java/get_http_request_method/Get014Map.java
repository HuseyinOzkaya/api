package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get014Map extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User send a request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose first name is “Mary” and last name is “Ericsson”
 */
    @Test
    public void get05() {

        spec.pathParams("first", "booking", "second", 2);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        HashMap<String, Object> expectedData = HerOkuAppTestData.setUpTestData();
        HashMap actualData = response.as(HashMap.class);

        System.out.println(expectedData);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        System.out.println(((Map) expectedData.get("bookingdates")).get("checkin"));
        System.out.println(((Map) expectedData.get("bookingdates")).get("checkout"));
        Assert.assertEquals(((Map) expectedData.get("bookingdates")).get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map) expectedData.get("bookingdates")).get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));



    }
}