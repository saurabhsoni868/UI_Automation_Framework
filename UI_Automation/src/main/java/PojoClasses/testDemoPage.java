
package PojoClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;

public class testDemoPage extends BaseClass {

	public testDemoPage() throws Exception {
		super();
	}

	private String hamburgerMenu = "";

	public void verify_URL(String _url) 
	{
		extlogger.log(LogStatus.INFO, "application is Launched ");
		try {
			if (driver.getCurrentUrl().contains(_url)) {
				extlogger.log(LogStatus.PASS, "URL is correct ");
			} else {
				extlogger.log(LogStatus.FAIL, "URL is Wrong ");
			}

		} catch (WebDriverException e) {
			extlogger.log(LogStatus.ERROR, "verifying URL gives Error", "throws error" + e.getMessage());
		}

	}

}
