package com.codetru.project.cica.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.utils.LogUtils;

public class ProjectUtilities {
	
	private By profile_Icon = By.xpath("//ion-col[@class='ion-text-right md hydrated']//ion-button[@class='ion-color ion-color-dark md button button-clear ion-activatable ion-focusable hydrated']");
	private By licenses_Appointments_Tab = By.xpath("//ion-item[normalize-space()='Licenses & Appointments']");
	private By first_row_first_column = By.xpath("//tbody/tr[1]/td[1]");
	private By lic_States = By.xpath("//th[normalize-space()='License State']/following::tbody/tr[not(@style='background-color: red;')]/td[6]");
	private By appointment_Status = By.xpath("//th[normalize-space()='License State']/following::tbody/tr[not(@style='background-color: red;')]/td[10]");
	private By agentID_Popup_CloseButton = By.xpath("//ion-button[@class='md button button-small button-clear in-toolbar in-toolbar-color ion-activatable ion-focusable hydrated']");
	private By lic_County = By.xpath("//th[normalize-space()='License County']/following::tbody/tr[not(@style='background-color: red;')]/td[7]");
	private By lic_Exp_Date = By.xpath("//th[normalize-space()='License Exp Date']/following::tbody/tr[not(@style='background-color: red;')]/td[9]");
	private By Licenses_Appointment_Data_Popup = By.xpath("//div[contains(text(),'Loading licenses and appointments data')]");
	private static By signaturePad = By.xpath("//canvas[@class='signature-pad-canvas hidden-xs-down']");
	
	public List<String> getLicenseStateAndCountyList() {

		List<String> licenseStateTexts;
		List<String> appointmentStatusTexts;
		List<String> licenseCountyTexts;
		List<String> licenseExpDates;

		WebUI.sleep(1);
		WebUI.clickElement(profile_Icon);
		WebUI.sleep(1);
		WebUI.clickElement(licenses_Appointments_Tab);
		WebUI.sleep(2);

//		try {
//			for (int wt = 0; wt <= 30; wt++) {
//				if (DriverManager.getDriver().findElement(Licenses_Appointment_Data_Popup).isDisplayed()) {
//					WebUI.sleep(1);
//
//				}
//				if (wt == 30) {
//					Assert.fail();
//				}
//			}
//
//		} catch (Exception ex) {
//			System.out.println("");
//		}
		spinnerWaitWithTime(Licenses_Appointment_Data_Popup, 30);

		WebUI.sleep(1);
		System.out.println("Get the state list");
		WebUI.waitForElementPresent(first_row_first_column);
		WebUI.clickElement(first_row_first_column);
		WebUI.sleep(2);

		licenseStateTexts = WebUI.getElementTextsInList(lic_States);
		licenseCountyTexts = WebUI.getElementTextsInListIncludeEmpty(lic_County);
		licenseExpDates = WebUI.getElementTextsInList(lic_Exp_Date);
		appointmentStatusTexts = WebUI.getElementTextsAndDeleteCorrespondingIfFoundEmpty(appointment_Status, licenseStateTexts, licenseCountyTexts, licenseExpDates);

		System.out.println("License States: " + licenseStateTexts);
		System.out.println("************************  License State texts count: " + licenseStateTexts.size());
		System.out.println("License County: " + licenseCountyTexts);
		System.out.println("************************ License County texts count: " + licenseCountyTexts.size());
		System.out.println("Appointment Status : " + appointmentStatusTexts);
		System.out.println("************************ Appointment Status texts count: " + appointmentStatusTexts.size());
		System.out.println("************************ Lic Exp Date Count: " + licenseExpDates.size());

		WebUI.processListsAndDeleteCorresponding(licenseCountyTexts, licenseStateTexts, appointmentStatusTexts, licenseExpDates, "FL");
		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Unrequested", licenseStateTexts, licenseCountyTexts, licenseExpDates);
		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Inactive/Cancelled", licenseStateTexts,	licenseCountyTexts, licenseExpDates);
		remove_States_County_MatchingDateAndCorresponding(licenseExpDates, licenseStateTexts, licenseCountyTexts, appointmentStatusTexts);

		System.out.println("***************************************************************************************************");
		System.out.println("License States: " + licenseStateTexts);
		System.out.println("************************  License State texts count: " + licenseStateTexts.size());
		System.out.println("License County: " + licenseCountyTexts);
		System.out.println("************************ License County texts count: " + licenseCountyTexts.size());
		System.out.println("Appointment Status : " + appointmentStatusTexts);
		System.out.println("************************ Appointment Status texts count: " + appointmentStatusTexts.size());
		System.out.println("************************ Lic Exp Dates : " + licenseExpDates);

		WebUI.removeDuplicatesAndCorresponding(licenseCountyTexts, licenseStateTexts, appointmentStatusTexts, licenseExpDates);

		// Store the lists in the ThreadLocalManager
		ThreadLocalManager.setLicenseStateList(licenseStateTexts);
		ThreadLocalManager.setAppointmentStatusList(appointmentStatusTexts);
		ThreadLocalManager.setLicenseCountyList(licenseCountyTexts);
		ThreadLocalManager.setLicenseExpDateList(licenseExpDates);

		// Print the list size from both columns
		System.out.println("License State texts count: " + licenseStateTexts.size());
		System.out.println("Appointment Status texts count: " + appointmentStatusTexts.size());
		System.out.println("License County texts count: " + licenseCountyTexts.size());
		System.out.println("License Exp Dates texts count: " + licenseExpDates.size());
		// Print the texts from both columns
		System.out.println("License State texts: " + licenseStateTexts);
		System.out.println("Appointment Status texts: " + appointmentStatusTexts);
		System.out.println("License County texts: " + licenseCountyTexts);
		System.out.println("License Exp Dates texts: " + licenseExpDates);

		WebUI.logInfoMessage("License States: " + licenseStateTexts);
		WebUI.logInfoMessage("Appointment Status: " + appointmentStatusTexts);
		WebUI.logInfoMessage("License County: " + licenseCountyTexts);
		WebUI.logInfoMessage("License Exp Dates texts: " + licenseExpDates);
		WebUI.logInfoMessage("License State texts count: " + licenseStateTexts.size());
		WebUI.logInfoMessage("Appointment Status texts count: " + appointmentStatusTexts.size());
		WebUI.logInfoMessage("License County texts count: " + licenseCountyTexts.size());
		WebUI.logInfoMessage("License Exp Dates texts count: " + licenseExpDates.size());

		WebUI.clickElement(agentID_Popup_CloseButton);
		return licenseStateTexts;
	}

	public List<String> getLicenseStateList_Excd_FL() {

		List<String> licenseStateTexts;
		List<String> appointmentStatusTexts;

		WebUI.sleep(0.5);
		WebUI.clickElement(profile_Icon);
		WebUI.sleep(1);
		WebUI.clickElement(licenses_Appointments_Tab);
		WebUI.sleep(2);

		spinnerWaitWithTime(Licenses_Appointment_Data_Popup, 30);

		System.out.println("Get the licensed state list");
		WebUI.waitForElementPresent(first_row_first_column);
		WebUI.clickElement(first_row_first_column);
		WebUI.sleep(2);

		licenseStateTexts = WebUI.getElementTextsInList(lic_States);
		appointmentStatusTexts = WebUI.getElementTextsAndDeleteCorrespondingIfFoundEmpty(appointment_Status, licenseStateTexts);

		WebUI.removeElementsContainingAndCorresponding(licenseStateTexts, "FL", appointmentStatusTexts);
		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Unrequested", licenseStateTexts);
		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Inactive/Cancelled", licenseStateTexts);
		WebUI.removeDuplicatesAndCorresponding(licenseStateTexts, appointmentStatusTexts);

		// Store the lists in the ThreadLocalManager
		ThreadLocalManager.setLicenseStateList(licenseStateTexts);
		ThreadLocalManager.setAppointmentStatusList(appointmentStatusTexts);

		// Print the list size from both columns
		System.out.println("License State texts count: " + licenseStateTexts.size());
		System.out.println("Appointment Status texts count: " + appointmentStatusTexts.size());
		// Print the texts from both columns
		System.out.println("License State texts: " + licenseStateTexts);
		System.out.println("Appointment Status texts: " + appointmentStatusTexts);

		WebUI.logInfoMessage("License States: " + licenseStateTexts);
		WebUI.logInfoMessage("Appointment Status: " + appointmentStatusTexts);
		WebUI.logInfoMessage("License State texts count: " + licenseStateTexts.size());
		WebUI.logInfoMessage("Appointment Status texts count: " + appointmentStatusTexts.size());

		WebUI.clickElement(agentID_Popup_CloseButton);

		return licenseStateTexts;
	}

	public List<String> getLicenseStateList_FL() {

		List<String> licenseStateTexts;
		List<String> appointmentStatusTexts;
		List<String> licenseCountyTexts;

		WebUI.sleep(0.5);
		WebUI.clickElement(profile_Icon);
		WebUI.sleep(1);
		WebUI.clickElement(licenses_Appointments_Tab);
		WebUI.sleep(2);

		spinnerWaitWithTime(Licenses_Appointment_Data_Popup, 30);

		System.out.println("Get the state list");
		WebUI.waitForElementPresent(first_row_first_column);
		WebUI.clickElement(first_row_first_column);
		WebUI.sleep(2);

		licenseStateTexts = WebUI.getElementTextsInList(lic_States);
		licenseCountyTexts = WebUI.getElementTextsInListIncludeEmpty(lic_County);
		appointmentStatusTexts = WebUI.getElementTextsInListIncludeEmpty(appointment_Status);

		System.out.println("License States: " + licenseStateTexts);
		System.out.println("************************  License State texts count: " + licenseStateTexts.size());
		System.out.println("License County: " + licenseCountyTexts);
		System.out.println("************************ License County texts count: " + licenseCountyTexts.size());
		System.out.println("Appointment Status : " + appointmentStatusTexts);
		System.out.println("************************ Appointment Status texts count: " + appointmentStatusTexts.size());

		WebUI.removeEmptyOrNullElementsFromLists(licenseCountyTexts, appointmentStatusTexts);

		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Unrequested", licenseCountyTexts);
		WebUI.removeElementsContainingAndCorresponding(appointmentStatusTexts, "Inactive/Cancelled", licenseCountyTexts);

		System.out.println("***************************************************************************************************");
		System.out.println("License States: " + licenseStateTexts);
		System.out.println("************************  License State texts count: " + licenseStateTexts.size());
		System.out.println("License County: " + licenseCountyTexts);
		System.out.println("************************ License County texts count: " + licenseCountyTexts.size());
		System.out.println("Appointment Status : " + appointmentStatusTexts);
		System.out.println("************************ Appointment Status texts count: " + appointmentStatusTexts.size());

		WebUI.removeDuplicatesAndCorresponding(licenseCountyTexts, appointmentStatusTexts);

		// Store the lists in the ThreadLocalManager
		ThreadLocalManager.setLicenseStateList(licenseStateTexts);
		ThreadLocalManager.setAppointmentStatusList(appointmentStatusTexts);
		ThreadLocalManager.setLicenseCountyList(licenseCountyTexts);

		System.out.println("License State texts count: " + licenseStateTexts.size());
		System.out.println("Appointment Status texts count: " + appointmentStatusTexts.size());
		System.out.println("License County texts count: " + licenseCountyTexts.size());
		System.out.println("License State texts: " + licenseStateTexts);
		System.out.println("Appointment Status texts: " + appointmentStatusTexts);
		System.out.println("License County texts: " + licenseCountyTexts);

		WebUI.logInfoMessage("Appointment Status: " + appointmentStatusTexts);
		WebUI.logInfoMessage("License County: " + licenseCountyTexts);
		WebUI.logInfoMessage("Appointment Status texts count: " + appointmentStatusTexts.size());
		WebUI.logInfoMessage("License County texts count: " + licenseCountyTexts.size());

		WebUI.clickElement(agentID_Popup_CloseButton);
		return licenseCountyTexts;
	}

//	("Remove elements from list2, list3 and list4 if date matches today's date and corresponding elements from date list")
	public static boolean remove_States_County_MatchingDateAndCorresponding(List<String> dateList, List<String> list2,
			List<String> list3, List<String> list4) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String todayDate = dateFormat.format(new Date()); 

		try {
			for (int i = 0; i < dateList.size(); i++) {
				
				if (dateList.get(i).trim().equals(todayDate)) {
					dateList.remove(i);
					list2.remove(i);
					list3.remove(i);
					list4.remove(i);
					i--; // Adjust index after removal
				}
			}
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

//	("Get the next valid date, ensuring it doesn't exceed the 14-day rule from today's date")
	public String getNextValidDate(String inputDate) {
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(inputDate, inputFormatter);

		LocalDate today = LocalDate.now();
		LocalDate nextDate = date.plusDays(1);

		// Check if the next date exceeds 14 days from today
		long daysBetween = ChronoUnit.DAYS.between(today, nextDate);

		if (daysBetween > 14) {
			nextDate = today.plusDays(12);
		}

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return nextDate.format(outputFormatter);
	}

	public String getFirstNonEmptyCorrespondingElement(List<String> list1, List<String> list2) {
		
		if (list1 == null || list2 == null || list1.size() != list2.size()) {
			throw new IllegalArgumentException("Lists must be non-null and of equal size");
		}

		for (int i = 0; i < list1.size(); i++) {
			String list1Value = list1.get(i);

			if (list1Value != null && !list1Value.trim().isEmpty()) {
				// Return the corresponding element from list2
				return list2.get(i);
			}
		}

		return null;
	}
	
	public static void signature1()
	{
		WebUI.clickHold(signaturePad);
		WebUI.moveToOffset(25, 25);
		WebUI.moveToOffset(35, 30);
		WebUI.moveToOffset(16, 26);
		WebUI.moveToOffset(-76, -26);
		WebUI.moveToOffset(18, 56);
		WebUI.moveToOffset(-52, -36);
		WebUI.moveToOffset(-21, -25);
		WebUI.moveToOffset(36, 26);
		WebUI.moveToOffset(-54, 56);
		WebUI.releaseElement(signaturePad);
	}
	
	public static void signature2() {
		
		WebUI.clickHold(signaturePad);
		WebUI.moveToOffset(10, 10);
		WebUI.moveToOffset(20, 45);
		WebUI.moveToOffset(35, 30);
		WebUI.moveToOffset(16, 26);
		WebUI.moveToOffset(-50, -10);
		WebUI.moveToOffset(18, 56);
		WebUI.moveToOffset(-40, -55);
		WebUI.moveToOffset(-21, -25);
		WebUI.moveToOffset(36, 26);
		WebUI.moveToOffset(-60, 65);
		WebUI.moveToOffset(-100, 90);
		WebUI.releaseElement(signaturePad);
 }
	
	// Method to return the corresponding element from list2 when a valid date is found
	public String getElementForExpiredDate(List<String> dateList, List<String> list2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate today = LocalDate.now();

		for (int i = 0; i < dateList.size(); i++) {
			String dateStr = dateList.get(i).trim();

			if (dateStr.isEmpty()) {
				continue;
			}

			LocalDate date = LocalDate.parse(dateStr, formatter);

			if (date.isBefore(today)) {
				return list2.get(i);
			}
		}

		return null;
	}

	// Spinner wait 
	public static void spinnerWait(By locator) {
		try {
			while (DriverManager.getDriver().findElement(locator).isDisplayed()) {
				continue;
			}
		} catch (Exception ex) {
			WebUI.sleep(1);
		}
	}
	
	// Spinner wait with 30 secs max wait
	public static void spinnerWaitWithTime(By locator, int maxWaitTimeInSecs) {
		try {
			for (int wt = 0; wt <= maxWaitTimeInSecs; wt++) {
				if (DriverManager.getDriver().findElement(locator).isDisplayed()) {
					WebUI.sleep(1);

				}
				if (wt >= maxWaitTimeInSecs) {
					Assert.fail();
				}
			}

		} catch (Exception ex) {
			System.out.println("");
		}
	}
	

	/**
	 * Splits each string in the input list by a comma and returns a new list with
	 * all split elements.
	 *
	 * @param list The input list of strings to be split
	 * @return A new list containing the split elements
	 */
	public static List<String> splitListByComma(List<String> list) {
		List<String> splitList = new ArrayList<>();

		for (String item : list) {
			String[] splitItems = item.split(",");

			for (String splitItem : splitItems) {
				splitList.add(splitItem.trim()); // Trim to remove any extra spaces
			}
		}

		return splitList;
	}
}
