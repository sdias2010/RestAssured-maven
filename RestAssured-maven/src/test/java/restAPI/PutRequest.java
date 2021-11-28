package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
	public void putCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("name", "Peter");
		jsonMap.put("salary", "6000");
		
		Response response = request.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(jsonMap)
							.put("/employees/4");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
							
		
	}

}
