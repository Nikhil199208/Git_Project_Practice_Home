package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame3= driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		driver.switchTo().frame(frame3);
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//div[@id='i9']")).click();
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();
		
	

	}

}
