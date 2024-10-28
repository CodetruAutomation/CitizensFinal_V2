package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step3_Test extends BaseTest {
	
	 @Test
    public void TC_Policy_Owner_Information() {

        getStep_3Page().Policy_Owner_Information();
    }
}
