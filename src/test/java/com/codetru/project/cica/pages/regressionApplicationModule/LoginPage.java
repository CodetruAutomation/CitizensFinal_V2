package com.codetru.project.cica.pages.regressionApplicationModule;

import com.codetru.constants.FrameworkConstants;
import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

import static com.codetru.keywords.WebUI.*;

import org.openqa.selenium.By;

public class LoginPage extends CommonPageCICA {

    private By closeAdvertisementPopup = By.xpath("//button[@data-key='website-popup']");
  
    private By buttonSubmitLogin = By.xpath("//ion-button[@type='submit']");
    private By titleLoginPage = By.xpath("//ion-button[@type='submit']");
    private By userNameReqd = By.xpath("//p[text()='Please enter a value. ']");
    private By inputEmail = By.xpath("//input[@name='username']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By messageUserDoesNotExist = By.xpath("//h2[.='Incorrect User Name or Password']");
    private By messageRequiredPassword = By.className("errormsg");
    private By dashboardTab = By.xpath("//ion-button[text()=' Dashboard ']");
    
    


    public void clickCloseAdvertisementPopup() {
        clickElement(closeAdvertisementPopup);
    }

    public void openLoginPage() {
        openWebsite(FrameworkConstants.URL_CICA_AGENT);
        waitForPageLoaded();
        verifyElementVisible(titleLoginPage, "Login page is NOT displayed");
    }


    public void loginFailWithEmailNull() {
        openLoginPage();
        sleep(2);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyEquals(getTextElement(userNameReqd).trim(), "Please enter a value.", "");
    }

    public void loginFailWithEmailDoesNotExist(String email, String password) {
        openLoginPage();
        sleep(2);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementVisible(messageUserDoesNotExist, "User Doesn't Exist. Please enter a valid User Name.");
    }

    public void loginFailWithNullPassword(String email) {
        openLoginPage();
        sleep(2);
        setText(inputEmail, email);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementPresent(messageRequiredPassword, "Did not enter the password");
    }

    public void loginFailWithIncorrectPassword(String email, String password) {
        openLoginPage();
        sleep(2);
        setText(inputEmail, email);
        clearText(inputPassword);
        setText(inputPassword, password);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementVisible(messageUserDoesNotExist, "Password is failed but valid is NOT displayed.");
    }

    public void loginSuccessWithAgentAccount(String email, String password) {
        openLoginPage();
        sleep(2);
        setText(inputEmail, email);
        clearText(inputPassword);
        setText(inputPassword, password);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(6);

    }
    
    public void login_WithoutPageLoading(String email, String password)
    {
    	WebUI.sleep(1);
        setText(inputEmail, email);
        WebUI.sleep(0.5);
        clearText(inputPassword);
        setText(inputPassword, password);
        clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(6);
    }

}


