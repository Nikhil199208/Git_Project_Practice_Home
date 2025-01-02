package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTestOnIncognitoBrowser {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options= new ChromeOptions();
		
	     options.addArguments("--incognito");
	     
	     WebDriver driver = new ChromeDriver(options);
	     
	     driver.manage().window().maximize();
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	     driver.get("https://demo.opencart.com/");
	     
	     
	     

	}

}
