package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		
		//Right Click
		
	   WebElement rightclickbutton=	driver.findElement(By.xpath("//span[text()='right click me']"));
	
	      Actions act= new Actions(driver);
	      
	      act.contextClick(rightclickbutton).perform();
	      
	      
	      
	      
	
	

	}

}
