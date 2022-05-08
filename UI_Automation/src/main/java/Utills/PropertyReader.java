package Utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;


public class PropertyReader 
{
	public static Properties getPropertFileObject()
	{
	File file = new File("./src/main/resources/configPropertyFile/configuration.properties");
	FileInputStream fi = null;
	Properties property = new Properties();

		try {
			fi = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		try {
			property.load(fi);
		} catch (IOException el) {
			el.printStackTrace();

		}
		return property;
	}
}
