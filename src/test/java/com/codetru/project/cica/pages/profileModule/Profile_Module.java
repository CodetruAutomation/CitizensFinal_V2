package com.codetru.project.cica.pages.profileModule;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;

public class Profile_Module extends CommonPageCICA{

	private By MyName = By.xpath("//ion-label[text()='My Name']/parent::ion-item");
	private By MyNameField=By.xpath("//ion-input[@formcontrolname='MyName']/input");
	//AgentNumber
	private By agentField=By.xpath("//ion-input[@formcontrolname='AgentNumber']/input");
	private By profileIcon = By.xpath("(//ion-icon[@name='person']/parent::ion-button)[2]");	
	private By Independent_Consultant = By.xpath("//ion-label[text()='Independent Consultant']/parent::ion-item");
	private By email_err_msg=By.xpath("//p[text()='Please enter a valid Email Address.']/ancestor::ion-col");
	private By EmailAddress = By.xpath("//ion-input[@formcontrolname='EmailAddress']/input");    //AddressLine1
	private By EditInformationBtn = By.xpath("//ion-button[text()='Edit Information']");
	//private By changePasswordBtn = By.xpath("//ion-button[text()='Change Password']");
	private By Savebtn = By.xpath("//ion-button[@title='Save']");
	private By Cancelbtn = By.xpath("//ion-button[@title='Cancel']");
	//AddressBlock                               
	private By adressBlock=By.xpath("//h3[text()='Address']/parent::div/ion-grid");                    //ZipCode
	private By addAddressbtn = By.xpath("//ion-button[text()='Add Address']");
	private By Address1 = By.xpath("//ion-input[@formcontrolname='AddressLine1']/input");
	private By Address1_err_msg = By.xpath("//p[text()='Please enter a valid address.']/ancestor::ion-col");
	private By Address2 = By.xpath("//ion-input[@formcontrolname='AddressLine2']/input");
	private By city = By.xpath("//ion-input[@formcontrolname='City']/input");
	private By city_err_msg = By.xpath("//ion-input[@formcontrolname='City']/parent::ion-item/following-sibling::div");
	private By state = By.xpath("//ion-input[@formcontrolname='State']/input");
	private By State_validationtext = By.xpath("//ion-input[@formcontrolname='State']/parent::ion-item/following-sibling::div");
	private By postalCode = By.xpath("//ion-input[@formcontrolname='ZipCode']/input");
	private By postalcode_validationtext = By.xpath("//ion-input[@formcontrolname='ZipCode']/parent::ion-item/following-sibling::div");
	private By country_dropdown = By.xpath("//select[@formcontrolname='Country']");
	private By checkBox = By.xpath("//ion-checkbox[@formcontrolname='IsMailing']");
	private By cancel_btn2=By.xpath("//ion-button[@title='Cancel']");
	private By cancelBtn_address=By.xpath("//div[@formarrayname='AgentAddresses']/descendant::ion-button[@title='Cancel']");
	private By SaveBtn_address = By.xpath("//div[@formarrayname='AgentAddresses']/descendant::ion-button[@title='Save']");
	private By EditBtn_address = By.xpath("//div[@formarrayname='AgentAddresses']/descendant::ion-button[@title='Edit']");
	private By DeleteBtn_address = By.xpath("//div[@formarrayname='AgentAddresses']/descendant::ion-button[@title='Delete']");
	private By delete_popup=By.xpath("//div[.='Are you sure you want to delete this address?']/parent::div");
	private By clickDelete = By.xpath("//span[.='Delete']/parent::button");
	private By clickCancel = By.xpath("//span[.='Cancel']/parent::button");
	private By country_US=By.xpath("//option[text()=' UNITED STATES']");
	private By country_Taiwan=By.xpath("//option[text()=' TAIWAN']");
	//TelephoneBlock
	private By Add_PhoneBtn = By.xpath("//ion-button[.='Add Phone']");
	private By telephoneBlock=By.xpath("//div[@formarrayname='AgentPhones']/div");
	private By TelephoneNumberText = By.xpath("//input[@placeholder='###-###-####']");
	private By telephone_dropdown = By.xpath("//select[@formcontrolname='PhoneType']");
	private By telephone_dropdownOptions = By.xpath("//select[@formcontrolname='PhoneType']/option");
	private By telephone_typeWork=By.xpath("//option[.=' Work']");
	private By telephone_typeHome=By.xpath("//option[.=' Home']");
	private By SaveBtn_telephone = By.xpath("(//ion-button[@title='Save']) | (//ion-icon[@name='save-outline'])");
	private By editBtn_telephone = By.xpath("(//ion-button[@title='Edit'])");
	private By editDuplicateTelephone = By.xpath("(//ion-button[@title='Edit'])[2]");
	private By deleteBtn_telephone = By.xpath("//ion-button[@title='Delete']");
	private By deleteDuplicateTelephone=By.xpath("(//ion-button[@title='Delete'])[2]");
	private By deletePopupTelephone=By.xpath("//div[text()='Are you sure you want to delete this phone?']/parent::div");
	private By cancelBtn_telephone = By.xpath("//ion-button[@title='Cancel']");
	private By list_Of_Countries=By.xpath("//select[@formcontrolname='Country']/option");
	//profileMenu
	private By listOfProfileMenu=By.xpath("//app-profile-menu/ion-list");
	private By licences=By.xpath("//ion-item[text()='Licenses & Appointments ']");
	private By language=By.xpath("//ion-item[text()='Language ']/div");
	private By app=By.xpath("//ion-item[text()=' Portal App Downloads ']");
	private By logout=By.xpath("//ion-item[text()=' Logout ']");
	private By dashboard= By.xpath("//ion-button[.=' Dashboard ']");
	private By wholePage=By.xpath("(//ion-popover[@aria-modal='true'])[2]");
	private By profileOption = By.xpath("//ion-item[text()='Profile ']");
	private By profilePage=By.xpath("//ion-title[text()='Profile']");
	//Add Office Assistants Block
	private By addOfficeAssistant=By.xpath("//ion-button[text()=' Add Office Assistant']");
	private By officeAssistantBlock=By.xpath("//div[@formarrayname='AgentAssistants']");
	private By lastNameInAssistants=By.xpath("(//ion-input[@formcontrolname='LastName']/input[contains(@name, 'ion-input')])[2]");
	private By firstNameInAssistants=By.xpath("(//ion-input[@formcontrolname='FirstName']/input[contains(@name, 'ion-input')])[2]");
	private By saveBtnInAssistants=By.xpath("//ion-button[@title='Save']");
	private By cancelInAssistants=By.xpath("//ion-button[@title='Cancel']");
	private By editInAssistants=By.xpath("//ion-button[@title='Edit']");
	private By deleteInAssistants=By.xpath("//ion-button[@title='Delete']");
	private By okBtn=By.xpath("//span[.='OK']");
	private By invalidOfficeAssistantPopup=By.xpath("//div[.='There was a problem validating that assistant.']/parent::div");
	private By deleteBtnPopup=By.xpath("//div[.='Are you sure you want to delete this assistant?']/parent::div");
	private By fnameerrMsgInAssistants=By.xpath("//ion-input[@formcontrolname='FirstName']/parent::ion-item/following-sibling::div");
	private By lnameerrMsgInAssistants=By.xpath("//ion-input[@formcontrolname='LastName']/parent::ion-item/following-sibling::div");
	private By duplicateDeleteInAssistants=By.xpath("//ion-button[@title='Save']/parent::ion-col/following-sibling::ion-col/ion-button[@title='Delete']");
 
	//License&Appointments
	private By licensesPage=By.xpath("//ion-title[text()='Licenses & Appointments ']");
	private By Licenses_Appointment_Data_Popup = By.xpath("//div[contains(text(),'Loading licenses and appointments data')]");
	private By profileIcon2=By.xpath("(//ion-icon[@name='person']/parent::ion-button)[1]");
	private By agentIdCol = By.xpath("//th[text()=' Agent ID ']");
	private By agentNameCol = By.xpath("//th[text()=' Agent Name ']");
	private By levelCol = By.xpath("//th[text()=' Level ']");
	private By managerIdCol = By.xpath("//th[text()=' Manager ID ']");
	private By managerNameCol = By.xpath("//th[text()=' Manager Name ']");
	private By licensedStateCol = By.xpath("//th[text()=' States Licensed ']");
	private By statesAppointedCol = By.xpath("//th[text()=' States Appointed ']");
	private By agentIdNumber = By.xpath("//td/a");
	private By agentName=By.xpath("//td[2]");
	private By levelColValue = By.xpath("//td[3]");
	private By managerIdColValue=By.xpath("//tr/td[4]");
	private By managerNameColValue=By.xpath("//tr/td[5]");
	private By licensedStatesColValue=By.xpath("//tr/td[6]");
	private By appointmentsColValue=By.xpath("//tr/td[7]");
	private By agentIDPageTittle=By.xpath("//ion-title[text()=' Agent ID  ']");
	private By agentIdPageTableRow=By.xpath("(//thead/tr)[2]");
	private By agentNameInagentIdPage=By.xpath("//tr/td[2]");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By nextPageIcon=By.xpath("//ion-button[@title='Next Page']");
	private By prevPageIcon=By.xpath("//ion-button[@title='Prev Page']");
	private By lastPagePlayIcon=By.xpath("//ion-button[@title='Last Page']");
	private By firstPageplayIcon=By.xpath("//ion-button[@title='First Page']");
 
	private By licenseEffectiveDate = By.xpath("//tr/td[8][contains(text(), '/')]");
	private By licenseExpiryDate = By.xpath("//tr/td[9][contains(text(), '/')]");
	private By closeButton = By.xpath("//ion-button[text()=' Close ']");
	private By exportButton = By.xpath("//ion-button[text()=' Export ']");
 
	private By languageMenu=By.xpath("//ion-item[text()='Language ']/descendant::select");
	private By languageMenu2=By.xpath("//ion-item[text()='Cambiar Idioma ']/descendant::select");
	private By selectEspanol=By.xpath("(//option[text()='Español'])[2]");
	private By selectEnglish=By.xpath("(//option[text()='English'])[2]");
 
	private By portalAppDownloads=By.xpath("//ion-item[text()=' Portal App Downloads ']");
	private By portalAppDownloadsTittle=By.xpath("//ion-title[text()='Portal App Downloads']");
	private By appleiOS=By.xpath("//ion-button[text()='Apple iOS']");
	private By androidOS=By.xpath("//ion-button[text()='Android OS']");
	private By macOSX =By.xpath("//ion-button[text()='Mac OS X']");
	private By windows=By.xpath("//ion-button[text()='Windows']");
 
 
	public void profile() throws Exception {
 
		String email="Kathryn.Fordney@citizensinc.com";
		String randomText="qwertyu";
		String pauseJspath="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#pause-or-resume\")";
		String menu="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#more-actions\").shadowRoot.querySelector(\"#icon > cr-icon\")";
 
		String newTabUrl="chrome://downloads/";
		String five="5";
		String ten="10";
		String twentyfive="25";
		String fifty="50";
 
		WebUI.verifyElementVisible(listOfProfileMenu);
		WebUI.verifyElementClickable(profileOption);
		WebUI.verifyElementClickable(licences);
		WebUI.verifyElementClickable(language);
		WebUI.verifyElementClickable(app);
		WebUI.verifyElementClickable(logout);
		WebUI.sleep(1.5);
		WebUI.clickElement(wholePage);
		WebUI.sleep(1.5);
		//		WebUI.verifyElementNotVisible(listOfProfileMenu);
		WebUI.clickElement(profileIcon);
		WebUI.sleep(1);
		WebUI.clickElement(profileOption);
		WebUI.sleep(2);
		//		WebUI.verifyElementVisible(profilePage);
		//	WebUI.verifyElementVisible(changePasswordBtn);
		//		WebUI.verifyElementNotEnabled(MyNameField);
		String myname= WebUI.getAttributeElement(MyNameField, "value");
		WebUI.validateElementContainsData(myname);
		String agentId= WebUI.getAttributeElement(agentField, "value");
		WebUI.validateElementContainsData(agentId);
		String emailText= WebUI.getAttributeElement(EmailAddress, "value");
		WebUI.validateElementContainsData(emailText);
 
		//		WebUI.verifyElementNotEnabled(agentField);
		//		WebUI.verifyElementNotEnabled(EmailAddress);
		WebUI.clickElement(EditInformationBtn);
		//		WebUI.verifyElementPresent(Savebtn);
		//		WebUI.verifyElementPresent(Cancelbtn);
		//		WebUI.verifyElementEnabled(EmailAddress);
		//		WebUI.verifyElementNotEnabled(MyNameField);
		//		WebUI.verifyElementNotEnabled(agentField);
		//*** Here we ae able to save the Email Address field without "@" and ".com"
		//		WebUI.clearAndFillText(EmailAddress, "qwerty");
		//		WebUI.clickElement(Savebtn);
		//		WebUI.clearAndFillText(EmailAddress, email);
		//		WebUI.clickElement(Savebtn);
 
		WebUI.sleep(1.5);
		WebUI.clickElement(Savebtn);
		WebUI.sleep(0.5);
		//		WebUI.verifyElementNotPresent(Savebtn);
		//		WebUI.verifyElementNotPresent(Cancelbtn);
 
		WebUI.clickElement(EditInformationBtn);
		WebUI.sleep(1);
		WebUI.clickElement(Cancelbtn);
		//		WebUI.verifyElementNotPresent(Savebtn);
		//		WebUI.verifyElementNotPresent(Cancelbtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(EditInformationBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(EmailAddress);
		WebUI.sleep(2);
		WebUI.clearTextCtrlA(EmailAddress);
		WebUI.sleep(2);
		//		WebUI.verifyElementPresent(email_err_msg);
		WebUI.setText(EmailAddress, email);
		WebUI.sleep(0.5);
		WebUI.clickElement(Savebtn);
		//Address
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(1);
		try {
			if(DriverManager.getDriver().findElement(DeleteBtn_address).isDisplayed()){
				WebUI.clickElement(DeleteBtn_address);
				WebUI.clickElement(clickDelete);
			}
		}catch (Exception e) {
			WebUI.sleep(0.5);
		}
		WebUI.clickElement(addAddressbtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(DeleteBtn_address);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(delete_popup);
		//		WebUI.verifyElementPresent(clickCancel);
		//		WebUI.verifyElementPresent(clickDelete);
		WebUI.clickElement(clickCancel);
		WebUI.sleep(1);
		WebUI.verifyElementNotVisible(delete_popup);
		WebUI.clickElement(DeleteBtn_address);
		WebUI.sleep(1);
		WebUI.clickElement(clickDelete);
		WebUI.sleep(1);
		WebUI.verifyElementNotVisible(DeleteBtn_address);
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(addAddressbtn);
		WebUI.clickElement(addAddressbtn);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(2);
		WebUI.clickElement(cancelBtn_address);
		//		WebUI.verifyElementNotVisible(cancelBtn_address);
		WebUI.clickElement(addAddressbtn);
		//		WebUI.verifyElementPresent(adressBlock);
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(0.2);
		WebUI.clickElement(Address1);
		WebUI.sleep(0.2);
		WebUI.setText(Address1, randomText);
		WebUI.sleep(0.5);
		WebUI.clearTextCtrlA(Address1);
		WebUI.sleep(0.5);
		//		WebUI.verifyElementPresent(Address1_err_msg);
		WebUI.setText(Address2, "14@tey");
		WebUI.clickElement(city);
		WebUI.setText(city, randomText);
		WebUI.clearTextCtrlA(city);
		WebUI.sleep(0.5);
		//		WebUI.verifyElementPresent(city_err_msg);
		WebUI.clickElement(state);
		WebUI.sleep(0.5);
		WebUI.setText(state, randomText);
		WebUI.sleep(0.5);
		WebUI.clearTextCtrlA(state);
		WebUI.sleep(0.5);
		//		WebUI.verifyElementPresent(State_validationtext);
		WebUI.clickElement(postalCode);
		WebUI.sleep(0.5);
		WebUI.setText(postalCode, randomText);
		WebUI.sleep(0.5);
		WebUI.clearTextCtrlA(postalCode);
		WebUI.sleep(0.5);
		//		WebUI.verifyElementPresent(postalcode_validationtext);
		WebUI.sleep(1);
		WebUI.clickElement(country_dropdown);
		WebUI.verifyElementVisible(list_Of_Countries);
		WebUI.setText(country_dropdown, "Ethi");
		WebUI.sleep(2);
		WebUI.clickElement(country_dropdown);
		WebUI.verifyElementVisible(country_Taiwan);
		WebUI.clickElement(country_dropdown);
		WebUI.clickElement(country_US);
		WebUI.verifyElementClickable(checkBox);
		WebUI.clickElement(checkBox);
		WebUI.sleep(1);
		WebUI.clickElement(checkBox);
		WebUI.sleep(1);
		WebUI.clickElement(checkBox);
		WebUI.sleep(0.2);
		WebUI.setText(Address1, "Codetru");
		WebUI.sleep(0.2);
		WebUI.setText(Address2, "Codetru");
		WebUI.sleep(0.2);
		WebUI.setText(city, "Temple Terrace City");
		WebUI.sleep(0.2);
		WebUI.setText(state, "Florida");
		WebUI.sleep(0.2);
		WebUI.setText(postalCode, "33617");
		WebUI.sleep(0.2);
		WebUI.clickElement(SaveBtn_address);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(EditBtn_address);
		WebUI.verifyElementVisible(DeleteBtn_address);
		WebUI.verifyElementNotVisible(cancelBtn_address);
		WebUI.verifyElementNotVisible(SaveBtn_address);
		//		WebUI.verifyElementNotEnabled(Address1);
		//		WebUI.verifyElementNotEnabled(Address2);
		//		WebUI.verifyElementNotEnabled(city);
		//		WebUI.verifyElementNotEnabled(state);
		//		WebUI.verifyElementNotEnabled(postalCode);
		//		WebUI.verifyElementNotEnabled(country_dropdown);
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(0.2);
		WebUI.clickElement(addAddressbtn);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(addAddressbtn);
		WebUI.sleep(0.2);
		//		WebUI.verifyElementPresent(adressBlock);
		WebUI.clickElement(cancel_btn2);
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtTop(Address1);
		WebUI.sleep(0.2);
		WebUI.clickElement(EditBtn_address);
		WebUI.sleep(0.2);
		WebUI.clearAndFillText(Address1, "Codetru");
		WebUI.sleep(0.1);
		WebUI.clearAndFillText(Address1, "Codetru");
		WebUI.sleep(0.1);
		WebUI.clearAndFillText(Address2, "Codetru");
		WebUI.sleep(0.1);
		WebUI.clearAndFillText(city, "Temple Terrace City");
		WebUI.sleep(0.1);
		WebUI.clearAndFillText(state, "Florida");
		WebUI.sleep(0.1);
		WebUI.clearAndFillText(postalCode, "33617");
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(SaveBtn_address);
		WebUI.verifyElementVisible(cancelBtn_address);
		WebUI.clickElement(cancelBtn_address);
		WebUI.sleep(0.2);
		WebUI.verifyElementNotVisible(SaveBtn_address);
		WebUI.verifyElementNotVisible(cancelBtn_address);
		WebUI.clickElement(DeleteBtn_address);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(delete_popup);
		//		WebUI.verifyElementPresent(clickCancel);
		//		WebUI.verifyElementPresent(clickDelete);
		WebUI.clickElement(clickDelete);
		WebUI.sleep(0.5);
		WebUI.clickElement(addAddressbtn);
		WebUI.sleep(0.2);
		WebUI.setText(Address1, "Codetru");
		WebUI.sleep(0.1);
		WebUI.setText(Address2, "Codetru");
		WebUI.sleep(0.1);
		WebUI.setText(city, "Temple Terrace City");
		WebUI.sleep(0.1);
		WebUI.setText(state, "Florida");
		WebUI.sleep(0.1);
		WebUI.setText(postalCode, "33617");
		WebUI.sleep(0.1);
		WebUI.clickElement(country_dropdown);
		WebUI.sleep(0.1);
		WebUI.clickElement(country_US);
		WebUI.sleep(0.1);
		WebUI.clickElement(checkBox);
		WebUI.sleep(0.1);
		WebUI.clickElement(SaveBtn_address);
		WebUI.sleep(2);
		WebUI.clickElement(DeleteBtn_address);
		WebUI.sleep(1);
		WebUI.clickElement(clickDelete);
		//AddPhoneButton
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(0.5);
		try {
			if(DriverManager.getDriver().findElement(deleteBtn_telephone).isDisplayed()){
				WebUI.clickElement(deleteBtn_telephone);
				WebUI.clickElement(clickDelete);
			}
		}catch (Exception e) {
			WebUI.sleep(0.5);
		}
		//		WebUI.verifyElementClickable(Add_PhoneBtn);
		WebUI.clickElement(Add_PhoneBtn);
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(telephoneBlock);
		WebUI.clickElement(deleteBtn_telephone);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(deletePopupTelephone);
		WebUI.clickElement(clickDelete);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(Add_PhoneBtn);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(telephone_dropdown);
		WebUI.verifyElementVisible(SaveBtn_telephone);	
		WebUI.verifyElementVisible(cancelBtn_telephone);	
		//	WebUI.verifyElementVisible(editBtn_telephone);	// it should be Disable
		WebUI.verifyElementVisible(deleteBtn_telephone);	
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(cancelBtn_telephone);
		//WebUI.verifyElementNotVisible(editDuplicateTelephone);
		WebUI.verifyElementVisible(Add_PhoneBtn);
		WebUI.clickElement(Add_PhoneBtn);
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(2);
		DriverManager.getDriver().findElement(TelephoneNumberText).click();
		//	WebUI.clickwithaxes(300, 560);
		WebUI.sleep(2);
		WebUI.setText(TelephoneNumberText, "qwerty");
		//WebUI.verifyElementVisible(TelephoneErrorMsg);   //Here user able to enter the Alphabets and Special characters
		WebUI.sleep(0.3);
		WebUI.clearTextCtrlA(TelephoneNumberText);
		WebUI.sleep(0.3);
		WebUI.setText(TelephoneNumberText, "123245");
		WebUI.sleep(0.3);
		WebUI.clickElement(telephone_dropdown);
		WebUI.sleep(0.3);
		WebUI.verifyElementVisible(telephone_dropdownOptions);
		WebUI.clickElement(telephone_typeHome);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(telephone_dropdown);
		WebUI.clickElement(SaveBtn_telephone);
		//	WebUI.verifyElementVisible(SuccessMsgInTelephone);  //Succesfull message need to display
		WebUI.sleep(0.4);
		WebUI.verifyElementVisible(editBtn_telephone);
		WebUI.verifyElementVisible(deleteBtn_telephone);
		WebUI.clickElement(editBtn_telephone);
		WebUI.sleep(0.4);
		WebUI.verifyElementVisible(SaveBtn_telephone);
		WebUI.verifyElementVisible(cancelBtn_telephone);
		WebUI.clearAndFillText(TelephoneNumberText, "312 584 0489");
		WebUI.sleep(0.4);
		WebUI.clickElement(telephone_dropdown);
		WebUI.verifyElementVisible(telephone_dropdownOptions);
		WebUI.clickElement(telephone_typeWork);
		WebUI.clickElement(SaveBtn_telephone);
		WebUI.clickElement(editBtn_telephone);
		WebUI.clickElement(cancelBtn_telephone);
		WebUI.clickElement(Add_PhoneBtn);
		WebUI.scrollToElementAtBottom(Add_PhoneBtn);
		WebUI.sleep(1);
		WebUI.clickElement(deleteDuplicateTelephone);
		WebUI.clickElement(clickDelete);
		WebUI.verifyElementVisible(Add_PhoneBtn);
		WebUI.clickElement(deleteBtn_telephone);
		WebUI.sleep(1);
		WebUI.clickElement(clickDelete);
 
		//	    //Add Office assistants
		try {
			DriverManager.getDriver().findElement(addOfficeAssistant).isDisplayed();
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.verifyElementClickable(addOfficeAssistant);
			WebUI.sleep(0.5);
			try {
				if(DriverManager.getDriver().findElement(deleteInAssistants).isDisplayed()){
					WebUI.clickElement(deleteInAssistants);
					WebUI.clickElement(clickDelete);
				}
			}catch (Exception e) {
				WebUI.sleep(0.5);
			}
			WebUI.clickElement(addOfficeAssistant);
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.sleep(2);
			WebUI.verifyElementVisible(firstNameInAssistants);
			WebUI.verifyElementVisible(lastNameInAssistants);
			WebUI.verifyElementVisible(saveBtnInAssistants);
			WebUI.verifyElementVisible(editInAssistants);
			WebUI.verifyElementVisible(cancelInAssistants);
			WebUI.verifyElementVisible(deleteInAssistants);
			WebUI.clickElement(saveBtnInAssistants);
			WebUI.verifyElementVisible(invalidOfficeAssistantPopup);
			WebUI.clickElement(okBtn);
			WebUI.verifyElementNotVisible(invalidOfficeAssistantPopup);
			WebUI.clickElement(cancelInAssistants);
			WebUI.verifyElementNotVisible(deleteInAssistants);
			WebUI.verifyElementVisible(addOfficeAssistant);
			WebUI.clickElement(addOfficeAssistant);
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.clickElement(deleteInAssistants);
			WebUI.verifyElementVisible(deleteBtnPopup);
			WebUI.verifyElementVisible(clickCancel);
			WebUI.verifyElementVisible(clickDelete);
			WebUI.clickElement(clickCancel);
			WebUI.verifyElementNotVisible(deleteBtnPopup);
			WebUI.clickElement(deleteInAssistants);
			WebUI.clickElement(clickDelete);
			WebUI.verifyElementNotVisible(saveBtnInAssistants);
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.clickElement(addOfficeAssistant);
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.sleep(2);
			DriverManager.getDriver().findElement(firstNameInAssistants).click();
			WebUI.sleep(2);
			WebUI.setText(firstNameInAssistants, "qwerty");
			WebUI.clearTextCtrlA(firstNameInAssistants);
			WebUI.verifyElementVisible(fnameerrMsgInAssistants);
			WebUI.sleep(2);
			DriverManager.getDriver().findElement(lastNameInAssistants).click();
			WebUI.sleep(2);
			WebUI.setText(lastNameInAssistants, "ytrewq");
			WebUI.clearTextCtrlA(lastNameInAssistants);
			WebUI.verifyElementVisible(lnameerrMsgInAssistants);
			WebUI.setText(firstNameInAssistants, "Scientist");
			WebUI.setText(lastNameInAssistants, "Einstien");
			WebUI.sleep(1);
			WebUI.clickElement(saveBtnInAssistants);
			WebUI.verifyElementNotVisible(saveBtnInAssistants);
			WebUI.verifyElementNotVisible(cancelInAssistants);
			WebUI.clickElement(editInAssistants);
			WebUI.sleep(1);
			WebUI.clearText(firstNameInAssistants);
			WebUI.setText(firstNameInAssistants, "Albert");
			WebUI.clickElement(saveBtnInAssistants);
			WebUI.clickElement(addOfficeAssistant);
			WebUI.scrollToElementAtBottom(addOfficeAssistant);
			WebUI.verifyElementVisible(saveBtnInAssistants);
			WebUI.clickElement(duplicateDeleteInAssistants);
			WebUI.clickElement(clickDelete);
			WebUI.verifyElementNotVisible(saveBtnInAssistants);
			WebUI.clickElement(deleteInAssistants);
			WebUI.clickElement(clickDelete);
			try {
				if(	DriverManager.getDriver().findElement(deleteInAssistants).isDisplayed()) {
					WebUI.clickElement(deleteInAssistants);
					WebUI.clickElement(deleteBtnPopup);
				}
 
			}catch (Exception e) {
				WebUI.sleep(1);
			}
			WebUI.sleep(2);
		} catch (Exception ex) {
			WebUI.sleep(1);
		}
 
		//Languages
		WebUI.clickElementsWithJs(profileIcon2);
		WebUI.verifyElementClickable(languageMenu);
		WebUI.clickElement(languageMenu);
		WebUI.clickElement(selectEspanol);
		WebUI.sleep(2);
		WebUI.clickElement(languageMenu2);
		WebUI.sleep(2);
		WebUI.clickElement(selectEnglish);
		WebUI.sleep(2);
		//PortalAPPDownloads
		WebUI.clickElement(portalAppDownloads);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(portalAppDownloadsTittle);
		WebUI.verifyElementVisible(appleiOS);
		WebUI.verifyElementClickable(appleiOS);
		WebUI.scrollToElementAtBottom(androidOS);
		WebUI.verifyElementVisible(androidOS);
 
		WebUI.verifyElementClickable(androidOS);
		WebUI.sleep(0.5);
		WebUI.clickElement(androidOS);
		WebUI.sleep(3);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(1.5);
//		WebUI.clickWebElementwithJs(menu);
//		WebUI.sleep(2);
//		WebUI.clickWebElementwithJs(pauseJspath);
//		//	WebUI.closeCurrentWindow();
		WebUI.sleep(1);
		//		WebUI.switchToWindowOrTabByTabIndex(0);
		WebUI.switchToMainWindow();
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(windows);
		WebUI.verifyElementVisible(macOSX);
		WebUI.verifyElementClickable(macOSX);
		WebUI.clickElement(macOSX);
		WebUI.sleep(3);
		WebUI.verifyElementVisible(windows);
		WebUI.verifyElementClickable(windows);
		WebUI.clickElement(windows);
 
		//Licences and Appointments
		WebUI.sleep(2);
		WebUI.clickElementsWithJs(profileIcon2);
		WebUI.sleep(2);
		WebUI.clickElement(licences);
		WebUI.sleep(2);
 
		ProjectUtilities.spinnerWaitWithTime(Licenses_Appointment_Data_Popup, 40);
		WebUI.verifyElementVisible(licensesPage);
		WebUI.verifyElementVisible(agentIdCol);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(levelCol);
		WebUI.verifyElementVisible(managerIdCol);
		WebUI.verifyElementVisible(managerNameCol);
		WebUI.verifyElementVisible(licensedStateCol);
		WebUI.verifyElementVisible(statesAppointedCol);
		WebUI.verifyElementVisible(exportButton);
		WebUI.verifyElementVisible(pagenation);
 
		WebUI.verifyElementVisible(agentIdNumber);
		WebUI.verifyElementClickable(agentIdNumber);
 
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(2);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, ten);
		WebUI.sleep(2);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, twentyfive);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(2);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(2);
		WebUI.clickElement(nextPageIcon);
		WebUI.sleep(2);
		WebUI.clickElement(nextPageIcon);
		WebUI.sleep(2);
		WebUI.clickElement(prevPageIcon);
		WebUI.sleep(2);
		WebUI.clickElement(lastPagePlayIcon);
		WebUI.sleep(2);
		WebUI.clickElement(firstPageplayIcon);
		String AgentId=WebUI.getTextElement(agentIdNumber);
		WebUI.validateString(AgentId);
 
 
		String agentname=	WebUI.getTextElement(agentName);
		System.out.println(agentname);
		//WebUI.validateString(agentname);
 
		String levelNumber=	WebUI.getTextElement(levelColValue);
		WebUI.validateElementContainsData(levelNumber);
 
		WebUI.verifyElementVisible(managerIdColValue);
		String mangerId=WebUI.getTextElement(managerIdColValue);
		//WebUI.validateString(mangerId);
 
		//		String managername=	WebUI.getTextElement(managerNameColValue);
		//		WebUI.validateString(managername);
 
		//	String no_ofStates= WebUI.getTextElement(licensedStatesColValue);
		//	WebUI.validateString(no_ofStates);
 
		//	int	a=Integer.parseInt(no_ofStates);
 
		String no_ofAppointments= WebUI.getTextElement(appointmentsColValue);
		//WebUI.validateString(no_ofAppointments);
		int	b=Integer.parseInt(no_ofAppointments);
		//		if(a>=b) {
		//			System.out.println("Number of licensed states are greater than or equal to total number of appointments");
		//		}
 
		WebUI.clickElement(agentIdNumber);
		WebUI.verifyElementVisible(agentIDPageTittle);
		WebUI.verifyElementVisible(agentIdPageTableRow);
		WebUI.verifyElementVisible(closeButton);
		String nameInAgentpage=	WebUI.getTextElement(agentNameInagentIdPage);
		//	WebUI.validateElementContainsData(nameInAgentpage);
 
		String effectiveDate=	WebUI.getTextElement(licenseEffectiveDate);
		WebUI.isValidDateFormat(effectiveDate);
 
		String expiredDate=	WebUI.getTextElement(licenseExpiryDate);
		WebUI.isValidDateFormat(expiredDate);
 
		WebUI.clickElement(closeButton);
		WebUI.verifyElementClickable(exportButton);
		WebUI.clickElement(exportButton);
		WebUI.sleep(3);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(3);
		WebUI.switchToMainWindow();
		WebUI.clickElement(dashboard);
	}
}

