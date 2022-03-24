package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.TodosPojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo extends JsonPlaceHolderBaseUrl {
         /*
        Given
                https://jsonplaceholder.typicode.com/todos
                {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false
                }
        When
                I send POST Request to the Url
        Then
                Status code is 201
        And
            response body is like {
                    "userId": 55,
                    "title": "Tidy your room",
                    "completed": false,
                    "id": 201
                    }
     */
    @Test
    public void test(){
        spec.pathParam("1","todos");
        TodosPojo requestData = new TodosPojo(55,"Tidy your room",false);
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(requestData)
                .when()
                .post("/{1}");
        response.prettyPrint();
        Assert.assertEquals(201,response.statusCode());

        TodosPojo actualData = response.as(TodosPojo.class);
        System.out.println(actualData);

        Assert.assertEquals(requestData.getTitle(),actualData.getTitle());
        Assert.assertEquals(requestData.isCompleted(),actualData.isCompleted());
        Assert.assertEquals(requestData.getUserId(),actualData.getUserId());

    }
}
