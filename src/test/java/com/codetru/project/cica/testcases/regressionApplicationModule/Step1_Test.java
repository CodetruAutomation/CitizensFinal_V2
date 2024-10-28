package com.codetru.project.cica.testcases.regressionApplicationModule;

import org.testng.annotations.Test;

import com.codetru.common.BaseTest;

public class Step1_Test extends BaseTest {
	
	@Test

    public void TC_Product_Information() {

        getStep_1Page().Product_Information();
    }
}
