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

public class ProductItem {

	public static String body= PostItem.setProductBody();


	@Test(priority = 1)
	public void getAllExistedProducts() throws FileNotFoundException, IOException
	{
		System.out.println("Step1");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("ProductURL"));	

	}

	@Test(priority = 2)
	public void addProduct() throws FileNotFoundException, IOException
	{
		System.out.println("Step2");
		PostItem.PostReq(UserDataFileReader.getRequiredData("ProductURL"),body);

	}

	@Test(priority = 3)
	public void validateProductAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step3");
		GetSpecificItem.getAnExistedItem(UserDataFileReader.getRequiredData("ProductURL"),body);

	}

	@Test(priority = 4)
	public void deleteProductAlreadyAdded() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step4");
		DeleteItem.deleteAnExistedItem(UserDataFileReader.getRequiredData("ProductURL"),body);

	}

	@Test(priority = 5)
	public void updatedExistingProduct() throws FileNotFoundException, IOException, ParseException
	{
		System.out.println("Step5");
		PatchItem.updateAnExistedItem(UserDataFileReader.getRequiredData("ProductURL"),body);

	}
}
