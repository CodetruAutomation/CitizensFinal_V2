package com.codetru.project.cica.testcases.policyPaymentsModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class PolicyPayment extends BaseTest {

	@Parameters({ "ROW_NUMBER" })
	@Test
	public void TC_PolicyPayments_Module(String rowNumber) throws Exception {
		
//		ExcelHelpers excel = new ExcelHelpers();
//		excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
//		String row = rowNumber;
//		int rowNum = Integer.parseInt(row);
//		getLoginPage().loginSuccessWithAgentAccount(excel.getCellData(rowNum, "userid"),excel.getCellData(rowNum, "password"));
		
		getHomePage_Payments().Open_PolicyPayment_Module();
		getPolicyPaymentModule().Make_a_Payment();
	}
}
