package APITestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import APIsFunctions.GetAllItem;
import readTestData.UserDataFileReader;

public class UtilitiesItem {

	@Test(priority = 1)
	public void getVersion() throws FileNotFoundException, IOException
	{
		System.out.println("Step1");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("VersionURL"));	

	}

	@Test(priority = 2)
	public void getHealthCheck() throws FileNotFoundException, IOException
	{
		System.out.println("Step2");
		GetAllItem.getAll(UserDataFileReader.getRequiredData("healthCheckURL"));	

	}


}
