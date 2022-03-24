package delete_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.RectangularShape;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class deleteRequest1 extends JsonPlaceHolderBaseUrl {
           /**
            Given
                https://jsonplaceholder.typicode.com/todos/198
            When
                 I send DELETE Request to the Url
             Then
                 Status code is 200
                 And Response body is { }
         */

        @Test
        public void test(){
            spec.pathParams("1","todos","2",198);

            Response response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .delete("/{1}/{2}");
            Assert.assertEquals(200, response.statusCode());
            HashMap actualData = response.as(HashMap.class);
            Assert.assertEquals(0, actualData.size());

        }

}
