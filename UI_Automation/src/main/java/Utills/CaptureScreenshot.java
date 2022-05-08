package Utills;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import Base.BrowserFactory;

public class CaptureScreenshot extends BaseClass
{


  public CaptureScreenshot() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

private static int i=0;

	public static String captureSnapshot(String screenshotname) throws Exception
    {
    	try
    	{
    		
    	i++;
    	TakesScreenshot ts =(TakesScreenshot)BrowserFactory.driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        
        String snapPath= propObjRef.getProperty("TestReport")+screenshotname.concat(Integer.toString(i))+".png";
        System.out.println("snapshot path"+snapPath);
        File destination=new File(snapPath);
        FileUtils.copyFile(source, destination);
        return snapPath;
    	}
    	catch(Exception e)
    	{
    		System.out.println("error while taking screenshot"+e.getMessage());
    		return e.getMessage();
    	}
    }
}
