package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step2_Test extends BaseTest {
	
	 @Test
    public void TC_Proposed_Insured_Information() {

        getStep_2Page().Proposed_Insured_Information();
    }
}
