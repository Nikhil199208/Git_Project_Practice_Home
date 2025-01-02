package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkinNewTab {

	public static void main(String[] args) 
	{
		
       WebDriverManager.chromedriver().setup();
       
       WebDriver driver= new ChromeDriver();
       
       driver.manage().window().maximize();
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       driver.get("https://demo.nopcommerce.com/");
       
       String tab= Keys.chord(Keys.CONTROL,Keys.RETURN);
       
       driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(tab);
	}

}