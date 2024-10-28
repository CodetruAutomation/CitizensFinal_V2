package com.codetru.project.cica.testcases.regressionApplicationModule;

import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.listeners.Retry;
import com.codetru.project.cica.utils.ThreadLocalManager;

public class MasterTest_Guarantee extends BaseTest {

	   private static final String LAST_ITERATION_KEY = "lastIteration";
	   
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 1, retryAnalyzer = Retry.class)
	    public void processStates1To10(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 1);
	        processStatesInRange(startIteration, 10, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 2, retryAnalyzer = Retry.class)
	    public void processStates11To20(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 11);
	        processStatesInRange(startIteration, 20, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 3, retryAnalyzer = Retry.class)
	    public void processStates21To30(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 21);
	        processStatesInRange(startIteration, 30, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 4, retryAnalyzer = Retry.class)
	    public void processStates31To40(String rowNumber, ITestContext context) throws Exception {  
	        int startIteration = getStartIteration(context, 31);
	        processStatesInRange(startIteration, 40, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 5, retryAnalyzer = Retry.class)
	    public void processStates41To50(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 41);
	        processStatesInRange(startIteration, 50, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 6, retryAnalyzer = Retry.class)
	    public void processStates51To60(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 51);
	        processStatesInRange(startIteration, 60, rowNumber, context);
	    }
	 
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 7, retryAnalyzer = Retry.class)
	    public void processStates61To70(String rowNumber, ITestContext context) throws Exception {
	        int startIteration = getStartIteration(context, 61);
	        processStatesInRange(startIteration, 70, rowNumber, context);
	    }
	    
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 8, retryAnalyzer = Retry.class)
	    public void processStates71To80(String rowNumber, ITestContext context) throws Exception {
	    	int startIteration = getStartIteration(context, 71);
	    	processStatesInRange(startIteration, 80, rowNumber, context);
	    }
	    
	    @Parameters({"ROW_NUMBER"})
	    @Test(priority = 9, retryAnalyzer = Retry.class)
	    public void processStates81To90(String rowNumber, ITestContext context) throws Exception {
	    	int startIteration = getStartIteration(context, 81);
	    	processStatesInRange(startIteration, 90, rowNumber, context);
	    }
	 
	    private int getStartIteration(ITestContext context, int defaultStart) {
	        if (context == null) {
	            System.err.println("Context is null, starting from default: " + defaultStart);
	            return defaultStart;
	        }
	 
	        Object lastIterationObj = context.getAttribute(LAST_ITERATION_KEY);
	        if (lastIterationObj == null) {
	            System.out.println("LAST_ITERATION_KEY is null, starting from default: " + defaultStart);
	            return defaultStart;
	        } else {
	            int lastIteration = (int) lastIterationObj;
	            System.out.println("LAST_ITERATION_KEY found, starting from: " + lastIteration);
	            return lastIteration;
	        }
	    }
	 
	    public void processStatesInRange(int start, int end, String rowNumber, ITestContext context) throws Exception {
	 
			 ExcelHelpers excel = new ExcelHelpers();
			 excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
			 String row = rowNumber;
			 int rowNum = Integer.parseInt(row);
	 
	        List<String> licensedStatesList = ThreadLocalManager.getLicenseStateList();
	 
	        for (int i = start; i <= end && i < licensedStatesList.size(); i++) {
	            boolean isSuccess = false;
	            try {
	                // Set the current county index for this iteration
	                ThreadLocalManager.setLicCountyIndex(i);
	                ThreadLocalManager.setLicStateIndex(i);
	                System.out.println("************************** County Index is set to: " + ThreadLocalManager.getLicCountyIndex());
	 
	                // Reset the UI state before starting
	                WebUI.switchToMainWindow();
	                WebUI.sleep(0.5);
	 
	                // Log in and process the state
	                WebUI.logInfoMessage("********** Login ID: " + excel.getCellData(rowNum, "userid") + " for State: " + licensedStatesList.get(i) + " **********");
	                WebUI.logInfoMessage("********** Selected State Number: " + (i + 1) + " **********");
	 
	                // Perform the actions for the state
	                getHomePage_NV_All().HomePageNewApplication();
	                getStep_1Page_NV_Guarantee().Product_Information(licensedStatesList.get(i));
	                getStep_2Page_NV().Proposed_Insured_Information();
	                getStep_3Page_NV().Policy_Owner_Information();
	    			getStep_4Page_NV().Beneficiary_Information();
	    			getStep_5Page_NV().Existing_Insurance();
	    			getStep_7Page_NV().Remarks();
	    			getStep_8Page_NV().Disclosure_and_Signature();
	    			getStep_9Page_NV().Edit_Submit();
	    			
	    			if (i % 2 != 0) {
	    				getStep_10PageACH().Make_a_Payment();
	    			} else {
	    				getStep_10Page_NV().Make_a_Payment();
	    			}
	 
	                // Mark as successful if no exception occurs
	                isSuccess = true;
	                System.out.println("Successfully completed iteration: " + i);
	            } catch (Exception e) {
	                // Store the failed iteration number
	                if (context != null) {
	                    context.setAttribute(LAST_ITERATION_KEY, i);
	                }
	                System.out.println("Exception occurred at iteration: " + i + ", storing as last iteration.");
	                throw e;
	            } finally {
	                if (isSuccess && context != null) {
	                    System.out.println("Before setAttribute method........... in finally block.");
	                    context.setAttribute(LAST_ITERATION_KEY, i + 1);
	                    System.out.println("Iteration " + i + " completed successfully. LAST_ITERATION_KEY is now set to: " + (i + 1));
	                }
	            }
	        }
	    }
}
