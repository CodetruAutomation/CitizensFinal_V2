package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;


public class Step_7PageHIPAA extends CommonPageCICA{



	private By nextStepHIPAA	=	By.xpath("//h3[.='HIPAA Privacy Authorization']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");	
	private By ownerSignature = By.xpath("//h3[.='Authorization/Consent']/following-sibling::ion-row/ion-col/div/ion-button");	
	private By signPadDone = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
	private By SignClear = By.xpath("//ion-col[@style='padding-left: 20px;']/ion-button");
	private By processing_Popup = By.xpath("//h2[contains(text(), 'Please stay on this page as we process this request.')]");
	private By HIPAA_Authentication_Error = By.xpath("//div[contains(text(),'Please ensure the following steps are completed before the HIPAA authentication can be performed.')]");
	private By HIPAA_Popup_OK_Button = By.xpath("//span[text()='OK']/parent::button");
	private By TableOfContents = By.xpath("//h3[.='HIPAA Privacy Authorization']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Table of Contents']");
	
	private By step1 = By.xpath("//span[.='Step 1: Product Information']");
	private By calculate = By.xpath("//ion-button[.='Calculate']");
	private By impNotice_Popup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	private By step_1_NextB = By.xpath("//p[.='Is Automatic Premium Loan Desired?']/parent::div/parent::ion-col/parent::ion-row/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_2_NextB = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_NextB = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_OwnerSSN = By.xpath("//ion-input[@formcontrolname='OwnerSSN']/input");
	private By step_4_NextB = By.xpath("//h3[.='Beneficiary Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By AddBenificiary = By.xpath("//ion-button[normalize-space()='Add Beneficiary']");
	private By step_5_NextB = By.xpath("//h3[.='Existing Insurance']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By InsurerName = By.xpath("//ion-input[@formcontrolname='PriorCovCompanyName1']/input");
	private By step_6_NextB = By.xpath("//h3[text()='Health Questions ']/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");

	public void HIPAA_Voice_Authorization() {
		
		String HIPAA_Authentication_ErrorMsg = "Please ensure the following steps are completed before the HIPAA authentication can be performed.";
		
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(ownerSignature);
		WebUI.sleep(0.5);

		WebUI.clickElement(ownerSignature);
		WebUI.sleep(1.5);
		ProjectUtilities.signature2();
		WebUI.clickElement(signPadDone);
		WebUI.sleep(2);
		
		WebUI.scrollToElementAtBottom(nextStepHIPAA);
		WebUI.moveToElement(nextStepHIPAA);
		WebUI.sleep(0.5);
		WebUI.clickElement(nextStepHIPAA);
		WebUI.sleep(1.5);
		
		try {
			WebUI.verifyElementVisible(HIPAA_Authentication_Error);
			WebUI.verifyContains(getTextElement(HIPAA_Authentication_Error), HIPAA_Authentication_ErrorMsg);
			WebUI.sleep(0.5);
			
			WebUI.clickElement(HIPAA_Popup_OK_Button);
			WebUI.sleep(0.5);
			
			WebUI.scrollToElementAtBottom(TableOfContents);
			WebUI.sleep(0.2);
			WebUI.moveToElement(TableOfContents);
			WebUI.clickElement(TableOfContents);
			WebUI.sleep(1);
		
			WebUI.clickElementWithJs(step1);
    		WebUI.sleep(1);
    		try {
				DriverManager.getDriver().findElement(impNotice_Popup).isDisplayed();
				WebUI.sleep(0.5);
				WebUI.clickElement(impNotice_Popup);
				WebUI.sleep(0.5);
    		}catch(Exception exe)
    		{
    			System.out.println("Move to Step-1 page failed. "+exe.getMessage());
    		}
			try {
				DriverManager.getDriver().findElement(calculate).isDisplayed();
				WebUI.scrollToElementAtBottom(calculate);
				WebUI.sleep(0.4);
				WebUI.clickElementWithJs(calculate);
				WebUI.sleep(0.4);
			} catch (Exception exe) {
				System.out.println("Calculate button not clicked. " + exe.getMessage());
			}
    		
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
    		WebUI.scrollToElementAtBottom(step_5_NextB);
    		WebUI.sleep(0.5);
    		WebUI.moveToElement(step_5_NextB);
    		WebUI.clickElement(step_5_NextB);
    		WebUI.sleep(2.5);
    		
    		WebUI.scrollToElementAtBottom(step_6_NextB);
    		WebUI.sleep(0.2);
    		WebUI.moveToElement(step_6_NextB);
    		WebUI.clickElement(step_6_NextB);
    		WebUI.sleep(2.5);
    		
    		WebUI.scrollToElementAtBottom(ownerSignature);
    		WebUI.sleep(0.5);

    		WebUI.clickElement(ownerSignature);
    		WebUI.sleep(1.5);
    		WebUI.clickElement(SignClear);
    		WebUI.sleep(0.4);
    		ProjectUtilities.signature2();
    		WebUI.clickElement(signPadDone);
    		WebUI.sleep(2);
    		
    		WebUI.scrollToElementAtBottom(nextStepHIPAA);
    		WebUI.sleep(0.2);
    		WebUI.moveToElement(nextStepHIPAA);
    		WebUI.clickElement(nextStepHIPAA);
    		WebUI.sleep(2);
		} catch (Exception ex) {
			System.out.println("HIPAA Authentication Failed. " + ex.getMessage());
		}
		
		try {
			while (DriverManager.getDriver().findElement(processing_Popup).isDisplayed()) {
				WebUI.sleep(0.2);
				continue;
			}

		} catch (Exception exe) {
			System.out.println("");
		}
		
		WebUI.waitForPageLoaded();
		WebUI.sleep(2);
		
	}


}
