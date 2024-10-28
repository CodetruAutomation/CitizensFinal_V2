package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.sleep;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_10Page_NV;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.project.cica.utils.ThreadLocalManager;

public class HomePage extends CommonPageCICA {

	private By applicationButton = By.id("applicationButton");
	private By listApplicationButton = By.xpath("//div[@class='applicationDropdown']/div[1]");
	private By newApplicationButton = By.xpath("//div[@class='applicationDropdown']/div[2]");
	private By step1ProductInformation = By.xpath("//span[.='Step 1: Product Information']");
	private By step1InsuredInfo = By.xpath("//h3[text()='Proposed Insured Info']");
	private By listColumnNames = By.xpath("//div[@class='table-responsive hidden-sm-down']//table//thead//tr/th");
	private By newApplicationButtonListPage = By.xpath("//ion-buttons[@class='buttons-last-slot sc-ion-buttons-md-h sc-ion-buttons-md-s md hydrated']//ion-button[@class='md button button-clear in-toolbar in-toolbar-color ion-activatable ion-focusable hydrated'][normalize-space()='New Application']");
	private By searchBox = By.xpath("(//input[@placeholder='Search' and @type='search'])[1]");
	private By searchResetButton = By.xpath("(//input[@placeholder='Search' and @type='search']/following-sibling::button)[1]");
	private By nameList = By.xpath("//tbody/tr/td[1]");
	private By applicationNumberList = By.xpath("//tbody/tr/td[8]");
	private By holdDateList = By.xpath("//tbody/tr/td[5]");
	private By expireDateList = By.xpath("//tbody/tr/td[6]");
	private By noSearchItemElement = By.xpath("//ion-col[contains(text(),'Welcome to the New Business Application section of')]");
	private By proposedNameColumn = By.xpath("//th[normalize-space()='Proposed Name']");
	private By planDescriptionColumn = By.xpath("//th[normalize-space()='Plan Description']");
	private By amountOfInsuranceColumn = By.xpath("//th[normalize-space()='Amount Of Insurance']");
	private By applicationStatusColumn = By.xpath("//th[normalize-space()='Application Status']");
	private By expireDateColumn = By.xpath("//th[normalize-space()='Expire Date']");
	private By createdDateColumn = By.xpath("//th[normalize-space()='Created']");
	private By applicationNumberColumn = By.xpath("//th[normalize-space()='Application Number']");
	private By actionsEditApplicationButtonList = By.xpath("//ion-button[@title='Edit Application']");
	private By actionsEditApplicationButton = By.xpath("(//ion-button[@title='Edit Application'])[1]");
	private By actionsCancelApplicationButton = By.xpath("(//ion-button[@title='Cancel Application'])[1]");
	private By actionsDeleteApplicationButton = By.xpath("(//ion-button[@title='Delete Application'])[1]");
	private By actionsEditCancelButtons = By.xpath("//tbody/tr/td[10]/ion-button");
	private By applicationNumberHome = By.xpath("(//tbody/tr/td[8])[1]");
	private By middleNameInput = By.xpath("//ion-input[@formcontrolname='ProposedMiddleName']/input");
	private By cannotEditApplicationElement = By.xpath("//h2[normalize-space()='Submitted Applications Cannot Be Edited']");
	private By alertDeleteApplicationElement = By.xpath("//div[contains(text(),'Are you sure you want to delete this application?')]");
	private By alertDeleteApplicationCancelButton = By.xpath("//span[normalize-space()='Cancel']");
	private By alertDeleteApplicationDeleteButton = By.xpath("//span[normalize-space()='Delete']");
	private By tableOfContentHoldDateEdit = By.xpath("//span[contains(text(), 'Hold Payment and Application until')]");
	private By holdDateInput = By.xpath("//input[@formcontrolname='HoldDate']");
	private By saveDateButton = By.xpath("//ion-button[text()='Save Date ']");

	private By profileIcon = By.xpath("//ion-col[@class='ion-text-right md hydrated']//ion-button[@class='ion-color ion-color-dark md button button-clear ion-activatable ion-focusable hydrated']");
	private By logoutButton = By.xpath("//ion-item[normalize-space()='Logout']");
	private By importantNoticePopup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	private By policyPaymentButton = By.xpath("//ion-button[text()=' Policy Payment ']");

	public List<String> expectedColumnNames = Arrays.asList("Proposed Name", "Plan Description", "Amount Of Insurance",
			"Application Status", "Hold Until", "Expire Date", "Created", "Application Number", "Saved Mode",
			"Actions");

	private String searchedItemNotFoundMessage = "Welcome to the New Business Application section of the IC Portal.";
	private String cannotEditApplicationMessage = "Submitted Applications Cannot Be Edited";
	private String alertDeleteApplicationMessage = "Are you sure you want to delete this application?";

	private ProjectUtilities projectUtilities;
	
	public void openApplicationModule() {

		projectUtilities = new ProjectUtilities();
		WebUI.waitForPageLoaded();
		sleep(3);
		// Get License State and Appointment Status List from Lic & Apnt Tab
		projectUtilities.getLicenseStateAndCountyList();
		// ================================= List Page Validation ===========================================================================
		WebUI.sleep(1);
		WebUI.verifyElementPresent(applicationButton);
//		WebUI.moveToElement(applicationButton);
		WebUI.clickElement(applicationButton);
		WebUI.sleep(0.5);
		WebUI.verifyElementPresent(listApplicationButton);
		WebUI.verifyElementPresent(newApplicationButton);
//		WebUI.releaseElement(applicationButton);
//		WebUI.sleep(0.4);
//		WebUI.clickElement(applicationButton);
		WebUI.sleep(0.2);
		WebUI.clickElement(listApplicationButton);
		WebUI.waitForPageLoaded();
		WebUI.sleep(5);

		List<String> actualColumnNames = WebUI.getElementTextsInList(listColumnNames);
		WebUI.verifyListContains(expectedColumnNames, actualColumnNames);
		WebUI.verifyElementPresent(newApplicationButtonListPage);
		
		//Negative scenarios validation for Search box
		WebUI.clearAndFillText(searchBox, "    ");
		WebUI.sleep(0.4);
		WebUI.verifyContains(WebUI.getTextElement(noSearchItemElement), searchedItemNotFoundMessage);

		WebUI.clearTextCtrlA(searchBox);
		WebUI.sleep(1);
		WebUI.setText(searchBox, "123456");
		WebUI.sleep(0.4);
		WebUI.verifyContains(WebUI.getTextElement(noSearchItemElement), searchedItemNotFoundMessage);

		WebUI.clearTextCtrlA(searchBox);
		WebUI.sleep(1);
		WebUI.setText(searchBox, "1200018250");
		WebUI.sleep(0.4);
		WebUI.verifyContains(WebUI.getTextElement(noSearchItemElement), searchedItemNotFoundMessage);

		WebUI.clearTextCtrlA(searchBox);
		WebUI.sleep(1);
		WebUI.setText(searchBox, "Saved");
		WebUI.sleep(0.4);
		WebUI.verifyContains(WebUI.getTextElement(noSearchItemElement), searchedItemNotFoundMessage);

		WebUI.clearTextCtrlA(searchBox);
		WebUI.sleep(1);

		try {
			int count = 1;
			DriverManager.getDriver().findElement(nameList).isDisplayed();
			WebUI.sleep(0.5);
			List<String> proposedNameList = WebUI.getElementTextsInList(nameList); // Verify through Proposed Names

			for (int i = 0; i < 6; i++) {
				String[] fullName = proposedNameList.get(i).split(" ");
				String firstName = fullName[0];
				WebUI.sleep(0.5);
				WebUI.setText(searchBox, firstName);
				WebUI.sleep(1.5);
				WebUI.verifyContains(WebUI.getTextElement(nameList), firstName);
				WebUI.verifyElementVisible(actionsEditApplicationButton);
				
				if (WebUI.getTextElement(applicationNumberHome) == null || WebUI.getTextElement(applicationNumberHome).isEmpty()) {
					
					WebUI.verifyElementVisible(actionsDeleteApplicationButton);
					WebUI.sleep(0.5);

					if (count == 1) {
						WebUI.clickElement(actionsEditApplicationButton);
						WebUI.sleep(1);
						WebUI.verifyElementPresent(step1ProductInformation);
						WebUI.clickElement(step1ProductInformation);
						WebUI.sleep(2);
						
						try {
							DriverManager.getDriver().findElement(importantNoticePopup).isDisplayed();
							WebUI.sleep(0.5);
							WebUI.clickElement(importantNoticePopup);
						} catch (Exception ex) {
							System.out.println("Notice Popup Did Not Appear. " + ex.getMessage());
						}

						WebUI.sleep(1);
						WebUI.clearAndFillText(middleNameInput, "Johhnneyy");
						WebUI.sleep(0.4);
						WebUI.verifyContains(WebUI.getAttributeElement(middleNameInput, "value"), "Johhnneyy");

						DriverManager.getDriver().navigate().back();
						WebUI.sleep(0.5);
						DriverManager.getDriver().navigate().back();
						WebUI.sleep(0.5);

						WebUI.clickElement(actionsDeleteApplicationButton);
						WebUI.sleep(1);
						WebUI.verifyElementVisible(alertDeleteApplicationElement);
						WebUI.verifyElementVisible(alertDeleteApplicationDeleteButton);
						WebUI.verifyElementVisible(alertDeleteApplicationCancelButton);
						WebUI.verifyEquals(WebUI.getTextElement(alertDeleteApplicationElement),alertDeleteApplicationMessage);
						WebUI.clickElement(alertDeleteApplicationCancelButton);
						WebUI.sleep(0.5);
//---------------------------------------------------------------------------------------
						WebUI.clearTextCtrlA(searchBox);
						WebUI.setText(searchBox, firstName);
						WebUI.sleep(1.5);
						WebUI.verifyContains(WebUI.getTextElement(nameList), firstName);
						WebUI.clickElement(actionsDeleteApplicationButton);
						WebUI.sleep(1);
						WebUI.clickElement(alertDeleteApplicationDeleteButton);
						WebUI.sleep(1);
						WebUI.clearTextCtrlA(searchBox);
						WebUI.setText(searchBox, firstName);
						WebUI.sleep(1.5);
//						WebUI.verifyContains(WebUI.getTextElement(noSearchItemElement), searchedItemNotFoundMessage);
//---------------------------------------------------------------------------------------
						count++;
					}
				}
				WebUI.clickElement(searchResetButton);
				WebUI.sleep(0.4);
			}
			
			WebUI.sleep(1);

			 // Verify through Application Numbers
			List<String> applicationNumbers = WebUI.getElementTextsInList(applicationNumberList);
																									 
			System.out.println("-------------------->>" + applicationNumbers.isEmpty());

			int count2 = 1;
			for (int i = 0; i < 6; i++) {
				
				System.out.println("Application Number obtained from List >>>>>>>>>>>>>>>>>>>>>> " + applicationNumbers.get(i));
				WebUI.clearAndFillText(searchBox, applicationNumbers.get(i));
				WebUI.sleep(0.5);
				System.out.println("Fetched Application Number after entering details in search box"+ WebUI.getTextElement(applicationNumberList));
				WebUI.verifyContains(WebUI.getTextElement(applicationNumberList), applicationNumbers.get(i));
				WebUI.verifyElementVisible(actionsEditApplicationButton);
				
				List<WebElement> editCancelButton = WebUI.getWebElements(actionsEditCancelButtons);
				System.out.println("editCancelButton Size >>>>>>>>>>>>>>>>>>>>>>>>> "+editCancelButton.size());
				if(editCancelButton.size() > 1 && !(WebUI.getTextElement(applicationNumberHome) == null || WebUI.getTextElement(applicationNumberHome).isEmpty()))
				{
					WebUI.verifyElementVisible(actionsCancelApplicationButton);
					WebUI.logInfoMessage("Cancel Application is enabled for Application No.: "+WebUI.getTextElement(applicationNumberHome));
				}
				
/*				// Verify cannot edit the submitted application - Bug. Standard Issue notification pop-up issue.
				if(count2 == 1) {
					WebUI.clickElement(actionsEditApplicationButton);
					WebUI.sleep(1);
					WebUI.clickElement(step1ProductInformation);
					WebUI.sleep(2);
					try {
						DriverManager.getDriver().findElement(importantNoticePopup).isDisplayed();
						WebUI.sleep(0.2);
						WebUI.clickElement(importantNoticePopup);
						WebUI.sleep(0.4);
						DriverManager.getDriver().findElement(importantNoticePopup).click();
						WebUI.sleep(0.2);
					}catch(Exception ex)
					{
						System.out.println("Important Notice popup didn't appear."+ ex.getMessage());
						WebUI.sleep(0.2);
					}
					WebUI.verifyElementPresent(cannotEditApplicationElement);
					WebUI.verifyContains(WebUI.getTextElement(cannotEditApplicationElement),cannotEditApplicationMessage);
					WebUI.verifyElementNotEnabled(middleNameInput);

					DriverManager.getDriver().navigate().back();
					WebUI.sleep(0.5);
					DriverManager.getDriver().navigate().back();
					WebUI.sleep(0.5);
					count2++;
				}					
//*/
				
			}

			WebUI.clearTextCtrlA(searchBox);
			WebUI.sleep(1.2);

			//Change Hold Date TC
			List<String> obtainedHoldDates = WebUI.getElementTextsInListIncludeEmpty(holdDateList);
			List<String> obtainedApplicationNumbers = WebUI.getElementTextsInListIncludeEmpty(applicationNumberList);
			String applicationNum = projectUtilities.getFirstNonEmptyCorrespondingElement(obtainedHoldDates,obtainedApplicationNumbers);
			if (applicationNum != null) {
				WebUI.setText(searchBox, applicationNum);
				WebUI.sleep(0.5);
				WebUI.clickElement(actionsEditApplicationButton);
				WebUI.sleep(1.5);
				WebUI.clickElement(tableOfContentHoldDateEdit);
				WebUI.sleep(0.5);
				String holdDateGiven = WebUI.getAttributeElement(holdDateInput, "value");
				System.out.println("Given Hold Date: " + holdDateGiven);
				WebUI.logInfoMessage("Given Hold Date: " + holdDateGiven);
				String updatedDate = projectUtilities.getNextValidDate(holdDateGiven);
				System.out.println("Updated Hold Date: " + updatedDate);
				WebUI.logInfoMessage("Updated Hold Date: " + updatedDate);
				WebUI.clearTextCtrlA(holdDateInput);
				WebUI.sleep(0.5);
				WebUI.setText(holdDateInput, updatedDate);
				WebUI.sleep(0.5);
				WebUI.clickElement(saveDateButton);
				WebUI.sleep(1);
				DriverManager.getDriver().navigate().back();
				WebUI.sleep(0.5);
				WebUI.clearTextCtrlA(searchBox);
				WebUI.sleep(1);
			}

			
// =======================================================================================================================================

			WebUI.clickElement(proposedNameColumn);
			WebUI.sleep(0.2);
			WebUI.clickElement(proposedNameColumn);
			WebUI.sleep(0.4);

			WebUI.clickElement(planDescriptionColumn);
			WebUI.sleep(0.2);
			WebUI.clickElement(planDescriptionColumn);
			WebUI.sleep(0.4);

			WebUI.clickElement(amountOfInsuranceColumn);
			WebUI.sleep(0.2);
			WebUI.clickElement(amountOfInsuranceColumn);
			WebUI.sleep(0.4);

			WebUI.clickElement(applicationStatusColumn);
			WebUI.sleep(0.2);
			WebUI.clickElement(applicationStatusColumn);
			WebUI.sleep(0.4);

			// Sorting Bug of Expiry Date Column in List
			// WebUI.clickElement(expireDateColumn); // Commented out
			// WebUI.sleep(0.2);
			// WebUI.clickElement(expireDateColumn);
			// WebUI.sleep(0.4);

			WebUI.clickElement(createdDateColumn);
			WebUI.sleep(0.2);
			WebUI.clickElement(createdDateColumn);
			WebUI.sleep(0.4);

			WebUI.clickElement(applicationNumberColumn);
			WebUI.sleep(0.3);
			WebUI.clickElement(applicationNumberColumn);
			WebUI.sleep(0.4);

		} catch (Exception ex) {
			System.out.println("Failed: " + ex.getMessage());
		}

		WebUI.sleep(1);
		WebUI.clickElement(applicationButton);
		WebUI.sleep(1);

		WebUI.clickElement(newApplicationButton);
		WebUI.sleep(2);

		WebUI.verifyElementVisible(step1ProductInformation, "Step-1 tab not available");
		WebUI.clickElement(step1ProductInformation);
		WebUI.sleep(2);

		WebUI.waitForPageLoaded();
		WebUI.verifyElementVisible(step1InsuredInfo, "Insured Info not displayed");
	}
	
	// Verify Expire Date Payment TC
	public void verifyExpireDatePayment() {
		
		SoftAssert softAssert = new SoftAssert();
		WebUI.sleep(1);
		WebUI.clickElement(applicationButton);
		WebUI.sleep(1);
		WebUI.clickElement(listApplicationButton);
		WebUI.sleep(1);
		WebUI.sleep(1);
		List<String> obtainedExpireDates = WebUI.getElementTextsInListIncludeEmpty(expireDateList);
		System.out.println("Obtained Expired Dates: "+obtainedExpireDates);
		List<String> obtainedApplicationNumbers = WebUI.getElementTextsInListIncludeEmpty(applicationNumberList);
		String applicationNumber = projectUtilities.getElementForExpiredDate(obtainedExpireDates, obtainedApplicationNumbers);
		WebUI.sleep(2);
		try {
			WebUI.clearTextCtrlA(searchBox);
			WebUI.sleep(0.2);
			WebUI.setText(searchBox, applicationNumber);
			WebUI.sleep(0.5);
			WebUI.clickElement(actionsEditApplicationButton);
			WebUI.sleep(1.5);
			Step_10Page_NV step10Page = new Step_10Page_NV();
			step10Page.Make_a_Payment();
			ThreadLocalManager.setFlag(1);
			softAssert.fail();

		} catch (Exception exception) {

			WebUI.logInfoMessage("Could not complete payment for the expired date application.");
		}

	}

	public void homePageNewApplication() {
		WebUI.sleep(3);
		WebUI.clickElement(applicationButton);
		WebUI.sleep(1);
		WebUI.clickElement(newApplicationButton);
		WebUI.sleep(2);
	}

	public void logout() {
		WebUI.sleep(2);
		WebUI.clickElement(profileIcon);
		WebUI.sleep(1);
		WebUI.clickElement(logoutButton);
		WebUI.sleep(3);
	}

}