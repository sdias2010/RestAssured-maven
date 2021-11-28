package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonFile {
	
	@Test
	public void postCall() throws IOException {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		String jsonBody = readJson("data.json");
		
		Response response = request.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(jsonBody)
							.post("/employees/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 201);
							
		
	}
	
	public String readJson(String filePath) throws IOException{

			return new String(Files.readAllBytes(Paths.get(filePath)));
		
	}

}
