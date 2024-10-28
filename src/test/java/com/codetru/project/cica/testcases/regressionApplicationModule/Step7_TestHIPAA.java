package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step7_TestHIPAA extends BaseTest {

	@Test
	public void TC_HIPAA_Voice_Authorization() {
		
		getStep_7PageHIPAA().HIPAA_Voice_Authorization();

	}
}
