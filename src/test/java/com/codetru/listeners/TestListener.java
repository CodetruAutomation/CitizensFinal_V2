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

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;

    private ScreenRecoderHelpers screenRecorder;
    public static String methodName = "";

    public TestListener() {
        System.out.println("Initializing TestListener...");
        try {
            screenRecorder = new ScreenRecoderHelpers();
            System.out.println("ScreenRecorderHelpers initialized successfully.");
        } catch (IOException | AWTException e) {
            System.err.println("Failed to initialize ScreenRecorderHelpers: " + e.getMessage());
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
        System.out.println("Before invocation: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After every method in the Test Class
        System.out.println("After invocation: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("========= INSTALLING CONFIGURATION DATA =========");
        PropertiesHelpers.loadAllFiles();
        ExtentReportManager.initReports();
        System.out.println("========= INSTALLED CONFIGURATION DATA =========");
        System.out.println("");
        LogUtils.info("Starting Suite: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("End Suite: " + iSuite.getName());
        WebUI.stopSoftAssertAll();
        ExtentReportManager.flushReports();
        TelegramManager.sendReportPath();
        EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
        FileHelpers.copyFile("src/test/resources/config/allure/categories.json", "target/allure-results/categories.json");
        FileHelpers.copyFile("src/test/resources/config/allure/executor.json", "target/allure-results/executor.json");
    }

    public AuthorType[] getAuthorType(ITestResult iTestResult) {
        FrameworkAnnotation annotation = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class);
        return annotation != null ? annotation.author() : null;
    }

    public CategoryType[] getCategoryType(ITestResult iTestResult) {
        FrameworkAnnotation annotation = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class);
        return annotation != null ? annotation.category() : null;
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
            try {
                screenRecorder.startRecording(getTestName(iTestResult));
                System.out.println("Started recording for: " + getTestName(iTestResult));
            } catch (Exception e) {
                System.err.println("Error starting video recording: " + e.getMessage());
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
            try {
                screenRecorder.stopRecording(true);
                System.out.println("Stopped recording for: " + getTestName(iTestResult));
            } catch (Exception e) {
                System.err.println("Error stopping video recording: " + e.getMessage());
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
            try {
                screenRecorder.stopRecording(true);
                System.out.println("Stopped recording for: " + getTestName(iTestResult));
            } catch (Exception e) {
                System.err.println("Error stopping video recording: " + e.getMessage());
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
        count_skippedTCs++;

        if (SCREENSHOT_SKIPPED_STEPS.equals(YES)) {
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(iTestResult));
        }

        ExtentReportManager.logMessage(Status.SKIP, "Test case: " + getTestName(iTestResult) + " is skipped.");

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            try {
                screenRecorder.stopRecording(true);
                System.out.println("Stopped recording for: " + getTestName(iTestResult));
            } catch (Exception e) {
                System.err.println("Error stopping video recording: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LogUtils.error("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
        ExtentReportManager.logMessage("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
    }
}
