package APIsFunctions;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import readTestData.UserDataFileReader;

public class PatchItem {


	public static long ItemID;
	public static String CategoryId;
	public static String ItemName=null;      
	public  static String updatedBody = null;


	public static void updateBodyName() throws FileNotFoundException, IOException
	{
		ItemName=UserDataFileReader.getRequiredData("name");
		updatedBody="{\"name\" :\""+ItemName+ "\" }";

	}

	public static void updateAnExistedItem(String URLData,String requestBody) throws ParseException, FileNotFoundException, IOException
	{

		PostItem.getAddedItemID(URLData,requestBody);
		ItemID=PostItem.ItemID;
		updateBodyName();
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("x-powered-by","Express").
		header("vary","Accept").
		body(updatedBody).
		when().
		patch(URLData+"/"+ItemID).
		then().
		assertThat().
		statusCode(200).
		log().body();


		String retrivedData=get(URLData+"/"+ItemID).asString();
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(retrivedData); 
		String changedName=(String) json.get("name");
		assertEquals(changedName,ItemName);
		System.out.println(changedName);

	}


	public static void updateAnExistedCategory(String URLData,String requestBody) throws ParseException, FileNotFoundException, IOException
	{

		PostItem.getAddedCategoryID(URLData,requestBody);
		CategoryId=PostItem.CategoryID;
		updateBodyName();
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("x-powered-by","Express").
		header("vary","Accept").
		body(updatedBody).
		when().
		patch(URLData+"/"+CategoryId).
		then().
		assertThat().
		statusCode(200).
		log().body();


		String retrivedData=get(URLData+"/"+CategoryId).asString();
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(retrivedData); 
		String changedName=(String) json.get("name");
		assertEquals(changedName,ItemName);
		System.out.println(changedName);

	}
	
	public static void updateItemNotExist(String URLData) throws ParseException, FileNotFoundException, IOException
	{
		ItemID=new Random().nextLong();
		updateBodyName();
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("x-powered-by","Express").
		header("vary","Accept").
		body(updatedBody).
		when().
		patch(URLData+"/"+ItemID+"#").
		then().
		assertThat().
		statusCode(404).
		log().body();

	}
	

	public static void updateCategoryNotExist(String URLData) throws ParseException, FileNotFoundException, IOException
	{
		CategoryId=RandomStringUtils.randomNumeric(5);
		updateBodyName();
		given().

		header("access-control-allow-origin","*").
		header("connection","keep-alive").
		header("content-type","application/json").
		header("x-powered-by","Express").
		header("vary","Accept").
		body(updatedBody).
		when().
		patch(URLData+"/"+CategoryId+"#").
		then().
		assertThat().
		statusCode(404).
		log().body();


	}

}
