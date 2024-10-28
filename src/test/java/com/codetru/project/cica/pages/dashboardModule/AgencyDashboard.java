package com.codetru.project.cica.pages.dashboardModule;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class AgencyDashboard extends CommonPageCICA {
	
	private By agencyDashboard=By.xpath("//ion-button[.=' Agency ']");
	private By combinedDashboard=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Dashboard ']");
	private By combinedActivityReport=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Activity Report ']");
	private By combinedApplPaymentStatus=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Application Payment Status ']");
	private By combinedRenewalPremiumReport=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Renewal Premium Report ']");
	private By ytdProduction=By.xpath("//ion-title[text()='YTD PRODUCTION']");
	private By resources=By.xpath("//ion-title[text()='Resources']");
	private By statusOfBook=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']");
	private By quickSearch=By.xpath("//ion-card-title[text()='Customer Quick Search ']");
	private By issuedCard=By.xpath("//ion-card-title[text()='Issued ']/following-sibling::ion-card-content/canvas");
	private By premiumCard=By.xpath("//ion-card-title[text()='Premium ']/following-sibling::ion-card-content/canvas");
	private By activityReportTitle=By.xpath("//ion-title[text()='Combined Activity Report ']");
	private By InprogressCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]");
	private By arrearsCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[2]");
	private By pendingLapseCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[3]");
	private By inprogressCardPageTitle=By.xpath("//ion-title[text()='Combined Application Status and Payments ']");
	private By arrearsCardPageTitle=By.xpath("//ion-title[text()='Combined Renewal Premium Report ']");
	private By countOfApplications=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::ion-col[2]");
	private By inprogressApplications=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]/ion-card-content[1]");
	private By oneMonthArrearsApplications=By.xpath("//ion-card-title[text()='1 Month Arrears ']/parent::ion-card-header/following-sibling::ion-card-content");
	private By pendingLapseCardValue=By.xpath("//ion-card-title[text()='Pending Lapse ']/parent::ion-card-header/following-sibling::ion-card-content");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By agentsDropdown=By.xpath("//select[@formcontrolname='agentddl']");
	private By DropdownList=By.xpath("//option[starts-with(text(),'7250')]");
	private By DropdownListThree=By.xpath("(//option[starts-with(text(),'7250')])[3]");
	private By agentInprogresscardValue=By.xpath("(//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]/ion-card-content[1])[2]");
	private By individualProduction=By.xpath("//h5[text()='Individual Production']");
	private By combinedActivityReportTitle=By.xpath("//ion-title[text()='Combined Activity Report ']");
	private By agencySalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']");
	private By agencyInforceReport=By.xpath("//span[text()=' Agency Inforce Report ']");
	private By agencyActivityReport=By.xpath("//span[text()=' Agency Activity Report ']");
	private By salesColInSalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Sales Activities']");
	private By appsColInSalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Apps']");
	private By volumeColInSalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By premiumColInSalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By inforceColInInforceActivity=By.xpath("//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='In-Force Activity']");
	private By appsColInInforceActivity=By.xpath("//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Apps']");
	private By volumeColInInforceActivity=By.xpath("//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By premiumColInInforceActivity=By.xpath("//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By IC_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='IC #']");
	private By ICName_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='IC Name']");
	private By contract_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Contract # ']");
	private By insured_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Insured']");
	private By status_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Status']");
	private By planName_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Plan Name']");
	private By plan_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Plan']");
	private By applicationDate_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Application Date ']");
	private By submittedDate_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Submitted Date ']");
	private By procDate_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Proc Date']");
	private By issuedDate_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Issued Date']");
	private By paidToDate_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Paid To Date ']");
	private By apps_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Apps ']");
	private By premium_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By volume_col=By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By exportBtn=By.xpath("//span[text()=' Agency Activity Report ']/ancestor::div/descendant::ion-button[.=' Export ']");
	private By combinedApplPaymentStatusTitle=By.xpath("//ion-title[text()='Combined Application Status and Payments ']");
	private By agentNumberCol=By.xpath("//th[text()=' Agent Number ']");
	private By agentNameCol=By.xpath("//th[text()=' Agent Name ']");
	private By applNumberCol=By.xpath("//th[text()=' Application Number ']");
	private By ownerCol=By.xpath("//th[text()=' Owner ']");
	private By holdDateCol=By.xpath("//th[text()=' Hold Date ']");
	private By applStatusCol=By.xpath("//th[text()=' Application Status ']");
	private By paymentMethodCol=By.xpath("//th[text()=' Payment Method ']");
	private By recurringCol=By.xpath("//th[text()=' Recurring ']");
	private By dateSubmittedCol=By.xpath("//th[text()=' Date Submitted ']");
	private By annualPremiumCol=By.xpath("//th[text()=' Annual Premium ']");
	private By modePremiumCol=By.xpath("//th[text()=' ModePremium ']");
	private By applTypeCol=By.xpath("//th[text()=' Application Type ']");
	private By exportBtnInApplPaymentStatus=By.xpath("//ion-button[.=' Export ']");
	private By combinedRenewalReportTitle=By.xpath("//ion-title[text()='Combined Renewal Premium Report ']");
	private By pastDue=By.xpath("//ion-button[text()=' Past Due ']");
	private By oneMnthArrears=By.xpath("//ion-button[text()=' 1 Month Arrears ']");
	private By dueSoon=By.xpath("//ion-button[text()=' Due Soon ']");
	private By twoMnthArrears=By.xpath("//ion-button[text()=' 2 Month Arrears ']");
	private By allBtn=By.xpath("//ion-button[text()='All ']");
	private By potentialLapse=By.xpath("//ion-button[text()=' Potential Lapse ']");
	private By table=By.xpath("//table");
	private By agentCol=By.xpath("//th[text()=' Agent # ']");
	private By agentNameColInReneWal=By.xpath("//th[text()=' Agent Name ']");
	private By policyCol=By.xpath("//th[text()=' Policy # ']");
	private By ownerColInRenewal=By.xpath("//th[text()=' Owner ']");
	private By ptdCol=By.xpath("//th[text()=' PTD ']");
	private By policyStatusCol=By.xpath("//th[text()=' Policy Status ']");
	private By paymentMethodColInRenewal=By.xpath("//th[text()=' Payment Method ']");
	private By recurringColInRenewal=By.xpath("//th[text()=' Recurring ']");
	private By nxtPaymentDateCol=By.xpath("//th[text()=' Next Payment Date ']");
	private By modeCol=By.xpath("//th[text()=' Mode ']");
	private By modePremiumColInRenewal=By.xpath("//th[text()=' Mode Premium ']");
	private By issuedDateCol=By.xpath("//th[text()=' Issue Date ']");
	private By exportBtn1=By.xpath("//ion-button[.=' Export ']");
	private By searchingSpinner = By.xpath("//div[text()='Searching...']");
	
	
	
	public void agencyDashboard() throws Exception {
		String newTabUrl="chrome://downloads/";
		String jspath="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\")";

		WebUI.verifyElementVisible(combinedDashboard);
		WebUI.verifyElementVisible(combinedActivityReport);
		WebUI.verifyElementVisible(combinedApplPaymentStatus);
		WebUI.verifyElementVisible(combinedRenewalPremiumReport);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(combinedDashboard);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.sleep(1);
		WebUI.verifyElementVisible(ytdProduction);		
		WebUI.verifyElementVisible(resources);
		WebUI.verifyElementVisible(statusOfBook);
		WebUI.verifyElementVisible(quickSearch);
		WebUI.clickElement(issuedCard);
//		WebUI.sleep(5);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.verifyElementVisible(activityReportTitle);
		WebUI.sleep(0.2);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(premiumCard);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.verifyElementVisible(activityReportTitle);
		WebUI.sleep(1);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1.5);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(1.5);
		WebUI.mouseHoverwithaxes(375, 515);
		WebUI.sleep(1);
		WebUI.mouseHoverwithaxes(710, 515);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(InprogressCard);
		WebUI.verifyElementVisible(arrearsCard);
		WebUI.verifyElementVisible(pendingLapseCard);
		String totalInprogressApplicationsInDashboard=WebUI.getTextElement(inprogressApplications).replaceAll(",","").trim();
		WebUI.validateString(totalInprogressApplicationsInDashboard);
		WebUI.clickElement(InprogressCard);
//		WebUI.sleep(6);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.verifyElementVisible(inprogressCardPageTitle);
		String totalApplicationsInInprogressPage=WebUI.getTextElement(countOfApplications).trim();
		WebUI.verifyEquals(totalApplicationsInInprogressPage, totalInprogressApplicationsInDashboard);
		WebUI.sleep(1);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(1);
		WebUI.clickElement(arrearsCard);
		WebUI.waitForPageLoaded();
		WebUI.sleep(3);
		WebUI.verifyElementVisible(arrearsCardPageTitle);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(3);
		String totalOneMonthArrearsApplicationsInDashboard=WebUI.getTextElement(oneMonthArrearsApplications).replaceAll(",","").trim();
		WebUI.validateString(totalInprogressApplicationsInDashboard);
		int totalArrears=Integer.parseInt(totalOneMonthArrearsApplicationsInDashboard);
		System.out.println(totalArrears);
		WebUI.clickElement(arrearsCard);
		WebUI.sleep(3.5);
		WebUI.verifyElementVisible(arrearsCardPageTitle);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(0.3);
		WebUI.clickElement(pagenationDropdown);
		WebUI.sleep(0.2);
		WebUI.selectOptionByText(pagenationDropdown, "50");
		WebUI.sleep(2);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(1);
		String totalNoOfPendingLapseApplications= WebUI.getTextElement(pendingLapseCardValue).replaceAll(",","").trim();
		WebUI.validateString(totalNoOfPendingLapseApplications);
		WebUI.clickElement(pendingLapseCard);
		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(arrearsCardPageTitle);
		WebUI.sleep(1);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1.5);
		WebUI.clickElementWithJs(combinedDashboard);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(agentsDropdown);
		WebUI.clickElement(agentsDropdown);
		WebUI.sleep(0.3);
		WebUI.verifyElementVisible(DropdownList);
		WebUI.clickElement(DropdownListThree);
		WebUI.sleep(3);
		WebUI.verifyElementVisible(individualProduction);
		String totalInProgressAppsInSelectedAgent=WebUI.getTextElement(agentInprogresscardValue).replaceAll(",","").trim();
		WebUI.verifyNotEquals(totalInprogressApplicationsInDashboard, totalInProgressAppsInSelectedAgent);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(combinedActivityReport);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		
		WebUI.verifyElementVisible(combinedActivityReportTitle);
		WebUI.verifyElementVisible(agencySalesSummary);
		WebUI.verifyElementVisible(agencyInforceReport);
		WebUI.verifyElementVisible(agencyActivityReport);
		WebUI.verifyElementVisible(salesColInSalesSummary);
		WebUI.verifyElementVisible(appsColInSalesSummary);
		WebUI.verifyElementVisible(volumeColInSalesSummary);
		WebUI.verifyElementVisible(premiumColInSalesSummary);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(inforceColInInforceActivity);
		WebUI.verifyElementVisible(appsColInInforceActivity);
		WebUI.verifyElementVisible(volumeColInInforceActivity);
		WebUI.verifyElementVisible(premiumColInInforceActivity);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(0.5);
		WebUI.verifyElementVisible(IC_col);
		WebUI.verifyElementVisible(ICName_col);
		WebUI.verifyElementVisible(contract_col);
		WebUI.verifyElementVisible(volume_col);
		WebUI.verifyElementVisible(premium_col);
		WebUI.verifyElementVisible(insured_col);
		WebUI.verifyElementVisible(status_col);
		WebUI.verifyElementVisible(planName_col);
		WebUI.verifyElementVisible(plan_col);
		WebUI.verifyElementVisible(applicationDate_col);
		WebUI.verifyElementVisible(submittedDate_col);
		WebUI.verifyElementVisible(procDate_col);
		WebUI.verifyElementVisible(apps_col);
		WebUI.verifyElementVisible(paidToDate_col);
		WebUI.verifyElementVisible(issuedDate_col);
		WebUI.scrollToElementAtTop(exportBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(exportBtn);
		WebUI.sleep(1);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(2);
		WebUI.switchToMainWindow();
		WebUI.sleep(1);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(combinedApplPaymentStatus);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.verifyElementVisible(combinedApplPaymentStatusTitle);
		WebUI.verifyElementVisible(agentNumberCol);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(applNumberCol);
		WebUI.verifyElementVisible(ownerCol);
		WebUI.verifyElementVisible(holdDateCol);
		WebUI.verifyElementVisible(applStatusCol);
		WebUI.verifyElementVisible(paymentMethodCol);
		WebUI.verifyElementVisible(recurringCol);
		WebUI.verifyElementVisible(dateSubmittedCol);
		WebUI.verifyElementVisible(annualPremiumCol);
		WebUI.verifyElementVisible(modePremiumCol);
		WebUI.verifyElementVisible(applTypeCol);
		WebUI.verifyElementVisible(exportBtnInApplPaymentStatus);
		WebUI.sleep(1);
		WebUI.clickElement(exportBtnInApplPaymentStatus);
		WebUI.sleep(1);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(2);
		WebUI.switchToMainWindow();
		WebUI.sleep(1);
		WebUI.mouseHover(agencyDashboard);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(combinedRenewalPremiumReport);
		try {
			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(2);
		}
		WebUI.verifyElementVisible(combinedRenewalReportTitle);
		WebUI.verifyElementVisible(pastDue);
		WebUI.verifyElementVisible(oneMnthArrears);
		WebUI.verifyElementVisible(twoMnthArrears);
		WebUI.verifyElementVisible(dueSoon);
		WebUI.verifyElementVisible(potentialLapse);
		WebUI.verifyElementVisible(allBtn);
		WebUI.verifyElementVisible(table);
		WebUI.verifyElementVisible(agentCol);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(policyCol);
		WebUI.verifyElementVisible(ownerColInRenewal);
		WebUI.verifyElementVisible(ptdCol);
		WebUI.verifyElementVisible(policyStatusCol);
		WebUI.verifyElementVisible(paymentMethodCol);
		WebUI.verifyElementVisible(recurringColInRenewal);
		WebUI.verifyElementVisible(nxtPaymentDateCol);
		WebUI.verifyElementVisible(modeCol);
		WebUI.verifyElementVisible(modePremiumColInRenewal);
		WebUI.verifyElementVisible(issuedDateCol);
		WebUI.verifyElementVisible(exportBtn1);
		WebUI.scrollToElementAtTop(exportBtn1);
		WebUI.sleep(0.5);
		WebUI.clickElement(exportBtn1);
		WebUI.sleep(1);
		WebUI.openNewTabWindow(newTabUrl);

		
	}
}
