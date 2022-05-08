package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;
import PojoClasses.testDemoPage;
import Utills.CaptureScreenshot;

public class testDemo extends BaseClass {

	
	public testDemo() throws Exception 
	{
		super();
	}

	private  testDemoPage testDemo_Page ;

	@BeforeMethod
	public void beforeTestClass() throws Exception 
	{
		extent=new ExtentReports(propObjRef.getProperty("Test_Report")+"automationTestReport.html", true);
		extent.config().documentTitle("Test Automation");
		extent.config().reportHeadline("Project Automation Test Report");
		
		testDemo_Page = new testDemoPage();
		
		browserfactory.openurl(Web_URL);
		
	}

	
	
	@Test
	public void verifyApplicationURL() throws Exception {
		try {
			extlogger = extent.startTest("Test case 1 : verify the URL of Application ");
			extlogger.log(LogStatus.INFO, "test cases one execution started");
			String webUrl = "web-frm.videoready.tv/";
			testDemo_Page.verify_URL(webUrl);
			extlogger.log(LogStatus.PASS, "test execution success");
		}

		catch (NullPointerException e) 
		{
			extlogger.log(LogStatus.ERROR, "Test case: Failed", "throws error" + e.getMessage());
		}
	}

	
	
	
	
	@AfterMethod
	public void afterEachTest(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.FAILURE || extlogger.getRunStatus() == LogStatus.ERROR) {
				String screenpath = CaptureScreenshot.captureSnapshot(result.getName());
				if (screenpath != null) {
					extlogger.log(LogStatus.FAIL, "image stored at given path", screenpath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		extent.endTest(extlogger);
		extent.flush();
	}

	
	@AfterClass
	public void shutdown() throws Exception 
	{
		browserfactory.closeTab();
		browserfactory.closeBrowser();
	}
}
