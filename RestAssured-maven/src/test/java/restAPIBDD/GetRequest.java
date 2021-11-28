package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void getcall() {
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.queryParam("id", 9)
					.when()
					.get("/employees")
					.then()
					.body("[0].id", Matchers.equalTo(1))
					.body("[0].name", Matchers.equalTo("Rahul"))
					.body("[0].salary", Matchers.equalTo("5000"))
					.statusCode(200)
					.log()
					.body();
		
	}

}
