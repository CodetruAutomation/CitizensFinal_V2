package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.utils.DataGenerateUtils;

public class Step_3Page extends CommonPageCICA {
	
	private By step3NextButton = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By hasOwnerYes = By.xpath("//ion-radio-group[@formcontrolname='HasOwner']/descendant::ion-label[.='Yes']/following-sibling::ion-radio");
	private By hasOwnerNo = By.xpath("//ion-radio-group[@formcontrolname='HasOwner']/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By errorMessageProposedOwner = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//div[@class='block-info-app']");
	private By BenificiaryFirstname = By.xpath("//ion-input[@formcontrolname='BeneficiaryFirstName']/input");
	
	private By ownerFirstName = By.xpath("//ion-input[@formcontrolname='OwnerFirstName']/input");
	private By ownerMiddleName = By.xpath("//ion-input[@formcontrolname='OwnerMiddleName']/input");
	private By ownerLastName = By.xpath("//ion-input[@formcontrolname='OwnerLastName']/input");
	private By ownerEmail = By.xpath("//ion-input[@formcontrolname='OwnerEmail']/input");
	private By ownerPhone = By.xpath("//ion-input[@formcontrolname='OwnerPhone']/input");
	private By ownerSSNRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNOwner']/descendant::ion-label[text()='SSN']/following-sibling::ion-radio");
	private By ownerEINRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNOwner']/descendant::ion-label[text()='EIN']/following-sibling::ion-radio");
	private By ownerSSN = By.xpath("//ion-input[@formcontrolname='OwnerSSN']/input");
	private By ownerAge = By.xpath("//ion-input[@formcontrolname='OwnerAge']/input");
	private By ownerRelation = By.xpath("//select[@formcontrolname='OwnerRelation']");
	private By ownerRelationList = By.xpath("//select[@formcontrolname='OwnerRelation']/option");
	private By ownerAddress1 = By.xpath("//ion-input[@formcontrolname='OwnerAddress1']/input");
	private By ownerAddress2 = By.xpath("//ion-input[@formcontrolname='OwnerAddress2']/input");
	private By ownerZipCode = By.xpath("//ion-input[@formcontrolname='OwnerZipCode']/input");
	private By ownerCity = By.xpath("//select[@formcontrolname='OwnerCity']");
	private By ownerCityList = By.xpath("//select[@formcontrolname='OwnerCity']/option");
	private By ownerState = By.xpath("//select[@formcontrolname='OwnerState']");
	private By ownerFirstNameErrorMsg = By.xpath("//ion-input[@formcontrolname='OwnerFirstName']/parent::ion-item/parent::ion-col");
	private By ownerMiddleNameErrorMsg = By.xpath("//ion-input[@formcontrolname='OwnerMiddleName']/parent::ion-item/parent::ion-col");
	private By ownerLastNameErrorMsg = By.xpath("//ion-input[@formcontrolname='OwnerLastName']/parent::ion-item/parent::ion-col");
	private By ownerEmailErrorMsg = By.xpath("//ion-input[@formcontrolname='OwnerEmail']/parent::ion-item/parent::ion-col");
	private By ownerPhoneErrorMsg = By.xpath("//ion-input[@formcontrolname='OwnerPhone']/parent::ion-item/parent::ion-col");
	private By errorMsgSSNEIN = By.xpath("//ion-input[@formcontrolname='OwnerSSN']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerAge = By.xpath("//ion-input[@formcontrolname='OwnerAge']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerRelation = By.xpath("//select[@formcontrolname='OwnerRelation']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerAddress1 = By.xpath("//ion-input[@formcontrolname='OwnerAddress1']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerAddress2 = By.xpath("//ion-input[@formcontrolname='OwnerAddress2']/parent::ion-item/parent::ion-col");
	private By zipCodeSearchButton = By.xpath("(//ion-button[@title='Search'])[2]");
	private By errorMsgZipCodeSearchButton = By.xpath("//ion-col[@class='md hydrated']//p[normalize-space()='Please enter a valid Zip Code.']");
	private By errorMsgZipCode = By.xpath("//ion-input[@formcontrolname='OwnerZipCode']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerCity = By.xpath("//select[@formcontrolname='OwnerCity']/parent::ion-item/parent::ion-col");
	private By errorMsgOwnerState = By.xpath("//select[@formcontrolname='OwnerState']/parent::ion-item/parent::ion-col");
	private By tableOfContents = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Table of Contents']");
	private By backToList = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Back to List ']");
	private By step4 = By.xpath("//h3[contains(text(), 'Step 4 of')]");
	
	//Policy Payor Information
	private By policyPayorYes = By.xpath("//h3[.='Policy Payor Information']/parent::div/descendant::ion-label[.='Yes']/following-sibling::ion-radio");
	private By policyPayorNo = By.xpath("//h3[.='Policy Payor Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By payorFirstName = By.xpath("//ion-input[@formcontrolname='PayorFirstName']/input");
	private By payorMiddleName = By.xpath("//ion-input[@formcontrolname='PayorMiddleName']/input");
	private By payorLastName = By.xpath("//ion-input[@formcontrolname='PayorLastName']/input");
	private By payorEmail = By.xpath("//ion-input[@formcontrolname='PayorEmail']/input");
	private By payorPhone = By.xpath("//ion-input[@formcontrolname='PayorPhone']/input");
	private By payorSSNRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNPayor']/descendant::ion-label[text()='SSN']/following-sibling::ion-radio");
	private By payorEINRadioButton = By.xpath("//ion-radio-group[@formcontrolname='IsSSNPayor']/descendant::ion-label[text()='EIN']/following-sibling::ion-radio");
	private By payorSSN = By.xpath("//ion-input[@formcontrolname='PayorSSN']/input");
	private By payorAge = By.xpath("//ion-input[@formcontrolname='PayorAge']/input");
	private By payorRelation = By.xpath("//select[@formcontrolname='PayorRelation']");
	private By payorRelationList = By.xpath("//select[@formcontrolname='PayorRelation']/option");
	private By payorAddress1 = By.xpath("//ion-input[@formcontrolname='PayorAddress1']/input");
	private By payorAddress2 = By.xpath("//ion-input[@formcontrolname='PayorAddress2']/input");
	private By payorCity = By.xpath("//ion-input[@formcontrolname='PayorCity']/input");
	private By payorState = By.xpath("//select[@formcontrolname='PayorState']");
	private By payorZipCode = By.xpath("//ion-input[@formcontrolname='PayorZipCode']/input");
	private By payorFistNameErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorFirstName']/parent::ion-item/parent::ion-col");
	private By payorMiddleNameErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorMiddleName']/parent::ion-item/parent::ion-col");
	private By payorLastNameErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorLastName']/parent::ion-item/parent::ion-col");
	private By payorEmailErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorEmail']/parent::ion-item/parent::ion-col");
	private By payorPhoneErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorPhone']/parent::ion-item/parent::ion-col");
	private By payorSSNEINErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorSSN']/parent::ion-item/parent::ion-col");
	private By payorAgeErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorAge']/parent::ion-item/parent::ion-col");
	private By payorRelationErrorMsg = By.xpath("//select[@formcontrolname='PayorRelation']/parent::ion-item/parent::ion-col");
	private By payorAddress1ErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorAddress1']/parent::ion-item/parent::ion-col");
	private By payorAddress2ErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorAddress2']/parent::ion-item/parent::ion-col");
	private By payorCityErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorCity']/parent::ion-item/parent::ion-col");
	private By payorStateErrorMsg = By.xpath("//select[@formcontrolname='PayorState']/parent::ion-item/parent::ion-col");
	private By payorZipCodeErrorMsg = By.xpath("//ion-input[@formcontrolname='PayorZipCode']/parent::ion-item/parent::ion-col");
	
	//Secondary Addressee Designation
	private By secondaryAddresseeYes = By.xpath("//h3[.='Secondary Addressee Designation']/parent::div/descendant::ion-label[.='Yes']/following-sibling::ion-radio");
	private By secondaryAddresseeNo = By.xpath("//h3[.='Secondary Addressee Designation']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	
	public void Policy_Owner_Information() {
		
		String mandatoryError = "Please enter a value.";
		String maxError = "The maximum number of characters is 33.";
		String maxCharacters = "qwertyuiopqwertyuiopqwertyuiopqwertyu";
		String pageError = "There are some errors on this page. Please correct before continuing.";
		String addMaxAddressChars = "280 SIERRA DR. APT. B407 1142 SW ARLINGTON BLVD 1142 SW ARLINGTON BLVD";
		String incorrectEmailError = "Email is not in the correct format";
		String emailMaxChar = "destinysdfghdfghdfsgdsfgsdfgdfghdfghdsfghjdsfghdfghdfghfghqwertyuiop";
		String emailMaxErrorMsg ="The maximum number of characters is 50";
		String phoneMinErrorMsg = "The minimum number of characters is 10.";
		String phoneMaxErrorMsg = "The maximum number of characters is 10.";
		String ssnErrorMsg = "SSN should have exactly 9 digits.";
		String einErrorMsg = "EIN should have exactly 9 digits.";
		String invalidSSN = "Invalid SSN.";
		String invalidEIN = "Invalid EIN format.";
		String ssnNumberError = "First 3 digits of SSN should not be 000, 666 or between 900 and 999.";
		String charactersOnly = "abcdefghijklmnopqrstuvwxyz";
		String ssnNumberFormatError = "Please use a number format.";
		String maxAgeError = "The maximum amount is 121.";
		String minZipError ="The minimum number of characters is 5.";
		String maxZipError ="The maximum number of characters is 5.";
		String zipCodeSearchButtonError = "Please enter a valid Zip Code.";
		
		WebUI.sleep(2);
		WebUI.verifyElementVisible(hasOwnerYes);
		WebUI.verifyElementVisible(hasOwnerNo);

		WebUI.clickElement(step3NextButton);
		WebUI.sleep(0.5);

		WebUI.verifyContains(getTextElement(errorMessageProposedOwner), mandatoryError);
		WebUI.sleep(1);

		WebUI.verifyElementClickable(hasOwnerYes);
		WebUI.clickElement(hasOwnerYes);
		WebUI.sleep(0.5);
		WebUI.verifyElementClickable(hasOwnerNo);
		WebUI.clickElement(hasOwnerNo);
		WebUI.sleep(0.5);

		WebUI.clickElement(hasOwnerYes);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(ownerFirstName);
		WebUI.verifyElementVisible(ownerMiddleName);
		WebUI.verifyElementVisible(ownerLastName);
		WebUI.verifyElementVisible(ownerEmail);
		WebUI.verifyElementVisible(ownerPhone);
		WebUI.sleep(1);

		WebUI.verifyContains(getTextElement(ownerFirstNameErrorMsg), mandatoryError);

		WebUI.sleep(0.5);
		WebUI.clearText(ownerFirstName);
		WebUI.setText(ownerFirstName, maxCharacters);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(ownerFirstNameErrorMsg);
		WebUI.verifyContains(getTextElement(ownerFirstNameErrorMsg), maxError);

		String firstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(ownerFirstName, firstName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ownerFirstName, "value"), firstName);

		WebUI.clearText(ownerMiddleName);
		WebUI.setText(ownerMiddleName, maxCharacters);
		WebUI.verifyElementVisible(ownerMiddleNameErrorMsg);
		WebUI.verifyContains(getTextElement(ownerMiddleNameErrorMsg), maxError);

		String middleName = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(ownerMiddleName, middleName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ownerMiddleName, "value"), middleName);

		WebUI.verifyContains(getTextElement(ownerLastNameErrorMsg), mandatoryError);

		WebUI.clearText(ownerLastName);
		WebUI.setText(ownerLastName, maxCharacters);
		WebUI.verifyElementVisible(ownerLastNameErrorMsg);
		WebUI.verifyContains(getTextElement(ownerLastNameErrorMsg), maxError);

		String randomLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(ownerLastName, randomLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ownerLastName, "value"), randomLastName);

		WebUI.verifyContains(getTextElement(ownerEmailErrorMsg), mandatoryError);

		WebUI.clearText(ownerEmail);
		WebUI.setText(ownerEmail, "destiny001");
		WebUI.verifyElementVisible(ownerEmailErrorMsg);
		WebUI.verifyContains(getTextElement(ownerEmailErrorMsg), incorrectEmailError);

		WebUI.clearText(ownerEmail);
		WebUI.setText(ownerEmail, emailMaxChar);
		WebUI.verifyElementVisible(ownerEmailErrorMsg);
		WebUI.verifyContains(getTextElement(ownerEmailErrorMsg).trim(), emailMaxErrorMsg);

		String randomEmailAddress = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(ownerEmail, randomEmailAddress);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(ownerEmail, "value"), randomEmailAddress);

		WebUI.clearAndFillText(ownerPhone, "789456");
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(ownerPhoneErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(ownerPhoneErrorMsg), phoneMinErrorMsg);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(ownerPhone, "258014736999");
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(ownerPhoneErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(ownerPhoneErrorMsg), phoneMaxErrorMsg);

		WebUI.clearAndFillText(ownerPhone, PropertiesHelpers.getValue("benif_phone"));
		WebUI.sleep(0.2);

		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), mandatoryError);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), ssnErrorMsg);

		// TC_128
		WebUI.clickElement(ownerEINRadioButton);
		WebUI.sleep(0.2);
		// TC_131
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), einErrorMsg);
		WebUI.clickElement(ownerSSNRadioButton);
		WebUI.sleep(0.2);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "25478451");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN).trim(), ssnErrorMsg);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "111111111");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN).trim(), invalidSSN);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "000000000");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN).trim(), ssnNumberError);

//		Verify the field should not accept alphabets
		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "asasa");
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), ssnNumberError);

//		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^EIN Field Validation^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		WebUI.clickElement(ownerEINRadioButton);
		WebUI.sleep(0.2);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, charactersOnly);
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), invalidEIN);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "25478451");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), einErrorMsg);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "000000000");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), invalidEIN);

		WebUI.clearText(ownerSSN);
		WebUI.setText(ownerSSN, "asasa");
		WebUI.verifyElementVisible(errorMsgSSNEIN);
		WebUI.verifyContains(getTextElement(errorMsgSSNEIN), invalidEIN);

		String randomEINNumber = DataGenerateUtils.randomValidITIN();
		WebUI.clearAndFillText(ownerSSN, randomEINNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ownerSSN, "value"), randomEINNumber);
//		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

		WebUI.clickElement(ownerSSNRadioButton);
		WebUI.sleep(0.2);
		String randomSSNNumber = DataGenerateUtils.randomValidSSN();
		WebUI.clearAndFillText(ownerSSN, randomSSNNumber);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ownerSSN, "value"), randomSSNNumber);

//	====================================================================================================================================

		// Age Field Validation
		WebUI.scrollToElementAtBottom(step3NextButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(step3NextButton);
		WebUI.scrollToElementAtTop(ownerSSN);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAge), mandatoryError);

		WebUI.clearText(ownerAge);
		WebUI.setText(ownerAge, "asdfghjkl");
		WebUI.verifyElementVisible(errorMsgOwnerAge);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAge), mandatoryError);

		WebUI.clearText(ownerAge);
		WebUI.setText(ownerAge, "122");
		WebUI.verifyElementVisible(errorMsgOwnerAge);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAge), maxAgeError);

		WebUI.clearText(ownerAge);
		WebUI.setText(ownerAge, "65");
		WebUI.verifyContains(getAttributeElement(ownerAge, "value"), "65");

		// Relationship Field Validation
		WebUI.verifyContains(getTextElement(errorMsgOwnerRelation), mandatoryError);

		List<String> relationships = WebUI.getElementTextsInList(ownerRelationList);
		for (int i = 1; i < relationships.size(); i++) {
			WebUI.selectOptionByIndex(ownerRelation, i);
			WebUI.sleep(0.4);
		}

		WebUI.sleep(0.2);
		WebUI.clickElement(ownerRelation);
		WebUI.setText(ownerRelation, "p", Keys.ENTER);

		// Address 1 Field Validation
		WebUI.scrollToElementAtBottom(ownerZipCode);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAddress1), mandatoryError);

		WebUI.clearText(ownerAddress1);
		WebUI.setText(ownerAddress1, addMaxAddressChars);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(errorMsgOwnerAddress1);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAddress1).trim(), maxError);

		String randomAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(ownerAddress1, randomAddress);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(ownerAddress1, "value"), randomAddress);

		// Address 2 Field Validation
		WebUI.clearText(ownerAddress2);
		WebUI.setText(ownerAddress2, addMaxAddressChars);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(errorMsgOwnerAddress2);
		WebUI.verifyContains(getTextElement(errorMsgOwnerAddress2).trim(), maxError);

		String randomAddress2 = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(ownerAddress2, randomAddress2);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(ownerAddress2, "value"), randomAddress2);

		WebUI.scrollToElementAtBottom(step3NextButton);
		WebUI.sleep(0.2);

		// Zip code Field Validation
		WebUI.verifyContains(getTextElement(errorMsgZipCode), mandatoryError);

		WebUI.clearText(ownerZipCode);
		WebUI.setText(ownerZipCode, "1234");
		WebUI.verifyElementVisible(errorMsgZipCode);
		WebUI.verifyContains(getTextElement(errorMsgZipCode), minZipError);

		WebUI.clearText(ownerZipCode);
		WebUI.setText(ownerZipCode, "123456");
		WebUI.verifyElementVisible(errorMsgZipCode);
		WebUI.verifyContains(getTextElement(errorMsgZipCode), maxZipError);

		// TC_154
		WebUI.clearText(ownerZipCode);
		WebUI.moveToElement(zipCodeSearchButton);
		WebUI.clickElement(zipCodeSearchButton);
		WebUI.verifyElementVisible(errorMsgZipCodeSearchButton);
		WebUI.verifyContains(getTextElement(errorMsgZipCodeSearchButton), zipCodeSearchButtonError);

		WebUI.verifyContains(getTextElement(errorMsgOwnerCity), mandatoryError);
		WebUI.verifyContains(getTextElement(errorMsgOwnerState), mandatoryError);

		WebUI.clearAndFillText(ownerZipCode, PropertiesHelpers.getValue("zip_Code"));
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(ownerZipCode, "value"), PropertiesHelpers.getValue("zip_Code"));

		WebUI.moveToElement(zipCodeSearchButton);
		WebUI.clickElement(zipCodeSearchButton);
		WebUI.sleep(2);

		WebUI.verifyContains(getTextElement(errorMsgOwnerCity), mandatoryError);

		List<String> cities = WebUI.getElementTextsInList(ownerCityList);
		for (int i = 1; i < cities.size(); i++) {
			WebUI.selectOptionByIndex(ownerCity, i);
			WebUI.sleep(1);
		}
		WebUI.clickElement(ownerCity);
		WebUI.setText(ownerCity, "d", Keys.ENTER);
		WebUI.sleep(1);

//		================================= Policy Payor Information =============================================================================
		try {

			DriverManager.getDriver().findElement(policyPayorYes).isDisplayed();
			DriverManager.getDriver().findElement(policyPayorNo).isDisplayed();
			WebUI.scrollToElementAtTop(policyPayorNo);
			WebUI.sleep(0.2);
			WebUI.clickElement(policyPayorNo);
			WebUI.sleep(0.5);
			WebUI.clickElement(policyPayorYes);
			WebUI.sleep(1);

			WebUI.verifyElementVisible(payorFirstName);
			WebUI.verifyElementVisible(payorMiddleName);
			WebUI.verifyElementVisible(payorLastName);
			WebUI.verifyElementVisible(payorEmail);
			WebUI.verifyElementVisible(payorPhone);
			WebUI.sleep(1);

			WebUI.verifyContains(getTextElement(payorFistNameErrorMsg), mandatoryError);

			WebUI.sleep(0.5);
			WebUI.clearText(payorFirstName);
			WebUI.setText(payorFirstName, maxCharacters);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorFistNameErrorMsg);
			WebUI.verifyContains(getTextElement(payorFistNameErrorMsg), maxError);

			String payorRandomFirstName = DataGenerateUtils.randomFirstName();
			WebUI.clearAndFillText(payorFirstName, payorRandomFirstName);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorFirstName, "value"), payorRandomFirstName);

			WebUI.clearText(payorMiddleName);
			WebUI.setText(payorMiddleName, maxCharacters);
			WebUI.verifyElementVisible(payorMiddleNameErrorMsg);
			WebUI.verifyContains(getTextElement(payorMiddleNameErrorMsg), maxError);

			String payorRandomMiddleName = DataGenerateUtils.randomMiddleName();
			WebUI.clearAndFillText(payorMiddleName, payorRandomMiddleName);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorMiddleName, "value"), payorRandomMiddleName);

			WebUI.verifyContains(getTextElement(payorLastNameErrorMsg), mandatoryError);

			WebUI.clearText(payorLastName);
			WebUI.setText(payorLastName, maxCharacters);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorLastNameErrorMsg);
			WebUI.verifyContains(getTextElement(payorLastNameErrorMsg), maxError);

			String payorRandomLastName = DataGenerateUtils.randomLastName();
			WebUI.clearAndFillText(payorLastName, payorRandomLastName);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorLastName, "value"), payorRandomLastName);

			WebUI.verifyContains(getTextElement(payorEmailErrorMsg), mandatoryError);

			WebUI.clearText(payorEmail);
			WebUI.setText(payorEmail, "destiny001");
			WebUI.verifyElementVisible(payorEmailErrorMsg);
			WebUI.verifyContains(getTextElement(payorEmailErrorMsg), incorrectEmailError);

			WebUI.scrollToElementAtBottom(payorSSNRadioButton);
			WebUI.sleep(0.2);
			WebUI.clearText(payorEmail);
			WebUI.setText(payorEmail, emailMaxChar);
			WebUI.verifyElementVisible(payorEmailErrorMsg);
			WebUI.verifyContains(getTextElement(payorEmailErrorMsg).trim(), emailMaxErrorMsg);

			String payorRandomEmailAddress = DataGenerateUtils.randomEmail();
			WebUI.clearAndFillText(payorEmail, payorRandomEmailAddress);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorEmail, "value"), payorRandomEmailAddress);

			WebUI.clearAndFillText(payorPhone, "789456");
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorPhoneErrorMsg);
			WebUI.verifyContains(WebUI.getTextElement(payorPhoneErrorMsg), phoneMinErrorMsg);
			WebUI.sleep(0.2);
//			WebUI.clearAndFillText(payorPhone, "258014736999");
//			WebUI.sleep(0.2);
//			WebUI.verifyElementVisible(payor_PhoneErrorMsg);
//			WebUI.verifyContains(WebUI.getTextElement(payor_PhoneErrorMsg), phoneMaxErrorMsg);

			WebUI.clearAndFillText(payorPhone, PropertiesHelpers.getValue("benif_phone"));
			WebUI.sleep(0.2);

			WebUI.scrollToElementAtTop(payorSSN);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), "Value required");
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnErrorMsg);

			WebUI.clickElement(payorEINRadioButton);
			WebUI.sleep(0.2);

			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnErrorMsg); // Here in place of ssnErrorMsg
																					// error, it should have einErrorMsg
			WebUI.clickElement(payorSSNRadioButton);
			WebUI.sleep(0.2);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "25478451");
			WebUI.verifyElementVisible(payorSSNEINErrorMsg);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnErrorMsg);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "111111111");
			WebUI.verifyElementVisible(payorSSNEINErrorMsg);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), invalidSSN);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "000000000");
			WebUI.verifyElementVisible(payorSSNEINErrorMsg);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnNumberError);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "asasa");
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnNumberError);

			WebUI.clickElement(payorEINRadioButton);
			WebUI.sleep(0.2);

//			WebUI.clearText(payorSSN);
//			WebUI.setText(payorSSN, charactersOnly);
//			WebUI.verifyElementVisible(payor_Error_SSN_EIN_Message);
//			WebUI.verifyContains(getTextElement(payor_Error_SSN_EIN_Message), invalidEIN);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "25478451");
			WebUI.verifyElementVisible(payorSSNEINErrorMsg);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnErrorMsg);

			WebUI.clearText(payorSSN);
			WebUI.setText(payorSSN, "000000000");
			WebUI.verifyElementVisible(payorSSNEINErrorMsg);
			WebUI.verifyContains(getTextElement(payorSSNEINErrorMsg), ssnNumberError);

//			WebUI.clearText(payorSSN);
//			WebUI.setText(payorSSN, "asasa");
//			WebUI.verifyElementVisible(payor_Error_SSN_EIN_Message);
//			WebUI.verifyContains(getTextElement(payor_Error_SSN_EIN_Message), invalidEIN);		

			String payorEINNumber = DataGenerateUtils.randomValidITIN();
			WebUI.clearAndFillText(payorSSN, payorEINNumber);
			WebUI.sleep(0.5);
			WebUI.verifyContains(getAttributeElement(payorSSN, "value"), payorEINNumber);

			WebUI.clickElement(payorSSNRadioButton);
			WebUI.sleep(0.2);

			String payorSSNNumber = DataGenerateUtils.randomValidSSN();
			WebUI.clearAndFillText(payorSSN, payorSSNNumber);
			WebUI.sleep(0.5);
			WebUI.verifyContains(getAttributeElement(payorSSN, "value"), payorSSNNumber);

			WebUI.scrollToElementAtBottom(step3NextButton);
			WebUI.sleep(0.2);
			WebUI.clickElement(step3NextButton);
			WebUI.scrollToElementAtTop(payorSSN);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getTextElement(payorAgeErrorMsg), mandatoryError);

			WebUI.clearText(payorAge);
			WebUI.setText(payorAge, "122");
			WebUI.verifyElementVisible(payorAgeErrorMsg);
			WebUI.verifyContains(getTextElement(payorAgeErrorMsg), maxAgeError);

			WebUI.clearText(payorAge);
			WebUI.setText(payorAge, "65");
			WebUI.verifyContains(getAttributeElement(payorAge, "value"), "65");

			// Relationship Field Validation
			WebUI.verifyContains(getTextElement(payorRelationErrorMsg), mandatoryError);

			List<String> payorrelationships = WebUI.getElementTextsInList(payorRelationList);
			for (int i = 1; i < payorrelationships.size(); i++) {
				WebUI.selectOptionByIndex(payorRelation, i);
				WebUI.sleep(0.2);
			}

			WebUI.sleep(0.2);
			WebUI.clickElement(payorRelation);
			WebUI.setText(payorRelation, "p", Keys.ENTER);

			// Address 1 Field Validation
			WebUI.scrollToElementAtBottom(payorZipCode);
			WebUI.verifyContains(getTextElement(payorAddress1ErrorMsg), mandatoryError);

			WebUI.clearText(payorAddress1);
			WebUI.setText(payorAddress1, addMaxAddressChars);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorAddress1ErrorMsg);
			WebUI.verifyContains(getTextElement(payorAddress1ErrorMsg), maxError);

			String payorRandomAddress1 = DataGenerateUtils.randomShortAddress();
			WebUI.clearAndFillText(payorAddress1, payorRandomAddress1);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorAddress1, "value"), payorRandomAddress1);

			// Address 2 Field Validation
			WebUI.clearText(payorAddress2);
			WebUI.setText(payorAddress2, addMaxAddressChars);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorAddress2ErrorMsg);
			WebUI.verifyContains(getTextElement(payorAddress2ErrorMsg), maxError);

			String payorRandomAddress2 = DataGenerateUtils.randomShortAddress();
			WebUI.clearAndFillText(payorAddress2, payorRandomAddress2);
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorAddress2, "value"), payorRandomAddress2);

			WebUI.scrollToElementAtBottom(step3NextButton);
			WebUI.sleep(0.2);

			// Payor City Validation
			WebUI.verifyContains(getTextElement(payorCityErrorMsg), mandatoryError);

			WebUI.clearText(payorCity);
			WebUI.setText(payorCity, addMaxAddressChars);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(payorCityErrorMsg);
			WebUI.verifyContains(getTextElement(payorCityErrorMsg), maxError);

			WebUI.clearAndFillText(payorCity, "Allgood");
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorCity, "value"), "Allgood");

			WebUI.sleep(0.2);
			WebUI.verifyContains(getTextElement(payorStateErrorMsg), mandatoryError);

			WebUI.clickElement(payorState);
			WebUI.sleep(0.5);
			WebUI.selectOptionByValue(payorState, "AL");
			WebUI.sleep(0.5);

			WebUI.verifyContains(getTextElement(payorZipCodeErrorMsg), mandatoryError);

			WebUI.clearText(payorZipCode);
			WebUI.setText(payorZipCode, "3456");
			WebUI.verifyElementVisible(payorZipCodeErrorMsg);
			WebUI.verifyContains(getTextElement(payorZipCodeErrorMsg), minZipError);

			WebUI.clearText(payorZipCode);
			WebUI.setText(payorZipCode, "345678");
			WebUI.verifyElementVisible(payorZipCodeErrorMsg);
			WebUI.verifyContains(getTextElement(payorZipCodeErrorMsg), maxZipError);

			WebUI.clearAndFillText(payorZipCode, "35013");
			WebUI.sleep(0.2);
			WebUI.verifyContains(getAttributeElement(payorZipCode, "value"), "35013");

		} catch (Exception ex) {

			System.out.println("Policy Payor Information Not Available. " + ex.getMessage());
		}

//================================= Secondary Addressee Designation =============================================================================
		try {
			DriverManager.getDriver().findElement(secondaryAddresseeNo).isDisplayed();
			WebUI.clickElement(secondaryAddresseeNo);
			WebUI.sleep(1);
		} catch (Exception exe) {
			System.out.println("Secondary Addressee Designation Information Not Provided." + exe.getMessage());
		}

		WebUI.scrollToElementAtBottom(step3NextButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementClickable(step3NextButton);
		WebUI.verifyElementClickable(tableOfContents);
		WebUI.verifyElementClickable(backToList);

		WebUI.scrollToElementAtBottom(step3NextButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(step3NextButton);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(step4);
		WebUI.logInfoMessage("Element is Visible " + step4);

	}

}
