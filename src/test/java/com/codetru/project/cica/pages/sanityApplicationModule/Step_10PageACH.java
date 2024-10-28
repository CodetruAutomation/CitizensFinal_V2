package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ThreadLocalManager;
import com.codetru.utils.DataGenerateUtils;

public class Step_10PageACH extends CommonPageCICA {
	
	private By MakePayment_Step_9 = By.xpath("//span[contains(text(),'Make a Payment')]");
//	private By MakePayment_Step_9 = By.xpath("//span[text()='Step 11: Schedule a Payment']");
	
	private By nextButton = By.xpath("//ion-button[normalize-space()='Next']");
	private By wait_ion_padding = By.xpath("(//ion-content[contains(@class, ion-padding)])[6]");
	private By nextButton_PolicyPayment = By.xpath("//ion-button[normalize-space()='Next']");
	private By waitUntill = By.xpath("(//ion-content[contains(@class, ion-padding)])[6]");
	private By nxtBtn = By.xpath("(//ion-col/ion-button[@size='small' and @color='primary'])[1]");
	private By Disclaimeryes = By.xpath("//ion-checkbox[@formcontrolname='disclaimerYes']");
	private By Error_PolicyPayment_Relationship = By.xpath("//ion-label[.=' Relationship']/parent::ion-item/following-sibling::div[.=' Please enter a value. ']");
	private By ErrorMessage_PolicyPayment_PaymentType = By.xpath("(//ion-col[@size='24' and @size-md='8' and @class='md hydrated'])[5]");
	private By RelationShipDropDown = By.xpath("//select[@formcontrolname='Relationship']");
	private By RelationShip_Parent = By.xpath("//option[.='Parent ']");
	private By PaymentType = By.xpath("//select[@formcontrolname='PaymentType']");
	private By PaymentType_premium = By.xpath("//option[.='Premium']");
	private By NextBtn_BillingPage = By.xpath("//ion-button[@color='primary' and @size-md='8']");
	private By Error_FormOfPayment = By.xpath("(//h3[.='Payment Preferences']/following-sibling::ion-row/ion-col[@size='24'])[1]");
	private By CreditCard = By.xpath("(//ion-radio[@slot='start' and @aria-checked='false'])[1]");
	private By Error_ReccuringPayemtns = By.xpath("(//h3[.='Payment Preferences']/following-sibling::ion-row/ion-col[@size='24'])[2]");
	private By Reccuring_CheckBox = By.xpath("//ion-checkbox[@role='checkbox']");
	private By Error_BillignFirstName = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @size-md='12'])[1]");
	private By BillingFirstName = By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/input");
	private By Error_BillignLastName = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @size-md='12'])[2]");
	private By BillingLastName = By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/input");
	private By billingZipCode = By.xpath("//ion-input[@formcontrolname='Zip']/input");
	private By Error_BillignStreetAddress = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[3]");
	private By billingStreetAddress = By.xpath("//ion-input[@formcontrolname='StreetAddress']/input");
	private By Error_BillignCityAndRegion = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[4]");
	private By billingCityAndRegion = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By Error_BillignState = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[5]");
	private By billingState = By.xpath("//select[@formcontrolname='State']");
	private By StateSelection = By.xpath("//option[.=' Arkansas']");
	private By Error_BillignZipCode = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[6]");
	private By Error_BillignCountry = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[7]");
	private By billingCountry = By.xpath("//select[@formcontrolname='Country']");
	private By billingCountrySelection = By.xpath("//option[.=' COLOMBIA']");
	private By Error_BillignPhoneNumber = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[8]");
	private By BillingPhoneNumber = By.xpath("//ion-input[@formcontrolname='Phone']/input");
	private By Error_BillignEmailAddress = By.xpath("(//h3[.='Billing Information']/following-sibling::ion-row/ion-col[@size='24' and @class='md hydrated'])[9]");
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
	private By open_file = By.xpath("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-item').shadowRoot.querySelector('div>div>div>a')");
	private By recurring_DateSelect = By.xpath("//select[@formcontrolname='PaymentDay']");
 
	//-----------------------------------------------------------------------------------------------
	private By ACh = By.xpath("//ion-label[text()='ACH (Automated Clearing House) ']/following-sibling::ion-radio[@slot='start']");
	private By Error_AccountType = By.xpath("(//ion-row[@class='md hydrated']/ion-col[@size='24' and @size-md='12' and @class='md hydrated'])[2]");
	private By AccountType = By.xpath("//select[@formcontrolname='AccountType']");
	private By SavingType = By.xpath("//option[.=' Checking ']");
	private By Error_AccountNumber = By.xpath("(//ion-row[@class='md hydrated']/ion-col[@size='24' and @size-md='12' and @class='md hydrated'])[3]");
	private By AccountNumber = By.xpath("//ion-input[@formcontrolname='AccountNumber']/input");
	private By Error_RoutingNumber = By.xpath("//ion-input[@formcontrolname='RoutingNumber']/parent::ion-item/parent::ion-col");
	private By RountingNumber = By.xpath("//ion-input[@formcontrolname='RoutingNumber']/input");
	
	private By insuredPolicyNumber = By.xpath("//tbody/tr/td[1]");
	public static String PolicyNumber;

	public void Make_a_Payment() throws Exception {

		String Max_Name = "PaymentasdfgaedfsdfgwSEDFGASDFGBASDFGBASDFGASDFGBASDFGSADF1234sdfsghdsfghjdfgh2345";
		String max_name = "sadfgsadfgsadfghasfgasdfghsadfgasdfghsadfghsdafghjasdfgn";
		String Max_error_70 ="The maximum number of characters is 70";
		String Max_error_50 ="The maximum number of characters is 50";
		String Mandatory_Err = "Please enter a value.";
		String billing_FMax_Name = "qwertyuiopasdfghj";
		String billing_FMax_Name_Err = "The maximum number of characters is 15.";
		String billing_City_Max_Err = "The maximum number of characters is 40.";
		String billing_Zip_Format_Err = "Please use a number format.";
		String billing_Zip_Max_Char_Err = "The minimum number of characters is 5.";
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

		WebUI.sleep(2);
		WebUI.clickElement(MakePayment_Step_9);
		WebUI.sleep(3);
		
		WebUI.clickElement(RelationShipDropDown);
		WebUI.sleep(0.2);
		
		WebUI.clickElement(RelationShip_Parent);
		WebUI.sleep(0.2);
		
		WebUI.clickElement(PaymentType);
		WebUI.sleep(0.5);
		
		WebUI.clickElement(PaymentType_premium);
		WebUI.sleep(1);
		
		WebUI.clickElement(nextButton);
		WebUI.sleep(1.2);

		WebUI.scrollToElementAtBottom(nxtBtn);
		WebUI.sleep(1.2);
		
		WebUI.clickElement(Disclaimeryes);
		WebUI.sleep(1.2);
		WebUI.clickElement(nxtBtn);
		WebUI.sleep(2);
				
//		================================== ACH Payment =======================================================================================
		
		WebUI.clickElement(ACh);
		WebUI.sleep(1);

		WebUI.clickElement(AccountType);
		WebUI.sleep(0.5);
		WebUI.clickElement(SavingType);
		WebUI.sleep(0.5);
		
		WebUI.clearText(AccountNumber);
		WebUI.setText(AccountNumber, "4099999992");
		
		WebUI.sleep(0.5);
		WebUI.clearAndFillText(RountingNumber, "011075150");
		WebUI.sleep(0.5);		

		WebUI.scrollToElementAtBottom(Reccuring_CheckBox);
		WebUI.sleep(0.5);
		if(ThreadLocalManager.getFlag()==2)
		{
			WebUI.logInfoMessage("********** ACH Payment. No Recurring. **********");
			WebUI.clickElement(Reccuring_CheckBox);			
		}
		else
		{
			WebUI.logInfoMessage("********** ACH Payment with Recurring. **********");
			WebUI.clickElement(recurring_DateSelect);
			WebUI.sleep(0.6);
			WebUI.selectOptionByValue(recurring_DateSelect, "1");
			WebUI.sleep(0.6);
		}
			
		String RandomBillingFirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(BillingFirstName,RandomBillingFirstName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingFirstName,"value"),RandomBillingFirstName);
		
		String RandomBillingLastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(BillingLastName,RandomBillingLastName);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(BillingLastName,"value"),RandomBillingLastName);
		
		String RandomBillingAddress = DataGenerateUtils.randomShortAddress();
		WebUI.clearAndFillText(billingStreetAddress,RandomBillingAddress);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingStreetAddress,"value"),RandomBillingAddress);
		
		WebUI.scrollToElementAtBottom(billingCityAndRegion);
		WebUI.sleep(0.2);
		String RandomBillingCity = DataGenerateUtils.randomCity();
		WebUI.clearAndFillText(billingCityAndRegion,RandomBillingCity);
		WebUI.sleep(0.5);
		
		WebUI.verifyElementClickable(billingState);
		WebUI.clickElement(billingState);
		WebUI.sleep(1);
		WebUI.selectOptionByIndex(billingState, 1);
		WebUI.sleep(0.5);

		String RandomBillingZipcode = DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(billingZipCode,RandomBillingZipcode);
		WebUI.sleep(0.5);
		WebUI.verifyContains(getAttributeElement(billingZipCode,"value"),RandomBillingZipcode);

		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.verifyElementVisible(NextBtn_BillingPage);

		String RandomBillingPhone = DataGenerateUtils.randomPhoneNumber();
		WebUI.clearAndFillText(BillingPhoneNumber,RandomBillingPhone);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(BillingPhoneNumber,"value"),RandomBillingPhone);
		
		String RandomBillingEmail = DataGenerateUtils.randomEmail();
		WebUI.clearAndFillText(BillingEmailAddress,RandomBillingEmail);
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(BillingEmailAddress,"value"),RandomBillingEmail);
		
		WebUI.scrollToElementAtBottom(NextBtn_BillingPage);
		WebUI.sleep(0.5);
		WebUI.waitForElementVisible(NextBtn_BillingPage);
		WebUI.sleep(1);
		WebUI.clickElement(NextBtn_BillingPage);
		WebUI.sleep(3);
		
	}

}
