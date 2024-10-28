package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step10_Test_ACH extends BaseTest {
	
	 @Test
    public void TC_Make_a_Payment() throws Exception {

        getStep_10PageACH().Make_a_Payment();
        
        
    }
}
