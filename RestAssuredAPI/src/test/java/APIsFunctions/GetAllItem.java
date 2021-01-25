package APIsFunctions;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;


public class GetAllItem {


	//"http://localhost:3030/products"

	@Test
	public static void getAll(String URLData) throws FileNotFoundException, IOException
	{
		//String URL = UserDataFileReader.getRequiredData(URLData);   //GetAllProductURL"
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		get(URLData).

		then().
		assertThat().
		statusCode(200).
		log().body();


	}
}
