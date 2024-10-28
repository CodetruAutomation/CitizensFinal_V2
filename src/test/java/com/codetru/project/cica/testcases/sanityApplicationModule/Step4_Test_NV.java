package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step4_Test_NV extends BaseTest {
	
	 @Test
    public void TC_Beneficiary_Information() {

        getStep_4Page_NV().Beneficiary_Information();
    }
}
