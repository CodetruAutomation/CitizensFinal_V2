package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class HomePageTest extends BaseTest {
	
	
	 @Parameters({"ROW_NUMBER"})
	 @Test
	 public void TC_Open_Application_Module(String rowNumber) throws Exception {
		 
//		 ExcelHelpers excel = new ExcelHelpers();
//		 excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
//		 String row = rowNumber;
//		 int rowNum = Integer.parseInt(row);
//		 getLoginPage().loginSuccessWithAgentAccount(excel.getCellData(rowNum, "userid"), excel.getCellData(rowNum , "password"));
		 getHomePage().openApplicationModule();
	 }
	 
}
