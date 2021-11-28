package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void putcall() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("name", "Rahul");
		jsonMap.put("salary", "5000");
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(jsonMap)
					.when()
					.put("/employees/9")
					.then()
					.statusCode(200)
					.body("name", Matchers.equalTo("Rahul"))
					.body("salary", Matchers.equalTo("5000"))
					.log()
					.body();
	}

}
