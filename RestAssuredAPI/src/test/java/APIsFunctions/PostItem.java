package APIsFunctions;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import io.restassured.response.Response;
import readTestData.GetDataFromJsonFile;


public class PostItem {

	public static String requestBody;
	public static String res2;
	public static Response res;
	public static long ItemID;
	public static String CategoryID;

	public static String PostReq(String URLData,String requestBody)
	{ 

		res = given().
				header("Content-Type","application/json").
				body(requestBody).
				when().
				post(URLData).
				then().
				assertThat().
				statusCode(201).
				log().body().
				extract().response();

		res2 = res.asString();
		return res2;
	}

	public static String setProductBody() {
		requestBody = 
				"{\n" +
						"  \"name\": \"testAutomation1\",\n" +
						"  \"type\": \"test1\",\n" +
						"  \"price\": 10,\n" +

                       "  \"shipping\": 1,\n" +
                       "  \"upc\": \"test\",\n" +
                       "  \"description\": \"testing Automation\",\n" +

                       "  \"manufacturer\": \"Egypt\",\n" +
                       "  \"model\": \"New Model\",\n" +
                       "  \"url\": \"http://localhost:3030/testing Automation\",\n" +

                       "  \"image\": \"testing Image\" \n" + 
                       "}";

		return requestBody;

	}

	public static String setStoreBody() {
		requestBody = 
				"{\n" +
						"  \"name\": \"TestingStore\",\n" +
						"  \"type\": \"Store\",\n" +
						"  \"address\": \"First Store Address\",\n" +
						"  \"address2\": \"Second Store Address\",\n" +

                       "  \"city\": \" Store City\",\n" +
                       "  \"state\": \"Store State\",\n" +
                       "  \"zip\": \"10115\",\n" +

                       "  \"lat\": 10,\n" +
                       "  \"lng\": 100,\n" +
                       "  \"hours\":\"10\",\n" +

                       "  \"services\":{\"name\": \" Store name\"} \r\n" + 
                       "}";
		//System.out.println(requestBody);
		return requestBody;

	}

	public static String setCategoryBody(String category) throws FileNotFoundException, IOException, ParseException {

		String CateName=GetDataFromJsonFile.getNameValue(category, "name");
		//String CateId=GetDataFromJsonFile.getNameValue(category, "id");
		String CateId=RandomStringUtils.randomNumeric(5);
		requestBody = 

				"{   \"name\" : \""+ CateName + "\"  ,"
						+ "\n \"id\"   :  \""+CateId +  "\" }";

		return requestBody;

	}

	public static String setServiceBody() throws FileNotFoundException, IOException, ParseException {

		String serviceName=GetDataFromJsonFile.getNameValue("AddService", "name");

		requestBody = 
				"{\n" +
						"  \"name\": \" "+serviceName+"\" }";

		return requestBody;

	}


	public static void getAddedItemID(String URLData,String requestBody) throws ParseException
	{
		PostReq(URLData,requestBody);
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(res2); 
		ItemID=	(Long) json.get("id");

	}

	public static void getAddedCategoryID(String URLData,String requestBody) throws ParseException
	{
		PostReq(URLData,requestBody);
		JSONParser parser = new JSONParser();  
		JSONObject json = (JSONObject) parser.parse(res2);	
		CategoryID=	(String)json.get("id");

	}
}
