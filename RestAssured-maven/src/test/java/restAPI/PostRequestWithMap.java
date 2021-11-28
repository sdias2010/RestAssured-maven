package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void postCall() {
			
			RestAssured.baseURI = "http://localhost:7000";
			
			RequestSpecification request = RestAssured.given();
			
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			
			jsonMap.put("name", "Joy");
			jsonMap.put("salary", "4000");
			
			Response response = request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(jsonMap)
								.post("/employees/create");
			
			String responseBody = response.getBody().asString();
			System.out.println(responseBody);
			
			int responseCode = response.getStatusCode();
			Assert.assertEquals(responseCode, 201);
								
			
		}

}
