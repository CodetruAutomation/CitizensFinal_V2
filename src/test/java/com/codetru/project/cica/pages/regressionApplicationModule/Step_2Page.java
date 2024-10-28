
package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;

public class Step_2Page extends CommonPageCICA {


	private By step2 = By.xpath("//span[text()='Step 2: Proposed Insured Information']");
	private By insuredGeneralInfo = By.xpath("//h3[normalize-space()='Insured General Information']");
	private By contactInfo = By.xpath("//h3[normalize-space()='Contact Information']");
	private By proposedInsuredFullName = By.xpath("//ion-input[@formcontrolname='ProposedFullName']");
	private By proposedAge = By.xpath("//ion-input[@formcontrolname='ProposedAge']");
	private By proposedGender = By.xpath("//ion-input[@value='Male']");
	private By step2NextButton = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By ssnRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNorTIN']/descendant::ion-label[text()='SSN']/following-sibling::ion-radio");
	private By itinRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNorTIN']/descendant::ion-label[text()='ITIN']/following-sibling::ion-radio");
	private By ssnNumber = By.xpath("//ion-input[@formcontrolname='ProposedSSN']/input");
	private By ssnErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedSSN']/parent::ion-item/parent::ion-col");
	private By emailAddress = By.xpath("//ion-input[@formcontrolname='ProposedEmailAddress']/input");
	private By emailAddressErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedEmailAddress']/parent::ion-item/parent::ion-col");
	private By emailCorrectFormatErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedEmailAddress']/parent::ion-item/parent::ion-col");
	private By phoneNumber = By.xpath("//ion-input[@formcontrolname='ProposedMobilePhone']/input");
	private By phoneNumberErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedMobilePhone']/parent::ion-item/parent::ion-col");
	private By address1 = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress1']/input");
	private By address1ErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress1']/parent::ion-item/parent::ion-col");
	private By address2 = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress2']/input");
	private By address2ErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalAddress2']/parent::ion-item/parent::ion-col");
	private By zipCode = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalZipCode']/input");
	private By zipCodeSearchButton = By.xpath("//ion-button[@title='Search']");
	private By zipCodeSearchButtonErrorMsg = By.xpath("//p[@class='errormsg' and text()='Please enter a valid Zip Code. ']");
	private By zipCodeErrorMsg = By.xpath("//ion-input[@formcontrolname='ProposedPhysicalZipCode']/parent::ion-item/parent::ion-col");
	private By city = By.xpath("//select[@formcontrolname='ProposedPhysicalCity']");
	private By cityList = By.xpath("//select[@formcontrolname='ProposedPhysicalCity']/option");
	private By cityErrorMsg = By.xpath("//select[@formcontrolname='ProposedPhysicalCity']/parent::ion-item/parent::ion-col");
	private By state = By.xpath("(//select[@formcontrolname='ProposedPhysicalState'])[2]");
	private By errorStateMessage = By.xpath("//select[@formcontrolname='ProposedPhysicalState']/parent::ion-item/parent::ion-col[@size='24' and @size-md='7']");
	private By tableOfContents = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Table of Contents']");
	private By backToList = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[text()='Back to List ']");
	private By step3PolicyOwnerInformation = By.xpath("(//h3[normalize-space()='Policy Owner Information'])[2]");

	
	public void Proposed_Insured_Information() {
		
		String mandatoryError = "Please enter a value.";
		String emailMaxChars = "destinysdfghdfghdfsgdsfgsdfgdfghdfghdsfghjdsfghdfghdfghfgh";
		String addressMax = "280 SIERRA DR. APT. B407 1142 SW ARLINGTON BLVD 1142 SW ARLINGTON BLVD";
		String nameMaxCharError ="The maximum number of characters is 33.";
		String maxCharError ="The maximum number of characters is 50";
		String phoneMinCharError ="The minimum number of characters is 10.";
		String phoneMaxCharError ="The maximum number of characters is 10.";
		String zipMinCharError ="The minimum number of characters is 5.";
		String zipMaxCharError ="The maximum number of characters is 5.";
		String ssnError = "SSN should have exactly 9 digits.";
		String itinError = "ITIN should have exactly 9 digits.";
		String itinInvalid = "Invalid ITIN.";
		String ssnLast4DigitError = "The last 4 digits of SSN should be from 0001 to 9999";
		String charactersOnly = "abcdefghijklmnopqrstuvwxyz";
		String ssnFormatError = "Please use a number format.";
		String emailFormatError = "Email is not in the correct format";
		String phoneFormatError = "Please use a number format.";
		String zipCodeSearchButtonError = "Please enter a valid Zip Code.";
		
		//TC_117
		WebUI.waitForPageLoaded();
		WebUI.sleep(1.5);
		WebUI.clickElement(step2);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(ssnNumber);
		
		//TC_118
		WebUI.verifyElementVisible(insuredGeneralInfo);
		WebUI.verifyElementVisible(contactInfo);

		//TC_125
		WebUI.verifyContains(WebUI.getAttributeElement(proposedInsuredFullName, "value"), ThreadLocalManager.getFirstName());
//		WebUI.verifyEquals(WebUI.getAttributeElement(proposedAge, "value"), Step_1Page.ageTextBoxValue);
		WebUI.verifyEquals(WebUI.getAttributeElement(proposedGender, "value"),PropertiesHelpers.getValue("gender"));
		WebUI.verifyEquals(WebUI.getAttributeElement(ssnNumber, "value"), "");
		
		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.verifyElementClickable(step2NextButton);
		WebUI.clickElement(step2NextButton);
		WebUI.scrollToElementAtTop(insuredGeneralInfo);
		WebUI.sleep(0.2);
		WebUI.verifyElementPresent(ssnNumber);
		
		//TC_128
		WebUI.verifyElementPresent(ssnRadioButton);
		WebUI.verifyElementClickable(ssnRadioButton);
		WebUI.verifyElementPresent(itinRadioButton);
		WebUI.verifyElementClickable(itinRadioButton);
		

		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnError);

		//TC_128
		WebUI.clickElement(itinRadioButton);
		WebUI.sleep(0.2);
		//TC_131
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), itinError);
		WebUI.clickElement(ssnRadioButton);
		WebUI.sleep(0.2);
		
		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, charactersOnly);
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnFormatError);

		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "25478451");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnError);
		
		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "25478451123");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnError);

		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "1234asasa");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnLast4DigitError);
		
		
//		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ITIN Field Validation^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		WebUI.clickElement(itinRadioButton);
		WebUI.sleep(0.2);
		
		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, charactersOnly);
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnFormatError);

		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "25478451");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), itinError);
		
		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "25478451123");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), itinError);

		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "1234asasa");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), ssnFormatError);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), itinInvalid);
		
		WebUI.clearText(ssnNumber);
		WebUI.setText(ssnNumber, "123451234");
		WebUI.verifyElementVisible(ssnErrorMsg);
		WebUI.verifyContains(getTextElement(ssnErrorMsg).trim(), itinInvalid);
		
		String randomITINNumber = DataGenerateUtils.randomValidITIN();
		WebUI.clearAndFillText(ssnNumber,randomITINNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ssnNumber,"value"),randomITINNumber);
		
		WebUI.clickElement(ssnRadioButton);
		WebUI.sleep(0.2);
		String randomSSNNumber = DataGenerateUtils.randomValidSSN();
		WebUI.clearAndFillText(ssnNumber,randomSSNNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ssnNumber,"value"),randomSSNNumber);
		
		WebUI.scrollToElementAtBottom(zipCode);
		WebUI.verifyElementVisible(zipCode);

		WebUI.verifyContains(getTextElement(emailAddressErrorMsg).trim(), mandatoryError);

		WebUI.clearText(emailAddress);
		WebUI.setText(emailAddress, "destiny001");
		WebUI.verifyElementVisible(emailCorrectFormatErrorMsg);
		WebUI.verifyContains(getTextElement(emailCorrectFormatErrorMsg).trim(), emailFormatError);

		WebUI.clearText(emailAddress);
		WebUI.setText(emailAddress, emailMaxChars);
		WebUI.verifyElementVisible(emailCorrectFormatErrorMsg);
		WebUI.verifyContains(getTextElement(emailCorrectFormatErrorMsg).trim(), maxCharError);

		String randomEmailAddress = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(emailAddress,randomEmailAddress);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(emailAddress,"value"),randomEmailAddress);
		
		WebUI.verifyContains(getTextElement(phoneNumberErrorMsg).trim(), mandatoryError);

		WebUI.clearText(phoneNumber);
		WebUI.setText(phoneNumber, "abcd");
		WebUI.verifyElementVisible(phoneNumberErrorMsg);
		WebUI.verifyContains(getTextElement(phoneNumberErrorMsg).trim(), phoneFormatError);
		
		WebUI.clearText(phoneNumber);
		WebUI.setText(phoneNumber, "98765432");
		WebUI.verifyElementVisible(phoneNumberErrorMsg);
		WebUI.verifyContains(getTextElement(phoneNumberErrorMsg).trim(), phoneMinCharError);

		WebUI.clearText(phoneNumber);
		WebUI.setText(phoneNumber, "98765432100");
		WebUI.verifyElementVisible(phoneNumberErrorMsg);
		WebUI.verifyContains(getTextElement(phoneNumberErrorMsg).trim(), phoneMaxCharError);

		String randomPhoneNumber = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(phoneNumber,randomPhoneNumber);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(phoneNumber,"value"),randomPhoneNumber);
		WebUI.verifyContains(getTextElement(address1ErrorMsg).trim(), mandatoryError);

		WebUI.clearText(address1);
		WebUI.setText(address1, addressMax);
		WebUI.verifyElementVisible(address1ErrorMsg);
		WebUI.verifyContains(getTextElement(address1ErrorMsg).trim(), nameMaxCharError);

		String randomAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(address1,randomAddress);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(address1,"value"),randomAddress);
		
		WebUI.clearText(address2);
		WebUI.setText(address2, addressMax);
		WebUI.verifyElementVisible(address2ErrorMsg);
		WebUI.verifyContains(getTextElement(address2ErrorMsg).trim(), nameMaxCharError);

		WebUI.clearAndFillText(address2, PropertiesHelpers.getValue("address_2"));
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(address2, "value"), PropertiesHelpers.getValue("address_2"));

		WebUI.verifyContains(getTextElement(zipCodeErrorMsg).trim(), mandatoryError);

		WebUI.clearText(zipCode);
		WebUI.setText(zipCode, "1234");
		WebUI.verifyElementVisible(zipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(zipCodeErrorMsg).trim(), zipMinCharError);

		WebUI.clearText(zipCode);
		WebUI.setText(zipCode, "123456");
		WebUI.verifyElementVisible(zipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(zipCodeErrorMsg).trim(), zipMaxCharError);
		WebUI.clearText(zipCode);
		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getTextElement(errorStateMessage), mandatoryError);
		
		//TC_154
		WebUI.clearText(zipCode);
		WebUI.sleep(0.2);
		WebUI.moveToElement(zipCodeSearchButton);
		WebUI.clickElement(zipCodeSearchButton);
		WebUI.sleep(1.5);
		WebUI.verifyElementVisible(zipCodeSearchButtonErrorMsg);
		WebUI.verifyContains(getTextElement(zipCodeSearchButtonErrorMsg), zipCodeSearchButtonError);

		WebUI.clearAndFillText(zipCode, PropertiesHelpers.getValue("zip_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(zipCode, "value"), PropertiesHelpers.getValue("zip_Code"));

		WebUI.moveToElement(zipCodeSearchButton);
		WebUI.sleep(0.2);
		WebUI.clickElementWithJs(zipCodeSearchButton);
		WebUI.sleep(0.5);

		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.waitForElementVisible(step2NextButton);
		WebUI.clickElement(step2NextButton);

		WebUI.verifyContains(getTextElement(cityErrorMsg), mandatoryError);
		WebUI.sleep(1);
		
		//TC_159
		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.sleep(1);
		List<String> cities = WebUI.getElementTextsInList(cityList);
		WebUI.logInfoMessage("Number of Cities: "+(cities.size()-1));
		WebUI.sleep(1.5);
		for(int i=1; i<cities.size(); i++ )
		{	
			WebUI.selectOptionByIndex(city, i);
			WebUI.sleep(1);
		}
		
		//TC_166
		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementClickable(tableOfContents);
		WebUI.verifyElementClickable(backToList);

		WebUI.scrollToElementAtBottom(step2NextButton);
		WebUI.sleep(0.2);
		WebUI.moveToElement(step2NextButton);
		WebUI.clickElement(step2NextButton);
		WebUI.sleep(2);
		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(step3PolicyOwnerInformation);
		
	}

}
