package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import APIsFunctions.DeleteItem;
import APIsFunctions.GetAllItem;
import APIsFunctions.GetSpecificItem;
import APIsFunctions.PatchItem;
import APIsFunctions.PostItem;
import readTestData.UserDataFileReader;

public class ServiceItem {

	public static String body;

	@Test(priority = 1)
	public void getAllExistedService() throws FileNotFoundException, IOException
	{
		System.out.println("Step1");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("ServicesURL"));	

	}

	@Test(priority = 2)
	public void addService() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		body=PostItem.setServiceBody();
		PostItem.PostReq(UserDataFileReader.getRequiredData("ServicesURL"),body);

	}

	@Test(priority = 3)
	public void validateServiceAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		GetSpecificItem.getAnExistedItem(UserDataFileReader.getRequiredData("ServicesURL"),body);

	}

	@Test(priority = 4)
	public void deleteServiceAlreadyAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step4");
		DeleteItem.deleteAnExistedItem(UserDataFileReader.getRequiredData("ServicesURL"),body);

	}

	@Test(priority = 5)
	public void updatedExistingService() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step5");
		PatchItem.updateAnExistedItem(UserDataFileReader.getRequiredData("ServicesURL"),body);

	}

}
