package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLMultipleTabsAndWindows {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://demo.nopcommerce.com/");*/
		
         driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://demo.nopcommerce.com/");

	}

}
