/*
 * Copyright (c) 2022
 * Automation Framework Selenium
 */

package com.codetru.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.Point;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import org.openqa.selenium.devtools.v127.network.model.Headers;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.codetru.constants.FrameworkConstants;
import com.codetru.driver.DriverManager;
import com.codetru.enums.FailureHandling;
import com.codetru.helpers.Helpers;
import com.codetru.report.AllureManager;
import com.codetru.report.ExtentReportManager;
import com.codetru.report.ExtentTestManager;
import com.codetru.utils.BrowserInfoUtils;
import com.codetru.utils.DateUtils;
import com.codetru.utils.LogUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.qameta.allure.Step;

/**
 * Keyword WebUI is a generic class that is a preprocessed library with many custom functions from Selenium and Java.
 * Returns is a Class containing Static functions. Callback is used by taking the class name and dotting the function name (WebUI.method)
 */
public class WebUI {

	/**
	 * The SoftAssert object is created
	 */
	private static SoftAssert softAssert = new SoftAssert();

	/**
	 * Stop the Soft Assert of TestNG
	 */
	public static void stopSoftAssertAll() {
		softAssert.assertAll();
	}

	/**
	 * Smart Waits contains waitForPageLoaded and sleep functions
	 */
	public static void smartWait() {
		if (FrameworkConstants.ACTIVE_PAGE_LOADED.trim().toLowerCase().equals("true")) {
			waitForPageLoaded();
		}
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);
	}

	/**
	 * Take entire-page screenshot and add to Extent report and Allure report
	 *
	 * @param screenName Screenshot name
	 */
	public static void addScreenshotToReport(String screenName) {
		if (FrameworkConstants.SCREENSHOT_ALL_STEPS.equals(FrameworkConstants.YES)) {
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.addScreenShot(Helpers.makeSlug(screenName));
			}
			//            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), Helpers.makeSlug(screenshotName));
			AllureManager.takeScreenshotStep();
		}
	}

	/**
	 * Take a screenshot of a specific web element. The captured image will be saved in '.png' format.
	 *
	 * @param screenName Screenshot name
	 */
	public static void takeElementScreenshot(By by, String screenName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		try {
			String path = Helpers.getCurrentDir() + FrameworkConstants.EXPORT_CAPTURE_PATH;
			File file = new File(path);
			if (!file.exists()) {
				LogUtils.info("No Folder: " + path);
				file.mkdir();
				LogUtils.info("Folder created: " + file);
			}

			File source = getWebElement(by).getScreenshotAs(OutputType.FILE);
			// result.getName() gets the name of the test case and assigns it to the screenshot file name
			FileUtils.copyFile(source, new File(path + "/" + screenName + "_" + dateFormat.format(new Date()) + ".png"));
			LogUtils.info("Screenshot taken: " + screenName);
			LogUtils.info("Screenshot taken current URL: " + getCurrentUrl());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}

	/**
	 * Take entire-page screenshot, including overflow parts. The captured image will be saved in '.png' format.
	 * This method simulates a scroll action to take a number of shots and merge them together to make a full-page screenshot.
	 *
	 * @param screenName Screenshot name
	 */
	public static void takeFullPageScreenshot(String screenName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		try {
			String path = Helpers.getCurrentDir() + FrameworkConstants.EXPORT_CAPTURE_PATH;
			File file = new File(path);
			if (!file.exists()) {
				LogUtils.info("No Folder: " + path);
				file.mkdir();
				LogUtils.info("Folder created: " + file);
			}

			LogUtils.info("Driver for Screenshot: " + DriverManager.getDriver());
			// Create reference of TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
			// Call the capture screenshot function - getScreenshotAs
			File source = ts.getScreenshotAs(OutputType.FILE);
			// result.getName() gets the name of the test case and assigns it to the screenshot file name
			FileUtils.copyFile(source, new File(path + "/" + screenName + "_" + dateFormat.format(new Date()) + ".png"));
			LogUtils.info("Screenshot taken: " + screenName);
			LogUtils.info("Screenshot taken current URL: " + getCurrentUrl());
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}


	/**
	 * Get the Download Directory path
	 *
	 * @return the download directory path
	 */
	public static String getPathDownloadDirectory() {
		String path = "";
		String machine_name = System.getProperty("user.home");
		path = machine_name + File.separator + "Downloads";
		return path;
	}

	/**
	 * Count files in Download Directory
	 *
	 * @return files total in download directory
	 */
	public static int countFilesInDownloadDirectory() {
		String pathFolderDownload = getPathDownloadDirectory();
		File file = new File(pathFolderDownload);
		int i = 0;
		for (File listOfFiles : file.listFiles()) {
			if (listOfFiles.isFile()) {
				i++;
			}
		}
		return i;
	}

	/**
	 * Verify files in the Download Directory contain the specified file (CONTAIN)
	 *
	 * @param fileName the specified file
	 * @return true if file is contain in download directory, else is false
	 */
	public static boolean verifyFileContainsInDownloadDirectory(String fileName) {
		boolean flag = false;
		try {
			String pathFolderDownload = getPathDownloadDirectory();
			File dir = new File(pathFolderDownload);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				flag = false;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().contains(fileName)) {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			e.getMessage();
			return flag;
		}
	}

	/**
	 * Verify files in the Download Directory contain the specified file (EQUALS)
	 *
	 * @param fileName the specified file
	 * @return true if file is contain in download directory, else is false
	 */
	public static boolean verifyFileEqualsInDownloadDirectory(String fileName) {
		boolean flag = false;
		try {
			String pathFolderDownload = getPathDownloadDirectory();
			File dir = new File(pathFolderDownload);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				flag = false;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().equals(fileName)) {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			e.getMessage();
			return flag;
		}
	}

	/**
	 * Verify the file is downloaded (CONTAIN)
	 *
	 * @param fileName       the specified file
	 * @param timeoutSeconds System will wait at most timeout (seconds) to return result
	 * @return true if file is downloaded, else is false
	 */
	public static boolean verifyDownloadFileContainsName(String fileName, int timeoutSeconds) {
		boolean check = false;
		int i = 0;
		while (i < timeoutSeconds) {
			boolean exist = verifyFileContainsInDownloadDirectory(fileName);
			if (exist == true) {
				i = timeoutSeconds;
				return check = true;
			}
			sleep(1);
			i++;
		}
		return check;
	}

	/**
	 * Verify the file is downloaded (EQUALS)
	 *
	 * @param fileName       the specified file
	 * @param timeoutSeconds System will wait at most timeout (seconds) to return result
	 * @return true if file is downloaded, else is false
	 */
	public static boolean verifyDownloadFileEqualsName(String fileName, int timeoutSeconds) {
		boolean check = false;
		int i = 0;
		while (i < timeoutSeconds) {
			boolean exist = verifyFileEqualsInDownloadDirectory(fileName);
			if (exist == true) {
				i = timeoutSeconds;
				return check = true;
			}
			sleep(1);
			i++;
		}
		return check;
	}

	/**
	 * Delete all files in Download Directory
	 */
	public static void deleteAllFileInDownloadDirectory() {
		try {
			String pathFolderDownload = getPathDownloadDirectory();
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Delete all files in Download Directory
	 *
	 * @param pathDirectory the Download Directory path
	 */
	public static void deleteAllFileInDirectory(String pathDirectory) {
		try {
			File file = new File(pathDirectory);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Verify the file is downloaded with JavascriptExecutor (EQUALS)
	 *
	 * @param fileName the specified file
	 * @return true if file is downloaded, else is false
	 */
	@Step("Verify File Downloaded With JS [Equals]: {0}")
	public static boolean verifyFileDownloadedWithJS_Equals(String fileName) {
		openWebsite("chrome://downloads");
		sleep(3);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		String element = (String) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#show').getAttribute('title')");
		File file = new File(element);
		LogUtils.info(element);
		LogUtils.info(file.getName());
		if (file.exists() && file.getName().trim().equals(fileName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verify the file is downloaded with JavascriptExecutor (CONTAINS)
	 *
	 * @param fileName the specified file
	 * @return true if file is downloaded, else is false
	 */
	@Step("Verify File Downloaded With JS [Contains]: {0}")
	public static boolean verifyFileDownloadedWithJS_Contains(String fileName) {
		openWebsite("chrome://downloads");
		sleep(3);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		String element = (String) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#show').getAttribute('title')");
		File file = new File(element);
		LogUtils.info(element);
		LogUtils.info(file.getName());
		if (file.exists() && file.getName().trim().contains(fileName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Login as Authentication on URL
	 *
	 * @param url
	 * @param username
	 * @param password
	 */
	@Step("Get to URL {0} with authentication")
	public static void getToUrlAuthentication(String url, String username, String password) {
		// Get the devtools from the running driver and create a session
		DevTools devTools = ((HasDevTools) DriverManager.getDriver()).getDevTools();
		devTools.createSession();

		// Enable the Network domain of devtools
		devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));
		String auth = username + ":" + password;

		// Encoding the username and password using Base64 (java.util)
		String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

		// Pass the network header -> Authorization : Basic <encoded String>
		Map<String, Object> headers = new HashMap<>();
		headers.put("Authorization", "Basic " + encodeToString);
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

		LogUtils.info("getToUrlAuthentication with URL: " + url);
		LogUtils.info("getToUrlAuthentication with Username: " + username);
		LogUtils.info("getToUrlAuthentication with Password: " + password);
		// Load the application url
		openWebsite(url);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
	}

	/**
	 * Get code text of QR Code image
	 *
	 * @param an element of object type By
	 * @return text of QR Code
	 */
	@Step("Get QR code from image {0}")
	public static String getQRCodeFromImage(By by) {
		String qrCodeURL = WebUI.getAttributeElement(by, "src");
		//Create an object of URL Class
		URL url = null;
		try {
			url = new URL(qrCodeURL);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		//Pass the URL class object to store the file as image
		BufferedImage bufferedimage = null;
		try {
			bufferedimage = ImageIO.read(url);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// Process the image
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		//To Capture details of QR code
		Result result = null;
		try {
			result = new MultiFormatReader().decode(binaryBitmap);
		} catch (com.google.zxing.NotFoundException e) {
			throw new RuntimeException(e);
		}
		return result.getText();
	}

	//Handle HTML5 validation message and valid value

	/**
	 * Verify HTML5 message of element required field
	 *
	 * @param by is an element of type By
	 * @return true/false corresponds to required
	 */
	@Step("Verify HTML5 message of element {0} required field")
	public static Boolean verifyHTML5RequiredField(By by) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		Boolean verifyRequired = (Boolean) js.executeScript("return arguments[0].required;", getWebElement(by));
		return verifyRequired;
	}

	/**
	 * Verify the HTML5 message of the element has a value of Valid
	 *
	 * @param by is an element of type By
	 * @return true/false corresponds to Valid
	 */
	@Step("Verify HTML5 message of element {0} valid")
	public static Boolean verifyHTML5ValidValueField(By by) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		Boolean verifyValid = (Boolean) js.executeScript("return arguments[0].validity.valid;", getWebElement(by));
		return verifyValid;
	}

	/**
	 * Get HTML5 message of element
	 *
	 * @param by is an element of type By
	 * @return the Text string value of the notification (String)
	 */
	@Step("Get HTML5 message of element {0}")
	public static String getHTML5MessageField(By by) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		String message = (String) js.executeScript("return arguments[0].validationMessage;", getWebElement(by));
		return message;
	}

	/**
	 * Set window sizes.
	 *
	 * @param widthPixel  is Width with Pixel
	 * @param heightPixel is Height with Pixel
	 */
	public static void setWindowSize(int widthPixel, int heightPixel) {
		DriverManager.getDriver().manage().window().setSize(new Dimension(widthPixel, heightPixel));
	}

	/**
	 * Move the window to the selected position X, Y from the top left corner 0
	 *
	 * @param X (int) - horizontal
	 * @param Y (int) - vertical
	 */
	public static void setWindowPosition(int X, int Y) {
		DriverManager.getDriver().manage().window().setPosition(new Point(X, Y));
	}

	/**
	 * Maximize window
	 */
	public static void maximizeWindow() {
		DriverManager.getDriver().manage().window().maximize();
	}

	/**
	 * Minimize window
	 */
	public static void minimizeWindow() {
		DriverManager.getDriver().manage().window().minimize();
	}

	/**
	 * Take a screenshot at the element location. Do not capture the entire screen.
	 *
	 * @param by          is an element of type By
	 * @param elementName to name the .png image file
	 */
	public static void screenshotElement(By by, String elementName) {
		File scrFile = getWebElement(by).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./" + elementName + ".png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Print the current page in the browser.
	 * Note: Only works in headless mode
	 *
	 * @param endPage is the total number of pages to print. Adjective 1.
	 * @return is content of page form PDF file
	 */
	public static String printPage(int endPage) {
		PrintOptions printOptions = new PrintOptions();
		//From page 1 to end page
		printOptions.setPageRanges("1-" + endPage);

		Pdf pdf = ((PrintsPage) DriverManager.getDriver()).print(printOptions);
		return pdf.getContent();
	}

	/**
	 * Get the JavascriptExecutor object created
	 *
	 * @return JavascriptExecutor
	 */
	public static JavascriptExecutor getJsExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		return js;
	}

	/**
	 * Convert the By object to the WebElement
	 *
	 * @param by is an element of type By
	 * @return Returns a WebElement object
	 */
	public static WebElement getWebElement(By by) {
		return DriverManager.getDriver().findElement(by);
	}

	/**
	 * Find multiple elements with the locator By object
	 *
	 * @param by is an element of type By
	 * @return Returns a List of WebElement objects
	 */
	public static List<WebElement> getWebElements(By by) {
		return DriverManager.getDriver().findElements(by);
	}

	/**
	 * Print out the message in the Console log
	 *
	 * @param object passes any object
	 */
	public static void logConsole(@Nullable Object object) {
		System.out.println(object);
	}

	/**
	 * Forced wait with unit of Seconds
	 *
	 * @param second is a positive integer corresponding to the number of Seconds
	 */
	public static void sleep(double second) {
		try {
			Thread.sleep((long) (second * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Allow browser popup notifications on the website
	 *
	 * @return the value set Allow - belongs to the ChromeOptions object
	 */
	@Step("Allow Notifications")
	public static ChromeOptions notificationsAllow() {
		// Create a Map to store options
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Add keys and values to Map as follows to disable browser notifications
		// Pass argument 1 to ALLOW and 2 to BLOCK
		prefs.put("profile.default_content_setting_values.notifications", 1);

		// Create a ChromeOptions session
		ChromeOptions options = new ChromeOptions();

		// Use the setExperimentalOption function to execute the value through the above prefs object
		options.setExperimentalOption("prefs", prefs);

		//Returns the set value of the ChromeOptions object
		return options;
	}

	/**
	 * Block browser popup notifications on the website
	 *
	 * @return the value of the setup Block - belongs to the ChromeOptions object
	 */
	@Step("Blocked Notifications")
	public static ChromeOptions notificationsBlock() {
		// Create a Map to store options
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Add keys and values to Map as follows to disable browser notifications
		// Pass argument 1 to ALLOW and 2 to BLOCK
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create a ChromeOptions session
		ChromeOptions options = new ChromeOptions();

		// Use the setExperimentalOption function to execute the value through the above prefs object
		options.setExperimentalOption("prefs", prefs);

		//Returns the set value of the ChromeOptions object
		return options;
	}

	/**
	 * Uploading files with a click shows a form to select local files on your computer
	 *
	 * @param by       is an element of type By
	 * @param filePath the absolute path to the file on your computer
	 */
	@Step("Upload File with open Local Form")
	public static void uploadFileWithLocalForm(By by, String filePath) {
		smartWait();

		Actions action = new Actions(DriverManager.getDriver());
		//Click to open form upload
		action.moveToElement(getWebElement(by)).click().perform();
		sleep(3);

		// Create Robot class
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Copy File path to Clipboard
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		//Check OS for Windows
		if (BrowserInfoUtils.isWindows()) {
			// Press Control+V to paste
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			// Release the Control V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(2000);
			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		//Check OS for MAC
		if (BrowserInfoUtils.isMac()) {
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);

			//Open goto MAC
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_G);

			//Paste the clipboard value
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);

			//Press Enter key to close the Goto MAC and Upload on MAC
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		LogUtils.info("Upload File with Local Form: " + filePath);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Upload File with Local Form: " + filePath);
		}
		AllureManager.saveTextLog("Upload File with Local Form: " + filePath);

	}

	/**
	 * Upload files by dragging the link directly into the input box
	 *
	 * @param by       passes an element of object type By
	 * @param filePath absolute path to the file
	 */
	@Step("Upload File with SendKeys")
	public static void uploadFileWithSendKeys(By by, String filePath) {
		smartWait();

		waitForElementVisible(by).sendKeys(filePath);

		LogUtils.info("Upload File with SendKeys");
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Upload File with SendKeys");
		}
		AllureManager.saveTextLog("Upload File with SendKeys");

	}

	/**
	 * Get current URL from current driver
	 *
	 * @return the current URL as String
	 */
	@Step("Get Current URL")
	public static String getCurrentUrl() {
		smartWait();
		LogUtils.info("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
		}
		AllureManager.saveTextLog("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
		return DriverManager.getDriver().getCurrentUrl();
	}

	/**
	 * Get current web page's title
	 *
	 * @return the current URL as String
	 */
	@Step("Get Page Title")
	public static String getPageTitle() {
		smartWait();
		String title = DriverManager.getDriver().getTitle();
		LogUtils.info("Get Page Title: " + DriverManager.getDriver().getTitle());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Get Page Title: " + DriverManager.getDriver().getTitle());
		}
		AllureManager.saveTextLog("Get Page Title: " + DriverManager.getDriver().getTitle());
		return title;
	}

	/**
	 * Verify the web page's title equals with the specified title
	 *
	 * @param pageTitle The title of the web page that needs verifying
	 * @return the current URL as String
	 */
	@Step("Verify Page Title equals {0}")
	public static boolean VerifyPageTitle(String pageTitle) {
		smartWait();
		return getPageTitle().equals(pageTitle);
	}


	/**
	 * Verify if the given text presents anywhere in the page source.
	 *
	 * @param text
	 * @return true/false
	 */
	@Step("Verify Page sources Contains Text {0}")
	public static boolean verifyPageContainsText(String text) {
		smartWait();
		return DriverManager.getDriver().getPageSource().contains(text);
	}

	/**
	 * Verify if the given web element is checked.
	 *
	 * @param by Represent a web element as the By object
	 * @return true if the element is checked, otherwise false.
	 */
	@Step("Verify Element Checked {0}")
	public static boolean verifyElementChecked(By by) {
		smartWait();

		boolean checked = getWebElement(by).isSelected();
		if (checked == true) {
			return true;
		} else {
			Assert.assertTrue(false, "The element NOT checked.");
			return false;
		}
	}

	/**
	 * Verify if the given web element is checked.
	 *
	 * @param by      Represent a web element as the By object
	 * @param message the custom message if false
	 * @return true if the element is checked, otherwise false.
	 */
	@Step("Verify Element Checked {0}")
	public static boolean verifyElementChecked(By by, String message) {
		smartWait();
		waitForElementVisible(by);

		boolean checked = getWebElement(by).isSelected();

		if (checked == true) {
			return true;
		} else {
			Assert.assertTrue(false, message);
			return false;
		}
	}

	//Handle dropdown

	/**
	 * Select value in dropdown dynamic (not pure Select Option)
	 *
	 * @param objectListItem is the locator of the list item as a By object
	 * @param text           the value to select as Text of the item
	 * @return click to select a specified item with Text value
	 */
	@Step("Select Option Dynamic by Text {0}")
	public static boolean selectOptionDynamic(By objectListItem, String text) {
		smartWait();
		//For dynamic dropdowns (div, li, span,...not select options)
		try {
			List<WebElement> elements = getWebElements(objectListItem);

			for (WebElement element : elements) {
				LogUtils.info(element.getText());
				if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
					element.click();
					return true;
				}
			}
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			e.getMessage();
		}
		return false;
	}

	/**
	 * Verify All Options contains the specified text (select option)
	 *
	 * @param by   Represent a web element as the By object
	 * @param text the specified text
	 * @return true if all option contains the specified text
	 */
	@Step("Verify Option Dynamic Exist by Text {0}")
	public static boolean verifyOptionDynamicExist(By by, String text) {
		smartWait();

		try {
			List<WebElement> elements = getWebElements(by);

			for (WebElement element : elements) {
				LogUtils.info(element.getText());
				if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
					return true;
				}
			}
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			e.getMessage();
		}
		return false;
	}

	/**
	 * Get total number of options the given web element has. (select option)
	 *
	 * @param objectListItem Represent a web element as the By object
	 * @return total number of options
	 */
	@Step("Get total of Option Dynamic with list element {0}")
	public static int getOptionDynamicTotal(By objectListItem) {
		smartWait();

		LogUtils.info("Get total of Option Dynamic with list element. " + objectListItem);
		try {
			List<WebElement> elements = getWebElements(objectListItem);
			return elements.size();
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			e.getMessage();
		}
		return 0;
	}

	/**
	 * Select the options with the given label (displayed text).
	 *
	 * @param by   Represent a web element as the By object
	 * @param text the specified text of option
	 */
	@Step("Select Option by Text {0}")
	public static void selectOptionByText(By by, String text) {
		smartWait();
		Select select = new Select(getWebElement(by));
		select.selectByVisibleText(text);
		LogUtils.info("Select Option " + by + "by text " + text);
	}

	/**
	 * Select the options with the given value.
	 *
	 * @param by    Represent a web element as the By object
	 * @param value the specified value of option
	 */
	@Step("Select Option by Value {0}")
	public static void selectOptionByValue(By by, String value) {
		smartWait();

		Select select = new Select(getWebElement(by));
		select.selectByValue(value);
		LogUtils.info("Select Option " + by + "by value " + value);
	}

	/**
	 * Select the options with the given index.
	 *
	 * @param by    Represent a web element as the By object
	 * @param index the specified index of option
	 */
	@Step("Select Option by Index {0}")
	public static void selectOptionByIndex(By by, int index) {
		smartWait();

		Select select = new Select(getWebElement(by));
		select.selectByIndex(index);
		LogUtils.info("Select Option " + by + "by index " + index);
	}

	/**
	 * Verify the number of options equals the specified total
	 *
	 * @param by    Represent a web element as the By object
	 * @param total the specified options total
	 */
	@Step("Verify Option Total equals {0}")
	public static void verifyOptionTotal(By by, int total) {
		smartWait();

		Select select = new Select(getWebElement(by));
		LogUtils.info("Verify Option Total equals: " + total);
		Assert.assertEquals(total, select.getOptions().size());
	}

	/**
	 * Verify if the options at the given text are selected.
	 *
	 * @param by   Represent a web element as the By object
	 * @param text the specified options text
	 * @return true if options given selected, else is false
	 */
	@Step("Verify Selected Option by Text {0}")
	public static boolean verifySelectedByText(By by, String text) {
		smartWait();

		Select select = new Select(getWebElement(by));
		LogUtils.info("Verify Option Selected by text: " + select.getFirstSelectedOption().getText());

		if (select.getFirstSelectedOption().getText().equals(text)) {
			return true;
		} else {
			Assert.assertEquals(select.getFirstSelectedOption().getText(), text, "The option NOT selected. " + by);
			return false;
		}
	}

	/**
	 * Verify if the options at the given value are selected.
	 *
	 * @param by    Represent a web element as the By object
	 * @param value the specified options value
	 * @return true if options given selected, else is false
	 */
	@Step("Verify Selected Option by Value {0}")
	public static boolean verifySelectedByValue(By by, String value) {
		smartWait();

		Select select = new Select(getWebElement(by));
		LogUtils.info("Verify Option Selected by value: " + select.getFirstSelectedOption().getAttribute("value"));
		if (select.getFirstSelectedOption().getAttribute("value").equals(value)) {
			return true;
		} else {
			Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), value, "The option NOT selected. " + by);
			return false;
		}
	}

	/**
	 * Verify if the options at the given index are selected.
	 *
	 * @param by    Represent a web element as the By object
	 * @param index the specified options index
	 * @return true if options given selected, else is false
	 */
	@Step("Verify Selected Option by Index {0}")
	public static boolean verifySelectedByIndex(By by, int index) {
		smartWait();

		Select select = new Select(getWebElement(by));
		int indexFirstOption = select.getOptions().indexOf(select.getFirstSelectedOption());
		LogUtils.info("The First Option selected by index: " + indexFirstOption);
		LogUtils.info("Expected index: " + index);
		if (indexFirstOption == index) {
			return true;
		} else {
			Assert.assertTrue(false, "The option NOT selected. " + by);
			return false;
		}
	}

	/**
	 * Switch to iframe by index of iframe tag
	 *
	 * @param index index of iframe tag
	 */
	@Step("Switch to Frame by Index: {0}")
	public static void switchToFrameByIndex(int index) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		//DriverManager.getDriver().switchTo().frame(Index);
		LogUtils.info("Switch to Frame by Index. " + index);
	}

	/**
	 * Switch to iframe by ID or Name of iframe tag
	 *
	 * @param IdOrName ID or Name of iframe tag
	 */
	@Step("Switch to Frame by ID or Name: {0}")
	public static void switchToFrameByIdOrName(String IdOrName) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));
		LogUtils.info("Switch to Frame by ID or Name. " + IdOrName);
	}

	/**
	 * Switch to iframe by Element is this iframe tag
	 *
	 * @param by iframe tag
	 */
	@Step("Switch to Frame by Element {0}")
	public static void switchToFrameByElement(By by) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		LogUtils.info("Switch to Frame by Element. " + by);
	}

	/**
	 * Switch to Default Content
	 */
	@Step("Switch to Default Content")
	public static void switchToDefaultContent() {
		smartWait();

		DriverManager.getDriver().switchTo().defaultContent();
		LogUtils.info("Switch to Default Content");
	}

	/**
	 * Switch to iframe by position of iframe tag
	 *
	 * @param position index of iframe tag
	 */
	@Step("Switch to Window or Tab by Position: {0}")
	public static void switchToWindowOrTabByPosition(int position) {
		smartWait();

		DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[position].toString());
		LogUtils.info("Switch to Window or Tab by Position: " + position);
	}

	/**
	 * Switch to popup window by title
	 *
	 * @param title title of popup window
	 */
	@Step("Switch to Window or Tab by Title: {0}")
	public static void switchToWindowOrTabByTitle(String title) {
		smartWait();

		//Store the ID of the original window
		String originalWindow = DriverManager.getDriver().getWindowHandle();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		//Wait for the new window or tab
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		//Loop through until we find a new window handle
		for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				DriverManager.getDriver().switchTo().window(windowHandle);
				if (DriverManager.getDriver().getTitle().equals(title)) {
					break;
				}
			}
		}

	}

	/**
	 * Switch to popup window by URL
	 *
	 * @param url url of popup window
	 */
	@Step("Switch to Window or Tab by Url: {0}")
	public static void switchToWindowOrTabByUrl(String url) {
		smartWait();
		//Store the ID of the original window
		String originalWindow = DriverManager.getDriver().getWindowHandle();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		//Wait for the new window or tab
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		//Loop through until we find a new window handle
		for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				DriverManager.getDriver().switchTo().window(windowHandle);
				if (DriverManager.getDriver().getCurrentUrl().equals(url)) {
					break;
				}
			}
		}

	}

	/**
	 * Close current Window
	 */
	@Step("Close current Window")
	public static void closeCurrentWindow() {
		LogUtils.info("Close current Window." + getCurrentUrl());
		DriverManager.getDriver().close();
		LogUtils.info("Close current Window");
	}


	/**
	 * Get the total number of popup windows the given web page.
	 *
	 * @param number the specified number
	 * @return true/false
	 */
	@Step("Verify total of Windows or Tab")
	public static boolean verifyTotalOfWindowsOrTab(int number) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT)).until(ExpectedConditions.numberOfWindowsToBe(number));
	}

	/**
	 * Open new Tab
	 */
	@Step("Open new Tab")
	public static void openNewTab() {
		smartWait();
		// Opens a new tab and switches to new tab
		DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
		LogUtils.info("Open new Tab");
	}

	/**
	 * Open new Window
	 */
	@Step("Open new Window")
	public static void openNewWindow() {
		smartWait();
		// Opens a new window and switches to new window
		DriverManager.getDriver().switchTo().newWindow(WindowType.WINDOW);
		LogUtils.info("Open new Window");
	}

	/**
	 * Switch to Main Window
	 */
	@Step("Switch to Main Window")
	public static void switchToMainWindow() {
		smartWait();
		DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[0].toString());
		LogUtils.info("Switch to Main Window." + DriverManager.getDriver());
	}

	/**
	 * Switch to Main Window by ID
	 *
	 * @param originalWindow ID of main window
	 */
	@Step("Switch to Main Window by ID {0}")
	public static void switchToMainWindow(String originalWindow) {
		smartWait();
		DriverManager.getDriver().switchTo().window(originalWindow);
		LogUtils.info("Switch to Main Window." + originalWindow);
	}

	/**
	 * Switch to Last Window
	 */
	@Step("Switch to Last Window")
	public static void switchToLastWindow() {
		smartWait();
		Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
		WebDriver newDriver = DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[windowHandles.size() - 1].toString());
		LogUtils.info("Switch to Last Window." + newDriver.getCurrentUrl());
	}

	/**
	 * Click Accept on Alert
	 */
	@Step("Click Accept on Alert")
	public static void acceptAlert() {
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);
		DriverManager.getDriver().switchTo().alert().accept();
		LogUtils.info("Click Accept on Alert.");
	}

	/**
	 * Click Dismiss on Alert
	 */
	@Step("Click Dismiss on Alert")
	public static void dismissAlert() {
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);
		DriverManager.getDriver().switchTo().alert().dismiss();
		LogUtils.info("Click Dismiss on Alert.");
	}

	/**
	 * Get text on Alert
	 */
	@Step("Get text on Alert")
	public static String getTextAlert() {
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);
		LogUtils.info("Get text ion alert: " + DriverManager.getDriver().switchTo().alert().getText());
		return DriverManager.getDriver().switchTo().alert().getText();
	}

	/**
	 * Set text on Alert
	 */
	@Step("Set text on Alert {0}")
	public static void setTextAlert(String text) {
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);
		DriverManager.getDriver().switchTo().alert().sendKeys(text);
		LogUtils.info("Set " + text + " on Alert.");
	}

	/**
	 * Verify if alert does present
	 *
	 * @param timeOut Timeout waiting for alert to present.(in seconds)
	 * @return true/false
	 */
	@Step("Verify Alert present with timeout {0}")
	public static boolean verifyAlertPresent(int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Throwable error) {
			LogUtils.error("Alert NOT Present.");
			Assert.fail("Alert NOT Present.");
			return false;
		}
	}

	/**
	 * Get list text of specified elements
	 *
	 * @param by Represent a web element as the By object
	 * @return Text list of specified elements
	 */
	@Step("Get List Element {0}")
	public static List<String> getListElementsText(By by) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		List<WebElement> listElement = getWebElements(by);
		List<String> listText = new ArrayList<>();

		for (WebElement e : listElement) {
			listText.add(e.getText());
		}

		return listText;
	}

	/**
	 * Verify if a web element is present (findElements.size > 0).
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element exists {0}")
	public static boolean verifyElementExists(By by) {
		smartWait();

		boolean res;
		List<WebElement> elementList = getWebElements(by);
		if (elementList.size() > 0) {
			res = true;
			LogUtils.info("Element existing");
		} else {
			res = false;
			LogUtils.error("Element not exists");

		}
		return res;
	}


	/**
	 * Verify if two object are equal.
	 *
	 * @param value1 The object one
	 * @param value2 The object two
	 * @return true/false
	 */
	@Step("Verify Equals: {0} ---AND--- {1}")
	public static boolean verifyEquals(Object value1, Object value2) {
		boolean result = value1.equals(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " = " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Equals: " + value1 + " = " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " = " + value2);
		} else {
			LogUtils.info("Verify Equals: " + value1 + " != " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Equals: " + value1 + " != " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " != " + value2);
			Assert.assertEquals(value1, value2, value1 + " != " + value2);
		}
		return result;
	}

	/**
	 * Verify if two object are equal.
	 *
	 * @param value1  The object one
	 * @param value2  The object two
	 * @param message The custom message if false
	 * @return true/false
	 */
	@Step("Verify Equals: {0} ---AND--- {1}")
	public static boolean verifyEquals(Object value1, Object value2, String message) {
		boolean result = value1.equals(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " = " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Equals: " + value1 + " = " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " = " + value2);
		} else {
			LogUtils.info("Verify Equals: " + value1 + " != " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Equals: " + value1 + " != " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " != " + value2);
			Assert.assertEquals(value1, value2, message);
		}
		return result;
	}

	/**
	 * Verify if the first object contains the second object.
	 *
	 * @param value1 The first object
	 * @param value2 The second object
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyContains(String value1, String value2) {
		SoftAssert softAssert = new SoftAssert();
		boolean result = value1.contains(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
				ExtentReportManager.addScreenShot(Status.FAIL, "");
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);


			//            Assert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);
			softAssert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);

		}
		return result;
	}

	public static boolean verifyElementNotVisibleSoftAssert(By by) {
		smartWait();
		SoftAssert softAssert = new SoftAssert();
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			LogUtils.error("FAILED. The element is visible " + by);
			ExtentReportManager.fail("FAILED. The element is visible " + by);
			ExtentReportManager.addScreenShot(Status.FAIL, "");

			//            Assert.fail("FAILED. The element is visible " + by);
			softAssert.fail("FAILED. The element is visible " + by);
			return false;
		}
	}

	/**
	 * Verify if the first object contains the second object.
	 *
	 * @param value1  The first object
	 * @param value2  The second object
	 * @param message The custom message if false
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyContains(String value1, String value2, String message) {
		boolean result = value1.contains(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);

			Assert.assertEquals(value1, value2, message);
		}
		return result;
	}

	/**
	 * Verify the condition is true.
	 *
	 * @return true/false
	 */
	@Step("Verify TRUE with condition: {0}")
	public static boolean verifyTrue(Boolean condition) {
		if (condition == true) {
			LogUtils.info("Verify TRUE: " + condition);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify TRUE: " + condition);
			}
			AllureManager.saveTextLog("Verify TRUE: " + condition);
		} else {
			LogUtils.info("Verify TRUE: " + condition);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify TRUE: " + condition);
			}
			AllureManager.saveTextLog("Verify TRUE: " + condition);

			Assert.assertTrue(condition, "The condition is FALSE.");
		}
		return condition;
	}

	/**
	 * Verify the condition is true.
	 *
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify TRUE with condition: {0}")
	public static boolean verifyTrue(Boolean condition, String message) {
		if (condition == true) {
			LogUtils.info("Verify TRUE: " + condition);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify TRUE: " + condition);
			}
			AllureManager.saveTextLog("Verify TRUE: " + condition);
		} else {
			LogUtils.info("Verify TRUE: " + condition);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify TRUE: " + condition);
			}
			AllureManager.saveTextLog("Verify TRUE: " + condition);

			Assert.assertTrue(condition, message);
		}
		return condition;
	}


	/**
	 * Verify text of an element. (equals)
	 *
	 * @param by   Represent a web element as the By object
	 * @param text Text of the element to verify.
	 * @return true if the element has the desired text, otherwise false.
	 */
	public static boolean verifyElementText(By by, String text) {
		smartWait();
		waitForElementVisible(by);

		return getTextElement(by).trim().equals(text.trim());
	}

	/**
	 * Verify text of an element. (equals)
	 *
	 * @param by          Represent a web element as the By object
	 * @param text        Text of the element to verify.
	 * @param flowControl Specify failure handling schema (STOP_ON_FAILURE, CONTINUE_ON_FAILURE, OPTIONAL) to determine whether the execution should be allowed to continue or stop
	 * @return true if the element has the desired text, otherwise false.
	 */
	@Step("Verify text of an element [Equals]")
	public static boolean verifyElementTextEquals(By by, String text, FailureHandling flowControl) {
		smartWait();

		waitForElementVisible(by);

		boolean result = getTextElement(by).trim().equals(text.trim());

		if (result == true) {
			LogUtils.info("Verify text of an element [Equals]: " + result);
		} else {
			LogUtils.warn("Verify text of an element [Equals]: " + result);
		}

		if (flowControl.equals(FailureHandling.STOP_ON_FAILURE)) {
			Assert.assertEquals(getTextElement(by).trim(), text.trim(), "The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
		}
		if (flowControl.equals(FailureHandling.CONTINUE_ON_FAILURE)) {
			softAssert.assertEquals(getTextElement(by).trim(), text.trim(), "The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
			if (result == false) {
				ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
			}
		}
		if (flowControl.equals(FailureHandling.OPTIONAL)) {
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.warning("Verify text of an element [Equals] - " + result);
				ExtentReportManager.warning("The actual text is '" + getTextElement(by).trim() + "' not equals expected text '" + text.trim() + "'");
			}
			AllureManager.saveTextLog("Verify text of an element [Equals] - " + result + ". The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
		}

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return getTextElement(by).trim().equals(text.trim());
	}

	/**
	 * Verify text of an element. (equals)
	 *
	 * @param by   Represent a web element as the By object
	 * @param text Text of the element to verify.
	 * @return true if the element has the desired text, otherwise false.
	 */
	@Step("Verify text of an element [Equals]")
	public static boolean verifyElementTextEquals(By by, String text) {
		smartWait();
		waitForElementVisible(by);

		boolean result = getTextElement(by).trim().equals(text.trim());

		if (result == true) {
			LogUtils.info("Verify text of an element [Equals]: " + result);
		} else {
			LogUtils.warn("Verify text of an element [Equals]: " + result);
		}

		Assert.assertEquals(getTextElement(by).trim(), text.trim(), "The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.warning("Verify text of an element [Equals] : " + result);
			ExtentReportManager.warning("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
		}
		AllureManager.saveTextLog("Verify text of an element [Equals] : " + result + ". The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return result;
	}

	/**
	 * Verify text of an element. (contains)
	 *
	 * @param by          Represent a web element as the By object
	 * @param text        Text of the element to verify.
	 * @param flowControl Specify failure handling schema (STOP_ON_FAILURE, CONTINUE_ON_FAILURE, OPTIONAL) to determine whether the execution should be allowed to continue or stop
	 * @return true if the element has the desired text, otherwise false.
	 */
	@Step("Verify text of an element [Contains]")
	public static boolean verifyElementTextContains(By by, String text, FailureHandling flowControl) {
		smartWait();
		waitForElementVisible(by);

		boolean result = getTextElement(by).trim().contains(text.trim());

		if (result == true) {
			LogUtils.info("Verify text of an element [Contains]: " + result);
		} else {
			LogUtils.warn("Verify text of an element [Contains]: " + result);
		}

		if (flowControl.equals(FailureHandling.STOP_ON_FAILURE)) {
			Assert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " not contains " + text.trim());
		}
		if (flowControl.equals(FailureHandling.CONTINUE_ON_FAILURE)) {
			softAssert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " not contains " + text.trim());
		}
		if (flowControl.equals(FailureHandling.OPTIONAL)) {
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.warning("Verify text of an element [Contains] - " + result);
			}
			AllureManager.saveTextLog("Verify text of an element [Contains] - " + result);
		}

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return getTextElement(by).trim().contains(text.trim());
	}

	/**
	 * Verify text of an element. (contains)
	 *
	 * @param by   Represent a web element as the By object
	 * @param text Text of the element to verify.
	 * @return true if the element has the desired text, otherwise false.
	 */
	@Step("Verify text {1} of element [Contains] {0}")
	public static boolean verifyElementTextContains(By by, String text) {
		smartWait();
		waitForElementVisible(by);

		boolean result = getTextElement(by).trim().contains(text.trim());

		if (result == true) {
			LogUtils.info("Verify text of an element [Contains]: " + result);
		} else {
			LogUtils.warn("Verify text of an element [Contains]: " + result);
		}

		Assert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " not contains " + text.trim());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Verify text of an element [Contains] : " + result);
		}
		AllureManager.saveTextLog("Verify text of an element [Contains] : " + result);

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return result;
	}

	/**
	 * Verify if the given element is clickable.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element Clickable {0}")
	public static boolean verifyElementClickable(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			LogUtils.info("Verify element clickable " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element clickable " + by);
			}
			AllureManager.saveTextLog("Verify element clickable " + by);
			return true;
		} catch (Exception e) {
			LogUtils.error(e.getMessage());
			Assert.fail("FAILED. Element not clickable " + by);
			return false;
		}
	}

	/**
	 * Verify if the given element is clickable. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element Clickable {0} with timeout {1} second")
	public static boolean verifyElementClickable(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			LogUtils.info("Verify element clickable " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element clickable " + by);
			}
			AllureManager.saveTextLog("Verify element clickable " + by);
			return true;
		} catch (Exception e) {
			LogUtils.error("FAILED. Element not clickable " + by);
			LogUtils.error(e.getMessage());
			Assert.fail("FAILED. Element not clickable " + by);
			return false;
		}
	}

	/**
	 * Verify if the given element is clickable. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element Clickable {0}")
	public static boolean verifyElementClickable(By by, int timeout, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			LogUtils.info("Verify element clickable " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element clickable " + by);
			}
			AllureManager.saveTextLog("Verify element clickable " + by);
			return true;
		} catch (Exception e) {
			LogUtils.error(message);
			LogUtils.error(e.getMessage());
			Assert.fail(message + "" + e.getMessage());
			return false;
		}
	}

	/**
	 * Verify if the given web element does present on DOM.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element present {0}")
	public static boolean verifyElementPresent(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.info("Verify element present " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element present " + by);
			}
			AllureManager.saveTextLog("Verify element present " + by);
			addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
			return true;
		} catch (Exception e) {
			LogUtils.info("The element does NOT present. " + e.getMessage());
			Assert.fail("The element does NOT present. " + e.getMessage());
			return false;
		}
	}

	/**
	 * Verify if the given web element does present on DOM. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element present {0} with timeout {1} second")
	public static boolean verifyElementPresent(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.info("Verify element present " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element present " + by);
			}
			AllureManager.saveTextLog("Verify element present " + by);
			addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
			return true;
		} catch (Exception e) {
			LogUtils.info("The element does NOT present. " + e.getMessage());
			Assert.fail("The element does NOT present. " + e.getMessage());
			return false;
		}
	}

	/**
	 * Verify if the given web element does present on DOM.
	 *
	 * @param by      Represent a web element as the By object
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element present {0}")
	public static boolean verifyElementPresent(By by, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.info("Verify element present " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element present " + by);
			}
			AllureManager.saveTextLog("Verify element present " + by);
			addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element does NOT present. " + e.getMessage());
				Assert.fail("The element does NOT present. " + e.getMessage());
			} else {
				LogUtils.error(message);
				Assert.fail(message);
			}

			return false;
		}
	}

	/**
	 * Verify if the given web element does present on DOM. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element present {0} with timeout {1} second")
	public static boolean verifyElementPresent(By by, int timeout, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.info("Verify element present " + by);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element present " + by);
			}
			AllureManager.saveTextLog("Verify element present " + by);
			addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element does NOT present. " + e.getMessage());
				Assert.fail("The element does NOT present. " + e.getMessage());
			} else {
				LogUtils.error(message);
				Assert.fail(message);
			}

			return false;
		}
	}

	/**
	 * Verify if the given web element does NOT present on the DOM.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element NOT present {0}")
	public static boolean verifyElementNotPresent(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.error("The element presents. " + by);
			Assert.fail("The element presents. " + by);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * Verify if the given web element does NOT present on the DOM. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element NOT present {0} with timeout {1} second")
	public static boolean verifyElementNotPresent(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			LogUtils.error("Element is present " + by);
			Assert.fail("The element presents. " + by);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * Verify if the given web element does NOT present on the DOM.
	 *
	 * @param by      Represent a web element as the By object
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element NOT present {0}")
	public static boolean verifyElementNotPresent(By by, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element presents. " + by);
				Assert.fail("The element presents. " + by);
			} else {
				LogUtils.error(message);
				Assert.fail(message + " " + by);
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * Verify if the given web element does NOT present on the DOM. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element NOT present {0} with timeout {1} second")
	public static boolean verifyElementNotPresent(By by, int timeout, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element presents. " + by);
				Assert.fail("The element presents. " + by);
			} else {
				LogUtils.error(message + by);
				Assert.fail(message + by);
			}
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * Verify element is visible. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element visible {0}")
	public static boolean isElementVisible(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogUtils.info("Verify element visible " + by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Verify if the given web element is visible.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element visible {0}")
	public static boolean verifyElementVisible(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogUtils.info("Verify element visible " + by);
			return true;
		} catch (Exception e) {
			Assert.fail("The element is NOT visible. " + by);
			return false;
		}
	}

	/**
	 * Verify if the given web element is visible. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element visible {0} with timeout {1} second")
	public static boolean verifyElementVisible(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogUtils.info("Verify element visible " + by);
			return true;
		} catch (Exception e) {
			LogUtils.error("The element is not visible. " + e.getMessage());
			Assert.fail("The element is NOT visible. " + by);
			return false;
		}
	}

	/**
	 * Verify if the given web element is visible.
	 *
	 * @param by      Represent a web element as the By object
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element visible {0}")
	public static boolean verifyElementVisible(By by, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogUtils.info("Verify element visible " + by);
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element is not visible. " + by);
				Assert.fail("The element is NOT visible. " + by);
			} else {
				LogUtils.error(message + by);
				Assert.fail(message + by);
			}
			return false;
		}
	}

	/**
	 * Verify if the given web element is visible. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element visible {0} with timeout {1} second")
	public static boolean verifyElementVisible(By by, int timeout, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogUtils.info("Verify element visible " + by);
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("The element is not visible. " + by);
				Assert.fail("The element is NOT visible. " + by);
			} else {
				LogUtils.error(message + by);
				Assert.fail(message + by);
			}
			return false;
		}
	}


	/**
	 * Verify if the given web element is NOT visible.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Verify element NOT visible {0}")
	public static boolean verifyElementNotVisible(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			LogUtils.error("FAILED. The element is visible " + by);
			Assert.fail("FAILED. The element is visible " + by);
			return false;
		}
	}

	/**
	 * Verify if the given web element is NOT visible. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element NOT visible {0} with timeout {1} second")
	public static boolean verifyElementNotVisible(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			LogUtils.error("FAILED. The element is visible " + by);
			Assert.fail("FAILED. The element is visible " + by);
			return false;
		}
	}

	/**
	 * Verify if the given web element is NOT visible.
	 *
	 * @param by      Represent a web element as the By object
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element NOT visible {0}")
	public static boolean verifyElementNotVisible(By by, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("FAILED. The element is visible " + by);
				Assert.fail("FAILED. The element is visible " + by);
			} else {
				LogUtils.error(message + " " + by);
				Assert.fail(message + " " + by);
			}
			return false;
		}
	}

	/**
	 * Verify if the given web element is NOT visible. (in seconds)
	 *
	 * @param by      Represent a web element as the By object
	 * @param timeout System will wait at most timeout (seconds) to return result
	 * @param message the custom message if false
	 * @return true/false
	 */
	@Step("Verify element NOT visible {0} with timeout {1} second")
	public static boolean verifyElementNotVisible(By by, int timeout, String message) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			if (message.isEmpty() || message == null) {
				LogUtils.error("FAILED. The element is visible " + by);
				Assert.fail("FAILED. The element is visible " + by);
			} else {
				LogUtils.error(message + " " + by);
				Assert.fail(message + " " + by);
			}
			return false;
		}
	}


	/**
	 * Scroll an element into the visible area of the browser window. (at TOP)
	 *
	 * @param by Represent a web element as the By object
	 */
	@Step("Scroll to element {0}")
	public static void scrollToElementAtTop(By by) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
		LogUtils.info("Scroll to element " + by);
	}

	/**
	 * Scroll an element into the visible area of the browser window. (at BOTTOM)
	 *
	 * @param by Represent a web element as the By object
	 */
	@Step("Scroll to element {0}")
	public static void scrollToElementAtBottom(By by) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
		LogUtils.info("Scroll to element " + by);
	}

	/**
	 * Scroll an element into the visible area of the browser window. (at TOP)
	 *
	 * @param webElement Represent a web element as the By object
	 */
	@Step("Scroll to element {0}")
	public static void scrollToElementAtTop(WebElement webElement) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		LogUtils.info("Scroll to element " + webElement);
	}

	/**
	 * Scroll an element into the visible area of the browser window. (at BOTTOM)
	 *
	 * @param webElement Represent a web element as the By object
	 */
	@Step("Scroll to element {0}")
	public static void scrollToElementAtBottom(WebElement webElement) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", webElement);
		LogUtils.info("Scroll to element " + webElement);
	}

	/**
	 * Scroll to an offset location
	 *
	 * @param X x offset
	 * @param Y y offset
	 */
	@Step("Scroll to position X={0}, Y={1}")
	public static void scrollToPosition(int X, int Y) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(" + X + "," + Y + ");");
		LogUtils.info("Scroll to position X = " + X + " ; Y = " + Y);
	}

	/**
	 * Simulate users hovering a mouse over the given element.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Hover on element {0}")
	public static boolean hoverOnElement(By by) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(getWebElement(by)).perform();
			LogUtils.info("Hover on element " + by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Simulate users hovering a mouse over the given element.
	 *
	 * @param by Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Mouse hover on element {0}")
	public static boolean mouseHover(By by) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(getWebElement(by)).perform();
			LogUtils.info("Mouse hover on element " + by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Drag and drop an element onto another element.
	 *
	 * @param fromElement represent the drag-able element
	 * @param toElement   represent the drop-able element
	 * @return true/false
	 */
	@Step("Drag from element {0} to element {1}")
	public static boolean dragAndDrop(By fromElement, By toElement) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
			//action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}
	@Step("Move from element {0} by offset x: {1}, y: {2} using Robot")
	public static boolean moveByOffsetWithRobotAndClick(By element, int xOffset, int yOffset) {
		smartWait();


		try {
			WebElement webElement = getWebElement(element);
			Point point = webElement.getLocation();
			int startX = point.getX();
			int startY = point.getY();

			Robot robot = new Robot();
			// Move to the element's position
			robot.mouseMove(startX, startY);

			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			// Move by the specified offset
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseMove(startX + xOffset, startY + yOffset);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}


	/**
	 * Drag and drop an element onto another element. (HTML5)
	 *
	 * @param fromElement represent the drag-able element
	 * @param toElement   represent the drop-able element
	 * @return true/false
	 */
	@Step("Drag HTML5 from element {0} to element {1}")
	public static boolean dragAndDropHTML5(By fromElement, By toElement) {
		smartWait();

		try {
			Robot robot = new Robot();
			robot.mouseMove(0, 0);

			int X1 = getWebElement(fromElement).getLocation().getX() + (getWebElement(fromElement).getSize().getWidth() / 2);
			int Y1 = getWebElement(fromElement).getLocation().getY() + (getWebElement(fromElement).getSize().getHeight() / 2);
			System.out.println(X1 + " , " + Y1);

			int X2 = getWebElement(toElement).getLocation().getX() + (getWebElement(toElement).getSize().getWidth() / 2);
			int Y2 = getWebElement(toElement).getLocation().getY() + (getWebElement(toElement).getSize().getHeight() / 2);
			System.out.println(X2 + " , " + Y2);

			//This place takes the current coordinates plus 120px which is the browser header (1920x1080 current window)
			//Header: chrome is being controlled by automated test software
			sleep(1);
			robot.mouseMove(X1, Y1 + 120);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

			sleep(1);
			robot.mouseMove(X2, Y2 + 120);
			sleep(1);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	/**
	 * Drag an object and drop it to an offset location.
	 *
	 * @param fromElement represent the drag-able element
	 * @param X           x offset
	 * @param Y           y offset
	 * @return true/false
	 */
	@Step("Drag from element {0} to X={1}, Y={2}")
	public static boolean dragAndDropToOffset(By fromElement, int X, int Y) {
		smartWait();

		try {
			Robot robot = new Robot();
			robot.mouseMove(0, 0);
			int X1 = getWebElement(fromElement).getLocation().getX() + (getWebElement(fromElement).getSize().getWidth() / 2);
			int Y1 = getWebElement(fromElement).getLocation().getY() + (getWebElement(fromElement).getSize().getHeight() / 2);
			System.out.println(X1 + " , " + Y1);
			sleep(1);

			//This place takes the current coordinates plus 120px which is the browser header (1920x1080 current window)
			//Header: chrome is being controlled by automated test software
			robot.mouseMove(X1, Y1 + 120);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

			sleep(1);
			robot.mouseMove(X, Y + 120);
			sleep(1);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	/**
	 * Move to the given element.
	 *
	 * @param toElement Represent a web element as the By object
	 * @return true/false
	 */
	@Step("Move to element {0}")
	public static boolean moveToElement(By toElement) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	/**
	 * Move to an offset location.
	 *
	 * @param X x offset
	 * @param Y y offset
	 * @return true/false
	 */
	@Step("Move to offset X={0}, Y={1}")
	public static boolean moveToOffset(int X, int Y) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveByOffset(X, Y).build().perform();
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	/**
	 * Reload the current web page.
	 */
	@Step("Reload page")
	public static void reloadPage() {
		smartWait();

		DriverManager.getDriver().navigate().refresh();
		waitForPageLoaded();
		LogUtils.info("Reloaded page " + DriverManager.getDriver().getCurrentUrl());
	}


	/**
	 * Fills the border color of the specified element.
	 *
	 * @param by passes the element object in the form By
	 * @return Colors red borders for Elements on the website
	 */
	@Step("Highlight on element")
	public static WebElement highLightElement(By by) {
		smartWait();

		// draw a border around the found element
		if (DriverManager.getDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", waitForElementVisible(by));
			sleep(1);
			LogUtils.info("Highlight on element " + by);
		}
		return getWebElement(by);
	}

	/**
	 * Navigate to the specified URL.
	 *
	 * @param URL the specified url
	 */
	@Step("Open website with URL {0}")
	public static void openWebsite(String URL) {
		sleep(FrameworkConstants.WAIT_SLEEP_STEP);

		DriverManager.getDriver().get(URL);
		waitForPageLoaded();

		LogUtils.info("Open website with URL: " + URL);

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Open website with URL: " + URL);
		}
		AllureManager.saveTextLog("Open website with URL: " + URL);

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Navigate to the specified web page.
	 *
	 * @param URL the specified url
	 */
	@Step("Navigate to URL {0}")
	public static void navigateToUrl(String URL) {
		DriverManager.getDriver().navigate().to(URL);
		waitForPageLoaded();

		LogUtils.info("Navigate to URL: " + URL);

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Navigate to URL: " + URL);
		}
		AllureManager.saveTextLog("Navigate to URL: " + URL);

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Set the value of an input field
	 *
	 * @param by    an element of object type By
	 * @param value the value to fill in the text box
	 */
	@Step("Set text on text box")
	public static void setText(By by, String value) {
		waitForElementVisible(by).sendKeys(value);
		LogUtils.info("Set text " + value + " on " + by.toString());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Set text " + value + " on " + by.toString());
		}
		AllureManager.saveTextLog("Set text " + value + " on " + by.toString());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}
	@Step("Set text using JavaScript on text box")
	public static void setTextWithJS(By by, String value) {
		WebElement element = waitForElementVisible(by); // Ensure the element is visible

		// Use JavaScript to set the value
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].value = arguments[1];", element, value);

		LogUtils.info("Set text " + value + " on " + by.toString());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Set text " + value + " on " + by.toString());
		}
		AllureManager.saveTextLog("Set text " + value + " on " + by.toString());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}
	/**
	 * Set the value of an input field and press the key on the keyboard
	 *
	 * @param by    an element of object type By
	 * @param value the value to fill in the text box
	 * @param keys  key on the keyboard to press
	 */
	@Step("Set text on text box and press key")
	public static void setText(By by, String value, Keys keys) {
		waitForElementVisible(by).sendKeys(value, keys);
		LogUtils.info("Set text " + value + " on " + by + " and press key " + keys.name());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Set text " + value + " on " + by + " and press key " + keys.name());
		}
		AllureManager.saveTextLog("Set text " + value + " on " + by + " and press key " + keys.name());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Simulates keystroke events on the specified element, as though you typed the value key-by-key.
	 *
	 * @param by   an element of object type By
	 * @param keys key on the keyboard to press
	 */
	@Step("Set text on text box and press key")
	public static void sendKeys(By by, Keys keys) {
		waitForElementVisible(by).sendKeys(keys);
		LogUtils.info("Press key " + keys.name() + " on element " + by);

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Press key " + keys.name() + " on element " + by);
		}
		AllureManager.saveTextLog("Press key " + keys.name() + " on element " + by);

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}

	/**
	 * Simulates keystroke events at the current position, as though you typed the value key-by-key.
	 *
	 * @param keys key on the keyboard to press
	 */
	@Step("Set text on text box and press key")
	public static void sendKeys(Keys keys) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.sendKeys(keys);
		LogUtils.info("Press key " + keys.name() + " on keyboard");

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Press key " + keys.name() + " on keyboard");
		}
		AllureManager.saveTextLog("Press key " + keys.name() + " on keyboard");

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}

	/**
	 * Clear all text of the element.
	 *
	 * @param by an element of object type By
	 */
	@Step("Clear value in text box")
	public static void clearText(By by) {
		waitForElementVisible(by).clear();
		LogUtils.info("Clear text in textbox " + by.toString());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clear text in textbox " + by.toString());
		}
		AllureManager.saveTextLog("Clear text in textbox");
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Clear all text of the element with press Ctrl A > Delete
	 *
	 * @param by an element of object type By
	 */
	@Step("Clear text in text box with Ctrl A")
	public static void clearTextCtrlA(By by) {
		waitForElementVisible(by);
		Actions actions = new Actions(DriverManager.getDriver());
		actions.click(getWebElement(by)).build().perform();
		//actions.moveToElement(getWebElement(by)).click().build();
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		actions.sendKeys(Keys.DELETE).build().perform();

		LogUtils.info("Clear text in textbox " + by.toString());
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clear text in textbox " + by.toString());
		}
		AllureManager.saveTextLog("Clear text in textbox");
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Clear all text of the element then set the text on that element.
	 *
	 * @param by    an element of object type By
	 * @param value the value to fill in the text box
	 */
	@Step("Clear and Fill text on text box")
	public static void clearAndFillText(By by, String value) {
		waitForElementVisible(by).clear();
		waitForElementVisible(by).sendKeys(value);
		LogUtils.info("Clear and Fill " + value + " on " + by.toString());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clear and Fill " + value + " on " + by.toString());
		}
		AllureManager.saveTextLog("Clear and Fill " + value + " on " + by.toString());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Click on the specified element.
	 *
	 * @param by an element of object type By
	 */
	@Step("Click on the element {0}")
	public static void clickElement(By by) {
		waitForElementVisible(by).click();
		LogUtils.info("Clicked on the element " + by.toString());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clicked on the element " + by.toString());
		}
		AllureManager.saveTextLog("Clicked on the element " + by.toString());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Click on element with timeout
	 *
	 * @param by an element of object type By
	 */
	@Step("Click on the element {0} with timeout {1}s")
	public static void clickElement(By by, int timeout) {
		waitForElementVisible(by, timeout).click();
		LogUtils.info("Clicked on the element " + by.toString());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clicked on the element " + by.toString());
		}
		AllureManager.saveTextLog("Clicked on the element " + by.toString());

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Click on Elements on the web with Javascript (click implicitly without fear of being hidden)
	 *
	 * @param by an element of object type By
	 */
	@Step("Click on the element by Javascript {0}")
	public static void clickElementWithJs(By by) {
		waitForElementPresent(by);
		//Scroll to element với Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
		//Click with JS
		js.executeScript("arguments[0].click();", getWebElement(by));

		LogUtils.info("Click on element with JS: " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Click on element with JS: " + by);
		}
		AllureManager.saveTextLog("Click on element with JS: " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}


	@Step("Get text of hidden elements by Javascript {0}")
	public static List<String> getTextOfHiddenElements(By by) {
		waitForElementPresent(by);
		// Get the text of hidden elements with Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		List<WebElement> elements = getWebElements(by);
		List<String> texts = new ArrayList<>();

		for (WebElement element : elements) {
			String text = (String) js.executeScript("return arguments[0].textContent;", element);
			texts.add(text);
		}

		LogUtils.info("Get text of hidden elements with JS: " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Get text of hidden elements with JS: " + by);
		}
		AllureManager.saveTextLog("Get text of hidden elements with JS: " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return texts;
	}

	/**
	 * Click on the link on website with text
	 *
	 * @param linkText is the visible text of a link
	 */
	@Step("Click on the link text {0}")
	public static void clickLinkText(String linkText) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		WebElement elementWaited = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
		elementWaited.click();

		LogUtils.info("Click on link text " + linkText);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Click on link text " + linkText);
		}
		AllureManager.saveTextLog("Click on link text " + linkText);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}

	/**
	 * Right-click on the Element object on the web
	 *
	 * @param by an element of object type By
	 */
	@Step("Right click on element {0}")
	public static void rightClickElement(By by) {
		Actions action = new Actions(DriverManager.getDriver());
		action.contextClick(waitForElementVisible(by)).build().perform();
		LogUtils.info("Right click on element " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Right click on element " + by);
		}
		AllureManager.saveTextLog("Right click on element " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

	}

	/**
	 * Get text of an element
	 *
	 * @param by an element of object type By
	 * @return text of a element
	 */
	@Step("Get text of element {0}")
	public static String getTextElement(By by) {
		smartWait();
		AllureManager.saveTextLog("Get text of element " + by.toString());
		AllureManager.saveTextLog("==> The Text is: " + waitForElementVisible(by).getText());
		return waitForElementVisible(by).getText().trim();
	}

	/**
	 * Get the value from the element's attribute
	 *
	 * @param by            an element of object type By
	 * @param attributeName attribute name
	 * @return element's attribute value
	 */
	@Step("Get attribute {1} of element {0}")
	public static String getAttributeElement(By by, String attributeName) {
		smartWait();
		return waitForElementVisible(by).getAttribute(attributeName);
	}

	/**
	 * Get CSS value of an element
	 *
	 * @param by      Represent a web element as the By object
	 * @param cssName is CSS attribute name
	 * @return value of CSS attribute
	 */
	@Step("Get CSS value {1} of element {0}")
	public static String getCssValueElement(By by, String cssName) {
		smartWait();
		return waitForElementVisible(by).getCssValue(cssName);
	}

	/**
	 * Get size of specified element
	 *
	 * @param by Represent a web element as the By object
	 * @return Dimension
	 */
	@Step("Get Size of element {0}")
	public static Dimension getSizeElement(By by) {
		smartWait();
		return waitForElementVisible(by).getSize();
	}

	/**
	 * Get location of specified element
	 *
	 * @param by Represent a web element as the By object
	 * @return Point
	 */
	@Step("Get Location of element {0}")
	public static Point getLocationElement(By by) {
		smartWait();
		return waitForElementVisible(by).getLocation();
	}

	/**
	 * Get tag name (HTML tag) of specified element
	 *
	 * @param by Represent a web element as the By object
	 * @return Tag name as String
	 */
	@Step("Get Tag Name of element {0}")
	public static String getTagNameElement(By by) {
		smartWait();
		return waitForElementVisible(by).getTagName();
	}

	/**
	 * Check the value of each column of the table when searching according to EQUAL conditions (equals)
	 *
	 * @param column column position
	 * @param value  value to compare
	 */
	@Step("Check data by EQUALS type after searching on the Table by Column.")
	public static void checkEqualsValueOnTableByColumn(int column, String value) {
		smartWait();
		sleep(1);
		List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
		LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

		if (totalRows.size() < 1) {
			LogUtils.info("Not found value: " + value);
		} else {
			for (int i = 1; i <= totalRows.size(); i++) {
				boolean res = false;
				WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
				res = title.getText().toUpperCase().equals(value.toUpperCase());
				LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
				Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " equals no value: " + value);
			}
		}
	}

	/**
	 * Check the value of each column of the table when searching according to the CONTAINS condition (contains)
	 *
	 * @param column column position
	 * @param value  value to compare
	 */
	@Step("Check data by CONTAINS type after searching on the Table by Column.")
	public static void checkContainsValueOnTableByColumn(int column, String value) {
		smartWait();
		sleep(1);
		List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
		LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

		if (totalRows.size() < 1) {
			LogUtils.info("Not found value: " + value);
		} else {
			for (int i = 1; i <= totalRows.size(); i++) {
				boolean res = false;
				WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
				res = title.getText().toUpperCase().contains(value.toUpperCase());
				LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
				Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains no value: " + value);
			}
		}
	}

	/**
	 * Check the value of each column of the table when searching according to the CONTAINS condition with custom xpath
	 *
	 * @param column           column position
	 * @param value            value to compare
	 * @param xpathToTRtagname xpath value up to TR tag
	 */
	@Step("Check data by CONTAINS type after searching on the Table by Column.")
	public static void checkContainsValueOnTableByColumn(int column, String value, String xpathToTRtagname) {
		smartWait();

		//xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
		List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
		sleep(1);
		LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

		if (totalRows.size() < 1) {
			LogUtils.info("Not found value: " + value);
		} else {
			for (int i = 1; i <= totalRows.size(); i++) {
				boolean res = false;
				WebElement title = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column + "]"));
				res = title.getText().toUpperCase().contains(value.toUpperCase());
				LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
				Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains no value " + value);
			}
		}
	}

	/**
	 * Get the value of a column from the table
	 *
	 * @param column column position
	 * @return array of values of a column
	 */
	public static ArrayList getValueTableByColumn(int column) {
		smartWait();

		List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
		sleep(1);
		LogUtils.info("Number of results for column (" + column + "): " + totalRows.size()); //Không thích ghi log thì xóa nhen

		ArrayList arrayList = new ArrayList<String>();

		if (totalRows.size() < 1) {
			LogUtils.info("Not found value !!");
		} else {
			for (int i = 1; i <= totalRows.size(); i++) {
				boolean res = false;
				WebElement title = DriverManager.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
				arrayList.add(title.getText());
				LogUtils.info("Row " + i + ":" + title.getText()); //Không thích ghi log thì xóa nhen
			}
		}

		return arrayList;
	}

	//Wait Element

	/**
	 * Wait until the given web element is visible within the timeout.
	 *
	 * @param by      an element of object type By
	 * @param timeOut maximum timeout as second
	 * @return a WebElement object ready to be visible
	 */
	public static WebElement waitForElementVisible(By by, int timeOut) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));

			boolean check = verifyElementVisible(by, timeOut);
			if (check == true) {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} else {
				scrollToElementAtTop(by);
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for the element Visible. " + by.toString());
			LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
		}
		return null;
	}

	/**
	 * Wait until the given web element is visible.
	 *
	 * @param by an element of object type By
	 * @return a WebElement object ready to be visible
	 */
	public static WebElement waitForElementVisible(By by) {
		smartWait();
		waitForElementPresent(by);

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			boolean check = isElementVisible(by, 1);
			if (check == true) {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} else {
				scrollToElementAtBottom(by);
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		} catch (Throwable error) {
			LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
			Assert.fail("Timeout waiting for the element Visible. " + by.toString());
		}
		return null;
	}

	/**
	 * Wait for the given element to be clickable within the given time (in seconds).
	 *
	 * @param by      an element of object type By
	 * @param timeOut maximum timeout as seconds
	 * @return a WebElement object ready to CLICK
	 */
	public static WebElement waitForElementClickable(By by, long timeOut) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
			LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
		}
		return null;
	}

	/**
	 * Wait for the given element to be clickable.
	 *
	 * @param by an element of object type By
	 * @return a WebElement object ready to CLICK
	 */
	public static WebElement waitForElementClickable(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
			LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
		}
		return null;
	}

	/**
	 * Wait for the given element to present within the given time (in seconds).
	 *
	 * @param by      an element of object type By
	 * @param timeOut maximum timeout as seconds
	 * @return an existing WebElement object
	 */
	public static WebElement waitForElementPresent(By by, long timeOut) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Throwable error) {
			LogUtils.error("Timeout waiting for the element to exist. " + by.toString());
			Assert.fail("Timeout waiting for the element to exist. " + by.toString());
		}

		return null;
	}

	/**
	 * Wait for the given element to present
	 *
	 * @param by an element of object type By
	 * @return an existing WebElement object
	 */
	public static WebElement waitForElementPresent(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Throwable error) {
			LogUtils.error("Element not exist. " + by.toString());
			Assert.fail("Element not exist. " + by.toString());
		}
		return null;
	}

	/**
	 * Wait for an alert to present.
	 */
	public static boolean waitForAlertPresent() {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Throwable error) {
			LogUtils.error("Alert NOT present.");
			Assert.fail("Alert NOT present.");
			return false;
		}
	}

	/**
	 * Wait for an alert to present.
	 *
	 * @param timeOut Timeout waiting for an alert to present.
	 */
	public static boolean waitForAlertPresent(int timeOut) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Throwable error) {
			LogUtils.error("Alert NOT present.");
			Assert.fail("Alert NOT present.");
			return false;
		}
	}

	/**
	 * Wait until the given web element has an attribute with the specified name.
	 *
	 * @param by            an element of object type By
	 * @param attributeName The name of the attribute to wait for.
	 * @return true/false
	 */
	public static boolean waitForElementHasAttribute(By by, String attributeName) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.attributeToBeNotEmpty(waitForElementPresent(by), attributeName));
		} catch (Throwable error) {
			LogUtils.error("Timeout for element " + by.toString() + " to exist attribute: " + attributeName);
			Assert.fail("Timeout for element " + by.toString() + " to exist attribute: " + attributeName);
		}
		return false;
	}

	/**
	 * Verify if the web element has an attribute with the specified name and value.
	 *
	 * @param by             an element of object type By
	 * @param attributeName  The name of the attribute to wait for.
	 * @param attributeValue The value of attribute
	 * @return true/false
	 */
	@Step("Verify element {0} with attribute {1} has value is {2}")
	public static boolean verifyElementAttributeValue(By by, String attributeName, String attributeValue) {
		smartWait();

		waitForElementVisible(by);
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			wait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
			return true;
		} catch (Throwable error) {
			LogUtils.error("Object: " + by.toString() + ". Not found value: " + attributeValue + " with attribute type: " + attributeName + ". Actual get Attribute value is: " + getAttributeElement(by, attributeName));
			Assert.fail("Object: " + by.toString() + ". Not found value: " + attributeValue + " with attribute type: " + attributeName + ". Actual get Attribute value is: " + getAttributeElement(by, attributeName));
			return false;
		}
	}

	/**
	 * Verify if the web element has an attribute with the specified name.
	 *
	 * @param by            Represent a web element.
	 * @param attributeName The name of the attribute to wait for.
	 * @param timeOut       System will wait at most timeout (seconds) to return result
	 * @return true/false
	 */
	@Step("Verify element {0} has attribute {1} with timeout {2} second")
	public static boolean verifyElementHasAttribute(By by, String attributeName, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.attributeToBeNotEmpty(waitForElementPresent(by), attributeName));
			return true;
		} catch (Throwable error) {
			LogUtils.error("Not found Attribute " + attributeName + " of element " + by.toString());
			Assert.fail("Not found Attribute " + attributeName + " of element " + by.toString());
			return false;
		}
	}


	/**
	 * Wait for a page to load with the default time from the config
	 */
	public static void waitForPageLoaded() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOADED), Duration.ofMillis(500));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// wait for Javascript to loaded
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

		//Get JS is Ready
		boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

		//Wait Javascript until it is Ready!
		if (!jsReady) {
			LogUtils.info("Javascript in NOT Ready!");
			//Wait for Javascript to load
			try {
				wait.until(jsLoad);
			} catch (Throwable error) {
				error.printStackTrace();
				Assert.fail("Timeout waiting for page load. (" + FrameworkConstants.WAIT_PAGE_LOADED + "s)");
			}
		}
	}

	/**
	 * Wait for a page to load within the given time (in seconds)
	 */
	public static void waitForPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// wait for Javascript to loaded
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

		//Get JS is Ready
		boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

		//Wait Javascript until it is Ready!
		if (!jsReady) {
			LogUtils.info("Javascript in NOT Ready!");
			//Wait for Javascript to load
			try {
				wait.until(jsLoad);
			} catch (Throwable error) {
				error.printStackTrace();
				Assert.fail("Timeout waiting for page load. (" + FrameworkConstants.WAIT_PAGE_LOADED + "s)");
			}
		}
	}

	/**
	 * Wait for JQuery to finish loading with default time from config
	 */
	public static void waitForJQueryLoad() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOADED), Duration.ofMillis(500));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		//Wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> {
			assert driver != null;
			return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
		};

		//Get JQuery is Ready
		boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

		//Wait JQuery until it is Ready!
		if (!jqueryReady) {
			LogUtils.info("JQuery is NOT Ready!");
			try {
				//Wait for jQuery to load
				wait.until(jQueryLoad);
			} catch (Throwable error) {
				Assert.fail("Timeout waiting for JQuery load. (" + FrameworkConstants.WAIT_PAGE_LOADED + "s)");
			}
		}
	}

	/**
	 * Wait for Angular to finish loading with default time from config
	 */
	public static void waitForAngularLoad() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOADED), Duration.ofMillis(500));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		//Wait for ANGULAR to load
		ExpectedCondition<Boolean> angularLoad = driver -> {
			assert driver != null;
			return Boolean.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
		};

		//Get Angular is Ready
		boolean angularReady = Boolean.parseBoolean(js.executeScript(angularReadyScript).toString());

		//Wait ANGULAR until it is Ready!
		if (!angularReady) {
			LogUtils.warn("Angular is NOT Ready!");
			//Wait for Angular to load
			try {
				//Wait for jQuery to load
				wait.until(angularLoad);
			} catch (Throwable error) {
				Assert.fail("Timeout waiting for Angular load. (" + FrameworkConstants.WAIT_PAGE_LOADED + "s)");
			}
		}

	}

	@Step("Click and Hold element {0}")
	public static boolean clickHold(By element) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			//            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
			action.clickAndHold(getWebElement(element)).build().perform();
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	@Step("Release element {0}")
	public static boolean releaseElement(By element) {
		smartWait();

		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.release(getWebElement(element)).build().perform();
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	/**
	 * Switch to Parent Frame
	 */
	@Step("Switch to Default Content")
	public static void switchToParentFrame() {
		smartWait();

		DriverManager.getDriver().switchTo().parentFrame();
		LogUtils.info("Switch to Default Content");
	}


	@Step("Find text '{0}' in column '{1}' and click corresponding element in column '{2}'")
	public static void clickCorrespondingElement(String matchText, By column1Locator, By column2Locator) {
		// Wait for both columns to be present
		waitForElementPresent(column1Locator);
		waitForElementPresent(column2Locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements from both columns
		List<WebElement> column1Elements = getWebElements(column1Locator);
		List<WebElement> column2Elements = getWebElements(column2Locator);

		// Validate both columns have the same number of elements
		if (column1Elements.size() != column2Elements.size()) {
			throw new IllegalStateException("Columns do not have the same number of elements.");
		}

		// Iterate over the elements of the first column to find the match
		for (int i = 0; i < column1Elements.size(); i++) {
			WebElement column1Element = column1Elements.get(i);
			String text = (String) js.executeScript("return arguments[0].textContent;", column1Element);


			if (text.contains(matchText)) {
				// Match found, click the corresponding element in the second column
				WebElement column2Element = column2Elements.get(i);

				js.executeScript("arguments[0].scrollIntoView(false);", column2Element);
				js.executeScript("arguments[0].click();", column2Element);

				LogUtils.info("Clicked on corresponding element for text: " + matchText);
				if (ExtentTestManager.getExtentTest() != null) {
					ExtentReportManager.pass("Clicked on corresponding element for text: " + matchText);
				}
				AllureManager.saveTextLog("Clicked on corresponding element for text: " + matchText);
				addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

				return; // Exit after the first match
			}
		}

		throw new IllegalStateException("No matching text found in column 1 for: " + matchText);
	}

	/*    @Step("Click on the element by Javascript {0}")
    public static void clickElementsWithJs(By by) {
        waitForElementPresent(by);

        // Scroll to element with Javascript Executor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));

        // Play click sound
//        SoundUtils.playSound("C:\\Users\\Codetru\\Downloads\\CitizensFW\\AutomationFramework\\src\\test\\resources\\config\\Sounds\\mixkit-arcade-game-jump-coin-216.wav");  // Replace with the actual path to your sound file

        // Click with JS
        js.executeScript("arguments[0].click();", getWebElement(by));

        LogUtils.info("Click on element with JS: " + by);
        if (ExtentTestManager.getExtentTest() != null) {
            ExtentReportManager.pass("Click on element with JS: " + by);
        }
        AllureManager.saveTextLog("Click on element with JS: " + by);
        addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
    }
	 */

	@Step("Clear and Fill text on text box")
	public static void clearAndFillText1(By by, String value) {
		WebElement element = waitForElementVisible(by);
		element.clear();
		element.sendKeys(value);

		// Play default sound when sending keys

		LogUtils.info("Clear and Fill " + value + " on " + by.toString());

		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Clear and Fill " + value + " on " + by.toString());
		}
		AllureManager.saveTextLog("Clear and Fill " + value + " on " + by.toString());
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}


	@Step("Send keys '{1}' to element {0} using JavaScript")
	public static boolean sendKeysWithJavaScript(By element, String keys) {
		smartWait();

		try {
			WebElement webElement = getWebElement(element);
			WebDriver driver = DriverManager.getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = arguments[1];", webElement, keys);
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	@Step("Get text of elements identified by locator '{0}'")
	public static List<String> getElementTextsInList(By locator) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Retrieve and return the text of each element, filtering out blank or null texts
		return elements.stream()
				.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
				.filter(text -> text != null && !text.trim().isEmpty())
				.map(String::trim)
				.collect(Collectors.toList());
	}

	@Step("Get text of elements identified by locator '{0}'")
	public static List<String> getElementTextsInListIncludeEmpty(By locator) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Retrieve and return the text of each element, including null or empty texts
		return elements.stream()
				.map(element -> (String) js.executeScript("return arguments[0].textContent;", element))
				.map(text -> text != null ? text.trim() : null)
				.collect(Collectors.toList());
	}


	@Step("Get text of elements identified by locator '{0}' and filter corresponding elements from the second list")
	public static List<String> getElementTextsAndDeleteCorrespondingIfFoundEmpty(By locator, List<String> secondList) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Initialize an iterator for the second list
		Iterator<String> secondListIterator = secondList.iterator();

		// Retrieve and return the text of each element, filtering out blank or null texts
		List<String> resultList = new ArrayList<>();

		for (WebElement element : elements) {
			String text = (String) js.executeScript("return arguments[0].textContent;", element);
			text = text != null ? text.trim() : null;

			// Check if the text is not null and not empty
			if (text != null && !text.isEmpty()) {
				resultList.add(text);
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
				}
			} else {
				// Remove corresponding element from the second list
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
					secondListIterator.remove();
				}
			}
		}

		return resultList;
	}

	@Step("Remove corresponding elements from list1 and list2 if found empty or null in any list")
	public static void removeEmptyOrNullElementsFromLists(List<String> list1, List<String> list2) {
		try {
			for (int i = 0; i < list1.size(); i++) {
				String element1 = list1.get(i);
				String element2 = list2.get(i);

				// Check if either element is null or empty
				if ((element1 == null || element1.trim().isEmpty()) ||
						(element2 == null || element2.trim().isEmpty())) {
					list1.remove(i);
					list2.remove(i);
					i--; // Adjust index after removal
				}
			}
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
		}
	}


	@Step("Get text of elements identified by locator '{0}' and delete corresponding elements from the second and third lists if found empty")
	public static List<String> getElementTextsAndDeleteCorrespondingIfFoundEmpty(By locator, List<String> secondList, List<String> thirdList) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Initialize iterators for the second and third lists
		Iterator<String> secondListIterator = secondList.iterator();
		Iterator<String> thirdListIterator = thirdList.iterator();

		// Retrieve and return the text of each element, filtering out blank or null texts
		List<String> resultList = new ArrayList<>();

		for (WebElement element : elements) {
			String text = (String) js.executeScript("return arguments[0].textContent;", element);
			text = text != null ? text.trim() : null;

			// Check if the text is not null and not empty
			if (text != null && !text.isEmpty()) {
				resultList.add(text);
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
				}
				if (thirdListIterator.hasNext()) {
					thirdListIterator.next();
				}
			} else {
				// Remove corresponding elements from the second and third lists
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
					secondListIterator.remove();
				}
				if (thirdListIterator.hasNext()) {
					thirdListIterator.next();
					thirdListIterator.remove();
				}
			}
		}

		return resultList;
	}

	@Step("Get text of elements identified by locator '{0}' and delete corresponding elements from the second, third, and fourth lists if found empty")
	public static List<String> getElementTextsAndDeleteCorrespondingIfFoundEmpty(By locator, List<String> secondList, List<String> thirdList, List<String> fourthList) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Initialize iterators for the second, third, and fourth lists
		Iterator<String> secondListIterator = secondList.iterator();
		Iterator<String> thirdListIterator = thirdList.iterator();
		Iterator<String> fourthListIterator = fourthList.iterator();

		// Retrieve and return the text of each element, filtering out blank or null texts
		List<String> resultList = new ArrayList<>();

		for (WebElement element : elements) {
			String text = (String) js.executeScript("return arguments[0].textContent;", element);
			text = text != null ? text.trim() : null;

			// Check if the text is not null and not empty
			if (text != null && !text.isEmpty()) {
				resultList.add(text);
				// Move to the next item in the second, third, and fourth lists if the text is valid
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
				}
				if (thirdListIterator.hasNext()) {
					thirdListIterator.next();
				}
				if (fourthListIterator.hasNext()) {
					fourthListIterator.next();
				}
			} else {
				// If text is null or empty, remove corresponding elements from secondList, thirdList, and fourthList
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
					secondListIterator.remove();
				}
				if (thirdListIterator.hasNext()) {
					thirdListIterator.next();
					thirdListIterator.remove();
				}
				if (fourthListIterator.hasNext()) {
					fourthListIterator.next();
					fourthListIterator.remove();
				}
			}
		}

		return resultList;
	}



	@Step("Get text of elements identified by locator '{0}' and delete corresponding elements from the second list if found a specific string")
	public static List<String> getElementTextsAndDeleteCorrespondingIfContains(By locator, List<String> secondList, String searchString) {
		// Wait for the element to be present
		waitForElementPresent(locator);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// Get all elements identified by the locator
		List<WebElement> elements = getWebElements(locator);

		// Initialize an iterator for the second list
		Iterator<String> secondListIterator = secondList.iterator();

		// Retrieve and return the text of each element
		List<String> resultList = new ArrayList<>();

		for (WebElement element : elements) {
			String text = (String) js.executeScript("return arguments[0].textContent;", element);
			text = text != null ? text.trim() : null;

			// If the text is not null and not empty, process it
			if (text != null && !text.isEmpty()) {
				// Add the text to resultList
				resultList.add(text);

				// Check if the corresponding element in the second list contains the specific string
				if (secondListIterator.hasNext()) {
					String correspondingElement = secondListIterator.next();
					if (correspondingElement.contains(searchString)) {
						secondListIterator.remove();
					}
				}
			} else {
				// If text is null or empty, just move the iterator of the second list
				if (secondListIterator.hasNext()) {
					secondListIterator.next();
				}
			}
		}

		return resultList;
	}



	/**
	 * Verify if the first list contains all elements of the second list.
	 *
	 * @param list1 The first list
	 * @param list2 The second list
	 * @return true if list1 contains all elements of list2, false otherwise
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyListContains(List<String> list1, List<String> list2) {
		SoftAssert softAssert = new SoftAssert();
		boolean result = true;

		for (String value2 : list2) {
			boolean contains = list1.contains(value2);
			result &= contains;

			if (contains) {
				LogUtils.info("Verify Contains: List1 CONTAINS " + value2);
				if (ExtentTestManager.getExtentTest() != null) {
					ExtentReportManager.pass("Verify Contains: List1 CONTAINS " + value2);
				}
				AllureManager.saveTextLog("Verify Contains: List1 CONTAINS " + value2);
			} else {
				LogUtils.info("Verify Contains: List1 NOT CONTAINS " + value2);
				if (ExtentTestManager.getExtentTest() != null) {
					ExtentReportManager.fail("Verify Contains: List1 NOT CONTAINS " + value2);
					ExtentReportManager.addScreenShot(Status.FAIL, "");
				}
				AllureManager.saveTextLog("Verify Contains: List1 NOT CONTAINS " + value2);

				// Using soft assertion to allow for logging all missing elements
				softAssert.assertTrue(contains, "List1 NOT CONTAINS " + value2);
			}
		}

		softAssert.assertAll();
		return result;
	}


	/**
	 * Verify if the given web element is enabled.
	 *
	 * @param by Represents a web element as the By object
	 * @return true/false
	 */
	//    @Step("Verify element enabled {0}")
	//    public static boolean verifyElementEnabled(By by) {
	//        smartWait();
	//        
	//        try {
	//            WebDriver driver = DriverManager.getDriver();
	//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
	//            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
	//            
	//            if (element.isEnabled()) {
	//                LogUtils.info("Verify element enabled " + by);
	//                return true;
	//            } else {
	//                LogUtils.info("The element is NOT enabled. " + by);
	//                return false;
	//            }
	//        } catch (Exception e) {
	//            Assert.fail("The element is NOT present or enabled. " + by, e);
	//            return false;
	//        }
	//    }

	@Step("Verify element enabled {0}")
	public static boolean verifyElementEnabled(By by) {
		smartWait();
		waitForElementVisible(by);

		boolean result = false;

		try {
			WebDriver driver = DriverManager.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			result = element.isEnabled();

			if (result) {
				LogUtils.info("Verify element enabled: " + result);
			} else {
				LogUtils.warn("The element is NOT enabled: " + result);
			}

			Assert.assertTrue(result, "The element is NOT enabled. " + by);

			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element enabled: " + result);
				//                ExtentReportManager.warning("The element is NOT enabled: " + by);
			}
			AllureManager.saveTextLog("Verify element enabled: " + result + ". The element is NOT enabled: " + by);

		} catch (Exception e) {
			Assert.fail("The element is NOT present or enabled: " + by, e);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Exception while verifying element enabled: " + by);
				ExtentReportManager.fail("Exception: " + e.getMessage());
			}
			AllureManager.saveTextLog("Exception while verifying element enabled: " + by + ". Exception: " + e.getMessage());
		}

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return result;
	}

	@Step("Verify element is NOT enabled {0}")
	public static boolean verifyElementNotEnabled(By by) {
		smartWait();
		waitForElementVisible(by);

		boolean result = false;

		try {
			WebDriver driver = DriverManager.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			result = !element.isEnabled();

			if (!result) {
				LogUtils.info("Verify element is NOT enabled: " + result);
			} else {
				LogUtils.warn("The element is enabled: " + result);
			}

			Assert.assertFalse(element.isEnabled(), "The element is enabled: " + by);

			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.info("Verify element is NOT enabled: " + result);
				//                ExtentReportManager.warning("The element is enabled: " + by);
			}
			AllureManager.saveTextLog("Verify element is NOT enabled: " + result + ". The element is enabled: " + by);

		} catch (Exception e) {
			Assert.fail("The element is NOT present or enabled: " + by, e);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Exception while verifying element is NOT enabled: " + by);
				ExtentReportManager.fail("Exception: " + e.getMessage());
			}
			AllureManager.saveTextLog("Exception while verifying element is NOT enabled: " + by + ". Exception: " + e.getMessage());
		}

		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

		return result;
	}

	/**
	 * Deselect all options in a dropdown.
	 *
	 * @param by Represent a web element as the By object
	 */
	@Step("Deselect all options in dropdown {0}")
	public static void deselectAllOptions(By by) {
		smartWait();
		Select select = new Select(getWebElement(by));
		select.deselectAll();
		LogUtils.info("Deselect all options in dropdown " + by);
	}

	/**
	 * Deselect the option with the given label (displayed text).
	 *
	 * @param by   Represent a web element as the By object
	 * @param text the specified text of option to deselect
	 */
	@Step("Deselect Option by Text {0}")
	public static void deselectOptionByText(By by, String text) {
		smartWait();
		Select select = new Select(getWebElement(by));
		select.deselectByVisibleText(text);
		LogUtils.info("Deselect Option " + by + " by text " + text);
	}


	/**
	 * Move the cursor by the specified x and y offset and click using Robot.
	 *
	 * @param xOffset the x offset to move the cursor
	 * @param yOffset the y offset to move the cursor
	 * @return true if the action was successful, false otherwise
	 */
	@Step("Move by offset x: {0}, y: {1} using Robot and click")
	public static boolean moveByOffsetWithRobotAndClick(int xOffset, int yOffset, int delayInSecond) {
		smartWait();

		try {
			Robot robot = new Robot();
			// Move by the specified offset and click
			robot.mouseMove(xOffset, yOffset);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			WebUI.sleep(delayInSecond);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			LogUtils.info("Moved by offset x: " + xOffset + ", y: " + yOffset + " and clicked using Robot");
			return true;
		} catch (Exception e) {
			LogUtils.warn("Failed to move by offset and click using Robot: " + e.getMessage());
			return false;
		}
	}
	@Step("Press key: {0} using Robot")
	public static boolean pressKeyWithRobot(String key, int delayInSecond) {
		smartWait();  // Assuming this method adds a wait before performing the action

		try {
			Robot robot = new Robot();
			int keyCode = getKeyCode(key);  // Convert the key name to keycode
			if (keyCode == -1) {
				LogUtils.warn("Invalid key: " + key);
				return false;
			}

			// Press the specified key
			robot.keyPress(keyCode);
			WebUI.sleep(delayInSecond);  // Optional delay
			robot.keyRelease(keyCode);

			LogUtils.info("Pressed key: " + key + " using Robot");
			return true;
		} catch (Exception e) {
			LogUtils.warn("Failed to press key using Robot: " + e.getMessage());
			return false;
		}
	}
	private static int getKeyCode(String key) {
		switch (key.toUpperCase()) {
		case "ENTER": return KeyEvent.VK_ENTER;
		case "TAB": return KeyEvent.VK_TAB;
		case "SPACE": return KeyEvent.VK_SPACE;
		case "UP": return KeyEvent.VK_UP;
		case "DOWN": return KeyEvent.VK_DOWN;
		case "LEFT": return KeyEvent.VK_LEFT;
		case "RIGHT": return KeyEvent.VK_RIGHT;
		case "ESCAPE": return KeyEvent.VK_ESCAPE;
		case "CONTROL": return KeyEvent.VK_CONTROL;
		case "SHIFT": return KeyEvent.VK_SHIFT;
		case "ALT": return KeyEvent.VK_ALT;
		case "DELETE": return KeyEvent.VK_DELETE;
		// Add more cases for different keys as needed
		default:
			return -1;  // Invalid key
		}
	}

	/**
	 * Get the current date in "yyyy-MM-dd" format.
	 *
	 * @return the current date as a string in "yyyy-MM-dd" format
	 */
	@Step("Get the current date in yyyy-MM-dd format")
	public static String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);

		AllureManager.saveTextLog("Get the current date in yyyy-MM-dd format");
		AllureManager.saveTextLog("==> The current date is: " + formattedDate);

		return formattedDate;
	}

	@Step("Remove elements from list {0} containing '{1}' and corresponding elements from list {2}")
	public static boolean removeElementsContainingAndCorresponding(List<String> list1, String keyword, List<String> list2) {
		try {
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).contains(keyword)) {
					list1.remove(i);
					list2.remove(i);
					i--; // Adjust index after removal
				}
			}
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	@Step("Remove elements from list {0} containing '{1}' and corresponding elements from list {2} and list {3}")
	public static boolean removeElementsContainingAndCorresponding(List<String> list1, String keyword, List<String> list2, List<String> list3) {
		try {
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).contains(keyword)) {
					list1.remove(i);
					list2.remove(i);
					list3.remove(i);
					i--; // Adjust index after removal
				}
			}
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	@Step("Remove elements from list {0} containing '{1}' and corresponding elements from list {2}, list {3} and list {4}")
	public static boolean removeElementsContainingAndCorresponding(List<String> list1, String keyword, List<String> list2, List<String> list3, List<String> list4) {
		try {
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).contains(keyword)) {
					list1.remove(i);
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


	@Step("Remove duplicates from list {0} and corresponding elements from list {1}")
	public static boolean removeDuplicatesAndCorresponding(List<String> list1, List<String> list2) {
		try {
			List<String> tempList1 = new ArrayList<>(list1);
			for (int i = 0; i < tempList1.size(); i++) {
				String element1 = tempList1.get(i);
				for (int j = i + 1; j < tempList1.size(); j++) {
					if (element1.equals(tempList1.get(j))) {
						list1.remove(j);
						list2.remove(j);
						tempList1.remove(j); // Also remove from tempList1 to keep indices correct
						j--; // Adjust index after removal
					}
				}
			}
			return true;
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
			return false;
		}
	}

	@Step("Remove corresponding elements from list2 and list3 if a duplicate is found in list1, ignoring empty or null values in list1")
	public static void removeDuplicatesAndCorresponding(List<String> list1, List<String> list2, List<String> list3) {
		try {
			Set<String> seenElements = new HashSet<>();
			for (int i = 0; i < list1.size(); i++) {
				String element = list1.get(i);

				// Skip null or empty elements
				if (element == null || element.trim().isEmpty()) {
					continue;
				}

				// Check for duplicates in list1
				if (seenElements.contains(element)) {
					list1.remove(i);
					list2.remove(i);
					list3.remove(i);
					i--; // Adjust index after removal
				} else {
					seenElements.add(element);
				}
			}
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
		}
	}
	@Step("Remove corresponding elements from list2, list3 and list4 if a duplicate is found in list1, ignoring empty or null values in list1")
	public static void removeDuplicatesAndCorresponding(List<String> list1, List<String> list2, List<String> list3, List<String> list4) {
		try {
			Set<String> seenElements = new HashSet<>();
			for (int i = 0; i < list1.size(); i++) {
				String element = list1.get(i);

				// Skip null or empty elements
				if (element == null || element.trim().isEmpty()) {
					continue;
				}

				// Check for duplicates in list1
				if (seenElements.contains(element)) {
					list1.remove(i);
					list2.remove(i);
					list3.remove(i);
					list4.remove(i);
					i--; // Adjust index after removal
				} else {
					seenElements.add(element);
				}
			}
		} catch (Exception e) {
			LogUtils.info(e.getMessage());
		}
	}



	@Step("Verify Element Not Checked {0}")
	public static boolean verifyElementNotChecked(By by) {
		smartWait();

		boolean checked = getWebElement(by).isSelected();
		if (!checked) {
			return true;
		} else {
			Assert.assertTrue(false, "The element is checked.");
			return false;
		}
	}


	// Helper method to check if an element is checked using JavaScript
	@Step("Check if Element is Checked using JavaScript {0}")
	public static boolean verifyElementCheckedUsingJS(By by) {
		smartWait();

		WebDriver driver = DriverManager.getDriver();
		WebElement element = getWebElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isChecked = (Boolean) js.executeScript("return arguments[0].checked;", element);

		return isChecked;
	}


	@Step("Close Browser Window with Index {index}")
	public static void closeBrowserWindow(int index) {
		WebDriver driver = DriverManager.getDriver();
		smartWait();

		// Store the current window handle
		String currentWindowHandle = driver.getWindowHandle();

		// Get all window handles
		Object[] allWindows = driver.getWindowHandles().toArray();

		// Ensure the index is within the range of open windows
		if (index < 0 || index >= allWindows.length) {
			throw new IllegalArgumentException("Invalid window index: " + index);
		}

		// Switch to the window with the specified index
		driver.switchTo().window(allWindows[index].toString());

		// Close the window
		driver.close();

		LogUtils.info("Closed Browser Window with Index: " + index);

		// Switch back to the original window handle
		driver.switchTo().window(currentWindowHandle);
		LogUtils.info("Switched back to original window: " + currentWindowHandle);
	}


	@Step("Log Information Message")
	public static void logInfoMessage(String message) {
		smartWait();
		LogUtils.info(message);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info(message);
		}
		AllureManager.saveTextLog(message);
	}

	//    ############################################# Added by S ##############################################################
	@Step("Validate if WebElement contains data")
	public static String validateElementContainsData(String element) {
		SoftAssert softAssert = new SoftAssert();
		String result;

		// Check if element is present and has non-empty text
		if (element != null && !element.isEmpty()) {
			result = "WebElement contains data: " + element;
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);
			}
			AllureManager.saveTextLog(result);
		} else {
			result = "WebElement does not contain data or is not found.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(result);
				ExtentReportManager.addScreenShot(Status.FAIL, "WebElement_Data_Not_Found_Screenshot");
			}
			AllureManager.saveTextLog(result);

			// Using soft assertion to log the failure scenario
			softAssert.fail(result);
		}

		softAssert.assertAll();
		return result;
	}

	@Step("Validate the Date format in MM/DD/YYYY: {0}")
	public static boolean isValidDateFormat(String date) {
		SoftAssert softAssert = new SoftAssert();
		String result;

		// Regular expression for MM/DD/YYYY format
		String regex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		boolean isValid = matcher.matches();

		if (isValid) {
			result = "The date " + date + " is in the valid MM/DD/YYYY format.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);
			}
			AllureManager.saveTextLog(result);
		} else {
			result = "The date " + date + " is NOT in the valid MM/DD/YYYY format.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(result);
				ExtentReportManager.addScreenShot(Status.FAIL, "Invalid Date Format Screenshot");
			}
			AllureManager.saveTextLog(result);

			// Using soft assertion to log the invalid date scenario
			softAssert.fail(result);
		}

		softAssert.assertAll();
		return isValid;
	}


	@Step("Verify element present {0}")
	public static boolean verifyElementIncurrentPage(By by) {
		smartWait();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		LogUtils.info("Verify element present " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.info("Verify element present " + by);
		}
		AllureManager.saveTextLog("Verify element present " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
		return true;

	}

	public static double roundOf(String text) {
		String amountString = text.replaceAll("[^0-9.]", ""); // Remove non-numeric characters except the period
		double amount = Double.parseDouble(amountString);

		// Convert the double to BigDecimal for precise rounding
		BigDecimal bd = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
		double roundedAmount = bd.doubleValue();

		// Print the rounded double value
		System.out.println("Rounded amount: " + roundedAmount);
		return roundedAmount;

	}

	@Step("Verify element is editable {0}")
	public static boolean verifyElementEditable(By by) {
		smartWait();

		try {
			WebDriver driver = DriverManager.getDriver();
			WebElement textField = driver.findElement(by);

			// Clear the text field in case there is any pre-existing text
			textField.clear();


			String testValue = "TestValue";
			textField.sendKeys(testValue);

			// Verify if the text field is editable by checking if the value was set
			String value = textField.getAttribute("value");
			boolean isEditable = value.equals(testValue);
			textField.clear();

			if (isEditable) {
				LogUtils.info("Verify element is editable " + by);
				if (ExtentTestManager.getExtentTest() != null) {
					ExtentReportManager.info("Verify element is editable " + by);
				}
				AllureManager.saveTextLog("Verify element is editable " + by);
				return true;
			} else {
				throw new Exception("Element is not editable");
			}
		} catch (Exception e) {
			LogUtils.error(e.getMessage());
			Assert.fail("FAILED. Element is not editable " + by);
			return false;
		}
	}

	@Step("Verify element not editable {0}")
	public static boolean verifyElementNotEditable(By by) {
		smartWait();

		try {
			WebDriver driver = DriverManager.getDriver();
			WebElement textField = driver.findElement(by);

			String readOnlyAttribute = textField.getAttribute("readonly");
			boolean isNotEditable = readOnlyAttribute != null && (readOnlyAttribute.equals("true") || readOnlyAttribute.equals("readonly"));

			if (isNotEditable) {
				LogUtils.info("Verify element not editable " + by);
				if (ExtentTestManager.getExtentTest() != null) {
					ExtentReportManager.info("Verify element not editable " + by);
				}
				AllureManager.saveTextLog("Verify element not editable " + by);
				return true;
			} else {
				throw new Exception("Element is editable");
			}
		} catch (Exception e) {
			LogUtils.error(e.getMessage());
			Assert.fail("FAILED. Element is editable " + by);
			return false;
		}
	}

	public static double roundOfDouble(double amount) {

		BigDecimal bd = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
		double roundedAmount = bd.doubleValue();

		// Print the rounded double value
		System.out.println("Rounded amount: " + roundedAmount);
		return roundedAmount;

	}

	@Step("Process list1 and delete corresponding elements from list2 and list3 if list1 contains empty or null values and list2 contains a specific string")
	public static void processListsAndDeleteCorresponding(List<String> list1, List<String> list2, List<String> list3, String searchString) {
		// Initialize iterators for the lists
		Iterator<String> list1Iterator = list1.iterator();
		Iterator<String> list2Iterator = list2.iterator();
		Iterator<String> list3Iterator = list3.iterator();

		// Iterate through the first list
		while (list1Iterator.hasNext()) {
			String item1 = list1Iterator.next();
			String item2 = list2Iterator.hasNext() ? list2Iterator.next() : null;
			String item3 = list3Iterator.hasNext() ? list3Iterator.next() : null;

			// Check if the item in list1 is empty or null
			if (item1 == null || item1.trim().isEmpty()) {
				// Check if the corresponding item in list2 contains the specific string
				if (item2 != null && item2.contains(searchString)) {
					// Remove the item from all three lists
					list1Iterator.remove();
					if (item2 != null) {
						list2Iterator.remove();
					}
					if (item3 != null) {
						list3Iterator.remove();
					}
				}
			}
		}
	}

	@Step("Process lists1, 2, 3, and delete corresponding elements if list1 contains empty or null values and list2 contains a specific string")
	public static void processListsAndDeleteCorresponding(List<String> list1, List<String> list2, List<String> list3, List<String> list4, String searchString) {
		// Initialize iterators for the lists
		Iterator<String> list1Iterator = list1.iterator();
		Iterator<String> list2Iterator = list2.iterator();
		Iterator<String> list3Iterator = list3.iterator();
		Iterator<String> list4Iterator = list4.iterator();

		// Iterate through the first list
		while (list1Iterator.hasNext()) {
			String item1 = list1Iterator.next();
			String item2 = list2Iterator.hasNext() ? list2Iterator.next() : null;
			String item3 = list3Iterator.hasNext() ? list3Iterator.next() : null;
			String item4 = list4Iterator.hasNext() ? list4Iterator.next() : null;

			// Check if the item in list1 is empty or null
			if (item1 == null || item1.trim().isEmpty()) {
				// Check if the corresponding item in list2 contains the specific string
				if (item2 != null && item2.contains(searchString)) {
					// Remove the item from all four lists
					list1Iterator.remove();
					if (item2 != null) {
						list2Iterator.remove();
					}
					if (item3 != null) {
						list3Iterator.remove();
					}
					if (item4 != null) {
						list4Iterator.remove();
					}
				}
			}
		}
	}


	/**
	 * Send keys to Elements on the web with Javascript (set value implicitly without fear of being hidden)
	 *
	 * @param by an element of object type By
	 * @param keys the keys to send to the element
	 */
	@Step("Send keys to the element by Javascript {0}")
	public static void sendKeysWithJs(By by, String keys) {
		waitForElementPresent(by);
		// Scroll to element with Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
		// Send keys with JS
		js.executeScript("arguments[0].value=arguments[1];", getWebElement(by), keys);

		LogUtils.info("Send keys to element with JS: " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Send keys to element with JS: " + by);
		}
		AllureManager.saveTextLog("Send keys to element with JS: " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}

	//Extra Added Methods =====================================================================================================================================
	//	@Step("Click an element with co-ordinates ")
	//	public static void clickwithaxes(int x, int y) throws Exception  {
	//		Robot robot = new Robot();
	//		robot.mouseMove(x, y);
	//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	//		WebUI.sleep(0.5);
	//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	//
	//	}

	@Step("Mouse hover an element with co-ordinates ")
	public static void mouseHoverwithaxes(int x, int y) throws Exception  {
		Robot robot = new Robot();
		robot.mouseMove(x, y);
	}

	@Step("Click an element with co-ordinates ")
	public static void clickEnterKey() throws Exception  {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		WebUI.sleep(0.5);
		robot.keyRelease(KeyEvent.VK_ENTER); 
		WebUI.sleep(2);

	}

	@Step("Open new Window with url")
	public static void openNewTabWindow(String url) {
		smartWait();
		// Opens a new window and switches to new window
		DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
		DriverManager.getDriver().get(url);
		LogUtils.info("Open new Window");
	}

	@Step("Verify element present {0}")
	public static void clickWebElementwithJs(String path) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		WebElement element= (WebElement) js.executeScript(path);
		WebUI.sleep(2);
		element.click();

	}

	/**
	 * Switch to child window
	 * @param title title of popup window
	 */
	@Step("Switch to child window")
	public static void switchToChildWindow(){
		String originalWindow = DriverManager.getDriver().getWindowHandle();
		Set<String> windows= DriverManager.getDriver().getWindowHandles(); 
		for (String window : windows){
			if (!window.equals(originalWindow)) { 
				DriverManager.getDriver().switchTo().window(window);
			}
		}
	}

	@Step("Verify String is Numeric or Alphabetical Value: {0}")
	public static String validateString(String inputString) {
		SoftAssert softAssert = new SoftAssert();
		String result;

		if (inputString.matches("[0-9]+")) {
			result = "The string "+inputString+" contains only numeric characters.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);
			}
			AllureManager.saveTextLog(result);
		} else if (inputString.matches("[a-zA-Z, ]+")) {
			result = "The string "+inputString+" contains only alphabetic characters.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);
			}
			AllureManager.saveTextLog(result);
		} else {
			result = "The string "+inputString+" contains a mix of numeric and alphabetic characters.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(result);
				ExtentReportManager.addScreenShot(Status.FAIL, "");
			}
			AllureManager.saveTextLog(result);

			// Using soft assertion to log the mixed string scenario
			softAssert.fail(result);
		}

		softAssert.assertAll();
		return result;
	}

	@Step("Click an element with co-ordinates ")
	public static void clickwithaxes(int x, int y) throws Exception  {
		Robot robot = new Robot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		WebUI.sleep(0.5);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	@Step("Click on the element by Javascript {0}")
	public static void clickElementsWithJs(By by) {
		//	waitForElementPresent(by);

		// Scroll to element with Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));

		// Play click sound
		//        SoundUtils.playSound("C:\\Users\\Codetru\\Downloads\\CitizensFW\\AutomationFramework\\src\\test\\resources\\config\\Sounds\\mixkit-arcade-game-jump-coin-216.wav");  // Replace with the actual path to your sound file

		// Click with JS
		js.executeScript("arguments[0].click();", getWebElement(by));

		LogUtils.info("Click on element with JS: " + by);
		if (ExtentTestManager.getExtentTest() != null) {
			ExtentReportManager.pass("Click on element with JS: " + by);
		}
		AllureManager.saveTextLog("Click on element with JS: " + by);
		addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
	}

	/**
	 * Switch to popup window by title
	 *
	 * @param title title of popup window
	 */
	@Step("Switch to Window or Tab by Title: {0}")
	public static void switchToWindowOrTabByTabIndex(int tabPosition) {
		smartWait();

		//Store the ID of the original window
		String originalWindow = DriverManager.getDriver().getWindowHandle();

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
		//Wait for the new window or tab
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		//Loop through until we find a new window handle
		for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				DriverManager.getDriver().switchTo().window(windowHandle);
				if (DriverManager.getDriver().getTitle().equals(tabPosition)) {
					break;
				}
			}
		}
	}

	/**
	 * Verify if the first object contains the second object.
	 *
	 * @param value1 The first object
	 * @param value2 The second object
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyContainsIgnore(String value1, String value2) {
		SoftAssert softAssert = new SoftAssert();
		boolean result = value1.contains(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {

			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			softAssert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);
		}
		return result;
	}
	/**
	 * Verify if the first string in the list contains the second string.
	 *
	 * @param values A list containing the first string as the first element
	 * @param value2 The second string to check for containment
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyContainsIgnore(List<String> values, String value2) {
		String value1 = values.get(0);  // Assuming the first string in the list is the one to check
		SoftAssert softAssert = new SoftAssert();
		boolean result = value1.contains(value2);

		if (result) {
			LogUtils.info("Verify Contains: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " CONTAINS " + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				// Handle extent test if necessary
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			softAssert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);
		}
		return result;
	}
	/**
	 * Verify if the first object contains the second object.
	 *
	 * @param value1 The first object
	 * @param value2 The second object
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyContains(List<String> value1, String value2) {
		SoftAssert softAssert = new SoftAssert();
		boolean result = value1.contains(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
				ExtentReportManager.addScreenShot(Status.FAIL, "");
			}
			AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
			softAssert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);
		}
		return result;
	}

	/**
	 * Verify if the first object contains the second object.
	 *
	 * @param value1 The first object
	 * @param value2 The second object
	 * @return true/false
	 */
	@Step("Verify Contains: {0} ---AND--- {1}")
	public static boolean verifyNotContains(List<String> value1, String value2) {
		SoftAssert softAssert = new SoftAssert();
		boolean result =! value1.contains(value2);
		if (result == true) {
			LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Not Contains: " + value1 + "  NOT CONTAINS " + value2);
			}
			AllureManager.saveTextLog("Verify Not Contains: " + value1 + " NOT CONTAINS" + value2);
		} else {
			LogUtils.info("Verify Contains: " + value1 + " " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Not Contains: " + value1 + " CONTAINS " + value2);
				ExtentReportManager.addScreenShot(Status.FAIL, "");
			}
			AllureManager.saveTextLog("Verify Not Contains: " + value1 + " CONTAINS " + value2);
			softAssert.assertEquals(value1, value2, value1 + " CONTAINS " + value2);
		}
		return result;
	}


	@Step("Validate if WebElement contains data and extract ID")
	public static String validateElementContainsDataAndExtractID( By by) {
		SoftAssert softAssert = new SoftAssert();
		String result;
		String id = null;
		WebElement element = DriverManager.getDriver().findElement(by);
		String text = element.getText();
		System.out.println(text);
		if (text != null && !text.isEmpty()) {
			String[] parts = text.split(" - - ");
			if (parts.length > 1) {
				id = parts[1].split(" - ")[0].trim();
				result = "WebElement contains data: " + text + " | Extracted ID: " + id;
			} else {
				result = "WebElement contains data, but ID extraction failed. Text: " + text;
			}

			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);
			}
			AllureManager.saveTextLog(result);
		} else {
			result = "WebElement does not contain data or is not found.";
			LogUtils.info(result);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(result);
				addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
			}
			AllureManager.saveTextLog(result);
			softAssert.fail(result);
		}

		softAssert.assertAll();
		return id; 	   
	}


	/**
	 * Verify if the first object is less than or equal to the second object.
	 *
	 * @param fiveRecords The first object
	 * @param totalRows The second object
	 * @return true/false
	 */
	@Step("Verify Less Than or Equals: {0} <= {1}")
	public static boolean verifyGreaterThanOrEquals(int value1, int value2) {
		boolean result = value1 >= value2;     
		if (result) {
			String successMessage = "Verify Greater Than or Equals: " + value1 + " >= " + value2;
			LogUtils.info(successMessage);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(successMessage);
			}
			AllureManager.saveTextLog(successMessage);
		} else {
			String failureMessage = "Verify Greater Than or Equals: " + value1 + " < " + value2;
			LogUtils.info(failureMessage);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(failureMessage);
			}
			AllureManager.saveTextLog(failureMessage);
			Assert.assertTrue(result, failureMessage);  // Assert with failure message
		}
		return result;
	}

	/**
	 * Verify if the first object is less than or equal to the second object.
	 *
	 * @param fiveRecords The first object
	 * @param totalRows The second object
	 * @return true/false
	 */
	@Step("Verify Less Than or Equals: {0} <= {1}")
	public static boolean verifyLessThanOrEquals(int value1, int value2) {
		boolean result = value1 <= value2;     
		if (result) {
			String successMessage = "Verify Less Than or Equals: " + value1 + " <= " + value2;
			LogUtils.info(successMessage);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(successMessage);
			}
			AllureManager.saveTextLog(successMessage);
		} else {
			String failureMessage = "Verify Less Than or Equals: " + value1 + " > " + value2;
			LogUtils.info(failureMessage);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(failureMessage);
			}
			AllureManager.saveTextLog(failureMessage);
			Assert.assertTrue(result, failureMessage);  // Assert with failure message
		}
		return result;
	}

	/**
	 * Verify if two object are equal.
	 *
	 * @param value1 The object one
	 * @param value2 The object two
	 * @return true/false
	 */
	@Step("Verify Equals: {0} ---AND--- {1}")
	public static boolean verifyNotEquals(Object value1, Object value2) {
		boolean result = value1.equals(value2);
		if (result == false) {
			LogUtils.info("Verify Equals: " + value1 + " != " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass("Verify Equals: " + value1 + " != " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " != " + value2);
		} else {
			LogUtils.info("Verify Equals: " + value1 + " = " + value2);
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail("Verify Equals: " + value1 + " = " + value2);
			}
			AllureManager.saveTextLog("Verify Equals: " + value1 + " = " + value2);
			Assert.assertEquals(value1, value2, value1 + " = " + value2);
		}
		return result;
	}
	@Step("Verify past and future dates: {0} ---AND--- {1}")
	public static boolean ValidatePastAndFutureDate(String value1, String value2) {
		SoftAssert softAssert = new SoftAssert();
		String result;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate paidToDate = LocalDate.parse(value1, dateFormat);
		LocalDate applicationDate = LocalDate.parse(value2, dateFormat);
		if (paidToDate.isAfter(applicationDate)) {
			result = "Validation failed: Paid To Date (" + value1 + ") is after Application Date (" + value2 + ")";
			LogUtils.info(result); 
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.fail(result);  
				ExtentReportManager.addScreenShot(Status.FAIL, "Paid To Date After Application Date Screenshot");
			}
			AllureManager.saveTextLog(result);  
			softAssert.fail(result);  
		} else {
			result = "Validation passed: Paid To Date (" + value1 + ") is valid and not after Application Date (" + value2 + ")";
			LogUtils.info(result);  
			if (ExtentTestManager.getExtentTest() != null) {
				ExtentReportManager.pass(result);  
			}
			AllureManager.saveTextLog(result); 
		}
		softAssert.assertAll();  
		return !paidToDate.isAfter(applicationDate);
	}
	/**
	 * Navigate to the previous webPage.
	 */
	@Step("Reload page")
	public static void navigateToPreviousPage() {
		smartWait();

		DriverManager.getDriver().navigate().back();
		waitForPageLoaded();
		LogUtils.info("Navigate to Back WebPage " + DriverManager.getDriver().getCurrentUrl());
	}
	
	/**
	 * Verify if a specific string is present in the list.
	 *
	 * @param list The list to check
	 * @param value The string value to look for in the list
	 * @return true if the list contains the string, false otherwise
	 */
	@Step("Verify if list contains the string: {1}")
	public static boolean verifyStringInList(List<String> list, String value) {
	    SoftAssert softAssert = new SoftAssert();
	    boolean contains = list.contains(value);

	    if (contains) {
	        LogUtils.info("Verification Passed: List contains " + value);
	        if (ExtentTestManager.getExtentTest() != null) {
	            ExtentReportManager.pass("Verification Passed: List contains " + value);
	        }
	        AllureManager.saveTextLog("Verification Passed: List contains " + value);
	    } else {
	        LogUtils.info("Verification Failed: List does NOT contain " + value);
	        if (ExtentTestManager.getExtentTest() != null) {
	            ExtentReportManager.fail("Verification Failed: List does NOT contain " + value);
	            ExtentReportManager.addScreenShot(Status.FAIL, "");
	        }
	        AllureManager.saveTextLog("Verification Failed: List does NOT contain " + value);

	        // Soft assert to capture failure without immediately stopping execution
	        softAssert.assertTrue(contains, "Verification Failed: List does NOT contain " + value);
	    }

	    softAssert.assertAll();
	    return contains;
	}


}