//package put_http_request_method;
//
//import base_urls.JsonPlaceHolderBaseUrl;
//import com.google.gson.Gson;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.junit.Test;
//import test_data.JsonPlaceHolderTestData;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.*;
//import static org.junit.Assert.assertEquals;
//
//public class Put01Dt extends JsonPlaceHolderBaseUrl {
//    /*
//    Given
//        https://jsonplaceholder.typicode.com/todos/198
//        {
//        "userId": 21,
//        "title": "Wash the dishes",
//        "completed": false
//       }
//    When
//        I send PUT Request to the Url
//        with the PUT Request body like
//    Then
//           Status code is 200
//           And response body is like   {
//                                        "userId": 21,
//                                        "title": "Wash the dishes",
//                                        "completed": false
//                                       }
//     */
//@Test
//public void put01(){
//
//    //1.Step : Set the URL
//    spec.pathParams("first", "todos", "second", 198);
//    //2.Step : Set the request body data
//    JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
//    Map<String, Object> requestBodyMap = requestBody.expectedDataSetUpWithAllKeys(21,"Wash the dishes", false);
//    //3. STep : Sent the request get the response
//    Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().put("/{first}/{second}");
//    response.prettyPrint();
//    //Use GSON to convert response body to a map
//    Map<String, Object> actualDataMap = response.as(HashMap.class);
//    //4.Step : Do assertions
//    assertEquals(200, response.getStatusCode());
////    assertEquals(requestBodyMap.get("userId"), actualDataMap.get("userId"));
//    assertEquals(requestBodyMap.get("title"), actualDataMap.get("title"));
//    assertEquals(requestBodyMap.get("completed"), actualDataMap.get("completed"));
//
//    //How to "Serialization"
//    // Serialization : Converting Java Object to Json Data
//    Map<String, Object> ages = new HashMap<>();
//    ages.put("Ali Can", 13);
//    ages.put("Veli Han", 25);
//    ages.put("Mary Star", 21);
//    ages.put("Angelina Julie", 46);
//    System.out.println(ages);
//
//    //Create GSON Object
//    Gson gson = new Gson();
//
//    //By using "gson" object access to the methods and select the method which you need
//   String jsonFromJava =  gson.toJson(ages);
//    System.out.println(jsonFromJava);
//
//}
//}
