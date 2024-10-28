package com.codetru.project.cica.pages.reportsModule;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class CheckReport extends CommonPageCICA {

	private By title = By.xpath("//ion-title[starts-with(text(),'Check Report')]");
	private By agentDetails = By.xpath("//ion-list-header");
	private By agentCaret_btn = By.xpath("//ion-icon[@name='caret-down']");
//	private By agentsList = By.xpath("//ion-list[@role='list']/parent::ion-list");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn = By.xpath("//ion-button[text()='Close']");
	private By searchBar = By.xpath("//ion-searchbar[@type='text']");
	private By agentsText = By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput = By.xpath("//input[@aria-label='search text']");
	private By resetBtn = By.xpath("//button[@aria-label='reset']");
//	private By dateFilter = By.xpath("//select[@formcontrolname='dateFilter']");
//	private By selectMnth = By.xpath("//select[@formcontrolname='dateFilter']/option[3]");
//	private By loadMnthBtn = By.xpath("//ion-button[.=' Load Month ']");
//	private By checkDate = By.xpath("((//table)[2]/tbody/tr/td[12])[1]");
//	private By agentId = By.xpath("(//table)[2]/tbody/tr/td[2]");
//	private By loadAllBtn = By.xpath("//ion-button[.=' Load All ']");
//	private By loadAllBtnText = By.xpath("//ion-col[.=' Load all is export only. ']");
	private By exportBtn = By.xpath("//ion-button[.=' Export ']");
	private By HighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[1]");

	public void checkReports() throws Exception {
		String id = null;
		String fullName = null;
		String[] nameParts = null;
		String lastName = null;
		String firstName = null;
		String newTabUrl = "chrome://downloads/";

		WebUI.sleep(5);
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
		WebUI.sleep(1);
		WebUI.clickElement(resetBtn);
		WebUI.sleep(1);
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
		WebUI.sleep(2);
//		String selectedMonth = WebUI.getTextElement(dateFilter);
//		WebUI.clickElement(loadMnthBtn);
//		WebUI.sleep(5);
//		WebUI.scrollToElementAtBottom(checkDate);
//		WebUI.verifyElementVisible(agentId);
//		String[] dateParts = WebUI.getTextElement(checkDate).split("/");
//		String month = dateParts[0];
//		String year = dateParts[2];
//		String formattedDate = month + "/" + year;
////		WebUI.verifyContains(selectedMonth, formattedDate);
//		WebUI.verifyElementVisible(loadAllBtn);
//		WebUI.clickElement(loadAllBtn);
//		WebUI.sleep(7);
//		WebUI.verifyElementVisible(loadAllBtnText);
		WebUI.clickElement(exportBtn);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(1);
		WebUI.switchToMainWindow();

	}
}
