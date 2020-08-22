package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	//Constructor:
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Encapsulation:
	private By emailId = By.id("username");
	private By pass = By.id("password");
	private By loginBtn= By.xpath("//i18n-string[@data-key = 'login.form.button']");
	private By loginHeader = By.xpath("//i18n-string[@data-key='login.signupLink.text']");	
	
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPass() {
		return getElement(pass);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public WebElement getLoginHeader() {
		return getElement(loginHeader);
	}

	
	public String getLoginPageTitile(){
		return getPageTitle();
	}
	
	public String getLoginPageHeader(){
		return getPageHeader(loginHeader);
	}
	
	//Overloading:
	
	public Homepage doLogin(String username, String password){
		getEmailId().sendKeys(username);;
		getPass().sendKeys(password);;
		getLoginBtn().click();
		
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return getInstance(Homepage.class);
	}
	
	public void doLogin(String username){
		getEmailId().sendKeys(username);
		getPass().sendKeys(" ");
		getLoginBtn().click();
	}
	
	public void doLogin(){
		getEmailId().sendKeys(" ");
		getPass().sendKeys(" ");
		getLoginBtn().click();
	}
}
