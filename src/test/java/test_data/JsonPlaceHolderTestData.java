package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public static Map<String,Object> setData(){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("Server", "cloudflare");
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("completed", false);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("userId", 1.0);

        return expectedData;
    }
}