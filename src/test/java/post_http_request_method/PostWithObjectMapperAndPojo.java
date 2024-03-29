package post_http_request_method;

import Utils.JsonUtil;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostWithObjectMapperAndPojo extends JsonPlaceHolderBaseUrl {
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
    public void getWithObjectMapperAndPojo01(){
        //1.Step : Set the URL

        spec.pathParam("first", "todos");

        //2.Step : Set the request body
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();
        String expectedDate = expected.expectedDataInString(55, "Tidy your room", false);
        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJava(expectedDate, JsonPlaceHolderPojo.class);
        System.out.println(expectedDataPojo);

        //3.Step : Send the request get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataPojo).when().post("/{first}");
        response.prettyPrint();

        JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println(actualDataPojo);

        //4.Do assertion
        assertEquals(201,response.getStatusCode());

        assertEquals(expectedDataPojo.getUserId(), actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(), actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(), actualDataPojo.getCompleted());


    }

}
