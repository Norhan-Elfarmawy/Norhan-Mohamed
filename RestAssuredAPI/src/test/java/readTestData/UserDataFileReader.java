package readTestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class UserDataFileReader {

	public static String getRequiredData(String requiredKey) throws FileNotFoundException, IOException {

		Properties propertyFileReader = new Properties();
		propertyFileReader.load(new FileReader("testData/URLs.properties"));
		String returnedValue=propertyFileReader.getProperty(requiredKey);
		return returnedValue; 

	}

}
