package put_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class putRequest extends JsonPlaceHolderBaseUrl {
    /**
     * jsonplaceholder.typicode.com/todos/198
     * {
     *     "userId":21,
     *     "title":"Wash the dishes",
     *     "completed":false
     * }
     *
     * Donen response un status code :200 ve body kismi
     * {
     *     "userId":21,
     *     "title":"Wash the dishes",
     *     "completed":false,
     *     "id":198
     * }
     */
    @Test
    public void test(){
        spec.pathParams("1","todos","2",198);

        //198 sistemde oldugu icin post yapamayiz 404 donuyor sistemden
        //Teyit et

        JSONObject testData = JsonPlaceHolderTestData.putTestData();
        System.out.println(testData);
//POST
        Response postResponse = given()
                .spec(spec)
                .auth()
                .basic("admin","password123")
                .contentType(ContentType.JSON)
                .body(testData.toString())
                .when()
                .post("/{1}/{2}");
        Assert.assertEquals(404,postResponse.statusCode());

//PUT
        Response putResponse = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testData.toString())
                .when()
                .put("/{1}/{2}");
        Assert.assertEquals(200,putResponse.statusCode());
        JsonPath actualPut = putResponse.jsonPath();
        Assert.assertEquals(testData.getString("title"),actualPut.getString("title"));
        Assert.assertEquals(testData.getBoolean("completed"),actualPut.getBoolean("completed"));
        Assert.assertEquals(testData.getInt("userId"),actualPut.getInt("userId"));

    }
}
