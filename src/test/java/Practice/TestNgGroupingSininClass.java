package Practice;

import org.testng.annotations.Test;

public class TestNgGroupingSininClass
{
	
		@Test(priority=1,groups= {"Regression"})
		public void signinbyemail()
		{
			System.out.println("Signin By Email");
		}

		@Test(priority=2,groups= {"Regression"})
		public void signinbyfacebook()
		{
			System.out.println("Signin By facebook");
		}

		@Test(priority=3,groups= {"Regression"})
		public void signinbytwitter()
		{
			System.out.println("Signin By twitter");
		}
		

}
