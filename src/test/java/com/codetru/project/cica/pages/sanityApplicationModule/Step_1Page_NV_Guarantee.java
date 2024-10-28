package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.pages.regressionApplicationModule.HomePage;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataFakerUtils;
import com.codetru.utils.DataGenerateUtils;


public class Step_1Page_NV_Guarantee extends CommonPageCICA{


	private By step_1 = By.xpath("//span[normalize-space()='Step 1: Product Information']");
	private By page_Error = By.xpath("//p[.='There are some errors on this page. Please correct before continuing.']");
	private By FirstName = By.xpath("//ion-input[@formcontrolname='ProposedFirstName']/input");
	private By Error_Message_FirstName = By.xpath("(//ion-col[@size='24' and @size-md='8'])[1]");
	private By MiddleName = By.xpath("//ion-input[@formcontrolname='ProposedMiddleName']/input");
	private By Error_Message_MiddleName = By.xpath("(//ion-col[@size='24' and @size-md='8'])[2]");
	private By LastName = By.xpath("//ion-input[@formcontrolname='ProposedLastName']/input");
	private By Error_Message_LastName = By.xpath("(//ion-col[@size='24' and @size-md='8'])[3]");
	private By StateDropdown = By.xpath("//select[@formcontrolname='ProposedPhysicalState']");
	private By Error_Message_State = By.xpath("(//ion-col[@size='24' and @size-md='4'])[1]");
	private By state = By.xpath("(//option[.=' Louisiana'])[1]");
	private By genderDropdown = By.xpath("//select[@formcontrolname='ProposedGender']");
	private By gender = By.xpath("//option[.='Male']");
	private By Error_Message_Gender = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[1]");
	private By DateOfBirth = By.xpath("//input[@formcontrolname='ProposedBirthDate']");
	private By age = By.xpath("//ion-input[@formcontrolname='ProposedAge']");
	private By Error_Message_DateOfBirth = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[2]");
	private By Error_Message_ApplicantLocation = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and @class='md hydrated'])[4]");
	private By signedStateDropdown = By.xpath("//select[@formcontrolname='SignedState']");
	private By SignedState = By.xpath("(//option[.=' Louisiana'])[2]");
	private By preferredlanguage = By.xpath("//select[@formcontrolname='ProposedPreferredLanguage']");
	private By language = By.xpath("//option[.=' English']");
	private By Call_Yes = By.xpath("(//ion-label[.='Yes'])[1]");
	private By Call_No = By.xpath("(//ion-label[.='No'])[1]");
	private By Error_Message_Language = By.xpath("(//ion-col[@size='24' and @size-md='4' and @class='md hydrated']/following-sibling::ion-col[@size='24' and"
			+ " @class='md hydrated'])[5]");
	private By ErrorMessage_BasePlan = By.xpath("//ion-col[@class = 'md hydrated' and @size-md = '7']");
	private By plan = By.xpath("//select[@formcontrolname='Plan']");
	private By selectPlan = By.xpath("//option[.=' Allegiant Superior Choice Standard Issue']");
	private By selectPlan_CICA = By.xpath("//option[.=' CICA Life Plus Standard Issue']");
	private By selectPlan_Garuntee = By.xpath("//option[.=' CICA Life Plus Guaranteed Issue']");
	private By Accidental_Checkbox = By.xpath("//ion-Checkbox[@formcontrolname='ADB']");
	private By FaceAmount = By.xpath("//ion-input[@formcontrolname='AmountOfInsurance']/input");
	private By ErrorMessage_FaceAmount = By.xpath("//ion-col[@class = 'md hydrated' and @size-md = '3']");
	private By Annually = By.xpath("//ion-label[text()='Annually']/following-sibling::ion-radio");
	private By Semi_Annually = By.xpath("//ion-label[text()='Semi-Annually']/following-sibling::ion-radio");
	private By Quarterly = By.xpath("//ion-label[text()='Quarterly']/following-sibling::ion-radio");
	private By Monthly = By.xpath("//ion-label[text()='Monthly']/following-sibling::ion-radio");
	private By Yes = By.xpath("(//ion-label[text()='Yes']/following-sibling::ion-radio)[2]");
	private By No = By.xpath("(//ion-label[text()='No']/following-sibling::ion-radio)[2]");
	private By Nextstep_1 = By.xpath("(//ion-col/ion-button[starts-with(@class, 'md button')])[5]");
	private By premiumType = By.xpath("//ion-label[text()='Monthly']/following-sibling::ion-radio");
	private By loanRadioBtn = By.xpath("(//ion-label[text()='Yes']/following-sibling::ion-radio)[2]");
	private By calculate = By.xpath("(//div/ion-row/ion-col/ion-button[starts-with(@class, md)])[2]");
	private By step_2 = By.xpath("//span[normalize-space()='Step 2: Proposed Insured Information']");
	private By lic_County = By.xpath("//select[@formcontrolname='SignedCounty']");
	
	//Appointment Acknowledgement Popup
	private By appointmentAcknowledgement = By.xpath("//ion-button[normalize-space()='Yes, I acknowledge the statement above']");
	private By step1 = By.xpath("//span[.='Step 1: Product Information']");
	private By agentLicense = By.xpath("//button[@type='button']");
	private By TableOfContent_BackButton = By.xpath("//span[@title='Table of Contents']");
	
	private By insuredInfoElement = By.xpath("//h3[.='Proposed Insured Info']");
	private By impNotice_Popup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	
	public static String Randomfirstname;


	public void Product_Information(String statex) {
		
		List<String> licenseCountyList = ThreadLocalManager.getLicenseCountyList();

		WebUI.sleep(1.5);
		WebUI.clickElement(step_1);
		WebUI.sleep(1);
		WebUI.scrollToElementAtTop(insuredInfoElement);
		
		Randomfirstname = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(FirstName,Randomfirstname);
		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(FirstName,"value"),Randomfirstname);
				
//
//		String Randommiddlename = DataGenerateUtils.randomMiddleName();
//		WebUI.clearAndFillText(MiddleName,Randommiddlename);
//		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(MiddleName,"value"),Randommiddlename);
		
		WebUI.clearText(LastName);
		String randomlastname = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(LastName,randomlastname);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(LastName,"value"),randomlastname);

		WebUI.verifyElementClickable(StateDropdown);
		WebUI.clickElement(StateDropdown);
		WebUI.clickElementWithJs(StateDropdown);	
		WebUI.sleep(1);
		WebUI.clickElement(state);
		WebUI.clickElementWithJs(state);	
		WebUI.verifyContains(getAttributeElement(StateDropdown,"value"), getAttributeElement(StateDropdown,"value"));

		WebUI.selectOptionByText(genderDropdown, PropertiesHelpers.getValue("gender"));
		
		String randomDOB = DataGenerateUtils.generateRandomDOB();
		int Gen_age = DataGenerateUtils.calculateAge(randomDOB);
		WebUI.clearAndFillText(DateOfBirth,String.valueOf(randomDOB));
		WebUI.sleep(0.5);
		System.out.println(randomDOB);
//		WebUI.setText(DateOfBirth, PropertiesHelpers.getValue("date_Of_Birth"));
		
		WebUI.verifyElementClickable(signedStateDropdown);
		WebUI.selectOptionByValue(signedStateDropdown, statex);
		WebUI.sleep(0.5);
		String selectedState = WebUI.getAttributeElement(signedStateDropdown, "value");
		WebUI.logInfoMessage("********** Selected State: "+selectedState + " **********");
		
		if(selectedState.equalsIgnoreCase("FL"))
		{
			WebUI.selectOptionByText(lic_County, licenseCountyList.get(ThreadLocalManager.getLicCountyIndex()) );
			WebUI.sleep(1);
			WebUI.logInfoMessage("********** Selected License County For Florida: "+licenseCountyList.get(ThreadLocalManager.getLicCountyIndex())+ " **********");
			System.out.println("********** Selected License County For Florida: "+licenseCountyList.get(ThreadLocalManager.getLicCountyIndex())+ " **********");
		}

		WebUI.verifyElementClickable(preferredlanguage);
		WebUI.clickElement(preferredlanguage);
		WebUI.clickElementWithJs(preferredlanguage);
		WebUI.sleep(1);
		WebUI.clickElement(language);
		
		WebUI.clickElementWithJs(language);
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.verifyElementVisible(calculate);

		WebUI.verifyElementClickable(plan);
		WebUI.clickElementWithJs(plan);
		WebUI.sleep(0.5);
		WebUI.selectOptionByIndex(plan, 2);
		ThreadLocalManager.setPlanNumber(2);
		WebUI.sleep(2);
		
		//For Notice Popup
		try {
			DriverManager.getDriver().findElement(impNotice_Popup).isDisplayed();
			WebUI.sleep(0.5);
			WebUI.clickElement(impNotice_Popup);
			
		}catch(Exception ex)
		{
			System.out.println("Notice Popup Did Not Appear for Guaranteed Issue. "+ex.getMessage());
		}
		WebUI.clickElementWithJs(calculate);
		WebUI.sleep(1);
		WebUI.clearText(FaceAmount);
		WebUI.sleep(0.5);
		int fAmountGenerated = DataGenerateUtils.generateFaceAmountBasedOnAge(Gen_age);
		WebUI.clearAndFillText(FaceAmount,String.valueOf(fAmountGenerated));
		WebUI.sleep(0.5);
		System.out.println(fAmountGenerated);
		WebUI.verifyContains(getAttributeElement(FaceAmount,"value"),String.valueOf(fAmountGenerated));

		WebUI.verifyElementClickable(Annually);
		WebUI.clickElement(Annually);
		
		WebUI.verifyElementClickable(Semi_Annually);
		WebUI.clickElement(Semi_Annually);
		
		WebUI.verifyElementClickable(Quarterly);
		WebUI.clickElement(Quarterly);
		
		WebUI.verifyElementClickable(Monthly);
		WebUI.clickElement(Monthly);
		
		WebUI.verifyElementClickable(Yes);
		WebUI.clickElement(Yes);
		WebUI.verifyElementClickable(No);
		WebUI.clickElement(No);
		WebUI.clickElement(calculate);
		
		WebUI.moveToElement(Nextstep_1);
		WebUI.sleep(0.5);
		WebUI.clickElementWithJs(Nextstep_1);
		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(step_2);
	}
	
	public void Product_Information() {
		
		List<String> licensedStatesList = ThreadLocalManager.getLicenseStateList();
		List<String> licenseCountyList = ThreadLocalManager.getLicenseCountyList();
		WebUI.sleep(1);
		WebUI.scrollToElementAtTop(insuredInfoElement);
		
		Randomfirstname = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(FirstName,Randomfirstname);
		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(FirstName,"value"),Randomfirstname);
				

//		String Randommiddlename = DataGenerateUtils.randomMiddleName();
//		WebUI.clearAndFillText(MiddleName,Randommiddlename);
//		WebUI.sleep(0.5);
//		WebUI.verifyContains(getAttributeElement(MiddleName,"value"),Randommiddlename);
		
		WebUI.clearText(LastName);
		String randomLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(LastName,randomLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(LastName,"value"),randomLastName);

		WebUI.verifyElementClickable(StateDropdown);
		WebUI.clickElement(StateDropdown);
		WebUI.clickElementWithJs(StateDropdown);	
		WebUI.sleep(1);
		WebUI.clickElement(state);
		WebUI.clickElementWithJs(state);	
		
		WebUI.verifyContains(getAttributeElement(StateDropdown,"value"), getAttributeElement(StateDropdown,"value"));

		WebUI.selectOptionByText(genderDropdown, PropertiesHelpers.getValue("gender"));

		String randomDOB = DataGenerateUtils.generateRandomDOB();
		int Gen_age = DataGenerateUtils.calculateAge(randomDOB);
		WebUI.clearAndFillText(DateOfBirth,String.valueOf(randomDOB));
		WebUI.sleep(0.5);
		System.out.println(randomDOB);
		WebUI.sleep(0.5);
		WebUI.verifyElementClickable(signedStateDropdown);
		
		int countryCount = 1;
		for(int i=0; i < licensedStatesList.size(); i++)
		{
			try {
				
			Select sel = new Select(WebUI.getWebElement(signedStateDropdown));
			WebUI.sleep(1);
			ThreadLocalManager.setLicStateIndex(i);
			ThreadLocalManager.setLicCountyIndex(i);
			
			System.out.println("State ******************************************************: "+licensedStatesList.get(i));
			WebUI.logInfoMessage("********** Selected State: "+ licensedStatesList.get(i) +" **********");
			WebUI.logInfoMessage("********** Selected State Number: "+ 1 +" **********");
			sel.selectByValue(licensedStatesList.get(i));
			WebUI.sleep(1);
			
			if(licensedStatesList.get(i).equalsIgnoreCase("FL"))
			{
				WebUI.selectOptionByText(lic_County, licenseCountyList.get(i) );
				WebUI.logInfoMessage("********** Selected License County For Florida: "+licenseCountyList.get(i)+ " **********");
				System.out.println("********** Selected License County For Florida: "+licenseCountyList.get(i)+ " **********");
			}
			
			WebUI.verifyElementClickable(preferredlanguage);
			WebUI.clickElement(preferredlanguage);
			WebUI.clickElementWithJs(preferredlanguage);
			WebUI.sleep(1);
			WebUI.clickElement(language);
			
			WebUI.clickElementWithJs(language);
			WebUI.scrollToElementAtBottom(calculate);
			WebUI.verifyElementVisible(calculate);

			WebUI.verifyElementClickable(plan);
			WebUI.clickElementWithJs(plan);
			WebUI.sleep(0.5);
			WebUI.selectOptionByIndex(plan, 2);
			WebUI.sleep(2);
			
			//For Notice Popup
			try {
				DriverManager.getDriver().findElement(impNotice_Popup).isDisplayed();
				WebUI.sleep(0.5);
				WebUI.clickElement(impNotice_Popup);
				
			}catch(Exception ex)
			{
				System.out.println("Notice Popup Did Not Appear for Guaranteed Issue. "+ex.getMessage());
			}
			
			WebUI.clickElementWithJs(calculate);
			WebUI.sleep(1);
			WebUI.clearText(FaceAmount);
			WebUI.sleep(0.5);
			int fAmountGenerated = DataGenerateUtils.generateFaceAmountBasedOnAge(Gen_age);
			WebUI.clearAndFillText(FaceAmount,String.valueOf(fAmountGenerated));
			WebUI.sleep(0.5);
			System.out.println(fAmountGenerated);
			WebUI.verifyContains(getAttributeElement(FaceAmount,"value"),String.valueOf(fAmountGenerated));

			WebUI.verifyElementClickable(Annually);
			WebUI.clickElement(Annually);
			WebUI.sleep(0.2);
			
			WebUI.verifyElementClickable(Semi_Annually);
			WebUI.clickElement(Semi_Annually);
			WebUI.sleep(0.2);
			
			WebUI.verifyElementClickable(Quarterly);
			WebUI.clickElement(Quarterly);
			WebUI.sleep(0.2);
			
			WebUI.verifyElementClickable(Monthly);
			WebUI.clickElement(Monthly);
			WebUI.sleep(0.2);
			
			WebUI.verifyElementClickable(Yes);
			WebUI.clickElement(Yes);
			WebUI.sleep(0.2);
			WebUI.verifyElementClickable(No);
			WebUI.clickElement(No);
			WebUI.sleep(0.2);
			WebUI.clickElement(calculate);
			WebUI.sleep(0.2);
			WebUI.moveToElement(Nextstep_1);
			WebUI.clickElement(Nextstep_1);
			WebUI.waitForPageLoaded();
			WebUI.sleep(1);
			
				try {
						DriverManager.getDriver().findElement(step_2).isDisplayed();
						WebUI.sleep(1);
//						WebUI.clickElement(step1);
//						WebUI.sleep(1);
						
				}
				catch(Exception ex1)
				{
					try {
						DriverManager.getDriver().findElement(appointmentAcknowledgement).isDisplayed();
						WebUI.verifyElementVisible(appointmentAcknowledgement);
						WebUI.clickElement(appointmentAcknowledgement);
						WebUI.sleep(0.5);
						WebUI.clickElement(agentLicense);
						WebUI.sleep(0.2);
						WebUI.clickElement(TableOfContent_BackButton);
					}
					catch(Exception ex2)
					{
						try {
							DriverManager.getDriver().findElement(agentLicense).isDisplayed();
							WebUI.verifyElementVisible(agentLicense);
							WebUI.clickElement(agentLicense);
							WebUI.sleep(0.2);
							WebUI.clickElement(TableOfContent_BackButton);
						}
						catch(Exception ex3)
						{
							System.out.println("No popup found: "+ ex3.getMessage());
						}
					}
				}

			}
			catch(Exception ex)
			{
				System.out.println("-------------------------------------------------");
				System.out.println("No State found in Dropdown"+ licensedStatesList.get(i));
				System.out.println("-------------------------------------------------");
				continue;
			}
			
			countryCount++;
			
			if(countryCount==2)
				break;
		}
		
		WebUI.sleep(1);
		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(step_2);

	}
}



