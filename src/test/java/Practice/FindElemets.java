package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElemets {

	public static void main(String[] args) 
	{
		
      WebDriverManager.chromedriver().setup();
      
      WebDriver driver = new ChromeDriver();
      
      driver.manage().window().maximize();
      
      driver.get("https://demo.nopcommerce.com/");
      
      // FindElemet method will identify multiple webelement present on webpage
      
      List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
      
      System.out.println(links.size());
      
      
      // If wanted to perform action on multiple webelements present on webpage
      
      for( WebElement link: links)
      {
    	  System.out.println(link.getText());
    	  
      }
    
      
   // FindElemet method also can  identify single webelement present on webpage
      
     List<WebElement> singleLink =driver.findElements(By.xpath("//a[text()='Sitemap']"));
     
     System.out.println(singleLink.size());
     
     
  // FindElemet method returns 0 element if findelements  identify unable to identify any element present on webpage
     
 List<WebElement> singleLinks =driver.findElements(By.xpath("//a[text()='Sitemapa']"));
     
     System.out.println(singleLinks.size());
     
      
	}

}
