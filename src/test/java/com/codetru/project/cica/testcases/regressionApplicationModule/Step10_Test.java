package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step10_Test extends BaseTest {
	
	 @Test
    public void TC_Make_a_Payment() {

        getStep_10Page().Make_a_Payment();
        
    }
}
