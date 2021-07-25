package com.inetBanking.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	
	//set the variables as public 
	
	public String baseURL = rc.getApplicationURL();
	public String userName = rc.getUserName();
	public String password = rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	// write the setup method
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{	
		//Logs
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if (br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "/Users/bhuvanavignesh/Desktop/QA_Automation/Chrome/chromedriver");
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("This is not a supported browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	//write the teardown method
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+"-"+timestamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
