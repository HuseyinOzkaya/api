package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class PostNt01 extends JsonPlaceHolderBaseUrl {
      /*
        Given    https://jsonplaceholder.typicode.com/comments
            {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
            When I send Post Request to the URL
            Then the status code should be 201
            Response should be like
                 {
                "name": "This class has smart people",
                "postId": 80,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
         */

    @Test
    public void post01(){

    }
}
