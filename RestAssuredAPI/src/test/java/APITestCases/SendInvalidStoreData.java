package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import APIsFunctions.DeleteItem;
import APIsFunctions.GetSpecificItem;
import APIsFunctions.PatchItem;
import readTestData.UserDataFileReader;

public class SendInvalidStoreData {

	@Test(priority = 1)
	public void getCategoryNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step1");
		GetSpecificItem.getItemNotExist(UserDataFileReader.getRequiredData("StoresURL"));
	}

	@Test(priority = 2)
	public void deleteStoreNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		DeleteItem.deleteItemNotExist(UserDataFileReader.getRequiredData("StoresURL"));
	}

	@Test(priority = 3)
	public void updatedStoreNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		PatchItem.updateItemNotExist(UserDataFileReader.getRequiredData("StoresURL"));

	}

}
