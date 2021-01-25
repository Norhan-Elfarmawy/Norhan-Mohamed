package APIsFunctions;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class GetSpecificItem {

	public static long ItemId;
	public static String categoryId;

	//@Test
	public static void getAnExistedItem(String URLData,String requestBody) throws ParseException    
	{

		PostItem.getAddedItemID(URLData,requestBody);
		ItemId=PostItem.ItemID;
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		get(URLData+"/"+ItemId).

		then().
		assertThat().
		statusCode(200).
		log().body();

	}

	public static void getAnExistedCategory(String URLData,String requestBody) throws ParseException    
	{

		PostItem.getAddedCategoryID(URLData,requestBody);
		categoryId=PostItem.CategoryID;
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		get(URLData+"/"+categoryId).

		then().
		assertThat().
		statusCode(200).
		log().body();

	}
	
	public static void getItemNotExist(String URLData) throws ParseException    
	{
		ItemId=new Random().nextLong();
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		get(URLData+"/"+ItemId+"#").

		then().
		assertThat().
		statusCode(404).
		log().body();

	}
	
	public static void getCategoryNotExist(String URLData) throws ParseException    
	{

		categoryId=RandomStringUtils.randomNumeric(5);
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		get(URLData+"/"+categoryId+"#").

		then().
		assertThat().
		statusCode(404).
		log().body();

	}
}
