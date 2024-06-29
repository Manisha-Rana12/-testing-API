package test1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
public class CryptoWallet {
         
	    String url = "https://crypto-wallet-server.mock.beeceptor.com";
	
	@Test(enabled = false)
	public void rejistereAUserAndCreateWallet() {
		
		
		RestAssured.baseURI = url;
		
		
		JSONObject jo = new JSONObject();
		
		jo.put("username", "user123");
		
		jo.put("password", "securepassword");
		
		jo.put("email", "user@example.com");
		
		given().contentType(ContentType.JSON).body(jo.toJSONString()).when()
		.post("/api/v1/register").then().statusCode(200)
		.log().all().extract().response();
		
		
	}
	
	@Test(enabled = false)
	public void userLogin() {
		
		
		RestAssured.baseURI = url;
		
		
		JSONObject jo = new JSONObject();
		
		jo.put("username", "user123");
		
		jo.put("password", "securepassword");
		
		given().contentType(ContentType.JSON).body(jo.toJSONString()).when()
		.post("/api/v1/login").then().statusCode(200)
		.log().all().extract().response();
		
		//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
	}
	
	@Test(enabled=false)
	public void retriveBalance() {
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/v1/balance")
		.then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void transactions() {
		
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/v1/transactions")
		.then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void transfer5ETH() {
		
		
		RestAssured.baseURI = url;
		
		
		JSONObject js = new JSONObject();
		
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		js.put("amount", "5.0");
		
		js.put("currency", "ETH");
		
		given().when().contentType(ContentType.JSON).post("/api/v1/transactions")
		.then().log().all();
	}
	
	@Test(enabled=false)
	public void calculateTransaction() {
		
		
		RestAssured.baseURI = url;
		
		
        JSONObject js = new JSONObject();
		
		js.put("amount", "2.5");
		
		js.put("currency", "BTC");
		
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		given().when().contentType(ContentType.JSON).post("/api/v1/transaction_fee")
		.then().log().all();
	}
	
	@Test(enabled=true)
	public void availableCurrency() {
		
		
		RestAssured.baseURI = url;
		
		
		given().when().get("/api/v1/exchange_rates")
		.then().statusCode(200).log().all();
	}
}
