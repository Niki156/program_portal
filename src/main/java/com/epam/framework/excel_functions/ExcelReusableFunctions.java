package com.epam.framework.excel_functions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReusableFunctions {
	private ExcelReusableFunctions() {}
	
	public static int getMaxRows(XSSFSheet sheet)
	{
		return sheet.getLastRowNum();
	}
	public static XSSFSheet getSheetFromExcel(String path, String sheetName) throws IOException
	{	
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet =  workbook.getSheet(sheetName);
		workbook.close();
		return sheet;
	}
}
