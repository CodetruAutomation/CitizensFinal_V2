package com.codetru.project.cica.pages.sanityApplicationModule;

import java.util.List;

import org.openqa.selenium.By;

import com.codetru.constants.FrameworkConstants;
import com.codetru.driver.DriverManager;
import com.codetru.helpers.ExcelHelpers;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;
import com.codetru.project.cica.utils.ThreadLocalManager;

public class Step_7PageHIPAA_NV2 extends CommonPageCICA {

    private By nextStepHIPAA = By.xpath("//h3[.='HIPAA Privacy Authorization']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");    
    private By ownerSignature = By.xpath("//h3[.='Authorization/Consent']/following-sibling::ion-row/ion-col/div/ion-button");
    private By consentSection = By.xpath("//h3[.='Authorization/Consent']");
    private By Padding_Right1 = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
    private By processing_Popup = By.xpath("//h2[contains(text(), 'Please stay on this page as we process this request.')]");

    public void HIPAA_Voice_Authorization(int rowNumber) throws Exception {
        
		 ExcelHelpers excel = new ExcelHelpers();
		 excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
        
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        WebUI.clickElementWithJs(ownerSignature);
        WebUI.sleep(2);
        ProjectUtilities.signature2();
        WebUI.clickElement(Padding_Right1);
        WebUI.sleep(1);
        
        WebUI.scrollToElementAtBottom(nextStepHIPAA);
        WebUI.sleep(1);
        WebUI.moveToElement(nextStepHIPAA);
        WebUI.clickElementWithJs(nextStepHIPAA);
        WebUI.sleep(1.5);
        
        try {
            for (int wt = 0; wt <= 30; wt++) {
            	
                if (DriverManager.getDriver().findElement(processing_Popup).isDisplayed()) {    
                    WebUI.sleep(1);
                }
                if(wt==30){
                	
                	int stateIndex = ThreadLocalManager.getLicStateIndex();
                	int countyIndex = ThreadLocalManager.getLicCountyIndex();
                	List<String> licensedStatesList = ThreadLocalManager.getLicenseStateList();
                	                    
                    WebUI.sleep(1);
                    getLoginPage_NV().loginSuccessWithAgentAccount(excel.getCellData(rowNumber, "userid"), excel.getCellData(rowNumber , "password"));
                    WebUI.sleep(3);
	                getHomePage_NV_All().HomePageNewApplication();
	                getStep_1Page_NV().Product_Information(licensedStatesList.get(stateIndex));
	                getStep_2Page_NV().Proposed_Insured_Information();
	                getStep_3Page_NV().Policy_Owner_Information();
	    			getStep_4Page_NV().Beneficiary_Information();
	    			getStep_5Page_NV().Existing_Insurance();
	    			getStep_6Page_NV().Predetermination_Questions();
	    			getStep_7PageHIPAA_NV2().HIPAA_Voice_Authorization(rowNumber);
//	    			getStep_7PageHIPAA_NV().HIPAA_Voice_Authorization();
	    			
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception in HIPAA_Voice_Authorization: " + ex.getMessage());
        }
        
        WebUI.sleep(1);
    }
    
    
}
