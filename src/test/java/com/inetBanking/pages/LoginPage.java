package com.inetBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		//AboutPage ap = PageFactory.initElements(driver1, AboutPage.class); --like this it will be done if it its object is created from other class
		PageFactory.initElements(rdriver,this); /* this is created from the current class in constructor if it need not be called from any class*/
	}
	
	
	
	//@FindBy(xpath="//label[@id='message23']") WebElement txtUsrNm; --Can be written like this too
	
	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name="password")
	WebElement txtPwd;
	
	@FindBy(name="btnLogin")
	WebElement btnLgn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	public void btnClick()
	{
		btnLgn.click();
	}
	
	public void btnLgout()
	{
		btnLogout.click();
	}
	

}
