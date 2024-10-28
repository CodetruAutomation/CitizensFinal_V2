package com.codetru.project.cica.pages.sanityApplicationModule;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_3Page_NV extends CommonPageCICA {
	
	private By noRadioBtn = By.xpath("//ion-item/ion-label[.='No']/following-sibling::ion-radio[@value='false']");
	private By NextStep3 = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step3_Yes = By.xpath("//h3[.='Policy Owner Information']/parent::div/descendant::ion-radio-group/ion-row/ion-col//ion-label[.='Yes']/following-sibling::ion-radio");
	private By step3_No = By.xpath("//h3[.='Policy Owner Information']/parent::div/descendant::ion-radio-group/ion-row/ion-col//ion-label[.='No']/following-sibling::ion-radio");
	private By policyPayor_No = By.xpath("//h3[.='Policy Payor Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By secondaryAddresseeDesg_No = By.xpath("//h3[.='Secondary Addressee Designation']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");

	public void Policy_Owner_Information() {

		WebUI.sleep(1.5);
		WebUI.clickElement(step3_No);
		WebUI.sleep(0.5);

		try {

			DriverManager.getDriver().findElement(policyPayor_No).isDisplayed();
			WebUI.sleep(0.2);
			WebUI.clickElement(policyPayor_No);
			WebUI.sleep(0.5);

		} catch (Exception ex) {

			System.out.println("Policy Payor Information Not Available. " + ex.getMessage());

			try {
				DriverManager.getDriver().findElement(secondaryAddresseeDesg_No).isDisplayed();
				WebUI.sleep(0.2);
				WebUI.clickElement(secondaryAddresseeDesg_No);
				WebUI.sleep(0.5);
			} catch (Exception ex1) {
				System.out.println("Secondary Addressee Option Not Available.");
			}
		}

		WebUI.scrollToElementAtBottom(NextStep3);
		WebUI.sleep(0.5);
		WebUI.moveToElement(NextStep3);
		WebUI.clickElement(NextStep3);
		WebUI.sleep(2);

	}

}
