package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void postCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response =  request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body("{\r\n"
										+ "    \"name\": \"John\",\r\n"
										+ "    \"salary\": \"7000\"\r\n"
										+ "  }")
								.post("/employees/create");
		
		String responseBody = response.getBody().asString();		
		System.out.println(responseBody);
		
		int responseCode = response.getStatusCode();		
		Assert.assertEquals(responseCode, 201);
	}

}
