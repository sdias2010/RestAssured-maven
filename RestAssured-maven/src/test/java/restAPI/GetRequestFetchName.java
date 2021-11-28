package restAPI;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestFetchName {
	
	@Test
	public void getCall() {
		
RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/employees");
		
//		String reponseBody = response.getBody().asString();
//		
//		System.out.println(reponseBody);
		
		JsonPath jsonpath = response.jsonPath();
		
		List<String> names = jsonpath.get("name");
		
		for(String name : names) {
			System.out.println(name);
		}
		
	}

}
