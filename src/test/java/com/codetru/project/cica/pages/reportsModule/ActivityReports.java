package com.codetru.project.cica.pages.reportsModule;

import java.util.List;

import org.openqa.selenium.By;

import static com.codetru.keywords.WebUI.*;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class ActivityReports extends CommonPageCICA {

	private By title = By.xpath("//ion-title[text()='Activity Report ']");
	private By agentFilter = By.xpath("//ion-icon[@id='LoadingAgents']/ancestor::agent-filter");
	private By dateFilter = By.xpath("//ion-icon[@name='calendar']/ancestor::date-filter");
	private By agencyFilter = By.xpath("//select[@id='agentdd']/ancestor::agency-filter");
	private By agnecyfilterDropdown = By.xpath("//select[@formcontrolname='agencyFilter']");
	private By agencySalesSummary = By.xpath("//span[text()=' Agency Sales Summary ']/parent::h3/parent::div");
	private By agencyInforceReport = By.xpath("//span[text()=' Agency Inforce Report ']/parent::h3/parent::div");
	private By agencyActivityReport = By.xpath("//span[text()=' Agency Activity Report ']/parent::h3/parent::div");
	private By agentCaret_btn = By.xpath("//ion-icon[@name='caret-down']");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn = By.xpath("//ion-button[text()='Close']");
	private By searchBar = By.xpath("//ion-searchbar[@type='text']");
	private By agentsText = By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput = By.xpath("//input[@aria-label='search text']");
	private By resetBtn = By.xpath("//button[@aria-label='reset']");
	private By HighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By secondHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[2]");
	private By thirdHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[3]");
	private By fourthHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[4]");
	private By fifthHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[5]");
	private By pagenation = By.xpath("//ion-col[contains(text(), 'Page')]");
	private By IdNumber = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[1]");
	private By ICNameData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[2]");
	private By contractData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[3]");
	private By insuredData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[4]");
	private By statusData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[5]");
	private By planNameData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[6]");
	private By planData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[7]");
	private By applicationDateData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[8]");
	private By submittedDateData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[9]");
	private By procDateData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[10]");
	private By issuedDateData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[11]");
	private By paidTodDateData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[12]");
	private By appsData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[13]");
	private By volumeData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[14]");
	private By premiumData = By.xpath("//th[text()='IC #']/ancestor::table/tbody/tr/td[15]");

	private By noResult = By.xpath("//th[text()='IC #']/ancestor::ion-row/following-sibling::div/h5");
	private By calendar = By.xpath("//select[@formcontrolname='dateFilter']");
	private By mnthsDropdown = By.xpath("//select[@formcontrolname='dateFilter']/option");
	private By selectAgency = By.xpath("//option[text()=' Agency ']");
	private By selectIndividual = By.xpath("//option[text()=' Independent Consultant ']");
	private By independentSalesSummary = By
			.xpath("//span[text()=' Independent Consultant Sales Report ']/parent::h3/parent::div");
	private By independentInforceReport = By
			.xpath("//span[text()=' Independent Consultant Inforce Report ']/parent::h3/parent::div");
	private By independentActivityReport = By
			.xpath("//span[text()=' Independent Consultant Activity Report ']/parent::h3/parent::div");
	private By salesActivityCol = By.xpath(
			"//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Sales Activities']");
	private By appCol = By.xpath(
			"//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Apps']");
	private By volumeCol = By.xpath(
			"//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By premiumCol = By.xpath(
			"//span[text()=' Agency Sales Summary ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By pendingRow = By.xpath("//td[contains(text(), 'PENDING')]");
	private By pendingAppsColData = By.xpath("//td[contains(text(), 'PENDING')]/following-sibling::td");
	private By pendingVolumeColData = By.xpath("//td[contains(text(), 'PENDING')]/following-sibling::td[2]");
	private By pendingPremiumColData = By.xpath("//td[contains(text(), 'PENDING')]/following-sibling::td[3]");
	private By submittedRow = By.xpath("//td[text()='+SUBMITTED MTD']");
	private By submittedAppsColData = By.xpath("//td[contains(text(), 'SUBMITTED')]/following-sibling::td");
	private By submittedVolumeColData = By.xpath("//td[contains(text(), 'SUBMITTED')]/following-sibling::td[2]");
	private By submittedPremiumColData = By.xpath("//td[contains(text(), 'SUBMITTED')]/following-sibling::td[3]");
	private By reopenedRow = By.xpath("//td[text()='+RE-OPENED MTD']");
	private By reopenedAppsColData = By.xpath("//td[contains(text(), 'RE-OPENED')]/following-sibling::td");
	private By reopenedVolumeColData = By.xpath("//td[contains(text(), 'RE-OPENED')]/following-sibling::td[2]");
	private By reopenedPremiumColData = By.xpath("//td[contains(text(), 'RE-OPENED')]/following-sibling::td[3]");
	private By rejectedRow = By.xpath("//td[text()='-REJECTED  MTD']");
	private By rejectedAppsColData = By.xpath("//td[contains(text(), 'REJECTED')]/following-sibling::td");
	private By rejectedVolumeColData = By.xpath("//td[contains(text(), 'REJECTED')]/following-sibling::td[2]");
	private By rejectedPremiumColData = By.xpath("//td[contains(text(), 'REJECTED')]/following-sibling::td[3]");
	private By withdrawnRow = By.xpath("//td[text()='-WITHDRAWN MTD']");
	private By withdrawnAppsColData = By.xpath("//td[contains(text(), 'WITHDRAWN')]/following-sibling::td");
	private By withdrawnVolumeColData = By.xpath("//td[contains(text(), 'WITHDRAWN')]/following-sibling::td[2]");
	private By withdrawnPremiumColData = By.xpath("//td[contains(text(), 'WITHDRAWN')]/following-sibling::td[3]");
	private By paidRow = By.xpath("//td[text()='-PAID      MTD']");
	private By paidAppsColData = By.xpath("//td[contains(text(), 'PAID')]/following-sibling::td");
	private By paidVolumeColData = By.xpath("//td[contains(text(), 'PAID')]/following-sibling::td[2]");
	private By paidPremiumColData = By.xpath("//td[contains(text(), 'PAID')]/following-sibling::td[3]");
	private By pendingRow2 = By.xpath("(//td[contains(text(), 'PENDING')])[2]");
	private By pending2AppsColData = By.xpath("(//td[contains(text(), 'PENDING')])[2]/following-sibling::td");
	private By pending2VolumeColData = By.xpath("(//td[contains(text(), 'PENDING')])[2]/following-sibling::td[2]");
	private By pending2PremiumColData = By.xpath("(//td[contains(text(), 'PENDING')])[2]/following-sibling::td[3]");
	private By inforceActivity = By.xpath(
			"//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='In-Force Activity']");
	private By inforceAppsCol = By.xpath(
			"//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Apps']");
	private By inforceVolumeCol = By.xpath(
			"//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By inforcePremiumCol = By.xpath(
			"//span[text()=' Agency Inforce Report ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By paidMtdRow = By.xpath("//td[text()='PAID MTD']");
	private By inforcePaidAppcolData = By.xpath("//td[contains(text(), 'PAID MTD')]/following-sibling::td");
	private By inforcePaidVolumecolData = By.xpath("(//td[contains(text(), 'PAID MTD')]/following-sibling::td)[2]");
	private By inforcePaidPremiumcolData = By.xpath("(//td[contains(text(), 'PAID MTD')]/following-sibling::td)[3]");
	private By notTakenMtdRow = By.xpath("//td[text()='-NOT TAKEN MTD']");
	private By inforceNotTakenAppsColData = By.xpath("//td[contains(text(), 'NOT TAKEN')]/following-sibling::td");
	private By inforceNotTakenVolumeColData = By
			.xpath("(//td[contains(text(), 'NOT TAKEN')]/following-sibling::td)[2]");
	private By inforceNotTakenPremiumColData = By
			.xpath("(//td[contains(text(), 'NOT TAKEN')]/following-sibling::td)[3]");
	private By lapseMtdRow = By.xpath("//td[text()='-LAPSE/SURR MTD']");
	private By inforceLapseAppsColData = By.xpath("//td[contains(text(), 'LAPSE/SURR')]/following-sibling::td");
	private By inforceLapseVolumeColData = By.xpath("(//td[contains(text(), 'LAPSE/SURR')]/following-sibling::td)[2]");
	private By inforceLapsePremiumColData = By.xpath("(//td[contains(text(), 'LAPSE/SURR')]/following-sibling::td)[3]");
	private By miscMtdRow = By.xpath("//td[text()='+MISC INCR/DECR MTD']");
	private By inforceMiscAppsColData = By.xpath("//td[contains(text(), 'MISC')]/following-sibling::td");
	private By inforceMiscVolumeColData = By.xpath("(//td[contains(text(), 'MISC')]/following-sibling::td)[2]");
	private By inforceMiscPremiumColData = By.xpath("(//td[contains(text(), 'MISC')]/following-sibling::td)[3]");
	private By nifc_Row = By.xpath("//td[text()='NET IN FORCE CHANGE']");
	private By inforceNifcAppsColData = By.xpath("//td[contains(text(), 'NET IN FORCE')]/following-sibling::td");
	private By inforceNifcVolumeColData = By.xpath("(//td[contains(text(), 'NET IN FORCE')]/following-sibling::td)[2]");
	private By inforceNifcPremiumColData = By
			.xpath("(//td[contains(text(), 'NET IN FORCE')]/following-sibling::td)[3]");
	private By IC_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='IC #']");
	private By ICName_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='IC Name']");
	private By contract_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Contract # ']");
	private By insured_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Insured']");
	private By status_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Status']");
	private By planName_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Plan Name']");
	private By plan_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Plan']");
	private By applicationDate_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Application Date ']");
	private By submittedDate_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Submitted Date ']");
	private By procDate_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Proc Date']");
	private By issuedDate_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Issued Date']");
	private By paidToDate_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Paid To Date ']");
	private By apps_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Apps ']");
	private By premium_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Premium']");
	private By volume_col = By.xpath(
			"//span[text()=' Agency Activity Report ']/parent::h3/following-sibling::div/descendant::th[text()='Volume']");
	private By exportBtn = By
			.xpath("//span[text()=' Agency Activity Report ']/ancestor::div/descendant::ion-button[.=' Export ']");
	private By searchingSpinner = By.xpath("//div[text()='Searching...']");

	public void activityReports() throws Exception {
		String id = null;
		String fullName = null;
		String[] nameParts = null;
		String lastName = null;
		String firstName = null;

		waitForPageLoaded(3);
		verifyElementVisible(title);
		sleep(1);
		verifyElementVisible(agentFilter);
		verifyElementVisible(dateFilter);
		verifyElementVisible(agencyFilter);
		verifyElementVisible(agencySalesSummary);
		verifyElementVisible(agencyInforceReport);
		verifyElementVisible(agencyActivityReport);
	
		sleep(1.5);
		clickElement(agentCaret_btn);
		sleep(4);
		verifyElementVisible(agentsList);
		verifyElementVisible(closeBtn);
		verifyElementVisible(searchBar);
		clickElement(closeBtn);
		verifyElementNotVisible(agentsList);
		clickElement(agentCaret_btn);
		setText(searchBoxInput, "55555");
		sleep(0.6);
		verifyElementNotVisible(agentsText);
		clearText(searchBoxInput);
		setText(searchBoxInput, "Japfu");
		sleep(0.6);
		verifyElementNotVisible(agentsText);
		clearText(searchBoxInput);
		setText(searchBoxInput, "magpie");
		sleep(0.6);
		verifyElementNotVisible(agentsText);
		clearText(searchBoxInput);
		sleep(1);
		clickElement(resetBtn);
		sleep(1);
		List<String> listNames = getElementTextsInList(agentsText);
		int count = 0;
		for (String name : listNames) {
			if (count >= 5) {
				break;
			}
			id = name.split("-")[2].trim();
			fullName = name.split("-")[3].trim();
			nameParts = fullName.split(",");
			lastName = nameParts[0];
			firstName = nameParts[1];
			setText(searchBoxInput, id);
			sleep(1);
			verifyContains(getTextElement(agentsText), id);
			sleep(0.2);
			clearText(searchBoxInput);
			setText(searchBoxInput, firstName);
			sleep(1);
			verifyContains(getTextElement(agentsText), firstName);
			sleep(0.2);
			clearText(searchBoxInput);
			setText(searchBoxInput, lastName);
			sleep(1);
			verifyContains(getTextElement(agentsText), lastName);
			sleep(0.2);
			clearText(searchBoxInput);
			count++;
			System.out.println(count);
		}
		clickElement(resetBtn);
		clickElement(closeBtn);
		clickElement(agentCaret_btn);
		sleep(2);
		String Id1 = validateElementContainsDataAndExtractID(HighestLevel);
		String Id2 = validateElementContainsDataAndExtractID(secondHighestLevel);
		String Id3 = validateElementContainsDataAndExtractID(thirdHighestLevel);
		String Id4 = validateElementContainsDataAndExtractID(fourthHighestLevel);
		String Id5 = validateElementContainsDataAndExtractID(fifthHighestLevel);
		System.out.println(Id3);
		//sleep(2);
		clickElement(HighestLevel);
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
		scrollToElementAtBottom(pagenation);
		List<String> Ids = getElementTextsInList(IdNumber);
		System.out.println(Ids);
		if (verifyElementVisible(IdNumber)) {
			verifyContainsIgnore(Ids, Id1);
			verifyContainsIgnore(Ids, Id2);
			verifyContainsIgnore(Ids, Id3);
			verifyContainsIgnore(Ids, Id4);
			verifyContainsIgnore(Ids, Id5);
		} else {
			verifyElementVisible(noResult);
			scrollToElementAtTop(agentCaret_btn);
			clickElement(thirdHighestLevel);
			clickElement(thirdHighestLevel);
		}

		scrollToElementAtTop(agentCaret_btn);
		clickElement(agentCaret_btn);
		clickElement(thirdHighestLevel);
		sleep(2);
		scrollToElementAtBottom(pagenation);
		List<String> Ids3 = getElementTextsInList(IdNumber);
		System.out.println(Ids3);
		if (verifyElementVisible(IdNumber)) {
			verifyContainsIgnore(Ids3, Id3);
			verifyNotContains(Ids3, Id1);

		} else {
			verifyElementVisible(noResult);
		}
		scrollToElementAtTop(agentCaret_btn);
		clickElement(agentCaret_btn);
		clickElement(HighestLevel);
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
		clickElement(calendar);
		List<String> mnths = getElementTextsInList(mnthsDropdown);
		verifyEquals(mnths.size(), 13);
		clickElement(agnecyfilterDropdown);
		verifyElementVisible(selectAgency);
		verifyElementVisible(selectIndividual);
		clickElement(selectIndividual);
		verifyElementVisible(independentSalesSummary);
		verifyElementVisible(independentInforceReport);
		verifyElementVisible(independentActivityReport);
		scrollToElementAtBottom(pagenation);
		String idNumberCellData=getTextElement(IdNumber);
		validateElementContainsData(idNumberCellData);    //IC# column shouldn't be blank
		scrollToElementAtBottom(pagenation);
		String icNameCellData=getTextElement(ICNameData);
		validateElementContainsData(icNameCellData);    //ICName column shouldn't be blank
		sleep(2);
		clickElement(agnecyfilterDropdown);
		clickElement(selectAgency);
		verifyElementVisible(salesActivityCol);
		verifyElementVisible(appCol);
		verifyElementVisible(volumeCol);
		verifyElementVisible(premiumCol);
		sleep(2);
		verifyElementVisible(pendingRow);
		String pendingAppsData = getTextElement(pendingAppsColData);
		validateElementContainsData(pendingAppsData);
		String pendingVolumeData = getTextElement(pendingVolumeColData);
		validateElementContainsData(pendingVolumeData);
		String pendingPremiumData = getTextElement(pendingPremiumColData);
		validateElementContainsData(pendingPremiumData);
		verifyElementVisible(submittedRow);
		String submittedAppsData = getTextElement(submittedAppsColData);
		validateElementContainsData(submittedAppsData);
		String submittedVolumeData = getTextElement(submittedVolumeColData);
		validateElementContainsData(submittedVolumeData);
		String submittedPremiumData = getTextElement(submittedPremiumColData);
		validateElementContainsData(submittedPremiumData);
		verifyElementVisible(reopenedRow);
		String reopenedAppsData = getTextElement(reopenedAppsColData);
		validateElementContainsData(reopenedAppsData);
		String reopenedVolumeData = getTextElement(reopenedVolumeColData);
		validateElementContainsData(reopenedVolumeData);
		String reopenedPremiumData = getTextElement(reopenedPremiumColData);
		validateElementContainsData(reopenedPremiumData);
		verifyElementVisible(rejectedRow);
		String rejectedAppsData = getTextElement(rejectedAppsColData);
		validateElementContainsData(rejectedAppsData);
		String rejectedVolumeData = getTextElement(rejectedVolumeColData);
		validateElementContainsData(rejectedVolumeData);
		String rejectedPremiumData = getTextElement(rejectedPremiumColData);
		validateElementContainsData(rejectedPremiumData);
		verifyElementVisible(withdrawnRow);
		String withdrawnAppsData = getTextElement(withdrawnAppsColData);
		validateElementContainsData(withdrawnAppsData);
		String withdrawnVolumeData = getTextElement(withdrawnVolumeColData);
		validateElementContainsData(withdrawnVolumeData);
		String withdrawnPremiumData = getTextElement(withdrawnPremiumColData);
		validateElementContainsData(withdrawnPremiumData);
		verifyElementVisible(paidRow);
		String paidAppsData = getTextElement(paidAppsColData);
		validateElementContainsData(paidAppsData);
		String paidVolumeData = getTextElement(paidVolumeColData);
		validateElementContainsData(paidVolumeData);
		String paidPremiumData = getTextElement(paidPremiumColData);
		validateElementContainsData(paidPremiumData);
		verifyElementVisible(pendingRow2);
		String pending2AppsData = getTextElement(pending2AppsColData);
		validateElementContainsData(pending2AppsData);
		String pending2VolumeData = getTextElement(pending2VolumeColData);
		validateElementContainsData(pending2VolumeData);
		String pending2PremiumData = getTextElement(pending2PremiumColData);
		validateElementContainsData(pending2PremiumData);

		verifyElementVisible(inforceActivity);
		verifyElementVisible(inforceAppsCol);
		verifyElementVisible(inforceVolumeCol);
		verifyElementVisible(inforcePremiumCol);
		verifyElementVisible(paidMtdRow);
		String inforcePaidAppsData = getTextElement(inforcePaidAppcolData);
		validateElementContainsData(inforcePaidAppsData);
		double inforcePaidAppsDataDouble = roundOf(inforcePaidAppsData);
		String inforcePaidVolumeData = getTextElement(inforcePaidVolumecolData);
		validateElementContainsData(inforcePaidVolumeData);
		double inforcePaidVolumeDataDouble = roundOf(inforcePaidVolumeData);
		String inforcePaidPremiumData = getTextElement(inforcePaidPremiumcolData);
		validateElementContainsData(inforcePaidPremiumData);
		double inforcePaidPremiumDataDouble = roundOf(inforcePaidPremiumData);
		System.out.println(inforcePaidPremiumDataDouble);

		verifyElementVisible(notTakenMtdRow);
		String inforceNotTakenAppsData = getTextElement(inforceNotTakenAppsColData);
		validateElementContainsData(inforceNotTakenAppsData);
		double inforceNotTakenAppsDataDouble = roundOf(inforceNotTakenAppsData);
		String inforceNotTakenVolumeData = getTextElement(inforceNotTakenVolumeColData);
		validateElementContainsData(inforceNotTakenVolumeData);
		double inforceNotTakenVolumeDataDouble = roundOf(inforceNotTakenVolumeData);
		String inforceNotTakenPremiumData = getTextElement(inforceNotTakenPremiumColData);
		validateElementContainsData(inforceNotTakenPremiumData);
		double inforceNotTakenPremiumDataDouble = roundOf(inforceNotTakenPremiumData);
		System.out.println(inforceNotTakenPremiumDataDouble);

		verifyElementVisible(lapseMtdRow);
		String inforceLapseAppsData = getTextElement(inforceLapseAppsColData);
		validateElementContainsData(inforceLapseAppsData);
		double inforceLapseAppsDataDouble = roundOf(inforceLapseAppsData);
		String inforceLapseVolumeData = getTextElement(inforceLapseVolumeColData);
		validateElementContainsData(inforceLapseVolumeData);
		double inforceLapseVolumeDataDouble = roundOf(inforceLapseVolumeData);
		String inforceLapsePremiumData = getTextElement(inforceLapsePremiumColData);
		validateElementContainsData(inforceLapsePremiumData);
		double inforceLapsePremiumDataDouble = roundOf(inforceLapsePremiumData);
		System.out.println(inforceLapsePremiumDataDouble);

		verifyElementVisible(miscMtdRow);
		String inforceMiscAppsData = getTextElement(inforceMiscAppsColData);
		validateElementContainsData(inforceMiscAppsData);
		double inforceMiscAppsDataDouble = Double.parseDouble(inforceMiscAppsData);
		String inforceMiscVolumeData = getTextElement(inforceMiscVolumeColData);
		validateElementContainsData(inforceMiscVolumeData);
		double inforceMiscVolumeDataDouble = roundOf(inforceMiscVolumeData);
		String inforceMiscPremiumData = getTextElement(inforceMiscPremiumColData);
		validateElementContainsData(inforceMiscPremiumData);
		double inforceMiscPremiumDataDouble = roundOf(inforceMiscPremiumData);
		System.out.println(inforceMiscPremiumDataDouble);

		verifyElementVisible(nifc_Row);
		String inforceNifcAppsData = getTextElement(inforceNifcAppsColData);
		validateElementContainsData(inforceNifcAppsData);
		double inforceNifcAppsDataDouble = Double.parseDouble(inforceNifcAppsData);
		String inforceNifcVolumeData = getTextElement(inforceNifcVolumeColData);
		validateElementContainsData(inforceNifcVolumeData);
		double inforceNifcVolumeDataDouble = roundOf(inforceNifcVolumeData);
		String inforceNifcPremiumData = getTextElement(inforceNifcPremiumColData);
		validateElementContainsData(inforceNifcPremiumData);
		double inforceNifcPremiumDataDouble = roundOf(inforceNifcPremiumData);

		verifyEquals(inforceNifcAppsDataDouble, (inforcePaidAppsDataDouble + inforceMiscAppsDataDouble
				- inforceLapseAppsDataDouble - inforceNotTakenAppsDataDouble));
		verifyEquals(inforceNifcVolumeDataDouble, (inforcePaidVolumeDataDouble + inforceMiscVolumeDataDouble
				- inforceLapseVolumeDataDouble - inforceNotTakenVolumeDataDouble));
		verifyEquals(inforceNifcPremiumDataDouble, roundOfDouble(inforcePaidPremiumDataDouble
				+ inforceMiscPremiumDataDouble - inforceLapsePremiumDataDouble - inforceNotTakenPremiumDataDouble));
		clickElement(agentCaret_btn);
		clickElement(HighestLevel);
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
		scrollToElementAtBottom(pagenation);
		verifyElementVisible(IC_col);
		verifyElementVisible(ICName_col);
		verifyElementVisible(contract_col);
		verifyElementVisible(volume_col);
		verifyElementVisible(premium_col);
		verifyElementVisible(insured_col);
		verifyElementVisible(status_col);
		verifyElementVisible(planName_col);
		verifyElementVisible(plan_col);
		verifyElementVisible(applicationDate_col);
		verifyElementVisible(submittedDate_col);
		verifyElementVisible(procDate_col);
		verifyElementVisible(apps_col);
		verifyElementVisible(paidToDate_col);
		verifyElementVisible(issuedDate_col);

		List<String> a_col = getElementTextsInList(IdNumber);
		for (String a : a_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> ICName_col = getElementTextsInList(ICNameData);
		for (String a : ICName_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}
		List<String> contract_col = getElementTextsInList(contractData);
		for (String a : contract_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> insured_col = getElementTextsInList(insuredData);
		for (String a : insured_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> status_col = getElementTextsInList(statusData);
		for (String a : status_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> planName_col = getElementTextsInList(planNameData);
		for (String a : planName_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> plan_col = getElementTextsInList(planData);
		for (String a : plan_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> applicationDate_col = getElementTextsInList(applicationDateData);
		for (String a : applicationDate_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> submittedDate_col = getElementTextsInList(submittedDateData);
		for (String a : submittedDate_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> procdate_col = getElementTextsInList(procDateData);
		for (String a : procdate_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> issuedDate_col = getElementTextsInList(issuedDateData);
		for (String a : issuedDate_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> paidToDate_col = getElementTextsInList(paidTodDateData);

		for (String a : paidToDate_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

	//	ValidatePastAndFutureDate(getTextElement(applicationDateData), getTextElement(paidTodDateData)); //Here paid to date should not be prior to Application date

		List<String> apps_col = getElementTextsInList(appsData);
		for (String a : apps_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}

		List<String> premium_col = getElementTextsInList(premiumData);
		for (String a : premium_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}
		List<String> volume_col = getElementTextsInList(volumeData);
		for (String a : volume_col) {
			validateElementContainsData(a);
			System.out.println(a);
		}
		clickElement(exportBtn);
		sleep(1);
		switchToMainWindow();

	}
}
