package com.codetru.project.cica.pages.reportsModule;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;


public class RenewalPremiumReports extends CommonPageCICA {

	private By title=By.xpath("//ion-title[text()='Renewal Premium Report ']");
	private By agentFilter=By.xpath("//ion-icon[@id='LoadingAgents']/ancestor::agent-filter");
	private By pastDue=By.xpath("//ion-button[text()=' Past Due ']");
	private By oneMnthArrears=By.xpath("//ion-button[text()=' 1 Month Arrears ']");
	private By dueSoon=By.xpath("//ion-button[text()=' Due Soon ']");
	private By twoMnthArrears=By.xpath("//ion-button[text()=' 2 Month Arrears ']");
	private By allBtn=By.xpath("//ion-button[text()='All ']");
	private By potentialLapse=By.xpath("//ion-button[text()=' Potential Lapse ']");
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

	private By agentNumber=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[1]");
	private By agentNameData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[2]");
	private By policyNumberData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[3]");
	private By ownerNameData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[4]");
	private By paidToDateData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[5]");
	private By policyStatusData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[6]");
	private By paymentMethodData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[7]");
	private By recurringData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[8]");
	private By nxtPaymentDateData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[9]");
	private By modeData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[10]");
	private By modePremiumData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[11]");
	private By issuedDateData=By.xpath("//th[text()=' Agent # ']/ancestor::table/tbody/tr/td[12]");

	private By agentCol=By.xpath("//th[text()=' Agent # ']");
	private By agentNameCol=By.xpath("//th[text()=' Agent Name ']");
	private By policyCol=By.xpath("//th[text()=' Policy # ']");
	private By ownerCol=By.xpath("//th[text()=' Owner ']");
	private By ptdCol=By.xpath("//th[text()=' PTD ']");
	private By policyStatusCol=By.xpath("//th[text()=' Policy Status ']");
	private By paymentMethodCol=By.xpath("//th[text()=' Payment Method ']");
	private By recurringCol=By.xpath("//th[text()=' Recurring ']");
	private By nxtPaymentDateCol=By.xpath("//th[text()=' Next Payment Date ']");
	private By modeCol=By.xpath("//th[text()=' Mode ']");
	private By modePremiumCol=By.xpath("//th[text()=' Mode Premium ']");
	private By issuedDateCol=By.xpath("//th[text()=' Issue Date ']");
	private By exportBtn=By.xpath("//ion-button[.=' Export ']");
	private By policyHistory=By.xpath("//ion-title[contains(text(), 'Policy Payment History')]");
	private By transactionDateCol=By.xpath("//th[text()=' Transaction Date ']");
	private By paymentAmountCol=By.xpath("//th[text()=' Payment Amount ']");
	private By paymentMethod=By.xpath("//th[text()=' Payment Method ']");
	private By paymentStatusCol=By.xpath("//th[text()=' Payment Status ']");
	private By dueDatecol=By.xpath("//th[text()=' Due Date ']");
	private By lastFourDigitsCol=By.xpath("//th[text()=' Card Last Four Digits ']");
	private By policyHistorycloseBtn=By.xpath("//ion-button[text()=' Close ']");

	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By nextPageIcon=By.xpath("//ion-button[@title='Next Page']");
	private By prevPageIcon=By.xpath("//ion-button[@title='Prev Page']");
	private By lastPagePlayIcon=By.xpath("//ion-button[@title='Last Page']");
	private By firstPageplayIcon=By.xpath("//ion-button[@title='First Page']");
	private By policyNumbers = By.xpath("//td/a");

	public void renewalReports() throws Exception {
		String id=null ;
		String fullName=null ;
		String[] nameParts=null ;
		String lastName=null ;
		String firstName=null ;
		String five="5";
		String ten="10";
		String twentyfive="25";
		String fifty="50";
		String policystatusText="Premium Paying";
		String newTabUrl="chrome://downloads/";
		Pattern pattern;
		Matcher matcher;

		WebUI.sleep(5);
		WebUI.verifyElementVisible(title);
		WebUI.verifyElementVisible(agentFilter);
		WebUI.verifyElementVisible(pastDue);
		WebUI.verifyElementVisible(oneMnthArrears);
		WebUI.verifyElementVisible(twoMnthArrears);
		WebUI.verifyElementVisible(dueSoon);
		WebUI.verifyElementVisible(potentialLapse);
		WebUI.verifyElementVisible(allBtn);
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
		WebUI.sleep(1);
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
			WebUI.sleep(0.5);
			count++;
			System.out.println(count);
		}
		WebUI.clickElement(resetBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(closeBtn);

		WebUI.clickElement(agentCaret_btn);
		WebUI.sleep(2);
		String Id1=	WebUI.validateElementContainsDataAndExtractID(HighestLevel);
		String Id2=	WebUI.validateElementContainsDataAndExtractID(secondHighestLevel);
		String Id3=	WebUI.validateElementContainsDataAndExtractID(thirdHighestLevel);
		String Id4=	WebUI.validateElementContainsDataAndExtractID(fourthHighestLevel);
		String Id5=	WebUI.validateElementContainsDataAndExtractID(fifthHighestLevel);
		System.out.println(Id3);
		WebUI.sleep(2);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(3);
		WebUI.verifyElementVisible(agentCol);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(policyCol);
		WebUI.verifyElementVisible(ownerCol);
		WebUI.verifyElementVisible(ptdCol);
		WebUI.verifyElementVisible(policyStatusCol);
		WebUI.verifyElementVisible(paymentMethodCol);
		WebUI.verifyElementVisible(recurringCol);
		WebUI.verifyElementVisible(nxtPaymentDateCol);
		WebUI.verifyElementVisible(modeCol);
		WebUI.verifyElementVisible(modePremiumCol);
		WebUI.verifyElementVisible(issuedDateCol);
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
		}catch (Exception e) {
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(secondHighestLevel);
			WebUI.clickElement(secondHighestLevel);
		}
		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(secondHighestLevel);
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(pagenation);

		try {
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.getTextElement(pagenation);
			if(WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(thirdHighestLevel);
			}else {
				WebUI.isElementVisible(agentNumber,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumber);
				System.out.println(Ids2);
				WebUI.verifyContains(Ids2, Id2);
				WebUI.verifyNotContains(Ids2, Id1);
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(thirdHighestLevel);
				WebUI.sleep(2);
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
			WebUI.sleep(2);
		}
		try {
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.getTextElement(pagenation);
			System.out.println(WebUI.getTextElement(pagenation));
			if(	WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(thirdHighestLevel);
			}else {
				WebUI.isElementVisible(agentNumber,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumber);
				System.out.println(Ids2);
				WebUI.verifyContains(Ids2, Id3);
				WebUI.verifyNotContains(Ids2, Id2);
				WebUI.verifyNotContains(Ids2, Id1);
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fourthHighestLevel);
				WebUI.sleep(2);
			}
			WebUI.sleep(2);
		}catch (Exception e) {
			WebUI.isElementVisible(agentNumber,2);
			List<String> Ids3=WebUI.getElementTextsInList(agentNumber);
			System.out.println(Ids3);
			WebUI.verifyContains(Ids3, Id3);
			WebUI.verifyNotContains(Ids3, Id1);
			WebUI.verifyNotContains(Ids3, Id2);
			WebUI.scrollToElementAtTop(agentCaret_btn);
			WebUI.clickElement(agentCaret_btn);
			WebUI.clickElement(fourthHighestLevel);
		}
		try {
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.getTextElement(pagenation);
			System.out.println(WebUI.getTextElement(pagenation));
			if(	WebUI.verifyContainsIgnore(WebUI.getTextElement(pagenation), "0")) {
				WebUI.scrollToElementAtTop(agentCaret_btn);
				WebUI.clickElement(agentCaret_btn);
				WebUI.clickElement(fifthHighestLevel);
			}else {
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
			}
			WebUI.sleep(2);
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
		}

		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.clickElement(agentCaret_btn);
		WebUI.setText(searchBoxInput, Id3);
		WebUI.sleep(2);
		WebUI.clickElement(HighestLevel);
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNumber));
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNameData));
		WebUI.verifyContains(WebUI.validateElementContainsData(WebUI.getTextElement(agentNameData)), ",");
		WebUI.validateElementContainsData(WebUI.getTextElement(policyNumberData));
		WebUI.validateElementContainsData(WebUI.getTextElement(ownerNameData));
		WebUI.validateElementContainsData(WebUI.getTextElement(paidToDateData));
		WebUI.isValidDateFormat(WebUI.getTextElement(paidToDateData));
		WebUI.validateElementContainsData(WebUI.getTextElement(policyStatusData));
		WebUI.validateElementContainsData(WebUI.getTextElement(paymentMethodData));
		WebUI.sleep(1);
		WebUI.clickElement(recurringCol);
		WebUI.sleep(1);
		WebUI.validateElementContainsData(WebUI.getTextElement(recurringData));
		WebUI.validateElementContainsData(WebUI.getTextElement(nxtPaymentDateData));
		WebUI.isValidDateFormat(WebUI.getTextElement(nxtPaymentDateData));
		WebUI.validateElementContainsData(WebUI.getTextElement(modeData));
		WebUI.validateElementContainsData(WebUI.getTextElement(modePremiumData));
		WebUI.validateElementContainsData(WebUI.getTextElement(issuedDateData));
		WebUI.isValidDateFormat(WebUI.getTextElement(issuedDateData));
		WebUI.sleep(2);
		WebUI.clickElement(policyNumberData);
		WebUI.sleep(2);
		WebUI.verifyElementVisible(policyHistory);
		WebUI.verifyElementVisible(transactionDateCol);
		WebUI.verifyElementVisible(paymentAmountCol);
		WebUI.verifyElementVisible(paymentMethod);
		WebUI.verifyElementVisible(paymentStatusCol);
		WebUI.verifyElementVisible(issuedDateCol);
		WebUI.verifyElementVisible(dueDatecol);
		WebUI.verifyElementVisible(lastFourDigitsCol);
		WebUI.verifyElementVisible(policyHistorycloseBtn);
		WebUI.clickElement(policyHistorycloseBtn);
		WebUI.sleep(2);
		WebUI.verifyElementNotVisible(policyHistory);
		WebUI.scrollToElementAtTop(policyStatusCol);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pageDropdown, "10");
		List<String> status=WebUI.getListElementsText(policyStatusData);
		System.out.println(status);
		for (String text : status) {
			WebUI.verifyContains(text, policystatusText);
		}
		WebUI.scrollToElementAtBottom(pagenation);
		List<String> paymentMethod=WebUI.getListElementsText(paymentMethodData);
		for (String text : paymentMethod) {
			if(text.equals("ACH")) {
				System.out.println("This is a "+text+" payment");
			}else if (text.equals("Credit Card")) {
				System.out.println("This is a "+text+" payment");
			}else {
				text.equals("Direct");
				System.out.println("This is a "+text+" payment");
			}
		}
		List<String> reccuringTypes=WebUI.getElementTextsInList(recurringData);
		for (String string : reccuringTypes) {
			if(	string.equals("Yes")) {
				System.out.println("This is a "+string+" payment");
			}else if (string.equals("Off-Failed")) {
				System.out.println("This is a "+string+" payment");
			}else {
				if(!string.equals("Yes") && !string.equals("Off-Failed")) {
					System.out.println("This is a "+string+" payment");
				}
			}
		}
		WebUI.clickElement(exportBtn);
		WebUI.sleep(0.5);
		WebUI.openNewTabWindow(newTabUrl);
		//		WebUI.sleep(3);
		//		WebUI.clickWebElementwithJs(jspath);
		WebUI.sleep(3);
		WebUI.switchToMainWindow();
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(2);
		WebUI.clickElement(agentCol);
		WebUI.sleep(1);
		WebUI.clickElement(agentCol);
		WebUI.sleep(0.5);

		WebUI.clickElement(agentNameCol);
		WebUI.sleep(1);
		WebUI.clickElement(policyCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(policyCol);
		WebUI.sleep(1);
		WebUI.clickElement(ownerCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(ownerCol);
		WebUI.sleep(1);
		WebUI.clickElement(policyStatusCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(policyStatusCol);
		WebUI.sleep(1);
		WebUI.clickElement(recurringCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(recurringCol);
		WebUI.sleep(1);
		WebUI.clickElement(ptdCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(ptdCol);
		WebUI.sleep(1);
		WebUI.clickElement(nxtPaymentDateCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(nxtPaymentDateCol);
		WebUI.sleep(1);
		WebUI.clickElement(modeCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(modeCol);
		WebUI.sleep(1);
		WebUI.clickElement(modePremiumCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(modePremiumCol);
		WebUI.sleep(1);
		WebUI.clickElement(issuedDateCol);
		WebUI.sleep(0.5);
		WebUI.clickElement(issuedDateCol);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(4);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, ten);
		WebUI.sleep(4);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, twentyfive);
		WebUI.scrollToElementAtTop(exportBtn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(4);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(4);
		WebUI.scrollToElementAtTop(exportBtn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(4);
		WebUI.clickElement(nextPageIcon);
		WebUI.sleep(2);
		WebUI.clickElement(prevPageIcon);
		WebUI.sleep(2);
		WebUI.clickElement(lastPagePlayIcon);
		String pagenationText=	WebUI.getTextElement(pagenation);
		System.out.println(pagenationText);
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(pagenationText);
		int currentPage=0;
		int totalPages=0;

		if (matcher.find()) {
			totalPages=Integer.parseInt(matcher.group());
			System.out.println(totalPages);
		}
		if (matcher.find()) {
			currentPage=Integer.parseInt(matcher.group());
			System.out.println(currentPage);
		}
		WebUI.verifyEquals(currentPage, totalPages);
		WebUI.sleep(2);
		WebUI.clickElement(firstPageplayIcon);
		String pagenationText1=	WebUI.getTextElement(pagenation);
		System.out.println(pagenationText1);

		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(pagenationText1);
		int viewpage=0;
		if (matcher.find()) {
			viewpage=Integer.parseInt(matcher.group());
			System.out.println(viewpage);
		}
		WebUI.verifyEquals(viewpage, 1);
		WebUI.sleep(2);
		WebUI.scrollToElementAtTop(pastDue);
		WebUI.clickElement(allBtn);
		WebUI.sleep(5);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, fifty);

		String pagenationTextAll=	WebUI.getTextElement(pagenation);
		String totalPagesAll = pagenationTextAll.split("of")[1].trim();
		System.out.println(totalPagesAll);
		JavascriptExecutor js= (JavascriptExecutor)DriverManager.getDriver();
		List<String> allRowsDataInAll = new ArrayList<>();
		int totalPagesInAllBtn=Integer.parseInt(totalPagesAll);
		for (int page = 1; page <= totalPagesInAllBtn; page++) {
			List<WebElement> elements = WebUI.getWebElements(policyNumbers);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			//	elmentTexts.forEach(System.out::println);
			allRowsDataInAll.addAll(elementTexts);
			if (page < totalPagesInAllBtn) {
				WebUI.scrollToElementAtBottom(pagenation);
				WebUI.clickElement(nextPageIcon);;
				Thread.sleep(2000);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		WebUI.scrollToElementAtTop(pastDue);
		WebUI.clickElement(pastDue);
		WebUI.sleep(5);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);
		String pagenationTextPastDue=	WebUI.getTextElement(pagenation);
		String totalPagesPastDue = pagenationTextPastDue.split("of")[1].trim();
		System.out.println(totalPagesPastDue);
		Thread.sleep(2000);
		int totalPastDue=Integer.parseInt(totalPagesPastDue);
		List<String> allRowsDataPastDue = new ArrayList<>();
		for (int page = 1; page <= totalPastDue; page++) {
			List<WebElement> elements = WebUI.getWebElements(policyNumbers);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			//	elmentTexts.forEach(System.out::println);
			allRowsDataPastDue.addAll(elementTexts);
			if (page < totalPastDue) {
				WebUI.scrollToElementAtBottom(pagenation);
				WebUI.clickElement(nextPageIcon);;
				Thread.sleep(2000);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Past Due Policies"+allRowsDataPastDue);

		for (String policyNumber : allRowsDataPastDue) {
			WebUI.verifyContains(allRowsDataInAll, policyNumber);
			continue;

		}

		WebUI.scrollToElementAtTop(pastDue);
		WebUI.clickElement(oneMnthArrears);
		WebUI.sleep(5);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);
		String pagenationTextOneMonthArrears=	WebUI.getTextElement(pagenation);
		String totalPagesInOneMonthArrears = pagenationTextOneMonthArrears.split("of")[1].trim();
		System.out.println(totalPages);
		List<String> allRowsDataOneMonthArrears = new ArrayList<>();
		int totalOneMonthArrears=Integer.parseInt(totalPagesInOneMonthArrears);
		for (int page = 1; page <= totalOneMonthArrears; page++) {
			List<WebElement> elements = WebUI.getWebElements(policyNumbers);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			//	elmentTexts.forEach(System.out::println);
			allRowsDataOneMonthArrears.addAll(elementTexts);
			if (page < totalOneMonthArrears) {
				WebUI.scrollToElementAtBottom(pagenation);
				WebUI.clickElement(nextPageIcon);;
				Thread.sleep(2000);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("One Month arrear Policies"+allRowsDataOneMonthArrears);
		for (String policyNumber : allRowsDataOneMonthArrears) {
			WebUI.verifyContains(allRowsDataInAll, policyNumber);
			WebUI.verifyContains(allRowsDataPastDue, policyNumber);

			continue;

		}
		WebUI.scrollToElementAtTop(pastDue);
		WebUI.clickElement(twoMnthArrears);
		WebUI.sleep(4);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);
		String pagenationTextTwoMonthArrears=	WebUI.getTextElement(pagenation);
		String totalPagesInTwoMonthArrears = pagenationTextTwoMonthArrears.split("of")[1].trim();
		System.out.println(totalPages);
		List<String> allRowsDataTwoMonthArrears = new ArrayList<>();
		int totalTwoMonthArrears=Integer.parseInt(totalPagesInTwoMonthArrears);
		for (int page = 1; page <= totalTwoMonthArrears; page++) {
			List<WebElement> elements = WebUI.getWebElements(policyNumbers);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			//	elmentTexts.forEach(System.out::println);
			allRowsDataTwoMonthArrears.addAll(elementTexts);
			if (page < totalTwoMonthArrears) {
				WebUI.scrollToElementAtBottom(pagenation);
				WebUI.clickElement(nextPageIcon);;
				Thread.sleep(2000);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Two Month arrear Policies"+allRowsDataTwoMonthArrears);
		for (String policyNumber : allRowsDataTwoMonthArrears) {
			WebUI.verifyContains(allRowsDataInAll, policyNumber);
			WebUI.verifyContains(allRowsDataPastDue, policyNumber);
			WebUI.verifyNotContains(allRowsDataOneMonthArrears, policyNumber);
			continue;
		}
		WebUI.scrollToElementAtTop(pastDue);
		WebUI.clickElement(potentialLapse);
		WebUI.sleep(4);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);
		String pagenationTextPotentialLapse=	WebUI.getTextElement(pagenation);
		String totalPagesInPotentialLapse = pagenationTextPotentialLapse.split("of")[1].trim();
		System.out.println(totalPages);
		List<String> allRowsDataPotentialLapse = new ArrayList<>();
		int totalPotentialLapse=Integer.parseInt(totalPagesInPotentialLapse);
		for (int page = 1; page <= totalPotentialLapse; page++) {
			List<WebElement> elements = WebUI.getWebElements(policyNumbers);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			//	elmentTexts.forEach(System.out::println);
			allRowsDataPotentialLapse.addAll(elementTexts);
			if (page < totalPotentialLapse) {
				WebUI.scrollToElementAtBottom(pagenation);
				WebUI.clickElement(nextPageIcon);;
				Thread.sleep(2000);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("potential Lapse Policies" +allRowsDataPotentialLapse);
		for (String policyNumber :allRowsDataPotentialLapse ) {
			WebUI.verifyContains(allRowsDataInAll, policyNumber);
			WebUI.verifyContains(allRowsDataPastDue, policyNumber);
			WebUI.verifyNotContains(allRowsDataTwoMonthArrears, policyNumber);
			WebUI.verifyNotContains(allRowsDataOneMonthArrears, policyNumber);
			continue;

		}

	}
}
