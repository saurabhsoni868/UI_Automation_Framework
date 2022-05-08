package Base;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowserFactory  
{
	public static  WebDriver driver;
	
	private String exePath = System.getProperty("user.dir") + "/src/main/resources/BrowserDriversExecutableFile/";

	public WebDriver getBrowser(String browserName) throws MalformedURLException {
		driver = null;
		String lowerCase_browserName = browserName.toLowerCase();
		switch (lowerCase_browserName) {
		case "firefox":
			configFirefoxDriver();
			break;
		case "ie":
			configIEDriver();
			break;
		case "chrome":
			configChromeDriver();
			break;
		default:
			configChromeDriver();
		}
		return driver;
	}

	private void configChromeDriver() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", exePath+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("test-type");
		Options.addArguments("chrome.switches", "--disable-extensions");
		// options.addArguments("--kiosk");
		driver = new ChromeDriver();
	}

	private void configFirefoxDriver() throws MalformedURLException {
		System.setProperty("webdriver.gecko.driver", exePath + "/GeckoDriver.exe");
		driver = new FirefoxDriver();
	}

	private void configIEDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", exePath + "/IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability("ignoreZoomSetting", true);
		ieCapabilities.setCapability("nativeEvents", false);
		// ieCapabilities.getCapability("requireWindowFocus");
		// ieCapabilities.setVersion("8");
		driver = new InternetExplorerDriver(ieCapabilities);
	}
	
	
	public void openurl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void closeTab() 
	{
		driver.close();
	}
	
	public void closeBrowser() 
	{
		driver.quit();
	}

}
