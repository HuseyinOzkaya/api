package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class Post03JSONObjectBasic extends JsonPlaceHolderBaseUrl {
    /**
     * jsonplaceholder.typicode.com/todos
     * {
     *     "userId":55,
     *     "title":"Tidy your room",
     *     "completed":false
     * }
     *
     * posttan sonra kontrol et
     * status code 201 ve body nin asagidaki gibi oldugunu kontrol et
     * {
     *     "userId":55,
     *     "title":"Tidy your room",
     *     "completed":false
     * }
     */
    @Test
    public void test(){
       spec.pathParam("1","todos");
        JSONObject testData = JsonPlaceHolderTestData.requestAndExpectedData();
        System.out.println(testData);
        Response response = given()
                .accept("application/json")
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testData.toString())
                .when()
                .post("/{1}");
        response.prettyPrint();

        JsonPath actualData = response.jsonPath();
        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals(testData.getBoolean("completed"),actualData.getBoolean("completed"));
        Assert.assertEquals(testData.getString("title"),actualData.getString("title"));
        Assert.assertEquals(testData.getInt("userId"),actualData.getInt("userId"));
    }
}
