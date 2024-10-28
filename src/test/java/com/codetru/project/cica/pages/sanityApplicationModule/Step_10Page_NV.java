package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;

import org.openqa.selenium.By;

import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;

public class Step_10Page_NV extends CommonPageCICA {
	
	private By makePaymentStep = By.xpath("//span[contains(text(),'Make a Payment')]");
//	private By MakePayment_Step_9 = By.xpath("//span[text()='Step 11: Schedule a Payment']");
	
	private By nextButton = By.xpath("//ion-button[normalize-space()='Next']");
	private By nextButton_PolicyPayment = By.xpath("//ion-button[normalize-space()='Next']");
	private By nxtBtn = By.xpath("(//ion-col/ion-button[@size='small' and @color='primary'])[1]");
	private By Disclaimeryes = By.xpath("//ion-checkbox[@formcontrolname='disclaimerYes']");
	private By RelationShipDropDown = By.xpath("//select[@formcontrolname='Relationship']");
	private By RelationShip_Parent = By.xpath("//option[.='Parent ']");
	private By PaymentType = By.xpath("//select[@formcontrolname='PaymentType']");
	private By PaymentType_premium = By.xpath("//option[.='Premium']");
	private By NextBtn_BillingPage = By.xpath("//ion-button[@color='primary' and @size-md='8']");
	private By CreditCard = By.xpath("(//ion-radio[@slot='start' and @aria-checked='false'])[1]");
	private By Reccuring_CheckBox = By.xpath("//ion-checkbox[@role='checkbox']");
	private By BillingFirstName = By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/input");
	private By BillingLastName = By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/input");
	private By billingZipCode = By.xpath("//ion-input[@formcontrolname='Zip']/input");
	private By billingStreetAddress = By.xpath("//ion-input[@formcontrolname='StreetAddress']/input");
	private By billingCityAndRegion = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By billingState = By.xpath("//select[@formcontrolname='State']");
	private By StateSelection = By.xpath("//option[.=' Arkansas']");
	private By billingCountry = By.xpath("//select[@formcontrolname='Country']");
	private By billingCountrySelection = By.xpath("//option[.=' COLOMBIA']");
	private By BillingPhoneNumber = By.xpath("//ion-input[@formcontrolname='Phone']/input");
	private By BillingEmailAddress = By.xpath("//ion-input[@formcontrolname='Email']/input");
	private By CardNumber = By.xpath("//input[@name='cardNumber']");
	private By cardHolderName = By.id("cardholderName");
	private By ExpiryMonth = By.id("expiryMonth");
	private By ExpiryYear = By.id("expiryYear");
	private By SecurityCode = By.id("securityCode");
	private By MakePayment = By.id("submitButton");
	private By recurring_DateSelect = By.xpath("//select[@formcontrolname='PaymentDay']");
 
	//--------------------------------------------------------------------------------------------
	//ACH Payment Method ---------
	private By ACh = By.xpath("//ion-label[text()='ACH (Automated Clearing House) ']/following-sibling::ion-radio[@slot='start']");
	private By Error_AcountType = By.xpath("(//ion-row[@class='md hydrated']/ion-col[@size='24' and @size-md='12' and @class='md hydrated'])[2]");
	private By AcountType = By.xpath("//select[@formcontrolname='AccountType']");
	private By SavingType = By.xpath("//option[.=' Checking ']");
	private By Error_AcountNumber = By.xpath("(//ion-row[@class='md hydrated']/ion-col[@size='24' and @size-md='12' and @class='md hydrated'])[3]");
	private By AcountNumber = By.xpath("//ion-input[@formcontrolname='AccountNumber']/input");
	private By Error_RoutingNumber = By.xpath("//ion-input[@formcontrolname='RoutingNumber']/parent::ion-item/parent::ion-col");
	private By RountingNumber = By.xpath("//ion-input[@formcontrolname='RoutingNumber']/input");
	
	//-----------------------------------------------------------------------------------------------
	private By insuredPolicyNumber = By.xpath("//tbody/tr/td[1]");
	public static String PolicyNumber;
	

	public void Make_a_Payment() {

		WebUI.sleep(2);
		WebUI.clickElement(makePaymentStep);
		WebUI.sleep(2);
		
		WebUI.clickElement(RelationShipDropDown);
		WebUI.sleep(0.2);
		
		WebUI.clickElement(RelationShip_Parent);
		WebUI.sleep(0.2);
		
		WebUI.clickElement(PaymentType);
		WebUI.sleep(0.2);
		
		WebUI.clickElement(PaymentType_premium);
		WebUI.sleep(1);
		
		WebUI.clickElement(nextButton);
		WebUI.sleep(2);

		WebUI.scrollToElementAtBottom(nxtBtn);
		WebUI.sleep(1.5);
		
		WebUI.clickElement(Disclaimeryes);
		WebUI.sleep(1.5);
		WebUI.clickElement(nxtBtn);
		WebUI.sleep(2);
		
		WebUI.clickElement(CreditCard);
		WebUI.sleep(1);
		
		if(ThreadLocalManager.getFlag()==1)
		{
			WebUI.logInfoMessage("********** Credit Card Payment. No Recurring. **********");
			WebUI.clickElement(Reccuring_CheckBox);
			ThreadLocalManager.setFlag(2);
		}
		else
		{
			WebUI.logInfoMessage("********** Credit Card Payment with Recurring. **********");
			WebUI.clickElement(recurring_DateSelect);
			WebUI.sleep(0.5);
			WebUI.selectOptionByValue(recurring_DateSelect, "1");
			WebUI.sleep(0.5);
			ThreadLocalManager.setFlag(1);
		}

		String randomBillingFirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(BillingFirstName,randomBillingFirstName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingFirstName,"value"),randomBillingFirstName);

		String randomBillingLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(BillingLastName,randomBillingLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingLastName,"value"),randomBillingLastName);
		
		String randomBillingAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(billingStreetAddress,randomBillingAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingStreetAddress,"value"),randomBillingAddress);
		
		String randomBillingCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(billingCityAndRegion,randomBillingCity);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingCityAndRegion,"value"),randomBillingCity);
		
		WebUI.verifyElementClickable(billingState);
		WebUI.clickElement(billingState);
		WebUI.sleep(0.5);
		WebUI.clickElement(StateSelection);

		WebUI.scrollToElementAtBottom(billingZipCode);
		String randomBillingZipcode = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(billingZipCode,randomBillingZipcode);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingZipCode,"value"),randomBillingZipcode);

		WebUI.scrollToElementAtBottom(billingCountry);
		WebUI.verifyElementClickable(billingCountry);
		WebUI.clickElement(billingCountry);
		WebUI.sleep(0.5);
		WebUI.clickElement(billingCountrySelection);

		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.verifyElementVisible(NextBtn_BillingPage);

		String randomBillingPhone = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(BillingPhoneNumber,randomBillingPhone);
		WebUI.sleep(0.5);
		
		WebUI.scrollToElementAtBottom(BillingEmailAddress);
		String randomBillingEmail = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(BillingEmailAddress,randomBillingEmail);
		WebUI.sleep(0.5);

		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.sleep(0.5);
		WebUI.waitForElementVisible(NextBtn_BillingPage);
		WebUI.sleep(1);
		WebUI.clickElement(NextBtn_BillingPage);
		WebUI.sleep(1);
		
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);
		
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		
		
		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value"), PropertiesHelpers.getValue("billing_Card_No"));


		WebUI.clearAndFillText(cardHolderName, PropertiesHelpers.getValue("billing_CardHolder_Name"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(cardHolderName, "value"), PropertiesHelpers.getValue("billing_CardHolder_Name"));
		
		WebUI.clearAndFillText(ExpiryMonth, PropertiesHelpers.getValue("billing_Card_Exp_Mn"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ExpiryMonth, "value"), PropertiesHelpers.getValue("billing_Card_Exp_Mn"));

		WebUI.clickElement(CardNumber);
		WebUI.clearAndFillText(ExpiryYear, PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ExpiryYear, "value"), PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(0.5);

		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(SecurityCode, "value"), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(1);

		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value"), PropertiesHelpers.getValue("billing_Card_No"));

		WebUI.sleep(1);
		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(SecurityCode, "value").trim(), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);

		WebUI.clickElement(MakePayment);
		WebUI.waitForPageLoaded();
		
		WebUI.sleep(1);
		WebUI.switchToParentFrame();
		WebUI.sleep(1);
		
		//----------------------------------------------------------------------------------------------------------
		String policyDetails = WebUI.getTextElement(insuredPolicyNumber);
		System.out.println("Policy Holder Name and Policy Number: "+policyDetails);
		PolicyNumber = policyDetails.replaceAll("[^0-9]", "");
		System.out.println("Policy Number: "+PolicyNumber);
		WebUI.logInfoMessage("Policy Number: "+PolicyNumber);
		WebUI.sleep(1);
		//----------------------------------------------------------------------------------------------------------

/*
		WebUI.clearAndFillText(mail_Id, PropertiesHelpers.getValue("recipient_Email"));
		WebUI.sleep(1);
		
		WebUI.clickElement(send_btn);
		WebUI.sleep(2);
		
		WebUI.dismissAlert();
		WebUI.sleep(1);
		
		WebUI.openNewTab();
		WebUI.sleep(1);
		
		WebUI.openWebsite(PropertiesHelpers.getValue("email_URL"));
		WebUI.waitForPageLoaded(10);
		
		WebUI.clearAndFillText(email_field, PropertiesHelpers.getValue("recipient_Email"));
		
		WebUI.clickElement(submit);
		
		WebUI.switchToFrameByIdOrName("ifmail");
		
		if(WebUI.isElementVisible(email_from, 3))
		{
			WebUI.clickElement(reciept);
		}
		else
		{
			WebUI.switchToDefaultContent();
			WebUI.switchToFrameByIdOrName("ifinbox");
			WebUI.sleep(1);
			WebUI.clickElement(email_inbox);
			WebUI.sleep(1);
			WebUI.switchToDefaultContent();
			WebUI.switchToFrameByIdOrName("ifmail");
			WebUI.sleep(1);
			WebUI.clickElement(reciept);
		}
		
		WebUI.sleep(1);
		
		WebUI.openNewTab();
		
		WebUI.openWebsite("chrome://downloads/");
		WebUI.sleep(1);
		
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		
		WebElement open_file = (WebElement) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-item').shadowRoot.querySelector('div>div>div>a')");
		WebUI.sleep(2);
		open_file.click();
		WebUI.sleep(2);
		
//*/
		
	
	}

}
