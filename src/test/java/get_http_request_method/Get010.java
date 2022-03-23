package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Get010 extends DummyBaseUrl {
    /**
     * status code :200
     * 5. calisanin isminin "Airi Satou" oldugunu
     * 6. calisanin maasinin 372000 oldugunu
     * Toplam 24 tane calisan oldugunu
     * "Rhona Davidson" in employeelerden biri oldugunu
     * "21", "23", "61" yaslarinda employeeler oldugunu test edin
     */


    @Test
    public void Test() throws InterruptedException {
        Response response = null;
        int count = 0;
        int statusCode = 0;
        while (statusCode != 200 && count < 4) {
            spec.pathParams("1", "employees");
            response = given()
                    .accept("application/json")
                    .spec(spec)
                    .when()
                    .get("/{1}");

            System.err.println(response.statusCode());
            statusCode = response.statusCode();
            count++;
            Thread.sleep(1000);
        }

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Airi Satou", jsonPath.getString("data[4].employee_name"));
        Assert.assertEquals(372000, jsonPath.getInt("data[5].employee_salary"));

        Assert.assertEquals(24, jsonPath.getList("data").size());
        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));
        List<Integer> checkAges = new ArrayList<>(Arrays.asList(21,23,61));
        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(checkAges));

    }
}
