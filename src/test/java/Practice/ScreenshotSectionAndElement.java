package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotSectionAndElement {

	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		
	/*WebElement section=	driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
	
	File Scr= section.getScreenshotAs(OutputType.FILE);
	
	File target= new File(".\\Screenshot\\sction.png");
	
	FileUtils.copyFile(Scr, target);*/
		
		WebElement element=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		File scr= element.getScreenshotAs(OutputType.FILE);
		
		File Target= new File(".\\Screenshots\\NopCommerce.png");
		
		FileUtils.copyFile(scr, Target);
				
	

	}

}
