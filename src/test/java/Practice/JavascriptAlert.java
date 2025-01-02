package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptAlert {

	public static void main(String[] args) throws InterruptedException 
	{
		
       WebDriverManager.chromedriver().setup();
       
       WebDriver driver = new ChromeDriver();
       
       
       driver.manage().window().maximize();
       
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       
       Thread.sleep(3000);
       
      // driver.findElement(By.xpath("//div[@class='example']//li//button[@onclick='jsAlert()']")).click();
       
       //driver.switchTo().alert().accept();
       
      // driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
       
      // driver.switchTo().alert().dismiss();
       
       
       driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
       
       Thread.sleep(3000);
       
       Alert alertwindow=driver.switchTo().alert();
       
       System.out.println(alertwindow.getText());
       
       
       alertwindow.sendKeys("nikhil");
       
       alertwindow.accept();
       
       
       
       
	}

}
