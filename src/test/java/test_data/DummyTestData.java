package test_data;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyTestData {
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

    public static HashMap<String, Object> setUpTestData() {
        List<Integer> yaslar = new ArrayList<>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);

        HashMap<String, Object> onbirinci = new HashMap<>();
        onbirinci.put("id", 11);
        onbirinci.put("employee_name", "Jena Gaines");
        onbirinci.put("employee_salary", 90560);
        onbirinci.put("employee_age", 30);
        onbirinci.put("profile_image", "");

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("besincicalisanadi", "Airi Satou");
        expectedData.put("calisansayisi", 24);
        expectedData.put("sondanIkinciCalisanMaasi", 106450.0);
        expectedData.put("arananyaslar", yaslar);
        expectedData.put("onbirincicalisan", onbirinci);

        return expectedData;

    }

    /**
     * En yuksek maas 725000
     * En kucuk yas 19
     * Ikinci en yuksek maas 675000
     */
    public static HashMap<String, Object> setUpGet18Data() {
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("enyuksekmaas", 725000);
        expectedData.put("enkucukyas", 19);
        expectedData.put("enyuksekikincimaas", 675000);
        return expectedData;
    }

    /**
     *{
     *     "status":"success",
     *     "data":"2",
     *     "message":"Successfully! Record has been deleted"
     * }
     */
    public static JSONObject afterDeleted(){
        JSONObject testData = new JSONObject();
        testData.put("status","success");
        testData.put("data","2");
        testData.put("message","Successfully! Record has been deleted");
        return testData;
    }

}
