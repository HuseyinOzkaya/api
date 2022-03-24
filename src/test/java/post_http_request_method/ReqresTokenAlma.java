package post_http_request_method;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ReqresTokenAlma extends ReqresBaseUrl {
    @Test
    public void test() {
    spec.pathParams("1", "api", "2", "login");
        HashMap<String,String> requestBody = new HashMap<>();
        requestBody.put("email","eve.holt@reqres.in");
        requestBody.put("password","cityslicka");

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/{1}/{2}");
      //  response.prettyPrint();
    }
}
