package get_http_request_method;

import Utils.JsonUtil;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetWithObjectMapper02 extends HerOkuAppBaseUrl {

    /*
        Given
                https://restful-booker.herokuapp.com/booking/2
        When
                I send GET Request to the URL
        Then
                Status code is 200
                And response body is like {
                                            "firstname": "Mark",
                                            "lastname": "Ericsson",
                                            "totalprice": 726,
                                            "depositpaid": true,
                                            "bookingdates": {
                                                "checkin": "2015-08-07",
                                                "checkout": "2020-10-25"
                                             },
                                             "additionalneeds": "Breakfast"
                                             }
                                             }
     */

    @Test
    public void GetWithObjectMapper02(){
        //1.Step : Set the URL
        spec.pathParams("first","booking","second", 2);

        //2 Step : Set the expected data
        String expectedData = "{\n" +
                "\"firstname\": \"Eric\",\n" +
                "\"lastname\": \"Smith\",\n" +
                "\"totalprice\": 481,\n" +
                "\"depositpaid\": false,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2017-12-06\",\n" +
                "\"checkout\": \"2021-02-04\"\n" +
                "},\n" +
                "\"additionalneeds\": \"Breakfast\"\n" +
                "}\n" +
                "}";

        //2.Way Create a setUp method to convert Json Data String dynamically = > Homework

        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJava(expectedData, HashMap.class);

        //3.Step : Set the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        HashMap<String, Object> actualDataMap = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        //4.Step : Do assertion
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpad"), actualDataMap.get("depositpad"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));



    }
}
