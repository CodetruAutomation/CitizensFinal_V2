package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

public class Step3_Test_NV extends BaseTest {
	
	 @Test
    public void TC_Policy_Owner_Information() {

        getStep_3Page_NV().Policy_Owner_Information();
    }
}
