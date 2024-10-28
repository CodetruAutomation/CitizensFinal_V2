package com.codetru.project.cica.pages.policyPaymentsModule;

import static com.codetru.keywords.WebUI.getAttributeElement;
import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.utils.DataGenerateUtils;

public class PolicyPaymentModule {
	private By policyPaymentTittle=By.xpath("//ion-title[.='Policy Payment']");
	private By policyNumberField=By.xpath("//ion-label[.='Policy Number ']/parent::ion-item/parent::ion-col");
	private By InsuredNamberField=By.xpath("//ion-label[.='Insured Name ']/parent::ion-item/parent::ion-col");
	private By paidToDateField=By.xpath("//ion-label[.='Paid To Date ']/parent::ion-item/parent::ion-col");
	private By relationshipField=By.xpath("//ion-label[.=' Relationship']/parent::ion-item/parent::ion-col");
	private By paymentTypeField=By.xpath("//ion-label[.=' Payment Type']/parent::ion-item/parent::ion-col");
	private By amountField=By.xpath("//ion-label[.='Amount in US$ ']/parent::ion-item/parent::ion-col");
	private By addAnotherPaymentBtn=By.xpath("//ion-button[text()='Add Another Payment']");
	private By chevronArrowUp=By.xpath("//ion-icon[@aria-label='chevron up outline']");
	private By chevronArrowDown=By.xpath("//ion-icon[@aria-label='chevron down outline']");
	private By policyNumberInput=By.xpath("//ion-input[@formcontrolname='PolicyNumber']/input");
	private By insuredName=By.xpath("//ion-input[@formcontrolname='InsuredName']/input");
	private By paidToDate=By.xpath("//ion-label[text()='Paid To Date ']/following-sibling::ion-input/input");
	private By err_msg_policyNumber=By.xpath("//ion-input[@formcontrolname='PolicyNumber']/parent::ion-item/following-sibling::div/div/p");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");
	private By reportsBtn=By.xpath("//ion-button[text()=' Reports ']");
	private By renewalPremium=By.xpath("//ion-item[text()=' Renewal Premium Report ']");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By reccurringPolicy=By.xpath("//*[text()=' Policy is currently on recurring payment. ']");
	private By policypaymentBtn=By.xpath("//ion-button[text()=' Policy Payment ']");
	private By policySearchBtn=By.xpath("//ion-icon[@name='search']/parent::ion-button");
	private By policyNotFound=By.xpath("//h2[text()='Active Policy Not Found']/parent::div");
	private By ok_btn=By.xpath("//span[.='Ok']");
	private By validData=By.xpath("//ion-col[contains(text(), 'Policy Number')]/parent::ion-row");
	private By policyHeader=By.xpath("//ion-col[contains(text(), 'Policy Number')]");
	private By recurringPolicy=By.xpath("//ion-col[text()=' Policy is currently on recurring payment. ']");
	private By relationDropdown=By.xpath("//ion-label[text()=' Relationship']/following-sibling::select");
	private By relationshipDropdownValues=By.xpath("//select[@formcontrolname='Relationship']/option");
	private By nullValuePayment=By.xpath("//select[@formcontrolname='PaymentType']/option[1]");
	private By nullValueRelation=By.xpath("//select[@formcontrolname='Relationship']/option[1]");
	private By selectPremium=By.xpath("//option[text()='Premium']");
	private By parent=By.xpath("//option[text()='Parent ']");	
	private By selected=By.xpath("//select[@formcontrolname='Relationship']");
	private By paymentType=By.xpath("//select[@formcontrolname='PaymentType']");
	private By paymentDropdown=By.xpath("//select[@formcontrolname='PaymentType']/option");
	private By err_msg_relation=By.xpath("//select[@formcontrolname='Relationship']/parent::ion-item/following-sibling::div/div");
	private By err_msg_premium=By.xpath("//select[@formcontrolname='PaymentType']/parent::ion-item/following-sibling::div");
	private By no_ofPremiumsToPay=By.xpath("//ion-input[@formcontrolname='NumberOfPayments']/parent::ion-item");
	private By modePremium=By.xpath("//ion-input[@formcontrolname='ModePremium']/parent::ion-item");
	private By modePremiumValue=By.xpath("//ion-input[@formcontrolname='ModePremium']/input");
	private By noofPremiumsToPayValue=By.xpath("//ion-input[@formcontrolname='NumberOfPayments']/input");
	private By amountInput=By.xpath("//ion-input[@formcontrolname='Amount']/input");
	private By err_msg_noofPremiumsToPay=By.xpath("//ion-input[@formcontrolname='NumberOfPayments']/parent::ion-item/following-sibling::div/div/p");
	private By errMsgAmount=By.xpath("//ion-input[@formcontrolname='Amount']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By nullErrMsgAmount=By.xpath("//ion-input[@formcontrolname='Amount']/parent::ion-item/following-sibling::div/div");
	private By othersPaymentType=By.xpath("//select[@formcontrolname='PaymentType']/option[text()='Other']");
	private By trashBtn=By.xpath("//ion-icon[@name='trash']/parent::ion-button");
	private By totalAmount=By.xpath("(//ion-col[contains(text(), 'Amount in')])[last()]");
	private By firstTotalAmount=By.xpath("(//ion-col[contains(text(), 'Amount in')])[1]");
	private By transactionalAmount=By.xpath("//ion-col/following-sibling::ion-col/h2");
	private By nxtBtn=By.xpath("//ion-button[text()='Next ']");
	private By nxtBtn2=By.xpath("(//ion-button[text()='Next '])[2]");
	private By desclaimerBox=By.xpath("//app-payment-disclaimer[@class='ion-page']");
	private By Disclaimeryes = By.xpath("//ion-checkbox[@formcontrolname='disclaimerYes']");
	private By paymentAlert=By.xpath("//h2[text()='Recurring Payment is Active.']/ancestor::div");
	private By paymentAlertcancelBtn=By.xpath("//span[text()='Cancel']");
	private By paymentAlertNextBtn=By.xpath("//span[text()='Next']");
	private By closeBtn=By.xpath("//ion-button[text()='Close ']");
	private By offFailed=By.xpath("//td[text()='Off-Failed']/preceding-sibling::td/a");
	//Billing Information Page
	private By backArrow=By.xpath("//ion-back-button");
	private By billingInformationPage=By.xpath("//h3[text()='Billing Information']/parent::div");
	private By successSymbolPayment=By.xpath("//ion-label[text()='Payment Information ']/preceding-sibling::ion-icon[@color='success' and @name='checkmark-circle']");
	private By preferncesBlock=By.xpath("//h3[text()='Payment Preferences']/parent::div");
	private By creditCardRadioBtn=By.xpath("//ion-label[text()='Credit Card ']/parent::ion-item/ion-radio");
	private By achRadioBtn=By.xpath("//ion-label[text()='ACH (Automated Clearing House) ']/parent::ion-item/ion-radio");
	private By accountTypeField=By.xpath("//ion-label[text()='Account Type ']");
	private By accountNumberField=By.xpath("//ion-label[text()='Account Number ']");
	private By routingNumberField=By.xpath("//ion-label[text()='Routing Number ']");
	private By nxtBtnInBillingInfoPage=By.xpath("//ion-button[text()='Next']");
	private By errMsgAccountType=By.xpath("//ion-label[text()='Account Type ']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By errMsgAccountNumber=By.xpath("//ion-label[text()='Account Number ']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By errMsgRoutingNumber=By.xpath("//ion-label[text()='Routing Number ']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By selectAccountType=By.xpath("//select[@formcontrolname='AccountType']");
	private By checkingType=By.xpath("//select[@formcontrolname='AccountType']/option[text()=' Checking ']");
	private By savingsType=By.xpath("//select[@formcontrolname='AccountType']/option[text()=' Savings ']");
	private By accountNumberInput=By.xpath("//ion-input[@formcontrolname='AccountNumber']/input");
	private By routingNumberInput=By.xpath("//ion-input[@formcontrolname='RoutingNumber']/input");
	private By billingFirstName = By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/input");
	private By billingLastName = By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/input");
	private By billingEmailAddress = By.xpath("//ion-input[@formcontrolname='Email']/input");
	private By billingPhoneNumber = By.xpath("//ion-input[@formcontrolname='Phone']/input");
	private By billingCountry = By.xpath("//select[@formcontrolname='Country']");
	private By billingState = By.xpath("//select[@formcontrolname='State']");
	private By billingCityAndRegion = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By billingStreetAddress = By.xpath("//ion-input[@formcontrolname='StreetAddress']/input");
	private By billingZipCode = By.xpath("//ion-input[@formcontrolname='Zip']/input");
	private By billingNotes = By.xpath("//ion-input[@formcontrolname='Notes']/input");
	private By err_firstName=By.xpath("//ion-input[@formcontrolname='CardHolderFirstName']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_lastName=By.xpath("//ion-input[@formcontrolname='CardHolderLastName']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_streetAddress=By.xpath("//ion-input[@formcontrolname='StreetAddress']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_city=By.xpath("//ion-input[@formcontrolname='City']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_zipcode=By.xpath("//ion-input[@formcontrolname='Zip']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_phone=By.xpath("//ion-input[@formcontrolname='Phone']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_email=By.xpath("//ion-input[@formcontrolname='Email']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By err_state=By.xpath("//select[@formcontrolname='State']/parent::ion-item/following-sibling::div/div[@class='errormsg']");
	private By arkansas=By.xpath("//option[text()=' Arkansas']");
	private By emptyValue=By.xpath("(//select[@formcontrolname='State']/option)[1]");
	private By transactionalTotalBilling=By.xpath("(//ion-col/following-sibling::ion-col/h2)[2]");
	private By someErrosMsg=By.xpath("//div[text()='There are some errors on this page. Please correct before continuing.']");
	private By makeAnotherpaymentBtn=By.xpath("//ion-button[text()='Make Another Payment ']");
	private By india=By.xpath("//option[text()=' INDIA']");
	//CreditCardPayment
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
	private By mail_box = By.id("ReceiptEmail");
	private By send_btn = By.xpath("//input[@name='sendReceipt']");
	private By email_field = By.id("login");
	private By submit = By.id("refreshbut");
	private By email_from =By.xpath("(//span[contains(text(),'Citizensinc.com')])");
	private By reciept = By.xpath("//a[@title='Receipt.pdf']");
	private By email_inbox = By.xpath("(//span[contains(text(),'Citizensinc.com')])");
	private By cardnumbertickMark=By.xpath("//label[@id='cardNumberLabel']/span[@alt='✔']");
	private By cardNumberCrossMark=By.xpath("//label[@id='cardNumberLabel']/span[@class='validity-indicator invalid icon icon-cross']");
	private By cardNametickMark=By.xpath("//label[@id='cardholderNameLabel']/span[@alt='✔']");
	private By cardNameCrossMark=By.xpath("//label[@id='cardholderNameLabel']/span[@class='validity-indicator invalid icon icon-cross']");
	private By expiryDatetickMark=By.xpath("//label[@id='expiryMonthLabel']/span[@alt='✔']");
	private By expiryDateCrossMark=By.xpath("//label[@id='expiryMonthLabel']/span[@class='validity-indicator invalid icon icon-cross']");
	private By securityCodetickMark=By.xpath("//label[@id='securityCodeLabel']/span[@alt='✔']");
	private By securityCodeCrossMark=By.xpath("//label[@id='securityCodeLabel']/span[@class='validity-indicator invalid icon icon-cross']");
	private By cancelBtn=By.id("cancelButton");
	private By reccuringPolicyNumberInreports=By.xpath("//td[text()='Yes']/preceding-sibling::td/a");
	private By reccurringCol=By.xpath("//th[.=' Recurring ']");
	private By validPolicyNumbers = By.xpath("//td[text()='']/preceding-sibling::td/a");
	private By searchingSpinner = By.xpath("//div[text()='Searching...']");
	

	public static String PolicyNumber;

	public void Make_a_Payment() throws Exception {

		String firstpolicy_number = null ;
		String thirdPolicyNumber=null;
		String one="1";
		String secondPolicyNumber=null;
		String invalidMaxAccountNumber="7412036589741256398";
		String expectedMaxErr="The maximum number of characters is 17.";
		String expectedMaxErrRoutingNumber="The maximum number of characters is 9.";
		String validAccNum = "4099999992";            
		String validRoutingNum = "011075150";
		String expectedMinErrRoutingNumber="The minimum number of characters is 8.";
		String Max_Name = "PaymentasdfgaedfsdfgwSEDFGASDFGBASDFGBASDFGASDFGBASDFGSADF1234sdfsghdsfghjdfgh2345";
		String max50chars= "sadfgsadfgsadfghasfgasdfghsadfgasdfghsadfghsdafghjasdfgn";
		String Max_error_70 ="The maximum number of characters is 70.";
		String Max_error_50 ="The maximum number of characters is 50.";
		String unitedstates="US";
		String Mandatory_Err = "Please enter a value.";
		String billing_Max_Name = "qwertyuiopasdfghj";
		String billing_Max_Name_Err = "The maximum number of characters is 15.";
		String billing_numeric_Err = "Enter aphabets only";
		String billing_max_city_Err = "The maximum number of characters is 40.";
		String billing_Zip_Format_Err = "Please use a number format.";
		String billing_Zip_Min_Char_Err = "The minimum number of characters is 5.";
		String billing_Zip_Max_Char_Err = "The maximum number of characters is 10.";
		String billing_Ph_Format_Err = "Please use a number format.";
		String billing_Ph_Min_Char_Err = "The minimum number of characters is 10.";
		String billing_Ph_Max_Char_Err = "The maximum number of characters is 10.";
		String billing_Email_Format_Err = "Email is not in the correct format";
		String billing_Invalid_Card_Err = "Enter a valid card number";
		String billing_Card_Holder_Name_Err = "Enter a valid cardholder's name";
		String billing_Card_Month_Err = "Enter a valid month";
		String billing_Card_Year_Err = "Enter a valid year";
		String billing_Card_PastYear_Err = "Expiry date must be in the future";
		String billing_Card_SecuCode_Err = "Enter a valid security code";
		String billing_Pin_Hint = "Last 3 digits on the back of card";
		String billing_Pin_Hint_Front = "4 digits on the front of card";
		String errorMsgInvalidPolicyNumber="Policy Number must be validated by searching.";
		String invalidEmailErrMsg="You have entered an invalid email address!";
		String fifty="50";
		String cicaOrgPolicyNumber="7205000014";
		String reccurringPolicyNum = null;


		WebUI.verifyElementVisible(policyPaymentTittle);
		WebUI.verifyElementVisible(policyNumberField);
		WebUI.verifyElementVisible(InsuredNamberField);
		WebUI.verifyElementVisible(paidToDateField);
		WebUI.verifyElementVisible(relationshipField);
		WebUI.verifyElementVisible(paymentTypeField);
		WebUI.verifyElementVisible(amountField);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.verifyElementVisible(desclaimerBox);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn2);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(err_msg_policyNumber);
		WebUI.verifyElementVisible(err_msg_premium);
		WebUI.verifyElementVisible(err_msg_relation);
		WebUI.verifyElementVisible(errMsgAmount);
		WebUI.clickElement(chevronArrowUp);
//		WebUI.verifyElementNotPresent(policyNumberField);
		WebUI.clickElement(chevronArrowDown);
		WebUI.sleep(2);
		WebUI.setText(policyNumberInput, "qwer7412!!@0");
		WebUI.sleep(1);
		WebUI.verifyElementVisible(policyHeader);
		WebUI.verifyElementVisible(err_msg_policyNumber);
		WebUI.clearTextCtrlA(policyNumberInput);
		WebUI.verifyElementPresent(err_msg_policyNumber);
		WebUI.setText(policyNumberInput, "2200007217");
		WebUI.verifyElementVisible(err_msg_policyNumber);
		WebUI.verifyEquals(WebUI.getTextElement(err_msg_policyNumber).trim(), errorMsgInvalidPolicyNumber);	
		//*** If we trying to search the cica org policy number in Alligent org, error message should be display*** 
		//		WebUI.sleep(2);
		//		WebUI.clearAndFillText(policyNumberInput, cicaOrgPolicyNumber);
		//		WebUI.clickElement(policySearchBtn);
		//		WebUI.verifyElementVisible(policyNotExist);
		WebUI.sleep(2);
		WebUI.clearAndFillText(policyNumberInput, "2200001053");
		WebUI.clickElement(policySearchBtn);
		WebUI.verifyElementVisible(policyNotFound);
		WebUI.clickElement(ok_btn);
		WebUI.sleep(2);
		WebUI.clickElement(reportsBtn);
		WebUI.clickElementWithJs(renewalPremium);
		WebUI.sleep(1);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		List<String> policies=WebUI.getListElementsText(offFailed);
		System.out.println(policies);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(4);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenation);
		WebUI.sleep(2);

		WebUI.scrollToElementAtBottom(reccuringPolicyNumberInreports);
		WebUI.clickElement(reccurringCol);
		for(int i=1;i<=10; i++) {
			try {
				DriverManager.getDriver().findElement(reccuringPolicyNumberInreports).isDisplayed();
				break;
			}catch (Exception e) {
				WebUI.clickElement(reccurringCol);
			}
		}
		WebUI.sleep(2);
		reccurringPolicyNum=WebUI.getTextElement(reccuringPolicyNumberInreports);
		WebUI.sleep(2);
		WebUI.clickElement(policypaymentBtn);
		WebUI.clearAndFillText(policyNumberInput, reccurringPolicyNum);
		WebUI.sleep(3);
		WebUI.clickElement(policySearchBtn);
		WebUI.sleep(4);
		WebUI.verifyElementVisible(validData);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(paymentAlertcancelBtn);
		String reccurringMyName= WebUI.getAttributeElement(insuredName, "value");
		WebUI.validateElementContainsData(reccurringMyName);
		//	WebUI.verifyElementNotEditable(insuredName); //it should not be editable since it is auto-populated field
		String reccurringDate= WebUI.getAttributeElement(paidToDate, "value");
		WebUI.validateElementContainsData(reccurringDate);
		WebUI.verifyElementVisible(recurringPolicy);
//		WebUI.verifyElementEnabled(paidToDate);
		WebUI.isValidDateFormat(reccurringDate);
		WebUI.clickElement(addAnotherPaymentBtn);
		String reccurringDate2= WebUI.getAttributeElement(paidToDate, "value");
	//	WebUI.verifyNotEquals(reccurringDate, reccurringDate2); //It shouldnt be equal
		WebUI.clickElement(trashBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(chevronArrowDown);
		WebUI.clickElement(relationDropdown);
		WebUI.verifyElementVisible(relationshipDropdownValues);
		WebUI.clickElement(parent);
		WebUI.clickElement(relationDropdown);
		WebUI.clickElement(nullValueRelation);
		WebUI.verifyElementVisible(err_msg_relation);
		WebUI.clickElement(relationDropdown);
		WebUI.getTextElement(parent);
		WebUI.clickElement(parent);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(selectPremium);	
		WebUI.clickElement(nxtBtn);
		WebUI.verifyElementVisible(paymentAlert);
		WebUI.verifyElementVisible(paymentAlertcancelBtn);
		WebUI.verifyElementVisible(paymentAlertNextBtn);
		WebUI.clickElement(paymentAlertcancelBtn);
		WebUI.verifyElementNotVisible(paymentAlert);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(paymentAlertNextBtn);
		WebUI.verifyElementVisible(desclaimerBox);
		WebUI.verifyElementVisible(closeBtn);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(paymentAlertNextBtn);
		WebUI.clickElement(nxtBtn2);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(paymentAlertNextBtn);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn2);
		WebUI.sleep(2);
		//Billing Information Page
		WebUI.clickElement(backArrow);
		WebUI.sleep(2);				
		WebUI.clickElement(reportsBtn);
		WebUI.clickElementWithJs(renewalPremium);
		WebUI.sleep(1);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(2);
		List<String> validPolicies=WebUI.getListElementsText(validPolicyNumbers);
		System.out.println("Valid Policies Count "+validPolicies.size());
		WebUI.clickElement(policypaymentBtn);
		for (String number : validPolicies) {
			firstpolicy_number=number;
			WebUI.clearAndFillText(policyNumberInput, firstpolicy_number);
			break;
		}
		WebUI.clickElement(policySearchBtn);
		WebUI.sleep(2);
		WebUI.verifyElementNotVisible(policyNotFound);
		WebUI.verifyElementNotVisible(reccurringPolicy);

		WebUI.verifyElementVisible(validData);
		String myname= WebUI.getAttributeElement(insuredName, "value");
		WebUI.validateElementContainsData(myname);
		String date= WebUI.getAttributeElement(paidToDate, "value");
		WebUI.validateElementContainsData(date);
//		WebUI.verifyElementEnabled(paidToDate);
		WebUI.isValidDateFormat(date);
		WebUI.clickElement(relationDropdown);
		WebUI.verifyElementVisible(relationshipDropdownValues);
		WebUI.clickElement(parent);
		WebUI.clickElement(relationDropdown);
		WebUI.clickElement(nullValueRelation);
		WebUI.verifyElementVisible(err_msg_relation);
		WebUI.clickElement(relationDropdown);
		WebUI.getTextElement(parent);
		WebUI.clickElement(parent);
		String selectedOption=WebUI.getAttributeElement(selected, "value");
		System.out.println(selectedOption);
		WebUI.verifyEquals(WebUI.getTextElement(parent), selectedOption);
		WebUI.clickElement(paymentType);
		WebUI.verifyElementVisible(paymentDropdown);
		WebUI.clickElement(selectPremium);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(nullValuePayment);
		WebUI.verifyElementVisible(err_msg_premium);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(selectPremium);
		WebUI.verifyElementVisible(modePremium);
		WebUI.verifyElementVisible(no_ofPremiumsToPay);
		String modepremiumValue=WebUI.getAttributeElement(modePremiumValue, "value");
		WebUI.validateElementContainsData(modepremiumValue);
		WebUI.verifyElementNotEditable(modePremiumValue);
		String noofPremiumValue=WebUI.getAttributeElement(noofPremiumsToPayValue, "value");
		System.out.println(noofPremiumValue);
		WebUI.verifyEquals(one, noofPremiumValue);
		WebUI.verifyElementEditable(noofPremiumsToPayValue);
		WebUI.setText(noofPremiumsToPayValue, "6");
		WebUI.clearTextCtrlA(noofPremiumsToPayValue);
		WebUI.setText(noofPremiumsToPayValue, "10");
		WebUI.verifyElementVisible(err_msg_noofPremiumsToPay);
		WebUI.clearAndFillText(noofPremiumsToPayValue, "six");
		WebUI.verifyElementVisible(amountInput);
		WebUI.verifyEquals(WebUI.getAttributeElement(amountInput, "value"), "NaN");
		WebUI.verifyElementVisible(errMsgAmount);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(othersPaymentType);
		WebUI.verifyElementNotVisible(modePremium);
		WebUI.verifyElementNotVisible(no_ofPremiumsToPay);
		WebUI.verifyElementEditable(amountInput);
		WebUI.clearAndFillText(amountInput, "25001");
		WebUI.verifyElementVisible(errMsgAmount);
		WebUI.clearAndFillText(amountInput, "qwerty");
		WebUI.clearText(amountInput);
		WebUI.verifyElementVisible(nullErrMsgAmount);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(selectPremium);
		WebUI.clearAndFillText(noofPremiumsToPayValue, "3");
		String premiumvalue=WebUI.getAttributeElement(noofPremiumsToPayValue, "value");
		double premiumvalueNumber=Double.parseDouble(premiumvalue);
		String modevalue=WebUI.getAttributeElement(modePremiumValue, "value");
		System.out.println(modevalue);
		double modevalueNumber=Double.parseDouble(modevalue);
		System.out.println(modevalueNumber);
		double total=premiumvalueNumber*modevalueNumber;
		String amountUsValue=WebUI.getAttributeElement(amountInput, "value");
		double  amountUsValueNumber=Double.parseDouble(amountUsValue);
		System.out.println(amountUsValueNumber);
		WebUI.verifyEquals(total, amountUsValueNumber);
		WebUI.clickElement(addAnotherPaymentBtn);
		WebUI.verifyElementNotVisible(err_msg_policyNumber);
		WebUI.clickElement(trashBtn);
		WebUI.clickElement(addAnotherPaymentBtn);
		for ( String policyNumber1: validPolicies) {
			if(policyNumber1.equals(firstpolicy_number)) {
				continue;
			}else {
				WebUI.setText(policyNumberInput, policyNumber1);
				WebUI.sleep(2);
				WebUI.clickElement(policySearchBtn);
			}
			try{
				DriverManager.getDriver().findElement(policyNotFound).isDisplayed();
				WebUI.clickElement(ok_btn);
				WebUI.clearText(policyNumberInput);
				continue;
			}catch (Exception e) {
				System.out.println(policyNumber1+" Is a valid Polid Policy Number");
				secondPolicyNumber=policyNumber1;
				break;
			}
		}
		String date2= WebUI.getAttributeElement(paidToDate, "value");
//		WebUI.verifyNotEquals(date, date2);  //Both dates should not be equal
		WebUI.clickElement(relationDropdown);
		WebUI.clickElement(parent);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(selectPremium);
		String firsttext=	WebUI.getTextElement(firstTotalAmount);
		double firstTextamount=	WebUI.roundOf(firsttext);
		System.out.println(firstTextamount);
		String text=	WebUI.getTextElement(totalAmount);
		double amount=	WebUI.roundOf(text);
		System.out.println(amount);
		double totalAmount=WebUI.roundOfDouble(amount+firstTextamount);
		System.out.println(totalAmount);
		String transAmount=	WebUI.getTextElement(transactionalAmount);
		double transactionalTotal=	WebUI.roundOf(transAmount);
		WebUI.verifyEquals(transactionalTotal, totalAmount);
		WebUI.clickElement(nxtBtn);
		WebUI.sleep(2);

		WebUI.verifyElementVisible(desclaimerBox);
		WebUI.verifyElementVisible(closeBtn);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(nxtBtn2);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn2);
		WebUI.sleep(2);
		//Billing Information Page
		WebUI.clickElement(backArrow);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(addAnotherPaymentBtn);
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn2);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(successSymbolPayment);
		WebUI.verifyElementVisible(preferncesBlock);
		WebUI.verifyElementVisible(billingInformationPage);
		WebUI.verifyElementVisible(creditCardRadioBtn);
		WebUI.verifyElementVisible(achRadioBtn);
		WebUI.clickElement(achRadioBtn);
		WebUI.verifyElementVisible(accountNumberField);
		WebUI.verifyElementVisible(accountTypeField);
		WebUI.verifyElementVisible(routingNumberField);
		WebUI.clickElement(nxtBtnInBillingInfoPage);
		WebUI.scrollToElementAtTop(preferncesBlock);
		WebUI.verifyElementVisible(errMsgAccountNumber);
		WebUI.verifyElementVisible(errMsgAccountType);
		WebUI.verifyElementVisible(errMsgRoutingNumber);
		WebUI.clickElement(selectAccountType);
		WebUI.verifyElementVisible(checkingType);
		WebUI.verifyElementVisible(savingsType);
		WebUI.clickElement(savingsType);
		WebUI.clickElement(selectAccountType);
		WebUI.clickElement(checkingType);
		WebUI.setText(accountNumberInput, invalidMaxAccountNumber);
		WebUI.verifyEquals(WebUI.getTextElement(errMsgAccountNumber).trim(), expectedMaxErr);
		WebUI.clearAndFillText(accountNumberInput, validAccNum);
		String routingNumber = DataGenerateUtils.randomPhoneNumber();
		WebUI.setText(routingNumberInput, routingNumber);
		WebUI.verifyEquals(WebUI.getTextElement(errMsgRoutingNumber).trim(), expectedMaxErrRoutingNumber);
		String zipcode=DataGenerateUtils.randomZipCode();
		WebUI.clearAndFillText(routingNumberInput, zipcode);
		WebUI.verifyEquals(WebUI.getTextElement(errMsgRoutingNumber).trim(), expectedMinErrRoutingNumber);
		WebUI.clearAndFillText(routingNumberInput, validRoutingNum);
		WebUI.scrollToElementAtBottom(nxtBtnInBillingInfoPage);
		WebUI.verifyElementVisible(billingFirstName);
		WebUI.verifyElementVisible(billingLastName);
		WebUI.verifyElementVisible(billingStreetAddress);
		WebUI.verifyElementVisible(billingCityAndRegion);
		WebUI.verifyElementVisible(billingCountry);
		WebUI.verifyElementVisible(billingZipCode);
		WebUI.verifyElementVisible(billingPhoneNumber);
		WebUI.verifyElementVisible(billingEmailAddress);
		WebUI.verifyElementVisible(billingNotes);
		WebUI.clickElement(nxtBtnInBillingInfoPage);
		WebUI.verifyElementVisible(err_firstName);
		WebUI.verifyElementVisible(err_lastName);
		WebUI.verifyElementVisible(err_streetAddress);
		WebUI.verifyElementVisible(err_city);
		WebUI.verifyElementVisible(err_state);
		WebUI.verifyElementVisible(err_phone);
		WebUI.verifyElementVisible(err_email);
		WebUI.verifyElementVisible(err_zipcode);
		WebUI.scrollToElementAtBottom(someErrosMsg);
		WebUI.verifyElementVisible(someErrosMsg);
		WebUI.scrollToElementAtTop(billingFirstName);
		WebUI.setText(billingFirstName, billing_Max_Name);
		WebUI.verifyEquals(WebUI.getTextElement(err_firstName).trim(), billing_Max_Name_Err);
		//		WebUI.setText(billingFirstName, "52364");              //User should be able to see error message 
		//		WebUI.verifyEquals(WebUI.getTextElement(err_firstName).trim(), billing_numeric_Err);
		WebUI.clearTextCtrlA(billingFirstName);
		WebUI.verifyEquals(WebUI.getTextElement(err_firstName), Mandatory_Err );



		WebUI.setText(billingLastName, Max_Name);
		WebUI.verifyEquals(WebUI.getTextElement(err_lastName).trim(), Max_error_70);
		//		WebUI.setText(billingLastName, "52364");                  //User should be able to see error message 
		//		WebUI.verifyEquals(WebUI.getTextElement(err_firstName).trim(), billing_numeric_Err);
		WebUI.clearTextCtrlA(billingLastName);
		WebUI.verifyEquals(WebUI.getTextElement(err_lastName), Mandatory_Err );

		WebUI.setText(billingCityAndRegion, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_city).trim(), billing_max_city_Err);
		//		WebUI.setText(billingCityAndRegion, "52364");                //User should be able to see error message 
		//		WebUI.verifyEquals(WebUI.getTextElement(err_city).trim(), billing_numeric_Err);
		WebUI.clearTextCtrlA(billingCityAndRegion);
		WebUI.verifyEquals(WebUI.getTextElement(err_city), Mandatory_Err );

		WebUI.setText(billingStreetAddress, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_streetAddress).trim(), Max_error_50);
		WebUI.clearTextCtrlA(billingStreetAddress);
		WebUI.verifyEquals(WebUI.getTextElement(err_streetAddress), Mandatory_Err );

		WebUI.clickElement(billingState);
		WebUI.clickElement(arkansas);
		WebUI.clickElement(billingState);
		WebUI.clickElement(emptyValue);
		WebUI.verifyEquals(WebUI.getTextElement(err_state), Mandatory_Err);
		WebUI.clickElement(billingState);
		WebUI.clickElement(arkansas);
		WebUI.setText(billingNotes, "This is the ACH payment");
		WebUI.setText(billingZipCode, "14523698702");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Max_Char_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.setText(billingZipCode, "1236");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Min_Char_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.setText(billingZipCode, "sdf%@");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Format_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode), billing_Zip_Format_Err );

		String countryName=WebUI.getAttributeElement(billingCountry, "value");
		WebUI.validateElementContainsData(countryName);
		WebUI.verifyEquals(countryName, unitedstates);

		WebUI.setText(billingPhoneNumber, "14523698702");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Max_Char_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.setText(billingPhoneNumber, "1236");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Min_Char_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.setText(billingPhoneNumber, "sdfds@#$");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Format_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.verifyEquals(WebUI.getTextElement(err_phone), billing_Ph_Format_Err );

		WebUI.setText(billingEmailAddress, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_email).trim(), Max_error_50);
		WebUI.clearTextCtrlA(billingEmailAddress);
		WebUI.setText(billingEmailAddress, "sdfds@gmail");
		WebUI.verifyEquals(WebUI.getTextElement(err_email).trim(), billing_Email_Format_Err);
		WebUI.clearTextCtrlA(billingEmailAddress);
		WebUI.verifyEquals(WebUI.getTextElement(err_email), Mandatory_Err );
		String RandomBillingFirstName = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(billingFirstName,RandomBillingFirstName);
		String RandomBillinglastName = DataGenerateUtils.randomLastName();
		WebUI.clearAndFillText(billingLastName,RandomBillinglastName);
		String RandombillingAddress=DataGenerateUtils.randomStreetName();
		WebUI.setText(billingStreetAddress, RandombillingAddress);
		String Randombillingcity=DataGenerateUtils.randomCity();
		WebUI.setText(billingCityAndRegion, Randombillingcity);
		String RandomZipcode=DataGenerateUtils.randomZipCode();
		WebUI.setText(billingZipCode, RandomZipcode);
		String RandomPhnNumber=DataGenerateUtils.randomPhoneNumber();
		WebUI.setText(billingPhoneNumber, RandomPhnNumber);
		String RandomEmail=DataGenerateUtils.randomEmail();
		WebUI.setText(billingEmailAddress, RandomEmail);
		String billingtotal=WebUI.getTextElement(transactionalTotalBilling);
		WebUI.verifyEquals(WebUI.roundOf(billingtotal), transactionalTotal);
		WebUI.clickElement(nxtBtnInBillingInfoPage);
		WebUI.sleep(5);

		WebUI.clickElement(makeAnotherpaymentBtn);
		WebUI.sleep(3);
		//Credit Card Payment
		WebUI.clickElement(trashBtn);
		WebUI.clickElement(chevronArrowDown);

		WebUI.setText(policyNumberInput, secondPolicyNumber);
		WebUI.sleep(2);
		WebUI.clickElement(policySearchBtn);
		try{
			if(DriverManager.getDriver().findElement(policyNotFound).isDisplayed()){
				WebUI.clickElement(ok_btn);
			}
			else {
				WebUI.verifyElementIncurrentPage(reccurringPolicy);

			}
			WebUI.clearText(policyNumberInput);

		}catch (Exception e) {
			System.out.println(secondPolicyNumber+" Is a valid Polid Policy Number");
			thirdPolicyNumber=secondPolicyNumber;
		}

		System.out.println(thirdPolicyNumber);
		WebUI.clickElement(policySearchBtn);
		WebUI.clickElement(relationDropdown);
		WebUI.clickElement(parent);
		WebUI.clickElement(paymentType);
		WebUI.clickElement(selectPremium);
		WebUI.setText(noofPremiumsToPayValue, "2");
		WebUI.clickElement(nxtBtn);
		WebUI.clickElement(Disclaimeryes);
		WebUI.clickElement(nxtBtn2);
		WebUI.clickElement(creditCardRadioBtn);
		WebUI.scrollToElementAtBottom(nxtBtnInBillingInfoPage);
		WebUI.verifyElementVisible(billingFirstName);
		WebUI.verifyElementVisible(billingLastName);
		WebUI.verifyElementVisible(billingStreetAddress);
		WebUI.verifyElementVisible(billingCityAndRegion);
		WebUI.verifyElementVisible(billingCountry);
		WebUI.verifyElementVisible(billingZipCode);
		WebUI.verifyElementVisible(billingPhoneNumber);
		WebUI.verifyElementVisible(billingEmailAddress);
		WebUI.verifyElementVisible(billingNotes);
		WebUI.clickElement(nxtBtnInBillingInfoPage);
		WebUI.verifyElementVisible(err_firstName);
		WebUI.verifyElementVisible(err_lastName);
		WebUI.verifyElementVisible(err_streetAddress);
		WebUI.verifyElementVisible(err_city);
		WebUI.verifyElementVisible(err_state);

		WebUI.verifyElementVisible(err_phone);
		WebUI.verifyElementVisible(err_email);
		WebUI.verifyElementVisible(err_zipcode);
		WebUI.scrollToElementAtBottom(someErrosMsg);
		WebUI.verifyElementVisible(someErrosMsg);
		WebUI.scrollToElementAtTop(billingFirstName);
		WebUI.setText(billingFirstName, billing_Max_Name);
		WebUI.verifyEquals(WebUI.getTextElement(err_firstName).trim(), billing_Max_Name_Err);
		WebUI.clearTextCtrlA(billingFirstName);
		WebUI.verifyEquals(WebUI.getTextElement(err_firstName), Mandatory_Err );

		WebUI.setText(billingLastName, Max_Name);
		WebUI.verifyEquals(WebUI.getTextElement(err_lastName).trim(), Max_error_70);
		WebUI.clearTextCtrlA(billingLastName);
		WebUI.verifyEquals(WebUI.getTextElement(err_lastName), Mandatory_Err );

		WebUI.setText(billingCityAndRegion, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_city).trim(), billing_max_city_Err);
		WebUI.clearTextCtrlA(billingCityAndRegion);
		WebUI.verifyEquals(WebUI.getTextElement(err_city), Mandatory_Err );

		WebUI.setText(billingStreetAddress, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_streetAddress).trim(), Max_error_50);
		WebUI.clearTextCtrlA(billingStreetAddress);
		WebUI.verifyEquals(WebUI.getTextElement(err_streetAddress), Mandatory_Err );

		WebUI.clickElement(billingState);
		WebUI.clickElement(arkansas);
		WebUI.clickElement(billingState);
		WebUI.clickElement(emptyValue);
		WebUI.verifyEquals(WebUI.getTextElement(err_state), Mandatory_Err);
		WebUI.clickElement(billingState);
		WebUI.clickElement(arkansas);

		WebUI.clickElement(billingCountry);
		WebUI.sleep(1);
		WebUI.clickElement(india);

		WebUI.setText(billingZipCode, "14523698702");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Max_Char_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.setText(billingZipCode, "1236");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Min_Char_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.setText(billingZipCode, "sdf%@");
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode).trim(), billing_Zip_Format_Err);
		WebUI.clearTextCtrlA(billingZipCode);
		WebUI.verifyEquals(WebUI.getTextElement(err_zipcode), billing_Zip_Format_Err );

		WebUI.setText(billingPhoneNumber, "14523698702");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Max_Char_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.setText(billingPhoneNumber, "1236");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Min_Char_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.setText(billingPhoneNumber, "sdfds@#$");
		WebUI.verifyEquals(WebUI.getTextElement(err_phone).trim(), billing_Ph_Format_Err);
		WebUI.clearTextCtrlA(billingPhoneNumber);
		WebUI.verifyEquals(WebUI.getTextElement(err_phone), billing_Ph_Format_Err );

		WebUI.setText(billingEmailAddress, max50chars);
		WebUI.verifyEquals(WebUI.getTextElement(err_email).trim(), Max_error_50);
		WebUI.clearTextCtrlA(billingEmailAddress);
		WebUI.setText(billingEmailAddress, "sdfds@gmail");
		WebUI.verifyEquals(WebUI.getTextElement(err_email).trim(), billing_Email_Format_Err);
		WebUI.clearTextCtrlA(billingEmailAddress);
		WebUI.verifyEquals(WebUI.getTextElement(err_email), Mandatory_Err );
		WebUI.setText(billingNotes, "This is the Credit card payment");

		WebUI.clearAndFillText(billingFirstName,RandomBillingFirstName);
		WebUI.clearAndFillText(billingLastName,RandomBillinglastName);
		WebUI.setText(billingStreetAddress, RandombillingAddress);
		WebUI.setText(billingCityAndRegion, Randombillingcity);
		WebUI.setText(billingZipCode, RandomZipcode);
		WebUI.setText(billingPhoneNumber, RandomPhnNumber);

		WebUI.setText(billingEmailAddress, RandomEmail);
		WebUI.clickElement(nxtBtnInBillingInfoPage);
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);
		WebUI.switchToFrameByIndex(0);
		WebUI.sleep(1);

		WebUI.verifyElementVisible(CardNumber);
		WebUI.verifyElementVisible(cardHolderName);
		WebUI.verifyElementVisible(ExpiryMonth);
		WebUI.verifyElementVisible(ExpiryYear);
		WebUI.verifyElementVisible(SecurityCode);
		WebUI.verifyElementVisible(cancelBtn);
		WebUI.clearText(CardNumber);

		WebUI.setText(CardNumber, "123456567");
		WebUI.clickElement(cardHolderName);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(cardNumberCrossMark);
		WebUI.verifyElementVisible(Error_CardNumber);
		WebUI.verifyContains(WebUI.getTextElement(Error_CardNumber).trim(), billing_Invalid_Card_Err);
		WebUI.sleep(1);

		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.clearText(CardNumber);
		WebUI.setText(CardNumber, "5555555555554444124541");
		WebUI.clickElement(cardHolderName);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(cardNumberCrossMark);
		WebUI.verifyElementVisible(Error_CardNumber);
		WebUI.verifyContains(getTextElement(Error_CardNumber).trim(), billing_Invalid_Card_Err);
		WebUI.sleep(1);

		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(1);
		WebUI.clickElement(cardHolderName);
		WebUI.verifyElementVisible(cardnumbertickMark);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value").replace(" ", "").trim(), PropertiesHelpers.getValue("billing_Card_No"));

		WebUI.clickElement(CardNumber);
		WebUI.verifyContains(getTextElement(Error_CardHoldername).trim(), billing_Card_Holder_Name_Err);
		WebUI.sleep(1);

		WebUI.clearText(cardHolderName);
		WebUI.setText(cardHolderName, "12451232");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(cardNameCrossMark);
		WebUI.verifyElementVisible(Error_CardHoldername);
		WebUI.verifyContains(getTextElement(Error_CardHoldername).trim(), billing_Card_Holder_Name_Err);
		WebUI.sleep(1);

		WebUI.clearAndFillText(cardHolderName, PropertiesHelpers.getValue("billing_CardHolder_Name"));
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.verifyElementVisible(cardNametickMark);
		WebUI.verifyContains(getAttributeElement(cardHolderName, "value"), PropertiesHelpers.getValue("billing_CardHolder_Name"));

		WebUI.clickElement(ExpiryMonth);
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(expiryDateCrossMark);
		WebUI.verifyElementVisible(Error_ExpiryMonth);
		WebUI.verifyContains(getTextElement(Error_ExpiryMonth).trim(), billing_Card_Month_Err);
		WebUI.sleep(1);

		WebUI.clickElement(CardNumber);
		WebUI.clearAndFillText(ExpiryMonth, "13");
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.verifyElementVisible(expiryDateCrossMark);
		WebUI.verifyElementVisible(Error_ExpiryMonth, 2);
		WebUI.verifyContains(getTextElement(Error_ExpiryMonth).trim(), billing_Card_Month_Err);
		WebUI.sleep(1);

		WebUI.clearAndFillText(ExpiryMonth, PropertiesHelpers.getValue("billing_Card_Exp_Mn"));
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(ExpiryMonth, "value"), PropertiesHelpers.getValue("billing_Card_Exp_Mn"));

		WebUI.clickElement(ExpiryYear);
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(expiryDateCrossMark);
		WebUI.verifyElementVisible(Error_ExpiryYear);
		WebUI.verifyContains(getTextElement(Error_ExpiryYear).trim(), billing_Card_Year_Err);
		WebUI.sleep(1);

		WebUI.clearText(ExpiryYear);
		WebUI.setText(ExpiryYear, "23");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(expiryDateCrossMark);
		WebUI.verifyElementVisible(Error_ExpiryYear);
		WebUI.verifyContains(getTextElement(Error_ExpiryYear).trim(), billing_Card_PastYear_Err);
		WebUI.sleep(1);

		WebUI.clickElement(CardNumber);
		WebUI.clearAndFillText(ExpiryYear, PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.verifyElementVisible(expiryDatetickMark);
		WebUI.verifyContains(getAttributeElement(ExpiryYear, "value").trim(), PropertiesHelpers.getValue("billing_Card_Exp_Yr"));
		WebUI.sleep(1);

		WebUI.clearText(SecurityCode);
		WebUI.setText(SecurityCode, "12");
		WebUI.clickElement(CardNumber);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(securityCodeCrossMark);
		WebUI.verifyElementVisible(Error_SecurityCode);
		WebUI.verifyContains(getTextElement(Error_SecurityCode).trim(), billing_Card_SecuCode_Err);
		WebUI.sleep(1);

		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(1);
		WebUI.clickElement(CardNumber);
		WebUI.verifyElementVisible(securityCodetickMark);
		WebUI.verifyContains(getAttributeElement(SecurityCode, "value").trim(), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(1);

		WebUI.verifyContains(getTextElement(SecurityCode_PInHintVisa_Master).trim(), billing_Pin_Hint);
		WebUI.sleep(1);

		WebUI.clearText(CardNumber);
		WebUI.setText(CardNumber, "371449635398431");
		WebUI.clickElement(SecurityCode);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(SecurityCode_PInHintVisa_Master);
		WebUI.verifyContains(getTextElement(SecurityCode_PInHintVisa_Master).trim(), billing_Pin_Hint_Front);
		WebUI.sleep(1);

		WebUI.clearAndFillText(CardNumber, PropertiesHelpers.getValue("billing_Card_No"));
		WebUI.sleep(1);
		WebUI.verifyContains(getAttributeElement(CardNumber, "value"), PropertiesHelpers.getValue("billing_Card_No"));
//		WebUI.verifyElementNotEnabled(MakePayment);         //Untill and unless enter the security code Make Payment button shouldnt be Enabled
		WebUI.sleep(1);
		WebUI.clickElement(SecurityCode);
		WebUI.clearAndFillText(SecurityCode, PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(1);

		WebUI.verifyContains(getAttributeElement(SecurityCode, "value").trim(), PropertiesHelpers.getValue("billing_Card_Security_Code"));
		WebUI.sleep(1);

		WebUI.clickElement(MakePayment);
		WebUI.sleep(3);
		

	}
	
}
