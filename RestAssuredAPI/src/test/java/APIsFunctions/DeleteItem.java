package APIsFunctions;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import readTestData.UserDataFileReader;

public class DeleteItem {


	public static long ItemId;
	public static String CategoryId;
	//@Test
	public static void deleteAnExistedItem(String URLData,String requestBody) throws ParseException
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
		delete(URLData+"/"+ItemId).

		then().
		assertThat().
		statusCode(200).
		log().body();


		String retrivedData=get(URLData).asString();   //"http://localhost:3030/products"
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(retrivedData); 
		JSONArray AllProductInfo = (JSONArray) json.get("data");
		for(Object object : AllProductInfo)
		{
			JSONObject checkID=null;
			checkID = (JSONObject) object;
			assertNotEquals(checkID.get("id").toString(), ItemId);
		}

	}


	public static void deleteAnExistedCategory(String URLData,String requestBody) throws ParseException
	{

		PostItem.getAddedCategoryID(URLData,requestBody);
		CategoryId=PostItem.CategoryID;
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		delete(URLData+"/"+CategoryId).

		then().
		assertThat().
		statusCode(200).
		log().body();


		String retrivedData=get(URLData).asString();   //"http://localhost:3030/products"
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(retrivedData); 
		JSONArray AllProductInfo = (JSONArray) json.get("data");
		for(Object object : AllProductInfo)
		{
			JSONObject checkID=null;
			checkID = (JSONObject) object;
			assertNotEquals(checkID.get("id").toString(), CategoryId);
		}

	}
	
	public static void deleteItemNotExist(String URLData) throws ParseException, FileNotFoundException, IOException
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
		delete(URLData+"/"+ItemId+"#").

		then().
		assertThat().
		statusCode(404).
		log().body();

	}

	public static void deleteCategoryNotExist(String URLData) throws ParseException, FileNotFoundException, IOException
	{
		CategoryId=RandomStringUtils.randomNumeric(5);

		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("content-encoding","gzip").
		header("x-powered-by","Express").
		header("vary","Accept").

		when().
		delete(URLData+"/"+CategoryId+"#").

		then().
		assertThat().
		statusCode(404).
		log().body();

	}

}
