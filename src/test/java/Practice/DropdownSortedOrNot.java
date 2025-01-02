package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSortedOrNot {

	public static void main(String[] args) throws InterruptedException 
	{
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://www.twoplugs.com/");
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	
	WebElement dropdown=driver.findElement(By.xpath("//select[@name='category_id']"));
	
	Select sc = new Select(dropdown);
	
	List<WebElement> options= sc.getOptions();
	
	
	ArrayList origionalList= new ArrayList();
	
	ArrayList temproryList= new ArrayList();
	
	
	for(WebElement option:options)
	{
		origionalList.add(option.getText());
		temproryList.add(option.getText());
	}
	
	
	if(origionalList.equals(temproryList))
	{
		System.out.println("dropdown options are sorted...");
	}
	else
	{
		System.out.println("dropdown options are not sorted...");
	}
	
	/*Collections.sort(temproryList);
	
	if(origionalList.equals(temproryList))
	{
		System.out.println("dropdown options are sorted...");
	}
	else
	{
		System.out.println("dropdown options are not sorted...");
	}*/
	
	
	
	
	
	}

}
