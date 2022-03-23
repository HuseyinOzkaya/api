package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostNt01 extends JsonPlaceHolderBaseUrl {
      /*
        Given    https://jsonplaceholder.typicode.com/comments
            {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
            When I send Post Request to the URL
            Then the status code should be 201
            Response should be like
                 {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
         */

    @Test
    public void post01(){
    spec.pathParam("first", "comments");

    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("name", "This class has smart people");
    expectedData.put("postId", 81.0);
    expectedData.put("id", 501.0);
    expectedData.put("body", "Congratulations Everyone");
    expectedData.put("email", "techproedstudents@gmail.com");


    Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
    response.prettyPrint();

    Map <String, Object> actualData = response.as(HashMap.class);

        System.out.println("expectedData = > " + expectedData);
        System.out.println("actualData = > " + actualData);

    assertEquals(expectedData.get("name"),actualData.get("name"));
    assertEquals(expectedData.get("postId"),actualData.get("postId"));
    assertEquals(expectedData.get("id"),actualData.get("id"));
    assertEquals(expectedData.get("body"),actualData.get("body"));
    assertEquals(expectedData.get("email"),actualData.get("email"));








    }
}
