package utility;

import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class TestDataForELK {

    private TestDataForELK(){

    }
    public static void sendDetailstoELK(String testCaseName, String status,String reason){
        Map<String,String> mp = new HashMap<>();
        mp.put("testCaseName",testCaseName);
        mp.put("Status",status);
        mp.put("ExecutionTime", LocalDateTime.now().toString  ());
        mp.put("Reason",reason);

       Response response= given().header("Content-Type","application/json")
                .body(mp)
                .post("http://localhost:9200/regression/results");

        Assert.assertEquals(response.statusCode(),201);

        response.prettyPrint();
    }
}
