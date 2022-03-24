package patch_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchBasic extends JsonPlaceHolderBaseUrl {
    /**
     * /**
     *    jsonplaceholder.typicode.com/todos/198
     *    {
     *      "title":"Huseyin Ozkaya okuma kitabi"
     *    }
     *
     *    ve kontrol et
     *    status code : 200
     *
     *   {
     *     "userId": 10,
     *     "id": 198,
     *     "title": "Huseyin Ozkaya okuma kitabi",
     *     "completed": true
     *   }
     */

    @Test
    public void test(){
        spec.pathParams("1","todos","2",198);

        JSONObject request = JsonPlaceHolderTestData.patchRequestData();
        JSONObject expectedData = JsonPlaceHolderTestData.patchExpectedData();

        Response response = given()
                .spec(spec)
                .auth()
                .basic("admin","password123")
                .contentType(ContentType.JSON)
                .body(request.toString())
                .when()
                .patch("/{1}/{2}");
        response.prettyPrint();
        Assert.assertEquals(200,response.statusCode());

        JsonPath actualPut = response.jsonPath();
        Assert.assertEquals(expectedData.getString("title"),actualPut.getString("title"));
        Assert.assertEquals(expectedData.getBoolean("completed"),actualPut.getBoolean("completed"));
        Assert.assertEquals(expectedData.getInt("userId"),actualPut.getInt("userId"));
    }
}
