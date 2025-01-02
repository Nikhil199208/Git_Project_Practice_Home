package Practice;

import org.testng.annotations.Test;

public class TestNgGroupingLoginClass 
{
@Test(priority=1,groups= {"Sanity"})
public void loginbyemail()
{
	System.out.println("Login By Email");
}

@Test(priority=2,groups= {"Sanity"})
public void loginbyfacebook()
{
	System.out.println("Login By facebook");
}

@Test(priority=3,groups= {"Sanity"})
public void loginbytwitter()
{
	System.out.println("Login By twitter");
}
}
