package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
	WebElement dropdown=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
	
	
	
	dropdown.sendKeys("Selenium");
	
      Thread.sleep(3000);
	
		
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
		
		System.out.println(list.size());
		
		
		
	 for(WebElement option:list)
	 {
		 if(option.getText().contains("ide"))
		 {
			 option.click();
			 break;
		 }
	 }
		
		

	}

}
