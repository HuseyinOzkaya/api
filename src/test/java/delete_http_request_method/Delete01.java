package delete_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
Given
https://jsonplaceholder.typicode.com/todos/198
When
            I send DELETE Request to the Url
        Then
            Status code is 200
            And Response body is {}

*/
    @Test
    public void del01 (){

        //1.Step : Set the URL

        spec.pathParams("first", "todos", "second", 198);

        //2.Step : Set the expected data
        Map<String, Object> expectedMap = new HashMap<>();

        //3.Step : Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

    }
}
