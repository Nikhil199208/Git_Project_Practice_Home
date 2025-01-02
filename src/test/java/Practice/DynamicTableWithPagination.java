package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTableWithPagination {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		
		password.clear();
		
		password.sendKeys("demo");
		
		Thread.sleep(6000);
		
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-primary']//i"));
		
		DynamicTableWithPagination.click(driver, loginbutton);
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		
		String text=driver.findElement(By.xpath("//div[normalize-space()='Showing 1 to 10 of 1355 (136 Pages)']")).getText();
		
		System.out.println(text);
		
		int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		
		System.out.println(total_pages);
		
		
		
		//how to find number rows in each page
		
		/*for(int p=1; p<=12; p++)
		{
			if(p>1)
			{
			WebElement Active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			
			System.out.println("Active Page Number :"+"  "+Active_Page.getText());
			
			DynamicTableWithPagination.click(driver, Active_Page);
			}
			
			int NumberOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			System.out.println("Number of Rows :"+"  "+NumberOfRows);
			
			String pageno=Integer.toString(p+1);
			
			Thread.sleep(5000);
			
			WebElement nextpage=driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']"));
			
			DynamicTableWithPagination.click(driver, nextpage);*/
			
			
			//how to read all rows from each page
			
			for(int p=1; p<=10; p++)
			{
				
					WebElement Active_Page= driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
					
					System.out.println("Active Page Number :"+"  "+Active_Page.getText());
					
					DynamicTableWithPagination.click(driver, Active_Page);
					
			
				
				Thread.sleep(5000);
				
				int rows= driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
				
				System.out.println("Number of rows in page :"+"  "+rows);
				Thread.sleep(5000);
				
				for(int r=1; r<=rows; r++)
				{
				
					String OrderId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				
					String Customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
				
					String status= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
				
					System.out.println("OrderId :"+"  "+OrderId+"    "+"Customer :"+"  "+Customer+"    "+"Status :"+"  "+status);
				}
				
				String pageno=Integer.toString(p+1);
				
				Thread.sleep(5000);
				
				WebElement nextpage=driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']"));
				
				DynamicTableWithPagination.click(driver, nextpage);
			}
			
			
		}
		
		

	

	public static void click(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
	}
	
}
