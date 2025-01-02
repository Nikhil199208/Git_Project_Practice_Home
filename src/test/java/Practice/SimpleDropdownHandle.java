package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleDropdownHandle {

	public static void main(String[] args) 
	{
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://ewebdevelopment.com/quotes/inquire/openchart.com");
	
	
	//Using Generic Method
	
	WebElement countrydrp=driver.findElement(By.xpath("//select[@id='inputCountry']"));
	
	
	SimpleDropdownHandle.selectOption(countrydrp, "Argentina");
	
	
	
	
	
	
	
	//Select sc = new Select(countrydrp);
	
	//sc.selectByIndex(5);
	
	
	// Select option from dropdown without using select class methods
	
	//Select sc = new Select(countrydrp);
	
	//List<WebElement> drpoptions=sc.getOptions();
	
	/*for(WebElement option:drpoptions)
	{
	
	
	if(option.getText().contains("Aruba"))
	{
		option.click();
		break;
	}
	
	}*/
	}
	// Using Generic Method
	
	public static void selectOption(WebElement ele,String value)
	{
		Select sc = new Select(ele);
		List<WebElement> drpoption =sc.getOptions();
		
		for(WebElement op:drpoption )
		{
			if(op.getText().contains(value))
			{
				op.click();
				break;
			}
	}
	
	
	
	
	

	}

}
