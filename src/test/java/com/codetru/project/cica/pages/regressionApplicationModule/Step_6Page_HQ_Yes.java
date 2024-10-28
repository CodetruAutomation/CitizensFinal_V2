package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getTextElement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.utils.DataGenerateUtils;

public class Step_6Page_HQ_Yes {

	private By NextStep6 = By.xpath("//h3[text()='Health Questions ']/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By Error_HealthQuestions_1 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[1]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_2 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[2]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_3 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[3]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_4 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[4]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_5 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[5]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_6 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[6]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_7 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[7]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_8 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[8]/ion-row/ion-col[@class='md hydrated']");
	
	private By HealthQuestions1 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[8]");
	private By HealthQuestions2 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[9]");
	private By HealthQuestions3 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[10]");
	private By HealthQuestions4 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[11]");
	private By HealthQuestions5 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[12]");
	private By HealthQuestions6 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[13]");
	private By HealthQuestions7 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[14]");
	private By HealthQuestions8 = By.xpath("(//ion-item/ion-label[.='No']/following-sibling::ion-radio)[15]");
	
	private By no_physician = By.xpath("//ion-checkbox[@formcontrolname='PhysicianNameCheckbox']");
	private By Error_NoPhysicanCheckBox = By.xpath("//ion-input[@formcontrolname='PhysicianName']/parent::ion-item/parent::ion-col");
	private By Physician_textbox = By.xpath("//ion-input[@formcontrolname='PhysicianName']/input");
	
	//Health Question Radio Buttons List
	private By HealthQuestions_No_RadioButtons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='No']/following-sibling::ion-radio");
	private By HealthQuestions_Yes_RadioButtons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='Yes']/following-sibling::ion-radio");

	//Change Plan Locators
	private By popup_Ok_Button = By.xpath("//span[text()='Ok']/parent::button");
	private By selectPlan = By.xpath("(//select[@formcontrolname='Plan'])[2]");
	private By changePlan_Calculate = By.xpath("(//ion-button[text()='Calculate'])[2]");
	private By changePlan_NextButton = By.xpath("(//h3[.='Plan Options'])[2]/parent::div/following::ion-row/ion-col/ion-button[.='Next Step']");

	//Step 1 to 5 Locators
	private By TableOfContents = By.xpath("//h3[.='Health Questions ']/parent::ion-col/parent::ion-row/following-sibling::ion-row/ion-col[@size='24' and @size-md='18']/ion-button[.='Table of Contents']");
	private By step1 = By.xpath("//span[.='Step 1: Product Information']");
	private By impNotice_Popup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	private By calculate = By.xpath("//ion-button[text()='Calculate']");
	private By step_1_NextB = By.xpath("//p[.='Is Automatic Premium Loan Desired?']/parent::div/parent::ion-col/parent::ion-row/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_2_NextB = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_NextB = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step_3_OwnerSSN = By.xpath("//ion-input[@formcontrolname='OwnerSSN']/input");
	private By step_4_NextB = By.xpath("//h3[.='Beneficiary Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By AddBenificiary = By.xpath("//ion-button[normalize-space()='Add Beneficiary']");
	private By step_5_NextB = By.xpath("//h3[.='Existing Insurance']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By InsurerName = By.xpath("//ion-input[@formcontrolname='PriorCovCompanyName1']/input");

	public void Predetermination_Questions() {

		String mandatoryError = "Please enter a value.";
		String physicianMaxChar = "qwertyuiop asdfghjkl zxcvbnm poiuytrewq lkjhgfdsa mnbvcxz zxcvbnm lkjhgfdsa qwertyuiop poiuytrewq asdfghjkl";
		String physicianMaxCharError = "The maximum number of characters is 90.";
		
//=======================================================================================================================
		WebUI.sleep(2);
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
			System.out.println("Standard Issue notice didn't appear. "+exe.getMessage());
		}
		try {
			WebUI.sleep(1);
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
//=======================================================================================================================
		
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.moveToElement(NextStep6);
		WebUI.clickElement(NextStep6);

		WebUI.scrollToElementAtTop(Error_HealthQuestions_1);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_1);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_1), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_2);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_2);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_2), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_3);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_3);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_3), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_4);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_4);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_4), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_5);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_5);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_5), mandatoryError);
		WebUI.sleep(0.2);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_6);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_6), mandatoryError);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_7);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_7);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_7), mandatoryError);
		
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(no_physician);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(no_physician);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_8);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_8);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_8), mandatoryError);
		WebUI.sleep(1);
			
			List<WebElement> HQ_No_Buttons = WebUI.getWebElements(HealthQuestions_No_RadioButtons);
			List<WebElement> HQ_Yes_Buttons = WebUI.getWebElements(HealthQuestions_Yes_RadioButtons);
			
			for(int i=0; i < HQ_No_Buttons.size(); i++)
			{
				if(i == 0) {
					
					WebUI.scrollToElementAtBottom(HQ_Yes_Buttons.get(i));
					WebUI.sleep(0.2);
					HQ_Yes_Buttons.get(i).click();
				}
				else {
				WebUI.scrollToElementAtBottom(HQ_No_Buttons.get(i));
				WebUI.sleep(0.2);
				HQ_No_Buttons.get(i).click();
				}
			}
			
		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(NextStep6);

		WebUI.verifyContains(getTextElement(Error_NoPhysicanCheckBox).trim(), mandatoryError);
		WebUI.setText(Physician_textbox, physicianMaxChar);
		WebUI.verifyElementVisible(Error_NoPhysicanCheckBox);
		WebUI.verifyContains(getTextElement(Error_NoPhysicanCheckBox), physicianMaxCharError);
		
		WebUI.clearAndFillText(Physician_textbox, DataGenerateUtils.randomFirstName()+" "+DataGenerateUtils.randomLastName()+" "+DataGenerateUtils.randomShortAddress());
		WebUI.sleep(0.5);
		WebUI.clickElement(no_physician);

		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.moveToElement(NextStep6);
		WebUI.clickElement(NextStep6);
		WebUI.sleep(1.5);
		
		//Select 'Yes' in any of the HealthQuestions
		WebUI.verifyElementVisible(popup_Ok_Button);
		WebUI.clickElement(popup_Ok_Button);
		WebUI.sleep(1.5);
		WebUI.selectOptionByIndex(selectPlan, 1);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(changePlan_Calculate);
		WebUI.sleep(0.2);
		WebUI.clickElement(changePlan_Calculate);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(changePlan_NextButton);
		WebUI.sleep(0.2);
		WebUI.moveToElement(changePlan_NextButton);
		WebUI.clickElement(changePlan_NextButton);
		WebUI.sleep(2);
		

		
	}
}
