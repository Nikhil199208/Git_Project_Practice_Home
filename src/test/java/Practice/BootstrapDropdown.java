package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions option = new ChromeOptions();
	
	option.addArguments("--disable-notifications");
	
	WebDriver driver = new ChromeDriver(option);
	
	driver.manage().window().maximize();
	
	driver.get("https://www.hdfc.com/");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	driver.findElement(By.xpath("//div[@class='dropdown-active-item product-name-active']")).click();
	
	List<WebElement> ProductDrp = driver.findElements(By.xpath("//ul[@id='productName']//li[contains(@class,'slider-tab')]"));
	
	
	BootstrapDropdown.BootstrapDrp(ProductDrp, "Plot Loans");
	
	
	
	
	/*for(WebElement product:ProductDrp)
	{
		if(product.getText().equalsIgnoreCase("Home Extension Loans"))
		{
			product.click();
			break;
		}
	}*/
	}
	
	
	
	
	// Generic Method for Bootstrap dropdopwn
	
	public static void BootstrapDrp(List<WebElement> options, String value)
	{
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase(value))
			{
				option.click();
				break;
			}
		}
	
	
	}
}
