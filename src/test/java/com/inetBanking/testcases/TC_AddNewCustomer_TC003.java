package com.inetBanking.testcases;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import com.inetBanking.pages.LoginPage;
import com.inetBanking.pages.NewCustomerPage;


public class TC_AddNewCustomer_TC003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp =  new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.btnClick();
		
		Thread.sleep(3000);
		
		NewCustomerPage ncp = new NewCustomerPage(driver);
		ncp.clicknLink();
		ncp.feedncName("James");
		ncp.feedncGender("Female");
		ncp.feedncDate("10","20","1990");
		Thread.sleep(3000);
		ncp.feedncAddress("123 Bristol parkway");
		ncp.feedncCity("Chennai");
		ncp.feedncState("TamilNadu");
		ncp.feedncPin("600010");
		ncp.feedncTele("3947539578");
		ncp.feedncEmail(randomEmail()+"@gmail.com");
		Thread.sleep(3000);
		ncp.feedncPwd(randompwd());
		ncp.feedncSubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true)
		{
			Assert.assertTrue(true);
		}
		else if(isAlertPresent()==true)
		{
			System.out.print("The new customer is not registered");
			captureScreen(driver, "addNewCustomer");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	//Generate random strings
	public String randomEmail()
	{
		String rdmstring = RandomStringUtils.randomAlphabetic(8);
		return rdmstring;
	}
	
	public String randompwd()
	{
		String rdmstring = RandomStringUtils.randomAlphabetic(12);
		return rdmstring;
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
}

