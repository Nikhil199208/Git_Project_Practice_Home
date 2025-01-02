package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String windowID1=driver.getWindowHandle();
		System.out.println(windowID1);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).click();
		
		Set<String> windowIDS=driver.getWindowHandles();
		
        List<String> wds= new ArrayList(windowIDS);	
        
       /*String parentwindowid= wds.get(0);
       
       String childwindowid= wds.get(1);
       
       System.out.println(parentwindowid);
       
       System.out.println(childwindowid);
       
       driver.switchTo().window(parentwindowid);
       
       System.out.println(driver.getTitle());
       
       driver.switchTo().window(childwindowid);
       
       System.out.println(driver.getTitle());*/
        
        //want to print all windows ids swith to each window and get title
        
       /* for(String wd:wds)
        {
        	System.out.println(wd);
        	
        	String title=driver.switchTo().window(wd).getTitle();
        	
        	System.out.println(title);
        }*/
		
        //want to close specific window
        
        for(String wd:wds)
        {
        	String title=driver.switchTo().window(wd).getTitle();
        
        	System.out.println(title);
        	
        	if(title.equalsIgnoreCase("Upgrade to Advanced from Open Source | OrangeHRM"))
        	{
        		driver.close();
        	}
        }

	}

}
