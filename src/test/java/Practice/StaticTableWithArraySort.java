package Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableWithArraySort {

	public static void main(String[] args)
	{
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.get("https://blazedemo.com/");
	
	WebElement dropdown= driver.findElement(By.xpath("//select[@name='fromPort']"));
	
	Select sc = new Select(dropdown);
	
	sc.selectByVisibleText("Boston");
	
	WebElement drp= driver.findElement(By.xpath("//select[@name='toPort']"));
	
	Select sc1= new Select(drp);
	
	sc1.selectByVisibleText("London");
	
	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	
	int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
	
	System.out.println(rows);
	
	int col= driver.findElements(By.xpath("//table[@class='table']//thead//th")).size();
	
	System.out.println(col);
	
	
	
	ArrayList PrizeList = new ArrayList();
	
     for(int r=2; r<=rows; r++)
     {
    	 String prize=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
    	 
    	 PrizeList.add(prize);
     }
     
     System.out.println(PrizeList);
     
     Collections.sort(PrizeList);
	
     System.out.println(PrizeList);
     
     
     
     for(int r=2; r<=rows; r++)
     {
    	 String prize1=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText(); 
    	 
    	 if(prize1.equals(PrizeList.get(0)))
    			 {
    		             driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]//input[@class='btn btn-small']")).click();
    		             break;
    			 }
    	 
     }
	

	}

}
