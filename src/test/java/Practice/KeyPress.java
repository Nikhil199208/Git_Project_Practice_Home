package Practice;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyPress {

	public static void main(String[] args) throws InterruptedException 
	{
	
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://the-internet.herokuapp.com/key_presses?");
        
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        
        Thread.sleep(3000);
        act.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.SPACE).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.RETURN).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.TAB).perform();
        
	}

}
