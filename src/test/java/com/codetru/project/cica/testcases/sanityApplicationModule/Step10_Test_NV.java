package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step10_Test_NV extends BaseTest {
	
	 @Test
    public void TC_Make_a_Payment() {

        getStep_10Page_NV().Make_a_Payment();
        
        
    }
}
