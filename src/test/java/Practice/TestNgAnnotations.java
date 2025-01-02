package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations 
{
/*  @BeforeMethod
  public void DriverInitialized()
  {
	  System.out.println("Diver Initialized Successfully");
  }*/
  
	
	
	
 /* @BeforeClass
  public void DriverInitialized()
  {
	  System.out.println("Diver Initialized Successfully");
  } */
 
  
 /* @BeforeTest
  public void DriverInitialized()
  {
	  System.out.println("Diver Initialized Successfully with Before Test");
  } 
  */
  
  
  @BeforeSuite
  public void DriverInitialized()
  {
	  System.out.println("Diver Initialized Successfully with Before Suit");
  } 
  
  
  
  
  @Test
  public void test1()
  {
	  System.out.println("Test 1 Initialized");
  }
  
  @Test
  public void test2()
  {
	  System.out.println("Test 2 Initialized");
  }
  
  @Test
  public void test3()
  {
	  System.out.println("Test 3 Initialized");
  }
  
  
  
  
 /* @AfterMethod
  public void driverClosed()
  {
	  System.out.println("Driver closed Successfully");
  }
  */
  
  
 /* @AfterClass
  public void driverClosed()
  {
	  System.out.println("Driver closed Successfully");
  }*/
  
  
/*  @AfterTest
  public void driverClosed()
  {
	  System.out.println("Driver closed Successfully with After Test");
  }
  */
  
  @AfterSuite
  public void driverClosed()
  {
	  System.out.println("Driver closed Successfully with After Suite");
  }
}
