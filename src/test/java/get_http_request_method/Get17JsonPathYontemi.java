package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get17JsonPathYontemi extends DummyBaseUrl {
    /**
     * http://dummy.restapiexample.com/api/v1/employees url ine bir istek gonderildiginde
     * Status code : 200
     * 5. calisanin isminin "Airi Satao" oldugunu
     * calisan sayisinin 24 oldugunu
     * Sondan 2. calisanin maasinin 106450 oldugunu
     * 40,21 ve 19 yaslarinda calisanlar olup olmadigini
     * 11. calisan bilgilerinin
     * {
     * "id": 11,
     * "employee_name": "Jena Gaines",
     * "employee_salary": 90560,
     * "employee_age": 30,
     * "profile_image": ""
     * }
     */
    @Test
    public void test() throws InterruptedException {
        Response response = null;
        int count = 0;
        int statusCode = 0;
        while (statusCode != 200 && count < 5) {
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

        HashMap<String, Object> expectedData = DummyTestData.setUpTestData();
        System.out.println(expectedData);
        JsonPath jsonPath = response.jsonPath();

        //* Status code : 200
        Assert.assertEquals(200, response.statusCode());

        //         * 5. calisanin isminin "Airi Satao" oldugunu
        Assert.assertEquals(expectedData.get("besincicalisanadi"), jsonPath.getString("data[4].employee_name"));

        //       * calisan sayisinin 24 oldugunu
        Assert.assertEquals(expectedData.get("calisansayisi"), jsonPath.getList("data").size());

        //     * Sondan 2. calisanin maasinin 106450 oldugunu
        Assert.assertEquals(expectedData.get("sondanIkinciCalisanMaasi"), jsonPath.getDouble("data[-2].employee_salary"));

        //       * 40,21 ve 19 yaslarinda calisanlar olup olmadigini
        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll((Collection<Integer>) expectedData.get("arananyaslar")));

        //* 11. calisan bilgilerinin
        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_name"),jsonPath.getString("data[10].employee_name"));
        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_salary"),jsonPath.getInt("data[10].employee_salary"));
        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_age"),jsonPath.getInt("data[10].employee_age"));
        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("id"),jsonPath.getInt("data[10].id"));

    }
}