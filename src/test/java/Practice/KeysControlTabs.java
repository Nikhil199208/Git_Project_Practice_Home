package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysControlTabs {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		
		WebElement input1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		
		WebElement input2=driver.findElement(By.xpath("//textarea[@id='inputText2']")); 
		
		input1.sendKeys("Welcome to Selenium");
		
		
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
		act.sendKeys(Keys.TAB).perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
		//Compare
		
		if(input1.getAttribute("value").equals(input2.getAttribute("Value")))
		{
			System.out.println("Text copied");
		}
		else
		{
			System.out.println("Text not copied");
		}
		

	}

}
