package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptUtils 
{

	

		public static void main(String[] args)
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://demo.nopcommerce.com/");
		
			//draw border
		WebElement logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		JavascriptUtils.drawborder(driver, logo);
		
		//Get Title
		
		//System.out.println(JavascriptUtils.GetTitle(driver));
		
		//WebElement link=driver.findElement(By.xpath("//a[text()='Register']"));
		
		//JavascriptUtils.Click(driver, link);
		
		//JavascriptUtils.generatealert(driver, "This is customize alert");
		
		//WebElement inputbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		
		//JavascriptUtils.sendinput(driver, inputbox)	;
		
		//JavascriptUtils.Zoom(driver);
		
		
		//JavascriptUtils.refresh(driver);
			
			

		}
		
		
		//Highlight section and take screenshot of that section
		
		public static void drawborder(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js= ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px Solid red'", element);
			
		
		}
		
		public static String GetTitle(WebDriver driver)
		{
			JavascriptExecutor js= (JavascriptExecutor)driver;
		String title=	js.executeScript("return document.title;").toString();
		return title;
		}
		
		public static void Click(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();", element);
		}
		
		public static void generatealert(WebDriver driver,String message)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("alert('"+message+"')");
		}
		
		public static void sendinput(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','John')", element);
		}
		
		public static void Zoom(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.body.style.zoom='150%'");
		}
		
		public static void refresh(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("history.go(0)");
		}

	


	}


