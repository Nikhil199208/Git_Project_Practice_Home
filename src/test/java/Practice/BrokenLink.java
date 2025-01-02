package Practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("http://www.deadlinkcity.com/");
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	
	System.out.println(links.size());
	
	int brokenlinks=0;
	
	
	for(WebElement element:links)
	{
		String url= element.getAttribute("href");
		
		if(url==null || url.isEmpty())
		{
			System.out.println("Url is empty");
			continue;
		}
		URL link= new URL(url);
		try 
		{
		HttpURLConnection urlconnect= (HttpURLConnection)link.openConnection();
		
		urlconnect.connect();
		
		if(urlconnect.getResponseCode()>=400)
		{
			System.out.println(urlconnect.getResponseCode()+" "+url+" "+"is"+" "+"brokenlink");
			brokenlinks++;
		}
		else
		{
			System.out.println(urlconnect.getResponseCode()+" "+url+" "+"is"+" "+"valid link");
		}
		}
		catch(Exception e)
		{
			
		}
		
		
		
		
		
	}
	
	System.out.println("No of brokenlinks"+" "+"="+brokenlinks);
	
	
	

	}

}
