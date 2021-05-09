package com.epam.program_portal.utility_functions;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.epam.framework.excel_functions.ExcelReusableFunctions;
import com.epam.program_portal.api.beans.College;
import com.epam.program_portal.constants.ExcelConstants;
import com.epam.program_portal.constants.page_constants.CollegesPageConstants;

public class ExcelUtilityFunctions {

	private ExcelUtilityFunctions() {
	}

	public static Object[][] sendUserNamesAndPassWordFromExcel() throws IOException {
		XSSFSheet credentialsSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH,
				ExcelConstants.USER_NAME_AND_PASSWORD_SHEET_NAME);
		int maxRows = ExcelReusableFunctions.getMaxRows(credentialsSheet);
		Object[][] credentialsData = new Object[maxRows][2];
		for (int rowNumber = 1; rowNumber <= maxRows; rowNumber++) {
			Row row = credentialsSheet.getRow(rowNumber);
			credentialsData[rowNumber - 1][0] = row.getCell(0).getStringCellValue();
			credentialsData[rowNumber - 1][1] = row.getCell(1).getStringCellValue();
		}
		return credentialsData;
	}

	public static Object[][] sendSearchDataForSearchBoxInCollegePage() throws IOException {

		XSSFSheet searchKeysSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH,
				ExcelConstants.SEARCH_DATA_SHEET_NAME);

		int maxRows = ExcelReusableFunctions.getMaxRows(searchKeysSheet);
		Object[][] searchData = new Object[maxRows][1];
		for (int rowNum = 1; rowNum <= maxRows; rowNum++) {
			searchData[rowNum - 1][0] = searchKeysSheet.getRow(rowNum).getCell(0).getStringCellValue();
		}
		return searchData;
	}

	@SuppressWarnings("deprecation")
	public static College getCollegeFromExcelRow(Row currentRow) {
		College college = new College();
		college.setCollegeName(currentRow.getCell(CollegesPageConstants.collegeNameIndex).getStringCellValue());
		college.setGroup(currentRow.getCell(CollegesPageConstants.collegeGroupIndex).getStringCellValue());
		college.setCity(currentRow.getCell(CollegesPageConstants.collegeCityIndex).getStringCellValue());
		college.setPtoName(currentRow.getCell(CollegesPageConstants.collegePTONameIndex).getStringCellValue());
		college.setPtoEmail(currentRow.getCell(CollegesPageConstants.collegePTOEmailIndex).getStringCellValue());

		Cell mobileNumberCell = currentRow.getCell(CollegesPageConstants.collegePTOMobileIndex);
		if (mobileNumberCell == null) {
			college.setPtoMobile("");

		} else {
			mobileNumberCell.setCellType(CellType.STRING);
			college.setPtoMobile(mobileNumberCell.getStringCellValue());
		}

		return college;

	}

	public static Object[][] sendCollegeDataForAddingACollege() throws IOException {
		XSSFSheet collegeSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH,
				ExcelConstants.COLLEGE_DATA_SHEET_NAME);
		int maxRows = ExcelReusableFunctions.getMaxRows(collegeSheet);
		Object[][] collegeData = new Object[maxRows][1];
		for (int rowNum = 1; rowNum <= maxRows; rowNum++) {
			collegeData[rowNum - 1][0] = getCollegeFromExcelRow(collegeSheet.getRow(rowNum));
		}
		return collegeData;
	}

	// the size of second dimension is 1 beacuse We are adding a college object
	// instead of name, group, etc
	public static Object[][] sendInvalidDataForAddingCollege() throws IOException {
		XSSFSheet collegeSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH,
				ExcelConstants.INVALID_COLLEGE_DATA_SHEET_NAME);
		int maxRows = ExcelReusableFunctions.getMaxRows(collegeSheet);
		Object[][] collegeData = new Object[maxRows][1];
		for (int rowNum = 1; rowNum <= maxRows; rowNum++) {
			collegeData[rowNum - 1][0] = getCollegeFromExcelRow(collegeSheet.getRow(rowNum));
		}
		return collegeData;
	}
	
	public static Object[][] sendCollegeIDOfActiveColleges() throws IOException{
		DataFormatter formatter = new DataFormatter();
		XSSFSheet idSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH,ExcelConstants.ACTIVE_COLLEGE_COLLEGE_ID_SHEET_NAME);
		int maxRows=  ExcelReusableFunctions.getMaxRows(idSheet);
		Object[][] idData = new Object[maxRows][2];
		for(int rowNum = 1; rowNum<=maxRows; rowNum++)
		{
			idData[rowNum-1][0] = formatter.formatCellValue(idSheet.getRow(rowNum).getCell(6)); //6 refers to college id index
			idData[rowNum-1][1] = getCollegeFromExcelRow(idSheet.getRow(rowNum)); 
		}
		return idData;
		
	}

	public static Object[][] sendCollegeIdOfActiveCollegesForDeleting() throws IOException{
		XSSFSheet idSheet = ExcelReusableFunctions.getSheetFromExcel(ExcelConstants.EXCEL_SHEET_PATH, ExcelConstants.ACTIVE_COLLEGEID_FOR_DELETING_SHEET_NAME);
		int maxRows = ExcelReusableFunctions.getMaxRows(idSheet);
		Object[][] ids = new Object[maxRows][1];
		DataFormatter formatter = new DataFormatter();
		for(int rowNum = 1; rowNum<=maxRows; rowNum++)
		{
			ids[rowNum-1][0] = formatter.formatCellValue(idSheet.getRow(rowNum).getCell(0));
		}
		return ids;
	}
	

}
