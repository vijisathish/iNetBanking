package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{

		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		int rowcount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public static int getColumnCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		rw = sh.getRow(rownum);
		int colcount = rw.getLastCellNum();
		wb.close();
		fis.close();
		return colcount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		rw = sh.getRow(rownum);
		cl = rw.getCell(colnum);
		String data;
		try
		{
		DataFormatter formatter = new DataFormatter();
		String celldata = formatter.formatCellValue(cl);
		return celldata; 
		}
		catch (Exception e)
		{
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlsheet);
		rw = sh.getRow(rownum);
		cl = rw.createCell(colnum);
		cl.setCellValue(data);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
}
