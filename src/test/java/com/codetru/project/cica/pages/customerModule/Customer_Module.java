package com.codetru.project.cica.pages.customerModule;

import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.utils.DataGenerateUtils;

public class Customer_Module extends CommonPageCICA {


	private By policyNumber = By.xpath("//ion-input[@formcontrolname='PolicyNumber']/input");
	private By searchButton = By.xpath("(//ion-button[text()='Search'])[2]");
	private By clear_btn = By.xpath("(//ion-button[text()='Clear '])[2]");
	private By no_result  = By.xpath("//h5[normalize-space()='No Results']");
	private By searchPolicyNumber = By.xpath("//tbody/tr/td");
	private By lastName = By.xpath("//ion-input[@formcontrolname='LastName']/input");
	private By firstName = By.xpath("//ion-input[@formcontrolname='FirstName']/input");
	private By directCustomers= By.xpath("(//ion-button[text()='Direct Customers'])[2]");
	private By secondPolicyNumber=By.xpath("//tr[2]/td[1]");
	private By listofNames=By.xpath("//tbody/tr/td[3]");
	private By pagenation=By.xpath("//ion-col[starts-with(text(), ' Page')]");
	private By pagenationDropdown=By.xpath("//option[.='10']/parent::select");
	private By nextPageIcon=By.xpath("//ion-button[@title='Next Page']");
	private By prevPageIcon=By.xpath("//ion-button[@title='Prev Page']");
	private By lastPagePlayIcon=By.xpath("//ion-button[@title='Last Page']");
	private By firstPageplayIcon=By.xpath("//ion-button[@title='First Page']");
	private By clickonapplication=By.xpath("//tbody/tr");
	private By printBtn=By.xpath("//ion-button[.='Print']");
	private By sameName=By.xpath("//tbody/tr/td[2][.='']/following-sibling::td[contains(text(), ',')]");
	private By differentNames=	By.xpath("//tbody/tr/td[2][contains(text(),',')]/following-sibling::td[1]");
	private By insuredname=By.xpath("//ion-label[.='Insured Name']");
	private By policyNumberFromList= By.xpath("//tbody/tr/td[1]");
	private By table=By.xpath("//div/table");
	private By arrowUp=By.xpath("//ion-icon[@name='arrow-up']");
	private By arrowdown=By.xpath("//ion-icon[@name='arrow-down']");
	//th[.='Owner Full Name ']
	//th[.='Insured Full Name ']
	//th[.='Issue Date ']
	//th[.='W8/W9 Completion ']
	private By OwnerName=By.xpath("//th[.='Owner Full Name ']");
	private By InsuredName=By.xpath("//th[.='Insured Full Name ']");
	private By IssueDate=By.xpath("//th[.='Issue Date ']");
	private By Completion=By.xpath("//th[.='W8/W9 Completion ']");
	//private By searchingSpinner = By.xpath("//div[text()='Searching...']");
	private By pleaseWaitSpinner = By.xpath("//div[text()='Please Wait…']/parent::div");
 
	public void customer_module() {
 
		String No_result = "No Results";
		String lname;
		String fname;
		String five="5";
		String ten="10";
		String twentyfive="25";
		String fifty="50";
		String numericData="4152";
		String invalidSearch="bnml";
		String splChars="!@#$%";
		String newTabUrl="chrome://downloads/";
 
		String jspath="return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\")";
		String number;
		WebUI.sleep(1);
		//	     ***Without entering the data in the Fname, Lname and Policy Number fields "No Results" be Displayed***
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);
		WebUI.clickElement(directCustomers);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(0.5);
		String validPolicyNumber= WebUI.getTextElement(secondPolicyNumber);
		String[]names= 	WebUI.getTextElement(listofNames).split(",");
		fname=names[0];
		System.out.println(fname);
		lname=names[1];
		System.out.println(lname);
		WebUI.sleep(2);
 
		//		*** no results should be displayed if we fill the lastName in the FirstName field ***
		//		WebUI.setText(firstName, lname);
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);
		//			WebUI.clickElement(clear_btn);
 
		//		*** no results should be displayed if we fill the lastName in the FirstName field ***
		//		WebUI.setText(lastName, fname);
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);
		//		WebUI.clickElement(clear_btn);
 
		//		*** no results should be displayed if we fill the FName and LName in Vice-versa ***
		//		WebUI.setText(firstName, lname);
		//		WebUI.setText(lastName, fname);
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);
		//		WebUI.clickElement(directCustomers);
 
		//	     ***Without entering the data in the Fname, Lname and Policy Number fields "No Results" be Displayed***
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);
		//		WebUI.clickElement(directCostomers);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//			String validPolicyNumber= WebUI.getTextElement(secondPolicyNumber);
		//			String[]name= 	WebUI.getTextElement(listofNames).split(",");
		//			fname=name[0];
		//			lname=name[1];
		//			WebUI.sleep(2);
		//
		//			//		*** no results should be displayed if we fill the lastName in the FirstName field ***
		//			//		WebUI.setText(firstName, lname);
		//			//		WebUI.clickElement(searchButton);
		//			//		WebUI.sleep(0.5);
		//			//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//			//		WebUI.verifyElementVisible(no_result);
		//			//		WebUI.clickElement(clear_btn);
		//
		//			//		*** no results should be displayed if we fill the lastName in the FirstName field ***
		//			//		WebUI.setText(lastName, fname);
		//			//		WebUI.clickElement(searchButton);
		//			//		try {
		//			//			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
		//			//			{
		//			//				continue;
		//			//			}
		//			//		}catch(Exception ex)
		//			//		{
		//			//			System.out.println("");
		//			//			WebUI.sleep(2);
		//			//		}
		//			//		WebUI.verifyElementVisible(no_result);
		//			//	WebUI.clickElement(clear_btn);
		//
		//
		//			//		*** no results should be displayed if we fill the FName and LName in Vice-versa ***
		//			//		WebUI.setText(firstName, lname);
		//			//		WebUI.setText(lastName, fname);
		//			//		WebUI.clickElement(searchButton);
		//			//		try {
		//			//			while(DriverManager.getDriver().findElement(searchingSpinner).isDisplayed())
		//			//			{
		//			//				continue;
		//			//			}
		//			//		}catch(Exception ex)
		//			//		{
		//			//			System.out.println("");
		//			//			WebUI.sleep(2);
		//			//		}
		//			//		WebUI.verifyElementVisible(no_result);
		//			//	WebUI.clickElement(directCostomers);
		WebUI.clickElement(arrowUp);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(arrowdown);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(OwnerName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(OwnerName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(InsuredName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(InsuredName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(IssueDate);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(IssueDate);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(Completion);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(Completion);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		DriverManager.getDriver().findElement(policyNumber).click();
		WebUI.sleep(1.5);
		WebUI.setText(policyNumber, "4152");
		WebUI.sleep(1);
		WebUI.setText(firstName, "qwe");
		WebUI.sleep(1);
		WebUI.setText(lastName, "2346");
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(WebUI.getTextElement(no_result).trim(), No_result);
		WebUI.sleep(2);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(directCustomers);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.verifyElementPresent(table);
		number =WebUI.getTextElement(policyNumberFromList);
		String subSetOfString=	number.substring(1, 5);
		System.out.println(subSetOfString);
		List<String>  actualPolicyNumber= WebUI.getElementTextsInList(policyNumberFromList);	
		for(String name1:actualPolicyNumber){
			WebUI.verifyContains(name1, subSetOfString);
		}
		WebUI.sleep(0.5);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1);
		WebUI.clickElement(directCustomers);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(0.5);
		try {
			WebUI.clickElement(sameName);
			ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		} catch (Exception e) {
			WebUI.clickElement(differentNames);
		}
		WebUI.sleep(1.5);
		//WebUI.verifyElementNotPresent(insuredname);
		DriverManager.getDriver().navigate().back();
		WebUI.sleep(1);
		WebUI.clickElement(OwnerName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(OwnerName);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(0.5);
		try {
			if(DriverManager.getDriver().findElement(sameName).isDisplayed()) {
				WebUI.clickElement(sameName);
				ProjectUtilities.spinnerWait(pleaseWaitSpinner);
				DriverManager.getDriver().navigate().back();
			}else {
				WebUI.sleep(0.5);
			}
		} catch (Exception e) {
			WebUI.sleep(1.5);
		}
 
		WebUI.sleep(2);
		//WebUI.verifyElementPresent(insuredname);
		//WebUI.sleep(1);
		DriverManager.getDriver().findElement(policyNumber).click();
		WebUI.sleep(1.5);
		WebUI.setText(policyNumber, "lname1");
		WebUI.sleep(0.5);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(WebUI.getTextElement(no_result).trim(), No_result);
		WebUI.sleep(1);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1);
		DriverManager.getDriver().findElement(policyNumber).click();
		String RandomPolicyNumber = DataGenerateUtils.randomPolicyNumber();
		WebUI.setText(policyNumber, RandomPolicyNumber);
		WebUI.sleep(0.5);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.sleep(1);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(2);
		DriverManager.getDriver().findElement(policyNumber).click();
		WebUI.sleep(1);
		//		WebUI.clickElement(searchButton);
		//		WebUI.sleep(0.5);
		//		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(searchPolicyNumber);
		//		DriverManager.getDriver().findElement(policyNumber).click();
		WebUI.setText(policyNumber, validPolicyNumber);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.verifyElementVisible(searchPolicyNumber);
		WebUI.clearAndFillText(lastName, invalidSearch);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
		WebUI.clearAndFillText(lastName, numericData);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(1);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
		WebUI.clearAndFillText(lastName, splChars);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
 
		//String Randomfirstname = DataGenerateUtils.randomFirstName();
		WebUI.clearAndFillText(firstName, invalidSearch);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
//		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
		WebUI.clearAndFillText(firstName, numericData);
		WebUI.sleep(0.5);
		WebUI.clickElement(searchButton);
		WebUI.sleep(3);
		//		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
		WebUI.clearAndFillText(firstName, splChars);
		WebUI.sleep(0.5);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
 
		WebUI.setText(lastName, lname);
		WebUI.sleep(0.5);
		WebUI.clickElement(searchButton);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
//		List<String> columnNames_Actual = WebUI.getElementTextsInList(listofNames);	
		List<String> actualColumnNames = ProjectUtilities.splitListByComma(WebUI.getElementTextsInList(listofNames));
		WebUI.verifyStringInList(actualColumnNames, lname);
		WebUI.clickElement(clear_btn);
 
		WebUI.setText(firstName, fname);
		WebUI.clickElement(searchButton);
		WebUI.sleep(0.5);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
//		List<String> columnNames_Actual1 = WebUI.getElementTextsInList(listofNames);
		List<String> actualColumnNames1 = ProjectUtilities.splitListByComma(WebUI.getElementTextsInList(listofNames));
		WebUI.verifyStringInList(actualColumnNames1, fname);
		WebUI.sleep(0.5);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(0.5);
 
		WebUI.clearAndFillText(lastName, invalidSearch);
		WebUI.clearAndFillText(firstName, invalidSearch);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		//		WebUI.verifyElementVisible(no_result);	
		WebUI.verifyContains(getTextElement(no_result).trim(), No_result);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(0.5);
		WebUI.setText(firstName, fname);
		WebUI.setText(lastName, lname);
		WebUI.sleep(1);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
//		List<String> columnNames_Actual2 = WebUI.getElementTextsInList(listofNames);
		List<String> actualColumnNames2 = ProjectUtilities.splitListByComma(WebUI.getElementTextsInList(listofNames));

		WebUI.verifyStringInList(actualColumnNames2, fname);
		WebUI.verifyStringInList(actualColumnNames2, lname);
		WebUI.sleep(0.5);
		WebUI.clickElement(clear_btn);
		WebUI.sleep(1.5);
		WebUI.clickElement(directCustomers);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(0.5);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(2);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, ten);
		WebUI.sleep(2);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, twentyfive);
		WebUI.scrollToElementAtTop(clear_btn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, fifty);
		WebUI.sleep(2);
		WebUI.scrollToElementAtTop(clear_btn);
		WebUI.scrollToElementAtBottom(pagenation);
		WebUI.clickElement(pagenationDropdown);
		WebUI.selectOptionByText(pagenationDropdown, five);
		WebUI.sleep(2);
		WebUI.clickElement(nextPageIcon);
		WebUI.sleep(1.5);
		WebUI.clickElement(nextPageIcon);
		WebUI.sleep(1.5);
		WebUI.clickElement(prevPageIcon);
		WebUI.sleep(1.5);
		WebUI.clickElement(lastPagePlayIcon);
		WebUI.sleep(1.5);
		WebUI.clickElement(firstPageplayIcon);
		WebUI.sleep(2);
		WebUI.clickElement(searchButton);
		WebUI.sleep(1);
		ProjectUtilities.spinnerWait(pleaseWaitSpinner);
		WebUI.clickElement(clickonapplication);
		WebUI.sleep(1.5);
		WebUI.scrollToElementAtTop(printBtn);
		WebUI.clickElement(printBtn);
		WebUI.sleep(2);
		WebUI.switchToChildWindow();
		WebUI.sleep(2);
 
		WebUI.pressKeyWithRobot("ESCAPE", 1);
		WebUI.sleep(1.5);	
		WebUI.switchToMainWindow();
		WebUI.sleep(1);
		DriverManager.getDriver().navigate().back();
		WebUI.sleep(1);

	}
}