package Practice;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProvider 
{
	WebDriver driver;
	
	@BeforeClass
	
	public void stup()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@Test(dataProvider="dp")
	public void login(String email, String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		Thread.sleep(3000);
	WebElement loginbutton=	driver.findElement(By.xpath("//input[@value='Login']"));
	Thread.sleep(3000);
	 TestNgDataProvider.Click(driver, loginbutton);
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("My Account"))
		{
			
			WebElement logoutbutton=driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']"));
			
			 TestNgDataProvider.Click(driver, logoutbutton);
			 Thread.sleep(3000);
			 WebElement loginbut=driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Login']"));
			 TestNgDataProvider.Click(driver, loginbut);
			 
			 
			 
			 
			Assert.assertTrue(true);
			System.out.println("Login Successfull");
		}
		else
		{
			Assert.fail();
		}
		
		
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
	
	@DataProvider(name="dp",indices= {0,3})//indices= {0,3}
	Object[][]logindata()
	{
		Object[][]data= {
	           			{"nikhilmech605@gmail.com","Nikhil@92"},
	           			{"nikhilmech605@gmail.com","Nikhil@@92"},
	           			{"nikhilmech6055@gmail.com","Nikhil@92"},
	           			{"nikhilmech6055@gmail.com","Nikhil@@92"},
				
	                   	};
		return data;
	}
	
	public static void Click(WebDriver driver,WebElement element)
	{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",element);
	}

}
