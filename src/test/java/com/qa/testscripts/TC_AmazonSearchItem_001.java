package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

public class TC_AmazonSearchItem_001 extends TestBase {
	
	// child class that execute test steps by extending the parent class "testBase" class
	
	AmazonPages AmazonOR;
	
	@BeforeMethod
	public void loadPages() {
		AmazonOR= new AmazonPages(Driver);
	}
	
	@Test
	public void searchItem() throws IOException {
		
		AmazonOR.SetCategoryList("Books");
		AmazonOR.setSearchInput("Da vinci code");
		AmazonOR.setMagnifierBtn();
		String title = Driver.getTitle();
		boolean res = title.contains("Da vinci code");
		if(res) {
			
			Assert.assertTrue(true);
			Reporter.log("Title is correct", true);
		}
		else 
		{
			captureScreenshot(Driver,"searchItem");
			Assert.assertTrue(false);
			Reporter.log("Title is not correct", true);
			
			
		}		
		
		
	}
	
	
	
	

}
