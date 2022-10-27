package API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JSONSchema {

	@Test
	public void validateJSONSchema() {

		RestAssured.baseURI = "https://api.punkapi.com/v2/beers";

		given().when().get().then().assertThat()
				.body(JsonSchemaValidator
				.matchesJsonSchema(new File("/Users/arf95/eclipse-workspace/TechnicalTest/schema.json")))
				.statusCode(200);
	}
}