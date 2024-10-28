package com.codetru.listeners;

import static com.codetru.constants.FrameworkConstants.SCREENSHOT_FAILED_STEPS;
import static com.codetru.constants.FrameworkConstants.SCREENSHOT_PASSED_STEPS;
import static com.codetru.constants.FrameworkConstants.SCREENSHOT_SKIPPED_STEPS;
import static com.codetru.constants.FrameworkConstants.VIDEO_RECORD;
import static com.codetru.constants.FrameworkConstants.YES;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.codetru.annotations.FrameworkAnnotation;
import com.codetru.constants.FrameworkConstants;
import com.codetru.driver.DriverManager;
import com.codetru.enums.AuthorType;
import com.codetru.enums.Browser;
import com.codetru.enums.CategoryType;
import com.codetru.helpers.CaptureHelpers;
import com.codetru.helpers.FileHelpers;
import com.codetru.helpers.PropertiesHelpers;
import com.codetru.helpers.ScreenRecoderHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.report.ExtentReportManager;
import com.codetru.report.TelegramManager;
import com.codetru.utils.BrowserInfoUtils;
import com.codetru.utils.EmailSendUtils;
import com.codetru.utils.LogUtils;
import com.google.common.collect.ImmutableMap;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;

    private ScreenRecoderHelpers screenRecorder;
    public static String methodName = "";

    // Constructor: Lazy initialization of screenRecorder
    public TestListener() {
        LogUtils.info("Initializing TestListener...");
    }

    // Lazy instantiation method for screenRecorder to avoid initialization errors
    private void initScreenRecorder() {
        if (screenRecorder == null) {
            try {
                screenRecorder = new ScreenRecoderHelpers();
            } catch (IOException | AWTException e) {
                LogUtils.error("Failed to initialize ScreenRecoderHelpers: " + e.getMessage());
            }
        }
    }

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before every method in the Test Class
        // Logging can be added if needed
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After every method in the Test Class
        // Logging can be added if needed
    }

    @Override
    public void onStart(ISuite iSuite) {
        LogUtils.info("========= INSTALLING CONFIGURATION DATA =========");
        PropertiesHelpers.loadAllFiles();
   //     AllureManager.setAllureEnvironmentInformation();
        ExtentReportManager.initReports();
        LogUtils.info("========= CONFIGURATION DATA INSTALLED =========");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("End Suite: " + iSuite.getName());
        WebUI.stopSoftAssertAll();
        ExtentReportManager.flushReports();
        //ZipUtils.zipReportFolder();
        TelegramManager.sendReportPath();
        EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
    //    AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.<String, String>builder()
       //         .put("Test URL", FrameworkConstants.URL_CRM)
//                .put("Target Execution", FrameworkConstants.TARGET)
//                .put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT))
//                .put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED))
//                .put("Headless Mode", FrameworkConstants.HEADLESS)
//                .put("Local Browser", String.valueOf(Browser.CHROME))
//                .put("Remote URL", FrameworkConstants.REMOTE_URL)
//                .put("Remote Port", FrameworkConstants.REMOTE_PORT)
//                .put("TCs Total", String.valueOf(count_totalTCs))
//                .put("TCs Passed", String.valueOf(count_passedTCs))
//                .put("TCs Skipped", String.valueOf(count_skippedTCs))
//                .put("TCs Failed", String.valueOf(count_failedTCs))
//                .build());
        FileHelpers.copyFile("src/test/resources/config/allure/categories.json", "target/allure-results/categories.json");
        FileHelpers.copyFile("src/test/resources/config/allure/executor.json", "target/allure-results/executor.json");
    }

    public AuthorType[] getAuthorType(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) == null) {
            return null;
        }
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author();
    }

    public CategoryType[] getCategoryType(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class) == null) {
            return null;
        }
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("Test case: " + getTestName(iTestResult) + " is starting...");
        count_totalTCs++;

        methodName = iTestResult.getName();

        ExtentReportManager.createTest(iTestResult.getName());
        ExtentReportManager.addAuthors(getAuthorType(iTestResult));
        ExtentReportManager.addCategories(getCategoryType(iTestResult));
        ExtentReportManager.addDevices();
        String testTag = iTestResult.getTestContext().getCurrentXmlTest().getName();
        ExtentReportManager.info(BrowserInfoUtils.getOSInfo());
        ExtentReportManager.info(testTag);

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            initScreenRecorder();  // Initialize the screen recorder only when needed
            if (screenRecorder != null) {
                screenRecorder.startRecording(getTestName(iTestResult));
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("Test case: " + getTestName(iTestResult) + " is passed.");
        count_passedTCs++;

        if (SCREENSHOT_PASSED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(iTestResult) + " is passed.");

        if (VIDEO_RECORD.trim().toLowerCase().equals(YES)) {
            if (screenRecorder != null) {
                screenRecorder.stopRecording(true);
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.error("Test case: " + getTestName(iTestResult) + " is failed.");
        count_failedTCs++;

        if (SCREENSHOT_FAILED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            if (screenRecorder != null) {
                screenRecorder.stopRecording(true);
            }
        }

        LogUtils.error("FAILED !! Screenshot for test case: " + getTestName(iTestResult));
        LogUtils.error(iTestResult.getThrowable());

        ExtentReportManager.addScreenShot(Status.FAIL, getTestName(iTestResult));
        ExtentReportManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        LogUtils.warn("Test case: " + getTestName(iTestResult) + " is skipped.");
        count_skippedTCs = count_skippedTCs + 1;

        if (SCREENSHOT_SKIPPED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        ExtentReportManager.logMessage(Status.SKIP, "Test case: " + getTestName(iTestResult) + " is skipped.");

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            screenRecorder.stopRecording(true);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LogUtils.error("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
        ExtentReportManager.logMessage("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
    }

}
