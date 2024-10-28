package com.codetru.project.cica.testcases.reportsModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class PaymentRefusedReport extends BaseTest {


	@Parameters({"ROW_NUMBER"})
	@Test
	public void TC_PaymentRefusedReports(String rowNumber) throws Exception {
//		 ExcelHelpers excel = new ExcelHelpers();
//		 excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
//		 String row = rowNumber;
//		 int rowNum = Integer.parseInt(row);
//		 getLoginPage().loginSuccessWithAgentAccount(excel.getCellData(rowNum, "userid"),excel.getCellData(rowNum, "password"));
		 
		getHomePage_Payments().Open_PaymentRefusedReport();
		getPaymentRefusedReport().refusedReports();
	}

}
