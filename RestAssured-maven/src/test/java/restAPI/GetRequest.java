package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void getCall() {
		
		//RestAssured.baseURI = "http://localhost:7000/employees";
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		
		//Response response = request.get();
		Response response = request.get("/employees");
		
		String reponseBody = response.getBody().asString();
		
		System.out.println(reponseBody);
		
		
	}

}
