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

public class CategoriesItem {

	public static String body;


	@Test(priority = 1)
	public void getAllExistedCategories() throws FileNotFoundException, IOException
	{
		System.out.println("Step2");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("categoriesURL"));	
	}

	@Test(priority = 2)
	public void addCategory() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step2");
		body= PostItem.setCategoryBody("FirstCategory");
		PostItem.PostReq(UserDataFileReader.getRequiredData("categoriesURL"),body);
	}

	@Test(priority = 3)
	public void validateCategoryAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		body= PostItem.setCategoryBody("SecondCategory");
		GetSpecificItem.getAnExistedCategory(UserDataFileReader.getRequiredData("categoriesURL"),body);

	}

	@Test(priority = 4)
	public void deleteCategorAlreadyAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step4");
		body= PostItem.setCategoryBody("ThirdCategory");
		DeleteItem.deleteAnExistedCategory(UserDataFileReader.getRequiredData("categoriesURL"),body);

	}

	@Test(priority = 5)
	public void updatedExistingCategory() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step5");
		body= PostItem.setCategoryBody("FourthCategory");
		PatchItem.updateAnExistedCategory(UserDataFileReader.getRequiredData("categoriesURL"),body);

	}

}
