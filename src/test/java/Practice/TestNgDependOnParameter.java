package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgDependOnParameter 
{
@Test(priority=1)
public void Openapp()
{
	System.out.println("Open App");
	Assert.assertTrue(true);
}

@Test(priority=2,dependsOnMethods= {"Openapp"})
public void login()
{
	System.out.println("Login Successfully");
	Assert.assertTrue(false);
}

@Test(priority=3,dependsOnMethods= {"login"})
public void search()
{
	System.out.println("Searched Successfully");
}

@Test(priority=4,dependsOnMethods= {"Openapp"})
public void advancesreach()
{
	System.out.println("Advance Searched Successfully");
}

/*@Test(priority=5,dependsOnMethods= {"login"})
public void logout()
{
	System.out.println("Logout Successfully");
}*/
}
