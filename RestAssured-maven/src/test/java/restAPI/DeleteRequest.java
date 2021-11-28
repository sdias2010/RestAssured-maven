package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void deleteCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("/employees/7");
		
		String reponseBody = response.getBody().asString();
		
		System.out.println(reponseBody);
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		
	}

}
