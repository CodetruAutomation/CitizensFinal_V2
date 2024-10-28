package com.codetru.project.cica.pages.reportsModule;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class StatusReport extends CommonPageCICA {

	private By title=By.xpath("//ion-title[.='Status Report ']");
	private By agentDetails=By.xpath("//ion-list-header");
	private By agentCaret_btn=By.xpath("//ion-icon[@name='caret-down']");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn=By.xpath("//ion-button[text()='Close']");
	private By searchBar=By.xpath("//ion-searchbar[@type='text']");
	private By agentsText=By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput=By.xpath("//input[@aria-label='search text']");
	private By resetBtn=By.xpath("//button[@aria-label='reset']");
	private By dateFilter=By.xpath("//select[@formcontrolname='dateFilter']");
	private By selectMnth=By.xpath("//select[@formcontrolname='dateFilter']/option[3]");
	private By checkDate=By.xpath("//h2[.='Advance Account Balance ']/following-sibling::tbody/tr[3]/td");
	private By agentId=By.xpath("(//table)[2]/tbody/tr/td[2]");
	private By errorPopup=By.xpath("//h2[.='Error']/parent::div");
	private By errorOkBtn=By.xpath("//span[.='OK']");
	private By HighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By secondHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[2]");
	private By thirdHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[3]");
	private By fourthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[4]");
	private By fifthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[5]");
	private By agentTypeDropdown=By.xpath("//select[@id='agentdd']");
	private By agencyOption=By.xpath("//option[.=' Agency ']");
	private By independentConsultantOption=By.xpath("//option[.=' Independent Consultant ']");
	private By monthToDate=By.xpath("//h3[starts-with(text(), 'Commission Premiums')]/parent::div/ion-row/ion-col[.='Month To Date']");
	private By yearToDate=By.xpath("//h3[starts-with(text(), 'Commission Premiums')]/parent::div/ion-row/ion-col[.='Year To Date']");
	private By typeCol=By.xpath("//h3[starts-with(text(), 'Commission Premiums')]/parent::div/ion-row/ion-col[.='Type ']");
	private By salesActivityCol=By.xpath("//ion-col[.='Sales Activity']");
	private By activitySummaryMonthToDate=By.xpath("//h3[.='Activity Summary']/parent::div/ion-row/ion-col[.='Month To Date']");
	private By activitySummaryYearToDate=By.xpath("//h3[.='Activity Summary']/parent::div/ion-row/ion-col[.='Year To Date']");
	private By inforceActivityCol=By.xpath("//ion-col[.='In-Force Activity']");
	private By inforceActivityMonthToDate=By.xpath("//h3[.='In-Force Activity']/parent::div/ion-row/ion-col[.='Month To Date']");
	private By inforceActivityYearToDate=By.xpath("//h3[.='In-Force Activity']/parent::div/ion-row/ion-col[.='Year To Date']");
	private By netInforceTable=By.xpath("//h3[.='Net In-Force All Years']");
	private By netInforceApps=By.xpath("//h3[.='Net In-Force All Years']/parent::div/ion-row/ion-col[.='Apps']");
	private By netInforceVolume=By.xpath("//h3[.='Net In-Force All Years']/parent::div/ion-row/ion-col[.='Volume']");
	private By netInforcePremium=By.xpath("//h3[.='Net In-Force All Years']/parent::div/ion-row/ion-col[.='Premium']");

	private By presistencyMosCol=By.xpath("//h3[.='Persistency Summary']/parent::div/ion-row/ion-col[.='Mos ']");
	private By presistencyAppsCol=By.xpath("//h3[.='Persistency Summary']/parent::div/ion-row/ion-col[.='Apps']");
	private By presistencyPersCol=By.xpath("//h3[.='Persistency Summary']/parent::div/ion-row/ion-col[.='Pers %']");
	private By presistencyVolumeCol=By.xpath("//h3[.='Persistency Summary']/parent::div/ion-row/ion-col[.='Volume']");
	private By presistencyPremiumCol=By.xpath("//h3[.='Persistency Summary']/parent::div/ion-row/ion-col[.='Premium']");

	private By financialStatusTable=By.xpath("//h3[.=\"Consultant's Financial Status\"]");
	private By financialInformation=By.xpath("//h3[.='Financial Information']");
	private By deferredCommissions=By.xpath("//h3[.='Deferred Commissions - 24 Months']");
	private By contractInformation=By.xpath("//h3[.='Contract  Information']");
	private By pleaseWaitSpinner = By.xpath("//div[text()='Please Wait…']/parent::div");
	private By dashboardBtn=By.xpath("//ion-button[.=' Dashboard ']");

	public void statusReport() throws Exception {
		String id=null ;
		String fullName=null ;
		String[] nameParts=null ;
		String lastName=null ;
		String firstName=null ;


		WebUI.sleep(5);
		WebUI.verifyElementVisible(title);
		try {
			while(com.codetru.driver.DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		try {
			//WebUI.verifyElementVisible(errorPopup);
			DriverManager.getDriver().findElement(errorPopup).isDisplayed();
			WebUI.clickElement(errorOkBtn);
			WebUI.sleep(1);
			WebUI.clickElement(errorOkBtn);
			WebUI.sleep(1);
			WebUI.clickElement(errorOkBtn);
			WebUI.sleep(1);

		}catch(Exception e) {
			WebUI.sleep(1);
		}
		WebUI.clickElement(agentCaret_btn);
		WebUI.verifyElementVisible(agentsList);
		WebUI.verifyElementVisible(closeBtn);
		WebUI.verifyElementVisible(searchBar);
		WebUI.verifyElementVisible(agentDetails);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(agentsList);
		WebUI.clickElement(agentCaret_btn);
		WebUI.setText(searchBoxInput, "55555");
		WebUI.sleep(2);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "Japfu");
		WebUI.sleep(2);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "magpie");
		WebUI.sleep(2);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.sleep(2);
		WebUI.clickElement(resetBtn);
		WebUI.sleep(2);
		String Id1=	WebUI.validateElementContainsDataAndExtractID(HighestLevel);
		String Id2=	WebUI.validateElementContainsDataAndExtractID(secondHighestLevel);
		String Id3=	WebUI.validateElementContainsDataAndExtractID(thirdHighestLevel);
		String Id4=	WebUI.validateElementContainsDataAndExtractID(fourthHighestLevel);
		String Id5=	WebUI.validateElementContainsDataAndExtractID(fifthHighestLevel);
		System.out.println(Id3);
		WebUI.sleep(2);

		List<String> listNames = WebUI.getElementTextsInList(agentsText);
		int count = 0;
		for (String name : listNames) {
			if (count >= 2) {
				break;
			}
			id = name.split("-")[2].trim();
			fullName = name.split("-")[3].trim();
			nameParts = fullName.split(",");
			lastName = nameParts[0];
			firstName = nameParts[1];
			WebUI.setText(searchBoxInput, id);
			WebUI.sleep(1);
			WebUI.verifyContains(WebUI.getTextElement(agentsText), id);
			WebUI.sleep(0.2);
			WebUI.clearText(searchBoxInput);
			WebUI.setText(searchBoxInput, firstName);
			WebUI.sleep(1);
			WebUI.verifyContains(WebUI.getTextElement(agentsText), firstName);
			WebUI.sleep(0.2);
			WebUI.clearText(searchBoxInput);
			WebUI.setText(searchBoxInput, lastName);
			WebUI.sleep(1);
			WebUI.verifyContains(WebUI.getTextElement(agentsText), lastName);
			WebUI.sleep(0.2);
			WebUI.clearText(searchBoxInput);
			count++;
			System.out.println(count);
		}
		WebUI.clickElement(resetBtn);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(HighestLevel);
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(1);
		try {
			while(com.codetru.driver.DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		WebUI.clickElement(dateFilter);

		WebUI.clickElement(selectMnth);
		WebUI.sleep(1);
		try {
			while(com.codetru.driver.DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		WebUI.clickElement(agentTypeDropdown);
		WebUI.verifyElementVisible(agencyOption);
		WebUI.verifyElementVisible(independentConsultantOption);
		WebUI.clickElement(independentConsultantOption);
		WebUI.sleep(1);
		try {
			while(com.codetru.driver.DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		try {
			//			WebUI.verifyElementVisible(errorPopup);
			DriverManager.getDriver().findElement(errorPopup).isDisplayed();
			WebUI.clickElement(errorOkBtn);
			WebUI.clickElement(agentTypeDropdown);
			WebUI.clickElement(agencyOption);
		}catch(Exception e) {
			WebUI.clickElement(agentTypeDropdown);
			WebUI.clickElement(agencyOption);
		}

		WebUI.sleep(1);
		try {
			while(com.codetru.driver.DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		WebUI.verifyElementVisible(monthToDate);
		WebUI.verifyElementVisible(yearToDate);
		WebUI.verifyElementVisible(typeCol);
		WebUI.scrollToElementAtBottom(salesActivityCol);
		WebUI.verifyElementVisible(salesActivityCol);
		WebUI.verifyElementVisible(activitySummaryMonthToDate);
		WebUI.verifyElementVisible(activitySummaryYearToDate);
		WebUI.scrollToElementAtBottom(inforceActivityCol);
		WebUI.verifyElementVisible(inforceActivityCol);
		WebUI.verifyElementVisible(inforceActivityMonthToDate);
		WebUI.verifyElementVisible(inforceActivityYearToDate);
		WebUI.scrollToElementAtBottom(netInforceApps);
		WebUI.verifyElementVisible(netInforceTable);
		WebUI.verifyElementVisible(netInforceApps);
		WebUI.verifyElementVisible(netInforceVolume);
		WebUI.verifyElementVisible(netInforcePremium);

		WebUI.scrollToElementAtBottom(presistencyMosCol);
		WebUI.verifyElementVisible(presistencyMosCol);
		WebUI.verifyElementVisible(presistencyAppsCol);
		WebUI.verifyElementVisible(presistencyPersCol);
		WebUI.verifyElementVisible(presistencyVolumeCol);
		WebUI.verifyElementVisible(presistencyPremiumCol);

		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.verifyElementVisible(financialStatusTable);
		WebUI.scrollToElementAtBottom(financialInformation);
		WebUI.verifyElementVisible(financialInformation);
		WebUI.scrollToElementAtBottom(deferredCommissions);
		WebUI.verifyElementVisible(deferredCommissions);
		WebUI.scrollToElementAtBottom(contractInformation);
		WebUI.verifyElementVisible(contractInformation);
		WebUI.sleep(1);
		WebUI.clickElement(dashboardBtn);





		//		WebUI.scrollToElementAtBottom(checkDate);
		//		WebUI.verifyElementVisible(agentId);
		//		String[] dateParts = WebUI.getTextElement(checkDate).split("/");
		//		String month = dateParts[0];
		//		String year = dateParts[2];
		//		String formattedDate = month + "/" + year;
		//		WebUI.verifyContains(selectedMonth, formattedDate);



	}
}