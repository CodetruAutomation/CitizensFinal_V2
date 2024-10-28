package com.codetru.project.cica.pages.sanityApplicationModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_6Page_HQ_Yes_NV extends CommonPageCICA {

	private By NextStep6 = By.xpath("//h3[text()='Health Questions ']/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By no_physician = By.xpath("//ion-checkbox[@formcontrolname='PhysicianNameCheckbox']");

	// Health Question Radio Buttons List
	private By HealthQuestions_No_RadioButtons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='No']/following-sibling::ion-radio");
	private By HealthQuestions_Yes_RadioButtons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='Yes']/following-sibling::ion-radio");

	// Change Plan Locators
	private By popup_Ok_Button = By.xpath("//span[text()='Ok']/parent::button");
	private By selectPlan = By.xpath("(//select[@formcontrolname='Plan'])[2]");
	private By calculate = By.xpath("(//ion-button[text()='Calculate'])[2]");
	private By changePlan_NextButton = By.xpath("(//h3[.='Plan Options'])[2]/parent::div/following::ion-row/ion-col/ion-button[.='Next Step']");

	public void Predetermination_Questions() {

		WebUI.waitForPageLoaded();
		WebUI.sleep(2);

		List<WebElement> HQ_No_Buttons = WebUI.getWebElements(HealthQuestions_No_RadioButtons);
		List<WebElement> HQ_Yes_Buttons = WebUI.getWebElements(HealthQuestions_Yes_RadioButtons);

		for (int i = 0; i < HQ_No_Buttons.size(); i++) {
			if (i == 0) {

				WebUI.scrollToElementAtBottom(HQ_Yes_Buttons.get(i));
				WebUI.sleep(0.2);
				HQ_Yes_Buttons.get(i).click();
			} else {
				WebUI.scrollToElementAtBottom(HQ_No_Buttons.get(i));
				WebUI.sleep(0.2);
				HQ_No_Buttons.get(i).click();
			}
		}

		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(NextStep6);
		WebUI.clickElement(no_physician);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.clickElement(NextStep6);
		WebUI.sleep(1.5);
		
		//Select 'Yes' in any of the HealthQuestions
		WebUI.verifyElementVisible(popup_Ok_Button);
		WebUI.clickElement(popup_Ok_Button);
		WebUI.sleep(1.5);
		WebUI.selectOptionByIndex(selectPlan, 1);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.sleep(0.2);
		WebUI.clickElement(calculate);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(changePlan_NextButton);
		WebUI.sleep(0.2);
		WebUI.moveToElement(changePlan_NextButton);
		WebUI.clickElement(changePlan_NextButton);
		WebUI.sleep(2);
		

	}
}
