package com.inetBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage 
{
	WebDriver ldriver;
	public NewCustomerPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this);
		}
	
	@FindBy (how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnknc;
	
	@FindBy (how = How.NAME, using="name") WebElement txtncname;
	
	@FindBy (how = How.XPATH, using="//input[@value='m']") WebElement rdncgender1;
	
	@FindBy (how = How.XPATH, using="//input[@value='f']") WebElement rdncgender2;
	
	@FindBy (how = How.ID_OR_NAME, using="dob") WebElement dtncdate;
	
	@FindBy (how = How.TAG_NAME, using="textarea") WebElement txtncaddress;
	
	@FindBy (how = How.NAME, using="city") WebElement txtnccity;
	
	@FindBy (how = How.NAME, using="state") WebElement txtncstate;
	
	@FindBy (how = How.NAME, using="pinno") WebElement txtncpin;
	
	@FindBy (how = How.NAME, using="telephoneno") WebElement txtnctno;
	
	@FindBy (how = How.NAME, using="emailid") WebElement txtncemail;
	
	@FindBy (how = How.NAME, using="password") WebElement txtncpwd;
	
	@FindBy (how = How.NAME, using="sub") WebElement btnncsubmit;
	
	@FindBy (how = How.NAME, using="res") WebElement btnncreset;
	
	
	public void clicknLink()
	{
		lnknc.click();
	}
	
	public void feedncName(String name)
	{
		txtncname.sendKeys(name);
	}
	
	public void feedncGender(String gndr)
	{
		if (gndr.equals("Male"))
			rdncgender1.click();
		else
			rdncgender2.click();
	}
	
	public void feedncDate(String mm, String dd, String yyyy)
	{
		dtncdate.sendKeys(mm);
		dtncdate.sendKeys(dd);
		dtncdate.sendKeys(yyyy);
	}
	
	public void feedncAddress(String add)
	{
		txtncaddress.sendKeys(add);
	}
	
	public void feedncCity(String city)
	{
		txtnccity.sendKeys(city);
	}
	
	public void feedncState(String state)
	{
		txtncstate.sendKeys(state);
	}
	
	public void feedncPin(String pin)
	{
		txtncpin.sendKeys(String.valueOf(pin));
	}
	
	public void feedncTele(String tele)
	{
		txtnctno.sendKeys(tele);
	}
	
	public void feedncEmail(String mail)
	{
		txtncemail.sendKeys(mail);
	}
	
	public void feedncPwd(String pwd)
	{
		txtncpwd.sendKeys(pwd);
	}
	
	public void feedncSubmit()
	{
		btnncsubmit.click();
	}
	
	public void feedncReset()
	{
		btnncreset.click();
	}
	
	
}
