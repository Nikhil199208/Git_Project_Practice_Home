package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
  	 
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
	
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		
		//Scroll till end of page
		
		/*js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(3000);
		
		
		
		//Scroll till up starting
		 
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		System.out.println(js.executeScript("return window.pageYOffset;"));*/
		
		
		
		
		//Sroll till certain pixel
		
		
		/*js.executeScript("window.scrollBy(0,1000)","");
		
		System.out.println(js.executeScript("return window.pageYOffse;"));*/
		
		WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Community poll']"));
		
		js.executeScript("arguments[0].scrollIntoView();",element );
		
		
		
	
		

		
  	 
  	 
		

	}

}
