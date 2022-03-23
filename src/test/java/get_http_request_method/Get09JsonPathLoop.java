package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get09JsonPathLoop extends DummyBaseUrl {
    
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

               response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("data.employee_name"));
        //3. kisi bilgileri
        System.out.println(jsonPath.getString("data[2]"));

        //3 kisi ismi
        System.out.println(jsonPath.getString("data[2].employee_name"));

        // ilk 5 kisiyi yazdir
        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]"));

        //son kisiyi yazdir
        System.out.println(jsonPath.getString("data.employee_name[-1]"));

    }
}
