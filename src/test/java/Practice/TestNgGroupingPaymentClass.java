package Practice;

import org.testng.annotations.Test;

public class TestNgGroupingPaymentClass 
{
	@Test(priority=1,groups= {"Sanity","Regression","Functional"})
	public void paymentinrupee()
	{
		System.out.println("Payment in Rupee");
	}

	@Test(priority=2,groups= {"Sanity","Regression","Functional"})
	public void paymentindollar()
	{
		System.out.println("Payment in Dollar");
	}
}
