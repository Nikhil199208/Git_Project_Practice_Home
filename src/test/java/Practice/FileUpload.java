package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) 
	{
		
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://testautomationpractice.blogspot.com/");
        
        driver.findElement(By.xpath("//input[@id='singleFileInput']")).sendKeys("C:\\Users\\npidurkar\\OneDrive - Nice Systems Ltd");
	
	if(driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText().equals("Single file selected: OneDrive - Nice Systems Ltd, Size: 4096 bytes, Type:"))
	{
		System.out.println("File Uploaded Successfully");
	}
	else
	{
		System.out.println("File Not Uploaded");
	}
	}

}
