package test_data;

import java.util.HashMap;
import java.util.Map;

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
}
