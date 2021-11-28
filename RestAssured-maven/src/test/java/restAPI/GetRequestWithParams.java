package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
	
	@Test
	public void getCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.param("id", "1").get("/employees");
		
		String responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
		
		//================Verify the Response Code
		
		int responseCode = response.getStatusCode();
		
		Assert.assertEquals(responseCode, 200);
		
		//================Verify Response Headers
		
		String responseHeader = response.getHeader("Content-Type");
		
		System.out.println("Response Header--" +responseHeader);
		
		System.out.println("All Headers-- " +response.getHeaders());
		
		Assert.assertEquals(responseHeader, "application/json; charset=utf-8");
		
		//===================Verify Response Body Using JsonPath
		
		Assert.assertTrue(responseBody.contains("Pankaj"));
		
		JsonPath jsonpath = response.jsonPath();
		
		List<String> names = jsonpath.get("name");
		
		Assert.assertEquals(names.get(0), "Pankaj");
	}

}
