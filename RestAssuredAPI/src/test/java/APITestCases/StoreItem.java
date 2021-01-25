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

public class StoreItem {

	public static String body= PostItem.setStoreBody();

	@Test(priority = 1)
	public void getAllExistedStores() throws FileNotFoundException, IOException
	{
		System.out.println("Step1");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("StoresURL"));	
	}

	@Test(priority = 2)
	public void addItem() throws FileNotFoundException, IOException
	{
		System.out.println("Step2");
		PostItem.PostReq(UserDataFileReader.getRequiredData("StoresURL"),body);
	}
	

	@Test(priority = 3)
	public void validateServiceAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		GetSpecificItem.getAnExistedItem(UserDataFileReader.getRequiredData("StoresURL"),body);

	}

	@Test(priority = 4)
	public void deleteServiceAlreadyAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step4");
		DeleteItem.deleteAnExistedItem(UserDataFileReader.getRequiredData("StoresURL"),body);

	}

	@Test(priority = 5)
	public void updatedExistingService() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step5");
		PatchItem.updateAnExistedItem(UserDataFileReader.getRequiredData("StoresURL"),body);

	}

}
