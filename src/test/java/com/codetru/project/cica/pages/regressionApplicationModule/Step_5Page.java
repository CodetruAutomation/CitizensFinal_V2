package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;

public class Step_5Page extends CommonPageCICA {

	private By NextStep5 = By.xpath("//h3[.='Existing Insurance']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By error_Message_ExistingInsurQuest_1 = By.xpath("(//h3[text()='Existing Insurance']/following-sibling::ion-row[@class='md hydrated'])[1]");
	private By error_Message_ExistingInsurQuest_2 = By.xpath("(//h3[text()='Existing Insurance']/following-sibling::ion-row[@class='md hydrated'])[2]");
	private By ExitingInsurance_Question_1 = By.xpath("(//ion-label[text()='No ']/following-sibling::ion-radio[@slot='start'])[1]");
	private By ExistingInsurance_RadioB_Yes1 = By.xpath("(//h3[.='Existing Insurance']/parent::div/descendant::ion-label[text()='Yes ']/following-sibling::ion-radio)[1]");
	private By ExistingInsurance_RadioB_Yes2 = By.xpath("(//h3[.='Existing Insurance']/parent::div/descendant::ion-label[text()='Yes ']/following-sibling::ion-radio)[2]");
	private By ExistingInsurance_RadioB_No1 = By.xpath("(//h3[.='Existing Insurance']/parent::div/descendant::ion-label[text()='No ']/following-sibling::ion-radio)[1]");
	private By ExistingInsurance_RadioB_No2 = By.xpath("(//h3[.='Existing Insurance']/parent::div/descendant::ion-label[text()='No ']/following-sibling::ion-radio)[2]");
	private By Questionier__RadioB_Yes1 = By.xpath("(//h3[.='Replacement Form']/parent::div/descendant::ion-label[text()='Yes ']/following-sibling::ion-radio)[1]");
	private By Questionier__RadioB_Yes2 = By.xpath("(//h3[.='Replacement Form']/parent::div/descendant::ion-label[text()='Yes ']/following-sibling::ion-radio)[2]");
	private By Questionier__RadioB_No1 = By.xpath("(//h3[.='Replacement Form']/parent::div/descendant::ion-label[text()='No ']/following-sibling::ion-radio)[1]");
	private By Questionier__RadioB_No2 = By.xpath("(//h3[.='Replacement Form']/parent::div/descendant::ion-label[text()='No ']/following-sibling::ion-radio)[2]");
	private By ProposedInsurer_Sign = By.xpath("(//ion-button[@class='buttonIcon md button button-clear ion-activatable ion-focusable hydrated'])[1]");
	private By Agent_Sign = By.xpath("(//ion-button[@class='buttonIcon md button button-clear ion-activatable ion-focusable hydrated'])[2]");
	private By Sign_Done = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
	private By Sign_Clear = By.xpath("//ion-col[@style='padding-left: 20px;']/ion-button");
	private By SignPad_CloseButton = By.xpath("//ion-buttons[@slot='primary']/ion-button");
	private By InsurerName = By.xpath("//ion-input[@formcontrolname='PriorCovCompanyName1']/input");
	private By InsurerName_ErrorMsg = By.xpath("//ion-input[@formcontrolname='PriorCovCompanyName1']/parent::ion-item/parent::ion-col");
	private By ContractOrPolicyNumber = By.xpath("//ion-input[@formcontrolname='PriorCovPolicyNumber1']/input");
	private By ContractOrPolicyNumber_ErrorMsg = By.xpath("//ion-input[@formcontrolname='PriorCovPolicyNumber1']/parent::ion-item/parent::ion-col");
	private By InsuredOrAnnuitant = By.xpath("//ion-input[@formcontrolname='PriorCovInsured1']/input");
	private By InsuredOrAnnuitant_ErrorMsg = By.xpath("//ion-input[@formcontrolname='PriorCovInsured1']/parent::ion-item/parent::ion-col");
	private By Replaced_RadioButton = By.xpath("//ion-label[@mode='md']/following-sibling::ion-radio[@value='R']");
	private By Financing_RadioButton = By.xpath("//ion-label[@mode='md']/following-sibling::ion-radio[@value='F']");
	private By Replaced_Financing_ErrorMsg = By.xpath("//ion-radio-group[@formcontrolname='PriorCovRepOrFinancing1']/parent::div/parent::ion-col");
	private By Add_Button = By.xpath("//ion-button[normalize-space()='Add']");	
	private By Remove_Button = By.xpath("//ion-button[normalize-space()='Remove']");	
	private By PolicyReplaced_Explanation = By.xpath("//ion-input[@formcontrolname='PriorCovExplain']/input");
	private By PolicyReplaced_Explanation_ErrorMsg = By.xpath("//ion-input[@formcontrolname='PriorCovExplain']/parent::ion-item/parent::ion-col");
	private By ProposedInsurer_Sign_Error = By.xpath("//ion-label[.=' Proposed insured click here to sign. ']/parent::ion-button/parent::div/parent::ion-col");
	private By Agent_Sign_Error = By.xpath("//ion-label[text()=' AGENT CLICK HERE TO SIGN. ']/parent::ion-button/parent::div/parent::ion-col");
	private By Proposed_SignedDate = By.xpath("//ion-input[@formcontrolname='ProposedReplacementSignedDate']/input");
	private By Agent_SignedDate = By.xpath("//ion-input[@formcontrolname='AgentReplacementSignedDate']/input");
	
	private By InsurerName2 = By.xpath("//ion-input[@formcontrolname='PriorCovCompanyName2']/input");
	private By ContractOrPolicyNumber2 = By.xpath("//ion-input[@formcontrolname='PriorCovPolicyNumber2']/input");
	private By InsuredOrAnnuitant2 = By.xpath("//ion-input[@formcontrolname='PriorCovInsured2']/input");
	
	private By tableOfContents = By.xpath("//h3[.='Provide Any Additional Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Table of Contents']");
	private By step_1 = By.xpath("//span[.='Step 1: Product Information']");
	private By calculate = By.xpath("(//div/ion-row/ion-col/ion-button[starts-with(@class, md)])[2]");
	private By step_1_NextB = By.xpath("//p[.='Is Automatic Premium Loan Desired?']/parent::div/parent::ion-col/parent::ion-row/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_2_NextB = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_NextB = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_OwnerSSN = By.xpath("//ion-input[@formcontrolname='OwnerSSN']/input");
	private By step_4_NextB = By.xpath("//h3[.='Beneficiary Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By AddBenificiary = By.xpath("//ion-button[normalize-space()='Add Beneficiary']");

	
	public void Existing_Insurance() {

		String mandatoryError = "Please enter a value.";
		String nameMaxChar = "qwertyuiop asdfghjkl zxcvbnm qwertyuiop asdfghjkl zxcvbnm";
		String maxCharErrorMsg = "The maximum number of characters is 50.";
		String explanationMaxChar = "qwertyuiop asdfghjkl zxcvbnm poiuytrewq lkjhgfdsa mnbvcxz zxcvbnm lkjhgfdsa qwertyuiop poiuytrewq asdfghjkl";
		String explanationMaxCharError = "The maximum number of characters is 100.";

		WebUI.sleep(1);
		WebUI.moveToElement(NextStep5);
		WebUI.sleep(1);
		WebUI.clickElement(NextStep5);

		WebUI.verifyContains(getTextElement(error_Message_ExistingInsurQuest_1), mandatoryError);
		WebUI.verifyContains(getTextElement(error_Message_ExistingInsurQuest_2), mandatoryError);

		WebUI.clickElement(ExitingInsurance_Question_1);
		WebUI.sleep(0.2);
		WebUI.clickElement(ExistingInsurance_RadioB_Yes1);
		WebUI.sleep(0.2);
		WebUI.clickElement(ExistingInsurance_RadioB_Yes2);
		WebUI.sleep(0.2);
		WebUI.clickElement(ExistingInsurance_RadioB_No2);

		WebUI.scrollToElementAtBottom(ProposedInsurer_Sign);
		WebUI.sleep(0.2);
		WebUI.clickElement(Questionier__RadioB_No1);
		WebUI.clickElement(Questionier__RadioB_Yes1);
		WebUI.sleep(0.2);
		WebUI.clickElement(Questionier__RadioB_No2);
		WebUI.clickElement(Questionier__RadioB_Yes2);
		WebUI.clickElement(Questionier__RadioB_No2);

		WebUI.scrollToElementAtBottom(NextStep5);
		WebUI.moveToElement(NextStep5);
		WebUI.sleep(1);
		WebUI.clickElement(NextStep5);

		WebUI.verifyContains(getTextElement(InsurerName_ErrorMsg), mandatoryError);
		WebUI.verifyContains(getTextElement(ContractOrPolicyNumber_ErrorMsg), mandatoryError);

		WebUI.clearAndFillText(InsurerName, nameMaxChar);
		WebUI.verifyElementVisible(InsurerName_ErrorMsg);
		WebUI.verifyContains(getTextElement(InsurerName_ErrorMsg), maxCharErrorMsg);

		String randomInsurerName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(InsurerName, randomInsurerName);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(InsurerName, "value"), randomInsurerName);

		WebUI.clearAndFillText(ContractOrPolicyNumber, nameMaxChar);
		WebUI.verifyElementVisible(ContractOrPolicyNumber_ErrorMsg);
		WebUI.verifyContains(getTextElement(ContractOrPolicyNumber_ErrorMsg), maxCharErrorMsg);

		String randomPolicyNumber = DataGenerateUtils.randomSSNNumber();
		WebUI.clearAndFillText(ContractOrPolicyNumber, randomPolicyNumber);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(ContractOrPolicyNumber, "value"), randomPolicyNumber);

		WebUI.scrollToElementAtBottom(PolicyReplaced_Explanation);
		WebUI.verifyContains(getTextElement(InsuredOrAnnuitant_ErrorMsg), mandatoryError);

		WebUI.clearAndFillText(InsuredOrAnnuitant, nameMaxChar);
		WebUI.verifyElementVisible(InsuredOrAnnuitant_ErrorMsg);
		WebUI.verifyContains(getTextElement(InsuredOrAnnuitant_ErrorMsg), maxCharErrorMsg);

		String randomInsured = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(InsuredOrAnnuitant, randomInsured);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getAttributeElement(InsuredOrAnnuitant, "value"), randomInsured);

		WebUI.verifyContains(getTextElement(Replaced_Financing_ErrorMsg), mandatoryError);
		WebUI.clickElement(Financing_RadioButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(Replaced_RadioButton);
		WebUI.clickElement(Financing_RadioButton);
		WebUI.sleep(0.2);

		WebUI.clickElement(Add_Button);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(InsurerName2);
		WebUI.verifyElementVisible(ContractOrPolicyNumber2);
		WebUI.verifyElementVisible(InsuredOrAnnuitant2);
		WebUI.clickElement(Remove_Button);

		WebUI.scrollToElementAtBottom(Agent_Sign);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getTextElement(PolicyReplaced_Explanation_ErrorMsg), mandatoryError);
		WebUI.clearAndFillText(PolicyReplaced_Explanation, explanationMaxChar);
		WebUI.verifyElementVisible(PolicyReplaced_Explanation_ErrorMsg);
		WebUI.verifyContains(getTextElement(PolicyReplaced_Explanation_ErrorMsg), explanationMaxCharError);
		WebUI.clearAndFillText(PolicyReplaced_Explanation, "Enter the reason of policy change");

		WebUI.scrollToElementAtTop(ProposedInsurer_Sign);
		WebUI.sleep(0.2);
		WebUI.verifyContains(getTextElement(ProposedInsurer_Sign_Error), mandatoryError);
		WebUI.clickElement(ProposedInsurer_Sign);
		WebUI.sleep(2);
		ProjectUtilities.signature1();
		WebUI.sleep(0.2);
		WebUI.clickElement(Sign_Clear);
		WebUI.sleep(0.5);
		WebUI.clickElement(SignPad_CloseButton);

		WebUI.sleep(1);
		WebUI.clickElement(ProposedInsurer_Sign);
		WebUI.sleep(2);
		ProjectUtilities.signature1();
		WebUI.clickElement(Sign_Done);

		WebUI.verifyElementNotEditable(Proposed_SignedDate);
		WebUI.sleep(1);

		// Agent Sign
		WebUI.verifyContains(getTextElement(Agent_Sign_Error), mandatoryError);
		WebUI.clickElement(Agent_Sign);
		WebUI.sleep(2);
		ProjectUtilities.signature1();

		try {
			DriverManager.getDriver().findElement(Sign_Done).isEnabled();
			WebUI.clickElement(Sign_Done);
		} catch (Exception ex) {
			WebUI.clickElement(SignPad_CloseButton);
			WebUI.sleep(1);
			WebUI.clickElement(Agent_Sign);
			WebUI.sleep(2);
			ProjectUtilities.signature1();
			WebUI.clickElement(Sign_Done);
		}

		WebUI.sleep(0.5);
		WebUI.verifyElementNotEditable(Agent_SignedDate);
		WebUI.logInfoMessage("Proposed Signed Date: " + WebUI.getAttributeElement(Proposed_SignedDate, "value"));
		WebUI.logInfoMessage("Agent Signed Date: " + WebUI.getAttributeElement(Agent_SignedDate, "value"));

		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(NextStep5);
		WebUI.sleep(0.2);
		WebUI.moveToElement(NextStep5);
		WebUI.clickElement(NextStep5);

		if (ThreadLocalManager.getPlanNumber() == 2) {
			WebUI.sleep(1.5);
			WebUI.moveToElement(tableOfContents);
			WebUI.clickElement(tableOfContents);
			WebUI.sleep(1);

			WebUI.clickElementWithJs(step_1);
			WebUI.sleep(1);
			WebUI.scrollToElementAtBottom(calculate);
			WebUI.sleep(0.2);
			WebUI.clickElement(calculate);
			WebUI.sleep(0.2);
			WebUI.scrollToElementAtBottom(step_1_NextB);
			WebUI.sleep(0.5);
			WebUI.moveToElement(step_1_NextB);
			WebUI.clickElement(step_1_NextB);
			WebUI.sleep(2.5);

			WebUI.scrollToElementAtBottom(step_2_NextB);
			WebUI.sleep(0.5);
			WebUI.moveToElement(step_2_NextB);
			WebUI.clickElement(step_2_NextB);
			WebUI.sleep(3);

			WebUI.scrollToElementAtTop(step_3_OwnerSSN);
			WebUI.sleep(0.5);
			WebUI.scrollToElementAtBottom(step_3_NextB);
			WebUI.sleep(0.5);
			WebUI.moveToElement(step_3_NextB);
			WebUI.clickElement(step_3_NextB);
			WebUI.sleep(2.5);

			WebUI.scrollToElementAtTop(AddBenificiary);
			WebUI.sleep(0.5);
			WebUI.scrollToElementAtBottom(step_4_NextB);
			WebUI.sleep(0.5);
			WebUI.moveToElement(step_4_NextB);
			WebUI.clickElement(step_4_NextB);
			WebUI.sleep(2.5);

			WebUI.scrollToElementAtTop(InsurerName);
			WebUI.sleep(0.5);
			WebUI.scrollToElementAtBottom(NextStep5);
			WebUI.sleep(0.5);
			WebUI.moveToElement(NextStep5);
			WebUI.clickElement(NextStep5);
			WebUI.sleep(2.5);
		}

	}

}
