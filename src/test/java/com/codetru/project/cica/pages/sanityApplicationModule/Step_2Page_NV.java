package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.utils.DataGenerateUtils;

public class Step_2Page_NV extends CommonPageCICA {

	private By step_2 = By.xpath("//span[text()='Step 2: Proposed Insured Information']");
	private By NextStep2 = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");

	private By SSN_Number = By.xpath("//ion-input[@formcontrolname='ProposedSSN']/input");
	private By EmailAddress = By.xpath("//ion-input[@formcontrolname='ProposedEmailAddress']/input");
	private By phoneNumber = By.xpath("//ion-input[@formcontrolname='ProposedMobilePhone']/input");
	private By Address_1_Message = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress1']/input");
	private By Address_2_Message = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress2']/input");
	private By ZipCode = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalZipCode']/input");
	private By Proposed_ZipCode = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalZipCode']/following-sibling::ion-button");
	private By city = By.xpath("//select[@formcontrolname='ProposedPhysicalCity']");

	private By step_1 = By.xpath("//span[.='Step 1: Product Information']");
	private By calculate = By.xpath("(//div/ion-row/ion-col/ion-button[starts-with(@class, md)])[2]");
	private By step_1_NextB = By.xpath("//p[.='Is Automatic Premium Loan Desired?']/parent::div/parent::ion-col/parent::ion-row/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By TableOfContent = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row[@style='padding-left: 50px;']/ion-col[@size-md='18']/ion-button[.='Table of Contents']");
	private By impNotice_Popup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");

	public void Proposed_Insured_Information() {

		WebUI.waitForPageLoaded();
		WebUI.clickElement(step_2);
		WebUI.sleep(0.5);

//		===========================================Go to Step-1==============================================================================================
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(TableOfContent);
		WebUI.sleep(0.5);
		WebUI.moveToElement(TableOfContent);
		WebUI.clickElement(TableOfContent);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(step_1);
		WebUI.sleep(1.5);
		// For Notice Popup
		try {
			DriverManager.getDriver().findElement(impNotice_Popup).isDisplayed();
			WebUI.sleep(0.5);
			WebUI.clickElement(impNotice_Popup);

		} catch (Exception ex) {
			System.out.println("Notice Popup Did Not Appear. " + ex.getMessage());
		}

		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.sleep(0.2);
		WebUI.clickElement(calculate);
		WebUI.sleep(0.2);

		WebUI.scrollToElementAtBottom(step_1_NextB);
		WebUI.sleep(0.2);
		WebUI.moveToElement(step_1_NextB);
		WebUI.clickElement(step_1_NextB);
		WebUI.sleep(3);
//		==================================================================================================================================================

		WebUI.clickElement(SSN_Number);
		String randomSSNNumber = DataGenerateUtils.randomValidSSN();
		WebUI.clearAndFillText(SSN_Number, randomSSNNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(SSN_Number, "value"), randomSSNNumber);

		WebUI.scrollToElementAtBottom(ZipCode);
		WebUI.verifyElementVisible(ZipCode);
		WebUI.sleep(0.5);

		String randomEmailAddress = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(EmailAddress, randomEmailAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(EmailAddress, "value"), randomEmailAddress);

		String randomPhoneNumber = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(phoneNumber, randomPhoneNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(phoneNumber, "value"), randomPhoneNumber);

		String randomAddress = DataGenerateUtils.randomStreetName();
		WebUI.clearAndFillText(Address_1_Message, randomAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(Address_1_Message, "value"), randomAddress);

//		WebUI.clearAndFillText(Address_2_Message, PropertiesHelpers.getValue("address_2"));
//		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(Address_2_Message, "value"), PropertiesHelpers.getValue("address_2"));

		WebUI.clearAndFillText(ZipCode, PropertiesHelpers.getValue("zip_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ZipCode, "value"), PropertiesHelpers.getValue("zip_Code"));
		WebUI.moveToElement(Proposed_ZipCode);
		WebUI.sleep(0.2);
		WebUI.clickElement(Proposed_ZipCode);
		WebUI.sleep(1.5);

		WebUI.scrollToElementAtBottom(NextStep2);
		WebUI.sleep(0.8);

		WebUI.clickElement(city);
		WebUI.sleep(1);
		WebUI.selectOptionByIndex(city, 1);
		WebUI.sleep(0.6);

		WebUI.scrollToElementAtBottom(NextStep2);
		WebUI.sleep(0.5);
		WebUI.moveToElement(NextStep2);
		WebUI.sleep(0.2);
		WebUI.clickElement(NextStep2);
		WebUI.sleep(1);
		
	}

}
