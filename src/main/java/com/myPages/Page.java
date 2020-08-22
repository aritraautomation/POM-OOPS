/**
 * 
 */
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author AritraS
 *
 */
public abstract class Page {
	
	WebDriver driver;
	Wait wait;
	
	Page(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,15);
	}
	
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass){
		try{
				return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}



}
