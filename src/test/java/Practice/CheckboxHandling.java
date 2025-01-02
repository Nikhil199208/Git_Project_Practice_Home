package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxHandling {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Check Specific check box
		
		//driver.findElement(By.xpath("//input[@id='tuesday']")).click();
		
		
		//Check all check boxes
		
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		/*for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}*/
		
		//Check check boxes by choice
		
		
		/*for(WebElement checkbox:checkboxes)
		{
		String Checkboxname=checkbox.getAttribute("id");
		
		if(Checkboxname.equals("tuesday")|| Checkboxname.equals("wednesday")|| Checkboxname.equals("thursday"))
		{
			checkbox.click();
		
		}
		}*/
		
		//Check last 3 checkboxes
		
		System.out.println(checkboxes.size());
		
		int totalcheckboxes=checkboxes.size();
		
		/*for(int i=totalcheckboxes-3;i<totalcheckboxes;i++)
		{
			checkboxes.get(i).click();
		}*/
		
		
		//Check first 3 checkboxes
		
		for(int i=0;i<totalcheckboxes;i++)
			if(i<3)
			{
				checkboxes.get(i).click();
			}
		

	}

}
