package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	
	
			
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryui.com/datepicker");
		
		//String date= "4";
		//String month="April";
		//String year= "2023";
		
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		/*while(true)
		{
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			String currentyear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equalsIgnoreCase(month) && currentyear.equalsIgnoreCase(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}*/
		
		
		/*for(WebElement dates:alldates)
		{
		String selectiondate=dates.getText();
		
		if(selectiondate.equalsIgnoreCase(date))
		{
			dates.click();
			break;
		}*/
		
		
		//Generic Method
		
		 By locatormonth= By.xpath("//span[@class='ui-datepicker-month']");
		 
		 By locatoryear = By.xpath("//span[@class='ui-datepicker-year']");
		 
		 By locatorprev=By.xpath("//span[text()='Prev']");
		
		 
		 List<WebElement> alldates= driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		 
		 DatePicker.selectDate(driver,  locatormonth, locatoryear, locatorprev,"April", "2023", "4");
		
		}
		
	
	    public static void selectDate(WebDriver driver,By locatormonth,By locatoryear,By locatorprev,String Selectmonth,String Selectyear, String selectDate) 
	    {
	       
	    	
	    	// Validate the input parameters
	       /* if (dates == null || dates.isEmpty()) 
	        {
	            System.out.println("Date list is empty or null.");
	            return;
	        }

	        */
	    	
	    	
	    	while(true)	
			{
				String currentmonth = driver.findElement(locatormonth).getText();
				
				String currentyear= driver.findElement(locatoryear).getText();
				
				if(currentmonth.equalsIgnoreCase(Selectmonth) && currentyear.equalsIgnoreCase(Selectyear))
				{
					break;
				}
				
				driver.findElement(locatorprev).click();
			}
		
	    
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Iterate over the list of date elements
	        	while (true) {
	                try {
	                    // Fetch the date elements again in case they are stale
	                    List<WebElement> refreshedDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

	                    // Loop over each date element to find the correct one
	                    for (WebElement date : refreshedDates) 
	                    {
	                        String dateText = date.getText();

	                        // Check if the date matches the desired date
	                        if (dateText.equals(selectDate)) {
	                            // Wait until the date is clickable and then click it
	                        	
	                        	
	                            WebElement dateToClick = wait.until(ExpectedConditions.elementToBeClickable(date));
	                            dateToClick.click();
	                            break;  // Exit the method after clicking the date
	                        }
	                    }

	                
	            } catch (org.openqa.selenium.StaleElementReferenceException e) {
	                // Handle stale element exception by continuing to the next element in the list
	                System.out.println("Stale element reference exception caught, retrying...");
	            }
	        }
	    }

}
