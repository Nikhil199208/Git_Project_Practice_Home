package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		
		Thread.sleep(3000);
		
		JQueryDropdown.selectCheckbox(driver,"choice 3","choice 4","choice 5","choice 6 2 2");
		
		

	}
	
	public static void selectCheckbox(WebDriver driver,String... value)
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item:checkboxes)
			{
				String text=item.getText();
				
				for(String val:value)
				{
					if(text.equalsIgnoreCase(val))
					{
						item.click();
						break;
					}
				}
			}
		
		}
		else
		{
			try
			{
			for(WebElement item:checkboxes)
			{
				item.click();
			}
			}
			catch(Exception e)
			{
				
			}
		}
	}

}
