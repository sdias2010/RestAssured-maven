package restAPIXML;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLRequest {
	
	@Test
	public void getCall() {
		
		RestAssured.given()
		.baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log()
		.body();
	}
	
	@Test
	public void getCallFetchData() {
		
		Response response = RestAssured.given()
							.baseUri("https://chercher.tech/sample/api/books.xml")
							.when()
							.get();
		
		String books = response.then().extract().xmlPath().getString("bookstore.book.title");
		System.out.println(books);
	}
	
	
	@Test
	public void getCallVerifyData() {
		
		Response response = RestAssured.given()
								.baseUri("https://chercher.tech/sample/api/books.xml")
								.when()
								.get();
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		String actualTitle = books.get(0).toString();
		String expectedTitle = "The Nightingale";
		
		System.out.println("Book Name is " +actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}

}
