package get_http_request_method;

import base_urls.HerOkuAppBaseUrl_Exp;
import org.junit.Test;

public class Get01_Exp extends HerOkuAppBaseUrl_Exp {
  /* Test Case:

        Given
            https://restful-booker.herokuapp.com/booking/24
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
        spec.pathParams("first", "booking", "second", 24);







    }

}
