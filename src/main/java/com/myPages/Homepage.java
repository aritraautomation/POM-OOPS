/**
 * 
 */
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author AritraS
 *
 */
public class Homepage extends BasePage{

	Homepage(WebDriver driver) {
		super(driver);
	}
	
	private By homepageHeader = By.xpath("//i18n-string[contains(text(),'Setup Guide')]");
	/**
	 * @return the homepageHeader
	 */
	public WebElement getHomeHeader() {
		return getElement(homepageHeader);
	}

	public String getHomepageTitile(){
		return getPageTitle();
	}
	
	public String getHomepageHeader(){
		return getPageHeader(homepageHeader);
		//return getHomeHeader().getText();
	}

}
