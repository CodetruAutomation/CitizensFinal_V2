package com.codetru.project.cica.pages.reportsModule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class PaymentRefusedReport extends CommonPageCICA {

	private By title=By.xpath("//ion-title[text()='Payment Refused Report ']");
	private By agentFilter=By.xpath("//ion-icon[@id='LoadingAgents']/ancestor::agent-filter");
	private By agencyDropdown=By.xpath("//*[@formcontrolname='agencyFilter']");
	private By dateFrom=By.xpath("//ion-label[text()=' Date From ']/following-sibling::input");
	private By dateTo=By.xpath("//ion-label[text()=' Date To ']/following-sibling::input");
	private By agencyValue=By.xpath("//option[.=' Agency ']");

	private By table=By.xpath("//table");
	private By agentDetails=By.xpath("//ion-list-header");
	private By agentCaret_btn=By.xpath("//ion-icon[@name='caret-down']");
//	private By agentsList=By.xpath("//ion-list[@role='list']/parent::ion-list");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn=By.xpath("//ion-button[text()='Close']");
	private By searchBar=By.xpath("//ion-searchbar[@type='text']");
	private By agentsText=By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput=By.xpath("//input[@aria-label='search text']");
	private By resetBtn=By.xpath("//button[@aria-label='reset']");
	private By HighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By secondHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[2]");
	private By thirdHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[3]");
	private By fourthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[4]");
	private By fifthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[5]");
	private By pagenation=By.xpath("//ion-col[contains(text(), 'Page')]");
	private By pageDropdown=By.xpath("//option[.='10']/parent::select");
	private By tableRow=By.xpath("//tbody/tr");

	private By agentNameCol=By.xpath("//th[text()='  Agent Name ']");
	private By policyCol=By.xpath("//th[text()=' Policy # ']");
	private By agentCol=By.xpath("//th[text()=' Agent # ']");
	private By submittedDateCol=By.xpath("//th[text()=' Submitted Date ']");
	private By issueDateCol=By.xpath("//th[text()=' Issue Date ']");
	private By paidToDateCol=By.xpath("//th[text()=' PTD ']");
	private By recurringCol=By.xpath("//th[text()=' Recurring ']");
	private By nxtPaymentCol=By.xpath("//th[text()=' Next Payment ']");
	private By rejectedTypeCol=By.xpath("//th[text()=' Reject Type ']");
	private By refusedDateCol=By.xpath("//th[text()=' Refused Date ']");
	private By refusedAmountCol=By.xpath("//th[text()=' Refused Amount ']");
	private By exportBtn=By.xpath("//ion-button[.=' Export ']");
	private By attemptCol=By.xpath("//th[text()=' Attempt ']");
	private By annualPremiumCol=By.xpath("//th[text()=' Annual Premium ']");
	private By StatusCol=By.xpath("//th[text()=' Status ']");

	private By policyNumberData=By.xpath("//tr/td[1]");
	private By agentNumber=By.xpath("//tr/td[2]");
	private By agentNameData=By.xpath("//tr/td[3]");
	private By submittedDateData=By.xpath("//tr/td[4]");
	private By issuedDateData=By.xpath("//tr/td[5]");
	private By PTDData=By.xpath("//tr/td[6]");
	private By recurringData=By.xpath("//tr/td[7]");
	private By nxtPaymentData=By.xpath("//tr/td[8]");
	private By rejectedData=By.xpath("//tr/td[9]");
	private By refusedDateData=By.xpath("//tr/td[10]");
	private By refusedAmountData=By.xpath("//tr/td[11]");
	private By attemptData=By.xpath("//tr/td[12]");
	private By annualPremiumData=By.xpath("//tr/td[13]");
	private By statusData=By.xpath("//tr/td[14]");

	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By nextPageIcon=By.xpath("//ion-button[@title='Next Page']");
	private By prevPageIcon=By.xpath("//ion-button[@title='Prev Page']");
	private By firstPagePlayIcon=By.xpath("//ion-button[@title='First Page']");
	private By lastPagePlayIcon=By.xpath("//ion-button[@title='Last Page']");
	private By optionFive=By.xpath("//select/option[@value='5']");
	private By optionTen=By.xpath("//select/option[@value='10']");
	private By optionTwentyFive=By.xpath("//select/option[@value='25']");
	private By optionFifty=By.xpath("//select/option[@value='50']");

	public void refusedReports() throws Exception {
		String id=null ;
		String fullName=null ;
		String[] nameParts=null ;
		String lastName=null ;
		String firstName=null ;
		String fifty="50";
		Pattern pattern;
		Matcher matcher;
		String newTabUrl="chrome://downloads/";
		
		WebUI.sleep(5);
		WebUI.verifyElementVisible(title);
		WebUI.verifyElementVisible(agentFilter);
		WebUI.verifyElementVisible(agencyDropdown);
		WebUI.clickElement(agencyDropdown);
		WebUI.verifyElementVisible(dateFrom);
		WebUI.verifyElementVisible(dateTo);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String currentFormattedDate = currentDate.format(formatter);
		LocalDate lastMonthDate = currentDate.minusMonths(1).plusDays(1);
		String lastMonthFormattedDate = lastMonthDate.format(formatter);
		System.out.println(currentFormattedDate);
		System.out.println(lastMonthFormattedDate);
		WebUI.clickElement(agencyDropdown);
		WebUI.verifyElementVisible(agencyValue);
		WebUI.verifyElementVisible(table);
		WebUI.clickElement(agentCaret_btn);
		WebUI.verifyElementVisible(agentsList);
		WebUI.verifyElementVisible(closeBtn);
		WebUI.verifyElementVisible(searchBar);
		WebUI.verifyElementVisible(agentDetails);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(agentsList);
		WebUI.clickElement(agentCaret_btn);
		WebUI.setText(searchBoxInput, "55555");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "Japfu");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "magpie");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.sleep(0.6);
		WebUI.clickElement(resetBtn);
		WebUI.sleep(1.5);
		List<String> listNames=WebUI.getElementTextsInList(agentsText);
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
		WebUI.clickElement(agentCaret_btn);
		WebUI.sleep(2);
		String Id1=	WebUI.validateElementContainsDataAndExtractID(HighestLevel);
		String Id2=	WebUI.validateElementContainsDataAndExtractID(secondHighestLevel);
		String Id3=	WebUI.validateElementContainsDataAndExtractID(thirdHighestLevel);
		String Id4=	WebUI.validateElementContainsDataAndExtractID(fourthHighestLevel);
		String Id5=	WebUI.validateElementContainsDataAndExtractID(fifthHighestLevel);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(4);
		WebUI.verifyElementVisible(policyCol);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(agentCol);
		WebUI.verifyElementVisible(submittedDateCol);
		WebUI.verifyElementVisible(issueDateCol);
		WebUI.verifyElementVisible(paidToDateCol);
		WebUI.verifyElementVisible(nxtPaymentCol);
		WebUI.verifyElementVisible(recurringCol);
		WebUI.verifyElementVisible(rejectedTypeCol);
		WebUI.verifyElementVisible(refusedDateCol);
		WebUI.verifyElementVisible(refusedAmountCol);
		WebUI.verifyElementVisible(attemptCol);
		WebUI.verifyElementVisible(StatusCol);
		WebUI.verifyElementVisible(annualPremiumCol);
		WebUI.verifyElementVisible(exportBtn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pageDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);

		List<String> Ids=WebUI.getElementTextsInList(agentNumber);
		System.out.println(Ids);
		try{
			WebUI.isElementVisible(agentNumber,2);
			WebUI.verifyContainsIgnore(Ids, Id1);
			WebUI.verifyContainsIgnore(Ids, Id2);
			WebUI.verifyContainsIgnore(Ids, Id3);
			WebUI.verifyContainsIgnore(Ids, Id4);
			WebUI.verifyContainsIgnore(Ids, Id5);
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(agentCaret_btn);
			WebUI.clickElement(secondHighestLevel);
			WebUI.sleep(4);
		}catch (Exception e) {
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(secondHighestLevel);
			WebUI.sleep(4);
		}
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(1);
		System.out.println(WebUI.getTextElement(pagenation));
		try {
			if(WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(thirdHighestLevel);
			}else {
				WebUI.sleep(0.5);
				WebUI.isElementVisible(agentNumber,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumber);
				System.out.println(Ids2);
				WebUI.verifyContainsIgnore(Ids2, Id2);
				WebUI.verifyNotContains(Ids2, Id1);
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(thirdHighestLevel);
				WebUI.sleep(3);
			}
			WebUI.sleep(2);
		}catch (Exception e) {
			WebUI.isElementVisible(agentNumber,2);
			List<String> Ids2=WebUI.getElementTextsInList(agentNumber);
			System.out.println(Ids2);
			WebUI.verifyContains(Ids2, Id2);
			WebUI.verifyNotContains(Ids2, Id1);
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(agentCaret_btn);
			WebUI.clickElement(thirdHighestLevel);
			WebUI.sleep(3);
		}
		try {
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.getTextElement(pagenation);
			System.out.println(WebUI.getTextElement(pagenation));
			if(	WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fourthHighestLevel);
				WebUI.sleep(4);
			}else {
				WebUI.isElementVisible(agentNumber,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumber);
				System.out.println(Ids2);
				WebUI.verifyContainsIgnore(Ids2, Id3);
				WebUI.verifyContainsIgnore(Ids2, Id2);
				WebUI.verifyNotContains(Ids2, Id1);
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fourthHighestLevel);
				WebUI.sleep(4);
			}

		}catch (Exception e) {
			WebUI.isElementVisible(agentNumber,2);
			List<String> Ids3=WebUI.getElementTextsInList(agentNumber);
			System.out.println(Ids3);
			WebUI.verifyContainsIgnore(Ids3, Id3);
			WebUI.verifyNotContains(Ids3, Id1);
			WebUI.verifyNotContains(Ids3, Id2);
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(agentCaret_btn);
			WebUI.clickElement(fourthHighestLevel);
			WebUI.sleep(4);
		}
		try {
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.getTextElement(pagenation);
			System.out.println(WebUI.getTextElement(pagenation));
			if(	WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fifthHighestLevel);
				WebUI.sleep(4);
			}else {
				WebUI.isElementVisible(agentNumber,2);
				List<String> Ids4=WebUI.getElementTextsInList(agentNumber);
				System.out.println(Ids4);
				WebUI.verifyContainsIgnore(Ids4, Id4);
				WebUI.verifyNotContains(Ids4, Id1);
				WebUI.verifyNotContains(Ids4, Id2);
				WebUI.verifyNotContains(Ids4, Id3);
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fifthHighestLevel);
				WebUI.sleep(4);
			}
		}catch (Exception e) {
			WebUI.isElementVisible(agentNumber,2);
			List<String> Ids4=WebUI.getElementTextsInList(agentNumber);
			System.out.println(Ids4);
			WebUI.verifyContains(Ids4, Id4);
			WebUI.verifyNotContains(Ids4, Id1);
			WebUI.verifyNotContains(Ids4, Id2);
			WebUI.verifyNotContains(Ids4, Id3);
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(agentCaret_btn);
			WebUI.clickElement(fifthHighestLevel);
			WebUI.sleep(4);
		}
		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(4);
		WebUI.validateElementContainsData(WebUI.getTextElement(policyNumberData));
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNumber));
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNameData));
		WebUI.validateElementContainsData(WebUI.getTextElement(submittedDateData));
		WebUI.validateElementContainsData(WebUI.getTextElement(issuedDateData));
		WebUI.validateElementContainsData(WebUI.getTextElement(PTDData));
		WebUI.validateElementContainsData(WebUI.getTextElement(recurringData));
		WebUI.validateElementContainsData(WebUI.getTextElement(nxtPaymentData));
		WebUI.validateElementContainsData(WebUI.getTextElement(rejectedData));
		WebUI.validateElementContainsData(WebUI.getTextElement(refusedDateData));
		WebUI.validateElementContainsData(WebUI.getTextElement(refusedAmountData));
		WebUI.validateElementContainsData(WebUI.getTextElement(attemptData));
		WebUI.validateElementContainsData(WebUI.getTextElement(annualPremiumData));
		WebUI.validateElementContainsData(WebUI.getTextElement(statusData));

		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.verifyElementVisible(pagenation);
		WebUI.verifyElementVisible(pagenationDropdown);
		WebUI.verifyElementVisible(firstPagePlayIcon);
		WebUI.verifyElementVisible(nextPageIcon);
		WebUI.verifyElementVisible(prevPageIcon);
		WebUI.verifyElementVisible(lastPagePlayIcon);
		WebUI.clickElement(pagenationDropdown);
		WebUI.verifyElementVisible(optionFive);
		WebUI.verifyElementVisible(optionTen);
		WebUI.verifyElementVisible(optionTwentyFive);
		WebUI.verifyElementVisible(optionFifty);
		WebUI.clickElement(optionFive);
		int fiveRecords=Integer.parseInt(WebUI.getTextElement(optionFive));
		int totalRowsForFive=	WebUI.getWebElements(tableRow).size();
		WebUI.verifyLessThanOrEquals(totalRowsForFive, fiveRecords);
		WebUI.clickElement(pagenationDropdown);
		WebUI.clickElement(optionTen);
		WebUI.scrollToElementAtBottom(pagenation);
		int TenRecords=Integer.parseInt(WebUI.getTextElement(optionTen));
		int totalRowsForTen=	WebUI.getWebElements(tableRow).size();
		WebUI.verifyLessThanOrEquals(totalRowsForTen, TenRecords);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.clickElement(optionTwentyFive);
		WebUI.scrollToElementAtBottom(pagenation);
		int TwentyFiveRecords=Integer.parseInt(WebUI.getTextElement(optionTwentyFive));
		int totalRowsForTwentyfive=	WebUI.getWebElements(tableRow).size();
		WebUI.verifyLessThanOrEquals(totalRowsForTwentyfive, TwentyFiveRecords);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.clickElement(optionFifty);
		WebUI.scrollToElementAtBottom(pagenation);
		int FiftyRecords=Integer.parseInt(WebUI.getTextElement(optionFifty));
		int totalRowsForFifty=	WebUI.getWebElements(tableRow).size();
		WebUI.verifyLessThanOrEquals(totalRowsForFifty, FiftyRecords);

		String pagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(pagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(pagenationText);
		int currentPage=0;
		int totalPages=0;
		if (matcher.find()) {
			currentPage=Integer.parseInt(matcher.group());
			System.out.println(currentPage);
		}
		if (matcher.find()) {
			totalPages=Integer.parseInt(matcher.group());
			System.out.println(totalPages);
		}

		WebUI.clickElement(nextPageIcon);
		String NxtPagePagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(NxtPagePagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(NxtPagePagenationText);
		int	nxtBtnCurrentPage=0;
		if (matcher.find()) {
			nxtBtnCurrentPage=Integer.parseInt(matcher.group());
			System.out.println(nxtBtnCurrentPage);

		}
		WebUI.verifyLessThanOrEquals(nxtBtnCurrentPage, currentPage+1);
		WebUI.clickElement(prevPageIcon);
		String prevPagePagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(prevPagePagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(prevPagePagenationText);
		int	prevBtnCurrentPage=0;
		if (matcher.find()) {
			prevBtnCurrentPage=Integer.parseInt(matcher.group());
			System.out.println(prevBtnCurrentPage);
		}
		if (matcher.find()) {
			nxtBtnCurrentPage=Integer.parseInt(matcher.group());
			System.out.println(nxtBtnCurrentPage);
		}
		WebUI.verifyGreaterThanOrEquals(prevBtnCurrentPage, nxtBtnCurrentPage-1);
		WebUI.clickElement(lastPagePlayIcon);
		String lastPagePagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(lastPagePagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(lastPagePagenationText);
		int	lastBtnCurrentPage=0;
		if (matcher.find()) {
			lastBtnCurrentPage=Integer.parseInt(matcher.group());
			System.out.println(lastBtnCurrentPage);
		}
		WebUI.verifyEquals(lastBtnCurrentPage, totalPages);
		WebUI.clickElement(firstPagePlayIcon);
		String firstPagePagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(firstPagePagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(firstPagePagenationText);
		int	firstBtnCurrentPage=0;
		if (matcher.find()) {
			firstBtnCurrentPage=Integer.parseInt(matcher.group());
			System.out.println(firstBtnCurrentPage);
		}
		WebUI.verifyEquals(firstBtnCurrentPage, 1);
		
		WebUI.clickElement(exportBtn);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(1);
		WebUI.switchToMainWindow();



	}
}
