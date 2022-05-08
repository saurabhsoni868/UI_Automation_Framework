package Base;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utills.PropertyReader;
import Utills.SendEmailReport;


public class BaseClass extends BrowserFactory
{
	public static PropertyReader properties;
	public static Properties propObjRef;
	public String BrowserName ;
	public String Web_URL ; 
	public static ExtentReports extent;
	public static ExtentTest extlogger;
	
	
	
	public BrowserFactory browserfactory;

	
	// constructor
	public BaseClass() throws Exception
	{
		propObjRef = PropertyReader.getPropertFileObject();
		browserfactory = new BrowserFactory();
	}
	
	
	
	
	@BeforeSuite
	public void StepsBeforeRunnigSuite()
	{
	    BrowserName =  propObjRef.getProperty("Browser_Name");
	    Web_URL =  propObjRef.getProperty("WebURL");
	}
	
	@BeforeClass
	public void LaunchBrowser() throws MalformedURLException
	{
		browserfactory.getBrowser(BrowserName);
		browserfactory.maximizeWindow();
	}
	
	@AfterSuite
	public void StepsAfterRunnigSuite() throws MalformedURLException, EmailException
	{
		//SendEmailReport.sentReport_via_Mail();
	}
}
