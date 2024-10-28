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

public class ApplicationPaymentStatusReport extends CommonPageCICA {

	private By title=By.xpath("//ion-title[text()='Application Status and Payments ']");
	private By agentFilter=By.xpath("//ion-icon[@id='LoadingAgents']/ancestor::agent-filter");
	private By salesSummary=By.xpath("//span[.=' Agency Sales Summary ']");
	private By issuedOrPendingApplication=By.xpath("//ion-col[text()=' Total Pending/Issued Application Count ']");
	private By issuedOrPendingApplicationCount=By.xpath("//ion-col[text()=' Total Pending/Issued Application Count ']/following-sibling::ion-col");
	private By totalAnnualPremium=By.xpath("//ion-col[text()=' Total Annual Premium ']");
	private By totalAmountAnnualPremium=By.xpath("//ion-col[text()=' Total Annual Premium ']/following-sibling::ion-col");

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

	private By agentNumberData=By.xpath("(//tr/td[1])[1]");
	private By agentNameData=By.xpath("(//tr/td[2])[1]");
	private By applNumberData=By.xpath("(//tr/td[3])[1]");
	private By ownerNameData=By.xpath("(//tr/td[4])[1]");
	private By applStatusData=By.xpath("(//tr/td[5])");
	private By paymentMethodData=By.xpath("//tr/td[6]");
	private By recurringData=By.xpath("//tr/td[7]");
	private By modePremiumData=By.xpath("(//tr/td[8])[1]");
	private By annualPremiumData=By.xpath("//tr/td[10]");
	private By dateSubmittedData=By.xpath("(//tr/td[11])[1]");
	private By applTypeData=By.xpath("(//tr/td[12])[1]");
	private By minusAmount=By.xpath("(//td[starts-with(text(), 'Pending')] | //td[starts-with(text(), 'Denied')]| //td[starts-with(text(), 'Withdrawn')])/following-sibling::td[5]");
	private By issuedAppl=By.xpath("(//td[starts-with(text(), 'Sub')] | //td[starts-with(text(), 'Hold')]| //td[starts-with(text(), 'Issu')]|//td[starts-with(text(), 'In')])");

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
	private By exportBtn=By.xpath("//ion-button[.=' Export ']");

	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By nextPageIcon=By.xpath("//ion-button[@title='Next Page']");
	private By firstPageplayIcon=By.xpath("//ion-button[@title='First Page']");

	public void applicationPaymentStatusReports() throws Exception {
		String id=null ;
		double deniedAmount=0;
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
		int applCount = 0;

		WebUI.sleep(5);									////////// 10 to 5 sec
		WebUI.verifyElementVisible(title);
		WebUI.verifyElementVisible(agentFilter);
		WebUI.verifyElementVisible(salesSummary);
		WebUI.verifyElementVisible(issuedOrPendingApplication);
		int issuedApplCount=Integer.parseInt(WebUI.getTextElement(issuedOrPendingApplicationCount));
		System.out.println(issuedApplCount);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		String pagenationText=	WebUI.getTextElement(pagenation);
		String totalPagesMain = pagenationText.split("of")[1].trim();
		System.out.println(totalPagesMain);
		int pagesCount=Integer.parseInt(totalPagesMain);
		for (int page = 1; page <= pagesCount; page++) {
			List<WebElement> validAppl=WebUI.getWebElements(issuedAppl);
			applCount=applCount+validAppl.size();      
			if (page < pagesCount) {
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
		WebUI.verifyEquals(applCount, issuedApplCount);
		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.verifyElementVisible(totalAnnualPremium);
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
		WebUI.sleep(1);
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
		System.out.println(Id3);
		WebUI.sleep(1);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(3);
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
		WebUI.verifyElementVisible(exportBtn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pageDropdown, fifty);
		WebUI.scrollToElementAtBottom(pagenation);
		List<String> Ids=WebUI.getElementTextsInList(agentNumberData);
		System.out.println(Ids);
		try{
			WebUI.isElementVisible(agentNumberData,2);
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
				WebUI.isElementVisible(agentNumberData,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumberData);
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
			WebUI.isElementVisible(agentNumberData,2);
			List<String> Ids2=WebUI.getElementTextsInList(agentNumberData);
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
				WebUI.isElementVisible(agentNumberData,2);
				List<String> Ids2=WebUI.getElementTextsInList(agentNumberData);
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
			WebUI.isElementVisible(agentNumberData,2);
			List<String> Ids3=WebUI.getElementTextsInList(agentNumberData);
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
				WebUI.isElementVisible(agentNumberData,2);
				List<String> Ids4=WebUI.getElementTextsInList(agentNumberData);
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
			WebUI.isElementVisible(agentNumberData,2);
			List<String> Ids4=WebUI.getElementTextsInList(agentNumberData);
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
		WebUI.sleep(2);
		WebUI.clickElement(HighestLevel);
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNumberData));
		WebUI.validateElementContainsData(WebUI.getTextElement(agentNameData));
		WebUI.verifyContains(WebUI.validateElementContainsData(WebUI.getTextElement(agentNameData)), ",");
		WebUI.validateElementContainsData(WebUI.getTextElement(applNumberData));
		WebUI.validateElementContainsData(WebUI.getTextElement(ownerNameData));
		WebUI.validateElementContainsData(WebUI.getTextElement(applStatusData));
		WebUI.validateElementContainsData(WebUI.getTextElement(paymentMethodData));
		WebUI.validateElementContainsData(WebUI.getTextElement(recurringData));
		WebUI.validateElementContainsData(WebUI.getTextElement(modePremiumData));
		WebUI.validateElementContainsData(WebUI.getTextElement(annualPremiumData));
		WebUI.validateElementContainsData(WebUI.getTextElement(dateSubmittedData));
		WebUI.isValidDateFormat(WebUI.getTextElement(dateSubmittedData));
		WebUI.validateElementContainsData(WebUI.getTextElement(applTypeData));
		WebUI.sleep(2);
		WebUI.scrollToElementAtTop(agentCaret_btn);
		WebUI.clickElement(agentCaret_btn);
		WebUI.sleep(2);
		WebUI.clickElement(HighestLevel);
		WebUI.sleep(2);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(0.5);
		//	String pagenationText=	WebUI.getTextElement(pagenation);
		String totalPages = pagenationText.split("of")[1].trim();
		System.out.println(totalPages);
		JavascriptExecutor js= (JavascriptExecutor)DriverManager.getDriver();
		List<String> allRowsData = new ArrayList<>();
		int totalPagesCount=Integer.parseInt(totalPages);
		double totalAmount = 0;
		for (int page = 1; page <= totalPagesCount; page++) {
			List<WebElement> elements = WebUI.getWebElements(annualPremiumData);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			elementTexts.forEach(System.out::println);
			allRowsData.addAll(elementTexts);
			if (page < totalPagesCount) {
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
		System.out.println(allRowsData);
		for (String amount : allRowsData) {
			totalAmount=totalAmount+WebUI.roundOf(amount);
		}
		System.out.println("Total Amount" +totalAmount);
		WebUI.clickElement(firstPageplayIcon);
		WebUI.sleep(1);
		List<String> removedAmount = new ArrayList<>();
		for (int page = 1; page <= totalPagesCount; page++) {
			List<WebElement> elements = WebUI.getWebElements(minusAmount);
			List<String> elementTexts = elements.stream()
					.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
					.filter(text -> text != null && !text.trim().isEmpty())
					.map(String::trim)
					.collect(Collectors.toList());
			elementTexts.forEach(System.out::println);
			removedAmount.addAll(elementTexts);
			if (page < totalPagesCount) {
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
		System.out.println("Denied Rows Mode premium Value "+removedAmount);

		for (String amount : removedAmount) {
			deniedAmount=deniedAmount+WebUI.roundOf(amount);
		}
		double actualTotal =WebUI.roundOfDouble(totalAmount-deniedAmount);
		System.out.println("Denied Amount " +deniedAmount);
		System.out.println("Total Amount "+ totalAmount);
		System.out.println("actual Amount "+ actualTotal);
		WebUI.verifyEquals(actualTotal, WebUI.roundOf(WebUI.getTextElement(totalAmountAnnualPremium)));

		List<String> statusOfApplication = new ArrayList<>();
		List<WebElement> element = WebUI.getWebElements(applStatusData);
		List<String> elementText= element.stream()
				.map(element1 -> (String) js.executeScript("return arguments[0].textContent;", element1))
				.filter(text -> text != null && !text.trim().isEmpty())
				.map(String::trim)
				.collect(Collectors.toList());
		elementText.forEach(System.out::println);
		statusOfApplication.addAll(elementText);
		System.out.println("Application Status "+statusOfApplication);
		WebUI.verifyContainsIgnore(elementText, "Issued");
		WebUI.verifyContainsIgnore(elementText, "Hold Application");
		WebUI.verifyContainsIgnore(elementText, "Denied, Rejected Payment");

		List<String> paymentMethod = new ArrayList<>();
		List<WebElement> paymentElements = WebUI.getWebElements(paymentMethodData);
		List<String> paymentElementsText= paymentElements.stream()
				.map(element1 -> (String) js.executeScript("return arguments[0].textContent;", element1))
				.filter(text -> text != null && !text.trim().isEmpty())
				.map(String::trim)
				.collect(Collectors.toList());
		paymentElementsText.forEach(System.out::println);
		paymentMethod.addAll(paymentElementsText);
		System.out.println("Method of payment "+paymentMethod);
		WebUI.verifyContainsIgnore(paymentElementsText, "ACH");
		WebUI.verifyContainsIgnore(paymentElementsText, "Direct");
		WebUI.verifyContainsIgnore(paymentElementsText, "Credit Card");

		List<String> recurring = new ArrayList<>();
		List<WebElement> recurringElements = WebUI.getWebElements(paymentMethodData);
		List<String> recurringElementTexts= recurringElements.stream()
				.map(element1 -> (String) js.executeScript("return arguments[0].textContent;", element1))
				.filter(text -> text != null && !text.trim().isEmpty())
				.map(String::trim)
				.collect(Collectors.toList());
		recurringElementTexts.forEach(System.out::println);
		recurringElementTexts.addAll(recurring);
		System.out.println("Method of payment "+paymentMethod);
		WebUI.verifyContainsIgnore(recurringElementTexts, "Yes");
		WebUI.verifyContainsIgnore(recurringElementTexts, "No");
		WebUI.scrollToElementAtTop(exportBtn);
		WebUI.sleep(0.5);
		WebUI.clickElement(exportBtn);
		WebUI.sleep(0.5);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(1);
		WebUI.switchToMainWindow();
	


	}

}
