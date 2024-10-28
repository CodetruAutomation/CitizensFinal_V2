package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step7_TestHIPAA_NV2 extends BaseTest {

	@Parameters({"ROW_NUMBER"})
	@Test
	public void TC_HIPAA_Voice_Authorization(String rowNumber) throws Exception {
		 ExcelHelpers excel = new ExcelHelpers();
		 excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
		 String row = rowNumber;
		 int rowNum = Integer.parseInt(row);

		getStep_7PageHIPAA_NV2().HIPAA_Voice_Authorization(rowNum);

	}
}
