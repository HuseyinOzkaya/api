package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get012Map extends JsonPlaceHolderBaseUrl {
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


    @Test
    public void test() {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("Server", "cloudflare");
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("completed", false);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("userId", 1.0);


        spec.pathParams("1", "todos", "2", 2);
        Response response = given().spec(spec).when().get("/{1}/{2}");
        // response.prettyPrint();
        //  System.out.println(response.getHeaders());
        System.out.println(expectedData);

        Map actualData = response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("statusCode"), response.statusCode());
        Assert.assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        Assert.assertEquals(expectedData.get("Server"), response.getHeader("Server"));

        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}
