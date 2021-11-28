package restAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {
	
	@Test
	public void postCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "Rick");
		jsonObj.put("salary", "10000");
		
		Response response = request.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(jsonObj.toString())
							.post("/employees/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 201);
							
		
	}

}
