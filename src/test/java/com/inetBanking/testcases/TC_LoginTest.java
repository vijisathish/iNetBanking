package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import com.inetBanking.pages.LoginPage;

public class TC_LoginTest extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		
		
		logger.info("The url is launched");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("The user name is entered");
		lp.setPassword(password);
		logger.info("The password is entered");
		lp.btnClick();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("The test is passed");
		}
		else
		{
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("The test is failed");
		}
	}
}
