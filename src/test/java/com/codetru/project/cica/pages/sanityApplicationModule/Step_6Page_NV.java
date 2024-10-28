package com.codetru.project.cica.pages.sanityApplicationModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_6Page_NV extends CommonPageCICA {

	private By NextStep6 = By.xpath("//h3[text()='Health Questions ']/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By no_physician = By.xpath("//ion-checkbox[@formcontrolname='PhysicianNameCheckbox']");
	private By HealthQuestions_No_Buttons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='No']/following-sibling::ion-radio");
	

	public void Predetermination_Questions() {

		WebUI.waitForPageLoaded();
		WebUI.sleep(2);

		List<WebElement> HQ_No_Buttons = WebUI.getWebElements(HealthQuestions_No_Buttons);
		for(WebElement HQ_No_Button : HQ_No_Buttons)
		{
			WebUI.scrollToElementAtBottom(HQ_No_Button);
			WebUI.sleep(0.2);
			HQ_No_Button.click();
		}
		
		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(NextStep6);
		WebUI.clickElement(no_physician);
		WebUI.sleep(0.2);

		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.clickElement(NextStep6);
		WebUI.sleep(0.5);

	}
}
