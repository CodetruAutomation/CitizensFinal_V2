package com.codetru.project.cica.testcases.sanityApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step1_Test_NV extends BaseTest {
	

	@Test
    public void TC_Product_Information() {

        getStep_1Page_NV().Product_Information();
    }
}
