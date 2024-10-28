package com.codetru.project.cica.pages.regressionApplicationModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;


public class Step_9Page extends CommonPageCICA {
	
	private By applicationModule = By.id("applicationButton");	
	private By uploadApplicationGrt = By.xpath("//span[contains(text(),'Step 8: Upload Application')]");
	private By uploadApplication = By.xpath("//span[.='Step 10: Upload Application ']");
	private By applicationList = By.xpath("//div[@class='applicationDropdown']/div[1]");
	private By searchBox = By.xpath("(//input[@placeholder='Search' and @type='search'])[1]");
	private By actionsEditApplicationButton = By.xpath("//tbody/tr/td[10]/ion-button[1]");
	private By thumbsUpIcons = By.xpath("//ion-icon[@name='thumbs-up-outline']");
 
	public void Edit_Submit() {

		try {
			WebUI.waitForPageLoaded();
//			WebUI.clickElement(applicationModule);
//			WebUI.sleep(1.5);
//			WebUI.clickElement(applicationList);
//			WebUI.sleep(2.5);
//			WebUI.clearTextCtrlA(searchBox);
//			WebUI.sleep(0.5);
//			WebUI.setText(searchBox, ThreadLocalManager.getFirstName());
//			WebUI.sleep(2);
//			WebUI.clickElement(actionsEditApplicationButton);
			WebUI.sleep(3);

			try {
				DriverManager.getDriver().findElement(uploadApplicationGrt).isDisplayed();
				WebUI.clickElement(uploadApplicationGrt);
				WebUI.sleep(3);
				List<WebElement> thumbsUpIconsCount = WebUI.getWebElements(thumbsUpIcons);
				WebUI.verifyEquals(thumbsUpIconsCount.size(), 8);
				
			} catch (Exception exc) {
				WebUI.sleep(1);
				WebUI.clickElement(uploadApplication);
				WebUI.sleep(3);
				List<WebElement> thumbsUpIconsCount = WebUI.getWebElements(thumbsUpIcons);
				WebUI.verifyEquals(thumbsUpIconsCount.size(), 10);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		WebUI.sleep(1);


	}
    
}
