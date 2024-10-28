package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;


public class Step_7Page extends CommonPageCICA{



	private By nextstep7	=	By.xpath("//h3[.='Provide Any Additional Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");	
	private By Disclosure	=	By.xpath("//h3[.='HIPAA Privacy Authorization']");
	private By remarks_1	=	By.xpath("//ion-input[@formcontrolname='Remarks']/input");
	private By remarks_1ErrorMsg = By.xpath("//ion-input[@formcontrolname='Remarks']/input/parent::ion-input/parent::ion-item/parent::ion-col");
	private By remarks_2	=	By.xpath("//ion-input[@formcontrolname='Remarks2']/input");
	private By remarks_2ErrorMsg = By.xpath("//ion-input[@formcontrolname='Remarks2']/input/parent::ion-input/parent::ion-item/parent::ion-col");
	

	public void Remarks() throws Exception {
		String remarks_MaxChar = "qwertyuiop asdfghjkl zxcvbnm poiuytrewq lkjhgfdsa mnbvcxz zxcvbnm lkjhgfdsa qwertyuiop poiuytrewq asdfghjkl";
		String remarks_MaxChar_Error = "The maximum number of characters is 90.";

		WebUI.waitForPageLoaded();
		WebUI.sleep(2);
		WebUI.waitForElementVisible(nextstep7);
		
//		WebUI.clearAndFillText(remarks_1, remarks_MaxChar);
//		WebUI.sleep(0.2);
//		WebUI.clearAndFillText(remarks_2, remarks_MaxChar);
//		WebUI.moveToElement(nextstep7);
//		WebUI.sleep(0.4);
//		WebUI.clickElement(nextstep7);
//		WebUI.sleep(0.5);
//		WebUI.verifyElementVisible(remarks_1ErrorMsg);
//		WebUI.verifyContains(getTextElement(remarks_1ErrorMsg), remarks_MaxChar_Error);
//		WebUI.verifyElementVisible(remarks_2ErrorMsg);
//		WebUI.verifyContains(getTextElement(remarks_2ErrorMsg), remarks_MaxChar_Error);
//		
//		WebUI.sleep(0.5);
//		WebUI.clearTextCtrlA(remarks_1);
//		WebUI.sleep(0.2);
//		WebUI.clearTextCtrlA(remarks_2);
//		WebUI.sleep(0.5);
		
		WebUI.moveToElement(nextstep7);
		WebUI.sleep(0.5);
		WebUI.clickElementWithJs(nextstep7);
		WebUI.waitForPageLoaded();
		WebUI.sleep(2);
	}


}
