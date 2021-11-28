package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void postCall() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("name", "Rohan");
		jsonMap.put("salary", "5000");
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(jsonMap)
					.when()
					.post("/employees/create")
					.then()
					.statusCode(201)
					.body("name", Matchers.equalTo("Rohan"))
					.body("salary", Matchers.equalTo("5000"))
					.log()
					.body();
	}

}
