package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		By seleniumlink=By.xpath("//h3[text()='Selenium']");
		
		
		ExplicitWait.Wait(driver, 5, seleniumlink).click();
		
		
	
		
		
	}
	
	public static WebElement Wait(WebDriver driver,int timeout,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				
				return driver.findElement(locator);
	}

}
