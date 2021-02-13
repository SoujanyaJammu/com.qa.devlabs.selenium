package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver Driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
	@Parameters({"Browser"})
	@BeforeClass
	public void setUp(String Browser) {
		
		try {
			fileLoc = new FileInputStream("D:\\SeleniumTraining\\com.qa.devlabs.selenium\\Configuration\\config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		
		if(Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            Driver = new ChromeDriver();
        } else if(Browser.equalsIgnoreCase("firefox")) {
        	 System.setProperty("webdriver.geckodriver.driver","c:\\eclipse\\geckodriver.exe");
        	 Driver = new FirefoxDriver();
        } else if(Browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            Driver = new InternetExplorerDriver();
        } 
		
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.get(prop.getProperty("url"));
		
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quit();
	}
	
	
	
	public void captureScreenshot(WebDriver Driver, String tname) throws IOException {
		
		
		TakesScreenshot ts = (TakesScreenshot) Driver;
		File Src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Src, dest);
		System.out.println("Screen shot is captured");
		
		
	}

}
