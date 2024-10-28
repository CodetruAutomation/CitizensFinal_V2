package com.codetru.project.cica.pages.sanityApplicationModule;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_5Page_NV extends CommonPageCICA {

	private By NextStep5 = By.xpath("//h3[.='Existing Insurance']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By ExitingInsurance_Question_1 = By.xpath("(//ion-label[text()='No ']/following-sibling::ion-radio[@slot='start'])[1]");

	public void Existing_Insurance() {

		WebUI.sleep(1);
		WebUI.clickElement(ExitingInsurance_Question_1);
		WebUI.clickElement(NextStep5);
		WebUI.waitForPageLoaded();
		WebUI.sleep(3);

	}

}
