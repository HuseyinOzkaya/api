package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get013testData extends JsonPlaceHolderBaseUrl {
    /**
     * https://jsonplaceholder.typicode.com/todos/2 url sine iustek gonderildiginde
     * Status code : 200
     * BODY
     * "completed" = false
     * "title" ="quis ut nam facilis et officia qui"
     * "userId" = 1
     * HEADER
     * Via degerinin "1.1 vegur" ve
     * "Server" degerining " cloudflare" oldugunu test edin.
     */

    // Get12 ayni
    @Test
    public void test() {


        spec.pathParams("1", "todos", "2", 2);
        Response response = given().spec(spec).when().get("/{1}/{2}");

        //ExpectedData from test_data
        Map<String, Object> expectedData = JsonPlaceHolderTestData.setData();

        //actualdata
        Map <String,Object> actualData = response.as(HashMap.class);

        System.out.println("Expected : " + expectedData);
        System.out.println("Actual : " + actualData);

        Assert.assertEquals(expectedData.get("statusCode"), response.statusCode());
        Assert.assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        Assert.assertEquals(expectedData.get("Server"), response.getHeader("Server"));

        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}
