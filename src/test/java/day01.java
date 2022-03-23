import base_urls.Jsonnn_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class day01 extends Jsonnn_BaseUrl {
      /*
    Given
        https://jsonplaceholder.typicode.com/todos/23
    When
        User send GET Request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response format should be “application/json”
     And
        “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
    And
        “completed” is false
    And
        “userId” is 2

     */

    @Test
    public void dat01(){
        spec.pathParams("first","todos","second",23);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }

}
