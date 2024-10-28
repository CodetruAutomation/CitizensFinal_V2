package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step5_Test_NV extends BaseTest {
	
	 @Test
    public void TC_Existing_Insurance() throws Exception {

        getStep_5Page_NV().Existing_Insurance();
    }
}
