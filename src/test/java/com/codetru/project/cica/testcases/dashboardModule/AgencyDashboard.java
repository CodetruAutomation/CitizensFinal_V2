package com.codetru.project.cica.testcases.dashboardModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class AgencyDashboard extends BaseTest {


	@Parameters({ "ROW_NUMBER" })
	@Test
	public void TC_agencyDashboard(String rowNumber) throws Exception {
		
//		ExcelHelpers excel = new ExcelHelpers();
//		excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
//		String row = rowNumber;
//		int rowNum = Integer.parseInt(row);
//		getLoginPage().loginSuccessWithAgentAccount(excel.getCellData(rowNum, "userid"),excel.getCellData(rowNum, "password"));
		
		getHomePage_Payments().Open_agencyDashboard();
		getAgencyDashboard().agencyDashboard();
		
	}

}
