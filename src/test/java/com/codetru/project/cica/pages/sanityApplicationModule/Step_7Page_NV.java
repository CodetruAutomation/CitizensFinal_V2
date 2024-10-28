package com.codetru.project.cica.pages.sanityApplicationModule;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;


public class Step_7Page_NV extends CommonPageCICA{

	private By nextstep7 = By.xpath("//h3[.='Provide Any Additional Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");	

	public void Remarks() {

		WebUI.waitForPageLoaded();
		WebUI.sleep(1);
		WebUI.waitForElementVisible(nextstep7);
		WebUI.moveToElement(nextstep7);
		WebUI.sleep(0.5);
		WebUI.clickElementWithJs(nextstep7);
		WebUI.sleep(2);
		WebUI.waitForPageLoaded();
				
	}

}
