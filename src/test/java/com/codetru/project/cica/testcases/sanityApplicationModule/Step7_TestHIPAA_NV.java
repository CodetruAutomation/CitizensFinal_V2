package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step7_TestHIPAA_NV extends BaseTest {

	@Test
	public void TC_HIPAA_Voice_Authorization() {

		getStep_7PageHIPAA_NV().HIPAA_Voice_Authorization();

	}
}
