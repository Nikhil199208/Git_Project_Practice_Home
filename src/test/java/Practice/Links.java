package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		//how to find all links and print size
		
	System.out.println(driver.findElements(By.tagName("a")).size());
	
	//LinkText and PartialLinkText
	
	//driver.findElement(By.linkText("Sell")).click();
	
	driver.findElement(By.partialLinkText("Sel")).click();
		
		
	}

}
