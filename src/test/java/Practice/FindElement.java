package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {

	public static void main(String[] args) 
	
	{
	
       WebDriverManager.chromedriver().setup();
       
       WebDriver driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       
       driver.get("https://demo.nopcommerce.com/");
       
       // FindElement method will identify single WebElement on Webpage
       
     String LogoText =driver.findElement(By.xpath("//a[text()='Sitemap']")).getText();
     
     System.out.println(LogoText);
     
     
     // FindElement method can identify multiple WebElements but returns only single webelement ie, first webelement
     
    System.out.println(driver.findElement(By.xpath("//div[@class='footer-upper']//a")).getText());
    
    
    //Return "No Such Element" exception if findelement method not able to identify any webelement on webpage
    
    String LogoText1 =driver.findElement(By.xpath("//a[text()='Sitemapa']")).getText();
    
    System.out.println(LogoText1);
    
       
	}

}
