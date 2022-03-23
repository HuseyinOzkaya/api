package test_data;

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
        List<Double> yaslar = new ArrayList<>();
        yaslar.add(40.0);
        yaslar.add(21.0);
        yaslar.add(19.0);

        HashMap<String, Object> onbirinci = new HashMap<>();
        onbirinci.put("id", 11.0);
        onbirinci.put("employee_name", "Jena Gaines");
        onbirinci.put("employee_salary", 90560.0);
        onbirinci.put("employee_age", 30.0);
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
}
