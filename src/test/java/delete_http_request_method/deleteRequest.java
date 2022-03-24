package delete_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import static io.restassured.RestAssured.given;

public class deleteRequest extends DummyBaseUrl {
    /**
     * https://dummy.restapiexample.com/api/v1/delete/2
     * Donen response status code : 200 ve body control et
     * {
     *     "status":"success",
     *     "data":"2",
     *     "message":"Successfully! Record has been deleted"
     * }
     */
    @Test
    public void test(){
        spec.pathParams("1","delete","2",2);
        JSONObject expectedData = DummyTestData.afterDeleted();
        Response response=null;
        int count =0;
        int statuscode =0;
        while(statuscode!=200 && count<10) {
             response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .delete("/{1}/{2}");
            count++;
            System.err.println(response.statusCode());
            statuscode=response.statusCode();
        }
        response.prettyPrint();
        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getString("status"),actualData.getString("status"));
        Assert.assertEquals(expectedData.getString("data"),actualData.getString("data"));
        Assert.assertEquals(expectedData.getString("message"),actualData.getString("message"));

    }

}
