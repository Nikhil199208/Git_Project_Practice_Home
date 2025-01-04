package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Testbaseclass 
{
 public static WebDriver driver;
 public static Logger logger;
 @Parameters("Browser")
 @BeforeClass()
 public void setup(String br)
 {
	 logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		    driver=new FirefoxDriver();
		}
			
		
	driver.get("http://demo.guru99.com/V4/");
	logger.info("url is opened");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
 }
 
 
 @AfterClass
 public void teardown()
 {
	driver.close(); 
 }
 
 public void capturescreen(WebDriver driver,String tname) throws IOException
 {
	 File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File dest=new File(System.getProperty("user.dir")+"//screenshot//"+tname+".png");
	 FileUtils.copyFile(source, dest);
	 System.out.println("screenshot taken");
 }
}
