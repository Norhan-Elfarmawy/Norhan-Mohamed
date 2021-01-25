package readTestData;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class GetDataFromJsonFile {

	static JSONParser parser = new JSONParser();

	public static String getNameValue(String addedType ,String key) throws FileNotFoundException, IOException, ParseException
	{

		Object object = parser.parse(new FileReader("testData/testData.json"));
		JSONObject type=(JSONObject) object;
		JSONObject getJsonObject =(JSONObject) type.get(addedType);
		System.out.println(getJsonObject.get(key).toString());
		return getJsonObject.get(key).toString() ;
	}

	public void getValueFromJsonFile() throws FileNotFoundException, IOException, ParseException
	{
		getNameValue("AddProduct", "price");

	}



}
