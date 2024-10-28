package com.codetru.project.cica.testcases.reportsModule;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class AccountBalanceReport extends BaseTest {


	@Parameters({"ROW_NUMBER"})
	@Test
	public void TC_AccountBalanceReports(String rowNumber) throws Exception {

		getHomePage_Payments().Open_accountBalanceReports();
		getAccountBalanceReport().accountBalance();
	}

}