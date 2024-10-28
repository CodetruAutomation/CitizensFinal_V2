package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.utils.DataGenerateUtils;


public class Step_8Page extends CommonPageCICA {

	
		private By NextStep8 = By.xpath("//h3[text()='Agent']/ancestor::ion-grid/ion-row[2]/ion-col/ion-button[text()='Next Step']");
		private By signedCity = By.xpath("//ion-input[@formcontrolname='SignedCity']/input");
//		private By Date_Signed = By.xpath("//ion-input[@formcontrolname='DateSigned']/input");
		private By holdDate_tag = By.xpath("//h3[text()='Hold Date']");
		private By HoldDateRadioButton_No = By.xpath("//ion-radio-group[@formcontrolname='HoldDateCheckBox']/ion-row/ion-col[2]/ion-item/ion-radio");
		private By HoldDateRadioButton_Yes = By.xpath("//ion-radio-group[@formcontrolname='HoldDateCheckBox']/ion-row/ion-col[1]/ion-item/ion-radio");
		private By HoldDate_Textbox = By.xpath("//input[@formcontrolname='HoldDate']");
		private By HoldDate_ErrorMsg = By.xpath("//input[@formcontrolname='HoldDate']/parent::ion-item/parent::ion-col");
		private By Error_SignedCity = By.xpath("(//h3[.='Signature']/following-sibling::ion-row/ion-col)[1]");
		private By Error_SignatureProposedInsurer = By.xpath("(//h3[.='Signature']/following-sibling::ion-row/ion-col)[3]");
		private By ProposedInsurerSignature = By.xpath("//h3[.='Signature']/following-sibling::ion-row[2]/ion-col/div/ion-button");
		private By Error_SignatureOfOwner = By.xpath("(//h3[.='Signature']/following-sibling::ion-row/ion-col)[6]");
		private By SignatureOfOwner = By.xpath("//h3[.='Signature']/following-sibling::ion-row[3]/ion-col/div/ion-button");
		private By signature_pad1 = By.xpath("(//canvas[@class='signature-pad-canvas hidden-xs-down'])[1]");
		private By signature_pad2 = By.xpath("//canvas[@class='signature-pad-canvas hidden-xs-down']");
		private By Padding_Right1 = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
		private By Sign_Clear = By.xpath("//ion-col[@style='padding-left: 20px;']/ion-button");
		private By SignPad_CloseButton = By.xpath("//ion-buttons[@slot='primary']/ion-button");
		private By Error_HoldUntillDate = By.xpath("(//ion-col[@class = 'md hydrated' and @size-md = '12' and @size='24'])[13]");
		private By Error_SignatureOfAgent = By.xpath("//h3[text()='Agent']/following-sibling::ion-row/ion-col[4][@size='24']");
		private By SignatureOfAgent = By.xpath("//div/h3[.='Agent']/following-sibling::ion-row/ion-col[4]/div/ion-button");
		private By Padding_Right2 = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
		private By Sign1 = By.xpath("(//h3[.='Signature']/following-sibling::ion-row/ion-col[@size='24' and @size-md='6'])[2]/div/img");
		private By Sign2 = By.xpath("(//h3[.='Signature']/following-sibling::ion-row/ion-col[@size='24' and @size-md='6'])[4]/div/img");
		private By Sign3 = By.xpath("//h3[.='Agent']/following-sibling::ion-row/ion-col/following-sibling::ion-col/div/img");
		private By application_btn = By.id("applicationButton");
		private By ProposedInsurer_SignedDate = By.xpath("//ion-input[@formcontrolname='SignedDate']/input");
		private By Owner_SignedDate = By.xpath("//ion-input[@formcontrolname='SignedDateOwner']/input");
		private By Agent1_SignedDate = By.xpath("//ion-input[@formcontrolname='SignedDateAgent1']/input");
		private By Agent2_SignedDate = By.xpath("//ion-input[@formcontrolname='SignedDateAgent2']/input");
		private By AgentLic_ContinueButton = By.xpath("//span[normalize-space()='Continue']/parent::button");
		private By EC_Consent_Signature = By.xpath("//h3[.='Electronic Communication Consent']/parent::div/descendant::ion-button");
		private By tableOfContents = By.xpath("(//ion-button[normalize-space()='Table of Contents'])[1]");
		private By backToList = By.xpath("(//ion-button[normalize-space()='Back to List'])[1]");
		private By HoldDate_InfoIcon = By.xpath("//p[normalize-space()='Delay Payment']/ion-icon");
		private By HoldDate_InfoMsg = By.xpath("//p[contains(text(),' An applicant can choose a future date for their application and payment to process.')]");
		
		private By Agent1_Number = By.xpath("//ion-input[@formcontrolname='AgentNumber1']/input");
		private By Agent1_Name = By.xpath("//ion-input[@formcontrolname='AgentName1']/input");
		private By AgentStatement_RadioB_No1 = By.xpath("//ion-radio-group[@formcontrolname='AgentStatement1']/ion-row/ion-col[2]/ion-item/ion-radio");
		private By AgentStatement_RadioB_No2 = By.xpath("//ion-radio-group[@formcontrolname='AgentStatement1']/ion-row/ion-col[2]/ion-item/following::ion-radio[2]");
		private By licensedAgent_ContinueButton = By.xpath("//span[normalize-space()='Continue']/parent::button");
	
		public void Disclosure_and_Signature() {

			String mandatoryError = "Please enter a value.";
			String maxNameCharacters = "sdfsadfgdfsfghfghxfghjdsfghdfghdfghjdfsghdsfghretyu";
			String maxCharError = "The maximum number of characters is 50.";
			String holdDateError = "Hold Date required or click No for delayed payment";
			String HoldDate_InfoIcon_Msg = "An applicant can choose a future date for their application and payment to process. The date cannot be more than 14 days in the future.";

			WebUI.sleep(2);
			WebUI.scrollToElementAtBottom(NextStep8);
			WebUI.moveToElement(NextStep8);
			WebUI.sleep(0.2);
			WebUI.clickElement(NextStep8);
			WebUI.sleep(3);

			try {
				DriverManager.getDriver().findElement(licensedAgent_ContinueButton).isDisplayed();
				WebUI.clickElement(licensedAgent_ContinueButton);

			} catch (Exception ex) {
				System.out.println("Agent License pop up did not appear.");
			}

			try {

				DriverManager.getDriver().findElement(EC_Consent_Signature).isDisplayed();
				WebUI.scrollToElementAtTop(EC_Consent_Signature);
				WebUI.clickElement(EC_Consent_Signature);
				WebUI.sleep(2);
				ProjectUtilities.signature2();
				WebUI.clickElement(Padding_Right1);
				WebUI.sleep(2);

			} catch (Exception exe) {
				System.out.println("Electronic Communication Consent Did Not Appear. " + exe.getMessage());
			}

			WebUI.sleep(2);
			WebUI.scrollToElementAtTop(ProposedInsurerSignature);
			WebUI.sleep(0.2);
			WebUI.scrollToElementAtTop(signedCity);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(Error_SignedCity);

			WebUI.verifyContains(getTextElement(Error_SignedCity), mandatoryError);
			WebUI.sleep(0.2);
			WebUI.moveToElement(signedCity);
			WebUI.sleep(0.2);
			WebUI.moveToElement(ProposedInsurerSignature);
			WebUI.sleep(0.2);

			WebUI.scrollToElementAtTop(signedCity);
			WebUI.clearAndFillText(signedCity, maxNameCharacters);
			WebUI.sleep(1);
			WebUI.scrollToElementAtTop(Error_SignedCity);
			WebUI.verifyElementVisible(Error_SignedCity);
			WebUI.verifyContains(getTextElement(Error_SignedCity), maxCharError);

			WebUI.moveToElement(signedCity);
			String randomCity = DataGenerateUtils.randomCity();
			WebUI.clearAndFillText(signedCity, randomCity);
			WebUI.sleep(0.5);
			WebUI.verifyContains(getAttributeElement(signedCity, "value"), randomCity);
			WebUI.moveToElement(signedCity);

			WebUI.scrollToElementAtTop(Error_SignatureProposedInsurer);
			WebUI.sleep(0.5);
			WebUI.scrollToElementAtBottom(HoldDateRadioButton_No);
			WebUI.verifyElementPresent(HoldDateRadioButton_No);
			WebUI.sleep(0.5);

			WebUI.verifyContains(getTextElement(Error_SignatureProposedInsurer), mandatoryError);
			WebUI.sleep(1);

			for (int c = 0; c < 3; c++) {
				WebUI.clickElement(ProposedInsurerSignature);
				WebUI.sleep(2);

				if (c == 1) {
					WebUI.clickElement(Sign_Clear);
					WebUI.sleep(0.5);
					WebUI.clickElement(SignPad_CloseButton);
					WebUI.sleep(0.5);
					WebUI.verifyElementNotVisible(Sign1);
				} else {
					WebUI.verifyElementVisible(SignPad_CloseButton);
					WebUI.verifyElementVisible(Sign_Clear);
					WebUI.verifyElementVisible(Padding_Right1);
					ProjectUtilities.signature1();
					WebUI.clickElement(Padding_Right1);
					WebUI.sleep(1);
				}
			}

			WebUI.verifyElementVisible(Sign1);
			WebUI.verifyElementNotEditable(ProposedInsurer_SignedDate);
			WebUI.logInfoMessage("Proposed Signed Date: " + WebUI.getAttributeElement(ProposedInsurer_SignedDate, "value"));

			// Owner's Signature
			try {
				DriverManager.getDriver().findElement(Error_SignatureOfOwner).isDisplayed();
				WebUI.verifyContains(getTextElement(Error_SignatureOfOwner), mandatoryError);
				WebUI.sleep(1);
				WebUI.clickElement(SignatureOfOwner);
				WebUI.sleep(2);
				ProjectUtilities.signature2();
				WebUI.clickElement(Padding_Right1);
				WebUI.sleep(2);
				WebUI.verifyElementVisible(Sign2);
				WebUI.verifyElementNotEditable(Owner_SignedDate);
				WebUI.logInfoMessage("Owner Signed Date: " + WebUI.getAttributeElement(Owner_SignedDate, "value"));
			} catch (Exception ex) {
				System.out.println("Signature of Owner not available: " + ex.getMessage());
				WebUI.sleep(1);
			}

			WebUI.scrollToElementAtTop(holdDate_tag);
			WebUI.sleep(0.2);
			WebUI.verifyElementVisible(HoldDate_ErrorMsg);
			WebUI.verifyContains(getTextElement(HoldDate_ErrorMsg), holdDateError);

			WebUI.verifyElementVisible(HoldDateRadioButton_Yes);
			WebUI.verifyElementVisible(HoldDateRadioButton_No);
			WebUI.verifyElementVisible(HoldDate_Textbox);
			WebUI.clickElement(HoldDateRadioButton_No);
			WebUI.sleep(0.4);
			WebUI.verifyElementNotVisible(HoldDate_Textbox);

//			WebUI.clickElementWithJs(HoldDate_InfoIcon);
//			WebUI.sleep(0.2);
//			WebUI.verifyContains(getTextElement(HoldDate_InfoMsg), HoldDate_InfoIcon_Msg);
//			WebUI.sleep(0.2);
//			WebUI.clickElementWithJs(HoldDate_InfoIcon);
//			WebUI.sleep(0.2);

			try {

				DriverManager.getDriver().findElement(AgentStatement_RadioB_No1).isDisplayed();
				WebUI.clickElement(AgentStatement_RadioB_No1);
				WebUI.sleep(0.5);
				DriverManager.getDriver().findElement(AgentStatement_RadioB_No2).isDisplayed();
				WebUI.clickElement(AgentStatement_RadioB_No2);
				WebUI.sleep(0.5);

			} catch (Exception ex) {
				System.out.println("LICENSED AGENT STATEMENT - Not Available");
			}

			WebUI.scrollToElementAtBottom(NextStep8);
			WebUI.verifyElementVisible(NextStep8);
//			
			WebUI.verifyContains(getTextElement(Error_SignatureOfAgent), mandatoryError);
			WebUI.sleep(1);

			WebUI.verifyElementNotEditable(Agent1_Number);
			WebUI.verifyElementNotEditable(Agent1_Name);

			String agentName = WebUI.getAttributeElement(Agent1_Name, "value");
			if (agentName != "" || agentName != null) {
				WebUI.logInfoMessage("Agent 1 Number: " + WebUI.getAttributeElement(Agent1_Number, "value"));
				WebUI.logInfoMessage("Agent 1 Name: " + agentName);
			} else {
				WebUI.logInfoMessage("Agent Name and Number did not appear.");
			}

			// Agent's Signature
			WebUI.verifyElementVisible(SignatureOfAgent);
			WebUI.clickElement(SignatureOfAgent);
			WebUI.sleep(1);

			ProjectUtilities.signature1();
			WebUI.clickElement(Padding_Right2);
			WebUI.sleep(2);
			WebUI.verifyElementVisible(Sign3);

			WebUI.clickElement(SignatureOfAgent);
			WebUI.sleep(1);
			WebUI.clickElement(SignPad_CloseButton);
			WebUI.sleep(0.5);
			WebUI.verifyElementVisible(Sign3);
			WebUI.verifyElementNotEditable(Agent1_SignedDate);
			WebUI.logInfoMessage("Agent Signed Date: " + WebUI.getAttributeElement(Agent1_SignedDate, "value"));

			WebUI.scrollToElementAtBottom(NextStep8);
			WebUI.sleep(0.2);
			WebUI.clickElement(NextStep8);
			WebUI.sleep(1);
			WebUI.verifyElementVisible(application_btn);
			WebUI.sleep(1);

		}
		
}
