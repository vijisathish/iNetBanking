package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext textcontext)
	{
		String timestamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/spark-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*final File CONF = new File(System.getProperty("user.dir")+"/spark-config.xml");
		try {
			sparkReporter.loadXMLConfig(CONF);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Bhuvana");
		
	
		//This one needs to be added only if we are not using the spark-config.xml file which has these information already
		/*sparkReporter.config().setDocumentTitle("iNet Banking Project");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.DARK);*/
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		
		test= extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File f = new File(screenshotpath);
		
		
		if (f.exists())
		{
			test.fail("Screen shot is below"+test.addScreenCaptureFromPath(screenshotpath));
		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
