package com.codetru.project.cica.pages.loginModule;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class LoginModule extends CommonPageCICA {

	private By profileIcon = By.xpath("(//ion-icon[@name='person']/parent::ion-button)[2]");	
	private By logout=By.xpath("//ion-item[text()=' Logout ']");
	private By loginPage=By.xpath("//h1[.=' Sign In ']");
	private By logo=By.xpath("//img[@alt='Citizens National']");
	private By userNameReqd = By.xpath("//p[text()='Please enter a value. ']");
	private By passwordReqd=By.xpath("//p[text()='Please enter a value. ']");
	private By inputUserName = By.xpath("//input[@name='username']");
	private By inputPassword = By.xpath("//input[@name='password']");
	private By signInButton=By.xpath("//ion-button[@type='submit']");
	private By forgotPassword=By.xpath("//a[@href='/forgot-password']");
	private By selectLanguage=By.xpath("//select/parent::div");
	private By version=By.xpath("//div[starts-with(text(),' Version')]");
	private By dbVersion=By.xpath("//div[starts-with(text(),' DB Version')]");
	private By min_charsErrMsg=By.xpath("//p[.='The minimum number of characters is 8. ']");
	private By incorrectPortal=By.xpath("//h2[.='Incorrect Portal']");
	private By okBtn=By.xpath("//span[.='Ok']");
	private By cancelBtn=By.xpath("//span[.='Cancel']");
	private By incorrectCredentialsPopUp=By.xpath("//h2[.='Incorrect User Name or Password']");
	private By incorrectPopUpOkBtn=By.xpath("//span[.='OK']");


	public void Login() {

		String expectedURL="https://icportal.cica-ai.com/login";


		WebUI.sleep(5);
//		WebUI.clickElementWithJs(profileIcon);
//		WebUI.verifyElementVisible(logout);
//		WebUI.clickElementWithJs(logout);
		WebUI.verifyElementVisible(loginPage);
		WebUI.verifyElementVisible(logo);
		WebUI.verifyElementVisible(inputUserName);
		WebUI.verifyElementVisible(inputPassword);
		WebUI.verifyElementVisible(signInButton);
		WebUI.verifyElementVisible(forgotPassword);
		WebUI.verifyElementVisible(selectLanguage);
		WebUI.verifyElementVisible(version);
		WebUI.verifyElementVisible(dbVersion);
		WebUI.setText(inputUserName, "hbjcdbc");
		WebUI.clearText(inputUserName);
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(userNameReqd);
		WebUI.setText(inputPassword, "hbjcdbc");
		WebUI.verifyElementVisible(min_charsErrMsg);
		WebUI.clearTextCtrlA(inputPassword);
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(passwordReqd);
		WebUI.setText(inputUserName, "6766667");
		WebUI.setText(inputPassword, "RoctStar_K8");
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(incorrectPortal);
		WebUI.verifyElementVisible(okBtn);
		WebUI.verifyElementVisible(cancelBtn);
		WebUI.clickElement(cancelBtn);
		WebUI.clearAndFillText(inputUserName, "7250883");
		WebUI.clearAndFillText(inputPassword, "Test@12345");
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(incorrectCredentialsPopUp);
		WebUI.verifyElementVisible(incorrectPopUpOkBtn);
		WebUI.clickElement(incorrectPopUpOkBtn);
		WebUI.verifyElementNotVisible(incorrectCredentialsPopUp);
		WebUI.clearAndFillText(inputUserName, "7253775");
		WebUI.clearAndFillText(inputPassword, "RockStar_K8");
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(incorrectCredentialsPopUp);
		WebUI.verifyElementVisible(incorrectPopUpOkBtn);
		WebUI.clickElement(incorrectPopUpOkBtn);
		WebUI.clearAndFillText(inputPassword, "Test@12345");
		WebUI.clearAndFillText(inputUserName, "5363@#sdg");
		WebUI.clickElement(signInButton);
		WebUI.verifyElementVisible(incorrectPortal);
		WebUI.clickElement(okBtn);
		WebUI.sleep(2);
		String actualURL=WebUI.getCurrentUrl();
		WebUI.verifyEquals(actualURL, expectedURL);
		WebUI.navigateToPreviousPage();
		WebUI.sleep(2);
		WebUI.navigateToPreviousPage();

	}
}

