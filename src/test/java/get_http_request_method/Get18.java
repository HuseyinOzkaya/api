package get_http_request_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Get18 extends DummyBaseUrl {
    /**
     * status code : 200
     * En yuksek maas 725000
     * En kucuk yas 19
     * Ikinci en yuksek maas 67500
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

        HashMap<String, Object> expectedData = DummyTestData.setUpGet18Data();
        System.out.println(expectedData);
        JsonPath jsonPath = response.jsonPath();

        //* Status code : 200
        Assert.assertEquals(200, response.statusCode());

        List<Integer> maaslar = jsonPath.getList("data.employee_salary");
        Collections.sort(maaslar);

//      En yuksek maas 725000
        Assert.assertEquals(expectedData.get("enyuksekmaas"), maaslar.get(maaslar.size() - 1));

//      Ikinci en yuksek maas 67500
        Assert.assertEquals(expectedData.get("enyuksekikincimaas"), maaslar.get(maaslar.size() - 2));

//      En kucuk yas 19
        List<Integer> yaslar = jsonPath.getList("data.employee_age");
        Collections.sort(yaslar);
        Assert.assertEquals(expectedData.get("enkucukyas"), yaslar.get(0));


    }

}
