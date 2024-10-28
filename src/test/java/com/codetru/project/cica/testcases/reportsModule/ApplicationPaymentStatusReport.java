package com.codetru.project.cica.testcases.reportsModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class ApplicationPaymentStatusReport extends BaseTest {


	@Test
	public void TC_ApplicationPaymentStatusReport() throws Exception {

		getHomePage_Payments().Open_ApplicationPaymentStatus();
		getApplicationPaymentStatusReport().applicationPaymentStatusReports();
	}

}