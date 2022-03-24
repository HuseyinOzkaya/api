package test_data;


import org.json.JSONObject;

import java.util.HashMap;


public class HerOkuAppTestData {


    public static HashMap<String, Object> setUpTestData() {

        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-03-09");
        bookingDates.put("checkout", "2021-12-05");


        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jim");
        expectedData.put("lastname", "Jones");
        expectedData.put("totalprice", 639.0);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", bookingDates);

        return expectedData;
    }
    //-----------------------------------------------


    /**
           {
               "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
             }
*/
    public static JSONObject requestAndExpectSetup() {
        JSONObject bookingdates = new JSONObject(); //org.json.JSONObject
        bookingdates.put("checkin", "2020-09-09");
        bookingdates.put("checkout", "2020-09-21");

        JSONObject request = new JSONObject();
        request.put("firstname", "Selim");
        request.put("lastname", "Ak");
        request.put("totalprice", 11111);
        request.put("depositpaid", true);
        request.put("bookingdates", bookingdates);
        return request;
    }

}
