package com.codetru.project.cica.pages.reportsModule;

import static com.codetru.keywords.WebUI.clearText;
import static com.codetru.keywords.WebUI.getTextElement;
import static com.codetru.keywords.WebUI.setText;
import static com.codetru.keywords.WebUI.sleep;
import static com.codetru.keywords.WebUI.verifyContains;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class AccountBalanceHistory extends CommonPageCICA {

	private By title=By.xpath("//ion-title[starts-with(text(), 'Account Balance - Pre')]");
	private By agentDetails=By.xpath("//ion-list-header");
	private By agentCaret_btn=By.xpath("//ion-icon[@name='caret-down']");
//	private By agentsList=By.xpath("//ion-list[@role='list']/parent::ion-list");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn=By.xpath("//ion-button[text()='Close']");
	private By searchBar=By.xpath("//ion-searchbar[@type='text']");
	private By agentsText=By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput=By.xpath("//input[@aria-label='search text']");
	private By resetBtn=By.xpath("//button[@aria-label='reset']");
	private By dateFilter=By.xpath("//select[@formcontrolname='dateFilter']");
	private By selectMnth=By.xpath("//select[@formcontrolname='dateFilter']/option[3]");
	private By checkDate=By.xpath("//h2[.='Balance Statement ']/following-sibling::tbody/tr[3]/td");
	private By HighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By secondHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[2]");
	private By thirdHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[3]");
	private By fourthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[4]");
	private By fifthHighestLevel=By.xpath("(//ion-list-header[contains(text(), ',')])[5]");
	private By postedDateCol=By.xpath("//h2[.='Balance Statement ']/following-sibling::thead/tr/th[.='Posted Date']"); 
	private By descriptionCol=By.xpath("//h2[.='Balance Statement ']/following-sibling::thead/tr/th[.='Description']"); 
	private By amountCol=By.xpath("//h2[.='Balance Statement ']/following-sibling::thead/tr/th[.='Amount']");
	private By agentNameCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Agent Name']");
	private By agentCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Agent #']");
	private By LevelCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Level']");
	private By PolicyCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Policy #']");
	private By insuredNameCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Insured Name']");
	private By processDateCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Process Date']");
	private By checkCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Check #']");
	private By CommissionDescriptionCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Description']");
	private By debitCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Debit']");
	private By monthlyCommissionCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Monthly Commission Credit']");
	private By runningBalanceCol=By.xpath("//span[.=' Commission Statement Detail ']/parent::h3/following-sibling::div/descendant::th[.='Running Balance']");

	private By exportDownloadBtn=By.xpath("//ion-button[.=' Export for Full Details ']");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");

	public void accountBalance() throws Exception {

		String id=null ;
		String fullName=null ;
		String[] nameParts=null ;
		String lastName=null ;
		String five="5" ;
		String firstName=null ;
		String newTabUrl="chrome://downloads/";

		String jspath="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\")";


		WebUI.sleep(3);
		WebUI.verifyElementVisible(title);
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
		String Id1=	WebUI.validateElementContainsDataAndExtractID(HighestLevel);
		String Id2=	WebUI.validateElementContainsDataAndExtractID(secondHighestLevel);
		String Id3=	WebUI.validateElementContainsDataAndExtractID(thirdHighestLevel);
		String Id4=	WebUI.validateElementContainsDataAndExtractID(fourthHighestLevel);
		String Id5=	WebUI.validateElementContainsDataAndExtractID(fifthHighestLevel);
		System.out.println(Id3);
		WebUI.sleep(2);

		List<String> listNames=WebUI.getElementTextsInList(agentsText);
		int count = 0;
		for (String name : listNames) {
			if (count >= 3) {
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
		WebUI.clickElement(resetBtn);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(HighestLevel);
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(HighestLevel);
		WebUI.clickElement(dateFilter);
		String selectedMonth=	WebUI.getTextElement(dateFilter);
		WebUI.sleep(5);
		WebUI.scrollToElementAtBottom(checkDate);
		WebUI.sleep(0.5);
		String[] dateParts = WebUI.getTextElement(checkDate).split("/");
		String month = dateParts[0];
		String year = dateParts[2];
		String formattedDate = month + "/" + year;
		WebUI.verifyContains(selectedMonth, formattedDate);
		WebUI.verifyElementVisible(postedDateCol);
		WebUI.verifyElementVisible(descriptionCol);
		WebUI.verifyElementVisible(amountCol);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(agentNameCol);
		WebUI.verifyElementVisible(agentCol);
		WebUI.verifyElementVisible(LevelCol);
		WebUI.verifyElementVisible(PolicyCol);
		WebUI.verifyElementVisible(insuredNameCol);
		WebUI.verifyElementVisible(processDateCol);
		WebUI.verifyElementVisible(checkCol);
		WebUI.verifyElementVisible(CommissionDescriptionCol);
		WebUI.verifyElementVisible(debitCol);
		WebUI.verifyElementVisible(monthlyCommissionCol);
		WebUI.verifyElementVisible(runningBalanceCol);
		WebUI.verifyElementVisible(exportDownloadBtn);
		WebUI.clickElement(exportDownloadBtn);
		WebUI.sleep(2);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(2);
		//		WebUI.clickWebElementwithJs(jspath);
		WebUI.switchToMainWindow();


	}
}