package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Get011JsonPathGroovyDili extends DummyBaseUrl {

    /**
     * Status code : 200
     * 10 dan buyuk tum id leri yazdir - ve 10 dan buyuk 14 id oldugunu
     * 30 kucuk tum yaslari ekrana yazdir ve bu yaslarin en buyuk yasin 23 oldugunu
     * Maasin 350000 den buyuk olan tum employee name'leri ekrana yazdir ve bunlarin icersinde "Charde Marshall" oldugunu test edin
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
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200, response.statusCode());
        //  response.prettyPrint();

        //     * 10 dan buyuk tum id leri yazdir - ve 10 dan buyuk 14 id oldugunu

        List<Integer> ondanBuyukIdler = jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println(ondanBuyukIdler);
        Assert.assertEquals(14, ondanBuyukIdler.size());

        //     * 30 kucuk tum yaslari ekrana yazdir ve bu yaslarin en buyuk yasin 23 oldugunu
        List<Integer> otuzdanKucukYas = jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println(otuzdanKucukYas);
        Collections.sort(otuzdanKucukYas);
        Assert.assertEquals(23, (int)otuzdanKucukYas.get(otuzdanKucukYas.size()-1));


        //   * Maasin 350000 den buyuk olan tum employee name'leri ekrana yazdir ve bunlarin icersinde "Charde Marshall" oldugunu test edin

        List<String> ucYuzElliMaasAlan = jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(ucYuzElliMaasAlan);
        Assert.assertTrue(ucYuzElliMaasAlan.contains("Charde Marshall"));
    }
}
