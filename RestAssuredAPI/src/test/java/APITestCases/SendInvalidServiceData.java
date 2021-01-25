package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import APIsFunctions.DeleteItem;
import APIsFunctions.GetSpecificItem;
import APIsFunctions.PatchItem;
import readTestData.UserDataFileReader;

public class SendInvalidServiceData {


	@Test(priority = 1)
	public void getServiceNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step1");
		GetSpecificItem.getItemNotExist(UserDataFileReader.getRequiredData("ServicesURL"));
	}

	@Test(priority = 2)
	public void deleteServiceNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		DeleteItem.deleteItemNotExist(UserDataFileReader.getRequiredData("ServicesURL"));
	}

	@Test(priority = 3)
	public void updatedServiceNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		PatchItem.updateItemNotExist(UserDataFileReader.getRequiredData("ServicesURL"));

	}

}
