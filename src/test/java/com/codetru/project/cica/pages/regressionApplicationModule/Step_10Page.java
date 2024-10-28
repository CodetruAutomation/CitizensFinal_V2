package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;

import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;

public class Step_10Page extends CommonPageCICA {
	
	private By makePaymentStep = By.xpath("//span[contains(text(),'Make a Payment')]");
	private By nextButton = By.xpath("//ion-button[normalize-space()='Next']");
	private By nextButton_PolicyPayment = By.xpath("//ion-button[normalize-space()='Next']");
	private By nxtBtn = By.xpath("(//ion-col/ion-button[@size='small' and @color='primary'])[1]");
	private By Disclaimeryes = By.xpath("//ion-checkbox[@formcontrolname='disclaimerYes']");
	private By Error_PolicyPayment_Relationship = By.xpath("//ion-label[.=' Relationship']/parent::ion-item/following-sibling::div[.=' Please enter a value. ']");
	private By ErrorMessage_PolicyPayment_PaymentType = By.xpath("//select[@formcontrolname='PaymentType']/parent::ion-item/parent::ion-col");
	private By RelationShipDropDown = By.xpath("//select[@formcontrolname='Relationship']");
	private By RelationShip_Parent = By.xpath("//option[.='Parent ']");
	private By PaymentType = By.xpath("//select[@formcontrolname='PaymentType']");
	private By PaymentType_premium = By.xpath("//option[.='Premium']");
	private By NextBtn_BillingPage = By.xpath("//h3[.='Billing Information']/parent::div/following::ion-row/ion-col[@size='20' and @size-md='20']/ion-row[@size='24']/ion-col/ion-button");
	private By Error_FormOfPayment = By.xpath("(//h3[.='Payment Preferences']/following-sibling::ion-row/ion-col[@size='24'])[1]");
	private By CreditCard = By.xpath("//ion-radio-group[@formcontrolname='PaymentMethod']/descendant::ion-label[.='Credit Card ']/following-sibling::ion-radio");
	private By Error_ReccuringPayemtns = By.xpath("(//h3[.='Payment Preferences']/following-sibling::ion-row/ion-col[@size='24'])[2]");
	private By Reccuring_CheckBox = By.xpath("//ion-checkbox[@formcontrolname='IsAppPaymentRecurring']");
	private By billingInfoSection = By.xpath("//h3[.='Billing Information']");
	private By Error_BillignFirstName = By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/parent::ion-item/parent::ion-col");
	private By BillingFirstName = By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/input");
	private By Error_BillignLastName = By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/parent::ion-item/parent::ion-col");
	private By BillingLastName = By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/input");
	private By billingZipCode = By.xpath("//ion-input[@formcontrolname='Zip']/input");
	private By Error_BillignStreetAddress = By.xpath("//ion-input[@formcontrolname='StreetAddress']/parent::ion-item/parent::ion-col");
	private By billingStreetAddress = By.xpath("//ion-input[@formcontrolname='StreetAddress']/input");
	private By Error_BillignCityAndRegion = By.xpath("//ion-input[@formcontrolname='City']/parent::ion-item/parent::ion-col");
	private By billingCityAndRegion = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By Error_BillignState = By.xpath("//select[@formcontrolname='State']/parent::ion-item/parent::ion-col");
	private By billingState = By.xpath("//select[@formcontrolname='State']");
//	private By StateSelection = By.xpath("//option[.=' Arkansas']");
	private By Error_BillignZipCode = By.xpath("//ion-input[@formcontrolname='Zip']/parent::ion-item/parent::ion-col");
	private By Error_BillignCountry = By.xpath("//select[@formcontrolname='Country']/parent::ion-item/parent::ion-col");
	private By billingCountry = By.xpath("//select[@formcontrolname='Country']");
	private By billingCountrySelection = By.xpath("//option[.=' COLOMBIA']");
	private By Error_BillignPhoneNumber = By.xpath("//ion-input[@formcontrolname='Phone']/parent::ion-item/parent::ion-col");
	private By BillingPhoneNumber = By.xpath("//ion-input[@formcontrolname='Phone']/input");
	private By Error_BillignEmailAddress = By.xpath("//ion-input[@formcontrolname='Email']/parent::ion-item/parent::ion-col");
	private By BillingEmailAddress = By.xpath("//ion-input[@formcontrolname='Email']/input");
	private By CardNumber = By.xpath("//input[@name='cardNumber']");
	private By cardHolderName = By.id("cardholderName");
	private By Error_CardNumber = By.id("cardNumber-hint");
	private By Error_CardHoldername = By.id("cardholderName-hint");
	private By ExpiryMonth = By.id("expiryMonth");
	private By Error_ExpiryMonth = By.id("expiryDate-hint");
	private By ExpiryYear = By.id("expiryYear");
	private By Error_ExpiryYear = By.id("expiryDate-hint");
	private By SecurityCode = By.id("securityCode");
	private By Error_SecurityCode = By.id("securityCode-hint");
	private By SecurityCode_PInHintVisa_Master = By.id("pin-helptxt");
	private By MakePayment = By.id("submitButton");
	private By mail_Id = By.xpath("//input[@id='ReceiptEmail']");
	private By send_btn = By.xpath("//input[@name='sendReceipt']");
	private By email_field = By.id("login");
	private By submit = By.id("refreshbut");
	private By email_from =By.xpath("(//span[contains(text(),'Citizensinc.com')])");
	private By reciept = By.xpath("//a[@title='Receipt.pdf']");
	private By email_inbox = By.xpath("(//span[contains(text(),'Citizensinc.com')])");
	private By insuredPolicyNumber = By.xpath("//tbody/tr/td[1]");
	private By recurring_DateSelect = By.xpath("//select[@formcontrolname='PaymentDay']");
	private By dashboard= By.xpath("//ion-button[.=' Dashboard ']");
	
	public static String PolicyNumber;

	public void Make_a_Payment() {

		String Max_Name = "PaymentasdfgaedfsdfgwSEDFGASDFGBASDFGBASDFGASDFGBASDFGSADF1234sdfsghdsfghjdfgh2345";
		String max_name = "sadfgsadfgsadfghasfgasdfghsadfgasdfghsadfghsdafghjasdfgn";
		String Max_error_70 ="The maximum number of characters is 70";
		String Max_error_50 ="The maximum number of characters is 50";
		String Mandatory_Err = "Please enter a value.";
		String billing_FMax_Name = "qwertyuiopasdfghj";
		String billing_FMax_Name_Err = "The maximum number of characters is 15.";
		String billing_City_Max_Err = "The maximum number of characters is 40.";
		String billing_Zip_Format_Err = "Please use a number format.";
		String billing_Zip_Min_Char_Err = "The minimum number of characters is 5.";
		String billing_Zip_Max_Char_Err = "The maximum number of characters is 10.";
		String billing_Ph_Format_Err = "Please use a number format.";
		String billing_Ph_Min_Char_Err = "The minimum number of characters is 10.";
		String billing_Ph_Max_Char_Err = "The maximum number of characters is 10.";
		String billing_Email_Format_Err = "Email is not in the correct format";
		String billing_Email_Max_Char_Err = "The maximum number of characters is 50.";
		String billing_Invalid_Card_Err = "Enter a valid card number";
		String billing_Card_Holder_Name_Err = "Enter a valid cardholder's name";
		String billing_Card_Month_Err = "Enter a valid month";
		String billing_Card_Year_Err = "Enter a valid year";
		String billing_Card_PastYear_Err = "Expiry date must be in the future";
		String billing_Card_SecuCode_Err = "Enter a valid security code";
		String billing_Pin_Hint = "Last 3 digits on the back of card";
		String billing_Pin_Hint_Front = "4 digits on the front of card";
		String openFile_CSSLocator = "return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-item').shadowRoot.querySelector('div>div>div>a')";

		WebUI.sleep(2);
		WebUI.clickElementWithJs(makePaymentStep);
		WebUI.sleep(3);
		WebUI.clickElement(nextButton);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(nxtBtn);
		WebUI.sleep(0.2);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn);
		WebUI.verifyElementPresent(Error_PolicyPayment_Relationship);
		WebUI.verifyElementVisible(ErrorMessage_PolicyPayment_PaymentType);
		WebUI.clickElement(RelationShipDropDown);
		WebUI.clickElement(RelationShip_Parent);
		WebUI.clickElement(PaymentType);
		WebUI.clickElement(PaymentType_premium);
		WebUI.sleep(1);
		WebUI.clickElement(nextButton);
		WebUI.scrollToElementAtBottom(nxtBtn);
		WebUI.sleep(1);
		WebUI.clickElement(Disclaimeryes);
		WebUI.sleep(1);
		WebUI.clickElement(nxtBtn);
		WebUI.sleep(3);
		
		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.sleep(1);
		WebUI.clickElement(NextBtn_BillingPage);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(Error_FormOfPayment);
		WebUI.verifyElementVisible(Error_FormOfPayment);
		
		WebUI.clickElement(CreditCard);
		WebUI.sleep(1);
		
		if(ThreadLocalManager.getFlag()==1)
		{
			WebUI.logInfoMessage("********** Credit Card Payment. No Recurring. **********");
			WebUI.scrollToElementAtBottom(Error_ReccuringPayemtns);
			WebUI.verifyElementVisible(Error_ReccuringPayemtns);

			WebUI.sleep(1.5);
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

		WebUI.scrollToElementAtTop(billingInfoSection);
		WebUI.verifyElementVisible(Error_BillignFirstName);
		WebUI.verifyContains(getTextElement(Error_BillignFirstName).trim(), Mandatory_Err);
		
		WebUI.clearAndFillText(BillingFirstName, billing_FMax_Name);
		WebUI.sleep(0.5);
		WebUI.moveToElement(Error_BillignFirstName);
		WebUI.verifyElementVisible(Error_BillignFirstName, 1);
		WebUI.verifyContains(getTextElement(Error_BillignFirstName), billing_FMax_Name_Err);
			
		String randomBillingFirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(BillingFirstName,randomBillingFirstName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingFirstName,"value"),randomBillingFirstName);
		
		WebUI.scrollToElementAtBottom(Error_BillignLastName);
		WebUI.verifyElementVisible(Error_BillignLastName, 2);
		WebUI.verifyContains(getTextElement(Error_BillignLastName), Mandatory_Err);

		WebUI.clearAndFillText(BillingLastName, Max_Name);
		WebUI.sleep(0.5);
		WebUI.moveToElement(billingZipCode);
		WebUI.verifyElementVisible(billingZipCode,2);
		WebUI.moveToElement(Error_BillignLastName);
		WebUI.verifyContains(getTextElement(Error_BillignLastName), Max_error_70);
		WebUI.sleep(0.5);
		
		String randomBillingLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(BillingLastName,randomBillingLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingLastName,"value"),randomBillingLastName);
		
		WebUI.scrollToElementAtBottom(Error_BillignStreetAddress);
		WebUI.verifyElementVisible(Error_BillignStreetAddress, 2);
		WebUI.verifyContains(getTextElement(Error_BillignStreetAddress), Mandatory_Err);

		
		WebUI.clearText(billingStreetAddress);
		WebUI.setText(billingStreetAddress, max_name);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignStreetAddress);
		WebUI.verifyContains(getTextElement(Error_BillignStreetAddress).trim(), Max_error_50);

		
		String randomBillingAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(billingStreetAddress,randomBillingAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingStreetAddress,"value"),randomBillingAddress);
		
		WebUI.scrollToElementAtBottom(Error_BillignCityAndRegion);
		WebUI.verifyElementVisible(Error_BillignCityAndRegion, 2);
		WebUI.verifyContains(getTextElement(Error_BillignCityAndRegion).trim(), Mandatory_Err);

	
		WebUI.clearText(billingCityAndRegion);
		WebUI.setText(billingCityAndRegion, max_name);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignCityAndRegion);
		WebUI.verifyContains(getTextElement(Error_BillignCityAndRegion).trim(), billing_City_Max_Err);
		
		String randomBillingCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(billingCityAndRegion,randomBillingCity);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(billingCityAndRegion,"value"),randomBillingCity);
		
		WebUI.scrollToElementAtBottom(Error_BillignState);
		WebUI.verifyElementVisible(Error_BillignState);
		WebUI.verifyContains(getTextElement(Error_BillignState).trim(), Mandatory_Err);
	
		WebUI.verifyElementClickable(billingState);
		WebUI.clickElement(billingState);
		WebUI.sleep(0.5);
//		WebUI.clickElement(StateSelection);
		WebUI.selectOptionByIndex(billingState, 1);

		WebUI.scrollToElementAtBottom(Error_BillignZipCode);
		WebUI.verifyElementVisible(Error_BillignZipCode, 2);
		WebUI.verifyContains(getTextElement(Error_BillignZipCode).trim(), Mandatory_Err);

		WebUI.clearAndFillText(billingZipCode, "asdfasd");
		WebUI.sleep(0.5);
		WebUI.moveToElement(Error_BillignZipCode);
		WebUI.verifyElementVisible(Error_BillignZipCode, 1);
		WebUI.verifyContains(getTextElement(Error_BillignZipCode).trim(), billing_Zip_Format_Err);
		
		WebUI.clearText(billingZipCode);
		WebUI.setText(billingZipCode, "1234");
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignZipCode);
		WebUI.verifyContains(getTextElement(Error_BillignZipCode).trim(), billing_Zip_Min_Char_Err);
	
		WebUI.clearText(billingZipCode);
		WebUI.setText(billingZipCode, "5478415114155211");
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignZipCode);
		WebUI.verifyContains(getTextElement(Error_BillignZipCode).trim(), billing_Zip_Max_Char_Err);

		String randomBillingZipcode = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(billingZipCode,randomBillingZipcode);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingZipCode,"value"),randomBillingZipcode);

		WebUI.scrollToElementAtBottom(Error_BillignCountry);
		WebUI.verifyElementVisible(Error_BillignCountry, 2);
		WebUI.verifyContains(getTextElement(Error_BillignCountry).trim(), Mandatory_Err);

		WebUI.verifyElementClickable(billingCountry,2);
		WebUI.clickElement(billingCountry);
		WebUI.sleep(0.5);
		WebUI.clickElement(billingCountrySelection);

		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.verifyElementVisible(NextBtn_BillingPage);

		WebUI.scrollToElementAtBottom(Error_BillignPhoneNumber);
		WebUI.verifyElementVisible(Error_BillignPhoneNumber, 2);
		WebUI.verifyContains(getTextElement(Error_BillignPhoneNumber).trim(), Mandatory_Err);

		WebUI.clearText(BillingPhoneNumber);
		WebUI.setText(BillingPhoneNumber, "sadfasdd");
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignPhoneNumber);
		WebUI.verifyContains(getTextElement(Error_BillignPhoneNumber).trim(), billing_Ph_Format_Err);
		
		WebUI.clearText(BillingPhoneNumber);
		WebUI.setText(BillingPhoneNumber, "1254812");
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignPhoneNumber);
		WebUI.verifyContains(getTextElement(Error_BillignPhoneNumber).trim(), billing_Ph_Min_Char_Err);
	
		WebUI.clearText(BillingPhoneNumber);
		WebUI.setText(BillingPhoneNumber, "125481212512");
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignPhoneNumber);
		WebUI.verifyContains(getTextElement(Error_BillignPhoneNumber).trim(), billing_Ph_Max_Char_Err);
		
		String randomBillingPhone = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(BillingPhoneNumber,randomBillingPhone);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingPhoneNumber,"value"),randomBillingPhone);
		
		WebUI.scrollToElementAtBottom(Error_BillignEmailAddress);
		WebUI.verifyElementVisible(Error_BillignEmailAddress, 2);
		WebUI.verifyContains(getTextElement(Error_BillignEmailAddress).trim(), Mandatory_Err);

		WebUI.clearText(BillingEmailAddress);
		WebUI.setText(BillingEmailAddress, "asas");
		WebUI.verifyElementVisible(Error_BillignEmailAddress);
		WebUI.verifyContains(getTextElement(Error_BillignEmailAddress).trim(), billing_Email_Format_Err);
		WebUI.sleep(0.5);

		WebUI.clearText(BillingEmailAddress);
		WebUI.setText(BillingEmailAddress, max_name);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_BillignEmailAddress);
		WebUI.verifyContains(getTextElement(Error_BillignEmailAddress).trim(), billing_Email_Max_Char_Err);

		String randomBillingEmail = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(BillingEmailAddress,randomBillingEmail);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingEmailAddress,"value"),randomBillingEmail);
		
		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.sleep(0.5);
		WebUI.waitForElementVisible(NextBtn_BillingPage);
		WebUI.sleep(1);
		WebUI.clickElement(NextBtn_BillingPage);
		WebUI.sleep(3);
		
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);

		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.clearText(CardNumber);
		WebUI.setText(CardNumber, "123456567");
		WebUI.clickElement(cardHolderName);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_CardNumber);
		WebUI.verifyContains(getTextElement(Error_CardNumber).trim(), billing_Invalid_Card_Err);
		WebUI.sleep(0.5);
		
		WebUI.clearText(CardNumber);
		WebUI.setText(CardNumber, "5555555555554444124541");
		WebUI.clickElement(cardHolderName);
		WebUI.sleep(0.4);
		WebUI.verifyElementVisible(Error_CardNumber);
		WebUI.verifyContains(getTextElement(Error_CardNumber).trim(), billing_Invalid_Card_Err);
		
		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(0.4);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value"), PropertiesHelpers.getValue("billing_Card_No"));

		WebUI.verifyContains(getTextElement(Error_CardHoldername).trim(), billing_Card_Holder_Name_Err);
		WebUI.sleep(0.5);
		WebUI.clearText(cardHolderName);
		WebUI.setText(cardHolderName, "12451232");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_CardHoldername);
		WebUI.verifyContains(getTextElement(Error_CardHoldername).trim(), billing_Card_Holder_Name_Err);
		WebUI.sleep(0.5);

		WebUI.clearAndFillText(cardHolderName, PropertiesHelpers.getValue("billing_CardHolder_Name"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(cardHolderName, "value"), PropertiesHelpers.getValue("billing_CardHolder_Name"));
	
		WebUI.clickElement(ExpiryMonth);
		WebUI.sleep(0.5);
		WebUI.clickElement(CardNumber);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_ExpiryMonth);
		WebUI.verifyContains(getTextElement(Error_ExpiryMonth).trim(), billing_Card_Month_Err);
		WebUI.sleep(0.5);
	
		WebUI.clickElement(CardNumber);
		WebUI.clearAndFillText(ExpiryMonth, "13");
		WebUI.sleep(0.5);
		WebUI.clickElement(CardNumber);
		WebUI.verifyElementVisible(Error_ExpiryMonth, 2);
		WebUI.verifyContains(getTextElement(Error_ExpiryMonth).trim(), billing_Card_Month_Err);
		WebUI.sleep(0.5);
		
		WebUI.clearAndFillText(ExpiryMonth, PropertiesHelpers.getValue("billing_Card_Exp_Mn"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ExpiryMonth, "value"), PropertiesHelpers.getValue("billing_Card_Exp_Mn"));

		WebUI.clickElement(ExpiryYear);
		WebUI.sleep(0.5);
		WebUI.clickElement(CardNumber);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_ExpiryYear);
		WebUI.verifyContains(getTextElement(Error_ExpiryYear).trim(), billing_Card_Year_Err);
		WebUI.sleep(0.5);

		WebUI.clearText(ExpiryYear);
		WebUI.setText(ExpiryYear, "23");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_ExpiryYear);
		WebUI.verifyContains(getTextElement(Error_ExpiryYear).trim(), billing_Card_PastYear_Err);

		WebUI.clickElement(CardNumber);
		WebUI.clearAndFillText(ExpiryYear, PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(ExpiryYear, "value").trim(), PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(0.5);
		
		WebUI.clearText(SecurityCode);
		WebUI.setText(SecurityCode, "12");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(Error_SecurityCode);
		WebUI.verifyContains(getTextElement(Error_SecurityCode).trim(), billing_Card_SecuCode_Err);
		WebUI.sleep(0.5);

		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(SecurityCode, "value").trim(), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);

		WebUI.verifyContains(getTextElement(SecurityCode_PInHintVisa_Master).trim(), billing_Pin_Hint);
		WebUI.clearText(CardNumber);
		WebUI.setText(CardNumber, "371449635398431");
		WebUI.clickElement(SecurityCode);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(SecurityCode_PInHintVisa_Master);
		WebUI.verifyContains(getTextElement(SecurityCode_PInHintVisa_Master).trim(), billing_Pin_Hint_Front);
		WebUI.sleep(0.5);

		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value"), PropertiesHelpers.getValue("billing_Card_No"));

		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(SecurityCode, "value").trim(), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(0.5);

		WebUI.clickElement(MakePayment);
		WebUI.waitForPageLoaded();
		WebUI.sleep(1);
		WebUI.switchToParentFrame();
		WebUI.sleep(2);
		
		//----------------------------------------------------------------------------------------------------------
		String policyDetails = WebUI.getTextElement(insuredPolicyNumber);
		System.out.println("Policy Holder Name and Policy Number: "+policyDetails);
		PolicyNumber = policyDetails.replaceAll("[^0-9]", "");
		System.out.println("Policy Number: "+PolicyNumber);
		WebUI.logInfoMessage("Policy Number: "+PolicyNumber);
		WebUI.sleep(1);
		//----------------------------------------------------------------------------------------------------------
		
		WebUI.setText(mail_Id, PropertiesHelpers.getValue("recipient_Email"));
		WebUI.sleep(1);
		
		WebUI.clickElement(send_btn);
		WebUI.sleep(3);
		WebUI.dismissAlert();
		WebUI.sleep(2);
/*		
		WebUI.openNewTab();
		WebUI.sleep(2);
		WebUI.openWebsite(PropertiesHelpers.getValue("email_URL"));
		WebUI.waitForPageLoaded(10);
		
		WebUI.setText(email_field, PropertiesHelpers.getValue("recipient_Email"));
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
			WebUI.sleep(2);
			WebUI.clickElement(email_inbox);
			WebUI.sleep(3);
			WebUI.switchToDefaultContent();
			WebUI.switchToFrameByIdOrName("ifmail");
			WebUI.sleep(1);
			WebUI.clickElement(reciept);
		}
		
		WebUI.sleep(2);
		WebUI.openNewTab();
		
		DriverManager.getDriver().get("chrome://downloads/");
		WebUI.openWebsite("chrome://downloads/");
		WebUI.sleep(2);

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		WebElement openFile = (WebElement) js.executeScript(openFile_CSSLocator);
		WebUI.sleep(1);
		openFile.click();
		WebUI.sleep(1);
		WebUI.switchToMainWindow();
		WebUI.sleep(1);
//*/
		WebUI.switchToDefaultContent();
		WebUI.sleep(1);
	
	}

}
