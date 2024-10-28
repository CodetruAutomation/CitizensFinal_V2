package com.codetru.project.cica.utils;

import static com.codetru.keywords.WebUI.clickElement;
import static com.codetru.keywords.WebUI.sleep;
import static com.codetru.keywords.WebUI.verifyElementVisible;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class HomePage_Modules extends CommonPageCICA {

	private By policypaymentBtn = By.xpath("//ion-button[text()=' Policy Payment ']");
	private By paymentRefusedReportBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[text()=' Payment Refused Report ']");
	private By applicationPaymentStatusBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[text()=' Application Payment Status ']");
	private By accountBalanceBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[starts-with(text(),' Account Balance - Post')]");
	private By checkReportBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[starts-with(text(),' Check Report - Post')]");
	private By statusReportBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[text()=' Status Report ']");
	private By accountBalanceHistoryBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[starts-with(text(),' Account Balance - Pre')]");
	private By checkReportHistoryBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[starts-with(text(),' Check Report - Pre')]");
	private By reportBtn = By.xpath("//ion-button[text()=' Reports ']");
	private By activityReportBtn = By.xpath("//div[@class='reportDropdown']/div/ion-item[text()=' Activity Report ']");
	private By renewalPremium = By.xpath("//div[@class='reportDropdown']/div/ion-item[text()=' Renewal Premium Report ']");
	private By customerTab = By.xpath("//ion-button[normalize-space()='Customers']");
	private By customerSearch = By.xpath("//ion-title[text()='Customer Search']");
	private By profileIcon = By.xpath("(//ion-icon[@name='person']/parent::ion-button)[2]");
	private By logo = By.xpath("//ion-col[@class='ion-text-left md hydrated']/ion-img");
	private By menu = By.xpath("//ion-button/parent::ion-col[@class='ion-text-center md hydrated']");
	private By dashboardBtn = By.xpath("//ion-button[.=' Dashboard ']");
	private By agencyDashboard = By.xpath("//ion-button[.=' Agency ']");

	
	public void Open_PolicyPayment_Module() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(policypaymentBtn);
		WebUI.verifyElementClickable(policypaymentBtn);
		WebUI.clickElement(policypaymentBtn);
		WebUI.sleep(2);

	}

	public void Open_activityReports() {
		WebUI.waitForPageLoaded();
		sleep(2);
//		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(activityReportBtn);
		// WebUI.verifyElementVisible(paymentRefusedReportBtn);
		// WebUI.verifyElementVisible(applicationPaymentStatusBtn);
		// WebUI.verifyElementVisible(accountBalanceHistoryBtn);
		// WebUI.verifyElementVisible(accountBalanceBtn);
		// WebUI.verifyElementVisible(statusReportBtn);
		// WebUI.verifyElementVisible(renewalPremium);
		// WebUI.verifyElementVisible(CheckReportHistoryBtn);
		// WebUI.verifyElementVisible(checkReportBtn);
		// WebUI.sleep(2);
		WebUI.clickElementWithJs(activityReportBtn);
		WebUI.sleep(3);
	}

	public void Open_renewalReports() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(1);
		// WebUI.verifyElementVisible(activityReportBtn);
		// WebUI.verifyElementVisible(paymentRefusedReportBtn);
		// WebUI.verifyElementVisible(applicationPaymentStatusBtn);
		// WebUI.verifyElementVisible(accountBalanceHistoryBtn);
		// WebUI.verifyElementVisible(accountBalanceBtn);
		// WebUI.verifyElementVisible(statusReportBtn);
		// WebUI.verifyElementVisible(CheckReportHistoryBtn);
		// WebUI.verifyElementVisible(checkReportBtn);
		WebUI.verifyElementVisible(renewalPremium);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(renewalPremium);
		WebUI.sleep(2);

	}

	public void Open_Customers_Module() {
		WebUI.waitForPageLoaded();
		sleep(5);
		clickElement(customerTab);
		sleep(2);
		verifyElementVisible(customerSearch, "Customer Search");
	}

	public void Open_Profile_Module() {
		WebUI.waitForPageLoaded();
		sleep(5);
		clickElement(profileIcon);
		sleep(2);
	}

	public void Open_Dashboard_Module() {
		WebUI.waitForPageLoaded();
		sleep(8);
		WebUI.verifyElementVisible(logo);
		WebUI.verifyElementVisible(menu);
		WebUI.verifyElementVisible(profileIcon);
		WebUI.clickElement(dashboardBtn);
		sleep(2);
	}

	public void Open_ApplicationPaymentStatus() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
		// WebUI.verifyElementVisible(activityReportBtn);
		// WebUI.verifyElementVisible(paymentRefusedReportBtn);
		WebUI.verifyElementVisible(applicationPaymentStatusBtn);
		// WebUI.verifyElementVisible(accountBalanceHistoryBtn);
		// WebUI.verifyElementVisible(accountBalanceBtn);
		// WebUI.verifyElementVisible(statusReportBtn);
		// WebUI.verifyElementVisible(renewalPremium);
		// WebUI.verifyElementVisible(CheckReportHistoryBtn);
		// WebUI.verifyElementVisible(checkReportBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(applicationPaymentStatusBtn);
	}

	public void Open_PaymentRefusedReport() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceHistoryBtn);
//			WebUI.verifyElementVisible(accountBalanceBtn);
//			WebUI.verifyElementVisible(statusReportBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(CheckReportHistoryBtn);
//			WebUI.verifyElementVisible(checkReportBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(paymentRefusedReportBtn);
	}

	public void Open_checkReports() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceHistoryBtn);
//			WebUI.verifyElementVisible(accountBalanceBtn);
//			WebUI.verifyElementVisible(statusReportBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(CheckReportHistoryBtn);
		WebUI.verifyElementVisible(checkReportBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(checkReportBtn);
	}

	public void Open_checkReportHistory() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceHistoryBtn);
//			WebUI.verifyElementVisible(accountBalanceBtn);
//			WebUI.verifyElementVisible(statusReportBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(checkReportBtn);
		WebUI.verifyElementVisible(checkReportHistoryBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(checkReportHistoryBtn);
	}

	public void Open_agencyDashboard() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(agencyDashboard);
		WebUI.verifyElementClickable(agencyDashboard);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(2);

	}

	public void Open_accountBalanceHistory() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceBtn);
//			WebUI.verifyElementVisible(statusReportBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(CheckReportHistoryBtn);
//			WebUI.verifyElementVisible(checkReportBtn);
		WebUI.verifyElementVisible(accountBalanceHistoryBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(accountBalanceHistoryBtn);
	}

	public void Open_statusReports() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceHistoryBtn);
//			WebUI.verifyElementVisible(accountBalanceBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(CheckReportHistoryBtn);
//			WebUI.verifyElementVisible(checkReportBtn);
		WebUI.verifyElementVisible(statusReportBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(statusReportBtn);
	}

	public void Open_accountBalanceReports() {
		WebUI.waitForPageLoaded();
		sleep(2);
		WebUI.verifyElementPresent(reportBtn);
		WebUI.verifyElementClickable(reportBtn);
		WebUI.mouseHover(reportBtn);
		WebUI.sleep(2);
//			WebUI.verifyElementVisible(activityReportBtn);
//			WebUI.verifyElementVisible(paymentRefusedReportBtn);
//			WebUI.verifyElementVisible(applicationPaymentStatusBtn);
//			WebUI.verifyElementVisible(accountBalanceHistoryBtn);
//			WebUI.verifyElementVisible(statusReportBtn);
//			WebUI.verifyElementVisible(renewalPremium);
//			WebUI.verifyElementVisible(CheckReportHistoryBtn);
//			WebUI.verifyElementVisible(checkReportBtn);
		WebUI.verifyElementVisible(accountBalanceBtn);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(accountBalanceBtn);
	}

}
