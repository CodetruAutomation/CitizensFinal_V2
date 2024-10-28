package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.utils.DataGenerateUtils;


public class Step_4Page extends CommonPageCICA {


	private By step4 = By.xpath("//span[normalize-space()='Step 4: Beneficiary Information']");
	
	private By beneficiaryInformationSection= By.xpath("(//h3[normalize-space()='Beneficiary Information'])[2]"); 
	private By contingentInformationSection= By.xpath("//h3[normalize-space()='Contingent Beneficiary Information']"); 
	private By businessRadioButtonYes= By.xpath("//h3[.='Beneficiary Information']/parent::div/descendant::ion-label[.='Yes']/following-sibling::ion-radio");
	private By businessRadioButtonNo= By.xpath("//h3[.='Beneficiary Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By step4NextButton = By.xpath("//h3[.='Beneficiary Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button"); 
	private By businessName = By.xpath("//ion-input[@formcontrolname='BeneficiaryBusinessName']/input");
	private By businessNameErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryBusinessName']/parent::ion-item/parent::ion-col");
	private By beneficiaryFirstName = By.xpath("//ion-input[@formcontrolname='BeneficiaryFirstName']/input");
	private By beneficicartFirstNameErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryFirstName']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryMiddleName = By.xpath("//ion-input[@formcontrolname='BeneficiaryMiddleName']/input"); 
	private By beneficiaryMiddleNameErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryMiddleName']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryLastName = By.xpath("//ion-input[@formcontrolname='BeneficiaryLastName']/input");
	private By beneficiaryLastNameErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryLastName']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryAddress1 = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress1']/input");
	private By beneficiaryAddress1ErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress1']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryAddress2 = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress2']/input"); 
	private By beneficiaryAddress2ErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress2']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryCity = By.xpath("//ion-input[@formcontrolname='BeneficiaryCity']/input"); 
	private By beneficicaryCityErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryCity']/parent::ion-item/parent::ion-col"); 
	private By benificiaryState = By.xpath("//select[@formcontrolname='BeneficiaryState']"); 
	private By beneficiaryStateErrorMsg = By.xpath("//select[@formcontrolname='BeneficiaryState']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryStateList = By.xpath("//select[@formcontrolname='BeneficiaryState']/option"); 
	private By beneficiaryZipcode = By.xpath("//ion-input[@formcontrolname='BeneficiaryZipCode']/input"); 
	private By beneficicaryZipCodeErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryZipCode']/parent::ion-item/parent::ion-col"); 
	private By benificiaryEmailAddress = By.xpath("//ion-input[@formcontrolname='BeneficiaryEmailAddress']/input"); 
	private By beneficiaryEmailAddressErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryEmailAddress']/parent::ion-item/parent::ion-col"); 
	private By benificiaryPhone = By.xpath("//ion-input[@formcontrolname= 'BeneficiaryPhone']/input"); 
	private By beneficiaryPhoneErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryPhone']/parent::ion-item/parent::ion-col"); 
	private By beneficiarySSN = By.xpath("//ion-input[@formcontrolname='BeneficiarySSN']/input"); 
	private By beneficiarySSNErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiarySSN']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryDOB = By.xpath("//input[@formcontrolname='BeneficiaryBirthDate']"); 
	private By beneficiaryDOBErrorMsg = By.xpath("//input[@formcontrolname='BeneficiaryBirthDate']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryAge = By.xpath("//input[@formcontrolname='BeneficiaryBirthDate']/parent::ion-item/parent::ion-col/following-sibling::ion-col/ion-item/ion-input/input"); 
	private By beneficiaryAgeErrorMsg = By.xpath("//input[@formcontrolname='BeneficiaryBirthDate']/parent::ion-item/parent::ion-col/following-sibling::ion-col"); 
	private By beneficiaryPercent = By.xpath("//ion-input[@formcontrolname='BeneficiaryPercent']/input"); 
	private By beneficiaryPercentErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryPercent']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryMaxPercentError = By.xpath("//p[normalize-space()='Primary Beneficiaries must equal 100']"); 
	private By beneficiaryRelation = By.xpath("//select[@formcontrolname='BeneficiaryRelation']"); 
	private By beneficiaryRelationErrorMsg = By.xpath("//select[@formcontrolname='BeneficiaryRelation']/parent::ion-item/parent::ion-col"); 
	private By beneficiaryRelationList = By.xpath("//select[@formcontrolname='BeneficiaryRelation']/option"); 
	private By beneficiaryRelationOther = By.xpath("//ion-input[@formcontrolname='BeneficiaryOtherExplain']/input"); 
	private By beneficiaryRelationOtherErrorMsg = By.xpath("//ion-input[@formcontrolname='BeneficiaryOtherExplain']/parent::ion-item/parent::ion-col"); 

	private By Other = By.xpath("//option[.=' Other']");
	private By addBeneficiary = By.xpath("//ion-button[normalize-space()='Add Beneficiary']"); 
	private By benefDeleteButton = By.xpath("(//div[@formarrayname='BeneficiaryInformation']//ion-row[8]/ion-col[@class='md hydrated' and @size='24'])[6]/ion-button");
											//ion-icon[@name='trash']/parent::ion-button
	
	private By getBusinessRadioButtonYes(int index) {
	    return By.xpath("(//h3[.='Beneficiary Information']/parent::div/descendant::ion-label[.='Yes']/following-sibling::ion-radio)["+ index +"]");
	}

	private By getBusinessRadioButtonNo(int index) {
	    return By.xpath("(//h3[.='Beneficiary Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio)["+ index +"]");
	}

	private By getBeneficiaryFirstname(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryFirstName']/input)["+ index +"]");
	}

	private By getBusinessName(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryBusinessName']/input)");
	}

	private By getBeneficiaryMiddlename(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryMiddleName']/input)[" + index + "]");
	}

	private By getBeneficiaryLastname(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryLastName']/input)[" + index + "]");
	}

	private By getBeneficiaryAddress1(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryAddress1']/input)[" + index + "]");
	}

	private By getBeneficiaryAddress2(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryAddress2']/input)[" + index + "]");
	}

	private By getBeneficiaryCity(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryCity']/input)[" + index + "]");
	}

	private By getBeneficiaryState(int index) {
	    return By.xpath("(//select[@formcontrolname='BeneficiaryState'])[" + index + "]");
	}

	private By getBeneficiaryStateList(int index) {
	    return By.xpath("(//select[@formcontrolname='BeneficiaryState'])[" + index + "]/option");
	}

	private By getArizonaState(int index) {
	    return By.xpath("(//option[.=' Arizona'])[" + index + "]");
	}

	private By getBeneficiaryZipcode(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryZipCode']/input)[" + index + "]");
	}

	private By getBeneficiaryEmailAddress(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryEmailAddress']/input)[" + index + "]");
	}

	private By getBeneficiaryPhone(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryPhone']/input)[" + index + "]");
	}

	private By getBeneficiarySSN(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiarySSN']/input)[" + index + "]");
	}

	private By getBeneficiaryDOB(int index) {
	    return By.xpath("(//input[@formcontrolname='BeneficiaryBirthDate'])[" + index + "]");
	}

	private By getBeneficiaryAge(int index) {
	    return By.xpath("(//input[@formcontrolname='BeneficiaryBirthDate']/following::ion-col[1]//ion-input/input)[" + index + "]");
	}

	private By getBeneficiaryPercent(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryPercent']/input)[" + index + "]");
	}

	private By getBeneficiaryRelation(int index) {
	    return By.xpath("(//select[@formcontrolname='BeneficiaryRelation'])[" + index + "]");
	}

	private By getBeneficiaryRelationsList(int index) {
	    return By.xpath("(//select[@formcontrolname='BeneficiaryRelation'])[" + index + "]/option");
	}

	private By getBeneficiaryOthersRelationship(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='BeneficiaryOtherExplain']/input)[" + index + "]");
	}
	
	private By addContBeneficiary = By.xpath("//ion-button[normalize-space()='Add Contingent Beneficiary']");
	private By contBeneficiaryYesButton = By.xpath("//h3[.='Contingent Beneficiary Information']/parent::div/descendant::ion-label[.='Yes']/following-sibling::ion-radio");
	private By contBeneficiaryNoButton = By.xpath("//h3[.='Contingent Beneficiary Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By contBeneficiaryBusinessName = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryBusinessName']/input");
	private By contBeneficiaryBusinessNameErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryBusinessName']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryYesButton2 = By.xpath("(//ion-label[normalize-space()='Yes'])[6]/following::ion-radio[1]");
	private By contBeneficiaryNoButton2 = By.xpath("(//ion-label[normalize-space()='No'])[6]/following::ion-radio[1]");
	
	private By contBeneficiaryFirstName = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryFirstName']/input");
	private By contBeneficiaryFirstNameErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryFirstName']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryMiddleNameErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryMiddleName']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryLastNameErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryLastName']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryAddress1ErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryAddress1']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryAddress2ErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryAddress2']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryCityErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryCity']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryStateErrorMsg = By.xpath("//select[@formcontrolname='ContingentBeneficiaryState']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryZipCodeErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryZipCode']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryEmailErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryEmailAddress']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryPhoneErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryPhone']/parent::ion-item/parent::ion-col");
	private By contBeneficiarySSNErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiarySSN']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryDOBErrorMsg = By.xpath("//input[@formcontrolname='ContingentBeneficiaryBirthDate']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryAgeErrorMsg = By.xpath("//input[@formcontrolname='ContingentBeneficiaryBirthDate']/parent::ion-item/parent::ion-col/following-sibling::ion-col");
	private By contBeneficiaryPercentErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryPercent']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryMaxPercentErrorMsg = By.xpath("//p[normalize-space()='Contingent Beneficiaries must equal 100']"); 
	private By contBeneficiaryRelationErrorMsg = By.xpath("//select[@formcontrolname='ContingentBeneficiaryRelation']/parent::ion-item/parent::ion-col");
	private By contBeneficiaryDeleteButton = By.xpath("(//div[@formarrayname='ContingentBeneficiaryInformation']//ion-row[8]/ion-col[@class='md hydrated' and @size='24'])[3]/ion-button");
	private By contBeneficiaryMiddleName = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryMiddleName']/input");
	private By contBeneficiaryLastName = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryLastName']/input");
	private By contBeneficiaryAddress1 = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryAddress1']/input");
	private By contBeneficiaryAddress2 = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryAddress2']/input");
	private By contBeneficiaryCity = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryCity']/input");
	private By contBeneficiaryState = By.xpath("//select[@formcontrolname='ContingentBeneficiaryState']");
	private By contBeneficiaryStateList = By.xpath("(//select[@formcontrolname='ContingentBeneficiaryState'])[1]/option");
	private By contBeneficiaryZipcode = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryZipCode']/input");
	private By contBeneficiaryEmail = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryEmailAddress']/input");
	private By contBeneficiaryPhone = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryPhone']/input");
	private By contBeneficiarySSN = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiarySSN']/input");
	private By contBeneficiaryDOB = By.xpath("//input[@formcontrolname='ContingentBeneficiaryBirthDate']");
	private By contBeneficiaryAge = By.xpath("//input[@formcontrolname='ContingentBeneficiaryBirthDate']/parent::ion-item/parent::ion-col/following-sibling::ion-col/ion-item/ion-input/input"); 
	private By contBeneficiaryPercent = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryPercent']/input");
	private By contBeneficiaryMaxPercentError = By.xpath("//p[normalize-space()='Contingent Beneficiaries must equal 100']"); 
	private By contBeneficiaryRelation = By.xpath("//select[@formcontrolname='ContingentBeneficiaryRelation']");
	private By contBeneficiaryRelationList = By.xpath("//select[@formcontrolname='ContingentBeneficiaryRelation']/option");
	private By contBenificiaryOtherRelation = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryOtherExplain']/input"); 
	private By contBeneficiaryRelationOtherErrorMsg = By.xpath("//ion-input[@formcontrolname='ContingentBeneficiaryOtherExplain']/parent::ion-item/parent::ion-col"); 
	
	private By getContBeneficiaryFirstName(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryFirstName']/input)[" + index + "]");
	}

	private By getContBeneficiaryMiddleName(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryMiddleName']/input)[" + index + "]");
	}

	private By getContBeneficiaryLastName(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryLastName']/input)[" + index + "]");
	}

	private By getContBeneficiaryAddress1(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryAddress1']/input)[" + index + "]");
	}

	private By getContBeneficiaryAddress2(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryAddress2']/input)[" + index + "]");
	}

	private By getContBeneficiaryCity(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryCity']/input)[" + index + "]");
	}

	private By getContBeneficiaryState(int index) {
	    return By.xpath("(//select[@formcontrolname='ContingentBeneficiaryState'])[" + index + "]");
	}

	private By getContBeneficiaryZipcode(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryZipCode']/input)[" + index + "]");
	}

	private By getContBeneficiaryEmail(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryEmailAddress']/input)[" + index + "]");
	}

	private By getContBeneficiaryPhone(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryPhone']/input)[" + index + "]");
	}

	private By getContBeneficiarySSN(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiarySSN']/input)[" + index + "]");
	}

	private By getContBeneficiaryDOB(int index) {
	    return By.xpath("(//input[@formcontrolname='ContingentBeneficiaryBirthDate'])[" + index + "]");
	}

	private By getContBeneficiaryPercent(int index) {
	    return By.xpath("(//ion-input[@formcontrolname='ContingentBeneficiaryPercent']/input)[" + index + "]");
	}

	private By getContBeneficiaryRelation(int index) {
	    return By.xpath("(//select[@formcontrolname='ContingentBeneficiaryRelation'])[" + index + "]");
	}
	

	public void Beneficiary_Information() {

		String mandatoryError = "Please enter a value.";
		String nameMaxCharacters = "sdfsadfgdfsfghfghxfghjdsfghdfghdfghjdfsghdsfghretyu";
		String addressMax = "913 Alena Lakes Suite 843 35311 Kub Extensions Apt.Lakes Suite 843 ";
		String nameMaxCharError = "The maximum number of characters is 33.";
		String maxCharError = "The maximum number of characters is 50";
		String zipMinCharError = "The minimum number of characters is 5.";
		String zipMaxCharError = "The maximum number of characters is 5.";
		String phoneMinCharError = "The minimum number of characters is 10.";
		String phoneMaxCharError = "The maximum number of characters is 10.";
		String ssnMinCharError = "The minimum number of characters is 9.";
		String ssnMaxCharError = "The maximum number of characters is 9.";
		String emailFormatError = "Email is not in the correct format";
		String benefMaxPercentageError = "Primary Beneficiaries must equal 100";
		String businessNameMaxChars = "Infinite Horizons Innovative Solutions Pioneering Excellence in Sustainable Growth and Technological Advancement";
		String businessName100Chars = "Infinite Horizons Innovative Solutions Pioneering Excellence in Sustainable Growth and Technological";
		String businessNameMaxCharError = "The maximum number of characters is 100.";
		String BusinessName = "Codetru Pvt Ltd";
		String otherRelationMaxCharError = "The maximum number of characters is 90.";
		String contBenefMaxPercentageError = "Contingent Beneficiaries must equal 100";

		WebUI.waitForPageLoaded();
		WebUI.sleep(1);

		// TC_280 281 282
		WebUI.verifyElementVisible(beneficiaryInformationSection);
		WebUI.clickElement(businessRadioButtonYes);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(businessName);
		WebUI.clickElement(businessRadioButtonNo);
		WebUI.sleep(0.2);
		WebUI.verifyElementPresent(beneficiaryFirstName);
		WebUI.verifyElementPresent(beneficiaryLastName);
		WebUI.verifyElementPresent(beneficiaryMiddleName);

		// TC_283 284 285 286
		WebUI.clickElement(businessRadioButtonYes);
		WebUI.scrollToElementAtBottom(step4NextButton);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(contingentInformationSection);
		WebUI.verifyElementClickable(step4NextButton);
		WebUI.clickElement(step4NextButton);
		WebUI.scrollToElementAtTop(beneficiaryInformationSection);

		WebUI.verifyElementVisible(businessNameErrorMsg);
		WebUI.verifyContains(getTextElement(businessNameErrorMsg), mandatoryError);

		// Max Business name
		WebUI.clearText(businessName);
		WebUI.setText(businessName, businessNameMaxChars);
		WebUI.verifyElementVisible(businessNameErrorMsg);
		WebUI.verifyContains(getTextElement(businessNameErrorMsg), businessNameMaxCharError);

		WebUI.clearText(businessName);
		WebUI.setText(businessName, businessName100Chars);
		WebUI.sleep(0.2);
		WebUI.clearText(businessName);
		WebUI.setText(businessName, BusinessName);
		WebUI.verifyContains(getAttributeElement(businessName, "value"), BusinessName);

		WebUI.clickElement(businessRadioButtonNo);
		WebUI.verifyElementPresent(beneficiaryFirstName);
		WebUI.verifyContains(getTextElement(beneficicartFirstNameErrorMsg), mandatoryError);

		WebUI.clearText(beneficiaryFirstName);
		WebUI.setText(beneficiaryFirstName, nameMaxCharacters);
		WebUI.verifyElementVisible(beneficicartFirstNameErrorMsg);
		WebUI.verifyContains(getTextElement(beneficicartFirstNameErrorMsg), nameMaxCharError);

		String randomBenificiaryfirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(beneficiaryFirstName, randomBenificiaryfirstName);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryFirstName, "value"), randomBenificiaryfirstName);

		WebUI.clearText(beneficiaryMiddleName);
		WebUI.setText(beneficiaryMiddleName, nameMaxCharacters);
		WebUI.verifyElementVisible(beneficiaryMiddleNameErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryMiddleNameErrorMsg), nameMaxCharError);

		String randomBenificiaryMiddleName = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(beneficiaryMiddleName, randomBenificiaryMiddleName);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryMiddleName, "value"), randomBenificiaryMiddleName);

		WebUI.verifyContains(getTextElement(beneficiaryLastNameErrorMsg), mandatoryError);

		WebUI.clearText(beneficiaryLastName);
		WebUI.setText(beneficiaryLastName, nameMaxCharacters);
		WebUI.verifyElementVisible(beneficiaryLastNameErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryLastNameErrorMsg), nameMaxCharError);

		String randomBenificiaryLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(beneficiaryLastName, randomBenificiaryLastName);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryLastName, "value"), randomBenificiaryLastName);

		WebUI.verifyContains(getTextElement(beneficiaryAddress1ErrorMsg), mandatoryError);

		WebUI.clearText(beneficiaryAddress1);
		WebUI.setText(beneficiaryAddress1, addressMax);
		WebUI.verifyElementVisible(beneficiaryAddress1ErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryAddress1ErrorMsg), nameMaxCharError);

		String randomBenificiaryAddress1 = DataGenerateUtils.randomStreetName();
		WebUI.clearAndFillText(beneficiaryAddress1, randomBenificiaryAddress1);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryAddress1, "value"), randomBenificiaryAddress1);

		WebUI.clearText(beneficiaryAddress2);
		WebUI.setText(beneficiaryAddress2, addressMax);
		WebUI.verifyElementVisible(beneficiaryAddress2ErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryAddress2ErrorMsg), nameMaxCharError);

		String randomBenificiaryAddress2 = DataGenerateUtils.randomStreetName();
		WebUI.clearAndFillText(beneficiaryAddress2, randomBenificiaryAddress2);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryAddress2, "value"), randomBenificiaryAddress2);

		WebUI.scrollToElementAtBottom(addBeneficiary);
		WebUI.verifyElementVisible(addBeneficiary);

		WebUI.verifyContains(getTextElement(beneficicaryCityErrorMsg), mandatoryError);

		WebUI.clearText(beneficiaryCity);
		WebUI.setText(beneficiaryCity, nameMaxCharacters);
		WebUI.verifyElementVisible(beneficicaryCityErrorMsg);
		WebUI.verifyContains(getTextElement(beneficicaryCityErrorMsg), nameMaxCharError);

		String randomBenificiaryCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(beneficiaryCity, randomBenificiaryCity);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryCity, "value"), randomBenificiaryCity);

		WebUI.verifyContains(getTextElement(beneficiaryStateErrorMsg), mandatoryError);

		WebUI.waitForElementVisible(benificiaryState);

		List<String> states = WebUI.getElementTextsInList(beneficiaryStateList);
		for (int i = 1; i <= 10; i += 2) {
			WebUI.selectOptionByIndex(benificiaryState, i);
			WebUI.sleep(0.2);
		}
		WebUI.clickElement(benificiaryState);
		WebUI.sleep(0.2);
		WebUI.setText(benificiaryState, "l", Keys.ENTER);
		WebUI.sleep(0.2);

		WebUI.verifyContains(getTextElement(beneficicaryZipCodeErrorMsg), mandatoryError);

		WebUI.clearText(beneficiaryZipcode);
		WebUI.setText(beneficiaryZipcode, "345");
		WebUI.verifyElementVisible(beneficicaryZipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(beneficicaryZipCodeErrorMsg), zipMinCharError);

		WebUI.clearText(beneficiaryZipcode);
		WebUI.setText(beneficiaryZipcode, "3456789");
		WebUI.verifyElementVisible(beneficicaryZipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(beneficicaryZipCodeErrorMsg), zipMaxCharError);

		String randomBenificiaryZipcode = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(beneficiaryZipcode, randomBenificiaryZipcode);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryZipcode, "value"), randomBenificiaryZipcode);

		WebUI.clearText(benificiaryEmailAddress);
		WebUI.setText(benificiaryEmailAddress, "asdsaf");
		WebUI.verifyElementVisible(beneficiaryEmailAddressErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryEmailAddressErrorMsg), emailFormatError);

		WebUI.clearText(benificiaryEmailAddress);
		WebUI.setText(benificiaryEmailAddress, nameMaxCharacters);
		WebUI.verifyElementVisible(beneficiaryEmailAddressErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryEmailAddressErrorMsg), maxCharError);

		String randomBenificiaryEmail = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(benificiaryEmailAddress, randomBenificiaryEmail);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(benificiaryEmailAddress, "value"), randomBenificiaryEmail);

		WebUI.setText(benificiaryPhone, "123");
		WebUI.verifyElementVisible(beneficiaryPhoneErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryPhoneErrorMsg), phoneMinCharError);

		WebUI.clearText(benificiaryPhone);
		WebUI.setText(benificiaryPhone, "12487451245871");
		WebUI.verifyElementVisible(beneficiaryPhoneErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryPhoneErrorMsg), phoneMaxCharError);

		String randomBenificiaryPhone = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(benificiaryPhone, randomBenificiaryPhone);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(benificiaryPhone, "value"), randomBenificiaryPhone);

		WebUI.verifyContains(getTextElement(beneficiarySSNErrorMsg), mandatoryError);
		WebUI.clearText(beneficiarySSN);
		WebUI.setText(beneficiarySSN, "12345");
		WebUI.verifyElementVisible(beneficiarySSNErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiarySSNErrorMsg), ssnMinCharError);

		WebUI.clearText(beneficiarySSN);
		WebUI.setText(beneficiarySSN, "123455874512");
		WebUI.verifyElementVisible(beneficiarySSNErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiarySSNErrorMsg), ssnMaxCharError);

		String randomBenificiarySSN = DataGenerateUtils.randomSSNNumber();
		WebUI.clearAndFillText(beneficiarySSN, randomBenificiarySSN);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiarySSN, "value"), randomBenificiarySSN);

		WebUI.verifyContains(getTextElement(beneficiaryDOBErrorMsg), mandatoryError);
		WebUI.verifyContains(getTextElement(beneficiaryAgeErrorMsg), mandatoryError);
		WebUI.verifyEquals(getAttributeElement(beneficiaryAge, "value"), "0");

		String randomBenificiaryDOB = DataGenerateUtils.randomDateOfBirthDDMMYYYY();
		WebUI.clearAndFillText(beneficiaryDOB, randomBenificiaryDOB);
		WebUI.sleep(0.2);

		System.out.println("Generated DOB: " + randomBenificiaryDOB);
		System.out.println("Attribute DOB: " + getAttributeElement(beneficiaryDOB, "value"));

		WebUI.verifyContains(getTextElement(beneficiaryPercentErrorMsg), mandatoryError);
		WebUI.clearText(beneficiaryPercent);
		WebUI.setText(beneficiaryPercent, "123455874512");
		WebUI.verifyElementVisible(beneficiaryMaxPercentError);
		WebUI.verifyContains(getTextElement(beneficiaryMaxPercentError), benefMaxPercentageError);

		WebUI.clearAndFillText(beneficiaryPercent, "25");
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(beneficiaryPercent, "value"), "25");

		WebUI.verifyContains(getTextElement(beneficiaryRelationErrorMsg), mandatoryError);
		List<String> relationships = WebUI.getElementTextsInList(beneficiaryRelationList);
		for (int i = 1; i < relationships.size(); i++) {
			WebUI.selectOptionByIndex(beneficiaryRelation, i);
			WebUI.sleep(0.2);
		}
		WebUI.sleep(0.2);
		WebUI.clickElement(beneficiaryRelation);
		WebUI.setText(beneficiaryRelation, "o", Keys.ENTER);
		WebUI.sleep(1);

		WebUI.verifyElementVisible(beneficiaryRelationOtherErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryRelationOtherErrorMsg), "Please Explain Other Relationship");

		// Please Explain Other Relationship Max Error
		WebUI.clearText(beneficiaryRelationOther);
		WebUI.setText(beneficiaryRelationOther, businessName100Chars);
		WebUI.verifyElementVisible(beneficiaryRelationOtherErrorMsg);
		WebUI.verifyContains(getTextElement(beneficiaryRelationOtherErrorMsg), otherRelationMaxCharError);

		WebUI.clearAndFillText(beneficiaryRelationOther, "Others");
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(beneficiaryRelationOther, "value"), "Others");

//		==============================================ADD BENEFICIARY INFORMATION============================================================================================

		WebUI.verifyElementVisible(addBeneficiary);
		WebUI.clickElement(addBeneficiary);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(getBusinessRadioButtonYes(2));
		WebUI.logInfoMessage("Element Visible " + getBusinessRadioButtonYes(2));
		WebUI.verifyElementVisible(getBusinessRadioButtonNo(2));
		WebUI.logInfoMessage("Element Visible " + getBusinessRadioButtonNo(2));
		WebUI.scrollToElementAtBottom(benefDeleteButton);
		WebUI.sleep(1);
		WebUI.clickElement(benefDeleteButton);
		WebUI.sleep(1);
		WebUI.verifyElementNotVisibleSoftAssert(getBusinessRadioButtonYes(2));
		WebUI.verifyElementNotVisibleSoftAssert(getBusinessRadioButtonNo(2));
		WebUI.scrollToElementAtTop(addBeneficiary);
		WebUI.clickElement(addBeneficiary);

		try {

			for (int index = 2; index <= 4; index++) {

				WebUI.clearAndFillText(getBeneficiaryFirstname(index), DataGenerateUtils.randomFirstName());
				WebUI.clearAndFillText(getBeneficiaryMiddlename(index), DataGenerateUtils.randomMiddleName());
				WebUI.clearAndFillText(getBeneficiaryLastname(index), DataGenerateUtils.randomLastName());
				WebUI.clearAndFillText(getBeneficiaryAddress1(index), DataGenerateUtils.randomAddress());
				WebUI.clearAndFillText(getBeneficiaryCity(index), DataGenerateUtils.randomCity());
				WebUI.clickElement(getBeneficiaryState(index));
				WebUI.sleep(0.2);
				WebUI.setText(getBeneficiaryState(index), "g", Keys.ENTER);
				WebUI.sleep(0.2);
				WebUI.clearAndFillText(getBeneficiaryZipcode(index), DataGenerateUtils.randomZipCode());
				WebUI.clearAndFillText(getBeneficiaryEmailAddress(index), DataGenerateUtils.randomEmail());
				WebUI.clearAndFillText(getBeneficiaryPhone(index), DataGenerateUtils.randomPhoneNumber());
				WebUI.clearAndFillText(getBeneficiarySSN(index), DataGenerateUtils.randomSSNNumber());
				WebUI.clearAndFillText(getBeneficiaryDOB(index), DataGenerateUtils.randomDateOfBirthDDMMYYYY());
				WebUI.clearAndFillText(getBeneficiaryPercent(index), "25");
				WebUI.sleep(0.2);
				WebUI.clickElement(getBeneficiaryRelation(index));
				WebUI.setText(getBeneficiaryRelation(index), "p", Keys.ENTER);
				WebUI.sleep(1);
				WebUI.clickElement(addBeneficiary);

				if (index + 1 >= 5) {
					WebElement benefFirstName5th = DriverManager.getDriver()
							.findElement(By.xpath("(//ion-input[@formcontrolname='BeneficiaryFirstName']/input)[5]"));
					benefFirstName5th.isDisplayed();
				}
			}

		} catch (Exception ex) {
			WebUI.logInfoMessage("Added maximum beneficiary");
			WebUI.logInfoMessage(ex.getMessage());
		}

//		==============================================ADD CONTINGENT BENEFICIARY INFORMATION============================================================================================

		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(step4NextButton);
		WebUI.verifyElementVisible(addContBeneficiary);
		WebUI.clickElement(addContBeneficiary);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(contBeneficiaryYesButton);
		WebUI.logInfoMessage("Element Visible " + contBeneficiaryYesButton);
		WebUI.verifyElementVisible(contBeneficiaryNoButton);
		WebUI.logInfoMessage("Element Visible " + contBeneficiaryNoButton);
		WebUI.scrollToElementAtBottom(contBeneficiaryDeleteButton);
		WebUI.sleep(1);
		WebUI.clickElement(contBeneficiaryDeleteButton);
		WebUI.sleep(1);
		WebUI.verifyElementNotVisibleSoftAssert(contBeneficiaryYesButton);
		WebUI.verifyElementNotVisibleSoftAssert(contBeneficiaryNoButton);
		WebUI.scrollToElementAtTop(addContBeneficiary);
		WebUI.sleep(0.2);
		WebUI.clickElement(addContBeneficiary);
		WebUI.sleep(0.5);

		WebUI.scrollToElementAtBottom(step4NextButton);
		WebUI.moveToElement(step4NextButton);
		WebUI.clickElement(step4NextButton);
		WebUI.scrollToElementAtTop(contBeneficiaryNoButton);
		WebUI.sleep(0.2);

		WebUI.clearText(contBeneficiaryFirstName);
		WebUI.setText(contBeneficiaryFirstName, nameMaxCharacters);
		WebUI.verifyElementVisible(contBeneficiaryFirstNameErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryFirstNameErrorMsg), nameMaxCharError);

		String randomBeneficiaryFirstNameCont = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(contBeneficiaryFirstName, randomBeneficiaryFirstNameCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryFirstName, "value"), randomBeneficiaryFirstNameCont);

		WebUI.clearText(contBeneficiaryMiddleName);
		WebUI.setText(contBeneficiaryMiddleName, nameMaxCharacters);
		WebUI.verifyElementVisible(contBeneficiaryMiddleNameErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryMiddleNameErrorMsg), nameMaxCharError);

		String randomBeneficiaryMiddleNameCont = DataGenerateUtils.randomMiddleName();
		WebUI.clearAndFillText(contBeneficiaryMiddleName, randomBeneficiaryMiddleNameCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryMiddleName, "value"), randomBeneficiaryMiddleNameCont);

		WebUI.verifyContains(getTextElement(contBeneficiaryLastNameErrorMsg), mandatoryError);
		WebUI.clearText(contBeneficiaryLastName);
		WebUI.setText(contBeneficiaryLastName, nameMaxCharacters);
		WebUI.verifyElementVisible(contBeneficiaryLastNameErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryLastNameErrorMsg), nameMaxCharError);

		String randomBeneficiaryLastNameCont = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(contBeneficiaryLastName, randomBeneficiaryLastNameCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryLastName, "value"), randomBeneficiaryLastNameCont);

		WebUI.verifyContains(getTextElement(contBeneficiaryAddress1ErrorMsg), mandatoryError);
		WebUI.clearText(contBeneficiaryAddress1);
		WebUI.setText(contBeneficiaryAddress1, addressMax);
		WebUI.verifyElementVisible(contBeneficiaryAddress1ErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryAddress1ErrorMsg), nameMaxCharError);

		String randomBeneficiaryAddressCont = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(contBeneficiaryAddress1, randomBeneficiaryAddressCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryAddress1, "value"), randomBeneficiaryAddressCont);

		WebUI.clearText(contBeneficiaryAddress2);
		WebUI.setText(contBeneficiaryAddress2, addressMax);
		WebUI.verifyElementVisible(contBeneficiaryAddress2ErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryAddress2ErrorMsg), nameMaxCharError);

		String randomBeneficiaryAddress2Cont = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(contBeneficiaryAddress2, randomBeneficiaryAddress2Cont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryAddress2, "value"), randomBeneficiaryAddress2Cont);

		WebUI.scrollToElementAtBottom(addContBeneficiary);
		WebUI.verifyContains(getTextElement(contBeneficiaryCityErrorMsg), mandatoryError);
		WebUI.clearText(contBeneficiaryCity);
		WebUI.setText(contBeneficiaryCity, nameMaxCharacters);
		WebUI.verifyElementVisible(contBeneficiaryCityErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryCityErrorMsg), nameMaxCharError);

		String randomBeneficiaryCityCont = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(contBeneficiaryCity, randomBeneficiaryCityCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryCity, "value"), randomBeneficiaryCityCont);

		WebUI.scrollToElementAtBottom(addContBeneficiary);
		WebUI.verifyContains(getTextElement(contBeneficiaryStateErrorMsg), mandatoryError);
		WebUI.waitForElementVisible(contBeneficiaryState);

		List<String> cont_States = WebUI.getElementTextsInList(contBeneficiaryStateList);
		for (int i = 1; i <= 10; i += 2) {
			WebUI.selectOptionByIndex(contBeneficiaryState, i);
			WebUI.sleep(0.2);
		}
		WebUI.clickElement(contBeneficiaryState);
		WebUI.sleep(0.2);
		WebUI.setText(contBeneficiaryState, "l", Keys.ENTER);
		WebUI.sleep(0.2);

		WebUI.verifyContains(getTextElement(contBeneficiaryZipCodeErrorMsg), mandatoryError);
		WebUI.clearText(contBeneficiaryZipcode);
		WebUI.setText(contBeneficiaryZipcode, "345");
		WebUI.verifyElementVisible(contBeneficiaryZipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryZipCodeErrorMsg), zipMinCharError);

		WebUI.clearText(contBeneficiaryZipcode);
		WebUI.setText(contBeneficiaryZipcode, "3456789");
		WebUI.verifyElementVisible(contBeneficiaryZipCodeErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryZipCodeErrorMsg), zipMaxCharError);

		String randomBeneficiaryZipcodeCont = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(contBeneficiaryZipcode, randomBeneficiaryZipcodeCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryZipcode, "value"), randomBeneficiaryZipcodeCont);

		WebUI.clearText(contBeneficiaryEmail);
		WebUI.setText(contBeneficiaryEmail, "asdsaf");
		WebUI.verifyElementVisible(contBeneficiaryEmailErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryEmailErrorMsg), emailFormatError);

		WebUI.clearText(contBeneficiaryEmail);
		WebUI.setText(contBeneficiaryEmail, nameMaxCharacters);
		WebUI.verifyElementVisible(contBeneficiaryEmailErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryEmailErrorMsg), maxCharError);

		String randomBeneficiaryEmailCont = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(contBeneficiaryEmail, randomBeneficiaryEmailCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryEmail, "value"), randomBeneficiaryEmailCont);

		WebUI.setText(contBeneficiaryPhone, "123");
		WebUI.verifyElementVisible(contBeneficiaryPhoneErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryPhoneErrorMsg), phoneMinCharError);

		WebUI.clearText(contBeneficiaryPhone);
		WebUI.setText(contBeneficiaryPhone, "12487451245871");
		WebUI.verifyElementVisible(contBeneficiaryPhoneErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryPhoneErrorMsg), phoneMaxCharError);

		String randomBeneficiaryPhoneCont = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(contBeneficiaryPhone, randomBeneficiaryPhoneCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryPhone, "value"), randomBeneficiaryPhoneCont);

		WebUI.verifyContains(getTextElement(contBeneficiarySSNErrorMsg), mandatoryError);
		WebUI.clearText(contBeneficiarySSN);
		WebUI.setText(contBeneficiarySSN, "12345");
		WebUI.verifyElementVisible(contBeneficiarySSNErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiarySSNErrorMsg), ssnMinCharError);

		WebUI.clearText(contBeneficiarySSN);
		WebUI.setText(contBeneficiarySSN, "123455874512");
		WebUI.verifyElementVisible(contBeneficiarySSNErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiarySSNErrorMsg), ssnMaxCharError);

		String randomBeneficiarySSNCont = DataGenerateUtils.randomSSNNumber();
		WebUI.clearAndFillText(contBeneficiarySSN, randomBeneficiarySSNCont);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiarySSN, "value"), randomBeneficiarySSNCont);

		WebUI.scrollToElementAtBottom(addContBeneficiary);
		WebUI.sleep(0.4);
		WebUI.verifyContains(getTextElement(contBeneficiaryDOBErrorMsg), mandatoryError);
		WebUI.verifyContains(getTextElement(contBeneficiaryAgeErrorMsg), mandatoryError);
		WebUI.verifyEquals(getAttributeElement(contBeneficiaryAge, "value"), "0");

		String randomBeneficiaryDOBCont = DataGenerateUtils.randomDateOfBirthDDMMYYYY();
		WebUI.clearAndFillText(contBeneficiaryDOB, randomBeneficiaryDOBCont);
		WebUI.sleep(0.2);

		System.out.println("Generated DOB: " + randomBeneficiaryDOBCont);
		System.out.println("Attribute DOB: " + getAttributeElement(contBeneficiaryDOB, "value"));

		WebUI.verifyContains(getTextElement(contBeneficiaryPercentErrorMsg), mandatoryError);
		WebUI.scrollToElementAtBottom(step4NextButton);
		WebUI.clearText(contBeneficiaryPercent);
		WebUI.setText(contBeneficiaryPercent, "123455874512");
		WebUI.verifyElementVisible(contBeneficiaryMaxPercentError);
		WebUI.verifyContains(getTextElement(contBeneficiaryMaxPercentErrorMsg), contBenefMaxPercentageError);

		WebUI.clearAndFillText(contBeneficiaryPercent, "50");
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(contBeneficiaryPercent, "value"), "50");

		WebUI.verifyContains(getTextElement(contBeneficiaryRelationErrorMsg), mandatoryError);
		List<String> relationshipsCont = WebUI.getElementTextsInList(contBeneficiaryRelationList);
		for (int i = 1; i < relationshipsCont.size(); i++) {
			WebUI.selectOptionByIndex(contBeneficiaryRelation, i);
			WebUI.sleep(0.2);
		}

		WebUI.sleep(0.2);
		WebUI.clickElement(contBeneficiaryRelation);
		WebUI.setText(contBeneficiaryRelation, "o", Keys.ENTER);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(contBeneficiaryRelationOtherErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryRelationOtherErrorMsg), "Please Explain Other Relationship");

		// Please Explain Other Relationship Max Error
		WebUI.clearText(contBenificiaryOtherRelation);
		WebUI.setText(contBenificiaryOtherRelation, businessName100Chars);
		WebUI.verifyElementVisible(contBeneficiaryRelationOtherErrorMsg);
		WebUI.verifyContains(getTextElement(contBeneficiaryRelationOtherErrorMsg), otherRelationMaxCharError);

		WebUI.clearAndFillText(contBenificiaryOtherRelation, "Others");
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(contBenificiaryOtherRelation, "value"), "Others");

//******************************************************************************************************************************************************	

		// 2nd Contingent Beneficiary Details
		WebUI.clickElement(addContBeneficiary);
		WebUI.sleep(0.5);
		WebUI.clearAndFillText(getContBeneficiaryFirstName(2), DataGenerateUtils.randomFirstName());
		WebUI.clearAndFillText(getContBeneficiaryMiddleName(2), DataGenerateUtils.randomMiddleName());
		WebUI.clearAndFillText(getContBeneficiaryLastName(2), DataGenerateUtils.randomLastName());
		WebUI.clearAndFillText(getContBeneficiaryAddress1(2), DataGenerateUtils.randomAddress());
		WebUI.clearAndFillText(getContBeneficiaryAddress2(2), DataGenerateUtils.randomAddress());
		WebUI.clearAndFillText(getContBeneficiaryCity(2), DataGenerateUtils.randomCity());
		WebUI.clickElement(getContBeneficiaryState(2));
		WebUI.setText(getContBeneficiaryState(2), "a", Keys.ENTER);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(getContBeneficiaryZipcode(2), DataGenerateUtils.randomZipCode());
		WebUI.clearAndFillText(getContBeneficiaryEmail(2), DataGenerateUtils.randomEmail());
		WebUI.clearAndFillText(getContBeneficiaryPhone(2), DataGenerateUtils.randomPhoneNumber());
		WebUI.clearAndFillText(getContBeneficiarySSN(2), DataGenerateUtils.randomSSNNumber());
		WebUI.clearAndFillText(getContBeneficiaryDOB(2), DataGenerateUtils.randomDateOfBirthDDMMYYYY());
		WebUI.clearAndFillText(getContBeneficiaryPercent(2), "100");
		WebUI.sleep(0.2);
		WebUI.verifyContains(getTextElement(contBeneficiaryMaxPercentErrorMsg), contBenefMaxPercentageError);
		WebUI.clearAndFillText(getContBeneficiaryPercent(2), "50");
		WebUI.clickElement(getContBeneficiaryRelation(2));
		WebUI.setText(getContBeneficiaryRelation(2), "s", Keys.ENTER);

//		==========================================================================================================================================

		WebUI.scrollToElementAtBottom(step4NextButton);
		WebUI.sleep(0.2);
		WebUI.moveToElement(step4NextButton);
		WebUI.sleep(1);
		WebUI.clickElement(step4NextButton);
		WebUI.waitForPageLoaded();

	}

}
