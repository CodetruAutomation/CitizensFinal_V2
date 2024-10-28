package com.codetru.project.cica.testcases.reportsModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class CheckReportHistory extends BaseTest {

	@Parameters({"ROW_NUMBER"})
	@Test
	public void TC_CheckReportHistory(String rowNumber) {

		getHomePage_Payments().Open_checkReportHistory();
		getCheckReportHistory().checkReportsHistory();
	}

}
