package com.codetru.project.cica.pages.regressionApplicationModule;


import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;


public class Step_1Page extends CommonPageCICA{


	private By pageError = By.xpath("//p[.='There are some errors on this page. Please correct before continuing.']");
	private By firstName = By.xpath("//ion-input[@formcontrolname='ProposedFirstName']/input");
	private By firstNameLabel = By.xpath("//ion-input[@formcontrolname='ProposedFirstName']/parent::ion-item");
	private By firstNameErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='8'])[1]");
	private By middleName = By.xpath("//ion-input[@formcontrolname='ProposedMiddleName']/input");
	private By middleNameErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='8'])[2]");
	private By lastName = By.xpath("//ion-input[@formcontrolname='ProposedLastName']/input");
	private By lastNameErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='8'])[3]");
	private By stateDropdown = By.xpath("//select[@formcontrolname='ProposedPhysicalState']");
	private By stateErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='4'])[1]");
	private By state = By.xpath("(//option[.=' Louisiana'])[1]");
	private By genderDropdown = By.xpath("//select[@formcontrolname='ProposedGender']");
	private By genderErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[1]");
	private By dateOfBirth = By.xpath("//input[@formcontrolname='ProposedBirthDate']");
	private By age = By.xpath("//ion-input[@formcontrolname='ProposedAge']");
	private By dateOfBirthErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[2]");
	private By applicantLocationErrorMsg = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[4]");
	private By signedStateDropdown = By.xpath("//select[@formcontrolname='SignedState']");
	private By preferredLanguage = By.xpath("//select[@formcontrolname='ProposedPreferredLanguage']");
	private By language = By.xpath("//option[.=' English']");
	private By callYes = By.xpath("(//ion-label[.='Yes'])[1]");
	private By callNo = By.xpath("(//ion-label[.='No'])[1]");
	private By languageErrorMsg = By.xpath("//select[@formcontrolname='ProposedPreferredLanguage']/parent::ion-item/parent::ion-col");
	private By basePlanErrorMessage = By.xpath("//ion-col[@class = 'md hydrated' and @size-md = '7']");
	private By plan = By.xpath("//select[@formcontrolname='Plan']");
	private By faceAmount = By.xpath("//ion-input[@formcontrolname='AmountOfInsurance']/input");
	private By faceAmountErrorMessage = By.xpath("//ion-col[@class = 'md hydrated' and @size-md = '3']");
	private By annually = By.xpath("//ion-label[text()='Annually']/following-sibling::ion-radio");
	private By semiAnnually = By.xpath("//ion-label[text()='Semi-Annually']/following-sibling::ion-radio");
	private By quarterly = By.xpath("//ion-label[text()='Quarterly']/following-sibling::ion-radio");
	private By monthly = By.xpath("//ion-label[text()='Monthly']/following-sibling::ion-radio");
	private By yes = By.xpath("(//ion-label[text()='Yes']/following-sibling::ion-radio)[2]");
	private By no = By.xpath("(//ion-label[text()='No']/following-sibling::ion-radio)[2]");
	private By nextStep1 = By.xpath("(//ion-col/ion-button[starts-with(@class, 'md button')])[5]");
	private By premiumType = By.xpath("//ion-label[text()='monthly']/following-sibling::ion-radio");
	private By loanRadioBtn = By.xpath("(//ion-label[text()='Yes']/following-sibling::ion-radio)[2]");
	private By calculate = By.xpath("(//div/ion-row/ion-col/ion-button[starts-with(@class, md)])[2]");
	private By totalAnnualPremium = By.xpath("//h4[contains(text(), 'Total Annual Premium')]");
	private By modePremium = By.xpath("//h4[contains(text(), 'Mode Premium')]");
	private By basePremium = By.xpath("//h4[contains(text(), 'Base Premium')]");
	private By accidentalDeathPremium = By.xpath("//h4[contains(text(), 'Accidental Death Premium')]");
	private By tableOfContents = By.xpath("(//ion-button[normalize-space()='Table of Contents'])[1]");
	private By backToList = By.xpath("(//ion-button[normalize-space()='Back to List'])[1]");
	private By listColumnNames = By.xpath("//div[@class='table-responsive hidden-sm-down']//table//thead//tr/th");
	
	private By step1 = By.xpath("//span[.='Step 1: Product Information']");
	private By step2 = By.xpath("//span[normalize-space()='Step 2: Proposed Insured Information']");
	private By stepsList = By.xpath("//ion-list//span");
	
	private By insuredInfoElement = By.xpath("//h3[.='Proposed Insured Info']");
	private By authorizationConsent = By.xpath("//h3[normalize-space()='Authorization/Consent']");
	private By planOptions = By.xpath("//h3[normalize-space()='Plan Options']");
	
	// Global Person icon
	private By globalPersonIcon = By.xpath("//ion-icon[@name='person-add']/parent::ion-button");	
	private By editPersonHeader = By.xpath("//ion-title[normalize-space()='Edit Person']");
	private By editPersonInformation = By.xpath("//h3[normalize-space()='Person Information']");
	private By editSaveAndCloseButton = By.xpath("//ion-button[normalize-space()='Save And Close']");
	private By editClearButton = By.xpath("//ion-button[normalize-space()='Clear']");
	private By editCloseButton = By.xpath("//ion-button[normalize-space()='Close']");
	
	private By personInfoFirstName = By.xpath("//ion-input[@formcontrolname='FirstName']/input");
	private By personInfoMiddleName = By.xpath("//ion-input[@formcontrolname='MiddleName']/input");
	private By personInfoLastName = By.xpath("//ion-input[@formcontrolname='LastName']/input");
	private By personInfoFirstNameErrMsg = By.xpath("//ion-input[@formcontrolname='FirstName']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoMiddleNameErrMsg = By.xpath("//ion-input[@formcontrolname='MiddleName']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoLastNameErrMsg = By.xpath("//ion-input[@formcontrolname='LastName']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoGenderDropdown = By.xpath("//select[@formcontrolname='Gender']");
	private By personInfoGender = By.xpath("//option[.='Male']");
	private By personInfoDOB = By.xpath("//input[@formcontrolname='BirthDate']");
	private By personInfoSSNNo = By.xpath("//ion-input[@formcontrolname='SSN']/input");
	private By personInfoSSNErrorMsg = By.xpath("//ion-input[@formcontrolname='SSN']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoSSNMaxErrorMsg = By.xpath("//p[text()='The maximum number of characters is 9. ']");
	private By personInfoAddress1 = By.xpath("//ion-input[@formcontrolname='Address1']/input");
	private By personInfoAddress1ErrorMsg = By.xpath("//ion-input[@formcontrolname='Address1']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoAddress2 = By.xpath("//ion-input[@formcontrolname='Address2']/input");
	private By personInfoAddress2ErrorMsg = By.xpath("//ion-input[@formcontrolname='Address2']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoCity = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By personInfoCityErrorMsg = By.xpath("//ion-input[@formcontrolname='City']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoStateDropdown = By.xpath("//select[@formcontrolname='State']");
	private By personInfoZipcode = By.xpath("//ion-input[@formcontrolname='ZipCode']/input");
	private By personInfoZipcodeErrorMsg = By.xpath("//ion-input[@formcontrolname='ZipCode']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoEmail = By.xpath("//ion-input[@formcontrolname='Email']/input");
	private By personInfoEmailErrorMsg = By.xpath("//ion-input[@formcontrolname='Email']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoPhone = By.xpath("//ion-input[@formcontrolname='Phone']/input");
	private By personInfoPhoneErrorMsg = By.xpath("//ion-input[@formcontrolname='Phone']/ancestor-or-self::ion-col/div/div/p");
	private By personInfoMobile = By.xpath("//ion-input[@formcontrolname='MobilePhone']/input");
	private By personInfoMobileErrorMsg = By.xpath("//ion-input[@formcontrolname='MobilePhone']/ancestor-or-self::ion-col/div/div/p");
	private By licCounty = By.xpath("//select[@formcontrolname='SignedCounty']");
	// Proposed insured info person icon
	private By infoPersonIcon = By.xpath("//h3[.='Proposed Insured Info']/parent::div/descendant-or-self::ion-icon");
	private By infoPersonPopupHeader = By.xpath("//ion-title[normalize-space()='Copy']");
	private By dataAndAddRadioButton = By.xpath("//ion-label[.='Person Data And Address ']");
	private By addressOnlyRadioButton = By.xpath("//ion-label[.='Address Only ']");
	private By infoPersonPopupCopyButton = By.xpath("//ion-button[normalize-space()='Copy']");
	// DOB validation
	private By errorMessageAge = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[3]");
	//Appointment Acknowledgement Pop-up
	private By appointmentAcknowledgement = By.xpath("//ion-button[normalize-space()='yes, I acknowledge the statement above']");
	private By agentLicense = By.xpath("//button[@type='button']");
	private By TableOfContent_BackButton = By.xpath("//span[@title='Table of Contents']");
	private By impNoticePopup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	
	public static String ageTextBoxValue;

	public void Product_Information() {

		String mandatoryError = "Please enter a value.";
		String maxCharacterError = "The maximum number of characters is 33.";
		String maxCharacters = "qwertyuiopqwertyuiopqwertyuiopqwertyu";
		String pageErrorMsg = "There are some errors on this page. Please correct before continuing.";
		String faceAmountMaxError = "The maximum amount is 30000.";
		String faceAmountMinError = "The minimum amount is 1000.";
		String personInfoSSNMinError = "The minimum number of characters is 9.";
		String personInfoSSNMaxError = "The maximum number of characters is 9.";
		String personInfoZipMinError = "The minimum number of characters is 5.";
		String personInfoZipMaxError = "The maximum number of characters is 5.";
		String personInfoPhoneMinError = "The minimum number of characters is 10.";
		String personInfoPhoneMaxError = "The maximum number of characters is 10.";
		String addressMax = "280 SIERRA DR. APT. B407 1142 SW ARLINGTON BLVD 1142 SW ARLINGTON BLVD";
		String incorrectEmailError = "Email format not correct.";
		String emailMaxChar = "destinysdfghdfghdfsgdsfgsdfgdfghdfghdsfghjdsfghdfghdfghfgh";
		String emailMaxError ="The maximum number of characters is 50";
		String cityInvalid="qweqwertyuioplkjhgfdsazxcvbnmmnbvc";
		String zipcodeInvalid="415236987";
		String age_Max_Error = "The maximum amount is 85.";
//		String age_Max_Error = "The maximum age is 85.";
		String textFieldBoundaryExpectedColor = "rgb(135, 135, 135)";
		 
		List<String> licensedStatesList = ThreadLocalManager.getLicenseStateList();
		List<String> licenseCountyList = ThreadLocalManager.getLicenseCountyList();

		WebUI.verifyElementPresent(insuredInfoElement);						
		WebUI.verifyElementPresent(authorizationConsent);					
		WebUI.scrollToElementAtBottom(planOptions);
		WebUI.sleep(0.3);
		WebUI.verifyElementPresent(planOptions);							
		
		WebUI.scrollToElementAtTop(globalPersonIcon);
		WebUI.sleep(0.3);
		WebUI.verifyElementPresent(globalPersonIcon);						
		WebUI.clickElement(globalPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyElementPresent(editPersonHeader);						
		WebUI.verifyElementPresent(editPersonInformation);					
		WebUI.verifyElementPresent(editClearButton);						
		WebUI.verifyElementPresent(editCloseButton);						
		WebUI.sleep(0.5);
		
//	==============================Global Person Popup Fields Validation ============================================================================	
		WebUI.clearAndFillText(personInfoFirstName,maxCharacters);
		WebUI.sleep(0.1);

		WebUI.scrollToElementAtBottom(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(editSaveAndCloseButton);
		
		WebUI.scrollToElementAtTop(editPersonHeader);
		WebUI.sleep(0.1);
		WebUI.verifyElementVisible(personInfoFirstNameErrMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoFirstNameErrMsg), maxCharacterError);
		
		String randomFirstName = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(personInfoFirstName, randomFirstName);
		WebUI.sleep(0.1);
		WebUI.verifyContains(getAttributeElement(personInfoFirstName,"value"),randomFirstName);
		
		WebUI.clearText(personInfoMiddleName);
		WebUI.setText(personInfoMiddleName, maxCharacters);
		WebUI.verifyElementVisible(personInfoMiddleNameErrMsg);
		WebUI.verifyContains(getTextElement(personInfoMiddleNameErrMsg).trim(), maxCharacterError);
		
		String randomMiddleName = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(personInfoMiddleName,randomMiddleName);
		WebUI.sleep(0.1);
		WebUI.verifyContains(getAttributeElement(personInfoMiddleName,"value"),randomMiddleName);

		WebUI.clearText(personInfoLastName);
		WebUI.setText(personInfoLastName, maxCharacters);
		WebUI.verifyElementVisible(personInfoLastNameErrMsg);
		WebUI.verifyContains(getTextElement(personInfoLastNameErrMsg).trim(), maxCharacterError);

		String randomLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(personInfoLastName,randomLastName);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoLastName,"value"),randomLastName);
		
		WebUI.selectOptionByText(personInfoGenderDropdown, PropertiesHelpers.getValue("gender"));
		WebUI.setText(personInfoDOB, PropertiesHelpers.getValue("date_Of_Birth"));
	 
		WebUI.verifyElementVisible(personInfoSSNNo);
		WebUI.setText(personInfoSSNNo, "25478451");
		WebUI.verifyElementVisible(personInfoSSNErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoSSNErrorMsg).trim(), personInfoSSNMinError);
	 
		WebUI.clearText(personInfoSSNNo);
		WebUI.setText(personInfoSSNNo, "25478451123");
		WebUI.verifyElementVisible(personInfoSSNMaxErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoSSNMaxErrorMsg).trim(), personInfoSSNMaxError);
			
		String randomSSNNumber = DataGenerateUtils.randomValidSSN();
		WebUI.clearAndFillText(personInfoSSNNo,randomSSNNumber);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoSSNNo,"value"),randomSSNNumber);
 
		WebUI.clearText(personInfoAddress1);
		WebUI.setText(personInfoAddress1, addressMax);
		WebUI.scrollToElementAtBottom(editSaveAndCloseButton);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtTop(personInfoAddress1);
		WebUI.verifyElementVisible(personInfoAddress1ErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoAddress1ErrorMsg).trim(), maxCharacterError);
		
		String randomAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(personInfoAddress1,randomAddress);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoAddress1,"value"),randomAddress);
		
		WebUI.clearText(personInfoAddress2);
		WebUI.setText(personInfoAddress2, addressMax);
		WebUI.scrollToElementAtBottom(editSaveAndCloseButton);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtTop(personInfoAddress2);
		WebUI.verifyElementVisible(personInfoAddress2ErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoAddress2ErrorMsg).trim(), maxCharacterError);
		
		String randomAddress2 = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(personInfoAddress2,randomAddress2);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoAddress2,"value"),randomAddress2);
		
		WebUI.sleep(1);
		WebUI.setText(personInfoCity, cityInvalid);
		WebUI.scrollToElementAtBottom(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtTop(personInfoCity);
		WebUI.sleep(0.4);
		WebUI.verifyElementVisible(personInfoCityErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoCityErrorMsg), maxCharacterError);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(personInfoCity, PropertiesHelpers.getValue("benif_City"));
		WebUI.sleep(0.2);
		
		WebUI.clickElement(personInfoStateDropdown);
		WebUI.sleep(0.5);
		WebUI.setText(personInfoStateDropdown, "Te",Keys.ENTER);
			
		WebUI.clearAndFillText(personInfoZipcode, "7894");
		WebUI.scrollToElementAtBottom(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoZipcodeErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoZipcodeErrorMsg), personInfoZipMinError);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(personInfoZipcode, zipcodeInvalid);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoZipcodeErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoZipcodeErrorMsg), personInfoZipMaxError);
		
		WebUI.clearAndFillText(personInfoZipcode, PropertiesHelpers.getValue("benif_Zip"));
		WebUI.sleep(0.3);
		
		WebUI.clearText(personInfoEmail);
		WebUI.setText(personInfoEmail, "destiny001");
		WebUI.verifyElementVisible(personInfoEmailErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoEmailErrorMsg).trim(), incorrectEmailError);

		WebUI.clearText(personInfoEmail);
		WebUI.setText(personInfoEmail, emailMaxChar);
		WebUI.verifyElementVisible(personInfoEmailErrorMsg);
		WebUI.verifyContains(getTextElement(personInfoEmailErrorMsg).trim(), incorrectEmailError);

		String randomEmailAddress = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(personInfoEmail, randomEmailAddress);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoEmail,"value"), randomEmailAddress);	

		WebUI.clearAndFillText(personInfoPhone, "789456");
		WebUI.sleep(0.2);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoPhoneErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoPhoneErrorMsg), personInfoPhoneMinError);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(personInfoPhone, "258014736999");
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoPhoneErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoPhoneErrorMsg), personInfoPhoneMaxError);
		
		WebUI.clearAndFillText(personInfoPhone, PropertiesHelpers.getValue("benif_phone"));
		WebUI.sleep(0.2);
		
		WebUI.clearAndFillText(personInfoMobile, "789456");
		WebUI.sleep(0.2);
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoMobileErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoMobileErrorMsg), personInfoPhoneMinError);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(personInfoMobile, "258014736999");
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(personInfoMobileErrorMsg);
		WebUI.verifyContains(WebUI.getTextElement(personInfoMobileErrorMsg), personInfoPhoneMaxError);
		
		String randomMobileNumber = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(personInfoMobile,randomMobileNumber);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(personInfoMobile,"value"),randomMobileNumber);
		
		WebUI.clickElement(editSaveAndCloseButton);
		WebUI.sleep(1);

		WebUI.verifyElementNotVisible(editPersonHeader);
		
		WebUI.clickElement(globalPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyEquals(getAttributeElement(personInfoFirstName,"value"), randomFirstName);
		WebUI.verifyEquals(getAttributeElement(personInfoLastName,"value"), randomLastName);
		WebUI.verifyEquals(getAttributeElement(personInfoEmail,"value"), randomEmailAddress);
		
		WebUI.clickElement(editClearButton);
		WebUI.sleep(1);
		
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoFirstName,"value"), "");
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoLastName,"value"), "");
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoZipcode,"value"), "");
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoEmail,"value"), "");
		
		
		
		WebUI.clickElement(editCloseButton);
		WebUI.sleep(0.5);
		WebUI.verifyElementNotVisible(editPersonHeader);
		
		
		WebUI.clickElement(globalPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoFirstName,"value"), randomFirstName);
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoLastName,"value"), randomLastName);
		WebUI.clickElement(editClearButton);
		WebUI.clickElement(editSaveAndCloseButton);
		
		WebUI.clickElement(globalPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoFirstName,"value"), "");
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoLastName,"value"), "");
		
		String randomFirstName2 = DataGenerateUtils.randomFirstName();
		WebUI.setText(personInfoFirstName, randomFirstName2);
		WebUI.sleep(1);
		WebUI.verifyEquals(WebUI.getAttributeElement(personInfoFirstName,"value"), randomFirstName2);
		String randomLastName2 = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(personInfoLastName, randomLastName2);
		WebUI.setText(personInfoAddress1,randomAddress);
		WebUI.sleep(0.4);
		WebUI.verifyContains(getAttributeElement(personInfoAddress1,"value"),randomAddress);
		WebUI.clearAndFillText(personInfoAddress2, randomAddress2);
		
		WebUI.clickElement(editCloseButton);
		WebUI.verifyElementNotVisible(editPersonHeader);
		WebUI.clickElement(globalPersonIcon);
		WebUI.sleep(0.4);
		WebUI.verifyEquals(getAttributeElement(personInfoFirstName,"value"), "");
		WebUI.verifyEquals(getAttributeElement(personInfoLastName,"value"), "");
		
		WebUI.clearAndFillText(personInfoFirstName, randomFirstName);
		WebUI.clearAndFillText(personInfoLastName, randomLastName);
		WebUI.selectOptionByText(personInfoGenderDropdown, PropertiesHelpers.getValue("gender"));
		WebUI.setText(personInfoDOB, PropertiesHelpers.getValue("date_Of_Birth"));
		WebUI.clearAndFillText(personInfoSSNNo, randomSSNNumber);
		WebUI.clearAndFillText(personInfoAddress1, randomAddress);
		WebUI.clearAndFillText(personInfoAddress2, randomAddress2);
		WebUI.clearAndFillText(personInfoCity, PropertiesHelpers.getValue("benif_City"));
		WebUI.setText(personInfoStateDropdown, "Tx", Keys.ENTER);
		WebUI.clearAndFillText(personInfoZipcode, PropertiesHelpers.getValue("benif_Zip"));
		WebUI.clearAndFillText(personInfoEmail, randomEmailAddress);
		WebUI.clearAndFillText(personInfoPhone, PropertiesHelpers.getValue("benif_phone"));
		WebUI.clearAndFillText(personInfoMobile, randomMobileNumber);
		WebUI.clickElement(editSaveAndCloseButton);
		
		//============ Proposed insured info person (Copy) popup validation ====================================================
		WebUI.sleep(2);
		WebUI.clickElementWithJs(infoPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(infoPersonPopupHeader);
		WebUI.verifyElementPresent(dataAndAddRadioButton);
		WebUI.verifyElementPresent(addressOnlyRadioButton);
		
		WebUI.verifyEquals(getAttributeElement(personInfoFirstName,"value"), randomFirstName);
		WebUI.verifyEquals(getAttributeElement(personInfoLastName,"value"),randomLastName);
		WebUI.verifyEquals(getAttributeElement(personInfoSSNNo,"value"), randomSSNNumber);
		WebUI.verifyEquals(getAttributeElement(personInfoEmail,"value"), randomEmailAddress);
		WebUI.verifyEquals(getAttributeElement(personInfoMobile,"value"), randomMobileNumber);
		
		WebUI.clearAndFillText(personInfoMiddleName, randomMiddleName);
		WebUI.sleep(0.3);
		WebUI.verifyEquals(getAttributeElement(personInfoMiddleName,"value"), randomMiddleName);
		
		WebUI.verifyElementEnabled(personInfoDOB);
		WebUI.verifyElementEnabled(personInfoGender);
		WebUI.verifyElementEnabled(personInfoCity);
		WebUI.verifyElementEnabled(personInfoStateDropdown);
		WebUI.verifyElementEnabled(personInfoZipcode);
		WebUI.verifyElementEnabled(personInfoPhone);
		
		WebUI.scrollToElementAtTop(addressOnlyRadioButton);
		WebUI.sleep(0.2);
		WebUI.clickElementWithJs(addressOnlyRadioButton);
		WebUI.sleep(0.3);
		WebUI.scrollToElementAtBottom(infoPersonPopupCopyButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(infoPersonPopupCopyButton);
		WebUI.sleep(0.5);
		WebUI.verifyElementNotVisible(infoPersonPopupHeader);
		WebUI.verifyContains(getAttributeElement(stateDropdown,"value"),"TX");
		
		WebUI.clickElementWithJs(infoPersonIcon);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(infoPersonPopupHeader);
		WebUI.clickElementWithJs(dataAndAddRadioButton);
		WebUI.scrollToElementAtBottom(infoPersonPopupCopyButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(infoPersonPopupCopyButton);
		WebUI.sleep(0.5);
		WebUI.verifyElementNotVisible(infoPersonPopupHeader);
		WebUI.verifyEquals(getAttributeElement(firstName,"value"),randomFirstName);
		WebUI.verifyEquals(getAttributeElement(middleName,"value"), randomMiddleName);
		WebUI.verifyEquals(getAttributeElement(lastName,"value"), randomLastName);
//		WebUI.verifyContains(getAttributeElement(dateOfBirth,"value"),PropertiesHelpers.getValue("date_Of_Birth"));
		
		WebUI.clickElementWithJs(infoPersonIcon);
		WebUI.sleep(1);
		WebUI.clickElement(editClearButton);
		WebUI.sleep(0.5);
		WebUI.verifyEquals(getAttributeElement(personInfoFirstName,"value"), "");
		WebUI.verifyEquals(getAttributeElement(personInfoLastName,"value"), "");
		WebUI.verifyEquals(getAttributeElement(personInfoSSNNo,"value"), "");
		WebUI.verifyEquals(getAttributeElement(personInfoZipcode,"value"), "");
		WebUI.verifyEquals(getAttributeElement(personInfoEmail,"value"), "");
		
		WebUI.clickElement(editCloseButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementNotVisible(infoPersonPopupHeader);
		
		WebUI.clickElementWithJs(infoPersonIcon);
		WebUI.sleep(0.5);
		WebUI.clickElement(editClearButton);
		WebUI.scrollToElementAtBottom(infoPersonPopupCopyButton);
		WebUI.clickElement(infoPersonPopupCopyButton);
		WebUI.sleep(1);		
		
//=============================================================================================================================================================
		
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.verifyElementClickable(calculate);
		WebUI.clickElement(calculate);
		WebUI.clickElementWithJs(calculate);
		WebUI.scrollToElementAtBottom(pageError);
		WebUI.verifyElementPresent(pageError, "Error message not displayed");

		WebUI.verifyContains(getTextElement(pageError).trim(), pageErrorMsg);

		WebUI.scrollToElementAtBottom(calculate);
		WebUI.clickElement(calculate);
		WebUI.clickElementWithJs(calculate);
		WebUI.scrollToElementAtTop(firstName);
		WebUI.verifyElementVisible(firstName, "First Name textbox not displayed");
		
		WebUI.verifyContains(getTextElement(firstNameErrorMsg).trim(), mandatoryError);

		WebUI.sleep(1);
		WebUI.scrollToElementAtTop(insuredInfoElement);
		WebUI.clearText(firstName);
		WebUI.setText(firstName, maxCharacters);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(firstNameErrorMsg);	
		WebUI.verifyContains(getTextElement(firstNameErrorMsg).trim(), maxCharacterError);	
		
//=================================== TC_Applications_041 Bug || Accepting invalid characters=========================================================================
//		WebUI.clearText(firstName);
//		WebUI.setText(firstName, "  ");
//		WebUI.sleep(0.5);
//		String borderColor2 = WebUI.getCssValueElement(firstNameLabel, "border-color");
//		String borderColor2x = WebUI.getCssValueElement(firstNameLabel, "--highlight-background");
//		System.out.println("Border color of Text Field Box on entering blank space : "+borderColor2);
//		System.out.println("Border color of Text Field Box on entering blank space : "+borderColor2x);
//		WebUI.verifyEquals(borderColor2, textFieldBoundaryExpectedColor);
//		WebUI.sleep(0.5);
//		WebUI.clearAndFillText(firstName, "1234!@#$");
//		WebUI.sleep(0.5);
//		String borderColor3 = WebUI.getCssValueElement(firstNameLabel, "border-color");
//		String borderColor3x = WebUI.getCssValueElement(firstNameLabel, "--highlight-background");
//		System.out.println("Border color of Text Field Box on entering numbers and special characters : "+borderColor3x);
//		WebUI.verifyEquals(borderColor3, textFieldBoundaryExpectedColor);
//====================================================================================================================================================================
		
		ThreadLocalManager.setFirstName(DataGenerateUtils.randomFirstName());
		WebUI.clearAndFillText(firstName,ThreadLocalManager.getFirstName());
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(firstName,"value"),ThreadLocalManager.getFirstName());
		
		WebUI.clearText(middleName);
		WebUI.setText(middleName, maxCharacters);
		WebUI.verifyElementVisible(middleNameErrorMsg);
		WebUI.verifyContains(getTextElement(middleNameErrorMsg).trim(), maxCharacterError);
		
		String newAppRandomMiddleName = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(middleName, newAppRandomMiddleName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(middleName,"value"), newAppRandomMiddleName);

		WebUI.verifyContains(getTextElement(lastNameErrorMsg).trim(), mandatoryError);

		WebUI.clearText(lastName);
		WebUI.setText(lastName, maxCharacters);
		WebUI.verifyElementVisible(lastNameErrorMsg);
		WebUI.verifyContains(getTextElement(lastNameErrorMsg).trim(), maxCharacterError);

		String newAppRandomLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(lastName, newAppRandomLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(lastName,"value"), newAppRandomLastName);
		
		WebUI.verifyContains(getTextElement(stateErrorMsg).trim(), mandatoryError);

		WebUI.verifyElementClickable(stateDropdown);
		WebUI.clickElement(stateDropdown);
		WebUI.clickElementWithJs(stateDropdown);	
		WebUI.sleep(1);
		WebUI.clickElement(state);
		WebUI.clickElementWithJs(state);
		WebUI.verifyContains(getAttributeElement(stateDropdown,"value"), getAttributeElement(stateDropdown,"value"));
		WebUI.verifyContains(getTextElement(genderErrorMsg).trim(), mandatoryError);
		WebUI.selectOptionByText(genderDropdown, PropertiesHelpers.getValue("gender"));
		WebUI.verifyContains(getAttributeElement(genderDropdown,"value"), getAttributeElement(genderDropdown,"value"));
		
//		========================== DOB Validation ========================================================================================

		WebUI.verifyContains(getTextElement(dateOfBirthErrorMsg).trim(), mandatoryError);
		
//		------------------------------ Calendar and Age Validation-----------------------------------------------------
/*		WebUI.moveByOffsetWithRobotAndClick(1525, 265,1);	//Move Slider to top
		WebUI.moveByOffsetWithRobotAndClick(660, 550, 0);	//Click on Calendar
		WebUI.sleep(0.5);
		WebUI.moveByOffsetWithRobotAndClick(680, 516, 0);	//Click on Today
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(dateOfBirth,"value"),WebUI.getCurrentDate());
		WebUI.moveByOffsetWithRobotAndClick(660, 550, 0);	//Click on Calendar
		WebUI.sleep(0.5);
		WebUI.moveByOffsetWithRobotAndClick(535, 516, 0);	//Click on Clear
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(dateOfBirth,"value"),"");
		WebUI.verifyEquals(getAttributeElement(age,"value"), "NaN");
		WebUI.sleep(0.2);
		WebUI.moveByOffsetWithRobotAndClick(660, 550, 0);	//Click on Calendar
		WebUI.sleep(0.2);
		WebUI.moveByOffsetWithRobotAndClick(695, 285, 0);	//Click on Down Arrow
		WebUI.sleep(0.5);
		WebUI.moveByOffsetWithRobotAndClick(554, 404, 0);	//Click on Future date
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(age,"value"), "-1");
*/		
//		----------------------------------------------------------------------------------------------------------------	
		
		WebUI.clearAndFillText(dateOfBirth, "01011938");
		WebUI.sleep(0.2);
		
		WebUI.verifyContains(getTextElement(applicantLocationErrorMsg), mandatoryError);

		int iteration = 1;
		int countryCount = 1;
		for (int i = 0; i < licensedStatesList.size(); i++) {
			try {

				Select sel = new Select(WebUI.getWebElement(signedStateDropdown));
				WebUI.sleep(1);
				ThreadLocalManager.setLicStateIndex(i);
				ThreadLocalManager.setLicCountyIndex(i);

				System.out.println("********** State : " + licensedStatesList.get(i));
				WebUI.logInfoMessage("********** Selected State: " + licensedStatesList.get(i) + " **********");
				WebUI.logInfoMessage("********** Selected State Number: " + 1 + " **********");
				sel.selectByValue(licensedStatesList.get(i));
				WebUI.sleep(1);

				if (licensedStatesList.get(i).equalsIgnoreCase("FL")) {
					WebUI.selectOptionByText(licCounty, licenseCountyList.get(i));
					WebUI.logInfoMessage("********** Selected License County For Florida: " + licenseCountyList.get(i)+ " **********");
					System.out.println("********** Selected License County For Florida: " + licenseCountyList.get(i)+ " **********");
				}

				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(languageErrorMsg), mandatoryError);
				}

				WebUI.verifyElementClickable(preferredLanguage);
				WebUI.clickElementWithJs(preferredLanguage);
				WebUI.sleep(0.5);
				WebUI.clickElement(language);

				WebUI.scrollToElementAtBottom(plan);
				WebUI.sleep(0.2);
				WebUI.clickElementWithJs(callYes);
				WebUI.sleep(0.2);
				WebUI.clickElementWithJs(callNo);

				WebUI.scrollToElementAtBottom(calculate);
				WebUI.verifyElementVisible(calculate);

				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(basePlanErrorMessage).trim(), mandatoryError);
				}

				WebUI.verifyElementClickable(plan);
				WebUI.clickElementWithJs(plan);
				WebUI.sleep(1);
				WebUI.selectOptionByIndex(plan, 1);
				WebUI.sleep(2.5);

				// For Notice Popup
				try {
					DriverManager.getDriver().findElement(impNoticePopup).isDisplayed();
					WebUI.sleep(0.5);
					WebUI.clickElement(impNoticePopup);

				} catch (Exception ex) {
					System.out.println("Notice Popup Did Not Appear. " + ex.getMessage());
				}
				WebUI.clickElementWithJs(calculate);
				WebUI.sleep(1);

				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(faceAmountErrorMessage).trim(), mandatoryError);
				}

				WebUI.clearAndFillText(faceAmount, "30000");
				WebUI.sleep(0.2);
				if (iteration == 1) {
					WebUI.verifyContains(getAttributeElement(faceAmount, "value"), "30000");
				}
				
				// For Notice Popup
				try {
					DriverManager.getDriver().findElement(impNoticePopup).isDisplayed();
					WebUI.sleep(0.5);
					WebUI.clickElement(impNoticePopup);

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.2);
				WebUI.clickElement(calculate);

				WebUI.scrollToElementAtTop(dateOfBirth); // errorMessageAge- Element ....... age_Max_Error - String
				WebUI.sleep(0.2);

				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(errorMessageAge).trim(), age_Max_Error);
				}

				WebUI.clearAndFillText(dateOfBirth, "01011940");
				WebUI.sleep(0.2);
				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.2);
				WebUI.clickElement(calculate);
				WebUI.sleep(0.2);
				WebUI.scrollToElementAtTop(dateOfBirth);
				WebUI.sleep(0.2);
				WebUI.verifyElementVisible(faceAmountErrorMessage);
				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(faceAmountErrorMessage), "The maximum amount is 10000.");
				}

				WebUI.scrollToElementAtTop(dateOfBirth);
				WebUI.sleep(0.2);
				WebUI.clearAndFillText(dateOfBirth, "01011970");
				WebUI.sleep(0.2);
				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.2);
				WebUI.clickElement(calculate);
				WebUI.scrollToElementAtTop(dateOfBirth);
				WebUI.sleep(0.2);
				WebUI.verifyElementVisible(faceAmountErrorMessage);
				if (iteration == 1) {
					WebUI.verifyContains(getTextElement(faceAmountErrorMessage), "The maximum amount is 20000.");
				}

				WebUI.scrollToElementAtTop(dateOfBirth);
				WebUI.sleep(0.2);
				WebUI.clearAndFillText(dateOfBirth, "01011991");
				WebUI.sleep(0.2);
				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.2);
				WebUI.clickElement(calculate);

				WebUI.scrollToElementAtBottom(faceAmount);
				WebUI.clearText(faceAmount);
				WebUI.sleep(0.2);
				WebUI.setText(faceAmount, "Testing");
				WebUI.moveToElement(calculate);
				WebUI.clickElement(calculate);
				WebUI.verifyElementVisible(faceAmountErrorMessage);
				WebUI.verifyContains(getTextElement(faceAmountErrorMessage), "Please use a number format.");

				WebUI.scrollToElementAtTop(faceAmount);
				WebUI.clearText(faceAmount);
				WebUI.sleep(0.2);
				WebUI.setText(faceAmount, "30001");
				WebUI.sleep(0.5);
				WebUI.verifyElementVisible(faceAmountErrorMessage);
				WebUI.verifyContains(getTextElement(faceAmountErrorMessage).trim(), faceAmountMaxError);

				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.5);
				WebUI.clickElement(calculate);
				WebUI.sleep(1);
				WebUI.clearAndFillText(faceAmount, "999");
				WebUI.verifyElementVisible(faceAmountErrorMessage);
				WebUI.verifyContains(getTextElement(faceAmountErrorMessage).trim(), faceAmountMinError);

				WebUI.clearText(faceAmount);
				WebUI.sleep(0.2);
				int fAmountGenerated = DataGenerateUtils.random4DigitNumberLessThan30000();
				WebUI.clearAndFillText(faceAmount, String.valueOf(fAmountGenerated));
				WebUI.sleep(0.2);
				System.out.println(fAmountGenerated);
				WebUI.verifyContains(getAttributeElement(faceAmount, "value"), String.valueOf(fAmountGenerated));

				WebUI.verifyElementClickable(annually);
				WebUI.clickElement(annually);

				WebUI.verifyElementClickable(semiAnnually);
				WebUI.clickElement(semiAnnually);

				WebUI.verifyElementClickable(quarterly);
				WebUI.clickElement(quarterly);

				WebUI.verifyElementClickable(monthly);
				WebUI.clickElement(monthly);

				WebUI.verifyElementClickable(yes);
				WebUI.clickElement(yes);

				WebUI.verifyElementClickable(no);
				WebUI.clickElement(no);
				WebUI.clickElement(calculate);
				WebUI.sleep(0.5);

				WebUI.moveToElement(nextStep1);
				WebUI.sleep(0.2);
				WebUI.clickElement(nextStep1);
				WebUI.waitForPageLoaded();
				WebUI.sleep(2);

				try {
					DriverManager.getDriver().findElement(step2).isDisplayed();
					WebUI.verifyElementVisible(step2);
					WebUI.sleep(0.5);

				} catch (Exception ex1) {
					try {
						DriverManager.getDriver().findElement(appointmentAcknowledgement).isDisplayed();
						WebUI.verifyElementVisible(appointmentAcknowledgement);
						WebUI.clickElement(appointmentAcknowledgement);
						WebUI.sleep(0.5);
						WebUI.clickElement(agentLicense);
						WebUI.sleep(0.2);
						WebUI.clickElement(TableOfContent_BackButton);
					} catch (Exception ex2) {
						try {
							DriverManager.getDriver().findElement(agentLicense).isDisplayed();
							WebUI.verifyElementVisible(agentLicense);
							WebUI.clickElement(agentLicense);
							WebUI.sleep(0.2);
							WebUI.clickElement(TableOfContent_BackButton);
						} catch (Exception ex3) {
							System.out.println("No popup found: " + ex3.getMessage());
						}
					}
				}

			} catch (Exception ex) {
				System.out.println("-------------------------------------------------");
				System.out.println("No State found in Dropdown" + licensedStatesList.get(i));
				System.out.println("-------------------------------------------------");
				continue;
			}

			iteration++;
			countryCount++;

			if (countryCount == 2)
				break;
		}
		
		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(step2);
		WebUI.sleep(0.5);
		
	}
}



