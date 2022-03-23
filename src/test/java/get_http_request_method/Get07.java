package get_http_request_method;


import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get07 extends JsonPlaceHolderBaseUrl {
    @Test
    public void test(){
        spec.pathParams("1","todos","2",123);

     Response response = given().accept("application/json")
             .spec(spec)
             .when()
             .get("/{1}/{2}");
     response.prettyPrint();

     response.then()
             .assertThat()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .header("Server", equalTo("cloudflare"))
             .body("userId",equalTo(7),
                     "title",equalTo("esse et quis iste est earum aut impedit"),
                     "completed",equalTo(false));
    }
}