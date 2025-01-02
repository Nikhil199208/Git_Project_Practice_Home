package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureToolTip {

	public static void main(String[] args)
	{
		
       WebDriverManager.chromedriver().setup();
       
       WebDriver driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       driver.get("https://jqueryui.com/tooltip/");
       
       WebElement iframe =driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
       
       driver.switchTo().frame(iframe);
       
       WebElement Inputbox= driver.findElement(By.xpath("//input[@id='age']"));
       
       String text=Inputbox.getAttribute("title");
       
       System.out.println(text);
	}

}
