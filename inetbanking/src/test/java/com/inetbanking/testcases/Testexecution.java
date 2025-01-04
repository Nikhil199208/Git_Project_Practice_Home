package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class Testexecution extends Testbaseclass
{
@Test
public void execution() throws IOException
{
	Loginpage log=new Loginpage(driver);
	logger.info("enter name");
	log.setusername("mngr249423");
	logger.info("enter password");
	log.setpassword("asezEhE");
	log.clicksubmit();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
	{
		Assert.assertTrue(true);
		logger.info("login test passed");
	}
	else
	{
		capturescreen(driver,"execution");
		Assert.assertTrue(false);
		logger.info("login test failed");
	}
}

}
