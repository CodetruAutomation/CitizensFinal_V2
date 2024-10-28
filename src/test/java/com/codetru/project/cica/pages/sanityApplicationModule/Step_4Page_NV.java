package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.utils.DataGenerateUtils;

public class Step_4Page_NV extends CommonPageCICA {


	private By NextStep4 = By.xpath("//h3[.='Beneficiary Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button"); 
	private By BeneficiaryFirstName = By.xpath("//ion-input[@formcontrolname='BeneficiaryFirstName']/input");
	private By Business_name = By.xpath("//ion-input[@formcontrolname='BeneficiaryBusinessName']/input");
	private By BeneficiaryMiddleName = By.xpath("//ion-input[@formcontrolname='BeneficiaryMiddleName']/input"); 
	private By BeneficiaryLastName = By.xpath("//ion-input[@formcontrolname='BeneficiaryLastName']/input");
	private By BeneficiaryAddress_1 = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress1']/input");
	private By BeneficiaryAddress_2 = By.xpath("//ion-input[@formcontrolname='BeneficiaryAddress2']/input"); 
	private By AddBeneficiary = By.xpath("//ion-button[normalize-space()='Add Beneficiary']"); 
	private By BeneficiaryCity = By.xpath("//ion-input[@formcontrolname='BeneficiaryCity']/input"); 
	private By BeneficiaryState = By.xpath("//select[@formcontrolname='BeneficiaryState']"); 
	private By BeneficiaryZipCode = By.xpath("//ion-input[@formcontrolname='BeneficiaryZipCode']/input"); 
	private By BeneficiaryEmailAddress = By.xpath("//ion-input[@formcontrolname='BeneficiaryEmailAddress']/input"); 
	private By BeneficiaryPhone = By.xpath("//ion-input[@formcontrolname= 'BeneficiaryPhone']/input"); 
	private By BeneficiarySSN = By.xpath("//ion-input[@formcontrolname='BeneficiarySSN']/input"); 
	private By BeneficiaryDOB = By.xpath("//input[@formcontrolname='BeneficiaryBirthDate']"); 
	private By BeneficiaryPercent = By.xpath("//ion-input[@formcontrolname='BeneficiaryPercent']/input"); 
	private By BeneficiaryRelation = By.xpath("//select[@formcontrolname='BeneficiaryRelation']"); 
	private By BeneficiaryRelationOther = By.xpath("//ion-input[@formcontrolname='BeneficiaryOtherExplain']/input"); 
	private By Other_RelationOption = By.xpath("//option[.=' Other']");

	
	public void Beneficiary_Information() {
		
		WebUI.waitForPageLoaded();
		WebUI.sleep(2);
		WebUI.waitForElementVisible(BeneficiaryFirstName);
		String randomBeneficiaryFirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(BeneficiaryFirstName,randomBeneficiaryFirstName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryFirstName,"value"),randomBeneficiaryFirstName);
		
//		String randomBeneficiaryMiddlename = DataGenerateUtils.randomMiddleName();
//		WebUI.clearAndFillText(BeneficiaryMiddleName,randomBeneficiaryMiddlename);
//		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(BeneficiaryMiddleName,"value"),randomBeneficiaryMiddlename);
		
		String randomBeneficiaryLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(BeneficiaryLastName,randomBeneficiaryLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryLastName,"value"),randomBeneficiaryLastName);
		
		String randomBeneficiaryAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(BeneficiaryAddress_1,randomBeneficiaryAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryAddress_1,"value"),randomBeneficiaryAddress);
		
//		String randomBeneficiaryAddress_2 = DataGenerateUtils.randomShortAddress();
//		WebUI.clearAndFillText(BeneficiaryAddress_2,randomBeneficiaryAddress_2);
//		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(BeneficiaryAddress_2,"value"),randomBeneficiaryAddress_2);
		
		WebUI.scrollToElementAtBottom(AddBeneficiary);
		WebUI.verifyElementVisible(AddBeneficiary);

		String randomBeneficiaryCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(BeneficiaryCity,randomBeneficiaryCity);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryCity,"value"),randomBeneficiaryCity);
		
		WebUI.waitForElementVisible(BeneficiaryState);
		WebUI.clickElement(BeneficiaryState);
		WebUI.sleep(0.5);
		WebUI.selectOptionByIndex(BeneficiaryState, 1);
		
		String randomBeneficiaryZipcode = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(BeneficiaryZipCode,randomBeneficiaryZipcode);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryZipCode,"value"),randomBeneficiaryZipcode);
		
		String randomBeneficiaryEmail = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(BeneficiaryEmailAddress,randomBeneficiaryEmail);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryEmailAddress,"value"),randomBeneficiaryEmail);
		
		String randomBeneficiaryPhone = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(BeneficiaryPhone,randomBeneficiaryPhone);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryPhone,"value"),randomBeneficiaryPhone);
		
		String randomBeneficiarySSN = DataGenerateUtils.randomSSNNumber();
		WebUI.clearAndFillText(BeneficiarySSN,randomBeneficiarySSN);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiarySSN,"value"),randomBeneficiarySSN);
		
		String randomBeneficiaryDOB = DataGenerateUtils.randomDateOfBirthDDMMYYYY();
		WebUI.clearAndFillText(BeneficiaryDOB,randomBeneficiaryDOB);
		WebUI.sleep(0.5);
		
		
		WebUI.clearAndFillText(BeneficiaryPercent, "100");
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryPercent, "value"), "100");

		WebUI.clickElement(BeneficiaryRelation);
		WebUI.sleep(0.5);
		WebUI.clickElement(Other_RelationOption);
		WebUI.sleep(2);
		WebUI.clickElement(BeneficiaryRelation);
		WebUI.sleep(0.5);
		
		WebUI.clearAndFillText(BeneficiaryRelationOther, "Others");
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BeneficiaryRelationOther, "value"), "Others");

		WebUI.scrollToElementAtBottom(NextStep4);
		WebUI.moveToElement(NextStep4);
		WebUI.sleep(0.5);
		WebUI.clickElement(NextStep4);
		WebUI.waitForPageLoaded();
		
		
		}


}
