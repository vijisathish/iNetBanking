package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName()
	{
		String uname = pro.getProperty("userName");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String cp = pro.getProperty("chromepath");
		return cp;
	}
	
	public String getFirefoxPath()
	{
		String fp = pro.getProperty("firefoxpath");
		return fp;
	}
	
}
