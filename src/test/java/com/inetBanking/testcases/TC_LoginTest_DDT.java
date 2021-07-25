package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pages.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_LoginTest_DDT extends BaseClass
{

	@Test(dataProvider="Login")
	public void LoginTestDDT(String user, String pwd) throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.btnClick();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			
			captureScreen(driver,"LoginTestDDT");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			Thread.sleep(3000);
			lp.btnLgout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("The login success");
		}
	}
	
	@DataProvider(name="Login")
	String [][] getData() throws IOException
	{
		String path = "/Users/bhuvanavignesh/Desktop/QA_Automation/inetBanking/src/test/java/com/inetBanking/testdata/inetBank_TestData.xlsx";
		System.out.println("Getting the rowcount"+path);
		
		int rownum = ExcelUtils.getRowCount(path, "TestData1");
		System.out.println("Getting the column count");
		int colnum = ExcelUtils.getColumnCount(path, "TestData1", 1);
		
		String loginData[][] = new String[rownum][colnum];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j= 0;j<colnum;j++)
			{
				loginData[i-1][j]=ExcelUtils.getCellData(path, "TestData1",i,j);
			}
		}
		return loginData;
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
