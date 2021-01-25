package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import APIsFunctions.DeleteItem;
import APIsFunctions.GetSpecificItem;
import APIsFunctions.PatchItem;
import readTestData.UserDataFileReader;

public class SendInvalidCategoryData {

	@Test(priority = 1)
	public void getCategoryNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step1");
		GetSpecificItem.getCategoryNotExist(UserDataFileReader.getRequiredData("categoriesURL"));
	}

	@Test(priority = 2)
	public void deleteCategoryNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		DeleteItem.deleteCategoryNotExist(UserDataFileReader.getRequiredData("categoriesURL"));
	}

	@Test(priority = 3)
	public void updatedCategoryNotExist() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		PatchItem.updateCategoryNotExist(UserDataFileReader.getRequiredData("categoriesURL"));

	}
}
