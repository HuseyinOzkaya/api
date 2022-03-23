package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get015MapEnZor extends DummyBaseUrl {
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
        while (statusCode != 200 && count < 3) {
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
        HashMap actualData = response.as(HashMap.class);
        System.out.println(actualData);

        //Assertion Status Code
        Assert.assertEquals(200, response.statusCode());
        //    response.prettyPrint();

        //5. calisanin isminin "Airi Satao" oldugunu
        Assert.assertEquals(expectedData.get("besincicalisanadi"),
                ((Map) ((List) actualData.get("data")).get(4)).get("employee_name"));

        // calisan sayisinin 24 oldugunu
        Assert.assertEquals(expectedData.get("calisansayisi"), ((List) actualData.get("data")).size());

        //* Sondan 2. calisanin maasinin 106450 oldugunu
        int listSize = ((List) actualData.get("data")).size();
        Assert.assertEquals(expectedData.get("sondanIkinciCalisanMaasi"),
                ((Map) ((List) actualData.get("data")).get(listSize - 2)).get("employee_salary"));

        // 40,21 ve 19 yaslarinda calisanlar olup olmadigini
        List<Double> actualYasListesi = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            actualYasListesi.add(((Double) ((Map) ((List) actualData.get("data")).get(i)).get("employee_age")));
        }
        Assert.assertTrue(actualYasListesi.containsAll((List)(expectedData.get("arananyaslar"))));

        /*
         * 11. calisan bilgilerinin
         * {
         * "id": 11,
         * "employee_name": "Jena Gaines",
         * "employee_salary": 90560,
         * "employee_age": 30,
         * "profile_image": ""
         * }
         */

        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_name"),  ((Map)((List)actualData.get("data")).get(10)).get("employee_name"));

        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_salary"),  ((Map)((List)actualData.get("data")).get(10)).get("employee_salary"));

        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("employee_age"),  ((Map)((List)actualData.get("data")).get(10)).get("employee_age"));

        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("id"),  ((Map)((List)actualData.get("data")).get(10)).get("id"));

        Assert.assertEquals(((Map)expectedData.get("onbirincicalisan")).get("profile_image"),  ((Map)((List)actualData.get("data")).get(10)).get("profile_image"));

    }
}