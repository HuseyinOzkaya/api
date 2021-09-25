package get_http_request_method;

import base_urls.GoRestApiBaseUrl;
import org.junit.Test;
import pojos.GoRestDataPojo;

public class Get10 extends GoRestApiBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v1/users/13
    When
        User send Get Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
            {
                "meta": null,
                "data": {
                    "id": 13,
                    "name": "Fr. Ajit Prajapat",
                    "email": "ajit_fr_prajapat@barrows.org",
                    "gender": "female",
                    "status": "active"
             }
}
     */
    @Test
    public void get10(){
        //1.Step : Set the URL
        spec.pathParams("first", "users", "second", 13);

        //2.Step : Set the expected data
        GoRestDataPojo dataPojo = new GoRestDataPojo("Fr. Ajit Prajapat","ajit_fr_prajapat@barrows.org","female","active");


    }
}
