package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.clickElement;
import static com.codetru.keywords.WebUI.sleep;
import static com.codetru.keywords.WebUI.verifyElementVisible;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.utils.LogUtils;



public class HomePage_NV extends CommonPageCICA {

	private By applicationButton = By.id("applicationButton");
	private By newApplication = By.xpath("//div[@class='applicationDropdown']/div[2]");
	private By step1 = By.xpath("//span[.='Step 1: Product Information']");
	private By step1InsuredInfo = By.xpath("//h3[text()='Proposed Insured Info']");
	
	private By profileIcon = By.xpath("//ion-col[@class='ion-text-right md hydrated']//ion-button[@class='ion-color ion-color-dark md button button-clear ion-activatable ion-focusable hydrated']");
	private By logoutButton = By.xpath("//ion-item[normalize-space()='Logout']");
	
    
	public void Open_Application_Module() {
		
		ProjectUtilities projectUtilities = new ProjectUtilities();
		
		WebUI.waitForPageLoaded();
		sleep(5);
		
		// Get License State and Appointment Status List from Lic & Apnt Tab
		projectUtilities.getLicenseStateAndCountyList();
		
		sleep(1);
		clickElement(applicationButton);
		sleep(1.2);
		clickElement(newApplication);
		sleep(2);

		verifyElementVisible(step1);
		clickElement(step1);
		sleep(2);
		
		WebUI.waitForPageLoaded();
		verifyElementVisible(step1InsuredInfo, "Insured Info not displayed");

	}

	
	public void HomePageNewApplication()
	{
		sleep(3);
		clickElement(applicationButton);
		sleep(1);
		WebUI.clickElement(newApplication);
		sleep(1.5);
		WebUI.releaseElement(applicationButton);
		sleep(0.2);
	}
	
	public void logout()
	{
		WebUI.sleep(2);
		WebUI.clickElement(profileIcon);
		WebUI.sleep(1);
		WebUI.clickElement(logoutButton);
		WebUI.sleep(3);
	}
	 
	
}



