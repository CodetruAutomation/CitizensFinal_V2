package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step2_Test_NV extends BaseTest {
	
	 @Test
    public void TC_Proposed_Insured_Information() {

        getStep_2Page_NV().Proposed_Insured_Information();
    }
}
