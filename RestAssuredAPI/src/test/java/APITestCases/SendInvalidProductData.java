package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import APIsFunctions.DeleteItem;
import APIsFunctions.GetSpecificItem;
import APIsFunctions.PatchItem;
import readTestData.UserDataFileReader;

public class SendInvalidProductData {
	

	@Test(priority = 1)
	public void getProductNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step1");
		GetSpecificItem.getItemNotExist(UserDataFileReader.getRequiredData("ProductURL"));
	}

	@Test(priority = 2)
	public void deleteProductNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		DeleteItem.deleteItemNotExist(UserDataFileReader.getRequiredData("ProductURL"));
	}

	@Test(priority = 3)
	public void updatedProductNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		PatchItem.updateItemNotExist(UserDataFileReader.getRequiredData("ProductURL"));

	}

}
