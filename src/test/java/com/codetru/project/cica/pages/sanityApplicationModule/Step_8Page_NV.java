package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.utils.DataGenerateUtils;

public class Step_8Page_NV extends CommonPageCICA {

	private By NextStep8 = By.xpath("//h3[text()='Agent']/ancestor::ion-grid/ion-row[2]/ion-col/ion-button[text()='Next Step']");
	private By signedCity = By.xpath("//ion-input[@formcontrolname='SignedCity']/input");
	private By HoldDateRadioButton_No = By.xpath("//ion-radio-group[@formcontrolname='HoldDateCheckBox']/ion-row/ion-col/ion-item/ion-label[text()='No']/following-sibling::ion-radio");
	private By HoldDateRadioButton_Yes = By.xpath("//ion-radio-group[@formcontrolname='HoldDateCheckBox']/ion-row/ion-col/ion-item/ion-label[text()='Yes']/following-sibling::ion-radio");
	private By Error_SignatureProposedInsurer = By.xpath("(//h3[text()='Signature']/following-sibling::ion-row[2]/ion-col[@size='24' and @size-md='6'])[1]");
	private By ProposedInsurerSignature = By.xpath("//h3[.='Signature']/following-sibling::ion-row[2]/ion-col/div/ion-button");
	private By signature_pad1 = By.xpath("(//canvas[@class='signature-pad-canvas hidden-xs-down'])[1]");
	private By Padding_Right1 = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
	private By SignatureOfAgent = By.xpath("//div/h3[.='Agent']/following-sibling::ion-row/ion-col[4]/div/ion-button");
	private By signature_pad2 = By.xpath("//canvas[@class='signature-pad-canvas hidden-xs-down']");
	private By Padding_Right2 = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
	private By application_btn = By.id("applicationButton");
	private By EC_Consent_Signature = By.xpath("//h3[.='Electronic Communication Consent']/parent::div/descendant::ion-button");
	private By HIPAA_Privacy_Auth_Sec = By.xpath("//h3[text()=' Disclosure and Signature ']/following::div/h3[text()='HIPAA Privacy Authorization']");

	private By AgentStatement_RadioB_No1 = By.xpath("//ion-radio-group[@formcontrolname='AgentStatement1']/ion-row/ion-col[2]/ion-item/ion-radio");
	private By AgentStatement_RadioB_No2 = By.xpath("//ion-radio-group[@formcontrolname='AgentStatement1']/ion-row/ion-col[2]/ion-item/following::ion-radio[2]");
	private By licensedAgent_ContinueButton = By.xpath("//span[normalize-space()='Continue']/parent::button");

	public void Disclosure_and_Signature() {

		WebUI.sleep(1.2);
		WebUI.scrollToElementAtTop(HIPAA_Privacy_Auth_Sec);
		WebUI.sleep(0.5);

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

		WebUI.sleep(1);
		WebUI.scrollToElementAtTop(signedCity);
		WebUI.sleep(1);

		String randomCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(signedCity, randomCity);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(signedCity, "value"), randomCity);
		WebUI.moveToElement(signedCity);

		WebUI.scrollToElementAtBottom(Error_SignatureProposedInsurer);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(HoldDateRadioButton_No);
		WebUI.sleep(0.5);

		WebUI.sleep(1);
		WebUI.clickElement(ProposedInsurerSignature);
		WebUI.sleep(2);
		ProjectUtilities.signature1();
		WebUI.clickElement(Padding_Right1);
		WebUI.sleep(2);
			
		WebUI.clickElement(HoldDateRadioButton_No);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(NextStep8);
		WebUI.verifyElementVisible(NextStep8);
		WebUI.sleep(0.5);

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
		WebUI.sleep(0.5);
		WebUI.clickElement(SignatureOfAgent);
		WebUI.sleep(1);
		ProjectUtilities.signature1();
		WebUI.clickElement(Padding_Right2);
		WebUI.sleep(2);
		WebUI.sleep(1);

		WebUI.scrollToElementAtBottom(NextStep8);
		WebUI.sleep(0.5);
		WebUI.clickElement(NextStep8);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(application_btn);
		WebUI.sleep(1.5);

	}
}
