package practice;

import base_urls.RestApiExampleUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DummyGet04 extends RestApiExampleUrl {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            This user exists in the system
            "status": "success",
            "data": {
                "id": 5,
                "employee_name": "Airi Satou",
                "employee_salary": 162700,
                "employee_age": 33,
                "profile_image": ""
            },
    "message": "Successfully! Record has been fetched."
        },
     */

    @Test
    public void test04() {
        spec.pathParams("first", "api", "second", "v1", "third", "employee","final",5);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status", equalTo("success"),"data.id",5,
                        "data.employee_name",equalTo("Airi Satou"),"data.employee_salary",162700,
                        "data.employee_age",33,"message",equalTo("Successfully! Record has been fetched."));
    }
}
