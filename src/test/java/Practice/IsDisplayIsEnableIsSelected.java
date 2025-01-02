package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayIsEnableIsSelected {

	public static void main(String[] args)
	
	{
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("https://demo.nopcommerce.com/register");
	  
	  
	 WebElement searchBox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
	 
	  System.out.println(searchBox.isDisplayed());
	  
	  System.out.println(searchBox.isEnabled());
	  
	  WebElement CheckBoxMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
	  
	  System.out.println(CheckBoxMale.isSelected());
	  
	  
	  driver.findElement(By.xpath("//input[@id='gender-male']")).click();
	  
	  System.out.println(CheckBoxMale.isSelected());
	  
	  driver.findElement(By.xpath("//input[@id='gender-female']")).click();
	  
	  
	  System.out.println(driver.findElement(By.xpath("//input[@id='gender-female']")).isSelected());
	  
	  
	  
	  
	  
	  
	  

	}

}
