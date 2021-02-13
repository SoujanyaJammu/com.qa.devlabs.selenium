package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

public class TC_AmazonHomePage_002 extends TestBase {
	
	
AmazonPages AmazonOR;
	
	@BeforeMethod
	public void loadPages() {
		AmazonOR= new AmazonPages(Driver);
	}
	
	@Test
	public void getFooterlinks() throws IOException {
		// check if the amazon home page has 200 footer links
		List<WebElement> allFooterLinks = AmazonOR.getAllFooterLinks();
		int size = allFooterLinks.size();
		
		if(size==200) {
			Reporter.log("There are 200 links on the page");
			Assert.assertTrue(true);
			
			
		}else{
			Reporter.log("It is not as expeted");
			captureScreenshot(Driver,"getFooterlinks");
			Assert.assertTrue(false);
			
		}
		
		
		
	}

}

