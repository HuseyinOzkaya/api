package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public static Map<String, Object> setData() {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("Server", "cloudflare");
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("completed", false);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("userId", 1.0);

        return expectedData;
    }

    /**
     * {
     * "userId":55,
     * "title":"Tidy your room",
     * "completed":false
     * }
     */

    public static JSONObject requestAndExpectedData() {
        JSONObject testdata = new JSONObject();
        testdata.put("userId", 55);
        testdata.put("title", "Tidy your room");
        testdata.put("completed", false);
        return testdata;
    }

    /**
     * {
     * "userId":21,
     * "title":"Wash the dishes",
     * "completed":false
     * }
     */

    public static JSONObject putTestData() {
        JSONObject testData = new JSONObject();
        testData.put("userId", 21);
        testData.put("title", "Wash the dishes");
        testData.put("completed", false);
        return testData;
    }

    /**
     * {
     * "userId": 10,
     * "id": 198,
     * "title": "Hello",
     * "completed": true
     * }
     */

    public static JSONObject patchRequestData() {
        JSONObject testData = new JSONObject();
        testData.put("title", "Huseyin Ozkaya okuma kitabi");
        return testData;
    }


    public static JSONObject patchExpectedData() {
        JSONObject testData = new JSONObject();
        testData.put("userId", 10);
        testData.put("title", "Huseyin Ozkaya okuma kitabi");
        testData.put("completed", true);
        return testData;
    }

    /**
     * {
     * "userId": 10,
     * "id": 198,
     * "title": "Hello",
     * "completed": true
     * }
     */
    public String expectedDataInString(int userId, String title, boolean completed) {
        String jsonData = "{\n" +
                " \"userId\":" + userId + ",\n" +
                " \"title\":" + "\"" + title + "\",\n" +
                " \"completed\":" + completed +
                " }";
        return jsonData;
    }
}

