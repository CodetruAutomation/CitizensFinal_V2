package com.codetru.project.cica.pages.sanityApplicationModule;

import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;


public class Step_7PageHIPAA_NV extends CommonPageCICA{



	private By nextStepHIPAA = By.xpath("//h3[.='HIPAA Privacy Authorization']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");	
	private By ownerSignature = By.xpath("//h3[.='Authorization/Consent']/following-sibling::ion-row/ion-col/div/ion-button");
	private By consentSection = By.xpath("//h3[.='Authorization/Consent']");
	private By signatureDone = By.xpath("(//ion-col[@style='padding-right: 20px;']/ion-button)[1]");
	private By processing_Popup = By.xpath("//h2[contains(text(), 'Please stay on this page as we process this request.')]");

	public void HIPAA_Voice_Authorization() {
		
		WebUI.waitForPageLoaded();
		WebUI.sleep(1);
		WebUI.clickElementWithJs(ownerSignature);
		WebUI.sleep(2);
		ProjectUtilities.signature2();
		WebUI.clickElement(signatureDone);
		WebUI.sleep(1);
		
		
		WebUI.scrollToElementAtBottom(nextStepHIPAA);
		WebUI.sleep(1);
		WebUI.moveToElement(nextStepHIPAA);
		WebUI.clickElementWithJs(nextStepHIPAA);
		WebUI.sleep(1.5);
		
        try {
              for(int wt=1; wt<=30; wt++)
              {
              	if(DriverManager.getDriver().findElement(processing_Popup).isDisplayed())
              	{	
              		WebUI.sleep(1);
              	}
              	
              	if(wt==30)
              	{
              		Assert.fail();
              	}
              }
              
      } catch (Exception ex) {
          System.out.println("");
      }
		
		WebUI.sleep(1);
	}


}
