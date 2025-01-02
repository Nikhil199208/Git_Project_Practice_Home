package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClearAndEnterTextInInputBox {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		 
		driver.manage().window().maximize();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		System.out.println(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"));
		
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nikhilmech605@gmail.com");
		
		
	}

}
