package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get016ComplicatedMatchers extends DummyBaseUrl {
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

        response.then().assertThat().statusCode((Integer) expectedData.get("statusCode"))
                .body("data[4].employee_name", equalTo(expectedData.get("besincicalisanadi")),
                        "data.id", hasSize((Integer) expectedData.get("calisansayisi")),
                        "data[-2].employee_salary", equalTo(expectedData.get("sondanIkinciCalisanMaasi")),
                        "data.employee_age", hasItems(((List) expectedData.get("arananyaslar")).get(0),
                                ((List) expectedData.get("arananyaslar")).get(1),
                                ((List) expectedData.get("arananyaslar")).get(2)),
                        "data[10].employee_name", equalTo(((Map) expectedData.get("onbirincicalisan")).get("employee_name")),
                        "data[10].employee_salary", equalTo(((Map) expectedData.get("onbirincicalisan")).get("employee_salary")),
                        "data[10].employee_age", equalTo(((Map) expectedData.get("onbirincicalisan")).get("employee_age")));


    }
}