package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) 
	
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		
	WebElement desktop=	driver.findElement(By.xpath("//a[text()='Desktops']"));
	
	WebElement Mac=	driver.findElement(By.xpath("//a[text()='Mac (1)']"));
	
	Actions act = new Actions(driver);
	
	act.moveToElement(desktop).moveToElement(Mac).click().perform();
		
		

	}

}
