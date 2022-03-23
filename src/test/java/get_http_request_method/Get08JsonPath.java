package get_http_request_method;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08JsonPath extends HerOkuAppBaseUrl {
        /*
    Given
        https://restful-booker.herokuapp.com/booking/5
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        response content type is “application/json”
    And
        response body should be like;
        { "firstname": "Sally",
        "lastname": "Jackson",
        "totalprice": 111,
        "depositpaid": false,
        "bookingdates": { "checkin": "2017-05-23",
                            "checkout":"2019-07-02" }
        }
         */
    @Test
    public void test(){
        spec.pathParams("1","booking","2",5);

        Response response = given()
                .accept("application/json")
                .spec(spec)
                .when()
                .get("/{1}/{2}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals("Mary",jsonPath.getString("firstname"));
        assertEquals("Smith",jsonPath.getString("lastname"));
        assertEquals(423,jsonPath.getInt("totalprice"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2016-08-30",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2020-05-10",jsonPath.getString("bookingdates.checkout"));

    }
}
