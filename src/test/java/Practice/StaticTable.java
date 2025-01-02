package Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

    public static void main(String[] args) 
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://testautomationpractice.blogspot.com/");
        
        
        
        // how to find number of rows
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(rows);
        
        
        
        // how to find number of columns
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size();
        System.out.println(columns);
        
        
     /*   
        // Fetch 5th row 1st column data from table
        
         String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
         System.out.println(data);
         
         
        
        // print all table rows and columns data
         for(int r = 2; r <= rows; r++) {
            for(int c = 1; c <= columns; c++) {
                String text = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(text + "    ");
            }
            System.out.println("");
        } 
        
         
         
        // Specific condition wanted to print book name whose author name is Mukesh
        for(int r = 2; r <= rows; r++)
        {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            
            if(authorName.equals("Mukesh")) 
            {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(bookName + " " + authorName);
            }
        }*/
        
        
        // fetch all book prizes and print total amount of all books
        
        int total=0;
        for(int r= 2; r<=rows; r++)
        {
        	String prize=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
        	total=total+Integer.parseInt(prize);
        	
        }
        System.out.println(total);

        
    }
}
