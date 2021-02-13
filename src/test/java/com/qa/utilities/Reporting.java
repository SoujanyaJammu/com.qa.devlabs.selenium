package com.qa.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	ExtentHtmlReporter HtmlReporter;
	ExtentReports xReport;
	ExtentTest logger;
	
	
	
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		
		
		
		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		HtmlReporter.config().setDocumentTitle("Test Automation");
		HtmlReporter.config().setReportName("Functional Test automation report");
		HtmlReporter.config().setTheme(Theme.DARK);
		HtmlReporter.config().setAutoCreateRelativePathMedia(true);
		
		xReport = new ExtentReports();
		xReport.attachReporter(HtmlReporter);
		xReport.setSystemInfo("QA name", "Jyothi");
			
		
	}



	public void onTestSuccess(ITestResult tr) {
		
		logger = xReport.createTest(tr.getName()); // create an entry into extent report...
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		

	}


	public void onTestFailure(ITestResult tr) {
		logger = xReport.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable());
		
		String Sspath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() +".png";
		
		try {
			logger.fail("Screenshot of test failed is:" + logger.addScreenCaptureFromPath(Sspath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}


	public void onTestSkipped(ITestResult tr) {
		logger = xReport.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));

	}
	
	public void onFinish(ITestContext testContext) {
		xReport.flush();

	}


}
