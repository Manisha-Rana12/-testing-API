package test1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class ApiDemo {

	String url = "https://fake-store-api.mock.beeceptor.com";
	
	@Test(enabled=true)
	public void getAListOfProduct() {
		
		RestAssured.baseURI = url;
		
		given().when().get("/api/products").then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void getAListOfRegisteredUsers() {
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/users").then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void getAListOfCarts() {
		
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/carts").then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void getOrderDetails() {
		
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/orders/status\\?order_id=1").then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void getAListOfOrder() {
		
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/orders").then().statusCode(200).log().all();
	}
	
	@Test(enabled=true)
	public void putANewOrder() {
		
		
		RestAssured.baseURI = url;
	
		
//		// Create the request payload
//        String requestBody =" 
//        		{
//                "user_id": 1,
//                "items": [
//                    { "product_id": 1, "quantity": 2 },
//                    { "product_id": 3, "quantity": 1 }
//                ]
//            }
//            ";
		
		// JSON payload
        String jsonPayload = "{\n" +
                "  \"items\": [\n" +
                "    { \"product_id\": 1, \"quantity\": 2 },\n" +
                "    { \"product_id\": 3, \"quantity\": 1 }\n" +
                "  ]\n" +
                "}";
        // Sending PUT request
        Response response = RestAssured.given().contentType(ContentType.JSON).header("user_id", "1")
        		            .body(jsonPayload).when().put("/api/orders").then().extract().response();
                
                
        // Printing the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
		
  }

	}

//   {
//	  "user_id": 1,
//	  "items": [ { "product_id": 1, "quantity": 2 }, { "product_id": 3, "quantity": 1 } ]
//	 }

       