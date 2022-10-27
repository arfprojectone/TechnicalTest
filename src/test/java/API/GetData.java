package API;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	@Test(priority=1)
	public void testGet1() {

		Response response = RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=1");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority=2)
	public void testGet5() {

		Response response = RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=5");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	public void testGet20() {

		Response response = RestAssured.get("https://api.punkapi.com/v2/beers?page=2&per_page=20");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
