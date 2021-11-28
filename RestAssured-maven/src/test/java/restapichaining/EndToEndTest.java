package restapichaining;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	
	@Test
	public void Test1() {
		
		String responseBody;
		String responseId;
		
		RestAssured.baseURI = "http://localhost:7000";
		
		//======================== Get Call ==================

		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/employees");
		
		responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
		
		//=========================== Post Call ==================
		
		RequestSpecification postRequest = RestAssured.given();
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "Max_new1");
		jsonObj.put("salary", "5000");
		
		Response postResponse = postRequest.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonObj.toString())
				.post("/employees/create");
		
		responseBody = postResponse.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath jpath= postResponse.jsonPath();
		responseId = jpath.get("id").toString();
		System.out.println("Id Coming from Response is " + responseId);
		
		
		//============================= Put Call ========================
		
		RequestSpecification putRequest = RestAssured.given();
		
		jsonObj.put("name", "Max");
		jsonObj.put("salary", "5000");
		
		Response putResponse = putRequest.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonObj.toString())
				.put("/employees/" + responseId);
		
		responseBody = putResponse.getBody().asString();
		System.out.println(responseBody);
		
		
		//================================ Delete Call =============================
		
		RequestSpecification deleteRequest = RestAssured.given();
		
		Response deleteResponse = deleteRequest.delete("/employees/" + responseId);
		
		responseBody = deleteResponse.getBody().asString();
		
		System.out.println(responseBody);
		
		int responseCode = deleteResponse.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		
	}

}
