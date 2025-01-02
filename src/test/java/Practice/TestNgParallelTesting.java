package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParallelTesting 
{
	WebDriver driver;
	
@Parameters({"browser"})
@BeforeClass

public void SetUp(String br) throws InterruptedException
{
	
	switch(br.toLowerCase())
	{
	case"chrome":driver= new ChromeDriver();break;
	case"edge":driver=new EdgeDriver();break;
	case"firefox":driver=new FirefoxDriver();break;
	default:System.out.println("Invalid Browser");return;
	}
	
	
	
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Thread.sleep(3000);
}


@Test
public void TestLogo()
{
	boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	
	Assert.assertEquals(status, true);
}

@Test
public void CheckTitle()
{
	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
}

@Test
public void CheckURL()
{
	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@AfterClass
public void TearDown()
{
	driver.close();
}

}
