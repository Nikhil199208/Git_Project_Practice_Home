package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
@FindBy(name="uid")
private WebElement userid;

@FindBy(name="password")
private WebElement userpass;

@FindBy(name="btnLogin")
private WebElement login ;

public Loginpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void setusername(String name)
{
	userid.sendKeys(name);
}
public void setpassword(String pass)
{
	userpass.sendKeys(pass);
}
public void clicksubmit()
{
	login.click();
}



}
