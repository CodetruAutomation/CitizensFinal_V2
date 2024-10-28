package com.codetru.project.cica.pages.dashboardModule;

import org.openqa.selenium.By;

import static com.codetru.keywords.WebUI.*;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Dashboard extends CommonPageCICA {
	private By dashboard=By.xpath("//ion-button[text()=' Dashboard ']");
	private By ytd_production=By.xpath("//ion-title[text()='YTD PRODUCTION']");
	private By statusBook=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']");
	private By resources=By.xpath("//ion-title[text()='Resources']");
	private By customerSearch=By.xpath("//ion-card-title[text()='Customer Quick Search ']");
	private By individualIssuedCard=By.xpath("//h5[text()='Individual Production']/ancestor::ion-col[2]/descendant::ion-card-title[text()='Issued ']/following-sibling::ion-card-content");
	private By agencyIssuedCard=By.xpath("//h5[text()='Agency Production']/ancestor::ion-col[2]/descendant::ion-card-title[text()='Issued ']/following-sibling::ion-card-content");
	private By individualPremiumCard=By.xpath("//h5[text()='Individual Production']/ancestor::ion-col[2]/descendant::ion-card-title[text()='Premium ']/following-sibling::ion-card-content");
	private By agencyPremiumCard=By.xpath("//h5[text()='Agency Production']/ancestor::ion-col[2]/descendant::ion-card-title[text()='Premium ']/following-sibling::ion-card-content");
	private By activityReport=By.xpath("//ion-title[text()='Activity Report ']");
	private By agencySalesSummary=By.xpath("//span[text()=' Agency Sales Summary ']");
	private By agencyInforceReport=By.xpath("//span[text()=' Agency Inforce Report ']");
	private By agencyFilter=By.xpath("//select[@formcontrolname='agencyFilter']");
	private By selectIndividual=By.xpath("//option[text()=' Independent Consultant ']");
	private By selectAgency=By.xpath("//option[text()=' Agency ']");
	private By individualConsultant=By.xpath("//span[contains(text(),'Independent Consultant ')]");
	private By InprogressCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]");
	private By arrearsCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[2]");
	private By pendingLapseCard=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[3]");
	private By InprogressCardPage=By.xpath("//ion-title[text()='Application Status and Payments ']");
	private By arrearsCardpage=By.xpath("//ion-title[text()='Renewal Premium Report ']");
	private By countOfApplications=By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::ion-col[2]");
	private By inprogressApplications=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]/ion-card-content[1]");
	private By oneMonthArrearsApplications=By.xpath("//ion-card-title[text()='1 Month Arrears ']/parent::ion-card-header/following-sibling::ion-card-content");
	private By pendingLapseCardValue=By.xpath("//ion-card-title[text()='Pending Lapse ']/parent::ion-card-header/following-sibling::ion-card-content");
	private By oneMonthArrearsBtn=By.xpath("//ion-button[text()=' 1 Month Arrears ']");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By totalListInOneMonth=By.xpath("//tr/td[1]");
	private By potentialLapseBtn=By.xpath("//ion-button[text()=' Potential Lapse ']");
	private By firstName=By.xpath("//ion-input[@formcontrolname='FirstName']/input");
	private By lastName=By.xpath("//ion-input[@formcontrolname='LastName']/input");
	private By policyNumberField=By.xpath("//ion-input[@formcontrolname='PolicyNumber']/input");
	private By no_result  = By.xpath("//h5[normalize-space()='No Results']");
	private By firstNameInCustomer=By.xpath("(//ion-input[@formcontrolname='FirstName']/input)[2]");
	private By lastNameIncustomer=By.xpath("(//ion-input[@formcontrolname='LastName']/input)[2]");
	private By policyNumberInCustomer=By.xpath("(//ion-input[@formcontrolname='PolicyNumber']/input)[2]");
	private By searchBtn=By.xpath("//ion-button[text()='Search ']");
	private By customerDetails=By.xpath("//ion-title[text()='Customer Search']");
	private By insuredName=By.xpath("//tr/td[3][contains(text(), ',')]");
	private By policyNumberValue=By.xpath("//tr/td[1]");
	private By secondPolicyNumber=By.xpath("//tr[2]/td[1]");

	private By pleaseWaitSpinner = By.xpath("//div[text()='Please Wait…']/parent::div");

	//	Agency Dashboard Locators
	private By agencyDashboard = By.xpath("//ion-button[.=' Agency ']");
	private By combinedDashboard=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Dashboard ']");
	private By combinedActivityReport=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Activity Report ']");
	private By combinedApplPaymentStatus=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Application Payment Status ']");
	private By combinedRenewalPremiumReport=By.xpath("//div[@class='agencyDropdown']/div/ion-item[text()=' Combined Renewal Premium Report ']");
	private By ytdProduction=By.xpath("//ion-title[text()='YTD PRODUCTION']");
	private By statusOfBook=By.xpath("//ion-title[text()='STATUS OF BOOK OF BUSINESS ']");
	private By quickSearch=By.xpath("//ion-card-title[text()='Customer Quick Search ']");
	private By issuedCard=By.xpath("//ion-card-title[text()='Issued ']/following-sibling::ion-card-content/canvas");
	private By premiumCard=By.xpath("//ion-card-title[text()='Premium ']/following-sibling::ion-card-content/canvas");
	private By activityReportTitle=By.xpath("//ion-title[text()='Combined Activity Report ']");
	private By inprogressCardPageTitle=By.xpath("//ion-title[text()='Combined Application Status and Payments ']");
	private By arrearsCardPageTitle=By.xpath("//ion-title[text()='Combined Renewal Premium Report ']");
	private By agentsDropdown=By.xpath("//select[@formcontrolname='agentddl']");
	private By DropdownList=By.xpath("//option[starts-with(text(),'7250')]");
	private By DropdownListThree=By.xpath("(//option[starts-with(text(),'7250')])[3]");
	private By agentInprogresscardValue=By.xpath("(//ion-title[text()='STATUS OF BOOK OF BUSINESS ']/ancestor::ion-col[2]/descendant::ion-card[1]/ion-card-content[1])[2]");
	private By individualProduction=By.xpath("//h5[text()='Individual Production']");
	private By combinedActivityReportTitle=By.xpath("//ion-title[text()='Combined Activity Report ']");
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


	public void dashboard_module() throws Exception {
		String[] name;
		String fname;
		String lname;
		String policyNumber="220000";
		String No_result = "No Results";

		String newTabUrl="chrome://downloads/";
		String jspath="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\")";


		sleep(2);
		verifyElementVisible(ytd_production);
		verifyElementVisible(statusBook);
		verifyElementVisible(resources);
		verifyElementVisible(customerSearch);
		verifyElementClickable(individualIssuedCard);
		verifyElementClickable(agencyIssuedCard);
		verifyElementClickable(individualPremiumCard);
		verifyElementClickable(agencyPremiumCard);
		sleep(1.5);
		mouseHoverwithaxes(165, 520);
		sleep(1.5);
		mouseHoverwithaxes(410, 520);
		sleep(1.5);
		mouseHoverwithaxes(650, 520);
		sleep(1.5);
		mouseHoverwithaxes(900, 520);
		sleep(1.5);
		clickElement(individualIssuedCard);
		sleep(3);
		//		 verifyElementVisible(individualConsultant);  //User should see the Individual Consultant deata
		//		 sleep(3);
		clickElement(agencyFilter);
		sleep(1);
		clickElement(selectIndividual);
		sleep(1.5);
		//		 verifyElementVisible(individualConsultant);
		clickElement(dashboard);
		WebUI.sleep(0.2);
		clickElement(individualPremiumCard);
		sleep(3);
		// verifyElementVisible(individualConsultant);  //User should see the Individual Consultant deata
		//		 sleep(3);
		//		 verifyElementVisible(activityReport);
		clickElement(agencyFilter);
		sleep(1);
		clickElement(selectIndividual);
		sleep(1);
		//		 verifyElementVisible(individualConsultant);
		clickElement(dashboard);
		sleep(1);
		clickElement(agencyIssuedCard);
		sleep(1);
		verifyElementVisible(activityReport);
		sleep(1);
		clickElement(agencyFilter);
		clickElement(selectAgency);
		sleep(1);
		//		 verifyElementVisible(agencySalesSummary);
		//		 verifyElementVisible(agencyInforceReport);
		clickElement(dashboard);
		sleep(1);
		clickElement(agencyPremiumCard);
		sleep(1);
		//		 verifyElementVisible(activityReport);
		clickElement(agencyFilter);
		sleep(1);
		clickElement(selectAgency);
		sleep(1);
		//		 verifyElementVisible(agencySalesSummary);
		//		 verifyElementVisible(agencyInforceReport);
		clickElement(dashboard);
		sleep(2);
		//		 verifyElementClickable(InprogressCard);
		//		 verifyElementClickable(arrearsCard);
		//		 verifyElementClickable(pendingLapseCard);
		String totalInprogressApplicationsInDashboard= getTextElement(inprogressApplications).trim();
		validateString(totalInprogressApplicationsInDashboard);
		clickElement(InprogressCard);
		//		 verifyElementVisible(InprogressCardPage);
		sleep(2);
		String totalApplicationsInInprogressPage= getTextElement(countOfApplications).trim();
		verifyEquals(totalApplicationsInInprogressPage, totalInprogressApplicationsInDashboard);
		clickElement(dashboard);
		String totalOneMonthArrearsApplicationsInDashboard= getTextElement(oneMonthArrearsApplications).trim();
		validateString(totalInprogressApplicationsInDashboard);
		int totalArrears=Integer.parseInt(totalOneMonthArrearsApplicationsInDashboard);
		clickElement(arrearsCard);
		verifyElementVisible(arrearsCardpage);
		WebUI.sleep(1);
		try {
			while(DriverManager.getDriver().findElement(pleaseWaitSpinner).isDisplayed())
			{
				continue;
			}
		}catch(Exception ex)
		{
			System.out.println("");
			WebUI.sleep(1);
		}
		clickElement(oneMonthArrearsBtn);
		sleep(2);
		scrollToElementAtBottom(pagenation);
		sleep(0.5);
		clickElement(pagenationDropdown);
		selectOptionByText(pagenationDropdown, "50");
		sleep(1);
		int No_ofRows=	 getWebElements(totalListInOneMonth).size();
		//		 verifyEquals(totalArrears, No_ofRows);
		clickElement(dashboard);
		String totalNoOfPendingLapseApplications=  getTextElement(pendingLapseCardValue);
		validateString(totalNoOfPendingLapseApplications);
		clickElement(pendingLapseCard);
		sleep(1);
		clickElement(potentialLapseBtn);
		sleep(1);
		clickElement(dashboard);
		sleep(0.2);
		scrollToElementAtBottom(searchBtn);
		sleep(0.2);
		clickElement(searchBtn);
		sleep(3);
		verifyElementVisible(customerDetails);
		String policy=  getTextElement(secondPolicyNumber);
		name= 	 getTextElement(insuredName).split(",");
		fname=name[0];
		lname=name[1];
		System.out.println(fname);
		System.out.println(lname);
		clickElement(dashboard);
		setText(firstName, fname);
		clickElement(searchBtn);
		sleep(3);
		String fNameValue= getAttributeElement(firstNameInCustomer, "value");
		verifyEquals(fNameValue, fname);
		String InsuredFullName= getTextElement(insuredName);
		verifyContains(InsuredFullName, fname);
		clickElement(dashboard);
		setText(lastName, lname);
		clickElement(searchBtn);
		sleep(3);
		String lNameValue= getAttributeElement(lastNameIncustomer, "value");
		verifyEquals(lNameValue, lname);
		InsuredFullName= getTextElement(insuredName);
		verifyContains(InsuredFullName, lname);
		clickElement(dashboard);
		setText(policyNumberField, policyNumber);
		clickElement(searchBtn);
		sleep(3);
		String policy_number= getAttributeElement(policyNumberInCustomer, "value");
		verifyEquals(policy_number, policyNumber);
		String policy_no= getTextElement(policyNumberValue);
		verifyContains(policy_no, policyNumber);
		clickElement(dashboard);
		setText(policyNumberField, policy);
		clickElement(searchBtn);
		sleep(3);
		//		String policy_number= getAttributeElement(policyNumberInCustomer, "value");
		//		 verifyEquals(policy_number, policyNumber);
		//		 try {
		//			 DriverManager.getDriver().findElement(policyNumberValue).isDisplayed();
		//		String policy_no= getTextElement(policyNumberValue);
		//		 verifyContains(policy_no, policyNumber);
		//		 }catch(Exception e){
		//			 sleep(1.5);
		//			 verifyElementVisible(no_result);	
		//			 verifyContains(getTextElement(no_result).trim(), No_result);
		//		 }
		//		 
		//		 clickElement(dashboard);
		//		 setText(policyNumberField, policy);
		//		 clickElement(searchBtn);
		
		String policy_number2= getTextElement(policyNumberValue);
		verifyEquals(policy_number2, policy);
		clickElement(dashboard);
		setText(firstName, "!@df123g");
		clickElement(searchBtn);
		sleep(1.5);
		verifyElementVisible(no_result);	
		verifyContains(getTextElement(no_result).trim(), No_result);
		sleep(1.5);
		clickElement(dashboard);
		setText(lastName, "!@df123g");
		clickElement(searchBtn);
		sleep(1.5);
		verifyElementVisible(no_result);	
		verifyContains(getTextElement(no_result).trim(), No_result);
		sleep(1.5);
		clickElement(dashboard);
		setText(policyNumberField, "!@df123g");
		clickElement(searchBtn);
		sleep(1.5);
		verifyElementVisible(no_result);	
		verifyContains(getTextElement(no_result).trim(), No_result);
		sleep(1.5);
		clickElement(dashboard);

//====================================== Agency Dashboard Module =======================================================
		WebUI.waitForPageLoaded();
		sleep(2);
		try {
			DriverManager.getDriver().findElement(agencyDashboard);
			WebUI.verifyElementPresent(agencyDashboard);
			WebUI.verifyElementClickable(agencyDashboard);
			WebUI.mouseHover(agencyDashboard);
			WebUI.sleep(2);

			WebUI.verifyElementVisible(combinedDashboard);
			WebUI.verifyElementVisible(combinedActivityReport);
			WebUI.verifyElementVisible(combinedApplPaymentStatus);
			WebUI.verifyElementVisible(combinedRenewalPremiumReport);
			WebUI.sleep(1);
			WebUI.clickElementWithJs(combinedDashboard);
			WebUI.sleep(0.5);
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
			WebUI.verifyElementVisible(ytdProduction);		
			WebUI.verifyElementVisible(resources);
			WebUI.verifyElementVisible(statusOfBook);
			WebUI.verifyElementVisible(quickSearch);
			WebUI.clickElement(issuedCard);
			WebUI.sleep(0.5);
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
			WebUI.sleep(0.5);
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
			String totalInprogressApplicationsInDashboard1=WebUI.getTextElement(inprogressApplications).replaceAll(",","").trim();
			WebUI.validateString(totalInprogressApplicationsInDashboard1);
			WebUI.clickElement(InprogressCard);
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
			WebUI.verifyElementVisible(inprogressCardPageTitle);
			String totalApplicationsInInprogressPage1=WebUI.getTextElement(countOfApplications).trim();
			WebUI.verifyEquals(totalApplicationsInInprogressPage1, totalInprogressApplicationsInDashboard1);
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
			String totalOneMonthArrearsApplicationsInDashboard1=WebUI.getTextElement(oneMonthArrearsApplications).replaceAll(",","").trim();
			WebUI.validateString(totalInprogressApplicationsInDashboard1);
			int totalArrears1=Integer.parseInt(totalOneMonthArrearsApplicationsInDashboard1);
			System.out.println(totalArrears1);
			WebUI.clickElement(arrearsCard);
			WebUI.sleep(0.5);
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
			String totalNoOfPendingLapseApplications1= WebUI.getTextElement(pendingLapseCardValue).replaceAll(",","").trim();
			WebUI.validateString(totalNoOfPendingLapseApplications1);
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
			WebUI.sleep(1.5);
			WebUI.verifyElementVisible(individualProduction);
			String totalInProgressAppsInSelectedAgent=WebUI.getTextElement(agentInprogresscardValue).replaceAll(",","").trim();
			WebUI.verifyNotEquals(totalInprogressApplicationsInDashboard1, totalInProgressAppsInSelectedAgent);
			WebUI.mouseHover(agencyDashboard);
			WebUI.sleep(2);
			WebUI.clickElementWithJs(combinedActivityReport);
			WebUI.sleep(0.5);
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
			WebUI.sleep(0.5);
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
			WebUI.sleep(0.5);
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

			WebUI.switchToMainWindow();
			WebUI.sleep(1);

		} catch (Exception exception) {
			WebUI.logInfoMessage("Agency Dashboard is not available.");
		}
	}
}
