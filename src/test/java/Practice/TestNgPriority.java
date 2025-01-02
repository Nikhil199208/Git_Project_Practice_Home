package Practice;

import org.testng.annotations.Test;

public class TestNgPriority
{
@Test(priority=-3)

public void OpenURL()
{
	System.out.println("Application Open");
}


@Test(priority=-1)
public void sendUsername()
{
	System.out.println("Send Username");
}


@Test(priority=-4)
public void sendPassword()
{
	System.out.println("Send Password");
}


@Test(priority=-2)
public void login()
{
	System.out.println("Login click");
}

@Test(priority=-5)
public void openHome()
{
	System.out.println("Home Page Open");
}
}
