package com.codetru.project.cica.pages.sanityApplicationModule;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_9Page_NV extends CommonPageCICA {

	private By Upload_Application_G = By.xpath("//span[.='Step 8: Upload Application ']");
	private By Upload_Application = By.xpath("//span[.='Step 10: Upload Application ']");

	public void Edit_Submit() {

		WebUI.waitForPageLoaded();
		WebUI.sleep(2);

		try {
			DriverManager.getDriver().findElement(Upload_Application_G).isDisplayed();
			WebUI.clickElement(Upload_Application_G);
			WebUI.sleep(3);
		} catch (Exception exc) {
			WebUI.clickElement(Upload_Application);
			WebUI.sleep(3);
		}

	}

}
